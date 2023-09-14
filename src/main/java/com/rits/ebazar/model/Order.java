package com.rits.ebazar.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author rits
 * @created on 14/09/2023
 * @project ebazar
 */

@Data
@NoArgsConstructor
public class Order {
    private Long orderId;
    private Date date;
    private Customer customer;
    private List<OrderLine> orderLines = new ArrayList<>();
    private OrderState state;
    private Discount discount;

    public double getTotal() {
        return this.getOrderLines().stream()
                .mapToDouble(item -> item.getItem().getSalePrice() * item.getQuantity())
                .sum();
    }

    public int getTotalItems() {
        return this.getOrderLines().stream()
                .mapToInt(item -> item.getQuantity())
                .sum();
    }

    public void increaseDiscount(double increase) {
        if (discount == null) {
            discount = new Discount(0.0);
        }
        discount.setPercentage(discount.getPercentage() + increase);
    }

}

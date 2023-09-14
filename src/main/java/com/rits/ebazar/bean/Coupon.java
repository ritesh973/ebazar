package com.rits.ebazar.bean;

import com.rits.ebazar.model.Customer;
import com.rits.ebazar.model.Order;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author rits
 * @created on 14/09/2023
 * @project ebazar
 */

@Data
@NoArgsConstructor
public class Coupon {
    public enum CouponType {
        DISCOUNT, TWOFORONE, POINTS
    };

    private Customer customer;
    private Order order;
    private CouponType type;
    private Date validFrom;
    private Date validUntil;

    public Coupon(Customer customer, Order order, CouponType type) {
        this.customer = customer;
        this.order = order;
        this.type = type;
    }
}

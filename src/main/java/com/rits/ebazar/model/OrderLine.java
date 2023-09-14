package com.rits.ebazar.model;

import com.rits.ebazar.bean.Item;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author rits
 * @created on 14/09/2023
 * @project ebazar
 */
@Data
@NoArgsConstructor
public class OrderLine {
    private Item item;
    private Integer quantity;

    public OrderLine(Item item, Integer quantity) {
        this.item = item;
        this.quantity = quantity;
    }
}

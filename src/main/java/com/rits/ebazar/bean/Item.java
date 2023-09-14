package com.rits.ebazar.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author rits
 * @created on 14/09/2023
 * @project ebazar
 */
@Data
@NoArgsConstructor
public class Item {
    public enum Category {
        NA, LOW_RANGE, MID_RANGE, HIGH_RANGE, SPECIAL_MIDHIGH_RANGE
    }
    private Long id;
    private String name;
    private Double cost;
    private Double salePrice;
    private Category category;

    public Item(String name, Double cost, Double salePrice) {
        this(null, name, cost, salePrice);
    }

    public Item(Long id, String name, Double cost, Double salePrice) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.salePrice = salePrice;
        this.category = Category.NA;
    }
//    public Item(ItemData item) {
//        this.id = item.getId();
//        this.name = item.getName();
//        this.cost = item.getCost();
//        this.salePrice = item.getSalePrice();
//        this.category = item.getCategory();
//    }

}

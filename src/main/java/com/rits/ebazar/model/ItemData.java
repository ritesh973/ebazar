//package com.rits.ebazar.model;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.rits.ebazar.bean.Item;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//
///**
// * @author rits
// * @created on 14/09/2023
// * @project ebazar
// */
//@Entity
//@Table(name = "item")
//@Data
//@NoArgsConstructor
//public class ItemData {
//
//    @Id()
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @JsonIgnore
//    private Long id;
//
//    @Column
//    private String name;
//    @Column
//    private Double cost;
//    @Column
//    private Double salePrice;
//
//    @Column
//    @Enumerated(EnumType.STRING)
//    private Item.Category category;
//
//    public ItemData(Item item) {
//        this.name = item.getName();
//        this.cost = item.getCost();
//        this.salePrice = item.getSalePrice();
//        this.category = item.getCategory();
//    }
//}

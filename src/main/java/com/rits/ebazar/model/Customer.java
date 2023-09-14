package com.rits.ebazar.model;

import lombok.Data;

/**
 * @author rits
 * @created on 14/09/2023
 * @project ebazar
 */
@Data
public class Customer {
    public enum Category {
        NA, GOLD, SILVER, BRONZE
    };
    private static final long serialVersionUID = 1L;

    private Long customerId;
    private Integer age;
    private String name;
    private String email;
    private Category category = Category.NA;

}

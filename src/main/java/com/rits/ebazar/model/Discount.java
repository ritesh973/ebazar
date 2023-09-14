package com.rits.ebazar.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author rits
 * @created on 14/09/2023
 * @project ebazar
 */
@Data
@NoArgsConstructor
public class Discount {
    private Double percentage;

    public Discount(Double percentage) {
        this.percentage = percentage;
    }
}

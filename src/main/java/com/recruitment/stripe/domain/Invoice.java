package com.recruitment.stripe.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Invoice {
    private String id;
    private String customer;
    private String customerName;
    private Long amountRemaining;

    public Invoice(String customer) {
        this.customer = customer;
    }
}


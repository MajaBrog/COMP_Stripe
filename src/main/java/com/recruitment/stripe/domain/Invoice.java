package com.recruitment.stripe.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
public class Invoice {
    @NotNull
    private String id;
    @NotNull
    private String customer;
    @NotNull
    private String customerName;
    @Min(0L)
    private Long amountRemaining;

    public Invoice(String customer) {
        this.customer = customer;
    }
}


package com.recruitment.stripe.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class InvoiceDto {
    @JsonProperty("id")
    @NotNull
    private String id;
    @JsonProperty("customer")
    @NotNull
    private String customer;
    @JsonProperty("customer_name")
    @NotNull
    private String customerName;
    @JsonProperty("amount_remaining")
    @Min(0L)
    private Long amountRemaining;

    public InvoiceDto(String customer) {
        this.customer = customer;
    }
}

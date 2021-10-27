package com.recruitment.stripe.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class InvoiceDto {
    @JsonProperty("id")
    private String id;
    @JsonProperty("customer")
    private String customer;
    @JsonProperty("customer_name")
    private String customerName;
    @JsonProperty("amount_remaining")
    private Long amountRemaining;

    public InvoiceDto(String customer) {
        this.customer = customer;
    }
}

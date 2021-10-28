package com.recruitment.stripe.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class StripeConfig {
    @Value("${stripe.app.key}")
    private String stripeAppKey;
}

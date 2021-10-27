package com.recruitment.stripe.validator;

import com.recruitment.stripe.domain.Invoice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class StripeValidator {
    private static final Logger LOGGER = LoggerFactory.getLogger(StripeValidator.class);

    public void validateInvoice(final Invoice invoice) {
        if (invoice.getCustomerName().contains("test")) {
            LOGGER.info("Someone is testing my application!");
        } else {
            LOGGER.info("Seems that my application is used in proper way.");
        }
    }
}

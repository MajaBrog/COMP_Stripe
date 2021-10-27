package com.recruitment.stripe.client;

import com.recruitment.stripe.config.StripeConfig;
import com.recruitment.stripe.domain.InvoiceDto;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Invoice;
import com.stripe.param.InvoiceCreateParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StripeClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(StripeClient.class);

    @Autowired
    StripeConfig stripeConfig;

    public InvoiceDto getInvoice(String id) {
        try {
            Invoice invoice =
                    Invoice.retrieve(id);

            return new InvoiceDto(invoice.getId(), invoice.getCustomer(), invoice.getCustomerName(), invoice.getAmountRemaining());
        } catch (StripeException e) {
            LOGGER.error(e.getMessage(), e);
            return null;
        }
    }

    public void createInvoice(InvoiceDto invoiceDto) throws StripeException {
        Stripe.apiKey = stripeConfig.getStripeAppKey();

        InvoiceCreateParams invoiceParams =
                InvoiceCreateParams.builder()
                        .setCustomer(invoiceDto.getCustomer())
                        .setAutoAdvance(true) // Auto-finalize this draft after ~1 hour
                        .build();
        Invoice.create(invoiceParams);
    }
}

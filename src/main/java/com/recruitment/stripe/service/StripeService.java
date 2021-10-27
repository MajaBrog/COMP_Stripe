package com.recruitment.stripe.service;

import com.recruitment.stripe.client.StripeClient;
import com.recruitment.stripe.domain.InvoiceDto;
import com.stripe.exception.StripeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StripeService {
    @Autowired
    private StripeClient stripeClient;

    public InvoiceDto getInvoice(String id) {
        return stripeClient.getInvoice(id);
    }

    public void createInvoice(final InvoiceDto invoiceDto) throws StripeException {
        stripeClient.createInvoice(invoiceDto);
    }
}

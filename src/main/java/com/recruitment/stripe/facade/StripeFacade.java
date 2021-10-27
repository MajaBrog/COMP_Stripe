package com.recruitment.stripe.facade;

import com.recruitment.stripe.domain.Invoice;
import com.recruitment.stripe.domain.InvoiceDto;
import com.recruitment.stripe.mapper.StripeMapper;
import com.recruitment.stripe.service.StripeService;
import com.recruitment.stripe.validator.StripeValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StripeFacade {
    @Autowired
    private StripeService stripeService;

    @Autowired
    private StripeMapper stripeMapper;

    @Autowired
    private StripeValidator stripeValidator;

    public InvoiceDto getInvoice(String id) {
        InvoiceDto invoiceDto = stripeService.getInvoice(id);
        stripeValidator.validateInvoice(stripeMapper.mapToInvoice(invoiceDto));
        return invoiceDto;
    }

    public void createInvoice(final InvoiceDto invoiceDto) {
        Invoice invoice = stripeMapper.mapToInvoice(invoiceDto);
        stripeValidator.validateInvoice(invoice);
    }
}

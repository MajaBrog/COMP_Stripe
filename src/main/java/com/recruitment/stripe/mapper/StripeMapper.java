package com.recruitment.stripe.mapper;

import com.recruitment.stripe.domain.Invoice;
import com.recruitment.stripe.domain.InvoiceDto;
import org.springframework.stereotype.Component;

@Component
public class StripeMapper {

    public InvoiceDto mapToInvoiceDto(final Invoice invoice) {
        return new InvoiceDto(invoice.getId(), invoice.getCustomer(), invoice.getCustomerName(), invoice.getAmountRemaining());
    }

    public Invoice mapToInvoice(final InvoiceDto invoiceDto) {
        return new Invoice(invoiceDto.getCustomer());
    }
}

package com.recruitment.stripe.mapper;

import com.recruitment.stripe.domain.Invoice;
import com.recruitment.stripe.domain.InvoiceDto;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StripeMapperTest {

    @Test
    public void mapToInvoiceTest() {
        //Given
        StripeMapper stripeMapper = new StripeMapper();
        InvoiceDto invoiceDto = new InvoiceDto("customer");
        //When
        Invoice invoice = stripeMapper.mapToInvoice(invoiceDto);
        //Then
        assertEquals(invoiceDto.getId(), invoice.getId());
        assertEquals(invoiceDto.getCustomer(), invoice.getCustomer());
        assertEquals(invoiceDto.getCustomerName(), invoice.getCustomerName());
        assertEquals(invoiceDto.getAmountRemaining(), invoice.getAmountRemaining());
    }

    @Test
    public void mapToInvoiceDto() {
        //Given
        StripeMapper stripeMapper = new StripeMapper();
        Invoice invoice = new Invoice("id", "customer", "customer name", 200L);
        //When
        InvoiceDto invoiceDto = stripeMapper.mapToInvoiceDto(invoice);
        //Then
        assertEquals(invoice.getId(), invoiceDto.getId());
        assertEquals(invoice.getCustomer(), invoiceDto.getCustomer());
        assertEquals(invoice.getCustomerName(), invoiceDto.getCustomerName());
        assertEquals(invoice.getAmountRemaining(), invoiceDto.getAmountRemaining());
    }
}
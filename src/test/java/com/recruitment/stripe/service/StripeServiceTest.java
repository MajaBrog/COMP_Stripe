package com.recruitment.stripe.service;

import com.recruitment.stripe.client.StripeClient;
import com.recruitment.stripe.domain.InvoiceDto;
import com.stripe.exception.StripeException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class StripeServiceTest {
    @InjectMocks
    private StripeService stripeService;
    @Mock
    private StripeClient stripeClient;

    @Test
    public void shouldFetchInvoice() {
        //Given

        InvoiceDto invoiceDto = new InvoiceDto("id", "customer", "customer name", 200L);

        when(stripeClient.getInvoice("id")).thenReturn(invoiceDto);

        //When
        InvoiceDto fetchedInvoiceDto = stripeService.getInvoice("id");
        assertEquals("id", fetchedInvoiceDto.getId());
        assertEquals("customer", fetchedInvoiceDto.getCustomer());
        assertEquals("customer name", fetchedInvoiceDto.getCustomerName());
    }

    @Test
    public void shouldCreateInvoice() throws StripeException {
        //Given
        InvoiceDto invoiceDto = new InvoiceDto("cus_KTrmfQzLkaE9oX");
        //When
        stripeClient.createInvoice(invoiceDto);
        //Then
        Mockito.verify(stripeClient, times(1)).createInvoice(invoiceDto);
    }

}
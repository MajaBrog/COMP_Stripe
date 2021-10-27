package com.recruitment.stripe.facade;

import com.recruitment.stripe.domain.Invoice;
import com.recruitment.stripe.domain.InvoiceDto;
import com.recruitment.stripe.mapper.StripeMapper;
import com.recruitment.stripe.service.StripeService;
import com.recruitment.stripe.validator.StripeValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class StripeFacadeTest {
    @Spy
    @InjectMocks
    private StripeFacade stripeFacade;

    @Mock
    private StripeService stripeService;

    @Mock
    private StripeValidator stripeValidator;

    @Mock
    private StripeMapper stripeMapper;


    @Test
    public void fetchInvoices() {
        //Given
        InvoiceDto invoiceDto = new InvoiceDto("customer");

        Invoice mappedInvoice = new Invoice("customer");


        when(stripeService.getInvoice("id")).thenReturn(invoiceDto);
        when(stripeMapper.mapToInvoice(invoiceDto)).thenReturn(mappedInvoice);
        //When
        InvoiceDto fetchedInvoiceDto = stripeFacade.getInvoice("id");

        //Then
        assertNotNull(fetchedInvoiceDto);
    }

    @Test
    public void createInvoice() {
        //Given
        InvoiceDto invoiceDto = new InvoiceDto("customer");
        Invoice invoice = new Invoice("customer");

        when(stripeMapper.mapToInvoice(invoiceDto)).thenReturn(invoice);
        //When
        stripeFacade.createInvoice(invoiceDto);
        //Then
        Mockito.verify(stripeFacade, times(1)).createInvoice(invoiceDto);

    }
}
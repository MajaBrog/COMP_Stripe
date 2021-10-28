package com.recruitment.stripe.client;

import com.recruitment.stripe.config.StripeConfig;
import com.recruitment.stripe.domain.InvoiceDto;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Invoice;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class StripeClientTest {
    @InjectMocks
    private StripeClient stripeClient;

    @Mock
    Stripe stripe;
    @Mock
    private com.stripe.model.Invoice stripeInvoice;

    @Mock
    private StripeConfig stripeConfig;

    @Test
    public void shouldGetInvoice() throws StripeException {
        //Given
        InvoiceDto invoiceDto = new InvoiceDto("id", "customer", "customer name", 200L);
        when(Invoice.retrieve("id")).thenReturn(stripeInvoice);
        when(stripeConfig.getStripeAppKey()).thenReturn("pk_test_51Jot30Fmi6X6c4udaZFaraunyURDlk4JA7pN0V2EKk99js2XQdNulFEAyuzYy0YFis18ZIvNm0utmzMS6duarjL1007Zpk0grj");
        when(stripe.apiKey).thenReturn("pk_test_51Jot30Fmi6X6c4udaZFaraunyURDlk4JA7pN0V2EKk99js2XQdNulFEAyuzYy0YFis18ZIvNm0utmzMS6duarjL1007Zpk0grj");
        //When
        InvoiceDto fetchedInvoice = stripeClient.getInvoice("id");
        //Then
        assertEquals("id", fetchedInvoice.getId());
        assertEquals("customer", fetchedInvoice.getCustomer());
        assertEquals("customer name", fetchedInvoice.getCustomerName());

    }
}

package com.recruitment.stripe.validator;

import com.recruitment.stripe.domain.Invoice;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.times;


@RunWith(MockitoJUnitRunner.class)
public class StripeValidatorTest {

    @Mock
    StripeValidator stripeValidator;

    @Test
    public void shouldValidateInvoice() {
        //When
        Invoice invoice = new Invoice("Id", "customer", "test customer", 200L);
        //When & Then
        stripeValidator.validateInvoice(invoice);
        Mockito.verify(stripeValidator, times(1)).validateInvoice(invoice);
    }
}

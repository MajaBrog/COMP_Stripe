package com.recruitment.stripe.validator;

import com.recruitment.stripe.domain.Invoice;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class InvoiceValidationTest {
    private static ValidatorFactory validatorFactory;
    private static Validator validator;

    @BeforeClass
    public static void init() {
        validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    @Test
    public void shouldHaveNoViolations() {
        //Given
        Invoice invoice = new Invoice("id","customer","customer name",100L);

        //When
        Set<ConstraintViolation<Invoice>> violations
                = validator.validate(invoice);

        //Then
        assertTrue(violations.isEmpty());
    }

    @Test
    public void shouldDetectNullId() {
        //Given
        Invoice invoice = new Invoice(null,"customer","customer name",100L);

        //when:
        Set<ConstraintViolation<Invoice>> violations
                = validator.validate(invoice);

        //then:
        assertEquals(violations.size(), 1);

        ConstraintViolation<Invoice> violation
                = violations.iterator().next();

        assertEquals("id", violation.getPropertyPath().toString());
        assertEquals(null, violation.getInvalidValue());
    }

    @Test
    public void shouldDetectNullCustomer() {
        //Given
        Invoice invoice = new Invoice("id",null,"customer name",100L);

        //when:
        Set<ConstraintViolation<Invoice>> violations
                = validator.validate(invoice);

        //then:
        assertEquals(violations.size(), 1);

        ConstraintViolation<Invoice> violation
                = violations.iterator().next();

        assertEquals("customer", violation.getPropertyPath().toString());
        assertEquals(null, violation.getInvalidValue());
    }

    @Test
    public void shouldDetectNullCustomerName() {
        //Given
        Invoice invoice = new Invoice("id","customer", null,100L);

        //when:
        Set<ConstraintViolation<Invoice>> violations
                = validator.validate(invoice);

        //then:
        assertEquals(violations.size(), 1);

        ConstraintViolation<Invoice> violation
                = violations.iterator().next();

        assertEquals("customerName", violation.getPropertyPath().toString());
        assertEquals(null, violation.getInvalidValue());
    }

    @Test
    public void shouldDetectNegativeAmountRemaining() {
        //Given
        Invoice invoice = new Invoice("id","customer", "customer name",-100L);

        //when:
        Set<ConstraintViolation<Invoice>> violations
                = validator.validate(invoice);

        //then:
        assertEquals(violations.size(), 1);

        ConstraintViolation<Invoice> violation
                = violations.iterator().next();

        assertEquals("amountRemaining", violation.getPropertyPath().toString());
        assertEquals(-100L, violation.getInvalidValue());
    }
}

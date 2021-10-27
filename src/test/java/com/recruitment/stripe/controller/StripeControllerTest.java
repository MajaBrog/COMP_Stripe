package com.recruitment.stripe.controller;

import com.google.gson.Gson;
import com.recruitment.stripe.domain.InvoiceDto;
import com.recruitment.stripe.facade.StripeFacade;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(value = StripeController.class)
public class StripeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StripeFacade stripeFacade;

    @Test
    public void shouldGetInvoice() throws Exception {
        //Given
        InvoiceDto invoiceDto = new InvoiceDto("id", "customer", "customer name", 200L);

        when(stripeFacade.getInvoice("id")).thenReturn(invoiceDto);
        //When & Then
        mockMvc.perform(get("/v1/stripe/invoices/id").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is("id")))
                .andExpect(jsonPath("$.customer", is("customer")))
                .andExpect(jsonPath("$.customer_name", is("customer name")));

    }

    @Test
    public void createInvoice() throws Exception {
        //Given
        InvoiceDto invoiceDto = new InvoiceDto("id", "customer", "customer name", 200L);
        Gson gson = new Gson();

        String jsonContent = gson.toJson(invoiceDto);

        //When & Then
        mockMvc.perform(post("/v1/stripe/invoice").contentType(MediaType.APPLICATION_JSON_VALUE)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk());
    }
}
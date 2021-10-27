package com.recruitment.stripe.controller;

import com.recruitment.stripe.domain.InvoiceDto;
import com.recruitment.stripe.facade.StripeFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/stripe")
public class StripeController {

    @Autowired
    private StripeFacade stripeFacade;

    @RequestMapping(method = RequestMethod.GET, value = "/invoices/{id}")
    public InvoiceDto getInvoice(@PathVariable String id) {
        return stripeFacade.getInvoice(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/invoice")
    public void createInvoice(@RequestBody InvoiceDto invoiceDto) {
        stripeFacade.createInvoice(invoiceDto);
    }
}

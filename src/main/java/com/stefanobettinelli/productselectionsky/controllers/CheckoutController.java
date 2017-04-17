package com.stefanobettinelli.productselectionsky.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CheckoutController {

    private static final Logger Log = LoggerFactory.getLogger(CustomerLocationRequestController.class);

    //@Autowired
    //CheckoutService checkoutService;

    @RequestMapping(value = "/checkout")
    public String checkout(){
        return "checkout.html";
    }

}

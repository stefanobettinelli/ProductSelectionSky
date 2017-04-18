/**
 * Controller for the checkout page request
 */

package com.stefanobettinelli.productselectionsky.controllers;

import com.stefanobettinelli.productselectionsky.dao.StaticCatalogueDAO;
import com.stefanobettinelli.productselectionsky.dao.StaticCustomerDAO;
import com.stefanobettinelli.productselectionsky.model.Customer;
import com.stefanobettinelli.productselectionsky.model.IntegerSkyId;
import com.stefanobettinelli.productselectionsky.model.SelectedProductsJson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CheckoutController {

    private static final Logger Log = LoggerFactory.getLogger(CheckoutController.class);

    @PostMapping(value = "/checkout")
    public String checkout(@RequestBody SelectedProductsJson selectedProductsJson, Model model) {

        //get the customer
        Integer custId = Integer.parseInt(selectedProductsJson.getCustomerID());
        Customer customer = StaticCustomerDAO.getCustomerById(IntegerSkyId.getNewId(custId));

        //add all the selected products to the customer
        for (String productIdStr : selectedProductsJson.getSelectedProducts()) {
            customer.addProduct(StaticCatalogueDAO.getProductById( IntegerSkyId.getNewId(Integer.parseInt(productIdStr)) ));
        }

        //bind the selected products and the customer name to the model to render them in the checkout page
        List<String> productNames = new ArrayList<>();
        for (String productIdStr : selectedProductsJson.getSelectedProducts()) {
            String name = StaticCatalogueDAO.getProductById( IntegerSkyId.getNewId(Integer.parseInt(productIdStr))).getName();
            productNames.add(name);
        }
        model.addAttribute("username", customer.getName());
        model.addAttribute("products", productNames);

        Log.info("Doing checkout...");
        return "checkout";
    }

}

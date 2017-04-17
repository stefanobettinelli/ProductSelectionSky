package com.stefanobettinelli.productselectionsky.controllers;

import com.stefanobettinelli.productselectionsky.exceptions.CatalogueNotFoundException;
import com.stefanobettinelli.productselectionsky.exceptions.InvalidCatalogueIdException;
import com.stefanobettinelli.productselectionsky.exceptions.InvalidSkyIdException;
import com.stefanobettinelli.productselectionsky.model.Catalogue;
import com.stefanobettinelli.productselectionsky.model.IntegerSkyId;
import com.stefanobettinelli.productselectionsky.services.CatalogueRetrievalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CatalogueRequestController {

    private static final Logger Log = LoggerFactory.getLogger(CustomerLocationRequestController.class);

    @Autowired
    CatalogueRetrievalService catalogueRetrievalService;

    @RequestMapping(value = "/catalogue/{locationID}")
    public Catalogue getCatalogInLocation(@PathVariable String locationID) throws InvalidCatalogueIdException {

        Log.info("Request for location by customer with ID [{}]", locationID);

        Catalogue catalogue = null;

        try {
            catalogue = catalogueRetrievalService.getCatalogueByLocationId(IntegerSkyId.getNewId(Integer.valueOf(locationID)));
        } catch (NumberFormatException e) {
            throw new InvalidCatalogueIdException(String.format("Location id '%s' is not valid", locationID));
        } catch (CatalogueNotFoundException e) {
            e.printStackTrace();
        }

        return catalogue;
    }

    @RequestMapping(value = "/catalogue/complete")
    public Catalogue getCompleteCatalog() throws InvalidCatalogueIdException {

        Catalogue catalogue = null;

        try {
            catalogue = catalogueRetrievalService.getCompleteCatalogue();
        } catch (CatalogueNotFoundException e) {
            e.printStackTrace();
        }

        return catalogue;
    }

}

package com.stefanobettinelli.productselectionsky.controllers;

import com.stefanobettinelli.productselectionsky.exceptions.InvalidCustomerIdException;
import com.stefanobettinelli.productselectionsky.exceptions.LocationNotFoundException;
import com.stefanobettinelli.productselectionsky.model.IntegerSkyId;
import com.stefanobettinelli.productselectionsky.model.Location;
import com.stefanobettinelli.productselectionsky.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class CustomerLocationRequestController {

    private static final Logger Log = LoggerFactory.getLogger(CustomerLocationRequestController.class);

    @Autowired
    LocationService locationService;// TODO check this warining

    @RequestMapping(value = "/customer_locations/{customerID}")
    public Location getCustomerLocation(@PathVariable String customerID) throws InvalidCustomerIdException {

        Log.info("Request for location by customer with ID [{}]", customerID);

        Location loc = null;

        try {
            loc = locationService.getLocation(IntegerSkyId.getNewId(Integer.valueOf(customerID)));
        } catch (NumberFormatException e){
            throw new InvalidCustomerIdException(String.format("Customer id '%s' is not valid", customerID));
        } catch (LocationNotFoundException e) {
            e.printStackTrace();
        }

        return loc;
    }

}

package com.stefanobettinelli.productselectionsky.services;

import com.stefanobettinelli.productselectionsky.dao.StaticCustomerDAO;
import com.stefanobettinelli.productselectionsky.exceptions.LocationNotFoundException;
import com.stefanobettinelli.productselectionsky.model.Customer;
import com.stefanobettinelli.productselectionsky.model.IntegerSkyId;
import com.stefanobettinelli.productselectionsky.model.Location;
import com.stefanobettinelli.productselectionsky.model.SkyId;
import org.springframework.stereotype.Service;

@Service
public class StaticCustomerLocationService implements LocationService {
    @Override
    public Location getLocation(SkyId customerID) throws LocationNotFoundException {
        Customer customer = StaticCustomerDAO.getCustomerById(customerID);
        if (customer == null) return null;
        return customer.getLocation();
    }
}

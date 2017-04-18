package com.stefanobettinelli.productselectionsky.services;

import com.stefanobettinelli.productselectionsky.dao.StaticCustomerDAO;
import com.stefanobettinelli.productselectionsky.model.Customer;
import com.stefanobettinelli.productselectionsky.model.Location;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class StaticCustomerLocationServiceTest {

    private StaticCustomerLocationService staticCustomerLocationService;

    @Before
    public void setUp() {
        staticCustomerLocationService = new StaticCustomerLocationService();
    }

    @Test
    public void getLocation() throws Exception {
        List<Customer> custumers = StaticCustomerDAO.getCustomers();
        for (Customer customer : custumers) {
            Location location = staticCustomerLocationService.getLocation(customer.getID());
            assertNotNull(location);
            assertTrue((int) location.getId().getId() >= 0);
            assertTrue(location.getName() != null && !location.getName().isEmpty());
        }
    }

}
/**
 * Static container for Customers Data
 * most of the methods and properties are static to test real functionality
 * developer che implement enetityDAO to retrieve real data from DB or other sources for example
 */

package com.stefanobettinelli.productselectionsky.dao;

import com.stefanobettinelli.productselectionsky.model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StaticCustomerDAO implements entityDAO {

    public final static SkyId MARIO_ID = IntegerSkyId.getNewId(1);
    public final static SkyId LUIGI_ID = IntegerSkyId.getNewId(2);
    public final static SkyId ZELDA_ID = IntegerSkyId.getNewId(3);

    private final static Map<SkyId, Customer> CUSTOMER_MAP = new HashMap<>();

    static {
        Location londonLocation = StaticLocationDAO.getLocationById(StaticLocationDAO.LONDON_LOCATION_ID);
        Location liverpoolLocation = StaticLocationDAO.getLocationById(StaticLocationDAO.LIVERPOOL_LOCATION_ID);
        Customer mario = new SimpleCustomer("Mario", MARIO_ID, londonLocation);
        Customer luigi = new SimpleCustomer("Luigi", LUIGI_ID, londonLocation);
        Customer zelda = new SimpleCustomer("Zelda", ZELDA_ID, liverpoolLocation);
        CUSTOMER_MAP.putIfAbsent(mario.getID(), mario);
        CUSTOMER_MAP.putIfAbsent(luigi.getID(), luigi);
        CUSTOMER_MAP.putIfAbsent(zelda.getID(), zelda);
    }

    public static List<Customer> getCustomers() {
        return new ArrayList<>(CUSTOMER_MAP.values());
    }

    public static Customer getCustomerById(SkyId customerID) {
        return CUSTOMER_MAP.get(customerID);
    }

    @Override
    public List loadAll() {
        return null;
    }

    @Override
    public Object loadById(SkyId id) {
        return null;
    }
}

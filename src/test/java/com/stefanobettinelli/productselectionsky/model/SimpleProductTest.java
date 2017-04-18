package com.stefanobettinelli.productselectionsky.model;

import com.stefanobettinelli.productselectionsky.dao.StaticCategoryDAO;
import com.stefanobettinelli.productselectionsky.dao.StaticLocationDAO;
import com.stefanobettinelli.productselectionsky.exceptions.InvalidSkyIdException;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SimpleProductTest {

    private SimpleProduct simpleProductWithLocations;
    private SimpleProduct simpleProductNoLocations;

    @Before
    public void setUp() throws Exception, InvalidSkyIdException {
        Category sportCat = new SimpleCategory(StaticCategoryDAO.NEWS_CAT_ID, "Sports");
        List<Location> someLocations = new ArrayList<>();
        someLocations.add(new SimpleLocation(StaticLocationDAO.LONDON_LOCATION_ID, "London"));
        someLocations.add(new SimpleLocation(StaticLocationDAO.LIVERPOOL_LOCATION_ID, "Bristol"));
        simpleProductWithLocations = new SimpleProduct(IntegerSkyId.getNewId(1), "Tennis", sportCat, someLocations);
        simpleProductNoLocations = new SimpleProduct(IntegerSkyId.getNewId(2), "Soccer", sportCat);
    }

    @Test
    public void getProductID() throws Exception {
        SkyId<Integer> prodId = simpleProductWithLocations.getID();

    }

    @Test
    public void getAvailabilityLocations() throws Exception {
        assertEquals(2, simpleProductWithLocations.getAvailabilityLocations().size());
        assertEquals(0, simpleProductNoLocations.getAvailabilityLocations().size());
    }

    @Test
    public void getName() throws Exception {
        String name = simpleProductWithLocations.getName();
        assertTrue(name != null && !name.isEmpty());
        name = simpleProductNoLocations.getName();
        assertTrue(name != null && !name.isEmpty());
    }

    @Test
    public void getCategory() throws Exception {
        assertNotNull(simpleProductWithLocations.getCategory());
        assertNotNull(simpleProductNoLocations.getCategory());
    }

}
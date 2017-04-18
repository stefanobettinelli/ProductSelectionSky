package com.stefanobettinelli.productselectionsky.services;

import com.stefanobettinelli.productselectionsky.dao.StaticCatalogueDAO;
import com.stefanobettinelli.productselectionsky.dao.StaticCategoryDAO;
import com.stefanobettinelli.productselectionsky.dao.StaticLocationDAO;
import com.stefanobettinelli.productselectionsky.model.*;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class StaticCatalogueRetrievalServiceTest {

    private StaticCatalogueRetrievalService staticCatalogueRetrievalService;

    @Before
    public void setUp(){
        staticCatalogueRetrievalService = new StaticCatalogueRetrievalService();
    }

    @Test
    public void getCompleteCatalogue() throws Exception {
        Catalogue catalogue = staticCatalogueRetrievalService.getCompleteCatalogue();
        assertEquals(5, catalogue.getAllProducts().size());
        for (Product product : catalogue.getAllProducts()) {
            assertTrue((int) product.getID().getId() >= 0);
            if("Sports".equals(product.getCategory().getName())){
                assertTrue(product.getAvailabilityLocations().size() > 0);
            }
            assertNotNull(StaticCategoryDAO.getCategoryById(product.getCategory().getId()));
            assertTrue(product.getName() != null && !product.getName().isEmpty());
        }
    }

    @Test
    public void getCatalogueByLocationId() throws Exception {
        Catalogue londonCatalogue = staticCatalogueRetrievalService.getCatalogueByLocationId(StaticLocationDAO.LONDON_LOCATION_ID);
        assertEquals(4, londonCatalogue.getAllProducts().size());
        Catalogue livelpoolCatalogue = staticCatalogueRetrievalService.getCatalogueByLocationId(StaticLocationDAO.LIVERPOOL_LOCATION_ID);
        assertEquals(3, livelpoolCatalogue.getAllProducts().size());
    }

}
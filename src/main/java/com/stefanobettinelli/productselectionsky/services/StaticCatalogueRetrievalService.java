package com.stefanobettinelli.productselectionsky.services;

import com.stefanobettinelli.productselectionsky.dao.StaticCatalogueDAO;
import com.stefanobettinelli.productselectionsky.exceptions.CatalogueNotFoundException;
import com.stefanobettinelli.productselectionsky.model.Catalogue;
import com.stefanobettinelli.productselectionsky.model.SimpleCatalogue;
import com.stefanobettinelli.productselectionsky.model.SkyId;
import org.springframework.stereotype.Service;

@Service
public class StaticCatalogueRetrievalService implements CatalogueRetrievalService {
    @Override
    public Catalogue getCompleteCatalogue() throws CatalogueNotFoundException {
        return StaticCatalogueDAO.getCatalogue();
    }

    public Catalogue getCatalogueByLocationId(SkyId locationId) throws CatalogueNotFoundException {
        Catalogue catalogueForLocation = StaticCatalogueDAO.getCatalogueByLocation(locationId);
        return catalogueForLocation;
    }
}

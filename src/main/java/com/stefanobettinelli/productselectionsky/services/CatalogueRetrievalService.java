package com.stefanobettinelli.productselectionsky.services;

import com.stefanobettinelli.productselectionsky.exceptions.CatalogueNotFoundException;
import com.stefanobettinelli.productselectionsky.model.Catalogue;
import com.stefanobettinelli.productselectionsky.model.SkyId;

public interface CatalogueRetrievalService {
    public Catalogue getCompleteCatalogue() throws CatalogueNotFoundException;
    public Catalogue getCatalogueByLocationId(SkyId locationId) throws CatalogueNotFoundException;
}

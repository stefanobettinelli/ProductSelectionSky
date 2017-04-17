package com.stefanobettinelli.productselectionsky.model;

import java.util.List;

public class SimpleCatalogue implements Catalogue{

    private List<Product> products;

    public SimpleCatalogue(List<Product> products) {
        this.products = products;
    }

    @Override
    public List<Product> getAllProducts() {
        return products;
    }

    @Override
    public List<Product> getProductsByLocation(Location location) {
        return null;
    }

}

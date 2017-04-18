package com.stefanobettinelli.productselectionsky.model;

import java.util.List;
import java.util.Objects;

public class SimpleCatalogue implements Catalogue{

    private List<Product> products;

    public SimpleCatalogue(List<Product> products) {
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimpleCatalogue that = (SimpleCatalogue) o;
        return Objects.equals(products, that.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(products);
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

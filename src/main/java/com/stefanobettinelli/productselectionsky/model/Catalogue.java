package com.stefanobettinelli.productselectionsky.model;

import java.util.List;

/**
 * Created by Stefano on 15/04/2017.
 */
public interface Catalogue {
    public List<Product> getAllProducts();
    public List<Product> getProductsByLocation(Location location);
}

package com.stefanobettinelli.productselectionsky.model;

import java.util.List;
import java.util.Map;

/**
 * Customer abstract concept
 */
public interface Customer {
    SkyId getID();
    Location getLocation();
    Map<SkyId, Product> getSelectedProducts();
    List<Category> getCategoriesOfSelectedProducts();
    void addProduct(Product product);
    void addCollectionOfProductsById(List<SkyId> products);
    void removeProduct(Product product);
    String getName();
}

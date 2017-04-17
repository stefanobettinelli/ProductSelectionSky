package com.stefanobettinelli.productselectionsky.model;

import java.util.List;
import java.util.Map;

/**
 * Customer abstract concept
 */
public interface Customer {
    public SkyId getID();
    public Location getLocation();
    public Map<SkyId, Product> getSelectedProducts();
    public List<Category> getCategoriesOfSelectedProducts();
    public void addProduct(Product product);
    public void removeProduct(Product product);
    public void checkOut();
}

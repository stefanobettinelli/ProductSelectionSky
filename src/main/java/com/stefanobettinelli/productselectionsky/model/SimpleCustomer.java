package com.stefanobettinelli.productselectionsky.model;


import java.util.*;

public class SimpleCustomer implements Customer {

    private SkyId customerID;
    private Location location;
    private Map<SkyId, Product> selectedProducts;

    private String name;

    public SimpleCustomer(String name, SkyId customerID, Location location) {
        this(name, customerID, location, null);
        selectedProducts = new HashMap<>();
    }

    public SimpleCustomer(String name, SkyId customerID, Location location, Map<SkyId, Product> selectedProducts) {
        this.name = name;
        this.customerID = customerID;
        this.location = location;
        this.selectedProducts = selectedProducts;
    }

    @Override
    public void addProduct(Product product) {
        SkyId prodID = product.getID();
        selectedProducts.putIfAbsent(prodID, product);
    }

    @Override
    public void removeProduct(Product product) {
        selectedProducts.remove(product.getID());
    }

    @Override
    public void checkOut() {

    }

    private void updatePurchasedProducts() {

    }

    public SkyId getID() {
        return customerID;
    }

    public Location getLocation() {
        return location;
    }

    public Map<SkyId, Product> getSelectedProducts() {
        return selectedProducts;
    }

    @Override
    public List<Category> getCategoriesOfSelectedProducts() {
        Map<SkyId, Category> categoryMap = new HashMap<>();

        for (Map.Entry<SkyId, Product> entry : selectedProducts.entrySet())
        {
            Category cat = entry.getValue().getCategory();
            SkyId categoryId = cat.getId();
            categoryMap.putIfAbsent(categoryId, cat);
            System.out.println(entry.getKey() + "/" + entry.getValue());
        }

        return new ArrayList<>(categoryMap.values());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimpleCustomer that = (SimpleCustomer) o;
        return Objects.equals(customerID, that.customerID) &&
                Objects.equals(location, that.location) &&
                Objects.equals(selectedProducts, that.selectedProducts) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerID, location, selectedProducts, name);
    }

}

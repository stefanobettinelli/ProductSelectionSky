package com.stefanobettinelli.productselectionsky.model;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SimpleProduct implements Product {

    private SkyId productID;
    private String name;
    private Category category;
    private List<Location> availabilityLocations;//if size == 0 available in all locations

    public SimpleProduct(SkyId productID, String name, Category category, List<Location> availabilityLocations) {
        this.productID = productID;
        this.name = name;
        this.category = category;
        this.availabilityLocations = availabilityLocations;
    }

    public SimpleProduct(SkyId productID, String name, Category category) {
        this(productID, name, category, new ArrayList<>());
    }

    public SkyId getID() {
        return productID;
    }

    public List<Location> getAvailabilityLocations() {
        return availabilityLocations;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimpleProduct that = (SimpleProduct) o;
        return productID == that.productID &&
                category == that.category &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productID, name, category);
    }
}

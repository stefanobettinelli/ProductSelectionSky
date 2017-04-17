package com.stefanobettinelli.productselectionsky.model;

import java.util.List;

public interface Product {
    public String getName();
    public Category getCategory();
    public SkyId getID();
    public List<Location> getAvailabilityLocations();
}

package com.stefanobettinelli.productselectionsky.model;

import java.util.Objects;

public class SimpleLocation implements Location {

    private SkyId locationId;
    private String name;

    public SimpleLocation(SkyId locationId, String name) {
        this.locationId = locationId;
        this.name = name;
    }

    public SkyId getId() {
        return locationId;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimpleLocation that = (SimpleLocation) o;
        return Objects.equals(locationId, that.locationId) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(locationId, name);
    }
}

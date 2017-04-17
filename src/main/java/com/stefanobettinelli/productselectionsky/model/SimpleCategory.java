package com.stefanobettinelli.productselectionsky.model;

import java.util.Objects;

public class SimpleCategory implements Category {

    private SkyId id;

    private String name;

    public SimpleCategory(SkyId id, String name) {
        this.id = id;
        this.name = name;
    }

    public SkyId getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimpleCategory that = (SimpleCategory) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}

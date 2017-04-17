package com.stefanobettinelli.productselectionsky.model;

public interface SkyId<T> {
    public T getId();
    public boolean equals(Object o);
}

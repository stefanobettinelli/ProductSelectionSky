package com.stefanobettinelli.productselectionsky.dao;

import com.stefanobettinelli.productselectionsky.model.SkyId;

import java.util.List;

public interface entityDAO<T> {
    public List<T> loadAll();
    T loadById(SkyId id);
}

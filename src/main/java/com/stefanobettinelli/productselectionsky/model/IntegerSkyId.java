package com.stefanobettinelli.productselectionsky.model;

import com.stefanobettinelli.productselectionsky.controllers.CatalogueRequestController;
import com.stefanobettinelli.productselectionsky.exceptions.InvalidSkyIdException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public class IntegerSkyId implements SkyId<Integer> {

    private static final Logger Log = LoggerFactory.getLogger(IntegerSkyId.class);

    private Integer id;

    private IntegerSkyId(Integer id) throws InvalidSkyIdException {
        if (id < 0){
            throw new InvalidSkyIdException();
        }
        this.id = id;
    }

    public static IntegerSkyId getNewId(Integer id){
        IntegerSkyId integerSkyId = null;
        try {
            integerSkyId = new IntegerSkyId(id);
        } catch (InvalidSkyIdException e) {
            Log.error("Invalid sky id, must >= 0.", e);
            return null;
        }
        return integerSkyId;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntegerSkyId that = (IntegerSkyId) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

package com.stefanobettinelli.productselectionsky.model;

import com.stefanobettinelli.productselectionsky.exceptions.InvalidSkyIdException;

import java.util.Objects;

public class IntegerSkyId implements SkyId<Integer> {

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
            e.printStackTrace();
            return null; // TODO check this kind of stacktrace print
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

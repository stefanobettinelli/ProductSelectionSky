package com.stefanobettinelli.productselectionsky.model;

//the purpouse of this interface is to have a generic concept of the ID of the entity of the app that is being developer
//It uses generic type so that it can be adapted to future modification as well as extensions
//In the code base the ids are declared using this interface as static type, the usage of the interface makes the code
//resilient to the internal implementation of the concrete id class that implements SkyId (this one (: )
public interface SkyId<T> {
    public T getId();
    public boolean equals(Object o);
}

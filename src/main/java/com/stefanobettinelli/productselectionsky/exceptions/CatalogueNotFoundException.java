package com.stefanobettinelli.productselectionsky.exceptions;

public class CatalogueNotFoundException extends Exception {
    public CatalogueNotFoundException(String format) {
        super(format);
    }
}

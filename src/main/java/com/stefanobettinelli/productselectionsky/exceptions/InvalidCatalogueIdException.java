package com.stefanobettinelli.productselectionsky.exceptions;

public class InvalidCatalogueIdException extends Exception {
    public InvalidCatalogueIdException(String format) {
        super(format);
    }
}

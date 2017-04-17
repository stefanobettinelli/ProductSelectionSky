package com.stefanobettinelli.productselectionsky.exceptions;

public class InvalidCustomerIdException extends Exception {
    public InvalidCustomerIdException(String format) {
        super(format);
    }
}

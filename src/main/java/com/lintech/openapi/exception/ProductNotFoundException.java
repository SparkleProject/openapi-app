package com.lintech.openapi.exception;

public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException(String exception){
        super(exception);
    }
}

package com.app.salesinventory.exception;

public class TypeIdNotFoundException extends RuntimeException{
    public TypeIdNotFoundException(String message){
        super(message);
    }
}

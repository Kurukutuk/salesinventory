package com.app.salesinventory.exception;

public class StockNotFoundException extends RuntimeException{
    public StockNotFoundException(String message){
        super(message);
    }
}

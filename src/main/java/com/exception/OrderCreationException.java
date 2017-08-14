package com.exception;

/**
 * Created by ashis on 8/13/2017.
 */
public class OrderCreationException extends Exception {
    public OrderCreationException(){

    }
    public OrderCreationException(String message) {
        super (message);
    }

    public OrderCreationException(Throwable cause) {
        super (cause);
    }

    public OrderCreationException(String message, Throwable cause) {
        super (message, cause);
    }
}

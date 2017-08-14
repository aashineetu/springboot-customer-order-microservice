package com.exception;

/**
 * Created by ashis on 8/13/2017.
 */
public class CustomerOrderException extends Exception {
    public CustomerOrderException(){

    }
    public CustomerOrderException (String message) {
        super (message);
    }

    public CustomerOrderException (Throwable cause) {
        super (cause);
    }

    public CustomerOrderException (String message, Throwable cause) {
        super (message, cause);
    }
}

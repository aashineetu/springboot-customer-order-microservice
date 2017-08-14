package com.entity;

/**
 * Created by ashis on 8/13/2017.
 */
public class Status {

    private String code;

    private String message;

    public Status()
    {

    }

    public Status(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

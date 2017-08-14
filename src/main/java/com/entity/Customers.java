package com.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by ashis on 8/10/2017.
 */

import java.util.HashMap;
import java.util.Map;

public class Customers {

    private Integer id;
    private String name;


    /**
     * No args constructor for use in serialization
     *
     */
    public Customers() {
    }

    /**
     *
     * @param id
     * @param name
     */
    public Customers(Integer id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
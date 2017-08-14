package com.entity;

/**
 * Created by ashis on 8/11/2017.
 */
import java.util.HashMap;
import java.util.Map;

public class Supplier {

    private Integer id;
    private String name;


    /**
     * No args constructor for use in serialization
     *
     */
    public Supplier() {
    }

    /**
     *
     * @param id
     * @param name
     */
    public Supplier(Integer id, String name) {
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

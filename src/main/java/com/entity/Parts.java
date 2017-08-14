package com.entity;

/**
 * Created by ashis on 8/11/2017.
 */

public class Parts {
    private Integer id;
    private Supplier supplier;
    private String name;
    private String description;
    private String price;
    private Integer quantity;


    /**
     * No args constructor for use in serialization
     *
     */
    public Parts() {
    }

    /**
     *
     * @param id
     * @param price
     * @param description
     * @param name
     * @param quantity
     * @param supplier
     */
    public Parts(Integer id, Supplier supplier, String name, String description, String price, Integer quantity) {
        super();
        this.id = id;
        this.supplier = supplier;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }



}
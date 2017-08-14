package com.responsewrappers;

import com.entity.Customers;
import com.entity.Orders;
import com.entity.Parts;
import java.util.Map;
import java.util.HashMap;

import java.util.List;

/**
 * Created by ashish1.negi on 10/30/2015.
 */

public class CustomerOrderResponseWrapper {

    private Customers customers;
    private List<Parts> parts = null;
    private Integer id;
    private String orderDate;


    public CustomerOrderResponseWrapper() {
    }

    /**
     *
     * @param id
     * @param orderDate
     * @param parts
     * @param customers
     */
    public CustomerOrderResponseWrapper(Customers customers, List<Parts> parts, Integer id, String orderDate) {
        super();
        this.customers = customers;
        this.parts = parts;
        this.id = id;
        this.orderDate = orderDate;
    }

    public Customers getCustomers() {
        return customers;
    }

    public void setCustomers(Customers customers) {
        this.customers = customers;
    }

    public List<Parts> getParts() {
        return parts;
    }

    public void setParts(List<Parts> parts) {
        this.parts = parts;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }


}
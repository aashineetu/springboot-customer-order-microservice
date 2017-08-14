package com.requetwrappers;

import com.entity.Customers;
import com.entity.Parts;

import java.util.List;

/**
 * Created by ashish1.negi on 10/30/2015.
 */
public class CreateOrderRequestWrapper {

    private Customers customers;
    private List<Parts> parts = null;



    public CreateOrderRequestWrapper() {
    }

    /**
     *
     * @param parts
     * @param customers
     */
    public CreateOrderRequestWrapper(Customers customers, List<Parts> parts) {
        super();
        this.customers = customers;
        this.parts = parts;

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

}
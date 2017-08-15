package com.requetwrappers;

import com.entity.Customers;
import com.entity.Parts;

import java.util.List;


/**
 * Created by ashis on 8/12/2017.
 */

public class CreateOrderResponseWrapper {

    private Customers customers;
    private List<Parts> parts = null;



    public CreateOrderResponseWrapper() {
    }

    /**
     *
     * @param parts
     * @param customers
     */
    public CreateOrderResponseWrapper(Customers customers, List<Parts> parts) {
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
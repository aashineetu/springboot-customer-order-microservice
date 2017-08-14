package com.entity;

import org.springframework.stereotype.Component;

/**
 * Created by ashis on 8/12/2017.
 */

public class Orders {
    int orderID;
    String orderDate;

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public Orders()
    {

    }

    public Orders(int orderID, String orderDate) {
        this.orderID = orderID;
        this.orderDate = orderDate;
    }
}

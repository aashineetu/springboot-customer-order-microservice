package com.dao;

import com.exception.CustomerOrderException;
import com.exception.OrderCreationException;
import com.requetwrappers.CreateOrderRequestWrapper;
import com.requetwrappers.CreateOrderResponseWrapper;
import com.responsewrappers.CustomerOrderResponseWrapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by ashis on 8/12/2017.
 */

public interface OrderDao {

    List<CustomerOrderResponseWrapper> getOrders(Integer numOfRec, List<Integer> partNumbers) throws CustomerOrderException;
    CreateOrderResponseWrapper createCustomerOrder(CreateOrderRequestWrapper createOrderRequestWrapper) throws OrderCreationException;
}

package com.serviceimpl;

import com.dao.OrderDao;
import com.entity.Customers;
import com.entity.Orders;
import com.entity.Parts;
import com.entity.Supplier;
import com.exception.CustomerOrderException;
import com.exception.OrderCreationException;
import com.requetwrappers.CreateOrderRequestWrapper;
import com.responsewrappers.CustomerOrderResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by ashis on 4/1/2017.
 */


@Service
public class CustomerOrderService {

    @Autowired
    private OrderDao orderDao;

    public List<CustomerOrderResponseWrapper> getOrderResponse(Integer numOfRec, List<Integer> partNumbers) throws CustomerOrderException{
//       List<CustomerOrderResponseWrapper> orderResponseList= new ArrayList<CustomerOrderResponseWrapper>();
//        CustomerOrderResponseWrapper customerOrderResponseWrapper = new CustomerOrderResponseWrapper();
//        customerOrderResponseWrapper.setId(1111);
//        customerOrderResponseWrapper.setOrderDate("8/12/2017");
//
//        Customers customers = new Customers();
//        customers.setId(1);
//        customers.setName("ashish");
//        customerOrderResponseWrapper.setCustomers(customers);
//
//        List<Parts> partsList = new ArrayList<Parts>();
//        Parts parts = new Parts();
//        parts.setId(111);
//        parts.setName("RAM");
//        parts.setDescription("RAM for laptop");
//        parts.setQuantity(4);
//        Supplier supplier = new Supplier();
//        supplier.setId(11);
//        supplier.setName("ABC Electronic");
//        parts.setSupplier(supplier);
//        partsList.add(parts);
//        customerOrderResponseWrapper.setParts(partsList);
//        orderResponseList.add(customerOrderResponseWrapper);


        return orderDao.getOrders(numOfRec, partNumbers);
    }

    public CustomerOrderResponseWrapper createCustomerOrder(CreateOrderRequestWrapper createOrderRequestWrapper) throws OrderCreationException{
        //todo , need to create a method in dao and insert into database
        return orderDao.createCustomerOrder(createOrderRequestWrapper);
    }
}

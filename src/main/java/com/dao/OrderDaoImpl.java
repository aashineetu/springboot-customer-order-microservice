package com.dao;

import com.entity.Customers;
import com.entity.Parts;
import com.entity.Supplier;
import com.exception.CustomerOrderException;
import com.exception.OrderCreationException;
import com.requetwrappers.CreateOrderRequestWrapper;
import com.responsewrappers.CustomerOrderResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.time.LocalDateTime;
import java.util.*;


@Repository
public class OrderDaoImpl implements OrderDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<CustomerOrderResponseWrapper> getOrders(Integer numOfRec, List<Integer> partNumbers) throws CustomerOrderException {

        System.out.println("Inside getOrders ");
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("partNumbers", partNumbers);
        parameters.addValue("numOfRec", numOfRec);

        List<CustomerOrderResponseWrapper> orderResponseList = new ArrayList<CustomerOrderResponseWrapper>();
        CustomerOrderResponseWrapper wrapper = null;
        try {
            SqlRowSet rowSet = namedParameterJdbcTemplate.queryForRowSet(QueryConstant.GET_ORDERS, parameters);

            Map<Integer, String> orderMap = new HashMap<>();

            while (rowSet.next()) {
                wrapper = new CustomerOrderResponseWrapper();
                int customerId = rowSet.getInt("Customer_I");
                String customerName = rowSet.getString("Customer_Name");
                int orderId = rowSet.getInt("Order_ID");
                int partId = rowSet.getInt("Part_ID");
                String partName = rowSet.getString("Part_Name");
                String partDesc = rowSet.getString("Part_Description");
                int partPrice = rowSet.getInt("Part_Price");
                int supplierId = rowSet.getInt("Supplier_ID");
                String supplierName = rowSet.getString("Supplier_Name");
                int orderQuantity = rowSet.getInt("Order_Quantity");

                System.out.println("orderDetails: " + customerId);
                System.out.println("orderDetails: " + orderId);
                System.out.println("orderDetails: " + orderId);

                wrapper.setId(orderId);
                //TODO: orderDate should come from database
                wrapper.setOrderDate(LocalDateTime.now().toString());
                wrapper.setCustomers(new Customers(customerId, customerName));

                List<Parts> partsList = new ArrayList<Parts>();
                Parts parts = new Parts();
                parts.setId(partId);
                parts.setName(partName);
                parts.setDescription(partDesc);
                parts.setQuantity(1); // TODO
                Supplier supplier = new Supplier();
                supplier.setId(supplierId);
                supplier.setName(supplierName);
                parts.setSupplier(supplier);
                partsList.add(parts);
                wrapper.setParts(partsList);
                orderResponseList.add(wrapper);
            }
        } catch (Exception e) {
            System.out.println(e);//implement logger(sl4j) instead of console print-- todo

            throw new CustomerOrderException(e);

        }

        return orderResponseList;
    }

    /*
    to do for insert statement, we have to insert data only in transactional tables i.e ORDERS and ORDERS_PARTS_XREF,
     master tables data manage by admin ie, customers, suppliers and parts
     */
    //todo- currently working for one element of array, need make a loop and have to use batch update if multiple
    public CustomerOrderResponseWrapper createCustomerOrder(CreateOrderRequestWrapper createOrderRequestWrapper) throws OrderCreationException {
        List<Parts> parts = createOrderRequestWrapper.getParts();
        Parts part = parts.get(0);

        long randonNumber = generateRandom(6);
        int orderRow = 0;
        int orderRefRow = 0;
        try {
            //Insert into ASHISH.ORDERS (ORDER_ID,CUSTOMER_ID,ORDER_DATE) values (:orderID, :customerID, :data)
            Map<String, Object> orderParameters = new HashMap<String, Object>();
            orderParameters.put("orderID", randonNumber);
            orderParameters.put("customerID", createOrderRequestWrapper.getCustomers().getId());
            orderParameters.put("data", new Date());
            orderRow = namedParameterJdbcTemplate.update(QueryConstant.CREATE_ORDER[0], orderParameters);
        } catch (Exception e) {

            System.out.println(e);//implement logger(sl4j) instead of console print-- todo
            throw new OrderCreationException(e);
        }
        try {
            //insert into ORDERS_PARTS_XREF if order transaction successful
            if (orderRow >= 1) {
                //Insert into ASHISH.ORDERS_PARTS_XREF (ORDER_ID,PART_ID,ORDER_QUANTITY) values (:orderID,:partID,:quantity)
                Map<String, Object> orderRefParemeter = new HashMap<String, Object>();
                orderRefParemeter.put("orderID", randonNumber);
                orderRefParemeter.put("partID", part.getId());
                orderRefParemeter.put("quantity", part.getQuantity());
                orderRefRow = namedParameterJdbcTemplate.update(QueryConstant.CREATE_ORDER[1], orderRefParemeter);
            }
        } catch (Exception e) {
            System.out.println(e);//implement logger(sl4j) instead of console print-- todo
            throw new OrderCreationException("hello we got exception");
        }

        if (orderRefRow <= 0) {

            // need to implement transaction roll back logic from order table and throw the exception to controller if insert failed from ORDERS_PARTS_XREF table

        }
        //TODO need map customer and parts from input request plus orderId and orderDate
        return new CustomerOrderResponseWrapper();
    }

    public static long generateRandom(int length) {
        Random random = new Random();
        char[] digits = new char[length];
        digits[0] = (char) (random.nextInt(9) + '1');
        for (int i = 1; i < length; i++) {
            digits[i] = (char) (random.nextInt(10) + '0');
        }
        return Long.parseLong(new String(digits));
    }

}

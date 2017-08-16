package test.tdd;
import com.dao.OrderDao;
import com.entity.Customers;
import com.entity.Parts;
import com.entity.Supplier;
import com.exception.CustomerOrderException;
import com.requetwrappers.CreateOrderResponseWrapper;
import com.responsewrappers.CustomerOrderResponseWrapper;
import com.serviceimpl.CustomerOrderService;
import static org.mockito.Mockito.*;
import static junit.framework.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;



import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

/**
 * Created by ashis on 8/15/2017.
 */

public class CustomerOrderServiceMockTest {
    private CustomerOrderService service;
    private OrderDao dao;

    @Before
    public void setup() {
        service = new CustomerOrderService();
        dao = mock(OrderDao.class);
    }
    @Test
    public void testRetriveOrder() throws CustomerOrderException {
        List<CustomerOrderResponseWrapper> orderResponseList= new ArrayList<CustomerOrderResponseWrapper>();
        CustomerOrderResponseWrapper customerOrderResponseWrapper = new CustomerOrderResponseWrapper();
        Customers customers = new Customers();
        customers.setId(1);
        customers.setName("Ashish");
        customerOrderResponseWrapper.setCustomers(customers);
        List<Parts> partsList = new ArrayList<Parts>();
        Parts custParts = new Parts();
        custParts.setId(1111);
        custParts.setName("RAM");
        custParts.setDescription("RAM for compute");
        custParts.setQuantity(4);
        Supplier supplier = new Supplier();
        supplier.setId(111111);
        supplier.setName("ABC electrinic");
        custParts.setSupplier(supplier);
        partsList.add(custParts);
        customerOrderResponseWrapper.setParts(partsList);
        orderResponseList.add(customerOrderResponseWrapper);
        Integer numOfRec=5;
        List<Integer> partNumbers= Arrays.asList(1111,2222);

        when(dao.getOrders(numOfRec,partNumbers)).thenReturn(orderResponseList);

//        //call the main method we want to test
//        List<CustomerOrderResponseWrapper>  customerOrderResponseList = service.getOrderResponse(numOfRec,partNumbers);
        //verify the method was called
        verify(dao).getOrders(numOfRec,partNumbers);
    }

    @Test
    public void testCreateOrder() throws CustomerOrderException {
        //todo- need to mock dao and set dummy data to test insert operation
    }
}
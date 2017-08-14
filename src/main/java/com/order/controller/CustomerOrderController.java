package com.order.controller;

import com.entity.Customers;
import com.exception.CustomerOrderException;
import com.requetwrappers.CreateOrderRequestWrapper;
import com.responsewrappers.CustomerOrderResponseWrapper;
import com.serviceimpl.CustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

import java.util.Arrays;
import java.util.List;


@RestController
@Api(value = "/", description = "Controller for customer order")
public class CustomerOrderController {

    @Autowired
    CustomerOrderService customerOrderService;

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success - record found"),
            @ApiResponse(code = 404, message = "Unable to find record"),
            @ApiResponse(code = 500, message = "Internal Server error")})
    @ApiOperation(value = "Customer Order", produces = "application/json",
            response = ResponseEntity.class, httpMethod = "GET")
    @RequestMapping(method = RequestMethod.GET, value = "/orders",
            produces = "application/json")
    public ResponseEntity<List<Object>> getOrderResponse(
            @RequestParam(value = "limit") Integer limit,
            @RequestParam(value = "parts") List<Integer> parts
    ) throws Exception{
        List<CustomerOrderResponseWrapper> customerOrderResponseWrapperList = null;

        customerOrderResponseWrapperList = customerOrderService.getOrderResponse(limit, parts);

        if (CollectionUtils.isEmpty(customerOrderResponseWrapperList)) {
            return new ResponseEntity(Arrays.asList("No orders found given a filter."), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(customerOrderResponseWrapperList, HttpStatus.OK);
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success - record found"),
            @ApiResponse(code = 404, message = "Unable to find record"),
            @ApiResponse(code = 500, message = "Internal Server error")})
    @ApiOperation(value = "create order", produces = "application/json",
            consumes = "application/json", response = ResponseEntity.class)


    @RequestMapping(method = RequestMethod.POST, value = "/orders",
            consumes = "application/json", produces = "application/json")

    public ResponseEntity<Object> createCustomerOrder(
            @RequestBody CreateOrderRequestWrapper createOrderRequestWrapper) throws Exception {
        CustomerOrderResponseWrapper customerOrderResponseWrapper = null;

        customerOrderResponseWrapper = customerOrderService.createCustomerOrder(createOrderRequestWrapper);

        return new ResponseEntity(customerOrderResponseWrapper, HttpStatus.CREATED);
    }
}
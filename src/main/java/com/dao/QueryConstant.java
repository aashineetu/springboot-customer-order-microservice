package com.dao;

/**
 * Created by ashis on 8/12/2017.
 */
public class QueryConstant {

    public static final String GET_ORDERS =  "\n" +
            "select  customers.customer_id as \"Customer_ID\", customers.name as \"Customer_Name\",\n" +
            "orders.order_id as \"Order_ID\" ,\n" +
            "parts.part_id as \"Part_ID\", parts.name as \"Part_Name\", parts.DESCRIPTION as \"Part_Description\",parts.price as \"Part_Price\",\n" +
            "suppliers.supplier_id as \"Supplier_ID\", suppliers.name as \"Supplier_Name\",\n" +
            "ORDERS_PARTS_XREF.ORDER_QUANTITY as \"Order_Quantity\"\n" +
            "from orders,ORDERS_PARTS_XREF,customers,SUPPLIERS,parts\n" +
            "where orders.order_id = ORDERS_PARTS_XREF.order_id(+) AND\n" +
            "CUSTOMERS.CUSTOMER_ID=ORDERS.CUSTOMER_ID AND\n" +
            "ORDERS_PARTS_XREF.part_id IN (:partNumbers) and\n" +
            "suppliers.supplier_id=parts.supplier_id and \n" +
            "ORDERS_PARTS_XREF.part_id=parts.part_id AND rownum <= :numOfRec";
    public static final String[] CREATE_ORDER={"Insert into ASHISH.ORDERS (ORDER_ID,CUSTOMER_ID,ORDER_DATE) values (:orderID, :customerID, :data)",
            "Insert into ASHISH.ORDERS_PARTS_XREF (ORDER_ID,PART_ID,ORDER_QUANTITY) values (:orderID,:partID,:quantity)"
            };

}

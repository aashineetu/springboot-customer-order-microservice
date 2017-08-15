package com.entity;

import org.springframework.stereotype.Component;

/**
 * Created by ashis on 8/12/2017.
 */
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;


@Data
@ToString(includeFieldNames = true)
@EqualsAndHashCode(callSuper = false)
public class Orders {
    int orderID;
    String orderDate;
}

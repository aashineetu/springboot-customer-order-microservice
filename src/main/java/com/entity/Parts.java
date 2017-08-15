package com.entity;

/**
 * Created by ashis on 8/12/2017.
 */

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;


@Data
@ToString(includeFieldNames = true)
@EqualsAndHashCode(callSuper = false)
public class Parts {
    private Integer id;
    private Supplier supplier;
    private String name;
    private String description;
    private String price;
    private Integer quantity;

}
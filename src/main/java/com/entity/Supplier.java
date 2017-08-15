package com.entity;

/**
 * Created by ashis on 8/11/2017.
 */
import java.util.HashMap;
import java.util.Map;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;


@Data
@ToString(includeFieldNames = true)
@EqualsAndHashCode(callSuper = false)

public class Supplier {

    private Integer id;
    private String name;

}

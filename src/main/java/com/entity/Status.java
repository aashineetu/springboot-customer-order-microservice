package com.entity;

/**
 * Created by ashis on 8/13/2017.
 */
import lombok.*;


@Data
@ToString(includeFieldNames = true)
@EqualsAndHashCode(callSuper = false)
@RequiredArgsConstructor
@AllArgsConstructor
public class Status {

    private String code;

    private String message;

}

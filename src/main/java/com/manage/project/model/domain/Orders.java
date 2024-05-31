package com.manage.project.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * @TableName orders
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orders implements Serializable {
    /**
     * 
     */
    private Integer ordersId;

    /**
     * 
     */
    private Date ordersTime;

    /**
     * 
     */
    private BigDecimal ordersPrice;

    /**
     * 
     */
    private Integer userId;

    /**
     * 
     */
    private Integer menuId;

    private static final long serialVersionUID = 1L;
}
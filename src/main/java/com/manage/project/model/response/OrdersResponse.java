package com.manage.project.model.response;

import com.fasterxml.jackson.annotation.JsonFormat;
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
public class OrdersResponse implements Serializable {
    /**
     * 
     */
    private Integer ordersId;

    /**
     * 
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date ordersTime;

    /**
     * 
     */
    private BigDecimal ordersPrice;

    /**
     * 
     */
    private String menuName;

    /**
     * 
     */
    private String username;

    private static final long serialVersionUID = 1L;

}
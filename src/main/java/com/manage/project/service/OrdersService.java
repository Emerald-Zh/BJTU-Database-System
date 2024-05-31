package com.manage.project.service;

import com.manage.project.model.domain.Orders;
import com.manage.project.model.response.OrdersResponse;

import java.util.List;

public interface OrdersService {

    int deleteByPrimaryKey(Long id);

    int insert(Orders record);

    int insertSelective(Orders record);

    List<OrdersResponse> selectAllOrders();

    Orders selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Orders record);

    int updateByPrimaryKey(Orders record);

}
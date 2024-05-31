package com.manage.project.service.impl;

import com.manage.project.mapper.MenuMapper;
import com.manage.project.mapper.OrdersMapper;
import com.manage.project.model.domain.Menu;
import com.manage.project.model.domain.Orders;
import com.manage.project.model.response.OrdersResponse;
import com.manage.project.service.OrdersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService {
    @Resource
    private OrdersMapper ordersMapper;
    @Resource
    private MenuMapper menuMapper;
    @Override
    public int deleteByPrimaryKey(Long id) {
        return ordersMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Orders record) {
        // todo 加入计算用户总金额功能
        Menu menu = menuMapper.selectByPrimaryKey(Long.valueOf(record.getMenuId()));
        record.setOrdersPrice(menu.getMenuPrice());
        return ordersMapper.insertSelective(record);
    }

    @Override
    public int insertSelective(Orders record) {
        return ordersMapper.insertSelective(record);
    }

    @Override
    public Orders selectByPrimaryKey(Long id) {
        return null;
    }

    @Override
    public List<OrdersResponse> selectAllOrders(){
        return ordersMapper.selectAllOrders();
    }
    @Override
    public int updateByPrimaryKeySelective(Orders record) {
        Orders orders = ordersMapper.selectByPrimaryKey(Long.valueOf(record.getOrdersId()));
        Menu menu = menuMapper.selectByPrimaryKey(Long.valueOf(record.getMenuId()));
        record.setOrdersPrice(menu.getMenuPrice());
        if (orders.getUserId().equals(record.getUserId())){
            return ordersMapper.updateByPrimaryKeySelective(record);
        }
        return -1;
    }

    @Override
    public int updateByPrimaryKey(Orders record) {
        return 0;
    }
}

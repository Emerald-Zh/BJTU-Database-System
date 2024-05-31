package com.manage.project.controller;

import cn.hutool.db.sql.Order;
import com.manage.project.model.domain.Orders;
import com.manage.project.model.response.OrdersResponse;
import com.manage.project.model.response.Result;
import com.manage.project.service.impl.OrdersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrdersController {
    @Autowired
    private OrdersServiceImpl ordersService;
    @RequestMapping("/insertOrder")
    public Result insertOrder(String userId, String menuId) {
        Orders orders = new Orders();
        orders.setUserId(Integer.valueOf(userId));
        orders.setMenuId(Integer.valueOf(menuId));
        int insert = ordersService.insert(orders);
        if (insert > 0){
            return Result.success("添加点餐成功");
        }
        return Result.failure("添加点餐失败",40000);
    }
    @RequestMapping("/updateOrder")
    public Result updateOrder(String ordersId, String userId, String menuId) {
        Orders orders = new Orders();
        orders.setOrdersId(Integer.valueOf(ordersId));
        orders.setUserId(Integer.valueOf(userId));
        orders.setMenuId(Integer.valueOf(menuId));
        int update = ordersService.updateByPrimaryKeySelective(orders);
        if (update > 0){
            return Result.success("修改点餐成功");
        }else if(update == -1){
            return Result.failure("不能修改用户！",Result.PARAMS_ERROR);
        }
        return Result.failure("修改点餐失败",Result.PARAMS_ERROR);
    }
    @RequestMapping("/deleteOrder")
    public Result deleteOrder(String ordersId) {
        Long id = Long.valueOf(ordersId);
        int delete = ordersService.deleteByPrimaryKey(id);
        if (delete > 0){
            return Result.success("删除点餐成功");
        }
        return Result.failure("删除点餐失败",40000);
    }
    @RequestMapping("/getAllOrders")
    public Result getAllOrders() {
        List<OrdersResponse> orders = ordersService.selectAllOrders();
        return Result.success("查询点餐成功",orders);
    }
}

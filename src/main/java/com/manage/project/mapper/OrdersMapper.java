package com.manage.project.mapper;

import com.manage.project.model.domain.Orders;
import com.manage.project.model.response.OrdersResponse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author 麻小神
* @description 针对表【orders】的数据库操作Mapper
* @createDate 2024-05-12 20:42:54
* @Entity com.manage.project.model.domain.Orders
*/
@Mapper
public interface OrdersMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Orders record);

    int insertSelective(Orders record);

    Orders selectByPrimaryKey(Long id);

    List<OrdersResponse> selectAllOrders();

    int updateByPrimaryKeySelective(Orders record);

    int updateByPrimaryKey(Orders record);

}

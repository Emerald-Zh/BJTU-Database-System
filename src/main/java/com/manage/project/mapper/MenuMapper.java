package com.manage.project.mapper;

import com.manage.project.model.domain.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author 麻小神
* @description 针对表【menu】的数据库操作Mapper
* @createDate 2024-05-12 20:23:27
* @Entity com.manage.project.model.domain.Menu
*/
@Mapper
public interface MenuMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(Long id);

    List<Menu> selectAllMenus();

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);

}

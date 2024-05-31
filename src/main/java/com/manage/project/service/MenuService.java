package com.manage.project.service;

import com.manage.project.model.domain.Menu;

import java.util.List;

public interface MenuService {
    int deleteByPrimaryKey(Long id);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(Long id);

    List<Menu> selectAllMenus();

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);
}

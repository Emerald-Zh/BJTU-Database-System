package com.manage.project.service.impl;

import com.manage.project.mapper.MenuMapper;
import com.manage.project.model.domain.Menu;
import com.manage.project.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper mapper;
    @Override
    public int deleteByPrimaryKey(Long id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Menu record) {
        return mapper.insertSelective(record);
    }

    @Override
    public int insertSelective(Menu record) {
        return insertSelective(record);
    }

    @Override
    public Menu selectByPrimaryKey(Long id) {
        return null;
    }

    @Override
    public List<Menu> selectAllMenus() {
        return mapper.selectAllMenus();
    }

    @Override
    public int updateByPrimaryKeySelective(Menu record) {
        return mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Menu record) {
        return 0;
    }
}

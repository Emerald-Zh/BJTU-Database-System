package com.manage.project.controller;

import com.manage.project.model.domain.Menu;
import com.manage.project.model.response.Result;
import com.manage.project.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class MenuController {
    @Autowired
    private MenuService menuService;

    @RequestMapping("/insertMenu")
    public Result insertMenu(String name, double price, String type) {
        Menu menu = new Menu();
        menu.setMenuName(name);
        menu.setMenuPrice(new BigDecimal(price));
        menu.setMenuClass(type);
        int insert = menuService.insert(menu);
        if (insert > 0){
            return Result.success("添加菜品成功");
        }
        return Result.failure("添加菜品失败", Result.PARAMS_ERROR);
    }
    @RequestMapping("/updateMenu")
    public Result updateMenu(@RequestParam int id,String name, String price, String type) {
        Menu menu = new Menu();
        menu.setMenuId(id);
        menu.setMenuName(name);
        menu.setMenuPrice(new BigDecimal(price));
        menu.setMenuClass(type);
        int update = menuService.updateByPrimaryKeySelective(menu);
        if (update > 0){
            return Result.success("修改菜品成功");
        }
        return Result.failure("修改菜品失败", Result.PARAMS_ERROR);
    }

    @RequestMapping("/deleteMenu")
    public Result deleteMenu(int menuId) {
        Long id = (long) menuId;
        int delete = menuService.deleteByPrimaryKey(id);
        if (delete > 0){
            return Result.success("删除菜品成功");
        }
        return Result.failure("删除菜品失败", Result.PARAMS_ERROR);
    }

    @RequestMapping("/getAllMenus")
    public Result getAllMenus() {
        return Result.success("查询成功", menuService.selectAllMenus());
    }

    @RequestMapping("/getMenuByName")
    public Result getMenuByName(String menuName) {
//        return Result.success("查询成功", menuService.selectByPrimaryKey(menuName));
        return null;
    }

}

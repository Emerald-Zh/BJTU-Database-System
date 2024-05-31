package com.manage.project.mapper;

import com.manage.project.model.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface UserMapper {
    // 登录
    User login(String username, String password);

    // 注册
    int register(User user);

    // 根据ID查询用户
    User getUserById(int userId);

    // 根据用户名查询用户
    User getUserByUsername(String username);
    User getUserByNickName(String nickName);

    // 查询所有用户
    List<User> getUserList();
    // 更新用户信息
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}
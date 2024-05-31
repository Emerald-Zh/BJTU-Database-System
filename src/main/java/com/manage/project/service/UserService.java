package com.manage.project.service;

import com.manage.project.model.domain.User;
import com.manage.project.model.response.Result;

import java.util.List;

public interface UserService {
    Result registerByAccount(User user);

    User loginByAccount(User user);

    // 根据ID查询用户
    // 根据用户名查询用户
    User getUserByNickName(String nickName);

    // 查询所有用户
    List<User> getUserList();
    // 更新用户信息
    int updateUser(User user);

    // 删除用户
    int deleteUser(int userId);

}

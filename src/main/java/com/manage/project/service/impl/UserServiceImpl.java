package com.manage.project.service.impl;

import com.manage.project.mapper.UserMapper;
import com.manage.project.model.domain.User;
import com.manage.project.model.response.Result;
import com.manage.project.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    /**
     * 用户名注册方式
     *
     * @param user 请求参数
     * @return 响应结果
     */
    @Override
    public Result registerByAccount(User user) {
        // 后端校验操作
        // 查询用户名是否已被注册的逻辑
        User regisgerUser = userMapper.getUserByUsername(user.getUsername());
        if (regisgerUser != null) {
            // 如果不为空则说明该用户名已被注册，则返回提示信息
            return Result.failure("该用户名已被注册！请重新设置用户名！", Result.PARAMS_ERROR);

        }
        // 若没有被注册，则执行正常注册逻辑
        int row = userMapper.insertSelective(user);
        if (row > 0) {
            return Result.success("注册成功！");
        }
        return Result.failure("注册失败！", Result.SYSTEM_ERROR);
    }

    @Override
    public User loginByAccount(User user) {
        // 后端校验操作
        if (user.getUsername() == null || user.getUsername().isEmpty()) {
            return null;
        }
        if (user.getPassword() == null || user.getPassword().isEmpty()) {
            return null;
        }
        User login = userMapper.login(user.getUsername(), user.getPassword());
        if (login == null){
            return null;
        }
        return login;
    }


    @Override
    public User getUserByNickName(String nickName) {
        return userMapper.getUserByNickName(nickName);
    }


    @Override
    public List<User> getUserList() {
        return userMapper.getUserList();
    }

    @Override
    public int updateUser(User user) {
        int i = userMapper.updateByPrimaryKeySelective(user);
        if (i < 1) {
            return -1;
        }
        return 1;
    }

    @Override
    public int deleteUser(int userId) {
        int i = userMapper.deleteByPrimaryKey((long) userId);
        if (i < 1) {
            return -1;
        }
        return 1;
    }
}

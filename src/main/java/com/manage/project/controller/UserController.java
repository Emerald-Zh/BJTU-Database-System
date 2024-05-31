package com.manage.project.controller;

import com.manage.project.model.domain.User;
import com.manage.project.model.response.Result;
import com.manage.project.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/logout")
    public void doLogout(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 添加一条日志
        // 清除session
        session.setAttribute("loginUser", null);
        session.invalidate();
        response.sendRedirect("http://localhost:8080/loginPage");
    }

    /**
     * 通过账户登录的方法
     *
     * @param map 账户信息
     * @return 登录结果
     */
    @RequestMapping("/loginByAccount")
    public Result selectByAccount(@RequestBody Map<String, String> map, HttpServletRequest request,HttpServletResponse response, HttpSession session) {
        User user = new User();
        user.setUsername(map.get("username"));
        user.setPassword(map.get("password"));
        User loginUser = userService.loginByAccount(user);
        if (loginUser != null) {
            // 正常登录，则需补充其他登录的记录用户登录态
            session.setAttribute("loginUser", loginUser);
            return Result.success("登录成功！");
        }
        return Result.failure("您的账户或密码有误！请重新登录！", Result.NULL_ERROR);
    }

    @RequestMapping("/getCurrentUser")
    public Result getCurrentUser(HttpServletRequest request) {
        HttpSession session = request.getSession();
        User loginUser = (User) session.getAttribute("loginUser");
        if (loginUser != null) {
            return Result.success("查询成功！", loginUser);
        }
        return Result.failure("查询失败！", Result.NULL_ERROR);
    }

    /**
     * 通过账户注册的方法
     *
     * @param user    账户信息
     * @param request 请求
     * @return 注册结果
     */
    @RequestMapping("/registerByAccount")
    public Result registerByAccount(User user, HttpServletRequest request) {
        return userService.registerByAccount(user);
    }

    @RequestMapping("/getUserByNickName")
    public Result getUserByNickName(String nickName) {
        User user = userService.getUserByNickName(nickName);
        if (user != null) {
            return Result.success("查询成功！", user);
        }
        return Result.failure("查询失败！", Result.NULL_ERROR);
    }

    @RequestMapping("/getUserList")
    public Result getUserList() {
        return Result.success("查询成功！", userService.getUserList());
    }
    @RequestMapping("/updateUser")
    public Result updateUser(@RequestParam("userId") int userId,String username,String password,String nickName) {
        User user = new User();
        user.setUserId(userId);
        user.setUsername(username);
        user.setPassword(password);
        user.setNickName(nickName);
        int i = userService.updateUser(user);

        if (i>0){
            return Result.success("删除成功！",Result.SUCCESS_CODE);
        }
        return Result.failure("删除失败",Result.PARAMS_ERROR);

    }
    @RequestMapping("/deleteUser")
    public Result deleteUser(@RequestParam("userId") int userId) {
        int i = userService.deleteUser(userId);
        if (i>0){
            return Result.success("删除成功！",Result.SUCCESS_CODE);
        }
        return Result.failure("删除失败",Result.PARAMS_ERROR);
    }
    @RequestMapping("/addUser")
    public Result addUser(String username,String password,String nickName) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setNickName(nickName);
        Result result = userService.registerByAccount(user);
        if (result.getCode() == 0){
            return Result.success("添加用户成功！",Result.SUCCESS_CODE);
        }
        return Result.failure("添加用户失败！", Result.NULL_ERROR);
    }
}

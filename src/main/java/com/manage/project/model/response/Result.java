package com.manage.project.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Result {

    private String msg;

    private int code;

    private Object data;

    // 成功登录
    public static final int SUCCESS_CODE = 0;
    // 成功注册
    public static final int SUCCESS_REGISTER = 1;
    // 参数错误
    public static final int PARAMS_ERROR = 40000;
    // 参数为空
    public static final int NULL_ERROR = 40001;
    // 无登录
    public static final int NOT_LOGIN = 40100;
    // 无权限
    public static final int NO_AUTH = 40101;
    // 系统内部异常
    public static final int SYSTEM_ERROR = 50000;

    public static Result success(String msg, int code, Object data) {
        return new Result(msg, code, data);
    }

    public static Result success(String msg, Object data) {
        return new Result(msg, SUCCESS_CODE, data);
    }

    public static Result success(String msg) {
        return new Result(msg, SUCCESS_CODE, null);
    }

    public static Result success(String msg, int code){
        return new Result(msg,code,null);
    }
    public static Result failure(String msg, int code) {
        return new Result(msg, code, null);
    }

    public static Result failure(String msg, int code, Object data) {
        return new Result(msg, code, null);
    }
}

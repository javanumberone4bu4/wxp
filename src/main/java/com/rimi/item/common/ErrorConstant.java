package com.rimi.item.common;

/**
 * 错误常量
 *
 * @author Wang Xiaoping
 * @date 2019/9/23 14:50
 */
public enum ErrorConstant {
    /**
     * 成功
     */
    SUCCESS(200, "成功"),
    /**
     * 失败
     */
    FAIL(201, "错误"),
    /**
     * 登陆错误
     */
    LOGIN_ERROR(202, "用户名或密码错误!");

    /**
     * 错误码
     */
    private int code;

    /**
     * 错误描述
     */
    private String msg;

    ErrorConstant(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}

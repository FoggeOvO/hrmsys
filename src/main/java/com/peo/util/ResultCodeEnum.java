package com.peo.util;

/**
 * 统一返回结果状态信息类
 *
 */
public enum ResultCodeEnum {

    SUCCESS(200,"success"),
    USERNAME_ERROR(501,"用户名错误"),
    PASSWORD_ERROR(503,"密码错误"),
    NOTLOGIN(504,"没有登录"),
    NOTCHANGE(504,"没有改变发生"),
    ACCESSDENIED(504,"无权访问!"),
    NODATA(301,"没有数据!"),
    USERNAME_USED(505,"用户名已被使用");

    private Integer code;
    private String msg;
    private ResultCodeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    public Integer getCode() {
        return code;
    }
    public String getMessage() {
        return msg;
    }
}

package com.peo.util;

import lombok.Data;

import java.util.List;

@Data
public class Result {
    private Integer code;
    private String msg;
    private Object data;
    private Long timestamp;

    public Result() {
    }

    public Result(Integer code, String msg, Object data, Long timestamp) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.timestamp = timestamp;
    }

    private void build(ResultCodeEnum resultCodeEnum){
        Result result = new Result();
        result.setCode(resultCodeEnum.getCode());
        result.setMsg(result.getMsg());
    }

    public static Result ok(ResultCodeEnum resultCodeEnum){
        Result result = new Result();
        result.build(resultCodeEnum);
        return  result;
    }

    public static Result ok(){
        return new Result(200,"success",null,System.currentTimeMillis());
    }

    public static Result ok(Object data){
        return new Result(200,"success",data,System.currentTimeMillis());
    }

    public static Result ok(List<?> data) {
        return new Result(200, "success", data, System.currentTimeMillis());
    }

    public static Result failure(String msg) {
        return new Result(400, msg, null,System.currentTimeMillis());
    }

    public static Result failure(ResultCodeEnum resultCodeEnum) {
        Result result = new Result();
        result.build(resultCodeEnum);
        return  result;
    }



}

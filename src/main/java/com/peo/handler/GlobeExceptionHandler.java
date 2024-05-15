package com.peo.handler;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;



/** 异常处理中心
 * TODO
 * <p> 统一处理全部异常
 * */
@ControllerAdvice
public class GlobeExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String handlerException(){
        return "";
    }
}

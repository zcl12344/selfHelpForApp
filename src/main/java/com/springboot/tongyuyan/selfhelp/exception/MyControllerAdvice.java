package com.springboot.tongyuyan.selfhelp.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyControllerAdvice {

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Map<String,Object> erroHandler(Exception ex){
        Map<String,Object> map=new HashMap<>();
        map.put("cod",-1);
        map.put("msg",ex.getMessage());
        return  map;
    }

    @ResponseBody
    @ExceptionHandler(value = BusinessException.class)
    public Map<String,Object> businessException(BusinessException businessExceprion){
        Map<String,Object> map=new HashMap<>();
        map.put("cod",businessExceprion.getCode());
        map.put("msg",businessExceprion.getMessage());
        return  map;
    }
}

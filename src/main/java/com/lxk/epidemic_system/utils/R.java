package com.lxk.epidemic_system.utils;

import com.lxk.epidemic_system.enums.HttpStatus;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class R<T> {

    private HttpStatus status; //状态码

    private String msg; //错误信息

    private T data; //数据

    private Map<Object,Object> map = new HashMap<>(); //动态数据

    public static <T> R<T> success(T object,HttpStatus status) {
        R<T> r = new R<T>();
        r.data = object;
        r.status = status;
        return r;
    }

    public static <T> R<T> error(String msg,HttpStatus status) {
        R r = new R();
        r.msg = msg;
        r.status = status;
        return r;
    }

    public R<T> add(String key, Object value) {
        this.map.put(key, value);
        return this;
    }

}

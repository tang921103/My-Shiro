package com.demo.utils;

import java.util.HashMap;
import java.util.Map;

public class MessageUtil {
    public static Map<String,Object> getRightMSg(Object obj){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("code",1);
        map.put("message","ok");
        map.put("data",obj);
        return map;
    }
    public static Map<String,Object> getErrorMSg(Object obj){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("code",0);
        map.put("message","error");
        map.put("data",obj);
        return map;
    }
}

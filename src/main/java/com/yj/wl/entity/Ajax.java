package com.yj.wl.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Ajax {
    private Object data;
    private Map meta;

    public static Ajax success(){
        Ajax myResult = new Ajax();
        Map<Object,Object> map = new HashMap<Object, Object>();
        map.put("code",200);
        map.put("msg","成功");
        myResult.setMeta(map);
        return myResult;
    }
    public static Ajax success(Object data){
        Ajax myResult = new Ajax();
        Map<Object,Object> map = new HashMap<Object, Object>();
        map.put("code",200);
        map.put("msg","成功");
        myResult.setMeta(map);
        myResult.setData(data);

        return myResult;
    }

    public static Ajax error(){
        Ajax myResult = new Ajax();
        Map<Object,Object> map = new HashMap<Object, Object>();
        map.put("code",400);
        map.put("msg","失败");
        myResult.setMeta(map);
        return myResult;
    }
}

package com.co.back.event;

import com.alibaba.fastjson.JSONObject;
import org.springframework.context.ApplicationEvent;

import java.util.HashMap;

/**
 * @auther skg
 * @Date: 2019/12/3
 */
public class CallEvent extends ApplicationEvent {

    private HashMap<String,String> dataMap; //事件发生的当前节点
    //private 当前流程上下文
    public CallEvent(Object source, HashMap<String,String> dataMap) {
        super(source);
        this.dataMap = dataMap;
    }

    public HashMap<String, String> getDataMap() {
        return dataMap;
    }

    public void setDataMap(HashMap<String, String> dataMap) {
        this.dataMap = dataMap;
    }
}

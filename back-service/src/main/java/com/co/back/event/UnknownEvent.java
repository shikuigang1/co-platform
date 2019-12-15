package com.co.back.event;

import org.springframework.context.ApplicationEvent;

import java.util.HashMap;

/**
 * @auther skg
 * @Date: 2019/12/3
 */
public class UnknownEvent extends ApplicationEvent {

    private HashMap<String,String> dataMap; //事件发生的当前节点
    //private 当前流程上下文
    public UnknownEvent(Object source) {
        super(source);
    }

    public HashMap<String, String> getDataMap() {
        return dataMap;
    }

    public void setDataMap(HashMap<String, String> dataMap) {
        this.dataMap = dataMap;
    }
}

package com.co.back.event;

import com.alibaba.fastjson.JSONObject;
import org.springframework.context.ApplicationEvent;

/**
 * @auther skg
 * @Date: 2019/12/3
 */
public class TimeOutEvent extends ApplicationEvent {

    private JSONObject jsonT; //时间发生的当前节点
    private String desc;

    //private 当前流程上下文
    public TimeOutEvent(Object source, JSONObject jsonObject) {
        super(source);
        this.jsonT = jsonObject;
    }

    public JSONObject getObject() {
        return jsonT;
    }
}

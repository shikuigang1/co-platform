package com.co.back.event;

import org.springframework.context.ApplicationEvent;

import java.util.Map;

/**
 * @auther skg
 * @Date: 2019/12/8
 */
public class ChannelCreateEvent extends ApplicationEvent {

    public Map<String, String> getContexData() {
        return contexData;
    }

    public void setContexData(Map<String, String> contexData) {
        this.contexData = contexData;

    }

    private Map<String,String > contexData;// 呼叫信息

    public ChannelCreateEvent(Object source) {
        super(source);
    }
}

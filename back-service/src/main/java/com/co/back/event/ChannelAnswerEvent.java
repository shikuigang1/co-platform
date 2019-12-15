package com.co.back.event;

import org.springframework.context.ApplicationEvent;

import java.util.Map;

/**
 * @auther skg
 * @Date: 2019/12/8
 */
public class ChannelAnswerEvent extends ApplicationEvent {

    private Map<String,String > contexData;// 上下文数据

    public ChannelAnswerEvent(Object source) {
        super(source);
    }
}

package com.co.back.config;

import com.alibaba.fastjson.JSONObject;
import com.co.back.enums.EventEnum;
import com.co.back.event.TimeOutEvent;
import org.apache.commons.lang.enums.Enum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Configuration;

/**
 * @auther skg
 * @Date: 2019/12/3
 */
@Configuration
public class PublishCenter {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public void publish(EventEnum event, JSONObject jsonObject){

        switch (event){
            case TIME_OUT:
                //TimeOutEvent timeOutEvent = new TimeOutEvent();
                //applicationEventPublisher.publishEvent(timeOutEvent);
                break;
            case UNKNOWN_INTENTION:

        }

    }


}

package com.co.back.listener;

import com.alibaba.fastjson.JSONObject;
import com.co.back.event.HandupEvent;
import com.co.back.event.TimeOutEvent;
import com.co.back.service.impl.CallServiceImpl;
import com.co.back.vo.CallingMobileVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @auther skg
 * @Date: 2019/12/3
 */
@Component
public class TimeOutListener implements ApplicationListener<TimeOutEvent> {

    private static final Logger log = LoggerFactory.getLogger(TimeOutListener.class);

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void onApplicationEvent(TimeOutEvent timeOutEvent) {

        CallingMobileVo callingMobileVo = (CallingMobileVo)timeOutEvent.getSource();
        log.info("超时监听处理：{}",callingMobileVo.getMobile());

        JSONObject jsonObject = callingMobileVo.getJsonGlobal();
        Object o = jsonObject.get("overtime.targetNode");
        if(o == null) {//没有超时 节点 默认挂机
            HandupEvent handupEvent = new HandupEvent(callingMobileVo);
            applicationEventPublisher.publishEvent(handupEvent);
        }else{

        }
    }
}

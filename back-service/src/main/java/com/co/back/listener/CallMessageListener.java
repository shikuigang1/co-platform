package com.co.back.listener;

import com.co.back.event.CallMessageEvent;
import com.co.back.event.ChannelAnswerEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @auther skg
 * @Date: 2019/12/3
 */
@Component
public class CallMessageListener implements ApplicationListener<CallMessageEvent> {

    private static final Logger log = LoggerFactory.getLogger(CallMessageListener.class);

    @Override
    public void onApplicationEvent(CallMessageEvent callMessageEvent) {
        Map<String,String> map = (HashMap<String,String>) callMessageEvent.getSource();
        String text = map.get("result");


    }
}

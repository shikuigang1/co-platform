package com.co.back.listener;

import com.co.back.config.GlobalEnv;
import com.co.back.event.ChannelCreateEvent;
import com.co.back.event.TimeOutEvent;
import com.co.back.vo.CallingMobileVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @auther skg
 * @Date: 2019/12/3
 */
@Component
public class ChannelCreateEventListener implements ApplicationListener<ChannelCreateEvent> {

    private static final Logger log = LoggerFactory.getLogger(ChannelCreateEventListener.class);

    @Autowired
    private GlobalEnv globalEnv;

    @Override
    public void onApplicationEvent(ChannelCreateEvent channelCreateEvent) {
       Map<String,String> map = (HashMap<String,String>) channelCreateEvent.getSource();
       CopyOnWriteArrayList<CallingMobileVo> callingMobiles = globalEnv.getCallingMobile();
        String uuid = map.get("Unique-ID");
        String mobile = uuid.split("-")[0];
        for(CallingMobileVo callingMobileVo:callingMobiles){

            if(callingMobileVo.getMobile().equals(mobile)){
                callingMobileVo.setWaitStart(System.currentTimeMillis());
                break;
            }
        }

    }
}

package com.co.back.listener;

import com.co.back.config.GlobalEnv;
import com.co.back.event.CallDestroyEvent;
import com.co.back.event.ChannelAnswerEvent;
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
public class ChannelDestroyEventListener implements ApplicationListener<CallDestroyEvent> {

    private static final Logger log = LoggerFactory.getLogger(ChannelDestroyEventListener.class);

    @Autowired
    private GlobalEnv globalEnv;

    @Override
    public void onApplicationEvent(CallDestroyEvent callDestroyEvent) {
        //通话结束 资源回收
        Map<String,String> map = (HashMap<String,String>) callDestroyEvent.getSource();
        CopyOnWriteArrayList<CallingMobileVo> callingMobiles = globalEnv.getCallingMobile();
        String uuid = map.get("Unique-ID");
        log.info("资源回收：{}",uuid);
        String mobile = uuid.split("-")[0];
        for(CallingMobileVo callingMobileVo:callingMobiles){
            if(callingMobileVo.getMobile().equals(mobile)){
                callingMobiles.remove(callingMobileVo);
                break;
            }
        }
        globalEnv.getCurrentThreads().decrementAndGet();
    }
}

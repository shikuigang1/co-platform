package com.co.back.listener;

import com.alibaba.fastjson.JSONObject;
import com.co.back.config.GlobalEnv;
import com.co.back.event.ChannelAnswerEvent;
import com.co.back.service.impl.CallServiceImpl;
import com.co.back.vo.CallingMobileVo;
import org.freeswitch.esl.client.inbound.Client;
import org.freeswitch.esl.client.transport.SendMsg;
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
public class ChannerAnswerListener implements ApplicationListener<ChannelAnswerEvent> {

    private static final Logger log = LoggerFactory.getLogger(ChannerAnswerListener.class);

    @Autowired
    private GlobalEnv globalEnv;

    @Autowired
    private Client fsInboundClient;

    @Override
    public void onApplicationEvent(ChannelAnswerEvent channelAnswerEvent) {
        //超时 时间重置
        Map<String,String> map = (HashMap<String,String>) channelAnswerEvent.getSource();
        CopyOnWriteArrayList<CallingMobileVo> callingMobiles = globalEnv.getCallingMobile();
        String uuid = map.get("Unique-ID");
        String mobile = uuid.split("-")[0];
        JSONObject currentNode = null;
        for(CallingMobileVo callingMobileVo:callingMobiles){
            if(callingMobileVo.getMobile().equals(mobile)){
                callingMobileVo.setWaitStart(System.currentTimeMillis());
                currentNode = callingMobileVo.getCurrentNode();
                break;
            }
        }
        if(currentNode != null){
            Object o = currentNode.get("voiceInfo");
            if(o != null){
                String path = o.toString();
                SendMsg msg = new SendMsg(uuid);
                msg.addCallCommand("execute");
                msg.addExecuteAppName("playback");
                msg.addExecuteAppArg(path);///usr/local/test
                fsInboundClient.sendMessage(msg);

            }else if(currentNode.get("nodeContent")!=null && !currentNode.get("nodeContent").equals("")){
                String content = currentNode.get("nodeContent").toString();

            }

        }
    }
}

package com.co.back.listener;

import com.co.back.event.CallMessageEvent;
import com.co.back.event.HandupEvent;
import com.co.back.vo.CallingMobileVo;
import org.freeswitch.esl.client.inbound.Client;
import org.freeswitch.esl.client.transport.SendMsg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @auther skg
 * @Date: 2019/12/3
 */
@Component
public class HandupEventListener implements ApplicationListener<HandupEvent> {

    private static final Logger log = LoggerFactory.getLogger(HandupEventListener.class);

    @Autowired
    private Client fsInboundClient;


    @Override
    public void onApplicationEvent(HandupEvent handupEvent) {

       CallingMobileVo vo =  (CallingMobileVo)handupEvent.getSource();
       log.info("主动挂断电话：{}",vo.getMobile());

        SendMsg msg = new SendMsg(vo.getMobile()+"-"+vo.getSenceID());
        msg.addCallCommand("execute");
        msg.addExecuteAppName("uuid_break");
        fsInboundClient.sendMessage(msg);

    }
}

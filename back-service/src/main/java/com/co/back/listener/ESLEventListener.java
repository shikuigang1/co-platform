package com.co.back.listener;

import com.co.back.event.CallDestroyEvent;
import com.co.back.event.CallMessageEvent;
import com.co.back.event.ChannelAnswerEvent;
import com.co.back.event.ChannelCreateEvent;
import org.freeswitch.esl.client.IEslEventListener;
import org.freeswitch.esl.client.transport.event.EslEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @auther skg
 * @Date: 2019/12/8
 */
@Component
public class ESLEventListener implements IEslEventListener {


    public ApplicationEventPublisher getApplicationEventPublisher() {
        return applicationEventPublisher;
    }

    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void eventReceived(EslEvent eslEvent) {
        Map<String,String> map = eslEvent.getEventHeaders();
        switch (eslEvent.getEventName()){

            case "CHANNEL_CREATE":
               ChannelCreateEvent c = new ChannelCreateEvent(map);
               applicationEventPublisher.publishEvent(c);
            case "CHANNEL_ANSWER":
                ChannelAnswerEvent channelAnswerEvent = new ChannelAnswerEvent(map);
                applicationEventPublisher.publishEvent(channelAnswerEvent);

            case "CHANNEL_DESTROY":
                CallDestroyEvent callDestroyEvent = new CallDestroyEvent(map);
                applicationEventPublisher.publishEvent(callDestroyEvent);
            case "CHANNEL_BRIDGE":

            case "CHANNEL_HANGUP_COMPLETE":

            case "DTMF":

            case "CUSTOM": //自定义事件
                if(map.get("method") != null && map.get("method").equals("asr_result")){
                    CallMessageEvent callMessageEvent = new CallMessageEvent(map);
                    applicationEventPublisher.publishEvent(callMessageEvent);
                }
        }

    }

    @Override
    public void backgroundJobResultReceived(EslEvent eslEvent) {

    }
}

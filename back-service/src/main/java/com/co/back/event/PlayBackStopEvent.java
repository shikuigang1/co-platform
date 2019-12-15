package com.co.back.event;

import org.springframework.context.ApplicationEvent;

/**
 * @auther skg
 * @Date: 2019/12/8
 */
public class PlayBackStopEvent  extends ApplicationEvent {

    public PlayBackStopEvent(Object source) {
        super(source);
    }

}

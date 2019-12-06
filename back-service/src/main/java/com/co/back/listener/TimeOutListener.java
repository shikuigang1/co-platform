package com.co.back.listener;

import com.co.back.event.TimeOutEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @auther skg
 * @Date: 2019/12/3
 */
@Component
public class TimeOutListener implements ApplicationListener<TimeOutEvent> {
    @Override
    public void onApplicationEvent(TimeOutEvent timeOutEvent) {

    }
}

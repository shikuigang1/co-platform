package com.co.back.config;

import com.co.back.entity.CallRecord;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @auther skg
 * @Date: 2019/10/23
 */
@Configuration
public class QueueConfig {

    @Bean(name = "consumeLinkedBlockingQueue")
    public LinkedBlockingQueue<CallRecord> linkedBlockingQueue() {
        return new LinkedBlockingQueue<CallRecord>();
    }


}

package com.co.back.consumer;

import com.co.back.entity.CallRecord;
import com.co.back.service.CallService;
import com.co.back.service.QueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @auther skg
 * @Date: 2019/12/10
 */
//@Component
public class ConsumeQuenueStarter implements CommandLineRunner{

    @Autowired
    private QueueService queueService;

    @Override
    public void run(String... args) throws Exception {

        /*while (true){
            System.out.println("AAAA");
            CallRecord record = queueService.takeRecordFromQueue();
            if(record == null){

            }
        }*/

    }
}

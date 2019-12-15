package com.co.back;

import com.co.back.entity.CallRecord;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;


/**
 * @auther skg
 * @Date: 2019/11/26
 */

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
@EnableScheduling
@MapperScan("com.co.back.mapper")
public class BackServiceApplication {

    @Autowired
    private LinkedBlockingQueue<CallRecord> consumeLinkedBlockingQueue ;

    public static void  main(String[] args){
        SpringApplication.run(BackServiceApplication.class);
    }
}

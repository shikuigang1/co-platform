package com.co.back;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


/**
 * @auther skg
 * @Date: 2019/11/26
 */

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class BackServiceApplication {

    public static void  main(String[] args){

        SpringApplication.run(BackServiceApplication.class);

    }
}

package com.co.front.api;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @auther skg
 * @Date: 2019/12/3
 */

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
@EnableSwagger2
//@MapperScan("com.co.front.api.mapper")
public class ApiApplication {


    public static void main(String[] args){
        SpringApplication.run(ApiApplication.class);
    }
}

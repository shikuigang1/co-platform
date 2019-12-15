package com.co.back.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @auther skg
 * @Date: 2019/12/9
 * //全局 硬件资源 收集
 */
@Configuration
public class GlobalCollectConfigure {

    @Value("${max.routes.thread}")
    private Integer maxThreadRoute ;

    public static Integer CURRENT_ROUTES = 0;//当前并发使用的线路数量

    /**
     * 线路资源收集
     */
    public void collectRoutes(){

    }



}

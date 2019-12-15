package com.co.back.config;

import com.co.back.vo.CallingMobileVo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @auther skg
 * @Date: 2019/12/10
 */
@Configuration("globalEvn")
public class GlobalEnv {

    @Value("${max.routes.thread}")
    private Integer maxThreadRoute ;  //最大线路数 不可修改
    @Value("${max.mobile.timeOut}")
    private Integer timeOut ;  //最大超时时间
    @Value("${fs.ali.appkey}")
    private String appkey;
    @Value("${fs.ali.appid}")
    private String appid;
    @Value("${fs.ali.secret}")
    private String appsecret;

    public  AtomicInteger currentThreads = new AtomicInteger(0); //当前使用线路数量

    @Bean(name = "timeOutWatcherList")
    public CopyOnWriteArrayList initCopyOnWriteArrayList(){
        return new CopyOnWriteArrayList<CallingMobileVo>();
    }

    public CopyOnWriteArrayList getCallingMobile() {
        return callingMobile;
    }

    public CopyOnWriteArrayList callingMobile = new CopyOnWriteArrayList<CallingMobileVo>();//正在呼叫的任务


    public void setCallingMobile(CopyOnWriteArrayList callingMobile) {
        this.callingMobile = callingMobile;
    }

    public Integer getMaxThreadRoute() {
        return maxThreadRoute;
    }

    public void setMaxThreadRoute(Integer maxThreadRoute) {
        this.maxThreadRoute = maxThreadRoute;
    }

    public  AtomicInteger getCurrentThreads() {
        return currentThreads;
    }

    public  void setCurrentThreads(AtomicInteger currentThreads) {
        this.currentThreads = currentThreads;
    }

    public Integer getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(Integer timeOut) {
        this.timeOut = timeOut;
    }

    public String getAppkey() {
        return appkey;
    }

    public void setAppkey(String appkey) {
        this.appkey = appkey;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getAppsecret() {
        return appsecret;
    }

    public void setAppsecret(String appsecret) {
        this.appsecret = appsecret;
    }
}

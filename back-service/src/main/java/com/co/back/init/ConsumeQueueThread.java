package com.co.back.init;

import com.co.back.config.GlobalEnv;
import com.co.back.config.PublishCenter;
import com.co.back.entity.CallRecord;
import com.co.back.enums.EventEnum;
import com.co.back.event.CallEvent;
import com.co.back.service.QueueService;
import com.co.back.vo.CallingMobileVo;

import java.util.concurrent.CopyOnWriteArrayList;


public class ConsumeQueueThread implements Runnable {

    private QueueService queueService;
    private GlobalEnv globalEnv;
    private PublishCenter publishCenter;

    @Override
    public void run() {

        while(true){
            //查看是否有足够的 资源进行呼叫
           Integer currentsize = globalEnv.getCurrentThreads().get();
           Integer maxThreadRoute = globalEnv.getMaxThreadRoute();

           if(maxThreadRoute > currentsize){
               globalEnv.getCurrentThreads().incrementAndGet();
               CallRecord record = queueService.takeRecordFromQueue();
               if(null != record){
                   publishCenter.publish(EventEnum.CALL,record);
               }
           }

        }
    }

    public QueueService getQueueService() {
        return queueService;
    }

    public void setQueueService(QueueService queueService) {
        this.queueService = queueService;
    }

    public GlobalEnv getGlobalEnv() {
        return globalEnv;
    }

    public void setGlobalEnv(GlobalEnv globalEnv) {
        this.globalEnv = globalEnv;
    }

    public PublishCenter getPublishCenter() {
        return publishCenter;
    }

    public void setPublishCenter(PublishCenter publishCenter) {
        this.publishCenter = publishCenter;
    }
}

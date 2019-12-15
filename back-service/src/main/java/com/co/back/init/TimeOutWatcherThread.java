package com.co.back.init;


import com.alibaba.fastjson.JSONObject;
import com.co.back.config.GlobalEnv;
import com.co.back.event.TimeOutEvent;
import com.co.back.vo.CallingMobileVo;
import org.springframework.context.ApplicationEventPublisher;

import java.util.concurrent.CopyOnWriteArrayList;


public class TimeOutWatcherThread implements Runnable {


    private GlobalEnv globalEnv;

    public ApplicationEventPublisher getApplicationEventPublisher() {
        return applicationEventPublisher;
    }

    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void run() {

        while(true){

            CopyOnWriteArrayList<CallingMobileVo> callingMobiles = globalEnv.getCallingMobile();
            for(CallingMobileVo callingMobileVo:callingMobiles){

                if(callingMobileVo.getWaitStart() != 0L){
                    //判断是否超时
                    JSONObject jsonObject = callingMobileVo.getJsonGlobal();
                    Object time = jsonObject.get("overtime.time");
                    if(time == null){
                        break;
                    }else{
                        long timeOut = Long.parseLong(String.valueOf(time));
                        long now = System.currentTimeMillis();
                        long start = callingMobileVo.getWaitStart();
                        if(now -start > timeOut * 1000){
                            TimeOutEvent timeOutEvent = new TimeOutEvent(callingMobileVo);
                            applicationEventPublisher.publishEvent(timeOutEvent);
                        }
                    }
                }
                /*callingMobileVo.
                if(callingMobileVo.getMobile().equals(record.getCall_number())){
                    queueService.addRecordToQueue(record);
                    isCalling = true;
                    break;
                }*/
            }

            //每500毫秒检查一次
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public GlobalEnv getGlobalEnv() {
        return globalEnv;
    }

    public void setGlobalEnv(GlobalEnv globalEnv) {
        this.globalEnv = globalEnv;
    }
}

package com.co.back.listener;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.co.back.config.GlobalEnv;
import com.co.back.entity.CallRecord;
import com.co.back.entity.Sence;
import com.co.back.event.CallEvent;
import com.co.back.service.QueueService;
import com.co.back.service.SenceService;
import com.co.back.vo.CallingMobileVo;
import org.freeswitch.esl.client.inbound.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @auther skg
 * @Date: 2019/12/3
 */
@Component
public class CallListener implements ApplicationListener<CallEvent> {

    //当前默认使用网关呼叫

    @Autowired
    private Client fsInboundClient;

    @Autowired
    GlobalEnv globalEnv;

    @Autowired
    private QueueService queueService;

    @Autowired
    private SenceService senceService;

    @Override
    public void onApplicationEvent(CallEvent callEvent) {

        CopyOnWriteArrayList<CallingMobileVo> callingMobiles = globalEnv.getCallingMobile();
        CallRecord record = (CallRecord)callEvent.getSource();
        //验证 是否此电话在拨打过程中
        boolean isCalling = false;
        if(callingMobiles.size() > 0){
            for(CallingMobileVo callingMobileVo:callingMobiles){
                if(callingMobileVo.getMobile().equals(record.getCall_number())){
                    queueService.addRecordToQueue(record);
                    isCalling = true;
                    //线路回收
                    globalEnv.getCurrentThreads().decrementAndGet();
                    break;
                }
            }
        }

        if(!isCalling){
            //获取场景相关信息
            Sence sence = senceService.findSenceById(record.getSenceID());
            if(sence == null){
                globalEnv.getCurrentThreads().decrementAndGet();
                return;
            }
            CallingMobileVo callingMobileVo = new CallingMobileVo();

            callingMobileVo.setJsonGlobal(JSON.parseObject(sence.getSence_global()));
            callingMobileVo.setSenceFlow(JSON.parseArray(sence.getSence_flow()));
            callingMobileVo.setSenceID(sence.getId());
            callingMobileVo.setMobile(record.getCall_number());
            callingMobileVo.setWaitStart(0L);
            callingMobileVo.setCurrentNode(callingMobileVo.getSenceFlow().getJSONObject(0));//默认第一个是开始节点
            callingMobiles.add(callingMobileVo);

            //
            String command ="{origination_uuid="+record.getCall_number()+"-"+record.getSenceID()+"}"
                    + "{ignore_early_media=false,absolute_codec_string='PCMU,PCMA'}sofia/gateway/wangguan/"+record.getCall_number()
                    +" 'start_asr:"+ globalEnv.getAppkey()+" "+globalEnv.getAppid()+" "+globalEnv.getAppsecret()+",park' inline";

            fsInboundClient.sendAsyncApiCommand("originate",command);
        }
    }
}

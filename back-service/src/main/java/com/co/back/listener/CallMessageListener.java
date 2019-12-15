package com.co.back.listener;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.co.back.config.GlobalEnv;
import com.co.back.event.CallMessageEvent;
import com.co.back.event.ChannelAnswerEvent;
import com.co.back.event.UnknownEvent;
import com.co.back.vo.CallingMobileVo;
import org.freeswitch.esl.client.inbound.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @auther skg
 * @Date: 2019/12/3
 */
@Component
public class CallMessageListener implements ApplicationListener<CallMessageEvent> {

    private static final Logger log = LoggerFactory.getLogger(CallMessageListener.class);


    @Autowired
    private GlobalEnv globalEnv;

    @Autowired
    private Client fsInboundClient;

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void onApplicationEvent(CallMessageEvent callMessageEvent) {
        Map<String,String> map = (HashMap<String,String>) callMessageEvent.getSource();
        String text = map.get("result");
        log.info("识别到文本：{}",text);
        //意图识别
        CopyOnWriteArrayList<CallingMobileVo> callingMobiles = globalEnv.getCallingMobile();
        String uuid = map.get("Unique-ID");
        String mobile = uuid.split("-")[0];
        JSONObject currentNode = null;
        CallingMobileVo currentVo = null;
        for(CallingMobileVo callingMobileVo:callingMobiles){
            if(callingMobileVo.getMobile().equals(mobile)){
                callingMobileVo.setWaitStart(System.currentTimeMillis());
                currentNode = callingMobileVo.getCurrentNode();
                currentVo = callingMobileVo;
                break;
            }
        }
        if(currentNode == null){
            log.info("未找到节点信息：{}",mobile);
            return;
        }
        //处理该节点下的意图
        JSONArray jsonArray = currentNode.getJSONArray("status");

        boolean flag = false;
        String nextNode = null;
        for(int i=0;i<jsonArray.size();i++){
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            JSONArray jsonArray1 = jsonObject.getJSONArray("intentPrivateLexicon");
            //私有词库比较
            for(int j=0;j<jsonArray1.size();j++){
                String temp = jsonArray1.getString(j);
                //非正则
                if(text.contains(temp)){
                    nextNode = jsonObject.getString("jsonObject");
                    flag = true;
                    break;
                }
            }
            //共有词库比较
            if(!flag){
                JSONArray jsonArray2 = jsonObject.getJSONArray("intentPublicLexicon");
                if(jsonArray2 !=null && jsonArray2.size()!=0){
                    for(int j=0;j<jsonArray2.size();j++){
                        String temp = jsonArray2.getString(j);
                        //非正则
                        if(text.contains(temp)){
                            nextNode = jsonObject.getString("jsonObject");
                            flag = true;
                            break;
                        }
                    }
                }
            }

            if(flag){
                //不进行后面比较
                break;
            }
        }

        if(flag){
            //匹配到结果 当前节点 更换
            for(CallingMobileVo callingMobileVo:callingMobiles){
                JSONArray flow = callingMobileVo.getSenceFlow();
                boolean findNextNode = false;
                if(callingMobileVo.getMobile().equals(mobile)){
                    for(int k=0;k<flow.size();k++){
                        JSONObject jsonObject = flow.getJSONObject(k);
                        String id = jsonObject.getString("id");
                        if(id.equals(nextNode)){
                            //currentNode = jsonObject;
                            callingMobileVo.setCurrentNode(jsonObject);
                            findNextNode = true;
                            break;
                        }
                    }
                }
                if(findNextNode){
                    break;
                }

            }
        }
        //未知节点
        if(!flag){
            //UnknownEvent unknownEvent = new UnknownEvent(map);
            //applicationEventPublisher.publishEvent(unknownEvent);
            //寻找未知节点
            JSONObject jsonObject = currentVo.getJsonGlobal();
            Object unknown = jsonObject.get("unknown");
            if(unknown != null){
                JSONObject jsonObject1 = jsonObject.getJSONObject("unknown");
                if(jsonObject1.getString("targetNode") != null && !jsonObject1.getString("targetNode").equals("")){
                    String nextNodeID = jsonObject1.getString("targetNode");
                    for(CallingMobileVo callingMobileVo:callingMobiles){
                        JSONArray flow = callingMobileVo.getSenceFlow();
                        boolean findNextNode = false;
                        if(callingMobileVo.getMobile().equals(mobile)){
                            for(int k=0;k<flow.size();k++){
                                JSONObject temp = flow.getJSONObject(k);
                                String id = jsonObject.getString("id");
                                if(id.equals(nextNodeID)){
                                    callingMobileVo.setCurrentNode(temp);
                                    findNextNode = true;
                                    break;
                                }
                            }
                        }
                        if(findNextNode){
                            break;
                        }

                    }

                }else{
                    log.info("未设置 未知意图！");
                }

            }
        }

    }


}

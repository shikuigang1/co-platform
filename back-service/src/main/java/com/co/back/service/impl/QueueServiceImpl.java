package com.co.back.service.impl;

import com.co.back.entity.CallRecord;
import com.co.back.service.QueueService;
import jdk.nashorn.internal.codegen.CompilerConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @auther skg
 * @Date: 2019/12/10
 */
@Service("queueService")
public class QueueServiceImpl implements QueueService {

    private static final Logger log = LoggerFactory.getLogger(QueueServiceImpl.class);


    @Autowired
    private LinkedBlockingQueue consumeLinkedBlockingQueue;

    @Override
    public void addRecordToQueue(CallRecord callRecord) {
        log.info("添加记录到队列：{},对应场景{}",callRecord.getCall_number(),callRecord.getSenceID());
        consumeLinkedBlockingQueue.add(callRecord);
    }

    @Override
    public CallRecord takeRecordFromQueue()  {

        if(consumeLinkedBlockingQueue.size()>0){
            CallRecord callRecord = null;
            try {
                callRecord = (CallRecord)consumeLinkedBlockingQueue.take();
            } catch (InterruptedException e) {
                log.error("队列中获取呼叫记录异常{}",e.getMessage());
                e.printStackTrace();
            }
            log.info("队列中取数据进行呼叫：{},对应场景{}",callRecord.getCall_number(),callRecord.getSenceID());
            return  callRecord;
        }else{
            return null;
        }
    }

    @Override
    public Integer getQueueLength() {
        return consumeLinkedBlockingQueue.size();
    }
}

package com.co.back.service.impl;

import com.co.back.entity.CallRecord;
import com.co.back.mapper.CallRecordMapper;
import com.co.back.service.CallService;
import com.co.back.service.QueueService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

/**
 * @auther skg
 * @Date: 2019/12/8
 */

@Service("callService")
@Transactional
public class CallServiceImpl implements CallService {

    private static final Logger log = LoggerFactory.getLogger(CallServiceImpl.class);

    @Autowired
    private CallRecordMapper callRecordMapper;

    @Autowired
    private QueueService queueService;

    @Override
    public void call(String mobile, Integer senceId,String jsonContext) {
        CallRecord callRecord = new CallRecord();

        callRecord.setCall_batch(UUID.randomUUID().toString());//呼叫批次
        callRecord.setCall_data(jsonContext);
        callRecord.setCall_msg(null);
        callRecord.setResource(null);//呼叫来源
        callRecord.setCall_number(mobile);
        callRecord.setSenceID(senceId);
        callRecord.setCreate_time(new Date());
        callRecordMapper.insertSelective(callRecord);
        //添加呼叫任务到 队列中
        queueService.addRecordToQueue(callRecord);

        System.out.println(queueService.getQueueLength());

    }

    @Override
    public void breakup(String mobile) {

    }

    @Override
    public int addCallRecord(CallRecord callRecord) {
        //return callRecordMapper.insert(callRecord);
        return callRecordMapper.insertSelective(callRecord);
    }
}

package com.co.back.service;

import com.co.back.entity.CallRecord;

/**
 * @auther skg
 * @Date: 2019/12/10
 */
public interface QueueService {

    //添加数据到队列中
    void addRecordToQueue(CallRecord callRecord);

    //从队列中取数据
    CallRecord takeRecordFromQueue();

    //获取当前 队列长度
    Integer getQueueLength();



}

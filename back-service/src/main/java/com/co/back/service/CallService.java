package com.co.back.service;

import com.co.back.entity.CallRecord;

/**
 * @auther skg
 * @Date: 2019/12/8
 */
public interface CallService {

    public void call(String mobile,Integer senceId,String jsonContext);

    public void breakup(String mobile);

    //添加呼叫记录
    public int addCallRecord(CallRecord callRecord);

}

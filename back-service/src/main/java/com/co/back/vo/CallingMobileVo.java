package com.co.back.vo;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.Date;

/**
 * @auther skg
 * @Date: 2019/12/11
 */
public class CallingMobileVo {

    private String mobile;
    private Integer senceID;
    private Long waitStart; //超时监听开始时间点
    private Integer timeOut;//全局超时
    private JSONObject jsonGlobal;//全局json
    private JSONArray senceFlow;//场景节点流程
    private JSONObject currentNode;//当前节点

    public JSONObject getCurrentNode() {
        return currentNode;
    }

    public void setCurrentNode(JSONObject currentNode) {
        this.currentNode = currentNode;
    }

    public JSONObject getJsonGlobal() {
        return jsonGlobal;
    }

    public void setJsonGlobal(JSONObject jsonGlobal) {
        this.jsonGlobal = jsonGlobal;
    }

    public JSONArray getSenceFlow() {
        return senceFlow;
    }

    public void setSenceFlow(JSONArray senceFlow) {
        this.senceFlow = senceFlow;
    }

    public Integer getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(Integer timeOut) {
        this.timeOut = timeOut;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getSenceID() {
        return senceID;
    }

    public void setSenceID(Integer senceID) {
        this.senceID = senceID;
    }

    public Long getWaitStart() {
        return waitStart;
    }

    public void setWaitStart(Long waitStart) {
        this.waitStart = waitStart;
    }
}

package com.co.back.enums;

public enum EventEnum {

    CALL("CALL","呼叫"),
    TIME_OUT("TIME_OUT", "超时事件"),
    SEND_MESSAGE("SEND_MESSAGE","发送短信"),
    GATHER_INFO("GATHER_INFO","采集事件"),
    MOBILE_RECEIVE_KEY("MOBILE_RECEIVE_KEY","收键"),
    UNKNOWN_INTENTION("UNKNOWN_INTENTION","未知意图"),
    CONVERT_MANUAL("CONVERT_MANUAL","转人工");

    String key;
    String desc;

    EventEnum(String key, String desc) {
        this.key = key;
        this.desc = desc;
    }

    public static EventEnum getEnumByKey(String key){
        EventEnum[] payEnums = EventEnum.values();
        for(EventEnum payEnum : payEnums){
            if(payEnum.getKey().equals(key) ){
                return payEnum;
            }
        }
        return null;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}

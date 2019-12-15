package com.co.back.enums;

public enum FSEventEnum {

    CHANNEL_CREATE("CHANNEL_CREATE", "信道创建"),
    CHANNEL_DESTROY ("CHANNEL_DESTROY", "信道销毁"),
    CHANNEL_HANGUP ("CHANNEL_HANGUP","挂机事件 "),
    CHANNEL_HANGUP_COMPLETE ("CHANNEL_HANGUP_COMPLETE","挂机完成事件"),
    CHANNEL_EXECUTE_COMPLETE ("CHANNEL_EXECUTE_COMPLETE","呼叫执行完成"),
    CHANNEL_BRIDGE ("CHANNEL_BRIDGE","通道桥接事件"),
    CHANNEL_UNBRIDGE ("CHANNEL_UNBRIDGE","桥接停用事件"),
    CHANNEL_OUTGOING("CHANNEL_OUTGOING","外呼事件"),
    CHANNEL_PARK ("CHANNEL_PARK","挂起事件"),
    CHANNEL_ANSWER("CHANNEL_ANSWER", "客户应答事件"),

    CLIENT_DISCONNECTED ("CLIENT_DISCONNECTED","客户断开事件"),
    SERVER_DISCONNECTED ("SERVER_DISCONNECTED","服务断开事件"),
    PLAYBACK_START ("PLAYBACK_START","开始播放事件"),
    PLAYBACK_STOP ("PLAYBACK_STOP","停止播放"),

    PRESENCE_IN("PRESENCE_IN","呼入事件");

    String key;
    String desc;

    FSEventEnum(String key, String desc) {
        this.key = key;
        this.desc = desc;
    }

    public static FSEventEnum getEnumByKey(String key){
        FSEventEnum[] payEnums = FSEventEnum.values();
        for(FSEventEnum payEnum : payEnums){
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

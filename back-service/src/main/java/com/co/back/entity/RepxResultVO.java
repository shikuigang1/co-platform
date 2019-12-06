package com.co.back.entity;

/**
 * @auther skg
 * @Date: 2019/11/29
 */
public class RepxResultVO {

    private String content;//匹配到的关键字
    private String intent_id;//匹配到的 意图id
    private Integer length;//关键字配到的长度

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getIntent_id() {
        return intent_id;
    }

    public void setIntent_id(String intent_id) {
        this.intent_id = intent_id;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }
}

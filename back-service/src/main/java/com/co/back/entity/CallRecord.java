package com.co.back.entity;

import java.util.Date;

public class CallRecord {
    private Long id;

    private String call_number;

    private String resource;

    private String call_batch;

    private Integer call_stauts;

    private Integer senceID;

    private Date create_time;

    private String call_data;

    private String call_msg;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCall_number() {
        return call_number;
    }

    public void setCall_number(String call_number) {
        this.call_number = call_number == null ? null : call_number.trim();
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource == null ? null : resource.trim();
    }

    public String getCall_batch() {
        return call_batch;
    }

    public void setCall_batch(String call_batch) {
        this.call_batch = call_batch == null ? null : call_batch.trim();
    }

    public Integer getCall_stauts() {
        return call_stauts;
    }

    public void setCall_stauts(Integer call_stauts) {
        this.call_stauts = call_stauts;
    }

    public Integer getSenceID() {
        return senceID;
    }

    public void setSenceID(Integer senceID) {
        this.senceID = senceID;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public String getCall_data() {
        return call_data;
    }

    public void setCall_data(String call_data) {
        this.call_data = call_data == null ? null : call_data.trim();
    }

    public String getCall_msg() {
        return call_msg;
    }

    public void setCall_msg(String call_msg) {
        this.call_msg = call_msg == null ? null : call_msg.trim();
    }
}
package com.co.back.entity;

import java.util.Date;

public class Sence {
    private Integer id;

    private String sence_name;

    private Integer status;

    private Date createtime;

    private String sence_desc;

    private String sence_flow;

    private String sence_global;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSence_name() {
        return sence_name;
    }

    public void setSence_name(String sence_name) {
        this.sence_name = sence_name == null ? null : sence_name.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getSence_desc() {
        return sence_desc;
    }

    public void setSence_desc(String sence_desc) {
        this.sence_desc = sence_desc == null ? null : sence_desc.trim();
    }

    public String getSence_flow() {
        return sence_flow;
    }

    public void setSence_flow(String sence_flow) {
        this.sence_flow = sence_flow == null ? null : sence_flow.trim();
    }

    public String getSence_global() {
        return sence_global;
    }

    public void setSence_global(String sence_global) {
        this.sence_global = sence_global == null ? null : sence_global.trim();
    }
}
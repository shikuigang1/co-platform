package com.co.front.api.service;

import com.co.front.api.entity.Sence;

/**
 * @auther skg
 * @Date: 2019/12/5
 */
public interface SenceService {

    void insertSence(Sence sence);

    void updateSence(Sence sence);

    void insertOrUpdate(Sence sence);

}

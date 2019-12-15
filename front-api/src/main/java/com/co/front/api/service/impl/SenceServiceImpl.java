package com.co.front.api.service.impl;

import com.co.front.api.entity.Sence;
import com.co.front.api.mapper.SenceMapper;
import com.co.front.api.service.SenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @auther skg
 * @Date: 2019/12/5
 */
@Service
public class SenceServiceImpl implements SenceService {

    @Autowired
    private SenceMapper senceMapper;

    @Override
    public void insertSence(Sence sence) {
        senceMapper.insert(sence);
    }

    @Override
    public void updateSence(Sence sence) {
        senceMapper.updateByPrimaryKey(sence);
    }

    @Override
    public void insertOrUpdate(Sence sence) {

        if(sence.getId() == null){
            senceMapper.insert(sence);
        }else{
            senceMapper.updateByPrimaryKey(sence);
        }

    }
}

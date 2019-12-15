package com.co.back.service.impl;

import com.co.back.entity.Sence;
import com.co.back.mapper.SenceMapper;
import com.co.back.service.SenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @auther skg
 * @Date: 2019/12/15
 */
@Service("senceService")
public class SenceServiceImpl implements SenceService {

    @Autowired
    private SenceMapper senceMapper;

    @Override
    public Sence findSenceById(Integer SenceId) {
        return senceMapper.selectByPrimaryKey(SenceId);
    }
}

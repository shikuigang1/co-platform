package com.co.front.api.mapper;

import com.co.front.api.entity.Sence;
import java.util.List;

public interface SenceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Sence record);

    Sence selectByPrimaryKey(Integer id);

    List<Sence> selectAll();

    int updateByPrimaryKey(Sence record);
}
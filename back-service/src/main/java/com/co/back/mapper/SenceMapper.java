package com.co.back.mapper;

import com.co.back.entity.Sence;
import com.co.back.entity.SenceExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SenceMapper {
    int countByExample(SenceExample example);

    int deleteByExample(SenceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Sence record);

    int insertSelective(Sence record);

    List<Sence> selectByExampleWithBLOBs(SenceExample example);

    List<Sence> selectByExample(SenceExample example);

    Sence selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Sence record, @Param("example") SenceExample example);

    int updateByExampleWithBLOBs(@Param("record") Sence record, @Param("example") SenceExample example);

    int updateByExample(@Param("record") Sence record, @Param("example") SenceExample example);

    int updateByPrimaryKeySelective(Sence record);

    int updateByPrimaryKeyWithBLOBs(Sence record);

    int updateByPrimaryKey(Sence record);
}
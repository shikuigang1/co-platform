package com.co.back.mapper;

import com.co.back.entity.CallRecord;
import com.co.back.entity.CallRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CallRecordMapper {
    int countByExample(CallRecordExample example);

    int deleteByExample(CallRecordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CallRecord record);

    int insertSelective(CallRecord record);

    List<CallRecord> selectByExampleWithBLOBs(CallRecordExample example);

    List<CallRecord> selectByExample(CallRecordExample example);

    CallRecord selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CallRecord record, @Param("example") CallRecordExample example);

    int updateByExampleWithBLOBs(@Param("record") CallRecord record, @Param("example") CallRecordExample example);

    int updateByExample(@Param("record") CallRecord record, @Param("example") CallRecordExample example);

    int updateByPrimaryKeySelective(CallRecord record);

    int updateByPrimaryKeyWithBLOBs(CallRecord record);

    int updateByPrimaryKey(CallRecord record);
}
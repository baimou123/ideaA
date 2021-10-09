package com.xiexin.dao;

import com.xiexin.bean.SessionLog;
import com.xiexin.bean.SessionLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SessionLogDAO {
    long countByExample(SessionLogExample example);

    int deleteByExample(SessionLogExample example);

    int insert(SessionLog record);

    int insertSelective(SessionLog record);

    List<SessionLog> selectByExample(SessionLogExample example);

    int updateByExampleSelective(@Param("record") SessionLog record, @Param("example") SessionLogExample example);

    int updateByExample(@Param("record") SessionLog record, @Param("example") SessionLogExample example);
}
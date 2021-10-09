package com.xiexin.service;

import com.xiexin.bean.SessionLog;
import com.xiexin.bean.SessionLogExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SessionLogService {
   
    long countByExample(SessionLogExample example);

    int deleteByExample(SessionLogExample example);

 //   int deleteByPrimaryKey(Integer id);

    int insert(SessionLog record);

    int insertSelective(SessionLog record);

    List<SessionLog> selectByExample(SessionLogExample example);

 //   SessionLog selectByPrimaryKey(Integer id);
  
    int updateByExampleSelective(@Param("record") SessionLog record, @Param("example") SessionLogExample example);

    int updateByExample(@Param("record") SessionLog record, @Param("example") SessionLogExample example);

//    int updateByPrimaryKeySelective(SessionLog record);

//    int updateByPrimaryKey(SessionLog record);

}

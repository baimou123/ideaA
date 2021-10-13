package com.xiexin.service;

import com.xiexin.bean.Admin;
import com.xiexin.bean.AdminExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface AdminService {
   
    long countByExample(AdminExample example);

    int deleteByExample(AdminExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Admin record);

    int insertSelective(Admin record);

    List<Admin> selectByExample(AdminExample example);

    Admin selectByPrimaryKey(Integer id);
  
    int updateByExampleSelective(@Param("record") Admin record, @Param("example") AdminExample example);

    int updateByExample(@Param("record") Admin record, @Param("example") AdminExample example);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);

    List<Map> selectMore(Map map);

}

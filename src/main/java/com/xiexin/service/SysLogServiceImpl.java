package com.xiexin.service;

import com.xiexin.bean.SysLog;
import com.xiexin.bean.SysLogExample;
import com.xiexin.dao.SysLogDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("sysLogService")
public class SysLogServiceImpl implements SysLogService{
	@Autowired(required = false)
	private SysLogDAO sysLogDAO;
	public long countByExample(SysLogExample example){
    	return sysLogDAO.countByExample(example);
    }

	public int deleteByExample(SysLogExample example){
    	return sysLogDAO.deleteByExample(example);
    }

//	public int deleteByPrimaryKey(Integer id){
//    	return sysLogDAO.deleteByPrimaryKey(id);
//    }

	public int insert(SysLog record){
    	return sysLogDAO.insert(record);
    }

	public int insertSelective(SysLog record){
    	return sysLogDAO.insertSelective(record);
    }

	public List<SysLog> selectByExample(SysLogExample example){
    	return sysLogDAO.selectByExample(example);
    }

//	public SysLog selectByPrimaryKey(Integer id){
//    	return sysLogDAO.selectByPrimaryKey(id);
//    }
  
	public int updateByExampleSelective(SysLog record, SysLogExample example){
    	return sysLogDAO.updateByExampleSelective(record, example);
    }

	public int updateByExample(SysLog record, SysLogExample example){
    	return sysLogDAO.updateByExample(record, example);
    }

	public int updateByPrimaryKeySelective(SysLog record){
    	return sysLogDAO.updateByPrimaryKeySelective(record);
    }

	public int updateByPrimaryKey(SysLog record){
    	return sysLogDAO.updateByPrimaryKey(record);
    }


}

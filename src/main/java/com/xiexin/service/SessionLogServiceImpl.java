package com.xiexin.service;

import com.xiexin.bean.SessionLog;
import com.xiexin.bean.SessionLogExample;
import com.xiexin.dao.SessionLogDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("sessionLogService")
public class SessionLogServiceImpl implements SessionLogService{
	@Autowired(required = false)
	private SessionLogDAO sessionLogDAO;
	public long countByExample(SessionLogExample example){
    	return sessionLogDAO.countByExample(example);
    }

	public int deleteByExample(SessionLogExample example){
    	return sessionLogDAO.deleteByExample(example);
    }

//	public int deleteByPrimaryKey(Integer id){
//    	return sessionLogDAO.deleteByPrimaryKey(id);
//    }

	public int insert(SessionLog record){
    	return sessionLogDAO.insert(record);
    }

	public int insertSelective(SessionLog record){
    	return sessionLogDAO.insertSelective(record);
    }

	public List<SessionLog> selectByExample(SessionLogExample example){
    	return sessionLogDAO.selectByExample(example);
    }

//	public SessionLog selectByPrimaryKey(Integer id){
//    	return sessionLogDAO.selectByPrimaryKey(id);
//				}
//
	public int updateByExampleSelective(SessionLog record, SessionLogExample example){
    	return sessionLogDAO.updateByExampleSelective(record, example);
    }

	public int updateByExample(SessionLog record, SessionLogExample example){
    	return sessionLogDAO.updateByExample(record, example);
    }

//	public int updateByPrimaryKeySelective(SessionLog record){
//    	return sessionLogDAO.updateByPrimaryKeySelective(record);
//    }
//
//	public int updateByPrimaryKey(SessionLog record){
//    	return sessionLogDAO.updateByPrimaryKey(record);
//    }


}

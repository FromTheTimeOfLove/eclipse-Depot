package com.datadriver.web.system.dao;

import com.datadriver.core.generic.GenericDao;
import com.datadriver.web.system.model.SystemUser;

public interface SystemUserMapper extends GenericDao<SystemUser, Long> {
	int deleteByPrimaryKey(String userId);
	
	int insert(SystemUser record);
	
	SystemUser selectByPrimaryKey(String userId);
	
	int updateByPrimaryKeySelective(SystemUser record);
	
	int updateByPrimaryKey(SystemUser record);
	
	SystemUser selectByUserName(String userName);
	
	SystemUser selectByUserNameAndPw(SystemUser record);
}
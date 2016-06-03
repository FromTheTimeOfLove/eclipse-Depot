package com.datadriver.web.system.dao;

import java.util.List;

import com.datadriver.core.generic.GenericDao;
import com.datadriver.web.system.model.SystemRole;

public interface SystemRoleMapper extends GenericDao<SystemRole, Long> {
	int deleteByPrimaryKey(String userId);
	
	int insert(SystemRole record);
	
	SystemRole selectByPrimaryKey(String userId);
	
	int updateByPrimaryKeySelective(SystemRole record);
	
	int updateByPrimaryKey(SystemRole record);
	
	List<SystemRole> selectRolesByUserId(String userId);
}
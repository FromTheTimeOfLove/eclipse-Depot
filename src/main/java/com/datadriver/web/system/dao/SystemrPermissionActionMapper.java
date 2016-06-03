package com.datadriver.web.system.dao;

import java.util.HashMap;
import java.util.List;

import com.datadriver.core.generic.GenericDao;
import com.datadriver.web.system.model.SystemPermissionAction;

public interface SystemrPermissionActionMapper extends GenericDao<SystemPermissionAction, Long> {
	int deleteByPrimaryKey(String userId);
	
	int insert(SystemPermissionAction record);
	
	SystemPermissionAction selectByPrimaryKey(String userId);
	
	int updateByPrimaryKey(SystemPermissionAction record);
	
	List<SystemPermissionAction> selectByRoleId(String roleId);
	
	List<SystemPermissionAction> selectByUserId(String userId);
	
	List<SystemPermissionAction> selectBySelective(HashMap<String, String> record);
}
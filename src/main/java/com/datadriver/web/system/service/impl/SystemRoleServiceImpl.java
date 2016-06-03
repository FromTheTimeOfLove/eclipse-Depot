package com.datadriver.web.system.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.datadriver.core.generic.GenericDao;
import com.datadriver.core.generic.GenericServiceImpl;
import com.datadriver.web.system.dao.SystemRoleMapper;
import com.datadriver.web.system.model.SystemRole;
import com.datadriver.web.system.service.SystemRoleService;

/**
 * 角色Service实现类
 */
@Service
public class SystemRoleServiceImpl extends GenericServiceImpl<SystemRole, Long> implements SystemRoleService {
	
	@Resource
	private SystemRoleMapper	systemRoleMapper;
	
	@Override
	public GenericDao<SystemRole, Long> getDao() {
		return systemRoleMapper;
	}
	
	@Override
	public List<SystemRole> selectRolesByUserId(String userId) {
		return systemRoleMapper.selectRolesByUserId(userId);
	}
	
}

package com.datadriver.web.system.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.datadriver.core.entity.UnitedException;
import com.datadriver.core.generic.GenericDao;
import com.datadriver.core.generic.GenericServiceImpl;
import com.datadriver.web.system.dao.SystemrPermissionActionMapper;
import com.datadriver.web.system.model.SystemPermissionAction;
import com.datadriver.web.system.service.SystemPermissionActionService;

/**
 * 权限Service实现类
 *
 * @author StarZou
 * @since 2014年6月10日 下午12:05:03
 */
@Service
public class SystemPermissionActionServiceImpl extends GenericServiceImpl<SystemPermissionAction, Long> implements SystemPermissionActionService {
	
	@Resource
	private SystemrPermissionActionMapper	systemrPermissionActionMapper;
	
	@Override
	public GenericDao<SystemPermissionAction, Long> getDao() {
		return systemrPermissionActionMapper;
	}
	
	@Override
	public List<SystemPermissionAction> selectPermissionsByRoleId(String roleId) {
		return systemrPermissionActionMapper.selectByRoleId(roleId);
	}
	
	@Override
	public List<SystemPermissionAction> selectPermissionsByUserId(String userId) {
		return systemrPermissionActionMapper.selectByUserId(userId);
	}
	
	@Override
	public List<SystemPermissionAction> selectMenuByRoleId(String roleId) throws UnitedException {
		HashMap<String, String> paramHashMap = new HashMap<String, String>();
		paramHashMap.put("actionType", "mu");
		paramHashMap.put("roleId", roleId);
		return systemrPermissionActionMapper.selectBySelective(paramHashMap);
	}
	
	@Override
	public List<SystemPermissionAction> selectMenuByUserId(String userId) throws UnitedException {
		HashMap<String, String> paramHashMap = new HashMap<String, String>();
		paramHashMap.put("actionType", "PAGE.PERMISSION.TYPE.MU");
		paramHashMap.put("userId", userId);
		return systemrPermissionActionMapper.selectBySelective(paramHashMap);
	}
}

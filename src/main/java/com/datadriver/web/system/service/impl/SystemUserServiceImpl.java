package com.datadriver.web.system.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.datadriver.core.entity.UnitedException;
import com.datadriver.core.generic.GenericDao;
import com.datadriver.core.generic.GenericServiceImpl;
import com.datadriver.web.system.dao.SystemUserMapper;
import com.datadriver.web.system.model.SystemUser;
import com.datadriver.web.system.service.SystemUserService;

/**
 * 用户Service实现类
 */
@Service
public class SystemUserServiceImpl extends GenericServiceImpl<SystemUser, Long> implements SystemUserService {
	
	@Resource
	private SystemUserMapper	systemUserMapper;
	
	@Override
	public SystemUser selectByUsername(String userName) throws UnitedException {
		if (userName == null || ("").equals(userName.trim())) {
			throw new UnitedException("MSG.20001");
		}
		return systemUserMapper.selectByUserName(userName);
	}
	
	@Override
	public SystemUser selectByUserNameAndPw(String userName, String passwd) throws UnitedException {
		if (userName == null || ("").equals(userName.trim())) {
			throw new UnitedException("MSG.20001");
		}
		if (passwd == null || ("").equals(passwd.trim())) {
			throw new UnitedException("MSG.20002");
		}
		SystemUser tempUser = new SystemUser();
		tempUser.setUserLoginName(userName);
		tempUser.setUserPassword(passwd);
		return systemUserMapper.selectByUserNameAndPw(tempUser);
	}
	
	@Override
	public GenericDao<SystemUser, Long> getDao() {
		return systemUserMapper;
	}
	
}

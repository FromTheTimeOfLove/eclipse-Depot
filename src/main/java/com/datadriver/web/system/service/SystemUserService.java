package com.datadriver.web.system.service;

import com.datadriver.core.entity.UnitedException;
import com.datadriver.core.generic.GenericService;
import com.datadriver.web.system.model.SystemUser;

/**
 * @ClassName: SystemUserService
 * @Description: 用户 业务 接口
 * @date 2015年11月23日 上午10:57:18
 */
public interface SystemUserService extends GenericService<SystemUser, Long> {
	
	/**
	 * 根据用户名查询用户
	 * 
	 * @param username
	 * @return
	 */
	SystemUser selectByUsername(String username) throws UnitedException;
	
	/**
	 * @Title: selectByUserNameAndPw
	 * @Description: 根据登录名和密码查询用户
	 * @param @param username
	 * @param @param passwd
	 * @param @return 设定文件
	 * @return SystemUser 返回类型
	 * @throws
	 */
	SystemUser selectByUserNameAndPw(String username, String passwd) throws UnitedException;
	
}

package com.datadriver.web.system.service;

import java.util.List;

import com.datadriver.core.generic.GenericService;
import com.datadriver.web.system.model.SystemRole;

/**
 * 角色 业务接口
 **/
public interface SystemRoleService extends GenericService<SystemRole, Long> {
	/**
	 * @Title: selectRolesByUserId
	 * @Description: 通过用户id查询用户 拥有的角色
	 * @param @param userId
	 * @param @return 设定文件
	 * @return List<SystemRole> 返回类型
	 * @throws
	 */
	List<SystemRole> selectRolesByUserId(String userId);
}

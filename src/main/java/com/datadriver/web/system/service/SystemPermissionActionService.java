package com.datadriver.web.system.service;

import java.util.List;

import com.datadriver.core.entity.UnitedException;
import com.datadriver.core.generic.GenericService;
import com.datadriver.web.system.model.SystemPermissionAction;

/**
 * 权限 业务接口
 * 
 * @author StarZou
 * @since 2014年6月10日 下午12:02:39
 **/
public interface SystemPermissionActionService extends GenericService<SystemPermissionAction, Long> {
	
	/**
	 * @Title: selectPermissionsByRoleId
	 * @Description:通过角色id 查询角色 拥有的权限
	 * @param @param roleId
	 * @param @return 设定文件
	 * @return List<SystemPermissionAction> 返回类型
	 * @throws
	 */
	List<SystemPermissionAction> selectPermissionsByRoleId(String roleId) throws UnitedException;
	
	/**
	 * @Title: selectPermissionsByUserId
	 * @Description: 通过用户id 查询角色 拥有的权限
	 * @param @param userId
	 * @param @return 设定文件
	 * @return List<SystemPermissionAction> 返回类型
	 * @throws
	 */
	List<SystemPermissionAction> selectPermissionsByUserId(String userId) throws UnitedException;
	
	/**
	 * @Title: selectMenuByUserId
	 * @Description: 通过角色id 查询角色 拥有的菜单权限
	 * @param @param userId
	 * @param @return 设定文件
	 * @return List<SystemPermissionAction> 返回类型
	 * @throws
	 */
	List<SystemPermissionAction> selectMenuByRoleId(String roleId) throws UnitedException;
	
	/**
	 * @Title: selectMenuByUserId
	 * @Description: 通过用户id 查询角色 拥有的菜单权限
	 * @param @param userId
	 * @param @return 设定文件
	 * @return List<SystemPermissionAction> 返回类型
	 * @throws
	 */
	List<SystemPermissionAction> selectMenuByUserId(String userId) throws UnitedException;
	
}

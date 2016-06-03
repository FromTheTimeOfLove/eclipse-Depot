package com.datadriver.web.role.service;

import java.util.List;

import com.datadriver.core.entity.UnitedException;
import com.datadriver.core.generic.GenericService;
import com.datadriver.web.role.dto.RoleDto;
import com.datadriver.web.role.model.Role;
import com.datadriver.web.role.model.RoleAndPermissionZtreeNode;
import com.github.pagehelper.PageInfo;

/**
 * @ClassName: RoleService
 * @Description: 业务 接口
 */
public interface RoleService extends GenericService<Role, Long> {

	/**
	 * 根据角色名称查询
	 * 
	 * @param roleDto
	 * @return
	 */
	PageInfo<Role> selectPageByRoleName(RoleDto roleDto) throws UnitedException;

	/**
	 * 查询角色的所有权限
	 * 
	 * @param roleDto
	 *            传递角色ID
	 * @return 符合zTree结构的权限列表
	 * @throws UnitedException
	 */
	List<RoleAndPermissionZtreeNode> findPermissionTree(RoleDto roleDto)
			throws UnitedException;

	/**
	 * 保存角色的权限
	 * 
	 * @param roleDto
	 *            传递角色ID和它所拥有的权限ID
	 * @throws UnitedException
	 */
	void saveRolePermission(RoleDto roleDto) throws UnitedException;

	/**
	 * 判断数据库中是否存在角色名称
	 * 
	 * @param username
	 * @param type
	 * @return
	 */
	int findUserRole(Role role, String type);

}

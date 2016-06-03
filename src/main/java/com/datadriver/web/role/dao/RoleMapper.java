package com.datadriver.web.role.dao;

import java.util.List;

import com.datadriver.core.entity.UnitedException;
import com.datadriver.core.generic.GenericDao;
import com.datadriver.web.role.dto.RoleDto;
import com.datadriver.web.role.model.Role;
import com.datadriver.web.role.model.RoleAndPermissionZtreeNode;

public interface RoleMapper extends GenericDao<Role, Long> {

	List<Role> selectPageByRoleName(Object userName);

	int insert(Role record);

	int updateByPrimaryKeySelective(Role record);

	Role selectByPrimaryKey(String roleId);

	int deleteByPrimaryKey(String roleId);

	List<RoleAndPermissionZtreeNode> findPermissionTree(RoleDto roleDto)
			throws UnitedException;

	void deleteRolePermission(RoleDto paramDto);

	void saveRolePermission(List<RoleDto> list);

	int findRoleInsert(Role role);

	int findRoleUpdate(Role role);
}

package com.datadriver.web.role.dto;

import com.datadriver.core.generic.GenericDto;

public class RoleDto extends GenericDto {

	/**
	 * 角色ID
	 */
	private String roleId;
	/**
	 * 角色名称
	 */
	private String roleName;
	
	/**
	 * 角色状态 0:启用  1:禁用
	 */
	private String roleStatus;
	
	/**
	 * 角色分组
	 */
	private String roleGroup;
	
	/**
	 * 角色备注
	 */
	private String roleRemark;
	/**
	 * 用户ID
	 */
	private String userId;
	/**
	 * 权限ID
	 */
	private String permissionId;
	/**
	 * 权限ID数组
	 */
	private String[] permissionIdArr;
	/**
	 * 权限标识
	 */
	private String authority;

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleStatus() {
		return roleStatus;
	}

	public void setRoleStatus(String roleStatus) {
		this.roleStatus = roleStatus;
	}

	public String getRoleGroup() {
		return roleGroup;
	}

	public void setRoleGroup(String roleGroup) {
		this.roleGroup = roleGroup;
	}

	public String getRoleRemark() {
		return roleRemark;
	}

	public void setRoleRemark(String roleRemark) {
		this.roleRemark = roleRemark;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(String permissionId) {
		this.permissionId = permissionId;
	}

	public String[] getPermissionIdArr() {
		return permissionIdArr;
	}

	public void setPermissionIdArr(String[] permissionIdArr) {
		this.permissionIdArr = permissionIdArr;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
	
}

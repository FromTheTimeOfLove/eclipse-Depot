package com.datadriver.web.role.model;

/**
 * @ClassName: Role
 * @Description: 角色类
 */
public class Role {
	
	/**
	 * 主键ID
	 */
	private String	roleId;
	
	/**
	 * 角色名称
	 */
	private String	roleName;
	
	/**
	 * 角色状态 0:启用 1:禁用
	 */
	private String	roleStatus;
	
	/**
	 * 角色分组
	 */
	private String	roleGroup;
	
	/**
	 * 角色备注
	 */
	private String	roleRemark;
	
	public String getRoleId() {
		return roleId;
	}
	
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	
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
	
}

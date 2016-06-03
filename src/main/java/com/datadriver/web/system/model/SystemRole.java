package com.datadriver.web.system.model;

/**
 * @ClassName: SystemRole
 * @Description: 系统角色
 * @date 2015年11月23日 上午10:26:15
 */
public class SystemRole {
	/**
	 * 角色主键ID
	 */
	private String	roleId;
	/**
	 * 角色名称
	 */
	private String	roleName;
	/**
	 * 角色状态
	 */
	private String	roleStatus;
	/**
	 * 角色组名
	 */
	private String	roleGroup;
	/**
	 * 角色备注
	 */
	private String	roleRemark;
	/**
	 * 是否系统默认(默认的系统角色不允许修改)
	 */
	private String	isSystemDefault;
	
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
	
	public String getIsSystemDefault() {
		return isSystemDefault;
	}
	
	public void setIsSystemDefault(String isSystemDefault) {
		this.isSystemDefault = isSystemDefault;
	}
	
}

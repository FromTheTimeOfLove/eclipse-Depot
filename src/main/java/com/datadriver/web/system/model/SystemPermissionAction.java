package com.datadriver.web.system.model;

/**
 * @ClassName: SystemPermissionAction
 * @Description: 系统权限资源
 */
public class SystemPermissionAction {
	/**
	 * 主键ID
	 */
	private String					actionId;
	/**
	 * 权限资源名称
	 */
	private String					actionName;
	/**
	 * 权限资源代码
	 */
	private String					actionCode;
	/**
	 * 权限资源类型
	 */
	private String					actionType;
	/**
	 * 权限资源链接URL
	 */
	private String					actionUrl;
	/**
	 * 父权限资源ID
	 */
	private String					actionParentId;
	
	/**
	 * 备注
	 */
	private String					actionRemark;
	
	/**
	 * 图标路径(相对路径)
	 */
	private String					actionIcon;
	/**
	 * 排序
	 */
	private String					actionPin;
	/**
	 * 样式
	 */
	private String					actionClassName;
	
	/**
	 * 状态
	 */
	private String					actionStatus;
	
	/**
	 * 父权限资源对象
	 */
	private SystemPermissionAction	parentAction;
	
	public String getActionId() {
		return actionId;
	}
	
	public void setActionId(String actionId) {
		this.actionId = actionId;
	}
	
	public String getActionName() {
		return actionName;
	}
	
	public void setActionName(String actionName) {
		this.actionName = actionName;
	}
	
	public String getActionCode() {
		return actionCode;
	}
	
	public void setActionCode(String actionCode) {
		this.actionCode = actionCode;
	}
	
	public String getActionType() {
		return actionType;
	}
	
	public void setActionType(String actionType) {
		this.actionType = actionType;
	}
	
	public String getActionUrl() {
		return actionUrl;
	}
	
	public void setActionUrl(String actionUrl) {
		this.actionUrl = actionUrl;
	}
	
	public String getActionParentId() {
		return actionParentId;
	}
	
	public void setActionParentId(String actionParentId) {
		this.actionParentId = actionParentId;
	}
	
	public SystemPermissionAction getParentAction() {
		return parentAction;
	}
	
	public void setParentAction(SystemPermissionAction parentAction) {
		this.parentAction = parentAction;
	}
	
	public String getActionRemark() {
		return actionRemark;
	}
	
	public void setActionRemark(String actionRemark) {
		this.actionRemark = actionRemark;
	}
	
	public String getActionIcon() {
		return actionIcon;
	}
	
	public void setActionIcon(String actionIcon) {
		this.actionIcon = actionIcon;
	}
	
	public String getActionPin() {
		return actionPin;
	}
	
	public void setActionPin(String actionPin) {
		this.actionPin = actionPin;
	}
	
	public String getActionClassName() {
		return actionClassName;
	}
	
	public void setActionClassName(String actionClassName) {
		this.actionClassName = actionClassName;
	}
	
	public String getActionStatus() {
		return actionStatus;
	}
	
	public void setActionStatus(String actionStatus) {
		this.actionStatus = actionStatus;
	}
	
}

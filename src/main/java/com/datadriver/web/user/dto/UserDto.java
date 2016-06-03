package com.datadriver.web.user.dto;

import com.datadriver.core.generic.GenericDto;

public class UserDto extends GenericDto{
	/**
	 * 用户名称
	 */
	private String uname;
	
	/**
	 * 登录名
	 */
	private String userName;
	
	/**
	 * 状态
	 */
	private String userStatus;
	
	/**
	 * 用户类型
	 */
	private String userType;
	
	/**
	 * 是否离职【0：在职，1：离职】
	 */
	private String leave;
	
	/**
	 * 用户ID
	 */
	private String userId;
	
	/**
	 * 工号
	 */
	private String workNumber;
	/**
	 * 旧密码
	 */
	private String oldPassword;
	/**
	 * 新密码
	 */
	private String newPassword;
	/**
	 * 确认新密码
	 */
	private String confirmPassword;


	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getLeave() {
		return leave;
	}

	public void setLeave(String leave) {
		this.leave = leave;
	}

	public String getWorkNumber() {
		return workNumber;
	}

	public void setWorkNumber(String workNumber) {
		this.workNumber = workNumber;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
}

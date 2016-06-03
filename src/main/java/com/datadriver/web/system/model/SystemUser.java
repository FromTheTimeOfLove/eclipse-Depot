package com.datadriver.web.system.model;

/**
 * @ClassName: SystemUser
 * @Description: 系统用户
 * @date 2015年11月23日 上午10:13:13
 */
public class SystemUser {
	/**
	 * 用户主键ID
	 */
	private String	userId;
	/**
	 * 用户姓名
	 */
	private String	userName;
	/**
	 * 用户登录名
	 */
	private String	userLoginName;
	/**
	 * 用户密码
	 */
	private String	userPassword;
	/**
	 * 用户唯一代码(例如工号)
	 */
	private String	userAuthCode;
	/**
	 * 用户类型
	 */
	private String	userType;
	/**
	 * 用户状态(例删除)
	 */
	private String	userStatus;
	/**
	 * 是否离职
	 */
	private String	isLeave;
	
	/**
	 * 备注
	 */
	private String	remark;
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getUserLoginName() {
		return userLoginName;
	}
	
	public void setUserLoginName(String userLoginName) {
		this.userLoginName = userLoginName;
	}
	
	public String getUserPassword() {
		return userPassword;
	}
	
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	public String getUserAuthCode() {
		return userAuthCode;
	}
	
	public void setUserAuthCode(String userAuthCode) {
		this.userAuthCode = userAuthCode;
	}
	
	public String getUserType() {
		return userType;
	}
	
	public void setUserType(String userType) {
		this.userType = userType;
	}
	
	public String getUserStatus() {
		return userStatus;
	}
	
	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}
	
	public String getIsLeave() {
		return isLeave;
	}
	
	public void setIsLeave(String isLeave) {
		this.isLeave = isLeave;
	}
	
	public String getRemark() {
		return remark;
	}
	
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}

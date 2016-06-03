package com.datadriver.web.user.model;

/**
 * @ClassName: User
 * @Description: 用户类
 */
public class User {

	/**
	 * 用户ID
	 */
	private String userId;
	
	/**
	 * 用户名称
	 */
	private String uname;
	
	/**
	 * 登录名
	 */
	private String userName;
	
	/**
	 * 登录密码
	 */
	private String userPass;
	
	/**
	 * 备注
	 */
	private String userRemark;
	
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
	 * 工号
	 */
	private String workNumber;
	/**
	 * 职位
	 */
	private String vcPosition;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	

	

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

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	public String getUserRemark() {
		return userRemark;
	}

	public void setUserRemark(String userRemark) {
		this.userRemark = userRemark;
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

	public String getVcPosition() {
		return vcPosition;
	}

	public void setVcPosition(String vcPosition) {
		this.vcPosition = vcPosition;
	}
	
	
}

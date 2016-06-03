package com.datadriver.web.system.dto;

/**
 * @ClassName: LoginDto
 * @Description: 登录使用的DTO对象
 * @date 2015年11月23日 上午11:28:03
 */
public class LoginDto {
	/**
	 * 登录所用帐号
	 */
	private String	loginAccount;
	/**
	 * 登录密码
	 */
	private String	loginPw;
	/**
	 * 其他校验(验证码等信息)
	 */
	private String	loginAuthCode;
	
	/**
	 * 登录类型
	 */
	private String	loginType;
	
	public String getLoginAccount() {
		return loginAccount;
	}
	
	public void setLoginAccount(String loginAccount) {
		this.loginAccount = loginAccount;
	}
	
	public String getLoginPw() {
		return loginPw;
	}
	
	public void setLoginPw(String loginPw) {
		this.loginPw = loginPw;
	}
	
	public String getLoginAuthCode() {
		return loginAuthCode;
	}
	
	public void setLoginAuthCode(String loginAuthCode) {
		this.loginAuthCode = loginAuthCode;
	}
	
	public String getLoginType() {
		return loginType;
	}
	
	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}
	
}

package com.datadriver.core.entity;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.support.RequestContext;

@SuppressWarnings("serial")
public class UnitedException extends Exception {
	/**
	 * 错误代码
	 */
	private String	errorCcode;
	
	/**
	 * 错误信息
	 */
	private String	errorMessage;
	
	public UnitedException(Throwable cause) {
		super(cause);
	}
	
	public UnitedException(String errorMessage, Throwable cause) {
		super(errorMessage, cause);
	}
	
	public UnitedException(String errorCcode) {
		super(errorCcode);
		this.errorCcode = errorCcode;
	}
	
	public String getErrorCode() {
		return errorCcode;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	/**
	 * @Title: getErrorMessage
	 * @Description: 错误代码对应的信息描述
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	public String loadErrorMessageByCode(HttpServletRequest request) {
		String errorMessage = null;
		RequestContext requestContext = new RequestContext(request);// 国际化
		errorMessage = requestContext.getMessage(errorCcode);
		return errorMessage;
	}
	
}

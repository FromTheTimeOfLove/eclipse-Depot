package com.datadriver.web.common.model;

/**
 * @ClassName: DataDictionary
 * @Description: 数据字典下拉列表
 */
public class DataDictionary {
	/**
	 * 编码值
	 */
	private String	code;
	/**
	 * 对应的显示名称
	 */
	private String	display;
	/**
	 * 类型
	 */
	private String	type;
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getDisplay() {
		return display;
	}
	
	public void setDisplay(String display) {
		this.display = display;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
}

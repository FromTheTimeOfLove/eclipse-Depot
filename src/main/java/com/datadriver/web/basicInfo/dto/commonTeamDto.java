package com.datadriver.web.basicInfo.dto;

import com.datadriver.core.generic.GenericDto;

public class commonTeamDto extends GenericDto {
	private String teamType;// team type
	
	private String foreignKey;//外键标识
	
	private String contentName;//属性
	
	private String contentValue;//值

	public String getTeamType() {
		return teamType;
	}

	public void setTeamType(String teamType) {
		this.teamType = teamType;
	}

	public String getForeignKey() {
		return foreignKey;
	}

	public void setForeignKey(String foreignKey) {
		this.foreignKey = foreignKey;
	}

	public String getContentName() {
		return contentName;
	}

	public void setContentName(String contentName) {
		this.contentName = contentName;
	}

	public String getContentValue() {
		return contentValue;
	}

	public void setContentValue(String contentValue) {
		this.contentValue = contentValue;
	}
	
	
}

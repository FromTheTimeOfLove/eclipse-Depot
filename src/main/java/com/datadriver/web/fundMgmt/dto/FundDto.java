package com.datadriver.web.fundMgmt.dto;

import com.datadriver.core.generic.GenericDto;

public class FundDto extends GenericDto {
	private String fundName;

	public String getFundName() {
		return fundName;
	}

	public void setFundName(String fundName) {
		this.fundName = fundName;
	}
}

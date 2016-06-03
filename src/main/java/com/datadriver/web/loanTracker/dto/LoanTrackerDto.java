package com.datadriver.web.loanTracker.dto;

import com.datadriver.core.generic.GenericDto;

/**
 * 
 * @Acthor：hurentao
 * @ClassName: LoanTrackerDto
 * @Description: 查询条件实体
 * @Date 2016-4-14 上午9:51:45
 */
public class LoanTrackerDto extends GenericDto {
	private String fundId;

	public String getFundId() {
		return fundId;
	}

	public void setFundId(String fundId) {
		this.fundId = fundId;
	}
	
	
}

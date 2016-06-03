package com.datadriver.web.equityInvestment.dto;

import com.datadriver.core.generic.GenericDto;

public class EquityInvestmentDto extends GenericDto {
	private String	portfolioNameCH;	// 投资组合名称（中文）
										
	private String	stageId;			// 阶段 标识
										
	private String	sectorId;			// 区域标识
										
	private String	fundId;				// 基金标识
										
	public String getPortfolioNameCH() {
		return portfolioNameCH;
	}
	
	public void setPortfolioNameCH(String portfolioNameCH) {
		this.portfolioNameCH = portfolioNameCH;
	}
	
	public String getStageId() {
		return stageId;
	}
	
	public void setStageId(String stageId) {
		this.stageId = stageId;
	}
	
	public String getSectorId() {
		return sectorId;
	}
	
	public void setSectorId(String sectorId) {
		this.sectorId = sectorId;
	}
	
	public String getFundId() {
		return fundId;
	}
	
	public void setFundId(String fundId) {
		this.fundId = fundId;
	}
	
}

package com.datadriver.web.basicExit.dto;

import com.datadriver.core.generic.GenericDto;
/**
 * 
 * @Acthor：hurentao
 * @ClassName: BasicExitDto
 * @Description: 查询条件类
 * @Date 2016-4-12 上午11:45:57
 */
public class BasicExitDto extends GenericDto {
	private String portfolioNameCH;// 投资组合名称（中文）
	private String sectorId;// 领域标识
	private String fundId;// 基金标识
	private String stageId;// 阶段标识
	public String getPortfolioNameCH() {
		return portfolioNameCH;
	}
	public void setPortfolioNameCH(String portfolioNameCH) {
		this.portfolioNameCH = portfolioNameCH;
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
	public String getStageId() {
		return stageId;
	}
	public void setStageId(String stageId) {
		this.stageId = stageId;
	}
	
}

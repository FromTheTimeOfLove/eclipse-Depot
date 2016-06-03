package com.datadriver.web.basicExit.model;

/**
 * 
 * @Acthor：hurentao
 * @ClassName: BasicExit
 * @Description: 实体类
 * @Date 2016-4-13 下午3:18:44
 */
public class BasicExit {
	private String basicExitId;//标识
	private String portfolioNameCH;// 投资组合名称（中文）
	private String portfolioNameEN;// 投资组合名称（英文）
	private String sectorName;// 领域名称
	private String sectorId;// 领域标识
	private String fundName;// 基金名称
	private String fundId;// 基金标识
	private String stageName;// 阶段名称
	private String stageId;// 阶段标识
	private String typeName;// 类型名称
	private String typeId;// 类型标识
	private String proceedsAmount;// Amount of Proceeds
	private String afterSold;// Ownership after sold
	private String reducedInvestcost;// Reduced investment cost
	private String dateSold;//  Date of sold
	private String signDate; // 注册日期
	private String dealPartnerOne;// 交易伙伴1
	private String dealPartnerTwo;// 交易伙伴2
	private String dealPartnerThi;// 交易伙伴3
	private String countSize="0";//明细数量
	
	private String paperId;//关联项ID

	public BasicExit() {
		super();
	}
	
	public BasicExit(String basicExitId, String portfolioNameCH,
			String portfolioNameEN, String sectorName, String fundName,
			String stageName, String typeName, String proceedsAmount,
			String reducedInvestcost, String dateSold,String afterSold,
			String signDate) {
		super();
		this.basicExitId = basicExitId;
		this.portfolioNameCH = portfolioNameCH;
		this.portfolioNameEN = portfolioNameEN;
		this.sectorName = sectorName;
		this.fundName = fundName;
		this.stageName = stageName;
		this.typeName = typeName;
		this.proceedsAmount = proceedsAmount;
		this.reducedInvestcost = reducedInvestcost;
		this.dateSold = dateSold;
		this.afterSold = afterSold;
		this.setSignDate(signDate);
	}

	public String getBasicExitId() {
		return basicExitId;
	}
	public void setBasicExitId(String basicExitId) {
		this.basicExitId = basicExitId;
	}
	public String getPortfolioNameCH() {
		return portfolioNameCH;
	}
	public void setPortfolioNameCH(String portfolioNameCH) {
		this.portfolioNameCH = portfolioNameCH;
	}
	public String getPortfolioNameEN() {
		return portfolioNameEN;
	}
	public void setPortfolioNameEN(String portfolioNameEN) {
		this.portfolioNameEN = portfolioNameEN;
	}
	public String getSectorName() {
		return sectorName;
	}
	public void setSectorName(String sectorName) {
		this.sectorName = sectorName;
	}
	public String getSectorId() {
		return sectorId;
	}
	public void setSectorId(String sectorId) {
		this.sectorId = sectorId;
	}
	public String getFundName() {
		return fundName;
	}
	public void setFundName(String fundName) {
		this.fundName = fundName;
	}
	public String getFundId() {
		return fundId;
	}
	public void setFundId(String fundId) {
		this.fundId = fundId;
	}
	public String getStageName() {
		return stageName;
	}
	public void setStageName(String stageName) {
		this.stageName = stageName;
	}
	public String getStageId() {
		return stageId;
	}
	public void setStageId(String stageId) {
		this.stageId = stageId;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getTypeId() {
		return typeId;
	}
	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}
	public String getProceedsAmount() {
		return proceedsAmount;
	}
	public void setProceedsAmount(String proceedsAmount) {
		this.proceedsAmount = proceedsAmount;
	}
	public String getReducedInvestcost() {
		return reducedInvestcost;
	}
	public void setReducedInvestcost(String reducedInvestcost) {
		this.reducedInvestcost = reducedInvestcost;
	}
	public String getDateSold() {
		return dateSold;
	}
	public void setDateSold(String dateSold) {
		this.dateSold = dateSold;
	}

	public String getDealPartnerOne() {
		return dealPartnerOne;
	}

	public void setDealPartnerOne(String dealPartnerOne) {
		this.dealPartnerOne = dealPartnerOne;
	}

	public String getDealPartnerTwo() {
		return dealPartnerTwo;
	}

	public void setDealPartnerTwo(String dealPartnerTwo) {
		this.dealPartnerTwo = dealPartnerTwo;
	}

	public String getDealPartnerThi() {
		return dealPartnerThi;
	}

	public void setDealPartnerThi(String dealPartnerThi) {
		this.dealPartnerThi = dealPartnerThi;
	}

	public String getCountSize() {
		return countSize;
	}

	public void setCountSize(String countSize) {
		this.countSize = countSize;
	}
	
	public String getAfterSold() {
		return afterSold;
	}

	public void setAfterSold(String afterSold) {
		this.afterSold = afterSold;
	}

	public void setSignDate(String signDate) {
		this.signDate = signDate;
	}

	public String getSignDate() {
		return signDate;
	}

	public void setPaperId(String paperId) {
		this.paperId = paperId;
	}

	public String getPaperId() {
		return paperId;
	}

}

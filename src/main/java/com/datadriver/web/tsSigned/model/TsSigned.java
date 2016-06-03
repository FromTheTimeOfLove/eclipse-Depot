package com.datadriver.web.tsSigned.model;


/**
 * 
 * @Acthor：hurentao
 * @ClassName: TsSigned
 * @Description: 实体类
 * @Date 2016-4-12 上午11:34:02
 */
public class TsSigned {
	private String tsSignedId;//标识
	private String paperId; //oper ID
	private String portfolioNameCH;// 投资组合名称（中文）
	private String portfolioNameEN;// 投资组合名称（英文）
	private String investmentAmount;// 投资金额
	private String bridgeLoan;	//是否过桥贷款
	private String bridgeLoanRemark;
	private String investDate; //投资时间
	private String amount;	//金额
	private String signDate; //注册日期
	private String sectorName;// 领域名称
	private String sectorId;// 领域标识
	private String fundName;// 基金名称
	private String fundId;// 基金标识
	private String stageName;// 阶段名称
	private String stageId;// 阶段标识
	private String dealPartnerOne;// 交易伙伴1
	private String dealPartnerTwo;// 交易伙伴2
	private String dealPartnerThi;// 交易伙伴3
	private String boardDirector;// 董事会
	private String boarDirectoRemark;//董事局备注
	private String ownerShip;// 所有权
	private String ownerShipRemark;//所有权备注
	private String preference;// 清算优先权
	private String preferenceRemark;// 清算优先权备注
	private String redemption; //赎回
	private String redemptionRemark;//赎回备注
	private String typeName;// 类型名称
	private String typeId;// 类型标识
	private String typeSecurityName;// 安全类型名称
	private String typeSecurityId;// 安全类型名称
	private String LiquidationPreference;// 清算债券人
	private String countSize="0";//明细数量
	private String thruDate;//删除字段0标示未删除 1标示删除
	private String attachmentid;// 附件Id
	private String attachmentname;// 附件名称
	private String attachmentload;
	public TsSigned() {
		super();
	}
	
	public TsSigned(String tsSignedId, String portfolioNameCH, String portfolioNameEN,
			String investmentAmount, String sectorName, String fundName,
			String stageName, String typeSecurityName, String signDate) {
		super();
		this.tsSignedId = tsSignedId;
		this.portfolioNameCH = portfolioNameCH;
		this.portfolioNameEN = portfolioNameEN;
		this.investmentAmount = investmentAmount;
		this.sectorName = sectorName;
		this.fundName = fundName;
		this.stageName = stageName;
		this.typeSecurityName = typeSecurityName;
		this.signDate = signDate;
	}



	public String getTsSignedId() {
		return tsSignedId;
	}

	public void setTsSignedId(String tsSignedId) {
		this.tsSignedId = tsSignedId;
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

	public String getInvestmentAmount() {
		return investmentAmount;
	}

	public void setInvestmentAmount(String investmentAmount) {
		this.investmentAmount = investmentAmount;
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

	public String getBoardDirector() {
		return boardDirector;
	}

	public void setBoardDirector(String boardDirector) {
		this.boardDirector = boardDirector;
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

	public String getTypeSecurityName() {
		return typeSecurityName;
	}

	public void setTypeSecurityName(String typeSecurityName) {
		this.typeSecurityName = typeSecurityName;
	}

	public String getTypeSecurityId() {
		return typeSecurityId;
	}

	public void setTypeSecurityId(String typeSecurityId) {
		this.typeSecurityId = typeSecurityId;
	}

	public String getLiquidationPreference() {
		return LiquidationPreference;
	}

	public void setLiquidationPreference(String liquidationPreference) {
		LiquidationPreference = liquidationPreference;
	}

	public String getCountSize() {
		return countSize;
	}

	public void setCountSize(String countSize) {
		this.countSize = countSize;
	}

	
	public String getPaperId() {
		return paperId;
	}

	public void setPaperId(String paperId) {
		this.paperId = paperId;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getPreference() {
		return preference;
	}

	public void setPreference(String preference) {
		this.preference = preference;
	}

	public String getRedemption() {
		return redemption;
	}

	public void setRedemption(String redemption) {
		this.redemption = redemption;
	}

	public String getBridgeLoan() {
		return bridgeLoan;
	}

	public void setBridgeLoan(String bridgeLoan) {
		this.bridgeLoan = bridgeLoan;
	}

	public String getBoarDirectoRemark() {
		return boarDirectoRemark;
	}

	public void setBoarDirectoRemark(String boarDirectoRemark) {
		this.boarDirectoRemark = boarDirectoRemark;
	}

	public String getOwnerShip() {
		return ownerShip;
	}

	public void setOwnerShip(String ownerShip) {
		this.ownerShip = ownerShip;
	}

	public String getOwnerShipRemark() {
		return ownerShipRemark;
	}

	public void setOwnerShipRemark(String ownerShipRemark) {
		this.ownerShipRemark = ownerShipRemark;
	}

	public String getPreferenceRemark() {
		return preferenceRemark;
	}

	public void setPreferenceRemark(String preferenceRemark) {
		this.preferenceRemark = preferenceRemark;
	}

	public String getRedemptionRemark() {
		return redemptionRemark;
	}

	public void setRedemptionRemark(String redemptionRemark) {
		this.redemptionRemark = redemptionRemark;
	}

	public String getThruDate() {
		return thruDate;
	}

	public void setThruDate(String thruDate) {
		this.thruDate = thruDate;
	}

	public String getInvestDate() {
		return investDate;
	}

	public void setInvestDate(String investDate) {
		this.investDate = investDate;
	}

	public String getSignDate() {
		return signDate;
	}

	public void setSignDate(String signDate) {
		this.signDate = signDate;
	}

	public String getBridgeLoanRemark() {
		return bridgeLoanRemark;
	}

	public void setBridgeLoanRemark(String bridgeLoanRemark) {
		this.bridgeLoanRemark = bridgeLoanRemark;
	}

	public String getAttachmentid() {
		return attachmentid;
	}

	public void setAttachmentid(String attachmentid) {
		this.attachmentid = attachmentid;
	}

	public String getAttachmentname() {
		return attachmentname;
	}

	public void setAttachmentname(String attachmentname) {
		this.attachmentname = attachmentname;
	}

	public String getAttachmentload() {
		return attachmentload;
	}

	public void setAttachmentload(String attachmentload) {
		this.attachmentload = attachmentload;
	}
	
}

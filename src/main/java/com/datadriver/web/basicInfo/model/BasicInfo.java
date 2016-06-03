package com.datadriver.web.basicInfo.model;

import com.datadriver.web.common.model.DataDictionary;
import com.datadriver.web.file.model.DocumentEntity;

public class BasicInfo {

	private String basicInfoId;// 标识

	private String paperId;// one Paper标识

	private String portfolioNameCH;// 投资组合名称（中文）

	private String portfolioNameEN;// 投资组合名称（英文）

	private String signDate;// 注册日期

	private String sectorName;//领域名称
	
	private String fundName;//基金名称
	
	private String stageName;//阶段名称
	
	private String dealPartner;//合作伙伴

	private String fundingDate;// 资金日期 
	
	private DocumentEntity onepBridgeLoan;// 过桥贷款备忘录/寻呼机/Bridge loan memo/One Pager
	
	private String isApprovalSign;// 批准签署/Neil's approval to sign P-note
	
	private String preMoney;// 投前估值/Pre money valuation
	
	private String postMoney;// 投后估值/post money valuation 
	
	private String contactsName;// 联系人名称/contacts name
	
	private String contactsEmail;// 联系人邮箱/contacts email
	
	private String codeAddressEN;// 带区号英文地址/English address with area code
	
	private String contactsPhone;// 联系人手机/Contacts phone
	
	private String expectedReturn;// 预期收益/Expected return
	
	private DataDictionary developmentStage;// 开发阶段/Development stage
	
	private DocumentEntity latestFinancialStatements;// 最新财务报表/Latest financial statements

	private DataDictionary investmentStage;// 投资阶段/Investment Stage
	
	private DocumentEntity lddReport;// LDD 报表/LDD Report
	
	private DocumentEntity fddReport;// FDD 报表/FDD Report
	
	private DataDictionary fddMember;// FDD 成员/FDD Member
	
	private DataDictionary dealSource;// 交易来源/Deal source
	
	private String businessDescriptionCH;// 业务描述（中文）/ business description (Chinese)
	
	private String businessDescriptionEN;// 业务描述（英文）/ business description (English)
	
	private String isLeadInvestor;// 难道我们的主要投资人？/ Are we the lead investor?
	
	private String isStealthMode;// 它是在隐形模式？ / is it in stealth mode?
	
	private DocumentEntity groupChart;// 组图/Group Chart
	
	private String isUsdFund;// Cayman Directors’ approval to sign P-note (USD Fund
	
	private DocumentEntity wireInstruction;// 电线指令/Wire instruction
	
	private DocumentEntity repLetter;// 
	
	private DocumentEntity transactionDocs;// Fully signed P-note, relevant transaction docs
	
	private String isApprovalFunding;// 批准拨款/Neil’s approval for funding
	
	private String nextIndex;//下一步
	
	private String onshoreEntityCity;

	private String countsize;// 明细数量

	public String getBasicInfoId() {
		return basicInfoId;
	}

	public void setBasicInfoId(String basicInfoId) {
		this.basicInfoId = basicInfoId;
	}

	public String getPaperId() {
		return paperId;
	}

	public void setPaperId(String paperId) {
		this.paperId = paperId;
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

	public String getSignDate() {
		return signDate;
	}

	public void setSignDate(String signDate) {
		this.signDate = signDate;
	}

	public String getSectorName() {
		return sectorName;
	}

	public void setSectorName(String sectorName) {
		this.sectorName = sectorName;
	}

	public String getFundName() {
		return fundName;
	}

	public void setFundName(String fundName) {
		this.fundName = fundName;
	}

	public String getStageName() {
		return stageName;
	}

	public void setStageName(String stageName) {
		this.stageName = stageName;
	}
	
	public String getDealPartner() {
		return dealPartner;
	}

	public void setDealPartner(String dealPartner) {
		this.dealPartner = dealPartner;
	}

	public String getFundingDate() {
		return fundingDate;
	}

	public void setFundingDate(String fundingDate) {
		this.fundingDate = fundingDate;
	}

	public DocumentEntity getOnepBridgeLoan() {
		return onepBridgeLoan;
	}

	public void setOnepBridgeLoan(DocumentEntity onepBridgeLoan) {
		this.onepBridgeLoan = onepBridgeLoan;
	}

	public String getIsApprovalSign() {
		return isApprovalSign;
	}

	public void setIsApprovalSign(String isApprovalSign) {
		this.isApprovalSign = isApprovalSign;
	}

	public String getPreMoney() {
		return preMoney;
	}

	public void setPreMoney(String preMoney) {
		this.preMoney = preMoney;
	}

	public String getPostMoney() {
		return postMoney;
	}

	public void setPostMoney(String postMoney) {
		this.postMoney = postMoney;
	}

	public String getContactsName() {
		return contactsName;
	}

	public void setContactsName(String contactsName) {
		this.contactsName = contactsName;
	}

	public String getContactsEmail() {
		return contactsEmail;
	}

	public void setContactsEmail(String contactsEmail) {
		this.contactsEmail = contactsEmail;
	}

	public String getCodeAddressEN() {
		return codeAddressEN;
	}

	public void setCodeAddressEN(String codeAddressEN) {
		this.codeAddressEN = codeAddressEN;
	}

	public String getContactsPhone() {
		return contactsPhone;
	}

	public void setContactsPhone(String contactsPhone) {
		this.contactsPhone = contactsPhone;
	}

	public String getExpectedReturn() {
		return expectedReturn;
	}

	public void setExpectedReturn(String expectedReturn) {
		this.expectedReturn = expectedReturn;
	}

	public DataDictionary getDevelopmentStage() {
		return developmentStage;
	}

	public void setDevelopmentStage(DataDictionary developmentStage) {
		this.developmentStage = developmentStage;
	}

	public DocumentEntity getLatestFinancialStatements() {
		return latestFinancialStatements;
	}

	public void setLatestFinancialStatements(
			DocumentEntity latestFinancialStatements) {
		this.latestFinancialStatements = latestFinancialStatements;
	}

	public DataDictionary getInvestmentStage() {
		return investmentStage;
	}

	public void setInvestmentStage(DataDictionary investmentStage) {
		this.investmentStage = investmentStage;
	}

	public DocumentEntity getLddReport() {
		return lddReport;
	}

	public void setLddReport(DocumentEntity lddReport) {
		this.lddReport = lddReport;
	}

	public DocumentEntity getFddReport() {
		return fddReport;
	}

	public void setFddReport(DocumentEntity fddReport) {
		this.fddReport = fddReport;
	}

	public DataDictionary getFddMember() {
		return fddMember;
	}

	public void setFddMember(DataDictionary fddMember) {
		this.fddMember = fddMember;
	}

	public DataDictionary getDealSource() {
		return dealSource;
	}

	public void setDealSource(DataDictionary dealSource) {
		this.dealSource = dealSource;
	}

	public String getBusinessDescriptionCH() {
		return businessDescriptionCH;
	}

	public void setBusinessDescriptionCH(String businessDescriptionCH) {
		this.businessDescriptionCH = businessDescriptionCH;
	}

	public String getBusinessDescriptionEN() {
		return businessDescriptionEN;
	}

	public void setBusinessDescriptionEN(String businessDescriptionEN) {
		this.businessDescriptionEN = businessDescriptionEN;
	}

	public String getIsLeadInvestor() {
		return isLeadInvestor;
	}

	public void setIsLeadInvestor(String isLeadInvestor) {
		this.isLeadInvestor = isLeadInvestor;
	}

	public String getIsStealthMode() {
		return isStealthMode;
	}

	public void setIsStealthMode(String isStealthMode) {
		this.isStealthMode = isStealthMode;
	}

	public DocumentEntity getGroupChart() {
		return groupChart;
	}

	public void setGroupChart(DocumentEntity groupChart) {
		this.groupChart = groupChart;
	}

	public String getIsUsdFund() {
		return isUsdFund;
	}

	public void setIsUsdFund(String isUsdFund) {
		this.isUsdFund = isUsdFund;
	}

	public DocumentEntity getWireInstruction() {
		return wireInstruction;
	}

	public void setWireInstruction(DocumentEntity wireInstruction) {
		this.wireInstruction = wireInstruction;
	}

	public DocumentEntity getRepLetter() {
		return repLetter;
	}

	public void setRepLetter(DocumentEntity repLetter) {
		this.repLetter = repLetter;
	}

	public DocumentEntity getTransactionDocs() {
		return transactionDocs;
	}

	public void setTransactionDocs(DocumentEntity transactionDocs) {
		this.transactionDocs = transactionDocs;
	}

	public String getIsApprovalFunding() {
		return isApprovalFunding;
	}

	public void setIsApprovalFunding(String isApprovalFunding) {
		this.isApprovalFunding = isApprovalFunding;
	}

	public String getNextIndex() {
		return nextIndex;
	}

	public void setNextIndex(String nextIndex) {
		this.nextIndex = nextIndex;
	}

	public String getCountsize() {
		return countsize;
	}

	public void setCountsize(String countsize) {
		this.countsize = countsize;
	}

	public String getOnshoreEntityCity() {
		return onshoreEntityCity;
	}

	public void setOnshoreEntityCity(String onshoreEntityCity) {
		this.onshoreEntityCity = onshoreEntityCity;
	}
	
}

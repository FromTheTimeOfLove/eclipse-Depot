package com.datadriver.web.equityInvestment.model;

import com.datadriver.web.file.model.DocumentEntity;

public class EquityInvestment {
	
	private String	isNullDeal;		// deal是不是空
	private String	isNullLegal;	// legal是不是空
	// EquityInvestment
	private String	equityInvestmentId;
	private String	paperId;
	private String	fundingDate;
	private String	nextIndex;
	// PreFunding
	private DocumentEntity	indemnificationUpload;	// Dir indemnification
	private DocumentEntity	transactionDocsUpload;	// Fully signed SPA,
													// relevant transaction docs
	private DocumentEntity	instructionUpload;		// Wire instruction
	private DocumentEntity	repLetterUpload;		// Rep letter
	private String			isConditions;			// Confirm that all the
													// closing conditions are
													// satisfied or waived
	private String			isApproval;				// Neil’s approval for
													// funding
	private String			isRound;				// Is this round a follow on
													// investment?
	// PreSigning
	private String			equitySignSPA;			// Neil's approval to sign
													// SPA
	private DocumentEntity	memoUpload;				// Investment memo/One Pager
	private String			dealNameRmark;			// Chinese Deal Name
	private String			dealCompanyRmark;		// Chinese Company Name
	private String			npreMoney;				// Pre money valuation
	private String			npostMoney;				// Post money valuation
	private String			equityDealPartner;		// Deal partner
	private String			sectorOrIndustry;		// Sector/Industry
	private String			usdFundRemark;			// USD FUND
	private String			expectedRemark;			// Expected return
	private String			equityInvestmentStage;	// Investment Stage
	private String			contactName;			// name
	private String			contactEmail;			// email
	private String			contactAddress;			// English address with area
													// code
	private String			contactPhone;			// phone
	private String			equityDevelopmentStage;	// Development stage
	private DocumentEntity	financialUpload;		// Latest financial
													// statements
	private DocumentEntity	capTableUpload;			// Cap Table
	private DocumentEntity	fddReportUpload;		// FDD report
	private String			fddId;					// FDD member
	private String			bodId;					// BOD
	private String			equityDealSource;		// Deal source
	private String			equityInvestmentStatus;	// Investment Status
	private String			equityInvestors;		// Co-investors (if any)
	private String			equitySeriesType;		// Series type
	private String			equityExpectedExit;		// Expected exit method
													// (IPO, M&A, etc.)
	private String			equityTimeToExit;		// Time to exit
	private String			chineseRmark;			// business description
													// (Chinese)
	private String			englishRmark;			// business description
													// (English)
	private String			isEquityKeyTerms;		// Deal team to confirm the
													// key terms in the
													// transaction documents
	private String			isEquityFinancials;		// Can we disclose the name
													// of the investment in our
													// Fund’s financials?
	private String			isEquityBroker;			// Broker (if any)
	private String			equityBrokerRemark;		// if(isEquityBroker的是yes,则有数据)
	private String			isEquityAnnouncement;	// New Investment
													// Announcement form (Please
													// refer to Appendix 1)
	private String			equityRationale;		// if(isEquityAnnouncement是yes，则有数据)
	private String			equityWebsite;			// if(isEquityAnnouncement是yes，则有数据)
	private String			isEquityStealth;		// Is it in stealth mode?
	private String			isEquityLeadInvestor;	// Are we the lead investor?
	private String			equityOnshore;			// Onshore entity location
													// (City)
	private DocumentEntity	questionnaireUpload;	// FCPA questionnaire
	private String			isEquityGDOTOrFCPA;		// GDOT/FCPA
	private DocumentEntity	legalOpinionUpload;		// Legal Opinion (Cayman and
													// PRC) for all investments
													// (no waiver)
	private DocumentEntity	groupChartUpload;		// Group Chart
	private DocumentEntity	letterUpload;			// Name and Logo Undertaking
													// Letter
	private DocumentEntity	lddReportUpload;		// LDD report
	private String			isUSDFund;				// Cayman Directors’
													// approval to sign SPA and
													// related documents (USD
													// Fund)
	private String			isAtypical;				// Tax clearance for
													// atypical deals
	
	private DocumentEntity fcpaCheckingResult; //
	
	public String getIsNullDeal() {
		return isNullDeal;
	}
	
	public void setIsNullDeal(String isNullDeal) {
		this.isNullDeal = isNullDeal;
	}
	
	public String getIsNullLegal() {
		return isNullLegal;
	}
	
	public void setIsNullLegal(String isNullLegal) {
		this.isNullLegal = isNullLegal;
	}
	
	public void setEquityInvestmentId(String equityInvestmentId) {
		this.equityInvestmentId = equityInvestmentId;
	}
	
	public String getEquityInvestmentId() {
		return equityInvestmentId;
	}
	
	public void setPaperId(String paperId) {
		this.paperId = paperId;
	}
	
	public String getPaperId() {
		return paperId;
	}
	
	public void setFundingDate(String fundingDate) {
		this.fundingDate = fundingDate;
	}
	
	public String getFundingDate() {
		return fundingDate;
	}
	
	public DocumentEntity getIndemnificationUpload() {
		return indemnificationUpload;
	}
	
	public void setIndemnificationUpload(DocumentEntity indemnificationUpload) {
		this.indemnificationUpload = indemnificationUpload;
	}
	
	public DocumentEntity getTransactionDocsUpload() {
		return transactionDocsUpload;
	}
	
	public void setTransactionDocsUpload(DocumentEntity transactionDocsUpload) {
		this.transactionDocsUpload = transactionDocsUpload;
	}
	
	public DocumentEntity getInstructionUpload() {
		return instructionUpload;
	}
	
	public void setInstructionUpload(DocumentEntity instructionUpload) {
		this.instructionUpload = instructionUpload;
	}
	
	public DocumentEntity getRepLetterUpload() {
		return repLetterUpload;
	}
	
	public void setRepLetterUpload(DocumentEntity repLetterUpload) {
		this.repLetterUpload = repLetterUpload;
	}
	
	public String getIsConditions() {
		return isConditions;
	}
	
	public void setIsConditions(String isConditions) {
		this.isConditions = isConditions;
	}
	
	public String getIsApproval() {
		return isApproval;
	}
	
	public void setIsApproval(String isApproval) {
		this.isApproval = isApproval;
	}
	
	public String getIsRound() {
		return isRound;
	}
	
	public void setIsRound(String isRound) {
		this.isRound = isRound;
	}
	
	public DocumentEntity getFcpaCheckingResult() {
		return fcpaCheckingResult;
	}

	public void setFcpaCheckingResult(DocumentEntity fcpaCheckingResult) {
		this.fcpaCheckingResult = fcpaCheckingResult;
	}

	public String getEquitySignSPA() {
		return equitySignSPA;
	}
	
	public void setEquitySignSPA(String equitySignSPA) {
		this.equitySignSPA = equitySignSPA;
	}
	
	public DocumentEntity getMemoUpload() {
		return memoUpload;
	}
	
	public void setMemoUpload(DocumentEntity memoUpload) {
		this.memoUpload = memoUpload;
	}
	
	public String getDealNameRmark() {
		return dealNameRmark;
	}
	
	public void setDealNameRmark(String dealNameRmark) {
		this.dealNameRmark = dealNameRmark;
	}
	
	public String getDealCompanyRmark() {
		return dealCompanyRmark;
	}
	
	public void setDealCompanyRmark(String dealCompanyRmark) {
		this.dealCompanyRmark = dealCompanyRmark;
	}
	
	public String getNpreMoney() {
		return npreMoney;
	}
	
	public void setNpreMoney(String npreMoney) {
		this.npreMoney = npreMoney;
	}
	
	public String getNpostMoney() {
		return npostMoney;
	}
	
	public void setNpostMoney(String npostMoney) {
		this.npostMoney = npostMoney;
	}
	
	public String getEquityDealPartner() {
		return equityDealPartner;
	}
	
	public void setEquityDealPartner(String equityDealPartner) {
		this.equityDealPartner = equityDealPartner;
	}
	
	public String getUsdFundRemark() {
		return usdFundRemark;
	}
	
	public void setUsdFundRemark(String usdFundRemark) {
		this.usdFundRemark = usdFundRemark;
	}
	
	public String getExpectedRemark() {
		return expectedRemark;
	}
	
	public void setExpectedRemark(String expectedRemark) {
		this.expectedRemark = expectedRemark;
	}
	
	public String getEquityInvestmentStage() {
		return equityInvestmentStage;
	}
	
	public void setEquityInvestmentStage(String equityInvestmentStage) {
		this.equityInvestmentStage = equityInvestmentStage;
	}
	
	public String getContactName() {
		return contactName;
	}
	
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	
	public String getContactEmail() {
		return contactEmail;
	}
	
	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}
	
	public String getContactAddress() {
		return contactAddress;
	}
	
	public void setContactAddress(String contactAddress) {
		this.contactAddress = contactAddress;
	}
	
	public String getContactPhone() {
		return contactPhone;
	}
	
	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}
	
	public String getEquityDevelopmentStage() {
		return equityDevelopmentStage;
	}
	
	public void setEquityDevelopmentStage(String equityDevelopmentStage) {
		this.equityDevelopmentStage = equityDevelopmentStage;
	}
	
	public DocumentEntity getFinancialUpload() {
		return financialUpload;
	}
	
	public void setFinancialUpload(DocumentEntity financialUpload) {
		this.financialUpload = financialUpload;
	}
	
	public DocumentEntity getCapTableUpload() {
		return capTableUpload;
	}
	
	public void setCapTableUpload(DocumentEntity capTableUpload) {
		this.capTableUpload = capTableUpload;
	}
	
	public DocumentEntity getFddReportUpload() {
		return fddReportUpload;
	}
	
	public void setFddReportUpload(DocumentEntity fddReportUpload) {
		this.fddReportUpload = fddReportUpload;
	}
	
	public String getFddId() {
		return fddId;
	}
	
	public void setFddId(String fddId) {
		this.fddId = fddId;
	}
	
	public String getBodId() {
		return bodId;
	}
	
	public void setBodId(String bodId) {
		this.bodId = bodId;
	}
	
	public String getEquityDealSource() {
		return equityDealSource;
	}
	
	public void setEquityDealSource(String equityDealSource) {
		this.equityDealSource = equityDealSource;
	}
	
	public String getEquityInvestmentStatus() {
		return equityInvestmentStatus;
	}
	
	public void setEquityInvestmentStatus(String equityInvestmentStatus) {
		this.equityInvestmentStatus = equityInvestmentStatus;
	}
	
	public String getEquityInvestors() {
		return equityInvestors;
	}
	
	public void setEquityInvestors(String equityInvestors) {
		this.equityInvestors = equityInvestors;
	}
	
	public String getEquitySeriesType() {
		return equitySeriesType;
	}
	
	public void setEquitySeriesType(String equitySeriesType) {
		this.equitySeriesType = equitySeriesType;
	}
	
	public String getEquityExpectedExit() {
		return equityExpectedExit;
	}
	
	public void setEquityExpectedExit(String equityExpectedExit) {
		this.equityExpectedExit = equityExpectedExit;
	}
	
	public String getEquityTimeToExit() {
		return equityTimeToExit;
	}
	
	public void setEquityTimeToExit(String equityTimeToExit) {
		this.equityTimeToExit = equityTimeToExit;
	}
	
	public String getChineseRmark() {
		return chineseRmark;
	}
	
	public void setChineseRmark(String chineseRmark) {
		this.chineseRmark = chineseRmark;
	}
	
	public String getEnglishRmark() {
		return englishRmark;
	}
	
	public void setEnglishRmark(String englishRmark) {
		this.englishRmark = englishRmark;
	}
	
	public String getIsEquityKeyTerms() {
		return isEquityKeyTerms;
	}
	
	public void setIsEquityKeyTerms(String isEquityKeyTerms) {
		this.isEquityKeyTerms = isEquityKeyTerms;
	}
	
	public String getIsEquityFinancials() {
		return isEquityFinancials;
	}
	
	public void setIsEquityFinancials(String isEquityFinancials) {
		this.isEquityFinancials = isEquityFinancials;
	}
	
	public String getIsEquityBroker() {
		return isEquityBroker;
	}
	
	public void setIsEquityBroker(String isEquityBroker) {
		this.isEquityBroker = isEquityBroker;
	}
	
	public String getEquityBrokerRemark() {
		return equityBrokerRemark;
	}
	
	public void setEquityBrokerRemark(String equityBrokerRemark) {
		this.equityBrokerRemark = equityBrokerRemark;
	}
	
	public String getEquityRationale() {
		return equityRationale;
	}
	
	public void setEquityRationale(String equityRationale) {
		this.equityRationale = equityRationale;
	}
	
	public String getEquityWebsite() {
		return equityWebsite;
	}
	
	public void setEquityWebsite(String equityWebsite) {
		this.equityWebsite = equityWebsite;
	}
	
	public String getIsEquityStealth() {
		return isEquityStealth;
	}
	
	public void setIsEquityStealth(String isEquityStealth) {
		this.isEquityStealth = isEquityStealth;
	}
	
	public String getIsEquityLeadInvestor() {
		return isEquityLeadInvestor;
	}
	
	public void setIsEquityLeadInvestor(String isEquityLeadInvestor) {
		this.isEquityLeadInvestor = isEquityLeadInvestor;
	}
	
	public String getEquityOnshore() {
		return equityOnshore;
	}
	
	public void setEquityOnshore(String equityOnshore) {
		this.equityOnshore = equityOnshore;
	}
	
	public DocumentEntity getQuestionnaireUpload() {
		return questionnaireUpload;
	}
	
	public void setQuestionnaireUpload(DocumentEntity questionnaireUpload) {
		this.questionnaireUpload = questionnaireUpload;
	}
	
	public String getIsEquityGDOTOrFCPA() {
		return isEquityGDOTOrFCPA;
	}
	
	public void setIsEquityGDOTOrFCPA(String isEquityGDOTOrFCPA) {
		this.isEquityGDOTOrFCPA = isEquityGDOTOrFCPA;
	}
	
	public DocumentEntity getLegalOpinionUpload() {
		return legalOpinionUpload;
	}
	
	public void setLegalOpinionUpload(DocumentEntity legalOpinionUpload) {
		this.legalOpinionUpload = legalOpinionUpload;
	}
	
	public DocumentEntity getGroupChartUpload() {
		return groupChartUpload;
	}
	
	public void setGroupChartUpload(DocumentEntity groupChartUpload) {
		this.groupChartUpload = groupChartUpload;
	}
	
	public DocumentEntity getLddReportUpload() {
		return lddReportUpload;
	}
	
	public void setLddReportUpload(DocumentEntity lddReportUpload) {
		this.lddReportUpload = lddReportUpload;
	}
	
	public DocumentEntity getLetterUpload() {
		return letterUpload;
	}
	
	public void setLetterUpload(DocumentEntity letterUpload) {
		this.letterUpload = letterUpload;
	}
	
	public String getIsUSDFund() {
		return isUSDFund;
	}
	
	public void setIsUSDFund(String isUSDFund) {
		this.isUSDFund = isUSDFund;
	}
	
	public String getIsAtypical() {
		return isAtypical;
	}
	
	public void setIsAtypical(String isAtypical) {
		this.isAtypical = isAtypical;
	}
	
	public void setSectorOrIndustry(String sectorOrIndustry) {
		this.sectorOrIndustry = sectorOrIndustry;
	}
	
	public String getSectorOrIndustry() {
		return sectorOrIndustry;
	}
	
	public void setIsEquityAnnouncement(String isEquityAnnouncement) {
		this.isEquityAnnouncement = isEquityAnnouncement;
	}
	
	public String getIsEquityAnnouncement() {
		return isEquityAnnouncement;
	}
	
	public void setNextIndex(String nextIndex) {
		this.nextIndex = nextIndex;
	}
	
	public String getNextIndex() {
		return nextIndex;
	}
}

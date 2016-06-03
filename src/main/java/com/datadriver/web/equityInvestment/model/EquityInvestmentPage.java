package com.datadriver.web.equityInvestment.model;

import com.datadriver.web.common.model.DataDictionary;
import com.datadriver.web.file.model.DocumentEntity;

public class EquityInvestmentPage {
	
	private String			equityInvestmentId;	// 标识
												
	private String			paperId;			// one Paper标识
												
	private String			portfolioNameCH;	// 投资组合名称（中文）
												
	private String			portfolioNameEN;	// 投资组合名称（英文）
												
	private String			signDate;			// 注册日期
												
	private DataDictionary	sectorData;			// 区域
												
	private String			sectorName;
	private String			fundName;
	private String			stageName;
	
	private DataDictionary	fundData;			// 基金
												
	private DataDictionary	stageData;			// 阶段
												
	private String			fundingDate;		// 资金日期
												
	private String			partnerOne;			// 交易伙伴1
												
	private String			partnerTwo;			// 交易伙伴2
												
	private String			partnerThr;			// 交易伙伴3
												
	private String			investAmout;		// 投资金额
												
	private String			investAmoutRemark;	// 投资金额备注
												
	private String			ownership;			// 所有权
												
	private String			ownershipRemark;	// 所有权备注
												
	private DataDictionary	securityTypeData;	// 安全类型标识
												
	private String			securityTypeName;	// 安全类型名称
												
	private String			securityTypeRemark;	// 安全类型备注
												
	private String			quantity;			// 数量
												
	private String			quantityRemark;		// 数量备注
												
	private String			warrant;			// 授权
												
	private String			warrantRemark;		// 授权备注
												
	private String			preference;			// 清算优先权
												
	private String			preferenceRemark;	// 清算优先权备注
												
	private String			redemption;			// 赎回
												
	private String			redemptionRemark;	// 赎回备注
												
	private String			boardirector;		// 董事局
												
	private String			boardirectorRmark;	// 董事局备注
												
	private DocumentEntity	sapupload;			// SAP上传
												
	private String			deleted;			// 删除字段0标示没有删除，1标示删除
												
	private String			countsize;			// 明细数量
												
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
	
	public String getFundingDate() {
		return fundingDate;
	}
	
	public void setFundingDate(String fundingDate) {
		this.fundingDate = fundingDate;
	}
	
	public String getPartnerOne() {
		return partnerOne;
	}
	
	public void setPartnerOne(String partnerOne) {
		this.partnerOne = partnerOne;
	}
	
	public String getPartnerTwo() {
		return partnerTwo;
	}
	
	public void setPartnerTwo(String partnerTwo) {
		this.partnerTwo = partnerTwo;
	}
	
	public String getPartnerThr() {
		return partnerThr;
	}
	
	public void setPartnerThr(String partnerThr) {
		this.partnerThr = partnerThr;
	}
	
	public String getInvestAmout() {
		return investAmout;
	}
	
	public void setInvestAmout(String investAmout) {
		this.investAmout = investAmout;
	}
	
	public String getInvestAmoutRemark() {
		return investAmoutRemark;
	}
	
	public void setInvestAmoutRemark(String investAmoutRemark) {
		this.investAmoutRemark = investAmoutRemark;
	}
	
	public String getOwnership() {
		return ownership;
	}
	
	public void setOwnership(String ownership) {
		this.ownership = ownership;
	}
	
	public String getOwnershipRemark() {
		return ownershipRemark;
	}
	
	public void setOwnershipRemark(String ownershipRemark) {
		this.ownershipRemark = ownershipRemark;
	}
	
	public String getSecurityTypeName() {
		return securityTypeName;
	}
	
	public void setSecurityTypeName(String securityTypeName) {
		this.securityTypeName = securityTypeName;
	}
	
	public String getSecurityTypeRemark() {
		return securityTypeRemark;
	}
	
	public void setSecurityTypeRemark(String securityTypeRemark) {
		this.securityTypeRemark = securityTypeRemark;
	}
	
	public String getQuantity() {
		return quantity;
	}
	
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	
	public String getQuantityRemark() {
		return quantityRemark;
	}
	
	public void setQuantityRemark(String quantityRemark) {
		this.quantityRemark = quantityRemark;
	}
	
	public String getWarrant() {
		return warrant;
	}
	
	public void setWarrant(String warrant) {
		this.warrant = warrant;
	}
	
	public String getWarrantRemark() {
		return warrantRemark;
	}
	
	public void setWarrantRemark(String warrantRemark) {
		this.warrantRemark = warrantRemark;
	}
	
	public String getPreference() {
		return preference;
	}
	
	public void setPreference(String preference) {
		this.preference = preference;
	}
	
	public String getPreferenceRemark() {
		return preferenceRemark;
	}
	
	public void setPreferenceRemark(String preferenceRemark) {
		this.preferenceRemark = preferenceRemark;
	}
	
	public String getRedemption() {
		return redemption;
	}
	
	public void setRedemption(String redemption) {
		this.redemption = redemption;
	}
	
	public String getRedemptionRemark() {
		return redemptionRemark;
	}
	
	public void setRedemptionRemark(String redemptionRemark) {
		this.redemptionRemark = redemptionRemark;
	}
	
	public String getBoardirector() {
		return boardirector;
	}
	
	public void setBoardirector(String boardirector) {
		this.boardirector = boardirector;
	}
	
	public String getBoardirectorRmark() {
		return boardirectorRmark;
	}
	
	public void setBoardirectorRmark(String boardirectorRmark) {
		this.boardirectorRmark = boardirectorRmark;
	}
	
	public DocumentEntity getSapupload() {
		return sapupload;
	}
	
	public void setSapupload(DocumentEntity sapupload) {
		this.sapupload = sapupload;
	}
	
	public String getDeleted() {
		return deleted;
	}
	
	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}
	
	public String getCountsize() {
		return countsize;
	}
	
	public void setCountsize(String countsize) {
		this.countsize = countsize;
	}
	
	public DataDictionary getSectorData() {
		return sectorData;
	}
	
	public void setSectorData(DataDictionary sectorData) {
		this.sectorData = sectorData;
	}
	
	public DataDictionary getFundData() {
		return fundData;
	}
	
	public void setFundData(DataDictionary fundData) {
		this.fundData = fundData;
	}
	
	public DataDictionary getStageData() {
		return stageData;
	}
	
	public void setStageData(DataDictionary stageData) {
		this.stageData = stageData;
	}
	
	public DataDictionary getSecurityTypeData() {
		return securityTypeData;
	}
	
	public void setSecurityTypeData(DataDictionary securityTypeData) {
		this.securityTypeData = securityTypeData;
	}
	
	public void setEquityInvestmentId(String equityInvestmentId) {
		this.equityInvestmentId = equityInvestmentId;
	}
	
	public String getEquityInvestmentId() {
		return equityInvestmentId;
	}
	
}

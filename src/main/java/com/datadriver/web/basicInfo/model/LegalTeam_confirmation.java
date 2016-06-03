package com.datadriver.web.basicInfo.model;

/**
 * 
 * @Acthor：hurentao
 * @ClassName: LagelTeam
 * @Description: LagelTeam 实体
 * @Date 2016-5-9 下午5:40:32
 */
public class LegalTeam_confirmation {
	private String vpnoteCkConfId;
	private String confirmEconomics;
	private String confirmTransaction;
	private String confirmFundLoan;
	private String confirmNoReasonable;
	private String loanWithConditions;
	private String securedByCollateral;
	private String confirmPortfolioCompany;
	private String teamType;// team type
	private String exportTitle;
	
	public String getExportTitle() {
		return exportTitle;
	}
	public void setExportTitle(String exportTitle) {
		this.exportTitle = exportTitle;
	}
	
	public String getTeamType() {
		return teamType;
	}
	public void setTeamType(String teamType) {
		this.teamType = teamType;
	}
	
	public String getVpnoteCkConfId() {
		return vpnoteCkConfId;
	}
	public void setVpnoteCkConfId(String vpnoteCkConfId) {
		this.vpnoteCkConfId = vpnoteCkConfId;
	}
	public String getConfirmEconomics() {
		return confirmEconomics;
	}
	public void setConfirmEconomics(String confirmEconomics) {
		this.confirmEconomics = confirmEconomics;
	}
	public String getConfirmTransaction() {
		return confirmTransaction;
	}
	public void setConfirmTransaction(String confirmTransaction) {
		this.confirmTransaction = confirmTransaction;
	}
	public String getConfirmFundLoan() {
		return confirmFundLoan;
	}
	public void setConfirmFundLoan(String confirmFundLoan) {
		this.confirmFundLoan = confirmFundLoan;
	}
	public String getConfirmNoReasonable() {
		return confirmNoReasonable;
	}
	public void setConfirmNoReasonable(String confirmNoReasonable) {
		this.confirmNoReasonable = confirmNoReasonable;
	}
	public String getLoanWithConditions() {
		return loanWithConditions;
	}
	public void setLoanWithConditions(String loanWithConditions) {
		this.loanWithConditions = loanWithConditions;
	}
	public String getSecuredByCollateral() {
		return securedByCollateral;
	}
	public void setSecuredByCollateral(String securedByCollateral) {
		this.securedByCollateral = securedByCollateral;
	}
	public String getConfirmPortfolioCompany() {
		return confirmPortfolioCompany;
	}
	public void setConfirmPortfolioCompany(String confirmPortfolioCompany) {
		this.confirmPortfolioCompany = confirmPortfolioCompany;
	}
	
}

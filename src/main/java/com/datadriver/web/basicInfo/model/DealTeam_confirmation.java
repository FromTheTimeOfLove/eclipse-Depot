package com.datadriver.web.basicInfo.model;

/**
 * 
 * @Acthor：hurentao
 * @ClassName: DealTeam
 * @Description: DealTeam 实体
 * @Date 2016-5-10 上午9:10:27
 */
public class DealTeam_confirmation {
	private String vpnoteCkConfId;
	private String founderTrustworthy;
	private String investmentOpportunity;
	private String confirmInUsd;
	private String loanThirdParty;
	private String confirmfounder;
	private String teamType;// team type
	private String exportTitle;
	
	public String getExportTitle() {
		return exportTitle;
	}
	public void setExportTitle(String exportTitle) {
		this.exportTitle = exportTitle;
	}
	public DealTeam_confirmation() {
		super();
	}
	public DealTeam_confirmation(String founderTrustworthy, String investmentOpportunity,
			String confirmInUsd, String loanThirdParty, String confirmfounder,
			String teamType) {
		super();
		this.founderTrustworthy = founderTrustworthy;
		this.investmentOpportunity = investmentOpportunity;
		this.confirmInUsd = confirmInUsd;
		this.loanThirdParty = loanThirdParty;
		this.confirmfounder = confirmfounder;
		this.teamType = teamType;
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
	public String getFounderTrustworthy() {
		return founderTrustworthy;
	}
	public void setFounderTrustworthy(String founderTrustworthy) {
		this.founderTrustworthy = founderTrustworthy;
	}
	public String getInvestmentOpportunity() {
		return investmentOpportunity;
	}
	public void setInvestmentOpportunity(String investmentOpportunity) {
		this.investmentOpportunity = investmentOpportunity;
	}
	public String getConfirmInUsd() {
		return confirmInUsd;
	}
	public void setConfirmInUsd(String confirmInUsd) {
		this.confirmInUsd = confirmInUsd;
	}
	public String getLoanThirdParty() {
		return loanThirdParty;
	}
	public void setLoanThirdParty(String loanThirdParty) {
		this.loanThirdParty = loanThirdParty;
	}
	public String getConfirmfounder() {
		return confirmfounder;
	}
	public void setConfirmfounder(String confirmfounder) {
		this.confirmfounder = confirmfounder;
	}
	
}

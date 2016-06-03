package com.datadriver.web.loanTracker.model;

/**
 * 
 * @Acthor：hurentao
 * @ClassName: OnePaper
 * @Description: 实体类
 * @Date 2016-4-12 上午11:34:02
 */
public class LoanTracker {
	private String loanTrackerId;//标识
	private String fundName;// 基金名称
	private String fundId;// 基金标识
	private String investmentEntity;// 投资实体
	private String companyName;// 公司标名称
	private String companyId;// 公司标识
	private String loanAmount;// 过桥贷款
	private String dateIssued;// 发出时间
	private String expiry;// 贷款到期
	private String interestRate;// 利率
	private String expiredInterestRate;// 到期利率	
	private String companysShares;// 承诺是哪公司的股票
	private String pledgedEntity;// 承诺的实体
	private String personalGuarantee;// 个人担保
	private String recovered;// 可以恢复
	private String dateConvertedOrRepaid;// 日期转换或偿还
	private String daysOS;// 
	private String aging;// 
	private String note;// 注
	

	public LoanTracker(String loanTrackerId, String fundName, 
			String investmentEntity, String companyName, 
			String loanAmount, String dateIssued, String expiry,
			String interestRate, String expiredInterestRate,
			String companysShares, String pledgedEntity,
			String personalGuarantee, String recovered,
			String dateConvertedOrRepaid, String daysOS, String aging,
			String note) {
		super();
		this.loanTrackerId = loanTrackerId;
		this.fundName = fundName;
		this.investmentEntity = investmentEntity;
		this.companyName = companyName;
		this.loanAmount = loanAmount;
		this.dateIssued = dateIssued;
		this.expiry = expiry;
		this.interestRate = interestRate;
		this.expiredInterestRate = expiredInterestRate;
		this.companysShares = companysShares;
		this.pledgedEntity = pledgedEntity;
		this.personalGuarantee = personalGuarantee;
		this.recovered = recovered;
		this.dateConvertedOrRepaid = dateConvertedOrRepaid;
		this.daysOS = daysOS;
		this.aging = aging;
		this.note = note;
	}

	public LoanTracker() {
		super();
	}

	public String getLoanTrackerId() {
		return loanTrackerId;
	}

	public void setLoanTrackerId(String loanTrackerId) {
		this.loanTrackerId = loanTrackerId;
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

	public String getInvestmentEntity() {
		return investmentEntity;
	}

	public void setInvestmentEntity(String investmentEntity) {
		this.investmentEntity = investmentEntity;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(String loanAmount) {
		this.loanAmount = loanAmount;
	}

	public String getDateIssued() {
		return dateIssued;
	}

	public void setDateIssued(String dateIssued) {
		this.dateIssued = dateIssued;
	}

	public String getExpiry() {
		return expiry;
	}

	public void setExpiry(String expiry) {
		this.expiry = expiry;
	}

	public String getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(String interestRate) {
		this.interestRate = interestRate;
	}

	public String getExpiredInterestRate() {
		return expiredInterestRate;
	}

	public void setExpiredInterestRate(String expiredInterestRate) {
		this.expiredInterestRate = expiredInterestRate;
	}

	public String getCompanysShares() {
		return companysShares;
	}

	public void setCompanysShares(String companysShares) {
		this.companysShares = companysShares;
	}

	public String getPledgedEntity() {
		return pledgedEntity;
	}

	public void setPledgedEntity(String pledgedEntity) {
		this.pledgedEntity = pledgedEntity;
	}

	public String getPersonalGuarantee() {
		return personalGuarantee;
	}

	public void setPersonalGuarantee(String personalGuarantee) {
		this.personalGuarantee = personalGuarantee;
	}

	public String getRecovered() {
		return recovered;
	}

	public void setRecovered(String recovered) {
		this.recovered = recovered;
	}

	public String getDateConvertedOrRepaid() {
		return dateConvertedOrRepaid;
	}

	public void setDateConvertedOrRepaid(String dateConvertedOrRepaid) {
		this.dateConvertedOrRepaid = dateConvertedOrRepaid;
	}

	public String getDaysOS() {
		return daysOS;
	}

	public void setDaysOS(String daysOS) {
		this.daysOS = daysOS;
	}

	public String getAging() {
		return aging;
	}

	public void setAging(String aging) {
		this.aging = aging;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}

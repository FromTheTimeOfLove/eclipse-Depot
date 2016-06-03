package com.datadriver.web.basicInfo.model;
/**
 * 
 * @Acthor：hurentao
 * @ClassName: PostFunding
 * @Description: post funding实体类
 * @Date 2016-4-25 上午10:04:04
 */
public class PostFunding {

	private String postFundingId;// 标识
	private String basicInfoId;// basicInfo的标识
	private String signedDate;// Date of signed 签署日期
	private String prefMoney;// Pre money
	private String postfMoney;// Post money
	private String sccInvolved;// SCC Involved SCC参与
	private String sccInvolvedRe;// SCC Involved SCC参与备注
	private String dilutedOwnership;// Diluted ownership 稀释股权
	private String dilutedOwnershipRe;// 稀释股权备注
	private String tickerSymbol;// Ticker symbol 股票代码
	private String stockExchange;// Stock Exchange股票交易
	private String ipoDate;// IPO Date
	private String ipoPrice;// IPO Price
	private String closingIPOPrice;// Closing IPO Price 关闭IPO价格
	private String lockUpPeriod;// Lock up period 禁售期
	private String unlockDate;// Unlock date 解锁日期
	private String costPerShare;// Cost per share 每股成本
	private String holdingShares;// Holding shares 持股	
	private String sccDilutedOwnership;// SCC’s diluted ownership SCC的股权稀释
	private String dinDate;// 插入日期
	private String duppDate;// 修改日期
	private String nuserId;// 用户标识
	private String nuserName;// 用户名称
	
	public String getSccInvolvedRe() {
		return sccInvolvedRe;
	}
	public void setSccInvolvedRe(String sccInvolvedRe) {
		this.sccInvolvedRe = sccInvolvedRe;
	}
	public String getPostFundingId() {
		return postFundingId;
	}
	public void setPostFundingId(String postFundingId) {
		this.postFundingId = postFundingId;
	}
	public String getBasicInfoId() {
		return basicInfoId;
	}
	public void setBasicInfoId(String basicInfoId) {
		this.basicInfoId = basicInfoId;
	}
	public String getSignedDate() {
		return signedDate;
	}
	public void setSignedDate(String signedDate) {
		this.signedDate = signedDate;
	}
	public String getPrefMoney() {
		return prefMoney;
	}
	public void setPrefMoney(String prefMoney) {
		this.prefMoney = prefMoney;
	}
	public String getPostfMoney() {
		return postfMoney;
	}
	public void setPostfMoney(String postfMoney) {
		this.postfMoney = postfMoney;
	}
	public String getSccInvolved() {
		return sccInvolved;
	}
	public void setSccInvolved(String sccInvolved) {
		this.sccInvolved = sccInvolved;
	}
	public String getDilutedOwnership() {
		return dilutedOwnership;
	}
	public void setDilutedOwnership(String dilutedOwnership) {
		this.dilutedOwnership = dilutedOwnership;
	}
	public String getDilutedOwnershipRe() {
		return dilutedOwnershipRe;
	}
	public void setDilutedOwnershipRe(String dilutedOwnershipRe) {
		this.dilutedOwnershipRe = dilutedOwnershipRe;
	}
	public String getTickerSymbol() {
		return tickerSymbol;
	}
	public void setTickerSymbol(String tickerSymbol) {
		this.tickerSymbol = tickerSymbol;
	}
	public String getStockExchange() {
		return stockExchange;
	}
	public void setStockExchange(String stockExchange) {
		this.stockExchange = stockExchange;
	}
	public String getIpoDate() {
		return ipoDate;
	}
	public void setIpoDate(String ipoDate) {
		this.ipoDate = ipoDate;
	}
	public String getIpoPrice() {
		return ipoPrice;
	}
	public void setIpoPrice(String ipoPrice) {
		this.ipoPrice = ipoPrice;
	}
	public String getClosingIPOPrice() {
		return closingIPOPrice;
	}
	public void setClosingIPOPrice(String closingIPOPrice) {
		this.closingIPOPrice = closingIPOPrice;
	}
	public String getLockUpPeriod() {
		return lockUpPeriod;
	}
	public void setLockUpPeriod(String lockUpPeriod) {
		this.lockUpPeriod = lockUpPeriod;
	}
	public String getUnlockDate() {
		return unlockDate;
	}
	public void setUnlockDate(String unlockDate) {
		this.unlockDate = unlockDate;
	}
	public String getCostPerShare() {
		return costPerShare;
	}
	public void setCostPerShare(String costPerShare) {
		this.costPerShare = costPerShare;
	}
	public String getHoldingShares() {
		return holdingShares;
	}
	public void setHoldingShares(String holdingShares) {
		this.holdingShares = holdingShares;
	}
	public String getSccDilutedOwnership() {
		return sccDilutedOwnership;
	}
	public void setSccDilutedOwnership(String sccDilutedOwnership) {
		this.sccDilutedOwnership = sccDilutedOwnership;
	}
	public String getDinDate() {
		return dinDate;
	}
	public void setDinDate(String dinDate) {
		this.dinDate = dinDate;
	}
	public String getDuppDate() {
		return duppDate;
	}
	public void setDuppDate(String duppDate) {
		this.duppDate = duppDate;
	}
	public String getNuserId() {
		return nuserId;
	}
	public void setNuserId(String nuserId) {
		this.nuserId = nuserId;
	}
	public String getNuserName() {
		return nuserName;
	}
	public void setNuserName(String nuserName) {
		this.nuserName = nuserName;
	}
	
	
}

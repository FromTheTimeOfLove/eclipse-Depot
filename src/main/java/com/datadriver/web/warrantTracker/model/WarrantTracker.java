package com.datadriver.web.warrantTracker.model;

/**
 * 
 * @Acthor：hurentao
 * @ClassName: OnePaper
 * @Description: 实体类
 * @Date 2016-4-12 上午11:34:02
 */
public class WarrantTracker {
	private String warrantTrackerId;//标识
	private String fundName;// 基金名称
	private String fundId;// 基金标识
	private String partner;// 合作伙伴
	private String imminentExit;// 即将退出
	private String companyName;// 公司名称
	private String companyId;// 公司标识
	private String warrantsOwned;// 权证拥有
	private String ivestmentRounds;// 投资轮次
	private String purchasePrice;// 购买价格
	private String exercisePriceSH;// 行使价格/ SH
	private String totalExerciseCost;// 总成本
	private String fvsh;// FV/SH
	private String totalFV;// TOTAL FV
	private String comments;// 备注
	private String quistValuation;// 估值时间
	private String valuePerQuist;// 估值
	private String difference;// 区别
	private String notes;// 说明
	
	public WarrantTracker() {
		super();
	}
	
	public WarrantTracker(String warrantTrackerId, String fundName,
			String partner, String imminentExit, String companyName,
			String warrantsOwned, String ivestmentRounds, String purchasePrice,
			String exercisePriceSH, String totalExerciseCost, String fvsh,
			String totalFV, String comments, String quistValuation,
			String valuePerQuist, String difference, String notes) {
		super();
		this.warrantTrackerId = warrantTrackerId;
		this.fundName = fundName;
		this.partner = partner;
		this.imminentExit = imminentExit;
		this.companyName = companyName;
		this.warrantsOwned = warrantsOwned;
		this.ivestmentRounds = ivestmentRounds;
		this.purchasePrice = purchasePrice;
		this.exercisePriceSH = exercisePriceSH;
		this.totalExerciseCost = totalExerciseCost;
		this.fvsh = fvsh;
		this.totalFV = totalFV;
		this.comments = comments;
		this.quistValuation = quistValuation;
		this.valuePerQuist = valuePerQuist;
		this.difference = difference;
		this.notes = notes;
	}

	public String getWarrantTrackerId() {
		return warrantTrackerId;
	}
	public void setWarrantTrackerId(String warrantTrackerId) {
		this.warrantTrackerId = warrantTrackerId;
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
	public String getPartner() {
		return partner;
	}
	public void setPartner(String partner) {
		this.partner = partner;
	}
	public String getImminentExit() {
		return imminentExit;
	}
	public void setImminentExit(String imminentExit) {
		this.imminentExit = imminentExit;
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
	public String getWarrantsOwned() {
		return warrantsOwned;
	}
	public void setWarrantsOwned(String warrantsOwned) {
		this.warrantsOwned = warrantsOwned;
	}
	public String getIvestmentRounds() {
		return ivestmentRounds;
	}
	public void setIvestmentRounds(String ivestmentRounds) {
		this.ivestmentRounds = ivestmentRounds;
	}
	public String getPurchasePrice() {
		return purchasePrice;
	}
	public void setPurchasePrice(String purchasePrice) {
		this.purchasePrice = purchasePrice;
	}
	public String getExercisePriceSH() {
		return exercisePriceSH;
	}
	public void setExercisePriceSH(String exercisePriceSH) {
		this.exercisePriceSH = exercisePriceSH;
	}
	public String getTotalExerciseCost() {
		return totalExerciseCost;
	}
	public void setTotalExerciseCost(String totalExerciseCost) {
		this.totalExerciseCost = totalExerciseCost;
	}
	public String getFvsh() {
		return fvsh;
	}
	public void setFvsh(String fvsh) {
		this.fvsh = fvsh;
	}
	public String getTotalFV() {
		return totalFV;
	}
	public void setTotalFV(String totalFV) {
		this.totalFV = totalFV;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getQuistValuation() {
		return quistValuation;
	}
	public void setQuistValuation(String quistValuation) {
		this.quistValuation = quistValuation;
	}
	public String getValuePerQuist() {
		return valuePerQuist;
	}
	public void setValuePerQuist(String valuePerQuist) {
		this.valuePerQuist = valuePerQuist;
	}
	public String getDifference() {
		return difference;
	}
	public void setDifference(String difference) {
		this.difference = difference;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
}

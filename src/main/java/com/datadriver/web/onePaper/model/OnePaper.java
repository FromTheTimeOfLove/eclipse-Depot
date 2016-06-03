package com.datadriver.web.onePaper.model;

import org.springframework.web.multipart.MultipartFile;

/**
 * 
 * @Acthor：hurentao
 * @ClassName: OnePaper
 * @Description: 实体类
 * @Date 2016-4-12 上午11:34:02
 */
public class OnePaper {
	private String paperid;// 标识
	private String portfolionameCH;// 投资组合名称（中文）
	private String portfolionameEN;// 投资组合名称（英文）
	private String source;// 来源
	private String investmentthesis;// 投资主题
	private String sectorname;// 领域名称
	private String sectorid;// 领域标识
	private String fundname;// 基金名称
	private String fundid;// 基金标识
	private String stagename;// 阶段名称
	private String stageid;// 阶段标识
	private String statusname;// 状态名称
	private String statusid;// 状态标识
	private String business;// 业务
	private String market;// 市场
	private String product;// 产品
	private String dealpartnerone;// 交易伙伴1
	private String dealpartnertwo;// 交易伙伴2
	private String dealpartnerthi;// 交易伙伴3
	private String pricing;// 定价
	private String financials;// 金融股
	private String customersid;// 客户标识
	private String customersname;// 客户名称
	private String competitorsid;// 竞争对手标识
	private String competitorsname;// 竞争对手名称
	private String teamid;// 团队标识
	private String teamname;// 团队名称
	private String board;// 董事会
	private String dealterms;// 交易条款
	private String valuation;// 估值
	private String dpdate;// 日期
	private String attachmentid;// 附件Id
	private String attachmentname;// 附件名称
	private MultipartFile attachment;

	public String getPaperid() {
		return paperid;
	}

	public void setPaperid(String paperid) {
		this.paperid = paperid;
	}

	public String getPortfolionameCH() {
		return portfolionameCH;
	}

	public void setPortfolionameCH(String portfolionameCH) {
		this.portfolionameCH = portfolionameCH;
	}

	public String getPortfolionameEN() {
		return portfolionameEN;
	}

	public void setPortfolionameEN(String portfolionameEN) {
		this.portfolionameEN = portfolionameEN;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getInvestmentthesis() {
		return investmentthesis;
	}

	public void setInvestmentthesis(String investmentthesis) {
		this.investmentthesis = investmentthesis;
	}

	public String getSectorname() {
		return sectorname;
	}

	public void setSectorname(String sectorname) {
		this.sectorname = sectorname;
	}

	public String getSectorid() {
		return sectorid;
	}

	public void setSectorid(String sectorid) {
		this.sectorid = sectorid;
	}

	public String getFundname() {
		return fundname;
	}

	public void setFundname(String fundname) {
		this.fundname = fundname;
	}

	public String getFundid() {
		return fundid;
	}

	public void setFundid(String fundid) {
		this.fundid = fundid;
	}

	public String getStagename() {
		return stagename;
	}

	public void setStagename(String stagename) {
		this.stagename = stagename;
	}

	public String getStageid() {
		return stageid;
	}

	public void setStageid(String stageid) {
		this.stageid = stageid;
	}

	public String getStatusname() {
		return statusname;
	}

	public void setStatusname(String statusname) {
		this.statusname = statusname;
	}

	public String getStatusid() {
		return statusid;
	}

	public void setStatusid(String statusid) {
		this.statusid = statusid;
	}

	public String getBusiness() {
		return business;
	}

	public void setBusiness(String business) {
		this.business = business;
	}

	public String getMarket() {
		return market;
	}

	public void setMarket(String market) {
		this.market = market;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getDealpartnerone() {
		return dealpartnerone;
	}

	public void setDealpartnerone(String dealpartnerone) {
		this.dealpartnerone = dealpartnerone;
	}

	public String getDealpartnertwo() {
		return dealpartnertwo;
	}

	public void setDealpartnertwo(String dealpartnertwo) {
		this.dealpartnertwo = dealpartnertwo;
	}

	public String getDealpartnerthi() {
		return dealpartnerthi;
	}

	public void setDealpartnerthi(String dealpartnerthi) {
		this.dealpartnerthi = dealpartnerthi;
	}

	public String getPricing() {
		return pricing;
	}

	public void setPricing(String pricing) {
		this.pricing = pricing;
	}

	public String getFinancials() {
		return financials;
	}

	public void setFinancials(String financials) {
		this.financials = financials;
	}

	public String getCustomersid() {
		return customersid;
	}

	public void setCustomersid(String customersid) {
		this.customersid = customersid;
	}

	public String getCustomersname() {
		return customersname;
	}

	public void setCustomersname(String customersname) {
		this.customersname = customersname;
	}

	public String getCompetitorsid() {
		return competitorsid;
	}

	public void setCompetitorsid(String competitorsid) {
		this.competitorsid = competitorsid;
	}

	public String getCompetitorsname() {
		return competitorsname;
	}

	public void setCompetitorsname(String competitorsname) {
		this.competitorsname = competitorsname;
	}

	public String getTeamid() {
		return teamid;
	}

	public void setTeamid(String teamid) {
		this.teamid = teamid;
	}

	public String getTeamname() {
		return teamname;
	}

	public void setTeamname(String teamname) {
		this.teamname = teamname;
	}

	public String getBoard() {
		return board;
	}

	public void setBoard(String board) {
		this.board = board;
	}

	public String getDealterms() {
		return dealterms;
	}

	public void setDealterms(String dealterms) {
		this.dealterms = dealterms;
	}

	public String getValuation() {
		return valuation;
	}

	public void setValuation(String valuation) {
		this.valuation = valuation;
	}

	public String getDpdate() {
		return dpdate;
	}

	public void setDpdate(String dpdate) {
		this.dpdate = dpdate;
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

	public MultipartFile getAttachment() {
		return attachment;
	}

	public void setAttachment(MultipartFile attachment) {
		this.attachment = attachment;
	}

}

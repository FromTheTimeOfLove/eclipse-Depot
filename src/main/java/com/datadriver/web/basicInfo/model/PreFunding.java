package com.datadriver.web.basicInfo.model;

import com.datadriver.web.common.model.DataDictionary;
import com.datadriver.web.file.model.DocumentEntity;

/**
 * 
 * @Acthor：hurentao
 * @ClassName: PreFunding
 * @Description: pre funding实体类
 * @Date 2016-4-25 上午10:04:31
 */
public class PreFunding {
	
	private String preId;//标识
	private String basicInfoId;// basicInfo标识
	private DocumentEntity vapprovalFunding;// Neil's approval for funding
	private DocumentEntity vinvestmemo;// 投资备忘录  
	private DocumentEntity vgdfc;// GDOT/FCPA 
	private DocumentEntity vlddreport;// LDD报告
	private DocumentEntity vfddreport;// FDD报告
	private DocumentEntity vgroupChart;// 组图
	private DocumentEntity vcapTable;// 盖表 
	private DocumentEntity vlegalopinion;// 法律意见书（无减免） 
	private String vdealTeamto;// 交易团队于
	private String vdealTeamtoRemark;//交易团队备注
	private String indate;// 录入时间
	private String vconditions;// 收盘的所有条件达成或获豁免
	private String vconditionsRemark;// 收盘的所有条件达成或获豁免备注
	private DocumentEntity vsequoia;// 签署的协议声明，我们红杉的名字任何使用 
	private String vlegalNameCH;// 合法名称中文
	private String vlegalNameEN;// 合法名称英文
	private String destablished;// 成立日期
	private String varea;// 所在地
	private String vcompanyContact;// 公司联络人姓名 
	private String vtitle;// 主题
	private String vemailAddress;// 邮箱地址
	private String vphone;// 电话
	private DataDictionary vfund;// 基金
	private String vstealth;// 隐形
	private DataDictionary vtype;// 类型
	private String prefundingDate;// 投资日期
	private String namountFund;// 资金量
	private String vseries;// 系列
	private DataDictionary fundingtype;// 资助类型
	private String vownership;// 所有权
	private String vlead;// 领导
	private String vbod;//  
	private String vsupervisor;// 管理者
	private String vfddmember;// FDD成员
	private String npreMoney;// pre金额
	private String npostMoney;// post金额
	private DataDictionary vinvestPace;// 投资步伐
	private String leadingInvest;// 主导投资
	private String leadingInvestRemark;// 主导投资备注
	private String commonInvestorInfo;// 共同投资人信息
	private String vremark;// 备注
	
	public PreFunding() {
		super();
	}
	
	public DocumentEntity getVapprovalFunding() {
		return vapprovalFunding;
	}

	public void setVapprovalFunding(DocumentEntity vapprovalFunding) {
		this.vapprovalFunding = vapprovalFunding;
	}

	public String getVdealTeamtoRemark() {
		return vdealTeamtoRemark;
	}

	public void setVdealTeamtoRemark(String vdealTeamtoRemark) {
		this.vdealTeamtoRemark = vdealTeamtoRemark;
	}

	public String getPreId() {
		return preId;
	}
	public void setPreId(String preId) {
		this.preId = preId;
	}
	public String getBasicInfoId() {
		return basicInfoId;
	}
	public void setBasicInfoId(String basicInfoId) {
		this.basicInfoId = basicInfoId;
	}
	public DocumentEntity getVinvestmemo() {
		return vinvestmemo;
	}
	public void setVinvestmemo(DocumentEntity vinvestmemo) {
		this.vinvestmemo = vinvestmemo;
	}
	public DocumentEntity getVgdfc() {
		return vgdfc;
	}
	public void setVgdfc(DocumentEntity vgdfc) {
		this.vgdfc = vgdfc;
	}
	public DocumentEntity getVlddreport() {
		return vlddreport;
	}
	public void setVlddreport(DocumentEntity vlddreport) {
		this.vlddreport = vlddreport;
	}
	public DocumentEntity getVfddreport() {
		return vfddreport;
	}
	public void setVfddreport(DocumentEntity vfddreport) {
		this.vfddreport = vfddreport;
	}
	public DocumentEntity getVgroupChart() {
		return vgroupChart;
	}
	public void setVgroupChart(DocumentEntity vgroupChart) {
		this.vgroupChart = vgroupChart;
	}
	public DocumentEntity getVcapTable() {
		return vcapTable;
	}
	public void setVcapTable(DocumentEntity vcapTable) {
		this.vcapTable = vcapTable;
	}
	public DocumentEntity getVlegalopinion() {
		return vlegalopinion;
	}
	public void setVlegalopinion(DocumentEntity vlegalopinion) {
		this.vlegalopinion = vlegalopinion;
	}
	public String getVdealTeamto() {
		return vdealTeamto;
	}
	public void setVdealTeamto(String vdealTeamto) {
		this.vdealTeamto = vdealTeamto;
	}
	public String getIndate() {
		return indate;
	}
	public void setIndate(String indate) {
		this.indate = indate;
	}
	public String getVconditions() {
		return vconditions;
	}
	public void setVconditions(String vconditions) {
		this.vconditions = vconditions;
	}
	public DocumentEntity getVsequoia() {
		return vsequoia;
	}
	public void setVsequoia(DocumentEntity vsequoia) {
		this.vsequoia = vsequoia;
	}
	public String getVlegalNameCH() {
		return vlegalNameCH;
	}
	public void setVlegalNameCH(String vlegalNameCH) {
		this.vlegalNameCH = vlegalNameCH;
	}
	public String getVlegalNameEN() {
		return vlegalNameEN;
	}
	public void setVlegalNameEN(String vlegalNameEN) {
		this.vlegalNameEN = vlegalNameEN;
	}
	public String getDestablished() {
		return destablished;
	}
	public void setDestablished(String destablished) {
		this.destablished = destablished;
	}
	public String getVarea() {
		return varea;
	}
	public void setVarea(String varea) {
		this.varea = varea;
	}
	public String getVcompanyContact() {
		return vcompanyContact;
	}
	public void setVcompanyContact(String vcompanyContact) {
		this.vcompanyContact = vcompanyContact;
	}
	public String getVtitle() {
		return vtitle;
	}
	public void setVtitle(String vtitle) {
		this.vtitle = vtitle;
	}
	
	public String getVemailAddress() {
		return vemailAddress;
	}

	public void setVemailAddress(String vemailAddress) {
		this.vemailAddress = vemailAddress;
	}

	public String getVphone() {
		return vphone;
	}
	public void setVphone(String vphone) {
		this.vphone = vphone;
	}
	public DataDictionary getVfund() {
		return vfund;
	}
	public void setVfund(DataDictionary vfund) {
		this.vfund = vfund;
	}
	public String getVstealth() {
		return vstealth;
	}
	public void setVstealth(String vstealth) {
		this.vstealth = vstealth;
	}
	public DataDictionary getVtype() {
		return vtype;
	}
	public void setVtype(DataDictionary vtype) {
		this.vtype = vtype;
	}
	public String getPrefundingDate() {
		return prefundingDate;
	}

	public void setPrefundingDate(String prefundingDate) {
		this.prefundingDate = prefundingDate;
	}

	public String getNamountFund() {
		return namountFund;
	}
	public void setNamountFund(String namountFund) {
		this.namountFund = namountFund;
	}
	public String getVseries() {
		return vseries;
	}
	public void setVseries(String vseries) {
		this.vseries = vseries;
	}
	public DataDictionary getFundingtype() {
		return fundingtype;
	}
	public void setFundingtype(DataDictionary fundingtype) {
		this.fundingtype = fundingtype;
	}
	public String getVownership() {
		return vownership;
	}
	public void setVownership(String vownership) {
		this.vownership = vownership;
	}
	public String getVlead() {
		return vlead;
	}
	public void setVlead(String vlead) {
		this.vlead = vlead;
	}
	public String getVbod() {
		return vbod;
	}
	public void setVbod(String vbod) {
		this.vbod = vbod;
	}
	public String getVsupervisor() {
		return vsupervisor;
	}
	public void setVsupervisor(String vsupervisor) {
		this.vsupervisor = vsupervisor;
	}
	public String getVfddmember() {
		return vfddmember;
	}
	public void setVfddmember(String vfddmember) {
		this.vfddmember = vfddmember;
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
	public DataDictionary getVinvestPace() {
		return vinvestPace;
	}
	public void setVinvestPace(DataDictionary vinvestPace) {
		this.vinvestPace = vinvestPace;
	}
	public String getVremark() {
		return vremark;
	}
	public void setVremark(String vremark) {
		this.vremark = vremark;
	}

	public String getVconditionsRemark() {
		return vconditionsRemark;
	}

	public void setVconditionsRemark(String vconditionsRemark) {
		this.vconditionsRemark = vconditionsRemark;
	}

	public String getLeadingInvest() {
		return leadingInvest;
	}

	public void setLeadingInvest(String leadingInvest) {
		this.leadingInvest = leadingInvest;
	}

	public String getLeadingInvestRemark() {
		return leadingInvestRemark;
	}

	public void setLeadingInvestRemark(String leadingInvestRemark) {
		this.leadingInvestRemark = leadingInvestRemark;
	}

	public String getCommonInvestorInfo() {
		return commonInvestorInfo;
	}

	public void setCommonInvestorInfo(String commonInvestorInfo) {
		this.commonInvestorInfo = commonInvestorInfo;
	}
}

package com.datadriver.web.basicInfo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.datadriver.core.entity.Result;
import com.datadriver.core.entity.UnitedException;
import com.datadriver.core.entity.UnitedLogger;
import com.datadriver.core.export.ExcelFile;
import com.datadriver.core.export.ExportExcelDealTitle;
import com.datadriver.core.feature.orm.page.DataTablePage;
import com.datadriver.core.util.JSONUtils;
import com.datadriver.core.util.Utils;
import com.datadriver.web.basicInfo.dto.BasicInfoDto;
import com.datadriver.web.basicInfo.model.BasicInfo;
import com.datadriver.web.basicInfo.model.DealTeam_compliance;
import com.datadriver.web.basicInfo.model.DealTeam_confirmation;
import com.datadriver.web.basicInfo.model.LegalTeam_compliance;
import com.datadriver.web.basicInfo.model.LegalTeam_confirmation;
import com.datadriver.web.basicInfo.service.BasicInfoService;
import com.datadriver.web.common.enums.DictionaryType;
import com.datadriver.web.common.enums.FinalParamer;
import com.datadriver.web.common.enums.ResultEnum;
import com.datadriver.web.common.enums.SessionAttribute;
import com.datadriver.web.common.model.DataDictionary;
import com.datadriver.web.common.service.DataDictionaryService;
import com.datadriver.web.onePaper.model.OnePaper;
import com.datadriver.web.system.model.SystemUser;
import com.datadriver.web.user.model.User;
import com.datadriver.web.user.service.UserService;
import com.datadriver.web.file.model.DocumentEntity;
import com.github.pagehelper.PageInfo;

/**
 * @ClassName: BasicInfoController
 * @Description: Basic info 控制类
 * @date 2016-3-22 上午10:46:22
 */
@Controller
@RequestMapping(value = "/basicInfo")
public class BasicInfoController {

	@Resource
	private DataDictionaryService dataDictionaryService;

	@Resource
	private BasicInfoService basicinfoservice;

	@Resource
	private UserService userService;
	
	@RequestMapping(value = "/ininFile.do", method = RequestMethod.GET)
	public String ininFile(Model model){
		return "basicInfo/testFile";
	}
	
	/**
	 * 
	 * @Title: initLagalTeam
	 * @Description: 初始化LagelTeam
	 * @param model
	 * @return String 返回类型
	 */
	@RequestMapping(value = "/initLagalTeam.do", method = RequestMethod.POST)
	public String initLagalTeam(Model model, HttpServletRequest request, @ModelAttribute("legalTeam") LegalTeam_confirmation legalTeam){
		model.addAttribute("legalTeam",legalTeam);
		return "basicInfo/legalPnoteTeam_confirmation";
	}
	
	/**
	 * 
	 * @Title: initDealTeam
	 * @Description: 初始化DealTeam
	 * @param model
	 * @return String 返回类型
	 */
	@RequestMapping(value = "/initDealTeam.do", method = RequestMethod.POST)
	public String initDealTeam(Model model, HttpServletRequest request, @ModelAttribute("dealTeam") DealTeam_confirmation dealTeam){
		model.addAttribute("dealTeam",dealTeam);
		return "basicInfo/dealPnoteTeam_confirmation";
	}
	
	/**
	 * 
	 * @Title: initLagalTeam_compliance
	 * @Description: 初始化initLagalTeam_compliance
	 * @param model
	 * @return String 返回类型
	 */
	@RequestMapping(value = "/initLagalTeam_compliance.do", method = RequestMethod.POST)
	public String initLagalTeam_compliance(Model model, HttpServletRequest request, @ModelAttribute("legalTeam") LegalTeam_compliance legalTeam){
		model.addAttribute("legalTeam",legalTeam);
		return "basicInfo/legalPnoteTeam_compliance";
	}
	
	/**
	 * 
	 * @Title: initDealTeam_compliance
	 * @Description: 初始化initDealTeam_compliance
	 * @param model
	 * @return String 返回类型
	 */
	@RequestMapping(value = "/initDealTeam_compliance.do", method = RequestMethod.POST)
	public String initDealTeam_compliance(Model model, HttpServletRequest request, @ModelAttribute("dealTeam") DealTeam_compliance dealTeam){
		model.addAttribute("dealTeam",dealTeam);
		return "basicInfo/dealPnoteTeam_compliance";
	}

	/**
	 * @Title: initListBasicInfo
	 * @Description: 初始化BasicInfo页面
	 * @return String 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/initListBasicInfoPage.do", method = RequestMethod.GET)
	public String initListBasicInfo(Model model) {
		try {
			//领域
			List<DataDictionary> sectorDatas = dataDictionaryService.selectByType(DictionaryType.SECTOR_TYPE);
			//阶段
			List<DataDictionary> stageDatas = dataDictionaryService.selectByType(DictionaryType.STAGE_TYPE);
			//基金
			List<DataDictionary> fundDatas = dataDictionaryService.selectFunds();
			model.addAttribute("sectorDatas", sectorDatas);
			model.addAttribute("stageDatas", stageDatas);
			model.addAttribute("fundDatas", fundDatas);
		} catch (Exception e) {
			UnitedLogger.error(e);
			model.addAttribute(FinalParamer.MESSAGE, e.getMessage());
			model.addAttribute(FinalParamer.RESULT, ResultEnum.FAIL.getValue());
		}
		return "basicInfo/list_basicInfo";
	}
	
	/**
	 * @Title: initAddBasicInfo
	 * @Description: 初始化BasicInfo页面
	 * @return String 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/initAddBasicInfo.do", method = RequestMethod.GET)
	public String initAddBasicInfo(Model model, HttpServletRequest request,
			@RequestParam("universalId") String universalId,
			@RequestParam("universalStr") boolean universalStr) {
		try {
			//获取用户信息
			HttpSession session = request.getSession();
			SystemUser us = (SystemUser) session
					.getAttribute(SessionAttribute.USERINFO);
			User user = userService.selectById(Long.valueOf(us.getUserId()));
			//领域
			List<DataDictionary> sectorDatas = dataDictionaryService.
					selectByType(DictionaryType.SECTOR_TYPE);
			//基金
			List<DataDictionary> fundDatas = dataDictionaryService.selectFunds();
			//类型
			List<DataDictionary> typeDatas = dataDictionaryService.
					selectByType(DictionaryType.TYPE_TYPE);
			//fundingType类型
			List<DataDictionary> fundingTypeDatas = dataDictionaryService.
					selectByType(DictionaryType.FUNDING_TYPE);
			//development Stage
			List<DataDictionary> developmentStageDatas = dataDictionaryService.
					selectByType(DictionaryType.DEVELOPMENT_STAGE);
			
			//investMent Stage
			List<DataDictionary> investMentStageDatas = dataDictionaryService.
					selectByType(DictionaryType.INVESTMENT_STAGE);
			
			//dealSource
			List<DataDictionary> dealSourceDatas = dataDictionaryService.
					selectByType(DictionaryType.DEAL_SOURCE);
			//fddMember
			List<DataDictionary> fddMemberDatas = dataDictionaryService.selectUsers();
			BasicInfo basicinfo = new BasicInfo();
			OnePaper onePaper = new OnePaper();
			String comPlianceDeal="",comPlianceLegal="",confirmationDeal="",confirmationLegal="";
			//universalStr==true为编辑，否则为添加
			if(universalStr) {//编辑时universalId为basic Info的id
				String[] idArr = universalId.split(",");//分割成basicInfo的id与onepaper的id
				onePaper = basicinfoservice.selectPaperById(idArr[1]);//查询onepaper
				//top树
				List<DataDictionary> datas = basicinfoservice.selectTreeLi(idArr[1]);
				//根据basic Info 的id查询
				//basic Info
				basicinfo = basicinfoservice.queryBasicInfoObj(idArr[0]);
				onePaper = basicinfoservice.selectPaperById(idArr[1]);
				comPlianceDeal = basicinfoservice.selectLisgaggStr(idArr[0], DictionaryType.COMPLIANCE_DEAL);
				comPlianceLegal = basicinfoservice.selectLisgaggStr(idArr[0], DictionaryType.COMPLIANCE_LEGAL);
				confirmationDeal = basicinfoservice.selectLisgaggStr(idArr[0], DictionaryType.CONFIRMATION_DEAL);
				confirmationLegal = basicinfoservice.selectLisgaggStr(idArr[0], DictionaryType.CONFIRMATION_LEGAL);
				model.addAttribute("dataResults", datas);
			} else { //添加时universalId为one paper的id
				//根据id查询one paper详情
				onePaper = basicinfoservice.selectPaperById(universalId);
			}
			//拼接合作伙伴
			if(!Utils.isEmpty(onePaper.getDealpartnerone())) {
				basicinfo.setDealPartner(onePaper.getDealpartnerone()+",");
			}
			if(!Utils.isEmpty(onePaper.getDealpartnertwo())) {
				basicinfo.setDealPartner(basicinfo.getDealPartner()+onePaper.getDealpartnertwo()+",");
			}
			if(!Utils.isEmpty(onePaper.getDealpartnerthi())) {
				basicinfo.setDealPartner(basicinfo.getDealPartner()+onePaper.getDealpartnerthi()+",");
			}
			if(!Utils.isEmpty(basicinfo.getDealPartner())) {
				String dealPartner = basicinfo.getDealPartner().substring(0, basicinfo.getDealPartner().length()-1);
				basicinfo.setDealPartner(dealPartner);
			}
			model.addAttribute("comPlianceDeal", Utils.replaceSymbol(comPlianceDeal, ",", "&"));
			model.addAttribute("comPlianceLegal", Utils.replaceSymbol(comPlianceLegal, ",", "&"));
			model.addAttribute("confirmationDeal", Utils.replaceSymbol(confirmationDeal, ",", "&"));
			model.addAttribute("confirmationLegal", Utils.replaceSymbol(confirmationLegal, ",", "&"));
			model.addAttribute("user", user);
			model.addAttribute("developmentStageDatas", developmentStageDatas);
			model.addAttribute("investMentStageDatas", investMentStageDatas);
			model.addAttribute("dealSourceDatas", dealSourceDatas);
			model.addAttribute("fddMemberDatas", fddMemberDatas);
			model.addAttribute("sectorDatas", sectorDatas);
			model.addAttribute("fundDatas", fundDatas);
			model.addAttribute("basicInfo", basicinfo);
			model.addAttribute("onePaper", onePaper);
			model.addAttribute("typeDatas", typeDatas);
			model.addAttribute("fundingTypeDatas", fundingTypeDatas);
			model.addAttribute("universalStr", universalStr);
		} catch (NumberFormatException e) {
			UnitedLogger.error(e);  
			model.addAttribute(FinalParamer.MESSAGE, e.getMessage());
			model.addAttribute(FinalParamer.RESULT, ResultEnum.FAIL.getValue());
		} catch (UnitedException e) {
			UnitedLogger.error(e);
			model.addAttribute(FinalParamer.MESSAGE,
					e.loadErrorMessageByCode(request));
			model.addAttribute(FinalParamer.RESULT, ResultEnum.FAIL.getValue());
		}
		return "basicInfo/add_basicInfo";
	}
	
	
	@RequestMapping(value = "/queryTreeLiList.do", method = RequestMethod.POST)
	@ResponseBody
	public Result queryTreeLiList(Model model,
			HttpServletRequest request,
			@ModelAttribute("id") String id) {
		Result result = new Result();
		try {
			List<DataDictionary> data = basicinfoservice.selectTreeLi(id);
			result.setResultCode(ResultEnum.SUCCESS.getValue());
			result.setMessage(JSONObject.toJSONString(data));
		} catch (Exception e) {
			result.setResultCode(ResultEnum.ERROR.getValue());
		}
		return result;
	} 

	/**
	 * 获取Basic Info 信息
	 * 
	 * @param model
	 * @param request
	 * @param basicinfoDto
	 * @return
	 */
	@RequestMapping(value = "/findListBasicInfo.do", method = RequestMethod.POST)
	@ResponseBody
	public DataTablePage<BasicInfo> findListBasicInfo(Model model,
			HttpServletRequest request,
			@ModelAttribute("basicinfoDto") BasicInfoDto basicinfoDto) {
		// 实例化分页插件
		DataTablePage<BasicInfo> basicinfoPageList = new DataTablePage<BasicInfo>(
				request);
		try {
			// 验证是否为空，不为空时添加到session
			//if (!Utils.isEmpty(basicinfoDto.getPortfolioNameCH())) {
				// 获得session
				HttpSession session = request.getSession();
				// 把投资组合中文名称存入session
				session.setAttribute("portfolioNameCH",
						basicinfoDto.getPortfolioNameCH());
			//}
			// 设置分页参数（当前页码、每页显示大小、排序参数）
			basicinfoDto.setPageNum(basicinfoPageList.getPageNum());
			basicinfoDto.setPageSize(basicinfoPageList.getLength());

			PageInfo<BasicInfo> stuList = basicinfoservice
					.findBasicInfoListbyDto(basicinfoDto);
			// 转换提取成DataTablePage的分页参数
			basicinfoPageList = basicinfoPageList.transfer(basicinfoPageList,
					stuList);
		} catch (UnitedException e) {
			UnitedLogger.error(e);
			model.addAttribute(FinalParamer.MESSAGE,
					e.loadErrorMessageByCode(request));
			model.addAttribute(FinalParamer.RESULT, ResultEnum.FAIL.getValue());
		}
		return basicinfoPageList;
	}

	@RequestMapping(value = "/findBasicInfoByPaper.do", method = RequestMethod.POST)
	@ResponseBody
	public List<BasicInfo> findBasicInfoByPaper(Model model,
			HttpServletRequest request,
			@ModelAttribute("paperid") String paperid) {
		// 实例化分页插件
		//DataTablePage<BasicInfo> basicinfoPageList = new DataTablePage<BasicInfo>(request);
		List<BasicInfo> basicInfos = new ArrayList<BasicInfo>();
		try {
			// 设置分页参数（当前页码、每页显示大小、排序参数）
			//basicinfoDto.setPageNum(basicinfoPageList.getPageNum());
			//basicinfoDto.setPageSize(basicinfoPageList.getLength());
			basicInfos = basicinfoservice.findBasicInfo(paperid);
			// 转换提取成DataTablePage的分页参数
			//basicinfoPageList = basicinfoPageList.transfer(basicinfoPageList,basicInfos);
		} catch (UnitedException e) {
			UnitedLogger.error(e);
			model.addAttribute(FinalParamer.MESSAGE,
					e.loadErrorMessageByCode(request));
			model.addAttribute(FinalParamer.RESULT, ResultEnum.FAIL.getValue());
		}
		return basicInfos;
	}
	
	/**
	 * 
	 * @Title: saveDocInfo
	 * @Description: 添加文档
	 * @param doc
	 * @return DocumentEntity 返回类型
	 */
	public DocumentEntity saveDocInfo(DocumentEntity doc, HttpServletRequest request) {
		try {
			//验证文档对象是否为空
			if(!Utils.isEmpty(doc.getFileName()) && !Utils.isEmpty(doc.getFilePath())) {
				//获取用户信息
				HttpSession session = request.getSession();
				SystemUser user = (SystemUser) session
						.getAttribute(SessionAttribute.USERINFO);
				if (!Utils.isEmpty(user)) {
					doc.setUpdateUserId(user.getUserId());
					doc.setUpdateUserName(user.getUserName());
					doc.setUserId(user.getUserId());
					doc.setUserName(user.getUserName());
				}
				//添加文档
				basicinfoservice.insertDocument(doc);
			}
		} catch (Exception e) {
			UnitedLogger.error(e);
			System.out.println(e.getMessage());
		}
		return doc;
	}
	
	/**
	 * 
	 * @Title: updateDocbyId
	 * @Description: 批量修改文档信息
	 * @param list void 返回类型
	 */
	public void updateDocbyId(List<DocumentEntity> list, HttpServletRequest request) {
		try {
			if(!Utils.isEmpty(list)) {
				//获取用户信息
				HttpSession session = request.getSession();
				SystemUser user = (SystemUser) session
						.getAttribute(SessionAttribute.USERINFO);
				//循环修改文档信息
				for (DocumentEntity doc : list) {
					if (!Utils.isEmpty(user)) {
						doc.setUpdateUserId(user.getUserId());
						doc.setUpdateUserName(user.getUserName());
					}
					//若名称与路径为空，则修改删除标识为1
					if(Utils.isEmpty(doc.getFileName()) && Utils.isEmpty(doc.getFilePath()))
						doc.setThruDate("1");
					//更新文档
					basicinfoservice.updateDocument(doc);
				}
			}
		} catch (Exception e) {
			UnitedLogger.error(e);
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * 
	 * @Title: saveBasicInfo
	 * @Description: 保存
	 * @param basicinfo
	 * @param preFunding
	 * @param postFunding
	 * @return Result 返回类型
	 */
	@RequestMapping(value = "/saveBasicInfo.do", method = RequestMethod.POST)
	@ResponseBody
	public Result saveBasicInfo(HttpServletRequest request, 
			@ModelAttribute("basicinfo") BasicInfo basicinfo,
			@ModelAttribute("complianceDeal") DealTeam_compliance complianceDeal,
			@ModelAttribute("confirmationDeal") DealTeam_confirmation confirmationDeal,
			@ModelAttribute("complianceLegal") LegalTeam_compliance complianceLegal,
			@ModelAttribute("confirmationLegal") LegalTeam_confirmation confirmationLegal){
		Result result = new Result();
		try {
			//当basicInfo的id不为空时，则为编辑，否则为添加
			if(!Utils.isEmpty(basicinfo.getBasicInfoId())) {
				List<DocumentEntity> docs_edit = new ArrayList<DocumentEntity>();
				List<DocumentEntity> docs_add = new ArrayList<DocumentEntity>();
				if(!Utils.isEmpty(basicinfo.getOnepBridgeLoan().getFileId())) {
					if(!Utils.isEmpty(basicinfo.getOnepBridgeLoan().getFileName()) &&
							!Utils.isEmpty(basicinfo.getOnepBridgeLoan().getFilePath())) {
						docs_edit.add(basicinfo.getOnepBridgeLoan());
					} else {
						docs_add.add(basicinfo.getOnepBridgeLoan());
					}
				} else {
					basicinfo.setOnepBridgeLoan(saveDocInfo(basicinfo.getOnepBridgeLoan(), request));
				}
				if(!Utils.isEmpty(basicinfo.getLddReport().getFileId())) {
					if(!Utils.isEmpty(basicinfo.getLddReport().getFileName()) &&
							!Utils.isEmpty(basicinfo.getLddReport().getFilePath())) {
						docs_edit.add(basicinfo.getLddReport());
					} else {
						docs_add.add(basicinfo.getLddReport());
					}
				} else {
					basicinfo.setLddReport(saveDocInfo(basicinfo.getLddReport(), request));
				}
				if(!Utils.isEmpty(basicinfo.getFddReport().getFileId())) {
					if(!Utils.isEmpty(basicinfo.getFddReport().getFileName()) &&
							!Utils.isEmpty(basicinfo.getFddReport().getFilePath())) {
						docs_edit.add(basicinfo.getFddReport());
					} else {
						docs_add.add(basicinfo.getFddReport());
					}
				} else {
					basicinfo.setFddReport(saveDocInfo(basicinfo.getFddReport(), request));
				}
				if(!Utils.isEmpty(basicinfo.getGroupChart().getFileId())) {
					if(!Utils.isEmpty(basicinfo.getGroupChart().getFileName()) &&
							!Utils.isEmpty(basicinfo.getGroupChart().getFilePath())) {
						docs_edit.add(basicinfo.getGroupChart());
					} else {
						docs_add.add(basicinfo.getGroupChart());
					}
				} else {
					basicinfo.setGroupChart(saveDocInfo(basicinfo.getGroupChart(), request));
				}
				if(!Utils.isEmpty(basicinfo.getWireInstruction().getFileId())) {
					if(!Utils.isEmpty(basicinfo.getWireInstruction().getFileName()) &&
							!Utils.isEmpty(basicinfo.getWireInstruction().getFilePath())) {
						docs_edit.add(basicinfo.getWireInstruction());
					} else {
						docs_add.add(basicinfo.getWireInstruction());
					}
				} else {
					basicinfo.setWireInstruction(saveDocInfo(basicinfo.getWireInstruction(), request));
				}
				if(!Utils.isEmpty(basicinfo.getRepLetter().getFileId())) {
					if(!Utils.isEmpty(basicinfo.getRepLetter().getFileName()) &&
							!Utils.isEmpty(basicinfo.getRepLetter().getFilePath())) {
						docs_edit.add(basicinfo.getRepLetter());
					} else {
						docs_add.add(basicinfo.getRepLetter());
					}
				} else {
					basicinfo.setRepLetter(saveDocInfo(basicinfo.getRepLetter(), request));
				}
				if(!Utils.isEmpty(basicinfo.getTransactionDocs().getFileId())) {
					if(!Utils.isEmpty(basicinfo.getTransactionDocs().getFileName()) &&
							!Utils.isEmpty(basicinfo.getTransactionDocs().getFilePath())) {
						docs_edit.add(basicinfo.getTransactionDocs());
					} else {
						docs_add.add(basicinfo.getTransactionDocs());
					}
				} else {
					basicinfo.setTransactionDocs(saveDocInfo(basicinfo.getTransactionDocs(), request));
				}
				if(!Utils.isEmpty(basicinfo.getLatestFinancialStatements().getFileId())) {
					if(!Utils.isEmpty(basicinfo.getLatestFinancialStatements().getFileName()) &&
							!Utils.isEmpty(basicinfo.getLatestFinancialStatements().getFilePath())) {
						docs_edit.add(basicinfo.getLatestFinancialStatements());
					} else {
						docs_add.add(basicinfo.getLatestFinancialStatements());
					}
				} else {
					basicinfo.setLatestFinancialStatements(saveDocInfo(basicinfo.getLatestFinancialStatements(), request));
				}
				basicinfoservice.updateByIdBasicInfo(basicinfo);//编辑basicInfo
				basicinfoservice.deleteTeam(basicinfo.getBasicInfoId());//删除ComplianceOrConfirmation
				updateDocbyId(docs_add, request);//做删除，文档不物理删除
				updateDocbyId(docs_edit, request);//修改文档信息
			} else {
				//docs
				basicinfo.setOnepBridgeLoan(saveDocInfo(basicinfo.getOnepBridgeLoan(), request));
				basicinfo.setLddReport(saveDocInfo(basicinfo.getLddReport(), request));
				basicinfo.setFddReport(saveDocInfo(basicinfo.getFddReport(), request));
				basicinfo.setGroupChart(saveDocInfo(basicinfo.getGroupChart(), request));
				basicinfo.setWireInstruction(saveDocInfo(basicinfo.getWireInstruction(), request));
				basicinfo.setRepLetter(saveDocInfo(basicinfo.getRepLetter(), request));
				basicinfo.setTransactionDocs(saveDocInfo(basicinfo.getTransactionDocs(), request));
				basicinfo.setLatestFinancialStatements(saveDocInfo(basicinfo.getLatestFinancialStatements(), request));
				basicinfoservice.insertBasicInfo(basicinfo);//添加basicInfo
			}
			//保存 Compliance-ConfirmationTeam
			saveComplianceOrConfirmationTeam(basicinfo.getBasicInfoId(), complianceDeal, confirmationDeal, 
				complianceLegal, confirmationLegal);
			
			result.setMessage(ResultEnum.SUCCESS.getText());
			result.setResultCode(ResultEnum.SUCCESS.getValue());
		} catch (Exception e) {
			UnitedLogger.error(e);
			result.setResultCode(ResultEnum.FAIL.getValue());
			result.setMessage(e.getMessage());
		}
		return result;
	}
	
	/**
	 * 
	 * @Title: saveComplianceOrConfirmationTeam
	 * @Description: 保存ComplianceOrConfirmation
	 * @param basicInfoId void 返回类型
	 */
	public void saveComplianceOrConfirmationTeam(String basicInfoId, DealTeam_compliance complianceDeal,
			 DealTeam_confirmation confirmationDeal, LegalTeam_compliance complianceLegal,
			 LegalTeam_confirmation confirmationLegal ) {
		if(!Utils.isEmpty(basicInfoId)) {
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> maps = new HashMap<String, Object>();
			//complianceDeal 
			maps = JSONUtils.toMap(JSONUtils.toJson(complianceDeal), false);
			maps.remove("exportTitle");
			if(!Utils.isEmpty(maps)) {
				map = new HashMap<String, Object>();
				map.put("maps", maps);
				map.put("teamType", DictionaryType.COMPLIANCE_DEAL);
				map.put("foreignKey", basicInfoId);
				map.put("module", "0");
				basicinfoservice.insertTeam(map);
			}
			//confirmationDeal
			maps = JSONUtils.toMap(JSONUtils.toJson(confirmationDeal), false);
			maps.remove("exportTitle");
			if(!Utils.isEmpty(maps)) {
				map = new HashMap<String, Object>();
				map.put("maps", maps);
				map.put("teamType", DictionaryType.CONFIRMATION_DEAL);
				map.put("foreignKey", basicInfoId);
				map.put("module", "0");
				basicinfoservice.insertTeam(map);
			}
			//complianceLegal
			maps = JSONUtils.toMap(JSONUtils.toJson(complianceLegal), false);
			maps.remove("exportTitle");
			if(!Utils.isEmpty(maps)) {
				map = new HashMap<String, Object>();
				map.put("maps", maps);
				map.put("teamType", DictionaryType.COMPLIANCE_LEGAL);
				map.put("foreignKey", basicInfoId);
				map.put("module", "0");
				basicinfoservice.insertTeam(map);
			}
			//confirmationLegal
			maps = JSONUtils.toMap(JSONUtils.toJson(confirmationLegal), false);
			maps.remove("exportTitle");
			if(!Utils.isEmpty(maps)) {
				map = new HashMap<String, Object>();
				map.put("maps", maps);
				map.put("teamType", DictionaryType.CONFIRMATION_LEGAL);
				map.put("foreignKey", basicInfoId);
				map.put("module", "0");
				basicinfoservice.insertTeam(map);
			}
		}
	}
	
	/**
	 * 
	 * @Title: deleteByPrimaryKeyAll
	 * @Description: 删除关联信息
	 * @param basicInfoId
	 * @return Result 返回类型
	 */
	@RequestMapping(value = "/deleteByPrimaryKeyAll.do", method = RequestMethod.POST)
	@ResponseBody
	public Result deleteByPrimaryKeyAll(@ModelAttribute("basicInfoId") String basicInfoId){
		Result result = new Result();
		try {
			//当basicInfo的id不为空时，则为编辑，否则为添加6
			if(!Utils.isEmpty(basicInfoId)) {
				Map<String, Object> map = new HashMap<String, Object>();//定义一个map
				//根据basicInfoId查询关联文档id信息
				Map<String, Object> maps = basicinfoservice.selectDocRelatedId(basicInfoId);
				map.put("basicInfoId", basicInfoId);
				map.put("maps", maps);
				basicinfoservice.deleteByPrimaryKeyAll(map);//删除关联表信息
				basicinfoservice.deleteTeam(basicInfoId);//删除ComplianceOrConfirmation
				result.setMessage(ResultEnum.SUCCESS.getText());
				result.setResultCode(ResultEnum.SUCCESS.getValue());
			} else {
				result.setResultCode(ResultEnum.FAIL.getValue());
				result.setMessage(ResultEnum.FAIL.getText());
				return result;
			}
		} catch (Exception e) {
			UnitedLogger.error(e);
			result.setResultCode(ResultEnum.FAIL.getValue());
			result.setMessage(e.getMessage());
		}
		return result;
	}
	
	/**
	 * 
	 * @Title: reportExcelComplianceDeal
	 * @Description: To excel ComplianceDeal
	 * @param request
	 * @param response
	 * @param file
	 * @param complianceDeal void 返回类型
	 */
	@RequestMapping(value = "reportExcelComplianceDeal")
	public void reportExcelComplianceDeal(HttpServletRequest request
			, HttpServletResponse response
			, @RequestParam("file") String file
			, @ModelAttribute("complianceDeal") DealTeam_compliance complianceDeal) {
		exportExcelTeam(complianceDeal, file, complianceDeal.getExportTitle(), request, response);
	}
	
	/**
	 * 
	 * @Title: reportExcelConfirmationDeal
	 * @Description: To excel ConfirmationDeal
	 * @param request
	 * @param response
	 * @param file
	 * @param complianceDeal void 返回类型
	 */
	@RequestMapping(value = "reportExcelConfirmationDeal")
	public void reportExcelConfirmationDeal(HttpServletRequest request
			, HttpServletResponse response
			, @RequestParam("file") String file
			,@ModelAttribute("confirmationDeal") DealTeam_confirmation confirmationDeal) {
		exportExcelTeam(confirmationDeal, file, confirmationDeal.getExportTitle(), request, response);
	}
	
	/**
	 * 
	 * @Title: reportExcelComplianceLegal
	 * @Description: To excel ComplianceLegal
	 * @param request
	 * @param response
	 * @param file
	 * @param complianceDeal void 返回类型
	 */
	@RequestMapping(value = "reportExcelComplianceLegal")
	public void reportExcelComplianceLegal(HttpServletRequest request
			, HttpServletResponse response
			, @RequestParam("file") String file
			, @ModelAttribute("complianceLegal") LegalTeam_compliance complianceLegal) {
		exportExcelTeam(complianceLegal, file, complianceLegal.getExportTitle(), request, response);
	}
	
	/**
	 * 
	 * @Title: reportExcelConfirmationLegal
	 * @Description: To excel ConfirmationLegal
	 * @param request
	 * @param response
	 * @param file
	 * @param complianceDeal void 返回类型
	 */
	@RequestMapping(value = "reportExcelConfirmationLegal")
	public void reportExcelConfirmationLegal(HttpServletRequest request
			, HttpServletResponse response
			, @RequestParam("file") String file
			, @ModelAttribute("confirmationLegal") LegalTeam_confirmation confirmationLegal) {
		exportExcelTeam(confirmationLegal, file, confirmationLegal.getExportTitle(), request, response);
	}
	
	/**
	 * 
	 * @Title: exportExcelTeam
	 * @Description: 此Method中ComPliance - Confirmation Team 共用
	 * @param obj
	 * @param title
	 * @param file
	 * @param request
	 * @param response void 返回类型
	 */
	public void exportExcelTeam(Object object,String file, String title, HttpServletRequest request
			, HttpServletResponse response) {
		Map<String, Object> maps = new HashMap<String, Object>();
        JSONObject jsonObject = JSONObject.parseObject(JSONUtils.toJson(object));//转换成JSONObject对象
        Iterator<Entry<String, Object>> it = jsonObject.entrySet().iterator();  
		while (it.hasNext()) {
			Map.Entry<String, Object> param = (Map.Entry<String, Object>) it.next();
			if(param.getValue() instanceof String) {//转换数据
				if("0".equals(param.getValue())){
					maps.put(param.getKey(), "Y");
				}else if ("1".equals(param.getValue())){
					maps.put(param.getKey(), "N");
				}
			}
		}
		Object objs[] = new Object[1];
		objs[0] = JSONUtils.toJSONObject(JSONUtils.toJson(maps));//数据集
		Object obj = JSONUtils.toJSONObject(JSONUtils.toJson(new ExportExcelDealTitle()));//头部标题
		ExcelFile ef = new ExcelFile();
		ef.setIsObj(2);//单个对象
		ef.setFile(file);//文件全称
		ef.setTitle(title);//标题
		ef.setObjs(objs);
		ef.setHeadTitle(obj);
		Utils.export(ef, request, response);//导出
	}	

}

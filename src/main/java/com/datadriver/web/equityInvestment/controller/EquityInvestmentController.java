package com.datadriver.web.equityInvestment.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.datadriver.core.entity.Result;
import com.datadriver.core.entity.UnitedException;
import com.datadriver.core.entity.UnitedLogger;
import com.datadriver.core.feature.orm.page.DataTablePage;
import com.datadriver.core.util.JSONUtils;
import com.datadriver.core.util.Utils;
import com.datadriver.web.common.enums.DictionaryType;
import com.datadriver.web.common.enums.FinalParamer;
import com.datadriver.web.common.enums.ResultEnum;
import com.datadriver.web.common.enums.SessionAttribute;
import com.datadriver.web.common.model.DataDictionary;
import com.datadriver.web.common.service.DataDictionaryService;
import com.datadriver.web.equityInvestment.dto.EquityInvestmentDto;
import com.datadriver.web.equityInvestment.model.EquityDealTeam;
import com.datadriver.web.equityInvestment.model.EquityInvestment;
import com.datadriver.web.equityInvestment.model.EquityInvestmentPage;
import com.datadriver.web.equityInvestment.model.EquityLegalTeam;
import com.datadriver.web.equityInvestment.service.EquityInvestmentService;
import com.datadriver.web.file.model.DocumentEntity;
import com.datadriver.web.onePaper.model.OnePaper;
import com.datadriver.web.system.model.SystemUser;
import com.github.pagehelper.PageInfo;

/**
 * @ClassName: EquityInvestmentController
 * @Description: Basic info 控制类
 * @date 2016-3-22 上午10:46:22
 */
@Controller
@RequestMapping(value = "/equityInvestment")
public class EquityInvestmentController {
	
	@Resource
	private EquityInvestmentService	equityInvestmentService;
	
	@Resource
	private DataDictionaryService	dataDictionaryService;
	
	/**
	 * @Title: initListEquityInvestment
	 * @Description: 初始化EquityInvestment页面
	 * @return String 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/initListEquityInvestmentPage.do", method = RequestMethod.GET)
	public String initListEquityInvestment(Model model) {
		try {
			// 领域
			List<DataDictionary> sectorDatas = dataDictionaryService
					.selectByType(DictionaryType.SECTOR_TYPE);
			// 阶段
			List<DataDictionary> stageDatas = dataDictionaryService
					.selectByType(DictionaryType.STAGE_TYPE);
			// 基金
			List<DataDictionary> fundDatas = dataDictionaryService.selectFunds();
			model.addAttribute("sectorDatas", sectorDatas);
			model.addAttribute("stageDatas", stageDatas);
			model.addAttribute("fundDatas", fundDatas);
		} catch (Exception e) {
			UnitedLogger.error(e);
			model.addAttribute(FinalParamer.MESSAGE, e.getMessage());
			model.addAttribute(FinalParamer.RESULT, ResultEnum.FAIL.getValue());
		}
		return "equityInvestment/list_equityInvestment";
	}
	
	/**
	 * 获取Equity Investment 信息
	 * 
	 * @param model
	 * @param request
	 * @param equityInvestmentDto
	 * @return
	 */
	@RequestMapping(value = "/findListEquityInvestment.do", method = RequestMethod.POST)
	@ResponseBody
	public DataTablePage<EquityInvestment> findListEquityInvestment(Model model,
			HttpServletRequest request,
			@ModelAttribute("equityInvestmentDto") EquityInvestmentDto equityInvestmentDto) {
		// 实例化分页插件
		DataTablePage<EquityInvestment> equityInvestmentPageList = new DataTablePage<EquityInvestment>(
				request);
		try {
			// 获得session
			HttpSession session = request.getSession();
			// 把投资组合中文名称存入session
			session.setAttribute("portfolioNameCH", equityInvestmentDto.getPortfolioNameCH());
			// 设置分页参数（当前页码、每页显示大小、排序参数）
			equityInvestmentDto.setPageNum(equityInvestmentPageList.getPageNum());
			equityInvestmentDto.setPageSize(equityInvestmentPageList.getLength());
			
			PageInfo<EquityInvestment> equityInvestmentList = equityInvestmentService
					.findEquityInvestmentListbyDto(equityInvestmentDto);
			// 转换提取成DataTablePage的分页参数
			equityInvestmentPageList = equityInvestmentPageList.transfer(equityInvestmentPageList,
					equityInvestmentList);
		} catch (UnitedException e) {
			UnitedLogger.error(e);
			model.addAttribute(FinalParamer.MESSAGE, e.loadErrorMessageByCode(request));
			model.addAttribute(FinalParamer.RESULT, ResultEnum.FAIL.getValue());
		}
		return equityInvestmentPageList;
	}
	
	/**
	 * @Title: initAddEquityInvestment
	 * @Description: 初始化EquityInvestment页面
	 * @return String 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/initAddEquityInvestment.do", method = RequestMethod.GET)
	public String initAddEquityInvestment(Model model, HttpServletRequest request,
			@RequestParam("universalId") String universalId,
			@RequestParam("universalStr") boolean universalStr) {
		try {
			// 领域
			List<DataDictionary> sectorDatas = dataDictionaryService
					.selectByType(DictionaryType.SECTOR_TYPE);
			// 基金
			List<DataDictionary> fundDatas = dataDictionaryService.selectFunds();
			// 类型
			List<DataDictionary> typeDatas = dataDictionaryService
					.selectByType(DictionaryType.TYPE_TYPE);
			// fundingType类型
			List<DataDictionary> fundingTypeDatas = dataDictionaryService
					.selectByType(DictionaryType.FUNDING_TYPE);
			// developmentStage
			List<DataDictionary> developmentStageDatas = dataDictionaryService
					.selectByType(DictionaryType.DEVELOPMENT_STAGE);
			// investmentStage
			List<DataDictionary> investmentStageDatas = dataDictionaryService
					.selectByType(DictionaryType.INVESTMENT_STAGE);
			// dealSource
			List<DataDictionary> dealSourceDatas = dataDictionaryService
					.selectByType(DictionaryType.DEAL_SOURCE);
			// investmentStatus
			List<DataDictionary> investmentStatusDatas = dataDictionaryService
					.selectByType(DictionaryType.INVESTMENT_STATUS);
			// user数据
			List<DataDictionary> userDatas = dataDictionaryService.selectUsers();
			EquityInvestment equityInvestment = new EquityInvestment();
			OnePaper onePaper = new OnePaper();
			String equityDealTeamStr = "", equityLegalTeamStr = "";
			// universalStr==true为编辑，否则为添加
			if (universalStr) {// 编辑时universalId为equityInvestment的id
				String[] idArr = universalId.split(",");// 分割成equityInvestment的id与onepaper的id
				onePaper = equityInvestmentService.selectPaperById(idArr[1]);// 查询onepaper
				// equityInvestment
				equityInvestment = equityInvestmentService.queryEquityInvestmentObj(idArr[0]);
				equityDealTeamStr = equityInvestmentService.selectLisgaggStr(idArr[0],
						DictionaryType.EQUITY_DEALTEAM);
				equityLegalTeamStr = equityInvestmentService.selectLisgaggStr(idArr[0],
						DictionaryType.EQUITY_LEGALTEAM);
				model.addAttribute("equityLegalTeamStr", Utils.replaceSymbol(equityLegalTeamStr,
						",", "&"));
				model.addAttribute("equityDealTeamStr", Utils.replaceSymbol(equityDealTeamStr, ",",
						"&"));
			} else {
				// 根据id查询one paper详情
				onePaper = equityInvestmentService.selectPaperById(universalId);
			}
			model.addAttribute("investmentStageDatas", investmentStageDatas);
			model.addAttribute("developmentStageDatas", developmentStageDatas);
			model.addAttribute("dealSourceDatas", dealSourceDatas);
			model.addAttribute("investmentStatusDatas", investmentStatusDatas);
			model.addAttribute("userDatas", userDatas);
			model.addAttribute("sectorDatas", sectorDatas);
			model.addAttribute("fundDatas", fundDatas);
			model.addAttribute("equityInvestment", equityInvestment);
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
			model.addAttribute(FinalParamer.MESSAGE, e.loadErrorMessageByCode(request));
			model.addAttribute(FinalParamer.RESULT, ResultEnum.FAIL.getValue());
		}
		return "equityInvestment/add_equityInvestment";
	}
	
	/**
	 * 
	 * @Title: saveEquityInvestment
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param request
	 * @param @param equityInvestment
	 * @param @param preFunding
	 * @param @param preSigning
	 * @param @return 设定文件
	 * @return Result 返回类型
	 * @throws
	 */
	@ResponseBody
	@RequestMapping(value = "/saveEquityInvestment.do", method = RequestMethod.POST)
	public Result saveEquityInvestment(HttpServletRequest request,
			@ModelAttribute("equityInvestment") EquityInvestment equityInvestment,
			@ModelAttribute("equityDealTeam") EquityDealTeam equityDealTeam,
			@ModelAttribute("equityLegalTeam") EquityLegalTeam equityLegalTeam) {
		Result result = new Result();
		try {
			// 当equityInvestment的id不为空时，则为编辑，否则为添加
			if (!Utils.isEmpty(equityInvestment.getEquityInvestmentId())) {
				// 保存文档
				List<DocumentEntity> docs_edit = new ArrayList<DocumentEntity>();
				List<DocumentEntity> docs_add = new ArrayList<DocumentEntity>();
				// begin这些判断都是判断是否已经上传过文档
				if (!Utils.isEmpty(equityInvestment.getCapTableUpload().getFileId())) {
					if(!Utils.isEmpty(equityInvestment.getCapTableUpload().getFileName()) &&
							!Utils.isEmpty(equityInvestment.getCapTableUpload().getFilePath())) {
						docs_edit.add(equityInvestment.getCapTableUpload());
					} else {
						docs_add.add(equityInvestment.getCapTableUpload());
					}
				} else {
					equityInvestment.setCapTableUpload(saveDocInfo(equityInvestment
							.getCapTableUpload(), request));
				}
				if (!Utils.isEmpty(equityInvestment.getFddReportUpload().getFileId())) {
					if(!Utils.isEmpty(equityInvestment.getFddReportUpload().getFileName()) &&
							!Utils.isEmpty(equityInvestment.getFddReportUpload().getFilePath())) {
						docs_edit.add(equityInvestment.getFddReportUpload());
					} else {
						docs_add.add(equityInvestment.getFddReportUpload());
					}
				} else {
					equityInvestment.setFddReportUpload(saveDocInfo(equityInvestment
							.getFddReportUpload(), request));
				}
				if (!Utils.isEmpty(equityInvestment.getFinancialUpload().getFileId())) {
					if(!Utils.isEmpty(equityInvestment.getFinancialUpload().getFileName()) &&
							!Utils.isEmpty(equityInvestment.getFinancialUpload().getFilePath())) {
						docs_edit.add(equityInvestment.getFinancialUpload());
					} else {
						docs_add.add(equityInvestment.getFinancialUpload());
					}
				} else {
					equityInvestment.setFinancialUpload(saveDocInfo(equityInvestment
							.getFinancialUpload(), request));
				}
				if (!Utils.isEmpty(equityInvestment.getGroupChartUpload().getFileId())) {
					if(!Utils.isEmpty(equityInvestment.getGroupChartUpload().getFileName()) &&
							!Utils.isEmpty(equityInvestment.getGroupChartUpload().getFilePath())) {
						docs_edit.add(equityInvestment.getGroupChartUpload());
					} else {
						docs_add.add(equityInvestment.getGroupChartUpload());
					}
				} else {
					equityInvestment.setGroupChartUpload(saveDocInfo(equityInvestment
							.getGroupChartUpload(), request));
				}
				if (!Utils.isEmpty(equityInvestment.getIndemnificationUpload().getFileId())) {
					if(!Utils.isEmpty(equityInvestment.getIndemnificationUpload().getFileName()) &&
							!Utils.isEmpty(equityInvestment.getIndemnificationUpload().getFilePath())) {
						docs_edit.add(equityInvestment.getIndemnificationUpload());
					} else {
						docs_add.add(equityInvestment.getIndemnificationUpload());
					}
				} else {
					equityInvestment.setIndemnificationUpload(saveDocInfo(equityInvestment
							.getIndemnificationUpload(), request));
				}
				if (!Utils.isEmpty(equityInvestment.getInstructionUpload().getFileId())) {
					if(!Utils.isEmpty(equityInvestment.getInstructionUpload().getFileName()) &&
							!Utils.isEmpty(equityInvestment.getInstructionUpload().getFilePath())) {
						docs_edit.add(equityInvestment.getInstructionUpload());
					} else {
						docs_add.add(equityInvestment.getInstructionUpload());
					}
				} else {
					equityInvestment.setInstructionUpload(saveDocInfo(equityInvestment
							.getInstructionUpload(), request));
				}
				if (!Utils.isEmpty(equityInvestment.getLddReportUpload().getFileId())) {
					if(!Utils.isEmpty(equityInvestment.getLddReportUpload().getFileName()) &&
							!Utils.isEmpty(equityInvestment.getLddReportUpload().getFilePath())) {
						docs_edit.add(equityInvestment.getLddReportUpload());
					} else {
						docs_add.add(equityInvestment.getLddReportUpload());
					}
				} else {
					equityInvestment.setLddReportUpload(saveDocInfo(equityInvestment
							.getLddReportUpload(), request));
				}
				if (!Utils.isEmpty(equityInvestment.getLegalOpinionUpload().getFileId())) {
					if(!Utils.isEmpty(equityInvestment.getLegalOpinionUpload().getFileName()) &&
							!Utils.isEmpty(equityInvestment.getLegalOpinionUpload().getFilePath())) {
						docs_edit.add(equityInvestment.getLegalOpinionUpload());
					} else {
						docs_add.add(equityInvestment.getLegalOpinionUpload());
					}
				} else {
					equityInvestment.setLegalOpinionUpload(saveDocInfo(equityInvestment
							.getLegalOpinionUpload(), request));
				}
				if (!Utils.isEmpty(equityInvestment.getLetterUpload().getFileId())) {
					if(!Utils.isEmpty(equityInvestment.getLetterUpload().getFileName()) &&
							!Utils.isEmpty(equityInvestment.getLetterUpload().getFilePath())) {
						docs_edit.add(equityInvestment.getLetterUpload());
					} else {
						docs_add.add(equityInvestment.getLetterUpload());
					}
				} else {
					equityInvestment.setLetterUpload(saveDocInfo(
							equityInvestment.getLetterUpload(), request));
				}
				if (!Utils.isEmpty(equityInvestment.getMemoUpload().getFileId())) {
					if(!Utils.isEmpty(equityInvestment.getMemoUpload().getFileName()) &&
							!Utils.isEmpty(equityInvestment.getMemoUpload().getFilePath())) {
						docs_edit.add(equityInvestment.getMemoUpload());
					} else {
						docs_add.add(equityInvestment.getMemoUpload());
					}
				} else {
					equityInvestment.setMemoUpload(saveDocInfo(equityInvestment.getMemoUpload(),
							request));
				}
				if (!Utils.isEmpty(equityInvestment.getQuestionnaireUpload().getFileId())) {
					if(!Utils.isEmpty(equityInvestment.getQuestionnaireUpload().getFileName()) &&
							!Utils.isEmpty(equityInvestment.getQuestionnaireUpload().getFilePath())) {
						docs_edit.add(equityInvestment.getQuestionnaireUpload());
					} else {
						docs_add.add(equityInvestment.getQuestionnaireUpload());
					}
				} else {
					equityInvestment.setQuestionnaireUpload(saveDocInfo(equityInvestment
							.getQuestionnaireUpload(), request));
				}
				if (!Utils.isEmpty(equityInvestment.getRepLetterUpload().getFileId())) {
					if(!Utils.isEmpty(equityInvestment.getRepLetterUpload().getFileName()) &&
							!Utils.isEmpty(equityInvestment.getRepLetterUpload().getFilePath())) {
						docs_edit.add(equityInvestment.getRepLetterUpload());
					} else {
						docs_add.add(equityInvestment.getRepLetterUpload());
					}
				} else {
					equityInvestment.setRepLetterUpload(saveDocInfo(equityInvestment
							.getRepLetterUpload(), request));
				}
				if (!Utils.isEmpty(equityInvestment.getTransactionDocsUpload().getFileId())) {
					if(!Utils.isEmpty(equityInvestment.getTransactionDocsUpload().getFileName()) &&
							!Utils.isEmpty(equityInvestment.getTransactionDocsUpload().getFilePath())) {
						docs_edit.add(equityInvestment.getTransactionDocsUpload());
					} else {
						docs_add.add(equityInvestment.getTransactionDocsUpload());
					}
				} else {
					equityInvestment.setTransactionDocsUpload(saveDocInfo(equityInvestment
							.getTransactionDocsUpload(), request));
				}
				if (!Utils.isEmpty(equityInvestment.getFcpaCheckingResult().getFileId())) {
					if(!Utils.isEmpty(equityInvestment.getFcpaCheckingResult().getFileName()) &&
							!Utils.isEmpty(equityInvestment.getFcpaCheckingResult().getFilePath())) {
						docs_edit.add(equityInvestment.getFcpaCheckingResult());
					} else {
						docs_add.add(equityInvestment.getFcpaCheckingResult());
					}
				} else {
					equityInvestment.setFcpaCheckingResult(saveDocInfo(equityInvestment
							.getFcpaCheckingResult(), request));
				}
				// end
				// 修改文档信息
				updateDocbyId(docs_add, request);
				updateDocbyId(docs_edit, request);
				// 判断两个选择的信息
				if ("1".equals(equityInvestment.getIsEquityBroker())) {
					equityInvestment.setEquityBrokerRemark("");
				}
				if ("1".equals(equityInvestment.getIsEquityAnnouncement())) {
					equityInvestment.setEquityRationale("");
					equityInvestment.setEquityWebsite("");
				}
				equityInvestmentService.update(equityInvestment);
				equityInvestmentService.deleteTeam(equityInvestment.getEquityInvestmentId());// 删除ComplianceOrConfirmation
			} else {
				// 设置文档信息
				equityInvestment.setCapTableUpload(saveDocInfo(
						equityInvestment.getCapTableUpload(), request));
				equityInvestment.setFddReportUpload(saveDocInfo(equityInvestment
						.getFddReportUpload(), request));
				equityInvestment.setFinancialUpload(saveDocInfo(equityInvestment
						.getFinancialUpload(), request));
				equityInvestment.setGroupChartUpload(saveDocInfo(equityInvestment
						.getGroupChartUpload(), request));
				equityInvestment.setIndemnificationUpload(saveDocInfo(equityInvestment
						.getIndemnificationUpload(), request));
				equityInvestment.setInstructionUpload(saveDocInfo(equityInvestment
						.getInstructionUpload(), request));
				equityInvestment.setLddReportUpload(saveDocInfo(equityInvestment
						.getLddReportUpload(), request));
				equityInvestment.setLegalOpinionUpload(saveDocInfo(equityInvestment
						.getLegalOpinionUpload(), request));
				equityInvestment.setLetterUpload(saveDocInfo(equityInvestment.getLetterUpload(),
						request));
				equityInvestment.setMemoUpload(saveDocInfo(equityInvestment.getMemoUpload(),
						request));
				equityInvestment.setQuestionnaireUpload(saveDocInfo(equityInvestment
						.getQuestionnaireUpload(), request));
				equityInvestment.setRepLetterUpload(saveDocInfo(equityInvestment
						.getRepLetterUpload(), request));
				equityInvestment.setTransactionDocsUpload(saveDocInfo(equityInvestment
						.getTransactionDocsUpload(), request));
				equityInvestment.setFcpaCheckingResult(saveDocInfo(equityInvestment
						.getFcpaCheckingResult(), request));
				// 判断两个选择的信息
				if ("1".equals(equityInvestment.getIsEquityBroker())) {
					equityInvestment.setEquityBrokerRemark("");
				}
				if ("1".equals(equityInvestment.getIsEquityAnnouncement())) {
					equityInvestment.setEquityRationale("");
					equityInvestment.setEquityWebsite("");
				}
				equityInvestmentService.insert(equityInvestment);
			}
			// 保存 Compliance-ConfirmationTeam
			saveComplianceOrConfirmationTeam(equityInvestment, equityDealTeam, equityLegalTeam);
			result.setMessage(ResultEnum.SUCCESS.getText());
			result.setResultCode(ResultEnum.SUCCESS.getValue());
		} catch (Exception e) {
			UnitedLogger.error(e);
			result.setResultCode(ResultEnum.FAIL.getValue());
			result.setMessage(e.getMessage());
		}
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/deleteByPrimaryKeyAll.do", method = RequestMethod.POST)
	public Result deleteByPrimaryKeyAll(HttpServletRequest request,
			@ModelAttribute("equityInvestmentId") String equityInvestmentId) {
		Result result = new Result();
		try {
			Map<String, Object> map = new HashMap<String, Object>();//定义一个map
			//查询关联文档id信息
			Map<String, Object> maps = equityInvestmentService.selectDocRelatedId(equityInvestmentId);
			map.put("equityInvestmentId", equityInvestmentId);
			map.put("maps", maps);
			// 逻辑删除EquityInvestment
			equityInvestmentService.deleteByPrimaryKeyAll(map);//删除关联表信息
			equityInvestmentService.deleteTeam(equityInvestmentId);//删除ComplianceOrConfirmation
			result.setMessage(ResultEnum.SUCCESS.getText());
			result.setResultCode(ResultEnum.SUCCESS.getValue());
		} catch (Exception e) {
			result.setResultCode(ResultEnum.FAIL.getValue());
			result.setMessage(ResultEnum.FAIL.getText());
			return result;
		}
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/findEquityInvestmentByPaper.do", method = RequestMethod.POST)
	public Result findEquityInvestmentByPaper(HttpServletRequest request,
			@ModelAttribute("equityInvestmentId") String equityInvestmentId) {
		Result result = new Result();
		try {
			List<EquityInvestmentPage> list = equityInvestmentService
					.findEquityInvestmentByPaper(equityInvestmentId);
			result.setObjectInfo(list);
			result.setResultCode(ResultEnum.SUCCESS.getValue());
		} catch (Exception e) {
			UnitedLogger.error(e);
			result.setResultCode(ResultEnum.FAIL.getValue());
		}
		return result;
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
			// 验证文档对象是否为空
			if (!Utils.isEmpty(doc.getFileName()) && !Utils.isEmpty(doc.getFilePath())) {
				// 获取用户信息
				HttpSession session = request.getSession();
				SystemUser user = (SystemUser) session.getAttribute(SessionAttribute.USERINFO);
				if (!Utils.isEmpty(user)) {
					doc.setUpdateUserId(user.getUserId());
					doc.setUpdateUserName(user.getUserName());
					doc.setUserId(user.getUserId());
					doc.setUserName(user.getUserName());
				}
				// 添加文档
				equityInvestmentService.insertDocument(doc);
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
	 * @param list
	 *            void 返回类型
	 */
	public void updateDocbyId(List<DocumentEntity> list, HttpServletRequest request) {
		try {
			if (!Utils.isEmpty(list)) {
				// 获取用户信息
				HttpSession session = request.getSession();
				SystemUser user = (SystemUser) session.getAttribute(SessionAttribute.USERINFO);
				// 循环修改文档信息
				for (DocumentEntity doc : list) {
					if (!Utils.isEmpty(user)) {
						doc.setUpdateUserId(user.getUserId());
						doc.setUpdateUserName(user.getUserName());
					}
					//若名称与路径为空，则修改删除标识为1
					if(Utils.isEmpty(doc.getFileName()) && Utils.isEmpty(doc.getFilePath()))
						doc.setThruDate("1");
					// 更新文档
					equityInvestmentService.updateDocument(doc);
				}
			}
		} catch (Exception e) {
			UnitedLogger.error(e);
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * 
	 * @Title: saveComplianceOrConfirmationTeam
	 * @Description: 保存ComplianceOrConfirmation
	 * @param basicInfoId
	 *            void 返回类型
	 */
	public void saveComplianceOrConfirmationTeam(EquityInvestment equityInvestment,
			EquityDealTeam equityDealTeam, EquityLegalTeam equityLegalTeam) {
		String equityInvestmentId = equityInvestment.getEquityInvestmentId();
		if (!Utils.isEmpty(equityInvestmentId)) {
			Map<String, Object> map = null;
			Map<String, Object> maps = new HashMap<String, Object>();
			// complianceDeal
			if (!"1".equals(equityInvestment.getIsNullDeal())) {
				map = new HashMap<String, Object>();
				map.put("foreignKey", equityInvestmentId);
				map.put("module", "1");
				maps = JSONUtils.toMap(JSONUtils.toJson(equityDealTeam), false);
				map.put("maps", maps);
				map.put("teamType", DictionaryType.EQUITY_DEALTEAM);
				equityInvestmentService.insertTeam(map);
			}
			// complianceLegal
			if (!"1".equals(equityInvestment.getIsNullLegal())) {
				map = new HashMap<String, Object>();
				map.put("foreignKey", equityInvestmentId);
				map.put("module", "1");
				maps = JSONUtils.toMap(JSONUtils.toJson(equityLegalTeam), false);
				map.put("maps", maps);
				map.put("teamType", DictionaryType.EQUITY_LEGALTEAM);
				equityInvestmentService.insertTeam(map);
			}
		}
	}
	
	/**
	 * 
	 * @Title: initLegalTeamPage
	 * @Description: 初始化LegalTeam
	 * @param model
	 * @return String 返回类型
	 */
	@RequestMapping(value = "/initLegalTeamPage.do", method = RequestMethod.POST)
	public String initLegalTeamPage(Model model, HttpServletRequest request,
			@ModelAttribute("equityLegalTeam") EquityLegalTeam equityLegalTeam) {
		model.addAttribute("equityLegalTeam", equityLegalTeam);
		return "equityInvestment/legalTeamPage";
	}
	
	/**
	 * 
	 * @Title: initDealTeamPage
	 * @Description: 初始化DealTeam
	 * @param model
	 * @return String 返回类型
	 */
	@RequestMapping(value = "/initDealTeamPage.do", method = RequestMethod.POST)
	public String initDealTeamPage(Model model, HttpServletRequest request,
			@ModelAttribute("equityDealTeam") EquityDealTeam equityDealTeam) {
		model.addAttribute("equityDealTeam", equityDealTeam);
		return "equityInvestment/dealTeamPage";
	}
	
	@RequestMapping(value = "/toLegalExcel.do")
	public void toLegalExcel(ModelMap model,HttpServletResponse response,HttpServletRequest request,
		@ModelAttribute("equityLegalTeam") EquityLegalTeam equityLegalTeam) throws IOException{
		Map legalTeamMap = JSONUtils.toMap(JSONUtils.toJson(equityLegalTeam), false);
		equityInvestmentService.toExcel(response,legalTeamMap,"legalTeamExcel");
	}
	
	@RequestMapping(value = "/toDealExcel.do")
	public void toDealExcel(ModelMap model,HttpServletResponse response,HttpServletRequest request,
		@ModelAttribute("equityDealTeam") EquityDealTeam equityDealTeam) throws IOException{
		Map dealTeamMap = JSONUtils.toMap(JSONUtils.toJson(equityDealTeam), false);
		equityInvestmentService.toExcel(response,dealTeamMap,"dealTeamExcel");
	}
}

package com.datadriver.web.basicExit.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.datadriver.core.entity.Result;
import com.datadriver.core.entity.UnitedException;
import com.datadriver.core.entity.UnitedLogger;
import com.datadriver.core.feature.orm.page.DataTablePage;
import com.datadriver.core.util.Utils;
import com.datadriver.web.basicExit.dto.BasicExitDto;
import com.datadriver.web.basicExit.model.BasicExit;
import com.datadriver.web.basicExit.service.BasicExitService;
import com.datadriver.web.common.enums.DictionaryType;
import com.datadriver.web.common.enums.ResultEnum;
import com.datadriver.web.common.model.DataDictionary;
import com.datadriver.web.common.service.DataDictionaryService;
import com.github.pagehelper.PageInfo;

/**
 * @ClassName: BasicExitController
 * @Description: Basic Exit 控制类
 * @date 2016-3-22 上午10:46:22
 */
@Controller
@RequestMapping(value = "/basicExit")
public class BasicExitController {

	@Resource
	private BasicExitService basicExitService;

	@Resource
	private DataDictionaryService dataDictionaryService;

	/**
	 * @Title: initListBasicInfo
	 * @Description: 初始化BasicInfo页面
	 * @return String 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/initListBasicExitPage.do", method = RequestMethod.GET)
	public String initListBasicInfo(Model model) {
		// 初始化sector动态下拉字典
		List<DataDictionary> sector = dataDictionaryService
				.selectByType(DictionaryType.SECTOR_TYPE);

		// 初始化stage动态下拉字典
		List<DataDictionary> stage = dataDictionaryService
				.selectByType(DictionaryType.STAGE_TYPE);

		// 初始化fund动态下拉字典
		List<DataDictionary> fund = dataDictionaryService.selectFunds();
		model.addAttribute("sector", sector);
		model.addAttribute("stage", stage);
		model.addAttribute("fund", fund);
		return "basicExit/list_basicExit";
	}

	/**
	 * 
	 * @Title: initAddBasicExit
	 * @Description: 初始化新增/编辑页面
	 * @return String 返回类型
	 */
	@RequestMapping(value = "/initAddBasicExit.do", method = RequestMethod.GET)
	public String initAddTsSigned(Model model, HttpServletRequest request,
			@ModelAttribute("basicExit") BasicExit basicExit) {
		// 判断,如果paperId不为空。则说明当前状态为新增,否则为编辑
		try {
			if (Utils.isEmpty(basicExit.getPaperId())) {
				basicExit = basicExitService.selectById(Long.valueOf(basicExit
						.getBasicExitId()));
			} else {
				basicExit = basicExitService.selectByPaperId(basicExit
						.getPaperId());
			}
		} catch (NumberFormatException e) {
			UnitedLogger.error(e);
		} catch (UnitedException e) {
			UnitedLogger.error(e);
		}
		// 初始化sector动态下拉字典
		List<DataDictionary> sector = dataDictionaryService
				.selectByType(DictionaryType.SECTOR_TYPE);

		// 初始化type动态下拉字典
		List<DataDictionary> type = dataDictionaryService
				.selectByType(DictionaryType.TYPE_TYPE);

		// 初始化fund动态下拉字典
		List<DataDictionary> fund = dataDictionaryService.selectFunds();
		model.addAttribute("sector", sector);
		model.addAttribute("type", type);
		model.addAttribute("fund", fund);
		model.addAttribute("basicExit", basicExit);
		return "basicExit/add_basicExit";
	}

	/**
	 * 
	 * @Title: findBasicExitList
	 * @Description: 分页查询Basic Exit
	 * @param model
	 * @param request
	 * @param BasicExitDto
	 * @return DataTablePage<OnePaper> 返回类型
	 */
	@RequestMapping(value = "/findBasicExitList.do", method = RequestMethod.POST)
	@ResponseBody
	public DataTablePage<BasicExit> findTsSignedList(Model model,
			HttpServletRequest request,
			@ModelAttribute("basicExitDto") BasicExitDto basicExitDto) {
		// 实例化分页插件
		DataTablePage<BasicExit> basicExitDataList = new DataTablePage<BasicExit>(
				request);
		try {
			// 验证是否为空，不为空时添加到session
			// if (!Utils.isEmpty(basicExitDto.getPortfolioNameCH())) {
			// 获得session
			HttpSession session = request.getSession();
			// 把投资组合中文名称存入session
			session.setAttribute("portfolioNameCH",
					basicExitDto.getPortfolioNameCH());
			// }
			// 设置分页参数（当前页码、每页显示大小、排序参数）
			basicExitDto.setPageNum(basicExitDataList.getPageNum());
			basicExitDto.setPageSize(basicExitDataList.getLength());
			basicExitDto.setOrderString(basicExitDataList.getOrderStr());
			// 查询BasicExit
			PageInfo<BasicExit> basicExitPageList = basicExitService
					.selectBasicExitListbyDto(basicExitDto);
			// 转换提取成DataTablePage的分页参数
			basicExitDataList = basicExitDataList.transfer(basicExitDataList,
					basicExitPageList);
		} catch (Exception e) {
			UnitedLogger.error(e);
			// model.addAttribute(FinalParamer.MESSAGE,
			// e.loadErrorMessageByCode(request));
			// model.addAttribute(FinalParamer.RESULT,
			// ResultEnum.FAIL.getValue());
		}
		return basicExitDataList;
	}

	/**
	 * 
	 * @Title: saveBasicExit
	 * @Description: 保存basicExit
	 * @param @param model
	 * @param @param request
	 * @param @param basicExit
	 * @param @return 设定文件
	 * @return Result 返回类型
	 * @throws
	 */
	@ResponseBody
	@RequestMapping(value = "/saveBasicExit.do", method = RequestMethod.POST)
	public Result saveBasicExit(Model model, HttpServletRequest request,
			@ModelAttribute("basicExit") BasicExit basicExit) {
		Result result = new Result();
		try {
			String basicExitId = basicExit.getBasicExitId();
			// 如果basicExitId不存在则为新增,否则为编辑
			if (basicExit.getProceedsAmount() != null) {
				basicExit.setProceedsAmount(basicExit.getProceedsAmount()
						.replace(",", ""));
			}
			if (basicExit.getReducedInvestcost() != null) {
				basicExit.setReducedInvestcost(basicExit.getReducedInvestcost()
						.replace(",", ""));
			}
			if (basicExitId != null && !("").equals(basicExitId)) {
				basicExitService.update(basicExit);
			} else {
				basicExitService.insert(basicExit);
			}
			result.setResultCode(ResultEnum.SUCCESS.getValue());
			result.setMessage(ResultEnum.SUCCESS.getText());
		} catch (UnitedException e) {
			UnitedLogger.error(e);
			result.setResultCode(ResultEnum.FAIL.getValue());
			result.setMessageCode(e.getErrorCode());
			result.setMessage(e.loadErrorMessageByCode(request));
		}
		return result;
	}

	/**
	 * 
	 * @Title: delBasicExit
	 * @Description: 删除basicExit
	 * @param @param model
	 * @param @param request
	 * @param @param id
	 * @param @return 设定文件
	 * @return Result 返回类型
	 * @throws
	 */
	@ResponseBody
	@RequestMapping(value = "/delBasicExit.do", method = RequestMethod.POST)
	public Result delBasicExit(Model model, HttpServletRequest request,
			@RequestParam(value = "id") String id) {
		Result result = new Result();
		try {
			basicExitService.delete(Long.valueOf(id));
			result.setResultCode(ResultEnum.SUCCESS.getValue());
		} catch (NumberFormatException e) {
			UnitedLogger.error(e);
			result.setResultCode(ResultEnum.FAIL.getValue());
			result.setMessage(e.getMessage());
		} catch (UnitedException e) {
			UnitedLogger.error(e);
			result.setResultCode(ResultEnum.FAIL.getValue());
			result.setMessageCode(e.getErrorCode());
			result.setMessage(e.loadErrorMessageByCode(request));
		}
		return result;
	}

	/**
	 * 
	 * @Title: findRowDetails
	 * @Description: 查询+号内部的数据
	 * @param @param model
	 * @param @param request
	 * @param @param id
	 * @param @return 设定文件
	 * @return Result 返回类型
	 * @throws
	 */
	@ResponseBody
	@RequestMapping(value = "/findRowDetails.do", method = RequestMethod.POST)
	public Result findRowDetails(Model model, HttpServletRequest request,
			@RequestParam(value = "id") String id) {
		Result result = new Result();
		try {
			List<BasicExit> list = basicExitService.findRowDetails(id);
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
	 * @Title: resetSession
	 * @Description: 移除session
	 * @param request
	 * @return Result 返回类型
	 */
	@RequestMapping(value = "/resetSession.do", method = RequestMethod.GET)
	@ResponseBody
	public Result resetSession(Model model, HttpServletRequest request) {
		Result result = new Result();
		// 获得session
		HttpSession session = request.getSession();
		session.removeAttribute("portfolioNameCH");
		result.setResultCode(ResultEnum.SUCCESS.getValue());
		return result;
	}
}

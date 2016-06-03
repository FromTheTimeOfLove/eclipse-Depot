package com.datadriver.web.onePaper.controller;

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
import com.datadriver.web.common.enums.DictionaryType;
import com.datadriver.web.common.enums.FinalParamer;
import com.datadriver.web.common.enums.ResultEnum;
import com.datadriver.web.common.enums.SessionAttribute;
import com.datadriver.web.common.model.DataDictionary;
import com.datadriver.web.common.service.DataDictionaryService;
import com.datadriver.web.onePaper.dto.CustomerDto;
import com.datadriver.web.onePaper.dto.OnePaperDto;
import com.datadriver.web.onePaper.model.OnePaper;
import com.datadriver.web.onePaper.service.OnePaperService;
import com.datadriver.web.system.model.SystemUser;
import com.github.pagehelper.PageInfo;

/**
 * @ClassName: OnePaperController
 * @Description: One paper控制类
 * @date 2016-3-22 上午10:48:57
 */
@Controller
@RequestMapping(value = "/onePaper")
public class OnePaperController {

	@Resource
	private OnePaperService onePaperService;// 业务实现接口

	@Resource
	private DataDictionaryService dataDictionaryService;

	/**
	 * @Title: initListOnePaper
	 * @Description: 初始化One paper页面
	 * @return String 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/initListOnePaperPage.do", method = RequestMethod.GET)
	public String initListOnePaper(Model model) {
		// 初始化动态下拉字典
		List<DataDictionary> sector = dataDictionaryService
				.selectByType(DictionaryType.SECTOR_TYPE);

		// 初始化动态下拉字典
		List<DataDictionary> stage = dataDictionaryService
				.selectByType(DictionaryType.STAGE_TYPE);

		// 初始化动态下拉字典
		List<DataDictionary> fund = dataDictionaryService.selectFunds();

		// 初始化动态下拉字典
		List<DataDictionary> status = dataDictionaryService
				.selectByType(DictionaryType.STATUS_TYPE);

		model.addAttribute("secsector", sector);
		model.addAttribute("secstage", stage);
		model.addAttribute("secfund", fund);
		model.addAttribute("secstatus", status);

		return "onePaper/list_onePaper";
	}

	/**
	 * @Title: initAddOnePaper
	 * @Description: 跳转到新增页面
	 * @return String 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/initAddOnePaper.do", method = RequestMethod.GET)
	public String initAddOnePaper(Model model, String id) {

		// 初始化动态下拉字典
		List<DataDictionary> sector = dataDictionaryService
				.selectByType(DictionaryType.SECTOR_TYPE);

		// 初始化动态下拉字典
		List<DataDictionary> stage = dataDictionaryService
				.selectByType(DictionaryType.STAGE_TYPE);

		// 初始化动态下拉字典
		List<DataDictionary> fund = dataDictionaryService.selectFunds();

		// 初始化动态下拉字典
		List<DataDictionary> status = dataDictionaryService
				.selectByType(DictionaryType.STATUS_TYPE);

		model.addAttribute("secsector", sector);
		model.addAttribute("secstage", stage);
		model.addAttribute("secfund", fund);
		model.addAttribute("secstatus", status);
		return "onePaper/add_onePaper";
	}

	@RequestMapping(value = "/chooseCustomers.do", method = RequestMethod.GET)
	public String chooseCustomers(Model model, HttpServletRequest request) {

		OnePaperDto onePaperDto = new OnePaperDto();
		DataTablePage<OnePaper> onePaperDataList = new DataTablePage<OnePaper>(
				request);
		try {
			// 设置分页参数（当前页码、每页显示大小、排序参数）
			onePaperDto.setPageNum(onePaperDataList.getPageNum());
			onePaperDto.setPageSize(onePaperDataList.getLength());
			// 查询One Paper
			PageInfo<OnePaper> onePaperPageList = onePaperService
					.selectOnePaperListbyDto(onePaperDto);
			// 转换提取成DataTablePage的分页参数
			onePaperDataList = onePaperDataList.transfer(onePaperDataList,
					onePaperPageList);
		} catch (Exception e) {
			UnitedLogger.error(e);
		}
		model.addAttribute("onePaperDataList", onePaperDataList);
		return "onePaper/choosecustomers";
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
		session.removeAttribute("portfolioNameEN");
		result.setResultCode(ResultEnum.SUCCESS.getValue());
		return result;
	}

	/**
	 * 
	 * @Title: findOnePaperList
	 * @Description: 分页查询One Paper
	 * @param model
	 * @param request
	 * @param onePaperDto
	 * @return DataTablePage<OnePaper> 返回类型
	 */
	@RequestMapping(value = "/findOnePaperList.do", method = RequestMethod.POST)
	@ResponseBody
	public DataTablePage<OnePaper> findOnePaperList(Model model,
			HttpServletRequest request,
			@ModelAttribute("onePaperDto") OnePaperDto onePaperDto) {
		// 实例化分页插件
		DataTablePage<OnePaper> onePaperDataList = new DataTablePage<OnePaper>(
				request);
		try {
			// 获得session
			HttpSession session = request.getSession();
			// if (!Utils.isEmpty(onePaperDto.getPortfolionameCH())) {
			session.setAttribute("portfolioNameCH",
					onePaperDto.getPortfolionameCH());
			// }
			// if (!Utils.isEmpty(onePaperDto.getPortfolionameEN())) {
			session.setAttribute("portfolioNameEN",
					onePaperDto.getPortfolionameEN());
			// }
			// 设置分页参数（当前页码、每页显示大小、排序参数）
			onePaperDto.setPageNum(onePaperDataList.getPageNum());
			onePaperDto.setPageSize(onePaperDataList.getLength());
			// 查询One Paper
			PageInfo<OnePaper> onePaperPageList = onePaperService
					.selectOnePaperListbyDto(onePaperDto);
			// 转换提取成DataTablePage的分页参数
			onePaperDataList = onePaperDataList.transfer(onePaperDataList,
					onePaperPageList);
		} catch (Exception e) {
			UnitedLogger.error(e);
		}
		return onePaperDataList;
	}

	/**
	 * 
	 * @Title: findOnePaperList
	 * @Description: 分页查询One Paper
	 * @param model
	 * @param request
	 * @param onePaperDto
	 * @return DataTablePage<OnePaper> 返回类型
	 */
	@RequestMapping(value = "/findChooseList.do", method = RequestMethod.POST)
	@ResponseBody
	public DataTablePage<CustomerDto> findChooseList(Model model,
			HttpServletRequest request,
			@ModelAttribute("customer") CustomerDto customer) {
		// 实例化分页插件
		DataTablePage<CustomerDto> onePaperDataList = new DataTablePage<CustomerDto>(
				request);
		try {
			// 设置分页参数（当前页码、每页显示大小、排序参数）
			customer.setPageNum(onePaperDataList.getPageNum());
			customer.setPageSize(onePaperDataList.getLength());
			// 查询One Paper
			PageInfo<CustomerDto> onePaperPageList = onePaperService
					.selectCustomerDto(customer);
			// 转换提取成DataTablePage的分页参数
			onePaperDataList = onePaperDataList.transfer(onePaperDataList,
					onePaperPageList);
		} catch (Exception e) {
			UnitedLogger.error(e);
		}
		return onePaperDataList;
	}

	@RequestMapping(value = "/returethis.do", method = RequestMethod.POST)
	@ResponseBody
	public Result returethis(Model model, HttpServletRequest request) {
		Result result = new Result();
		return result;
	}

	/**
	 * 保存One Paper数据
	 * 
	 * @param model
	 * @param request
	 * @param emp
	 * @param empsex
	 * @return
	 */
	@RequestMapping(value = "/saveOnePaperObj.do", method = RequestMethod.POST)
	@ResponseBody
	public Result saveOnePaperObj(Model model, HttpServletRequest request,
			@ModelAttribute("onepaperdto") OnePaperDto onepaperdto) {
		Result result = new Result();
		HttpSession session = request.getSession();
		SystemUser systemuser = (SystemUser) session
				.getAttribute(SessionAttribute.USERINFO);
		session.setAttribute("portfolioNameCH",
				onepaperdto.getPortfolionameCH());
		session.setAttribute("portfolioNameEN",
				onepaperdto.getPortfolionameEN());
		// }
		try {
			String paperid = onepaperdto.getPaperid();
			if (onepaperdto.getValuation() != null) {
				onepaperdto.setValuation(onepaperdto.getValuation().replace(
						",", ""));
			}
			if (onepaperdto.getPricing() != null) {
				onepaperdto.setPricing(onepaperdto.getPricing()
						.replace(",", ""));
			}
			if (onepaperdto.getFinancials() != null) {
				onepaperdto.setFinancials(onepaperdto.getFinancials().replace(
						",", ""));
			}
			if (!"".equals(paperid) && paperid != null) {// 表示修改
				String updatename = onePaperService
						.updatePortfolioname(onepaperdto);
				if ("true".equals(updatename) || updatename == "true") {
					onePaperService.updateOnepaper(onepaperdto, systemuser);
					result.setMessage(ResultEnum.SUCCESS.getText());
					result.setResultCode(ResultEnum.SUCCESS.getValue());
				} else {
					result.setMessage(updatename);
					result.setResultCode(updatename);
				}

			} else {// 表示新增
				// 首先判断Portfolio name， Portfolio name (EN)是否存在
				String getname = onePaperService.findPortfolioname(onepaperdto);
				if ("true".equals(getname) || getname == "true") {
					onePaperService.insertOnepaper(onepaperdto, systemuser);
					result.setMessage(ResultEnum.SUCCESS.getText());
					result.setResultCode(ResultEnum.SUCCESS.getValue());
				} else {
					result.setMessage(getname);
					result.setResultCode(getname);
				}
			}

		} catch (Exception e) {
			UnitedLogger.error(e);
			result.setResultCode(ResultEnum.FAIL.getValue());
			// result.setMessageCode(e.getErrorCode());
			result.setMessage(e.getMessage());
		}
		return result;
	}

	/**
	 * 跳转数据修改界面
	 * 
	 * @param model
	 * @param request
	 * @param deptid
	 * @return
	 */
	@RequestMapping(value = "/initEditOnePaper.do", method = RequestMethod.GET)
	public String initEditOnePaper(Model model, HttpServletRequest request,
			@RequestParam(value = "paperid", defaultValue = "0") String paperid) {
		// 初始化动态下拉字典
		List<DataDictionary> sector = dataDictionaryService
				.selectByType(DictionaryType.SECTOR_TYPE);

		// 初始化动态下拉字典
		List<DataDictionary> stage = dataDictionaryService
				.selectByType(DictionaryType.STAGE_TYPE);

		// 初始化动态下拉字典
		List<DataDictionary> fund = dataDictionaryService.selectFunds();

		// 初始化动态下拉字典
		List<DataDictionary> status = dataDictionaryService
				.selectByType(DictionaryType.STATUS_TYPE);

		model.addAttribute("secsector", sector);
		model.addAttribute("secstage", stage);
		model.addAttribute("secfund", fund);
		model.addAttribute("secstatus", status);
		try {
			OnePaperDto onepaper = onePaperService.selectOnePaperById(Integer
					.valueOf(paperid));
			model.addAttribute("onepaper", onepaper);
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
		return "onePaper/add_onePaper";
	}

	/**
	 * Onepaper 删除
	 * 
	 * @param model
	 * @param request
	 * @param paperid
	 * @return
	 */
	@RequestMapping(value = "/delOnepaperBtId.do", method = RequestMethod.POST)
	@ResponseBody
	public Result delOnepaperBtId(Model model, HttpServletRequest request,
			@RequestParam("paperid") String paperid) {
		Result result = new Result();
		try {
			onePaperService.deleteOnepaper(paperid);
			result.setResultCode(ResultEnum.SUCCESS.getValue());
		} catch (NumberFormatException e) {
			UnitedLogger.error(e);
			result.setResultCode(ResultEnum.FAIL.getValue());
			result.setMessage(e.getMessage());
		} catch (UnitedException e) {
			UnitedLogger.error(e);
			result.setResultCode(ResultEnum.FAIL.getValue());
			result.setMessageCode(e.getErrorCode());
			result.setMessage(e.getMessage());
		}
		return result;
	}

}

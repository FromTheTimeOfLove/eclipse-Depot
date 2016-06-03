package com.datadriver.web.tsSigned.controller;

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
import com.datadriver.core.entity.UnitedLogger;
import com.datadriver.core.feature.orm.page.DataTablePage;
import com.datadriver.core.util.Utils;
import com.datadriver.web.common.enums.DictionaryType;
import com.datadriver.web.common.enums.ResultEnum;
import com.datadriver.web.common.enums.SessionAttribute;
import com.datadriver.web.common.model.DataDictionary;
import com.datadriver.web.common.service.DataDictionaryService;
import com.datadriver.web.system.model.SystemUser;
import com.datadriver.web.tsSigned.dto.TsSignedDto;
import com.datadriver.web.tsSigned.model.TsSigned;
import com.datadriver.web.tsSigned.service.TsSignedService;
import com.github.pagehelper.PageInfo;

/**
 * @ClassName: TsSignedController
 * @Description: Ts signed控制类
 * @date 2016-3-22 上午10:49:44
 */
@Controller
@RequestMapping(value = "/tsSigned")
public class TsSignedController {

	@Resource
	private TsSignedService tsSignedService;

	@Resource
	private DataDictionaryService dataDictionaryService;

	/**
	 * @Title: initListTsSigned
	 * @Description: 初始化Ts Signed页面
	 * @return String 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/initListTsSignedPage.do", method = RequestMethod.GET)
	public String initListTsSigned(Model model) {
		// 初始化动态下拉字典
		List<DataDictionary> fund = dataDictionaryService.selectFunds();
		List<DataDictionary> sector = dataDictionaryService
				.selectByType(DictionaryType.SECTOR_TYPE);

		model.addAttribute("secfund", fund);
		model.addAttribute("secsector", sector);
		return "tsSigned/list_tsSigned";
	}

	/**
	 * 
	 * @Title: initAddTsSigned
	 * @Description: 初始化新增页面
	 * @return String 返回类型
	 */
	@RequestMapping(value = "/initAddTsSigned.do", method = RequestMethod.GET)
	public String initAddTsSigned(Model model, HttpServletRequest request,
			@RequestParam(value = "paperId", defaultValue = "0") String paperId) {
		// 初始化动态下拉字典
		List<DataDictionary> fund = dataDictionaryService.selectFunds();
		List<DataDictionary> sector = dataDictionaryService
				.selectByType(DictionaryType.SECTOR_TYPE);
		List<DataDictionary> tsType = dataDictionaryService
				.selectByType(DictionaryType.TYPE_TYPE);
		List<DataDictionary> security = dataDictionaryService
				.selectByType(DictionaryType.SECURITY_TYPE);
		try {
				TsSigned tsSigned = tsSignedService.selectOnepaparById(paperId);
				tsSigned.setBridgeLoan("0");//是否过桥贷款，默认为yes
				model.addAttribute("tsSigned", tsSigned);
		} catch (Exception e) {
			UnitedLogger.error(e);
		}
		model.addAttribute("secfund", fund);
		model.addAttribute("secsector", sector);
		model.addAttribute("tsType", tsType);
		model.addAttribute("security", security);
		return "tsSigned/add_tsSigned";
	}

	/**
	 * 
	 * @Title: findTsSignedList
	 * @Description: 分页查询TS Signed
	 * @param model
	 * @param request
	 * @param tsSignedDto
	 * @return DataTablePage<OnePaper> 返回类型
	 */
	@RequestMapping(value = "/findTsSignedList.do", method = RequestMethod.POST)
	@ResponseBody
	public DataTablePage<TsSigned> findTsSignedList(Model model,
			HttpServletRequest request,
			@ModelAttribute("tsSignedDto") TsSignedDto tsSignedDto) {
		// 实例化分页插件
		DataTablePage<TsSigned> tsSignedDataList = new DataTablePage<TsSigned>(
				request);
		try {
			// 验证是否为空，不为空时添加到session
			// if (!Utils.isEmpty(tsSignedDto.getPortfolioNameCH())) {
			// 获得session
			HttpSession session = request.getSession();
			// 把投资组合中文名称存入session
			session.setAttribute("portfolioNameCH",
					tsSignedDto.getPortfolioNameCH());
			session.setAttribute("portfolioNameEN",
					tsSignedDto.getPortfolioNameEN());
			// }
			// 设置分页参数（当前页码、每页显示大小、排序参数）
			tsSignedDto.setPageNum(tsSignedDataList.getPageNum());
			tsSignedDto.setPageSize(tsSignedDataList.getLength());
			// 查询TsSigned
			PageInfo<TsSigned> tsSignedPageList = tsSignedService
					.selectTsSignedListbyDto(tsSignedDto);
			// 转换提取成DataTablePage的分页参数
			tsSignedDataList = tsSignedDataList.transfer(tsSignedDataList,
					tsSignedPageList);
		} catch (Exception e) {
			UnitedLogger.error(e);
		}
		return tsSignedDataList;
	}

	/**
	 * 
	 * @Title: findTsSignedById
	 * @Description: id查询
	 * @param @param model
	 * @param @param request
	 * @param @param tsSignedId
	 * @param @return 设定文件
	 * @return TsSigned 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/findTsSignedById.do", method = RequestMethod.GET)
	public String findTsSignedById(
			Model model,
			HttpServletRequest request,
			@RequestParam(value = "tsSignedId", defaultValue = "0") String tsSignedId) {
		// 初始化动态下拉字典
		List<DataDictionary> fund = dataDictionaryService.selectFunds();
		List<DataDictionary> sector = dataDictionaryService
				.selectByType(DictionaryType.SECTOR_TYPE);
		List<DataDictionary> tsType = dataDictionaryService
				.selectByType(DictionaryType.TYPE_TYPE);
		List<DataDictionary> security = dataDictionaryService
				.selectByType(DictionaryType.SECURITY_TYPE);
		TsSigned signed = new TsSigned();
		try {
			signed = tsSignedService.selectTsSignedById(tsSignedId);
		} catch (Exception e) {
			UnitedLogger.error(e);
		}
		model.addAttribute("secfund", fund);
		model.addAttribute("secsector", sector);
		model.addAttribute("tsType", tsType);
		model.addAttribute("security", security);
		model.addAttribute("tsSigned", signed);
		return "tsSigned/add_tsSigned";
	}

	/**
	 * 
	 * @Title: saveTsSigned
	 * @Description: 新增，修改方法，id值判断新增或修改
	 * @param @param model
	 * @param @param request
	 * @param @param signed
	 * @param @return 设定文件
	 * @return Result 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/saveTsSigned.do", method = RequestMethod.POST)
	@ResponseBody
	public Result saveTsSigned(Model model, HttpServletRequest request,
			@ModelAttribute("tsSigned") TsSigned signed) {
		Result result = new Result();
		HttpSession session = request.getSession();
		SystemUser systemuser = (SystemUser) session
				.getAttribute(SessionAttribute.USERINFO);
		try {
			// if (signed.getTsSignedId() == null ||
			// "".equals(signed.getTsSignedId())) {
			if (Utils.isEmpty(signed.getTsSignedId())) {// 表示新增
				tsSignedService.insertTsSigned(signed, systemuser);
			} else {// 标示修改
				tsSignedService.updateTsSigned(signed, systemuser);
			}
			result.setMessage(ResultEnum.SUCCESS.getText());
			result.setResultCode(ResultEnum.SUCCESS.getValue());
		} catch (Exception e) {
			UnitedLogger.error(e);
			result.setResultCode(ResultEnum.FAIL.getValue());
		}
		return result;
	}

	/**
	 * 
	 * @Title: deleteTsSigned
	 * @Description: 删除功能，实际修改字段D_THRUDATE 为1代表已删除0未删除
	 * @param @param model
	 * @param @param request
	 * @param @param tsSignedId
	 * @param @return 设定文件
	 * @return Result 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/deleteTsSigned.do", method = RequestMethod.POST)
	@ResponseBody
	public Result deleteTsSigned(
			Model model,
			HttpServletRequest request,
			@RequestParam(value = "tsSignedId", defaultValue = "0") String tsSignedId) {
		Result result = new Result();
		try {
			if (tsSignedId == "0") {
				result.setResultCode(ResultEnum.FAIL.getValue());
				return result;
			}
			tsSignedService.updateThruDate(tsSignedId);
			result.setMessage(ResultEnum.SUCCESS.getText());
			result.setResultCode(ResultEnum.SUCCESS.getValue());
		} catch (Exception e) {
			UnitedLogger.error(e);
			result.setResultCode(ResultEnum.FAIL.getValue());
		}
		return result;
	}
}

package com.datadriver.web.warrantTracker.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.datadriver.core.entity.UnitedLogger;
import com.datadriver.core.feature.orm.page.DataTablePage;
import com.datadriver.core.util.Utils;
import com.datadriver.web.loanTracker.dto.LoanTrackerDto;
import com.datadriver.web.loanTracker.model.LoanTracker;
import com.datadriver.web.loanTracker.service.LoanTrackerService;
import com.datadriver.web.onePaper.dto.OnePaperDto;
import com.datadriver.web.onePaper.model.OnePaper;
import com.datadriver.web.warrantTracker.dto.WarrantTrackerDto;
import com.datadriver.web.warrantTracker.model.WarrantTracker;
import com.datadriver.web.warrantTracker.service.WarrantTrackerService;
import com.github.pagehelper.PageInfo;

/**
 * 
 * @Acthor：hurentao
 * @ClassName: WarrantTrackerController
 * @Description: warrantTracker 控制器
 * @Date 2016-4-14 上午9:43:10
 */
@Controller
@RequestMapping(value = "/warrantTracker")
public class WarrantTrackerController {
	
	@Resource
	private WarrantTrackerService warrantTrackerService;
	
	/**
	* @Title: initListWarrantTracker
	* @Description: 初始化WarrantTracker页面
	* @return String 返回类型
	* @throws
	 */
	@RequestMapping(value = "/initListWarrantTracker.do", method = RequestMethod.GET)
	public String initListWarrantTracker() {
		return "warrantTracker/list_warrantTracker";
	}
	
	/**
	 * 
	 * @Title: findWarrantTrackerList
	 * @Description: 查询
	 * @param model
	 * @param request
	 * @param warrantTrackerDto
	 * @return DataTablePage<WarrantTracker> 返回类型
	 */
	@RequestMapping(value = "/findWarrantTrackerList.do", method = RequestMethod.POST)
	@ResponseBody
	public DataTablePage<WarrantTracker> findWarrantTrackerList(Model model, HttpServletRequest request,
		@ModelAttribute("warrantTrackerDto") WarrantTrackerDto warrantTrackerDto) {
		//实例化分页插件
		DataTablePage<WarrantTracker> warrantTrackerDataList = new DataTablePage<WarrantTracker>(request);
		try {
			//设置分页参数（当前页码、每页显示大小、排序参数）
			warrantTrackerDto.setPageNum(warrantTrackerDataList.getPageNum());
			warrantTrackerDto.setPageSize(warrantTrackerDataList.getLength());
			//查询One Paper
			PageInfo<WarrantTracker> warrantTrackerDtoPageList = warrantTrackerService.selectWarrantTrackerListbyDto(warrantTrackerDto);
			//转换提取成DataTablePage的分页参数
			warrantTrackerDataList = warrantTrackerDataList.transfer(warrantTrackerDataList, warrantTrackerDtoPageList);
		} catch (Exception e) {
			UnitedLogger.error(e);
			//model.addAttribute(FinalParamer.MESSAGE, e.loadErrorMessageByCode(request));
			//model.addAttribute(FinalParamer.RESULT, ResultEnum.FAIL.getValue());
		}
		return warrantTrackerDataList;
	} 
	
}

package com.datadriver.web.loanTracker.controller;

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
import com.github.pagehelper.PageInfo;

/**
 * 
 * @Acthor：hurentao
 * @ClassName: LoanTrackerController
 * @Description: loanTracker 控制器
 * @Date 2016-4-14 上午9:43:10
 */
@Controller
@RequestMapping(value = "/loanTracker")
public class LoanTrackerController {
	
	@Resource
	private LoanTrackerService loanTrackerService;
	
	/**
	* @Title: initListLoanTracker
	* @Description: 初始化LoanTracker页面
	* @return String 返回类型
	* @throws
	 */
	@RequestMapping(value = "/initListLoanTracker.do", method = RequestMethod.GET)
	public String initListLoanTracker() {
		return "loanTracker/list_loanTracker";
	}
	
	/**
	 * 
	 * @Title: findLoanTrackerList
	 * @Description: 查询
	 * @param model
	 * @param request
	 * @param loanTrackerDto
	 * @return DataTablePage<LoanTracker> 返回类型
	 */
	@RequestMapping(value = "/findLoanTrackerList.do", method = RequestMethod.POST)
	@ResponseBody
	public DataTablePage<LoanTracker> findLoanTrackerList(Model model, HttpServletRequest request,
		@ModelAttribute("loanTrackerDto") LoanTrackerDto loanTrackerDto) {
		//实例化分页插件
		DataTablePage<LoanTracker> loanTrackerDataList = new DataTablePage<LoanTracker>(request);
		try {
			//设置分页参数（当前页码、每页显示大小、排序参数）
			loanTrackerDto.setPageNum(loanTrackerDataList.getPageNum());
			loanTrackerDto.setPageSize(loanTrackerDataList.getLength());
			//查询One Paper
			PageInfo<LoanTracker> loanTrackerPageList = loanTrackerService.selectLoanTrackerListbyDto(loanTrackerDto);
			//转换提取成DataTablePage的分页参数
			loanTrackerDataList = loanTrackerDataList.transfer(loanTrackerDataList, loanTrackerPageList);
		} catch (Exception e) {
			UnitedLogger.error(e);
			//model.addAttribute(FinalParamer.MESSAGE, e.loadErrorMessageByCode(request));
			//model.addAttribute(FinalParamer.RESULT, ResultEnum.FAIL.getValue());
		}
		return loanTrackerDataList;
	} 
	
}

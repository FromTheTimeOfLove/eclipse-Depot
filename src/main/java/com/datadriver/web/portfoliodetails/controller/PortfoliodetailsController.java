package com.datadriver.web.portfoliodetails.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.datadriver.core.entity.UnitedException;
import com.datadriver.core.entity.UnitedLogger;
import com.datadriver.core.feature.orm.page.DataTablePage;
import com.datadriver.web.basicInfo.dto.BasicInfoDto;
import com.datadriver.web.basicInfo.model.BasicInfo;
import com.datadriver.web.basicInfo.service.BasicInfoService;
import com.datadriver.web.common.enums.FinalParamer;
import com.datadriver.web.common.enums.ResultEnum;
import com.github.pagehelper.PageInfo;

/**
 * @ClassName: BasicInfoController
 * @Description: Basic info 控制类
 * @date 2016-3-22 上午10:46:22
 */
@Controller
@RequestMapping(value = "/portfoliodetails")
public class PortfoliodetailsController {

	@Resource
	private BasicInfoService basicinfoservice;

	/**
	 * @Title: initListBasicInfo
	 * @Description: 初始化BasicInfo页面
	 * @return String 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/initFinanceportfoliodetails.do", method = RequestMethod.GET)
	public String initListBasicInfo() {
		return "portfoliodetails/list_portfoliodetails";
	}

	/**
	 * 获取Basic Info 信息
	 * 
	 * @param model
	 * @param request
	 * @param basicinfoDto
	 * @return
	 */
	@RequestMapping(value = "/findListPortfoliodetails.do", method = RequestMethod.POST)
	@ResponseBody
	public DataTablePage<BasicInfo> findListPortfoliodetails(Model model,
			HttpServletRequest request,
			@ModelAttribute("basicinfoDto") BasicInfoDto basicinfoDto) {
		// 实例化分页插件
		DataTablePage<BasicInfo> basicinfoPageList = new DataTablePage<BasicInfo>(
				request);
		try {
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

}

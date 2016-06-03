package com.datadriver.web.fundMgmt.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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
import com.datadriver.web.common.enums.FinalParamer;
import com.datadriver.web.common.enums.ResultEnum;
import com.datadriver.web.fundMgmt.dto.FundDto;
import com.datadriver.web.fundMgmt.model.Fund;
import com.datadriver.web.fundMgmt.service.FundMgmtService;
import com.github.pagehelper.PageInfo;

/**
* @ClassName: FundMgmtController
* @Description: 出资玉体控制类
* @date 2016-3-22 上午10:47:39
 */
@Controller
@RequestMapping(value = "/fundMgmt")
public class FundMgmtController {
	
	@Resource
	private FundMgmtService fundMgmtService;
	/**
	* @Title: initListFundMgmt
	* @Description: 初始化出资主体页面
	* @return String 返回类型
	* @throws
	 */
	@RequestMapping(value = "/initListFundMgmtPage.do", method = RequestMethod.GET)
	public String initListFundMgmt() {
		return "fundMgmt/list_fundMgmt";
	}
	
	@ResponseBody
	@RequestMapping(value = "/findFundList.do", method = RequestMethod.POST)
	public DataTablePage<Fund> findListBasicInfo(Model model,
			HttpServletRequest request,
			@ModelAttribute("fundDto") FundDto fundDto) {
		// 实例化分页插件
		DataTablePage<Fund> fundPageList = new DataTablePage<Fund>(request);
		try {
			// 设置分页参数（当前页码、每页显示大小、排序参数）
			fundDto.setPageNum(fundPageList.getPageNum());
			fundDto.setPageSize(fundPageList.getLength());
			
			PageInfo<Fund> fundList = fundMgmtService.selectFundPage(fundDto);
			// 转换提取成DataTablePage的分页参数
			fundPageList = fundPageList.transfer(fundPageList, fundList);
		} catch (UnitedException e) {
			UnitedLogger.error(e);
			model.addAttribute(FinalParamer.MESSAGE,
					e.loadErrorMessageByCode(request));
			model.addAttribute(FinalParamer.RESULT, ResultEnum.FAIL.getValue());
		}
		return fundPageList;
	}
	/**
	* @Title: initAddFund
	* @Description: 初始化添加/编辑页面
	* @return String 返回类型
	* @throws
	 */
	@RequestMapping(value = "/initAddFund.do", method = RequestMethod.GET)
	public String initAddFund(Model model, HttpServletRequest request,String id) {
		//如果ID不为空，则查出需要回显的数据
		if(!Utils.isEmpty(id)){
			try {
				Fund fund = fundMgmtService.selectById(Long.valueOf(id));
				model.addAttribute("fund", fund);
			} catch (NumberFormatException e) {
				UnitedLogger.error(e);
			} catch (UnitedException e) {
				UnitedLogger.error(e);
			}
		
		}
		return "fundMgmt/add_fund";
	}
	
	/**
	 * 
	 * @Title: delFund
	 * @Description: 删除出资主体
	 * @param @param model
	 * @param @param request
	 * @param @param id
	 * @param @return 设定文件
	 * @return Result 返回类型
	 * @throws
	 */
	@ResponseBody
	@RequestMapping(value = "/delFund.do", method = RequestMethod.POST)
	public Result delFund(Model model, HttpServletRequest request,@RequestParam("id")String id) {
		Result result = new Result();
		try {
			fundMgmtService.delete(Long.valueOf(id));
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
	 * @Title: saveFund
	 * @Description: 保存新建/编辑后的出资主体
	 * @param @param model
	 * @param @param request
	 * @param @param fund
	 * @param @return 设定文件
	 * @return Result 返回类型
	 * @throws
	 */
	@ResponseBody
	@RequestMapping(value = "/saveFund.do", method = RequestMethod.POST)
	public Result saveFund(Model model,HttpServletRequest request,@ModelAttribute("fund")Fund fund){
		Result result = new Result();
		try {
			String fundId = fund.getFundId(); 
			//验重判断
			Long flag = fundMgmtService.isRepeat(fund);
			if(flag<=0){
				if (fundId != null && !"".equals(fundId)) {
					fundMgmtService.update(fund);
				} else {
					fundMgmtService.insert(fund);
				}
				result.setResultCode(ResultEnum.SUCCESS.getValue());
				result.setMessage("保存成功"); 
			}else{
				result.setResultCode(ResultEnum.FAIL.getValue());
				result.setMessageCode("0");
				result.setMessage("出资主体有重复"); 
			}
		} catch (UnitedException e) {
			UnitedLogger.error(e);
			result.setResultCode(ResultEnum.FAIL.getValue());
			result.setMessageCode(e.getErrorCode());
			result.setMessage(e.loadErrorMessageByCode(request));  
		}
		return result;
	}
}

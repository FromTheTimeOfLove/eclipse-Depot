package com.datadriver.web.dept.controller;

import java.util.List;

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
import com.datadriver.web.common.enums.FinalParamer;
import com.datadriver.web.common.enums.ResultEnum;
import com.datadriver.web.common.model.ZtreeNode;
import com.datadriver.web.common.service.DataDictionaryService;
import com.datadriver.web.dept.dto.DeptDto;
import com.datadriver.web.dept.model.Dept;
import com.datadriver.web.dept.service.DeptService;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping(value = "/dept")
public class DeptController {

	@Resource
	private DataDictionaryService dataDictionaryService;

	@Resource
	private DeptService deptService;

	/**
	 * @Title: initListBasicInfo
	 * @Description: 初始化deptment页面
	 * @return String 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/initListDeptPage.do", method = RequestMethod.GET)
	public String initListDeptPage() {
		return "dept/list_dept";
	}

	/**
	 * 部门列表查询
	 * 
	 * @param model
	 * @param request
	 * @param deptDto
	 * @return
	 */
	@RequestMapping(value = "/findDept.do", method = RequestMethod.POST)
	@ResponseBody
	public DataTablePage<DeptDto> findDeptByDto(Model model,
			HttpServletRequest request,
			@ModelAttribute("deptDto") DeptDto deptDto) {

		// List<DataDictionary> dictionaries = dataDictionaryService
		// .selectByType(DictionaryType.emp);
		// model.addAttribute("empSelect", dictionaries);

		// 实例化分页插件
		DataTablePage<DeptDto> deptPageList = new DataTablePage<DeptDto>(
				request);
		try {
			// 设置分页参数（当前页码、每页显示大小、排序参数）
			deptDto.setPageNum(deptPageList.getPageNum());
			deptDto.setPageSize(deptPageList.getLength());
			// 查询学生信息
			PageInfo<DeptDto> stuList = deptService.findEmpListbyDto(deptDto);
			// 转换提取成DataTablePage的分页参数
			deptPageList = deptPageList.transfer(deptPageList, stuList);
		} catch (UnitedException e) {
			UnitedLogger.error(e);
			model.addAttribute(FinalParamer.MESSAGE,
					e.loadErrorMessageByCode(request));
			model.addAttribute(FinalParamer.RESULT, ResultEnum.FAIL.getValue());
		}
		return deptPageList;
	}

	/**
	 * 跳转到部门新增界面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/initAddNewDept.do", method = RequestMethod.GET)
	public String initAddNewDept(Model model) {
		// 初始化动态下拉字典
		// List<DataDictionary> dictionaries = dataDictionaryService
		// .selectByType(DictionaryType.emp);
		// model.addAttribute("empSelect", dictionaries);
		Dept dept = new Dept();
		model.addAttribute("dept", dept);
		return "dept/edit_dept";
	}

	/**
	 * @Title: initListBasicInfo
	 * @Description: 初始化BasicInfo页面
	 * @return String 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/initAddBasicExit.do", method = RequestMethod.GET)
	public String initAddBasicInfo() {
		return "basicExit/add_basicExit";
	}

	/**
	 * 
	 * @Title: saveDeptObj
	 * @Description: 部门信息 数据保存
	 * @param model
	 * @param request
	 * @param dept
	 * @return Result 返回类型
	 */
	@RequestMapping(value = "/saveDeptObject.do", method = RequestMethod.POST)
	@ResponseBody
	public Result saveDeptObj(Model model, HttpServletRequest request,
			@ModelAttribute("dept") Dept dept) {
		Result result = new Result();
		try {
			String deptid = dept.getDeptid();
			if (!"".equals(deptid) && deptid != null) {// 表示修改
				dept.setStatus(0);
				deptService.update(dept);
			} else {// 表示新增
				deptService.insert(dept);
			}
			result.setMessage(ResultEnum.SUCCESS.getText());
			result.setResultCode(ResultEnum.SUCCESS.getValue());
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
	@RequestMapping(value = "/initEditDeptInfo.do", method = RequestMethod.GET)
	public String initEditDeptInfo(Model model, HttpServletRequest request,
			@RequestParam(value = "deptid", defaultValue = "0") String deptid) {
		try {
			DeptDto dept = deptService.selectDeptById(Integer.valueOf(deptid));
			model.addAttribute("dept", dept);
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

		return "dept/edit_dept";
	}

	/**
	 * 删除部门信息
	 * 
	 * @param model
	 * @param request
	 * @param deptid
	 * @return
	 */
	@RequestMapping(value = "/delDeptInfo.do", method = RequestMethod.POST)
	@ResponseBody
	public Result delDeptInfo(Model model, HttpServletRequest request,
			@RequestParam("deptid") String deptid) {
		Result result = new Result();
		try {
			deptService.delete(Long.valueOf(deptid));
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

	/**
	 * 部门信息--上级部门选择
	 * 
	 * @param model
	 * @param request
	 * @param roleId
	 * @return
	 */
	@RequestMapping(value = "/initPermissionBtId.do", method = RequestMethod.GET)
	public String initPermissionBtId(Model model, HttpServletRequest request) {
		// 获取角色信息
		// Role role = new Role();
		// role.setRoleId(roleId);
		// model.addAttribute("role", role);
		return "dept/alterPermission_dept";
	}

	/**
	 * 返回部门树
	 * 
	 * @param model
	 * @param request
	 * @param roleDto
	 * @return
	 */
	@RequestMapping(value = "/findDeptPermissionTree.do", method = RequestMethod.POST)
	@ResponseBody
	public List<ZtreeNode> findDeptPermissionTree(Model model,
			HttpServletRequest request) {
		List<ZtreeNode> permissionList = null;
		try {
			permissionList = deptService.findDeptPermissionTree();
		} catch (UnitedException e) {
			UnitedLogger.error(e);
		}
		return permissionList;
	}

}

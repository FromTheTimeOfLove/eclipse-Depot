package com.datadriver.web.role.controller;

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
import com.datadriver.core.util.Constant;
import com.datadriver.web.common.enums.FinalParamer;
import com.datadriver.web.common.enums.ResultEnum;
import com.datadriver.web.role.dto.RoleDto;
import com.datadriver.web.role.model.Role;
import com.datadriver.web.role.model.RoleAndPermissionZtreeNode;
import com.datadriver.web.role.service.RoleService;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping(value = "/role")
public class RolesController {

	@Resource
	private RoleService roleService;

	@RequestMapping(value = "/initListRolePage.do", method = RequestMethod.GET)
	public String initListrolePage(Model model) {
		return "role/list_role";
	}

	@RequestMapping(value = "/findListRole.do", method = RequestMethod.POST)
	@ResponseBody
	public DataTablePage<Role> findListRole(Model model,
			HttpServletRequest request,
			@ModelAttribute("roleDto") RoleDto roleDto) {
		DataTablePage<Role> pageList = new DataTablePage<Role>(request);
		try {
			// 转换DataTable的参数传递到service
			roleDto.setPageNum(pageList.getPageNum());
			roleDto.setPageSize(pageList.getLength());
			roleDto.setOrderString(pageList.getOrderStr());
			// 获取分页数据
			PageInfo<Role> pageInfoList = roleService
					.selectPageByRoleName(roleDto);
			// 转换提取成DataTable的分页参数
			pageList = pageList.transfer(pageList, pageInfoList);

		} catch (UnitedException e) {
			UnitedLogger.error(e);
			model.addAttribute(FinalParamer.MESSAGE,
					e.loadErrorMessageByCode(request));
			model.addAttribute(FinalParamer.RESULT, ResultEnum.FAIL.getValue());
		}
		return pageList;
	}

	@RequestMapping(value = "/initAddNewRole.do", method = RequestMethod.GET)
	public String initAddNewRole(Model model) {
		return "role/edit_role";
	}

	@RequestMapping(value = "/saveRole.do", method = RequestMethod.POST)
	@ResponseBody
	public Result saveRole(Model model, HttpServletRequest request,
			@ModelAttribute("role") Role role) {
		Result result = new Result();
		int count = 0;
		try {
			String idString = role.getRoleId();
			if (idString != null && !("").equals(idString)) {// 标示修改
				count = roleService.findUserRole(role, "update");// 判断数据库中是否存在该登录账号
				if (count > 0) {// 标示数据库已经存在
					result.setMessage(Constant.RoleNAME);
					result.setResultCode(Constant.RoleNAME);
				} else {
					roleService.update(role);
					result.setMessage(ResultEnum.SUCCESS.getText());
					result.setResultCode(ResultEnum.SUCCESS.getValue());
				}
			} else {// 标示新增
				count = roleService.findUserRole(role, "insert");// 判断数据库中是否存在该登录账号
				if (count > 0) {// 标示数据库已经存在
					result.setMessage(Constant.RoleNAME);
					result.setResultCode(Constant.RoleNAME);
				} else {
					roleService.insert(role);
					result.setMessage(ResultEnum.SUCCESS.getText());
					result.setResultCode(ResultEnum.SUCCESS.getValue());
				}
			}
		} catch (UnitedException e) {
			UnitedLogger.error(e);
			result.setResultCode(ResultEnum.FAIL.getValue());
			result.setMessageCode(e.getErrorCode());
			result.setMessage(e.loadErrorMessageByCode(request));
		}
		return result;
	}

	@RequestMapping(value = "/initEditRole.do", method = RequestMethod.GET)
	public String initEditRole(Model model, HttpServletRequest request,
			@RequestParam(value = "id", defaultValue = "0") String id) {
		try {
			// 获取角色信息
			Role role = roleService.selectById(Long.valueOf(id));
			model.addAttribute("role", role);
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
		return "role/edit_role";
	}

	@RequestMapping(value = "/delRoleById.do", method = RequestMethod.POST)
	@ResponseBody
	public Result delRoleById(Model model, HttpServletRequest request,
			@RequestParam(value = "id") String id) {
		Result result = new Result();
		try {
			roleService.delete(Long.valueOf(id));
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

	@RequestMapping(value = "/initPermissionBtId.do", method = RequestMethod.GET)
	public String initPermissionBtId(Model model, HttpServletRequest request,
			@RequestParam(value = "roleId", defaultValue = "0") String roleId) {
		model.addAttribute("roleId", roleId);
		return "role/alterPermission_role";
	}

	@RequestMapping(value = "/findPermissionTree.do", method = RequestMethod.POST)
	@ResponseBody
	public List<RoleAndPermissionZtreeNode> findPermissionTree(Model model,
			HttpServletRequest request,
			@ModelAttribute("roleDto") RoleDto roleDto) {
		List<RoleAndPermissionZtreeNode> permissionList = null;
		try {
			permissionList = roleService.findPermissionTree(roleDto);
		} catch (UnitedException e) {
			UnitedLogger.error(e);
		}
		return permissionList;
	}

	@RequestMapping(value = "/saveRolePermission.do", method = RequestMethod.POST)
	@ResponseBody
	public Result saveRolePermission(Model model, HttpServletRequest request,
			@ModelAttribute("roleDto") RoleDto roleDto) {
		Result result = new Result();
		try {
			roleService.saveRolePermission(roleDto);
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

}

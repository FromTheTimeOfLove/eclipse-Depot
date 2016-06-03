package com.datadriver.web.user.controller;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
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
import com.datadriver.web.common.enums.DictionaryType;
import com.datadriver.web.common.enums.FinalParamer;
import com.datadriver.web.common.enums.ResultEnum;
import com.datadriver.web.common.enums.SessionAttribute;
import com.datadriver.web.common.model.DataDictionary;
import com.datadriver.web.common.model.ZtreeNode;
import com.datadriver.web.common.service.DataDictionaryService;
import com.datadriver.web.system.model.SystemUser;
import com.datadriver.web.user.dto.UserDto;
import com.datadriver.web.user.model.User;
import com.datadriver.web.user.service.UserService;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping(value = "/user")
public class UsersController {
	@Resource
	private UserService userService;
	
	@Resource
	private DataDictionaryService dataDictionaryService;

	@RequestMapping(value = "/initListUserPage.do", method = RequestMethod.GET)
	public String initListUserPage(Model model) {
		return "user/list_user";
	}

	@RequestMapping(value = "/initAddNewUser.do", method = RequestMethod.GET)
	public String initAddNewUser(Model model) {
		//职位
		List<DataDictionary> positionDatas = dataDictionaryService.selectByType(DictionaryType.POSITION_TYPE);
		model.addAttribute("positionDatas", positionDatas);
		return "user/edit_user";
	}

	@RequestMapping(value = "/initRoleEmp.do", method = RequestMethod.GET)
	public String initRoleEmp(Model model, @RequestParam("userId") String userId) {
		model.addAttribute("userId", userId);
		return "user/user_roleEmpowering";
	}

	@RequestMapping(value = "/findRoleTree.do", method = RequestMethod.POST)
	@ResponseBody
	public List<ZtreeNode> findRoleTree(Model model,
			HttpServletRequest request,
			@RequestParam(value = "userId", defaultValue = "0") String userId) {
		List<ZtreeNode> roleList = new ArrayList<ZtreeNode>();
		try {
			roleList = userService.selectRoleTree(userId);
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
		return roleList;
	}

	@RequestMapping(value = "/findListUser.do", method = RequestMethod.POST)
	@ResponseBody
	public DataTablePage<User> findListUser(Model model,
			HttpServletRequest request,
			@ModelAttribute("userDto") UserDto userDto) {
		DataTablePage<User> pageList = new DataTablePage<User>(request);
		try {
			// 转换DataTable的参数传递到service
			userDto.setPageNum(pageList.getPageNum());
			userDto.setPageSize(pageList.getLength());
			userDto.setOrderString(pageList.getOrderStr());
			// 获取分页数据
			PageInfo<User> pageInfoList = userService
					.selectPageByUserName(userDto);
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

	@RequestMapping(value = "/saveUserRole.do", method = RequestMethod.POST)
	@ResponseBody
	public Result saveUserRole(Model model, HttpServletRequest request,
			@ModelAttribute("user") User user) {
		Result result = new Result();
		try {
			userService.saveUserRole(user);
			result.setResultCode(ResultEnum.SUCCESS.getValue());
		} catch (UnitedException e) {
			UnitedLogger.error(e);
			result.setResultCode(ResultEnum.FAIL.getValue());
			result.setMessageCode(e.getErrorCode());
			result.setMessage(e.loadErrorMessageByCode(request));
		}
		return result;
	}

	/**
	 * 用户人员保存和修改
	 * 
	 * @param model
	 * @param request
	 * @param user
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeySpecException
	 */
	@RequestMapping(value = "/saveUser.do", method = RequestMethod.POST)
	@ResponseBody
	public Result saveUser(Model model, HttpServletRequest request,
			@ModelAttribute("user") User user) throws NoSuchAlgorithmException,
			InvalidKeySpecException {
		Result result = new Result();
		int count = 0;
		try {
			String idString = user.getUserId();
			if (idString != null && !("").equals(idString)) {// 标示修改
				count = userService.findUserName(user, "update");// 判断数据库中是否存在该登录账号
				if (count > 0) {// 标示数据库已经存在
					result.setMessage(Constant.USERNAME);
					result.setResultCode(Constant.USERNAME);
				} else {
					userService.update(user);
					result.setMessage(ResultEnum.SUCCESS.getText());
					result.setResultCode(ResultEnum.SUCCESS.getValue());
				}
			} else {// 标示新增
				count = userService.findUserName(user, "insert");// 判断数据库中是否存在该登录账号
				if (count > 0) {// 标示数据库已经存在
					result.setMessage(Constant.USERNAME);
					result.setResultCode(Constant.USERNAME);
				} else {
					userService.insert(user);
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

	@RequestMapping(value = "/initEditUser.do", method = RequestMethod.GET)
	public String initEditUser(Model model, HttpServletRequest request,
			@RequestParam(value = "id", defaultValue = "0") String id) {
		try {
			List<DataDictionary> positionDatas = dataDictionaryService.selectByType(DictionaryType.POSITION_TYPE);
			model.addAttribute("positionDatas", positionDatas);
			// 获取用户信息
			User user = userService.selectById(Long.valueOf(id));
			model.addAttribute("user", user);
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
		return "user/edit_user";
	}

	@RequestMapping(value = "/delUserById.do", method = RequestMethod.POST)
	@ResponseBody
	public Result delUserById(Model model, HttpServletRequest request,
			@RequestParam(value = "id") String id) {
		Result result = new Result();
		try {
			userService.delete(Long.valueOf(id));
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

	@RequestMapping(value = "/initPasswordById.do", method = RequestMethod.GET)
	public String initPasswordById(Model model, HttpServletRequest request) {
		// 获取用户信息
		try {
			SystemUser currentUser = (SystemUser) request.getSession()
					.getAttribute(SessionAttribute.USERINFO);
			User user = userService.selectById(Long.valueOf(currentUser
					.getUserId()));
			model.addAttribute("user", user);
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
		return "user/changePwd_user";
	}

	@RequestMapping(value = "/editUserInfoById", method = RequestMethod.GET)
	@ResponseBody
	public Result editUserInfoById(Model model, HttpServletRequest request,
			@ModelAttribute("user") User user) {
		Result result = new Result();
		try {
			userService.updateUserByUserId(user);
			result.setResultCode(ResultEnum.SUCCESS.getValue());
		} catch (UnitedException e) {
			UnitedLogger.error(e);
			result.setResultCode(ResultEnum.FAIL.getValue());
			result.setMessage(e.getMessage());
			result.setMessageCode(e.loadErrorMessageByCode(request));
		}
		return result;
	}

	@RequestMapping(value = "/updatePwdByUserId.do", method = RequestMethod.POST)
	@ResponseBody
	public Result updatePwdByUserId(Model model, HttpServletRequest request,
			@ModelAttribute("userDto") UserDto userDto) {
		Result result = new Result();
		try {
			result = userService.updatePwdByUserId(userDto);
		} catch (UnitedException e) {
			UnitedLogger.error(e);
			result.setResultCode(ResultEnum.FAIL.getValue());
			result.setMessage(e.getMessage());
			result.setMessageCode(e.loadErrorMessageByCode(request));
		}
		return result;
	}

	@RequestMapping(value = "/rePassword.do", method = RequestMethod.POST)
	@ResponseBody
	public Result rePassword(Model model, HttpServletRequest request,
			@RequestParam(value = "id") String id) {
		Result result = new Result();
		try {
			userService.updatePassword(id);
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

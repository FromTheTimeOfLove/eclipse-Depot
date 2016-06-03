package com.datadriver.web.system.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.datadriver.core.entity.UnitedException;
import com.datadriver.web.common.enums.FinalParamer;
import com.datadriver.web.common.enums.ResultEnum;
import com.datadriver.web.common.enums.SessionAttribute;
import com.datadriver.web.system.model.SystemPermissionAction;
import com.datadriver.web.system.model.SystemUser;
import com.datadriver.web.system.service.SystemPermissionActionService;

/**
 * 公共视图控制器
 **/
@Controller
public class CommonController {
	
	@Resource
	private SystemPermissionActionService	systemPermissionActionService;
	
	/**
	 * 首页
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("index")
	public String index(HttpServletRequest request, Model model) {
		try {
			// 菜单数据
			SystemUser currentUser = (SystemUser) request.getSession().getAttribute(SessionAttribute.USERINFO);
			if (currentUser == null || ("").equals(currentUser.getUserId())) {
				return "redirect:/index.html";
			}
			String userIdString = currentUser.getUserId();
			final List<SystemPermissionAction> menuList = systemPermissionActionService.selectMenuByUserId(userIdString);
			model.addAttribute("userMenuList", menuList);
			model.addAttribute(FinalParamer.RESULT, ResultEnum.SUCCESS.getValue());
		} catch (UnitedException e) {
			model.addAttribute(FinalParamer.MESSAGE, e.loadErrorMessageByCode(request));
			model.addAttribute(FinalParamer.RESULT, ResultEnum.FAIL.getValue());
		}
		return "/main/index";
	}
}
package com.datadriver.web.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 视图控制器,返回jsp视图给前端
 **/
@Controller
@RequestMapping("/page")
public class PageController {
	
	/**
	 * 登录页
	 */
	@RequestMapping("/login")
	public String login(Model model, @RequestParam(value = "langType", defaultValue = "zh") String langType) {
		model.addAttribute("langType", langType);
		return "/system/login";
	}
	
	/**
	 * dashboard页
	 */
	@RequestMapping("/dashboard")
	public String dashboard() {
		return "/main/dashboard";
	}
	
	/**
	 * 404页
	 */
	@RequestMapping("/404")
	public String error404() {
		return "/error/404";
	}
	
	/**
	 * 401页
	 */
	@RequestMapping("/401")
	public String error401() {
		return "/error/401";
	}
	
	/**
	 * 500页
	 */
	@RequestMapping("/500")
	public String error500() {
		return "/error/500";
	}
	
}
package com.datadriver.web.system.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.support.RequestContext;

import com.datadriver.core.entity.UnitedException;
import com.datadriver.core.entity.UnitedLogger;
import com.datadriver.core.util.SecurityUtil;
import com.datadriver.web.common.enums.FinalParamer;
import com.datadriver.web.common.enums.SessionAttribute;
import com.datadriver.web.system.dto.LoginDto;
import com.datadriver.web.system.model.SystemUser;
import com.datadriver.web.system.service.SystemUserService;
import com.datadriver.web.system.util.LocaleUtil;

@Controller
@RequestMapping(value = "/system")
public class LoginController {
	@Resource
	private SystemUserService systemUserService;

	/**
	 * 用户登录界面
	 */
	@RequestMapping(value = "/loginPage.do", method = RequestMethod.GET)
	public String loginPage(
			Model model,
			HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value = "langType", defaultValue = "zh_CN") String langType) {
		if (!model.containsAttribute("contentModel")) {
			// 语言环境切换
			LocaleUtil.exchangeLocale(request, langType);
		}
		return "redirect:/rest/page/login?langType=" + langType;
	}

	/**
	 * 用户登录
	 */
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String login(
			Model model,
			HttpServletRequest request,
			@ModelAttribute("loginDto") LoginDto loginDto,
			@RequestParam(value = "langType", defaultValue = "zh_CN") String langType) {
		try {
			RequestContext requestContext = new RequestContext(request);// 国际化
			if (loginDto == null) {
				model.addAttribute(FinalParamer.MESSAGE,
						requestContext.getMessage("MSG.10003"));
				return "/system/login";
			}
			String loginAccount = loginDto.getLoginAccount();
			String loginPw = loginDto.getLoginPw();
			// 解密处理
			loginAccount = SecurityUtil.base64MultiDecrypt(loginAccount);
			Subject subject = SecurityUtils.getSubject();
			// 已登陆则 跳到首页
			// if (subject.isAuthenticated()) {
			// return "redirect:/rest/index";
			// }
			// 验证成功在Session中保存用户信息
			final SystemUser authUserInfo = systemUserService
					.selectByUserNameAndPw(loginAccount, loginPw);
			request.getSession().setAttribute(SessionAttribute.USERINFO,
					authUserInfo);
			if (authUserInfo == null) {
				model.addAttribute(FinalParamer.MESSAGE,
						requestContext.getMessage("MSG.10003"));
				return "/system/login";
			} else if("1".equals(authUserInfo.getIsLeave())) {
				model.addAttribute(FinalParamer.MESSAGE,
						requestContext.getMessage("MSG.10005"));
				return "/system/login";
			} else if("1".equals(authUserInfo.getUserStatus())) {
				model.addAttribute(FinalParamer.MESSAGE,
						requestContext.getMessage("MSG.10004"));
				return "/system/login";
			}
			// Shiro身份验证
			subject.login(new UsernamePasswordToken(loginAccount, loginPw));
			// 语言环境切换
			LocaleUtil.exchangeLocale(request, langType);

		} catch (AuthenticationException e) {
			// 身份验证失败
			UnitedLogger.error(e);
			model.addAttribute(FinalParamer.MESSAGE, e.getMessage());
			return "/system/login";
		} catch (UnitedException e) {
			UnitedLogger.error(e);
			model.addAttribute(FinalParamer.MESSAGE,
					e.loadErrorMessageByCode(request));
			return "/system/login";
		} catch (Exception e) {
			UnitedLogger.error(e);
			model.addAttribute(FinalParamer.MESSAGE, e.getMessage());
			return "/system/login";
		}
		return "redirect:/rest/index";
	}

	/**
	 * 用户登出
	 */
	@RequestMapping(value = "/logout.do", method = RequestMethod.GET)
	public String logout(
			@RequestParam(value = "langType", defaultValue = "zh_CN") String langType,
			HttpSession session) {
		session.removeAttribute(SessionAttribute.USERINFO);
		// 登出操作
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		return "redirect:/rest/system/loginPage.do?langType=" + langType;
	}
}

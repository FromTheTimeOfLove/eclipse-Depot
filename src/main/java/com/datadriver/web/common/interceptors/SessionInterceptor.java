package com.datadriver.web.common.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.datadriver.web.common.enums.SessionAttribute;

public class SessionInterceptor extends HandlerInterceptorAdapter {
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		Object obj = request.getSession().getAttribute(SessionAttribute.USERINFO);
		if (null == obj) { // 未登录
			if (request.getHeader("x-requested-with") != null && request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")) { // 如果是ajax请求响应头会有，x-requested-with
				response.setHeader("sessionstatus", "timeout");// 在响应头设置session状态
			} else {
				response.sendRedirect(request.getContextPath() + "/index.html");
			}
			return false;
		}
		return super.preHandle(request, response, handler);
	}
}

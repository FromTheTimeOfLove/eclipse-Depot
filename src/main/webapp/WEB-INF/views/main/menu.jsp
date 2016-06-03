<%@page import="org.springframework.web.servlet.support.RequestContext"%>
<%@page import="com.datadriver.web.system.model.SystemPermissionAction"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix='fmt'%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	List<SystemPermissionAction> menuList = (List<SystemPermissionAction>) request.getAttribute("userMenuList");
	RequestContext requestContext = new RequestContext(request);// 国际化
	String htmlString = "";
	int level = 0;
	int tempLevel = 0;
	int diffLevel = 0;
	String parentId = null;
	String _menuPin = "";
	int i = 0;
	if (menuList.size() > 0) {
		level = menuList.get(0).getActionPin().length() / 2;
	}
	SystemPermissionAction menu = null;
	String indexURL = null;
	int dataIndex = 1;
	for (int j = 0; j < menuList.size(); j++) {
		menu = menuList.get(j);
		indexURL = menu.getActionUrl();
		parentId = menu.getActionParentId();// 菜单的父ID
		tempLevel = menu.getActionPin().length() / 2;// 多少层级
		diffLevel = tempLevel - level;// 层级差异
		_menuPin = menu.getActionPin();
		// 非根节点
		if ("0".equals(parentId.trim())) {// 根节点
			if (j != 0) {
				for (i = 0; i < Math.abs(diffLevel); i++) {
					// 生成层级的</li>
					htmlString += "</li></ul></li>";
				}
			}
			level = menu.getActionPin().length() / 2;
			htmlString += "<li class=\"nav-item \">";
			htmlString += "<a href=\"" + menu.getActionUrl() + "\" class=\"nav-link ajaxify ";
			if (indexURL != null && !("").equals(indexURL.trim()) && !("javascript:;").equals(indexURL.trim())) {
				htmlString += "J_menuItem";
			}
			htmlString += "\" data-index=\"" + _menuPin + "\">";
			htmlString += "<i class=\"" + menu.getActionIcon() + "\">";
			htmlString += "</i>";
			htmlString += "<span class=\"title\">";
			htmlString += requestContext.getMessage("MENU." + menu.getActionId());
			htmlString += "</span>";
			htmlString += "<span class=\"arrow\">";
			htmlString += "</span>";
			htmlString += "<span class=\"selected\">";
			htmlString += "</span>";
			htmlString += "</a>";
			continue;// 根节点，直接到下一次循环
		}
		if (diffLevel > 0) {// 大于当前的深度的是子菜单
			// 开始新的子层级
			htmlString += "<ul class=\"sub-menu\">";
			htmlString += "<li class=\"nav-item \">";
			htmlString += "<a href=\"" + menu.getActionUrl() + "\" class=\"nav-link ajaxify ";
			if (indexURL != null && !("").equals(indexURL.trim()) && !("javascript:;").equals(indexURL.trim())) {
				htmlString += "J_menuItem";
			}
			htmlString += "\" data-index=\"" + _menuPin + "\">";
			htmlString += "<i class=\"" + menu.getActionIcon() + "\">";
			htmlString += "</i>";
			htmlString += "<span class=\"title\">";
			htmlString += requestContext.getMessage("MENU." + menu.getActionId());
			htmlString += "</span>";
			htmlString += "<span class=\"arrow\">";
			htmlString += "</span>";
			htmlString += "</a>";
		} else if (diffLevel == 0) {// 同级的菜单
			htmlString += "</li>";
			htmlString += "<li class=\"nav-item \" >";
			htmlString += "<a href=\"" + menu.getActionUrl() + "\" class=\"nav-link ajaxify ";
			if (indexURL != null && !("").equals(indexURL.trim()) && !("javascript:;").equals(indexURL.trim())) {
				htmlString += "J_menuItem";
			}
			htmlString += "\" data-index=\"" + _menuPin + "\">";
			htmlString += "<i class=\"" + menu.getActionIcon() + "\">";
			htmlString += "</i>";
			htmlString += "<span class=\"title\">";
			htmlString += requestContext.getMessage("MENU." + menu.getActionId());
			htmlString += "</span>";
			htmlString += "<span class=\"arrow\">";
			htmlString += "</span>";
			htmlString += "</a>";
		} else if (diffLevel < 0) {// 父级同级别的
			// 计算相差的级别
			for (i = 0; i < Math.abs(diffLevel); i++) {
				// 生成层级的</li>
				htmlString += "</li></ul></li>";
			}
			htmlString += "<li class=\"nav-item\">";
			htmlString += "<a href=\"" + menu.getActionUrl() + "\" class=\"nav-link ajaxify ";
			if (indexURL != null && !("").equals(indexURL.trim()) && !("javascript:;").equals(indexURL.trim())) {
				htmlString += "J_menuItem";
			}
			htmlString += "\" data-index=\"" + _menuPin + "\">";
			htmlString += "<i class=\"" + menu.getActionIcon() + "\">";
			htmlString += "</i>";
			htmlString += "<span class=\"title\">";
			htmlString += requestContext.getMessage("MENU." + menu.getActionId());
			htmlString += "</span>";
			htmlString += "<span class=\"arrow\">";
			htmlString += "</span>";
			htmlString += "</a>";
		}
		if (j == (menuList.size() - 1)) {
			for (i = 0; i < Math.abs(diffLevel); i++) {
				// 生成层级的</li>
				htmlString += "</li></ul></li>";
			}
		}
		level = tempLevel;
	}
	dataIndex = 1;
%>
<%=htmlString%>

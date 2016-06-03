<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<!--[if IE 8]>
 <html lang="en" class="ie8 no-js">
<![endif]-->
<!--[if IE 9]>
 <html lang="en" class="ie9 no-js">
<![endif]-->
<!--[if !IE]><!-->
<html lang="en">
<!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
<title>
	<fmt:message key="PAGE.INDEX.TITLE" />
</title>
<jsp:include page="../decorate/indexHead.jsp"></jsp:include>
</head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<body class="page-header-fixed page-sidebar-closed-hide-logo page-container-bg-solid" style="overflow: hidden">
	<!-- HIDDEN GLOBAL -->
	<input type="hidden" id="global_langType" value="${sessionScope.APP_LOCALE}">
	<input type="hidden" id="global_rooturl" value="<%=basePath%>">
	<!-- BEGIN HEADER -->
	<div class="page-header navbar navbar-fixed-top">
		<div class="page-header-inner ">
			<!-- BEGIN LOGO -->
			<div class="page-logo">
				<a href="rest/index">
					<img src="static/main/img/logo-default.png" alt="logo" class="logo-default" />
				</a>
				<div class="menu-toggler sidebar-toggler"></div>
			</div>
			<!-- BEGIN RESPONSIVE MENU TOGGLER -->
			<a href="javascript:;" class="menu-toggler responsive-toggler" data-toggle="collapse" data-target=".navbar-collapse"> </a>
			<!-- END RESPONSIVE MENU TOGGLER -->
			<!-- BEGIN PAGE ACTIONS -->
			<!-- DOC: Remove "hide" class to enable the page header actions -->
			<!-- END PAGE ACTIONS -->
			<!-- BEGIN PAGE TOP -->
			<div class="page-top">
				<div class="top-menu">
					<ul class="nav navbar-nav pull-right">
						<li class="dropdown dropdown-extended dropdown-inbox" id="header_inbox_bar">
							<a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-close-others="true">
								<i class="fa fa-language fa-lg"> </i>
							</a>
							<ul class="dropdown-menu dropdown-menu-default">
								<li>
									<a href="rest/localeLanguage/langType?langType=zh_CN">
										<img src="assets/global/img/flags/cn.png" />&nbsp;中文简体
										<c:if test="${sessionScope.APP_LOCALE=='zh_CN'}">
											<span class="badge">
												<i class="fa fa-check"> </i>
											</span>
										</c:if>
									</a>
								</li>
								<li>
									<a href="rest/localeLanguage/langType?langType=en">
										<img src="assets/global/img/flags/us.png" />&nbsp;English
										<c:if test="${sessionScope.APP_LOCALE=='en'}">
											<span class="badge">
												<i class="fa fa-check"> </i>
											</span>
										</c:if>
									</a>
								</li>
							</ul>
						</li>
						<li class="dropdown dropdown-user">
							<a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-close-others="true">
								<img alt="" class="img-circle" src="static/common/img/avatar.png" />
								<span class="username username-hide-on-mobile"> ${sessionScope.APP_USERS.userName} </span>
								<i class="fa fa-angle-down"> </i>
							</a>
							<ul class="dropdown-menu dropdown-menu-default">
								<li>
									<a href="javascript:void(0);" onclick="User.initPasswordById(${sessionScope.APP_USERS.userId});">
										<i class="fa fa-lock"> </i>
										<fmt:message key="PAGE.INDEX.ALTERPWD" />
									</a>
								</li>
								<li>
									<a href="rest/system/logout.do?langType=${sessionScope.APP_LOCALE}">
										<i class="fa fa-sign-out"> </i>
										<fmt:message key="PAGE.INDEX.LOGINOUT" />
									</a>
								</li>
							</ul>
						</li>
					</ul>
				</div>
			</div>
			<!-- END PAGE TOP -->
		</div>
		<!-- END HEADER INNER -->
	</div>
	<!-- END HEADER -->
	<!-- BEGIN HEADER & CONTENT DIVIDER -->
	<div class="clearfix"></div>
	<!-- END HEADER & CONTENT DIVIDER -->
	<!-- BEGIN CONTAINER -->
	<div class="page-container">
		<!-- BEGIN SIDEBAR -->
		<div class="page-sidebar-wrapper">
			<div class="page-sidebar navbar-collapse collapse">
				<!-- BEGIN SIDEBAR MENU -->
				<ul class="page-sidebar-menu  page-header-fixed" id="page-sidebar-menu" data-keep-expanded="true" data-auto-scroll="true" data-slide-speed="200">
					<li class="start active open">
						<a href="rest/page/dashboard" id="btn-dashboard" class="J_menuItem" data-index="0">
							<i class="fa fa-home"></i>
							<span class="title">
								<fmt:message key="MENU.0" />
							</span>
							<span class="selected"> </span>
						</a>
					</li>
					<jsp:include page="./menu.jsp" />
				</ul>
			</div>
		</div>
		<!-- BEGIN CONTENT -->
		<div class="page-content-wrapper">
			<div id="page-wrapper" class="page-content">
				<!-- BEGIN THEME PANEL -->
				<div class="content-tabs">
					<button class="roll-nav roll-left J_tabLeft">
						<i class="fa fa-backward"></i>
					</button>
					<nav class="page-tabs J_menuTabs">
						<div class="page-tabs-content" style="margin-left: 0px;">
							<a href="javascript:;" class="J_menuTab active" data-id="rest/page/dashboard">
								<fmt:message key="MENU.0" />
							</a>
						</div>
					</nav>
					<button class="roll-nav roll-right J_tabRight">
						<i class="fa fa-forward"></i>
					</button>
					<div class="btn-group roll-nav roll-right">
						<button class="dropdown J_tabClose" data-toggle="dropdown" aria-expanded="false"><fmt:message key="PAGE.CONTENT.TABS.CLOSE" /></button>
						<ul role="menu" class="dropdown-menu">
							<%-- <li class="J_tabShowActive">
								<a><fmt:message key="PAGE.CONTENT.TABS.CLOSE.ACTIVE" /></a>
							</li>
							<li class="divider"></li>
							 --%>
							<li class="J_tabCloseAll">
								<a><fmt:message key="PAGE.CONTENT.TABS.CLOSE.ALL" /></a>
							</li>
							<li class="J_tabCloseOther">
								<a><fmt:message key="PAGE.CONTENT.TABS.CLOSE.OTHERS" /></a>
							</li>
						</ul>
					</div>
					<a href="javascript:;" id="theme_set" class="roll-nav roll-right J_tabExit" data-container="body" data-placement="left" data-html="true"
						data-original-title="<fmt:message key="PAGE.THEME.SET.TOOLTIP" />"
					>
						<i class="fa fa-gear"></i>
						<fmt:message key="PAGE.THEME" />
					</a>
					<div class="theme-panel hidden-xs hidden-sm">
						<div class="toggler-close">
						</div>
						<div class="theme-options">
							<div class="theme-option theme-colors clearfix">
								<span>
									<fmt:message key="PAGE.THEME.COLOR" />
								</span>
								<ul>
									<li class="color-default current tooltips" data-style="default" data-container="body" data-original-title="<fmt:message key="PAGE.THEME.COLOR.DEFAULT" />"></li>
									<li class="color-grey tooltips" data-style="grey" data-container="body" data-original-title="<fmt:message key="PAGE.THEME.COLOR.GREY" />"></li>
									<li class="color-blue tooltips" data-style="blue" data-container="body" data-original-title="<fmt:message key="PAGE.THEME.COLOR.BLUE" />"></li>
									<li class="color-dark tooltips" data-style="darkblue" data-container="body" data-original-title="<fmt:message key="PAGE.THEME.COLOR.DARK" />"></li>
									<li class="color-light tooltips" data-style="light" data-container="body" data-original-title="<fmt:message key="PAGE.THEME.COLOR.LIGHT" />"></li>
								</ul>
							</div>
							<div class="theme-option">
								<span>
									<fmt:message key="PAGE.THEME.LAYOUT" />
								</span>
								<select class="layout-option form-control input-small">
									<option value="fluid" selected="selected"><fmt:message key="PAGE.THEME.LAYOUT.FLUID" /></option>
									<option value="boxed"><fmt:message key="PAGE.THEME.LAYOUT.BOXED" /></option>
								</select>
							</div>
							<div class="theme-option">
								<span>
									<fmt:message key="PAGE.THEME.SIDEBAR.MODE" />
								</span>
								<select class="sidebar-option form-control input-small">
									<option value="fixed"><fmt:message key="PAGE.THEME.SIDEBAR.MODE.FIXED" /></option>
									<option value="default" selected="selected"><fmt:message key="PAGE.THEME.SIDEBAR.MODE.DEFAULT" /></option>
								</select>
							</div>
							<div class="theme-option">
								<span>
									<fmt:message key="PAGE.THEME.SIDEBAR.STYLE" />
								</span>
								<select class="sidebar-style-option form-control input-small">
									<option value="default" selected="selected"><fmt:message key="PAGE.THEME.SIDEBAR.STYLE.DEFAULT" /></option>
									<option value="compact"><fmt:message key="PAGE.THEME.SIDEBAR.STYLE.COMPACT" /></option>
								</select>
							</div>
							<div class="theme-option">
								<span>
									<fmt:message key="PAGE.THEME.SIDEBAR.MENU" />
								</span>
								<select class="sidebar-menu-option form-control input-small">
									<option value="accordion" selected="selected"><fmt:message key="PAGE.THEME.SIDEBAR.MENU.ACCORDION" /></option>
									<option value="hover"><fmt:message key="PAGE.THEME.SIDEBAR.MENU.HOVER" /></option>
								</select>
							</div>
							<div class="theme-option">
								<span>
									<fmt:message key="PAGE.THEME.SIDEBAR.POSITION" />
								</span>
								<select class="sidebar-pos-option form-control input-small">
									<option value="left" selected="selected"><fmt:message key="PAGE.THEME.SIDEBAR.POSITION.LEFT" /></option>
									<option value="right"><fmt:message key="PAGE.THEME.SIDEBAR.POSITION.RIGHT" /></option>
								</select>
							</div>
						</div>
					</div>
				</div>
				<!-- END THEME PANEL -->
				<div id="content-main" class="J_mainContent">
					<iframe class="J_iframe" name="iframe0" width="100%" height="100%" src="rest/page/dashboard" frameborder="0" data-id="rest/page/dashboard" seamless=""></iframe>
				</div>
			</div>
		</div>
	</div>
	<!-- END CONTAINER -->
	<!-- BEGIN FOOTER -->
	<div class="page-footer">
		<div class="page-footer-inner">2015 &copy;DataDriver</div>
		<div class="scroll-to-top" style="font-size: 16px; background-color: #F2F2F2;">
			<span class="fa fa-arrow-up"> </span>
		</div>
	</div>
	<jsp:include page="../decorate/indexFoot.jsp"></jsp:include>
</body>
</html>

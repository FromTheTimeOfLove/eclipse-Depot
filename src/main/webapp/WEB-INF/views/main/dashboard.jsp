<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false"%>
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
<jsp:include page="../decorate/contentHead.jsp"></jsp:include>
</head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<body>
	<h3 class="page-title">
		<fmt:message key="PAGE.DASHBOARD.TITLE" />
		<small> <fmt:message key="PAGE.DASHBOARD.TITLE.SMALL" />
		</small>
	</h3>
	<div class="row">
		<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
			<div class="dashboard-stat blue">
				<div class="visual">
					<i class="fa fa-comments"></i>
				</div>
				<div class="details">
					<div class="number">13</div>
				</div>
				<a class="more" href="#">
					one paper
					<i class="m-icon-swapright m-icon-white"> </i>
				</a>
			</div>
		</div>
		<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
			<div class="dashboard-stat green">
				<div class="visual">
					<i class="fa fa-shopping-cart"> </i>
				</div>
				<div class="details">
					<div class="number">13</div>
				</div>
				<a class="more" href="#">
					TS Signed
					<i class="m-icon-swapright m-icon-white"> </i>
				</a>
			</div>
		</div>
		<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
			<div class="dashboard-stat purple">
				<div class="visual">
					<i class="fa fa-globe"> </i>
				</div>
				<div class="details">
					<div class="number">89</div>
				</div>
				<a class="more" href="#">
					Basic Info
					<i class="m-icon-swapright m-icon-white"> </i>
				</a>
			</div>
		</div>
		<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
			<div class="dashboard-stat yellow">
				<div class="visual">
					<i class="fa fa-bar-chart-o"> </i>
				</div>
				<div class="details">
					<div class="number">12</div>
				</div>
				<a class="more" href="#">
					Funds
					<i class="m-icon-swapright m-icon-white"> </i>
				</a>
			</div>
		</div>
	</div>
	<!-- 测试权限控制 -->
<!-- 	<shiro:hasAnyRoles name="super_admin"> -->
<!-- 		<span> super_admin角色 </span> -->
<!-- 	</shiro:hasAnyRoles> -->
	<!-- 资源权限控制 -->
<!-- 	<shiro:hasPermission name="BT.PROJECT.ADD"> -->
<!-- 		<button type="button" class="btn btn-primary">新增</button> -->
<!-- 	</shiro:hasPermission> -->
<!-- 	<shiro:hasPermission name="BT.PROJECT.DELETE"> -->
<!-- 		<button type="button" class="btn ben-danger">删除</button> -->
<!-- 	</shiro:hasPermission> -->
	<jsp:include page="../decorate/contentFoot.jsp"></jsp:include>
</body>
</html>

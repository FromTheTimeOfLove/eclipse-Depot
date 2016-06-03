<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix='fmt'%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en">
<!--<![endif]-->
<head>
<meta charset="utf-8" />
<title>
	<fmt:message key="PAGE.INDEX.TITLE" />
</title>
<base href="<%=basePath%>">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta content="width=device-width, initial-scale=1" name="viewport" />
<meta content="" name="description" />
<meta content="" name="author" />
<!-- BEGIN GLOBAL MANDATORY STYLES -->
<link href="assets/global/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
<link href="assets/global/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="assets/global/plugins/uniform/css/uniform.default.css" rel="stylesheet" type="text/css" />
<!-- END GLOBAL MANDATORY STYLES -->
<!-- BEGIN THEME GLOBAL STYLES -->
<link href="assets/global/css/components.min.css" rel="stylesheet" id="style_components" type="text/css" />
<link href="assets/global/css/plugins.min.css" rel="stylesheet" type="text/css" />
<!-- END THEME GLOBAL STYLES -->
<!-- BEGIN PAGE LEVEL STYLES -->
<!--[if gt IE 9]>
<link href="static/common/css/dd.fontface.css" rel="stylesheet" type="text/css" />
<!--<![endif]-->
<link href="static/common/css/dd.table.css" rel="stylesheet" type="text/css" />
<link href="static/common/css/dd.form.css" rel="stylesheet" type="text/css" />
<link href="static/common/css/dd.jquery.validate.css" rel="stylesheet" type="text/css" />
<link href="static/system/css/login.min.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="assets/global/scripts/select2/dist/css/select2.css" type="text/css"></link>
<!-- END PAGE LEVEL STYLES -->
<style>
body, h1, h2, h3, h4, h5, h6, p, span {
	font-family: "San Francisco Medium", "Open Sans", sans-serif
}
</style>
</head>
<!-- END HEAD -->
<body class=" login">
	<!-- HIDDEN GLOBAL -->
	<input type="hidden" id="global_langType" value="${sessionScope.APP_LOCALE}">
	<input type="hidden" id="global_rooturl" value="<%=basePath%>">
	<!-- BEGIN LOGO -->
	<div class="logo">
		<a href="index.html">
			<img src="static/common/img/logo/logo-big.png" alt="DataDriver" />
		</a>
	</div>
	<!-- END LOGO -->
	<!-- BEGIN LOGIN -->
	<div class="content">
		<!-- BEGIN LOGIN FORM -->
		<form id="login-a-form" action="rest/system/login.do" method="post">
			<input type="hidden" name="loginAccount" id="loginAccountHidden" />
			<input type="hidden" name="loginPw" id="loginPwHidden" />
		</form>
		<form class="login-form">
			<h3 class="form-title">
				<fmt:message key="PAGE.LOGIN.TITLE" />
			</h3>
			<div class="alert alert-danger display-hide">
				<button class="close" data-close="alert"></button>
				<span> Enter any username and password. </span>
			</div>
			<div class="form-group">
				<!--ie8, ie9 does not support html5 placeholder, so we just show field title for that-->
				<label class="control-label visible-ie8 visible-ie9">
					<fmt:message key="PAGE.LOGIN.USERNAME" />
				</label>
				<div class="input-icon">
					<i class="fa fa-user"> </i>
					<input id="loginAccount" name="loginName" class="form-control placeholder-no-fix" type="text" autocomplete="off" placeholder="<fmt:message key='PAGE.LOGIN.USERNAME' />" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label visible-ie8 visible-ie9">
					<fmt:message key="PAGE.LOGIN.PASSWORD" />
				</label>
				<div class="input-icon">
					<i class="fa fa-lock"> </i>
					<input id="loginPw" name="loginPassword" class="form-control placeholder-no-fix" type="password" autocomplete="off" placeholder="<fmt:message key='PAGE.LOGIN.PASSWORD' />" />
				</div>
			</div>
			<div class="form-actions">
				<button type="button" class="btn btn-primary pull-right" id="submitLoginBt">
					<fmt:message key="PAGE.LOGIN.BT" />
				</button>
			</div>
			<div class="form-actions">
				<c:if test="${message!=null && message!=''}">
					<div class="alert-danger" style="padding: 5px;">${message}</div>
				</c:if>
			</div>
			<div class="login-options">
				<h4>
					<fmt:message key="PAGE.LANGUAGE" />
				</h4>
				<select id="languageSelect" name="langType" class="js-example-placeholder-single form-control">
					<option value="zh_CN" <c:if test="${langType=='zh_CN'}">selected</c:if>>中文简体</option>
					<option value="en" <c:if test="${langType=='en'}">selected</c:if>>English</option>
				</select>
			</div>
		</form>
		<!-- END LOGIN FORM -->
	</div>
	<!-- END LOGIN -->
	<!-- BEGIN COPYRIGHT -->
	<div class="copyright">2016 &copy; DataDriver</div>
	<!-- END COPYRIGHT -->
	<!--[if lt IE 9]>
	<script src="static/common/plugins/html5shiv.min.js"></script>
	<script src="assets/global/plugins/respond.min.js"></script>
	<script src="assets/global/plugins/excanvas.min.js"></script>
	<![endif]-->
	<!-- BEGIN CORE PLUGINS -->
	<script src="assets/global/plugins/jquery.min.js" type="text/javascript"></script>
	<script src="assets/global/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
	<script src="assets/global/plugins/js.cookie.min.js" type="text/javascript"></script>
	<script src="assets/global/plugins/uniform/jquery.uniform.min.js" type="text/javascript"></script>
	<script src="assets/global/plugins/jquery.blockui.min.js" type="text/javascript"></script>
	<script src="static/common/plugins/jquery.i18next.min.js" type="text/javascript"></script>
	<!-- END CORE PLUGINS -->
	<!-- BEGIN PAGE LEVEL PLUGINS -->
	<script src="assets/global/plugins/jquery-validation/js/jquery.validate.min.js" type="text/javascript"></script>
	<script src="assets/global/plugins/backstretch/jquery.backstretch.min.js" type="text/javascript"></script>
	<!-- END PAGE LEVEL PLUGINS -->
	<!-- BEGIN CRYPTO SCRIPTS -->
	<script src="static/common/plugins/crypto-js/crypto-js.js" type="text/javascript"></script>
	<!-- END CRYPTO SCRIPTS -->
	<!-- BEGIN PAGE GLOBAL SCRIPTS -->
	<script src="assets/global/scripts/app.min.js" type="text/javascript"></script>
	<script src="static/common/scripts/base64.js" type="text/javascript"></script>
	<script src="static/common/scripts/common.js" type="text/javascript"></script>
	<script src="static/common/scripts/utils.js" type="text/javascript"></script>
	<script src="static/system/scripts/login.js" type="text/javascript"></script>
	<script type="text/javascript" src="assets/global/scripts/select2/dist/js/select2.js"></script>
	<script type="text/javascript">
		$(".js-example-placeholder-single").select2();
	</script>
	<!-- END PAGE LEVEL SCRIPTS -->
</body>
</html>

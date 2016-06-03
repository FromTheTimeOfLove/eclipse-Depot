<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix='fmt'%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en" class="no-js">
<!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
<base href="<%=basePath%>">
<meta charset="utf-8" />
<title>
	<fmt:message key="PAGE.404.TITLE" />
</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta content="width=device-width, initial-scale=1" name="viewport" />
<meta content="" name="description" />
<meta content="" name="author" />
<!-- BEGIN GLOBAL MANDATORY STYLES -->
<link href="assets/global/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
<link href="assets/global/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<!-- END GLOBAL MANDATORY STYLES -->
<!-- BEGIN THEME GLOBAL STYLES -->
<link href="assets/global/css/components.min.css" rel="stylesheet" id="style_components" type="text/css" />
<link href="assets/global/css/plugins.min.css" rel="stylesheet" type="text/css" />
<!-- END THEME GLOBAL STYLES -->
<!-- BEGIN PAGE LEVEL STYLES -->
<link href="static/error/css/error.min.css" rel="stylesheet" type="text/css" />
<!-- END PAGE LEVEL STYLES -->
<!-- BEGIN THEME LAYOUT STYLES -->
<!-- END THEME LAYOUT STYLES -->
<!--<link rel="shortcut icon" href="favicon.ico" />-->
</head>
<!-- END HEAD -->
<body class=" page-404-full-page">
	<div class="row">
		<div class="col-md-12 page-404">
			<div class="number font-red">404</div>
			<div class="details">
				<h3>
					<fmt:message key="PAGE.404.DETAIL" />
				</h3>
				<p>
					<fmt:message key="PAGE.404.RETURN.H" />
					<br />
					<a href="<%=basePath%>rest/index">
						<fmt:message key="PAGE.404.RETURN.M" />
					</a>
				</p>
			</div>
		</div>
	</div>
	<!--[if lt IE 9]>
		<script src="static/common/plugins/html5shiv.min.js"></script>
		<script src="assets/global/plugins/respond.min.js"></script>
		<script src="assets/global/plugins/excanvas.min.js"></script>
		<![endif]-->
	<!-- BEGIN CORE PLUGINS -->
	<script src="assets/global/plugins/jquery.min.js" type="text/javascript"></script>
	<script src="assets/global/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
	<!-- END CORE PLUGINS -->
	<!-- BEGIN THEME GLOBAL SCRIPTS -->
	<script src="assets/global/scripts/app.min.js" type="text/javascript"></script>
	<!-- END THEME LAYOUT SCRIPTS -->
</body>
<!-- END BODY -->
</html>

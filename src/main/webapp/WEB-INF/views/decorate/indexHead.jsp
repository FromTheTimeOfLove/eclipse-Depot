<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
<%
	String path = request.getContextPath();
	String headerReferer = request.getHeader("Referer");
	String basePath = headerReferer.substring(0, headerReferer.indexOf(path) + path.length() + 1);
%>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta content="width=device-width, initial-scale=1" name="viewport" />
<meta content="" name="description" />
<meta content="DataDriver" name="author" />
<base href="<%=basePath%>" />
<!-- BEGIN GLOBAL MANDATORY STYLES -->
<link href="assets/global/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
<link href="assets/global/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<!-- END GLOBAL MANDATORY STYLES -->
<!-- BEGIN PAGE LEVEL PLUGINS -->
<link href="assets/global/plugins/datatables/plugins/bootstrap/datatables.bootstrap.css" rel="stylesheet" type="text/css" />
<link href="assets/global/plugins/bootstrap-datetimepicker/css/bootstrap-datetimepicker.min.css" rel="stylesheet" type="text/css" />
<link href="static/common/plugins/jquery-showLoading/jquery-showLoading.css" rel="stylesheet" type="text/css" />
<!-- END PAGE LEVEL PLUGINS -->
<!-- BEGIN THEME GLOBAL STYLES -->
<link href="assets/global/css/components.min.css" rel="stylesheet" id="style_components" type="text/css" />
<link href="assets/global/css/plugins.min.css" rel="stylesheet" type="text/css" />
<!-- END THEME GLOBAL STYLES -->
<!-- BEGIN THEME LAYOUT STYLES -->
<link href="assets/layouts/layout/css/layout.min.css" rel="stylesheet" type="text/css" />
<link href="assets/layouts/layout/css/themes/darkblue.min.css" rel="stylesheet" type="text/css" id="style_color" />
<link href="assets/layouts/layout/css/custom.min.css" rel="stylesheet" type="text/css" />
<!-- END THEME LAYOUT STYLES -->
<!-- BEGIN DD STYLES -->
<!--[if gt IE 9]>
<link href="static/common/css/dd.fontface.css" rel="stylesheet" type="text/css" />
<!--<![endif]-->
<link href="static/common/css/dd.common.css" rel="stylesheet" type="text/css" />
<link href="static/common/css/dd.table.css" rel="stylesheet" type="text/css" />
<link href="static/common/css/dd.form.css" rel="stylesheet" type="text/css" />
<link href="static/common/css/dd.jquery.validate.css" rel="stylesheet" type="text/css" />
<!-- END DD STYLES -->
<!-- <link rel="shortcut icon" href="favicon.ico" />-->
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
<%
	String path = request.getContextPath();
	String headerReferer = request.getHeader("Referer");
	String basePath = headerReferer.substring(0, headerReferer.indexOf(path) + path.length() + 1);
	response.setHeader("Pragma","No-cache");
	response.setHeader("Cache-Control","no-cache");
	response.setDateHeader("Expires", -10);
%>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta content="width=device-width, initial-scale=1" name="viewport" />
<meta content="" name="description" />
<meta content="" name="author" />
<base href="<%=basePath%>" />
<!-- BEGIN GLOBAL MANDATORY STYLES -->
<link href="assets/global/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
<link href="assets/global/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<!-- END GLOBAL MANDATORY STYLES -->
<!-- BEGIN PAGE LEVEL PLUGINS -->
<link href="assets/global/plugins/datatables/plugins/bootstrap/datatables.bootstrap.css" rel="stylesheet" type="text/css" />
<link href="static/common/plugins/bootstrap-table-master/dist/bootstrap-table.css"	rel="stylesheet">
<link href="assets/global/plugins/bootstrap-datetimepicker/css/bootstrap-datetimepicker.min.css" rel="stylesheet" type="text/css" />
<link href="static/common/plugins/jquery-showLoading/jquery-showLoading.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="assets/global/plugins/bootstrap-datepicker/css/bootstrap-datepicker3.min.css" type="text/css"></link>
<link href="assets/global/plugins/bootstrap-switch/css/bootstrap-switch.min.css" rel="stylesheet"type="text/css" >

<!-- END PAGE LEVEL PLUGINS -->
<link href="assets/global/css/components.min.css" rel="stylesheet" type="text/css" />
<!-- BEGIN DD STYLES -->
<!--[if gt IE 9]>
<link href="static/common/css/dd.fontface.css" rel="stylesheet" type="text/css" />
<!--<![endif]-->
<link href="static/common/css/dd.common.css" rel="stylesheet" type="text/css" />
<link href="static/common/css/dd.table.css" rel="stylesheet" type="text/css" />
<link href="static/common/css/dd.form.css" rel="stylesheet" type="text/css" />
<link href="static/common/css/dd.jquery.validate.css" rel="stylesheet" type="text/css" />
<link href="static/common/css/dd.components.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="static/common/css/dd-style.css" type="text/css">
<!-- END DD STYLES -->
<!-- BEGIN SELECT STYLES -->
<link rel="stylesheet" href="assets/global/scripts/select2/dist/css/select2.css" type="text/css"></link>
<!-- END SELECT STYLES -->
<!-- BEGIN FILE STYLES -->
<link rel="stylesheet" href="assets/global/plugins/bootstrap-fileinput/bootstrap-fileinput.css" type="text/css"></link>
<!-- END FILE STYLES -->
<link rel="stylesheet" href="static/common/plugins/notification/dist/css/Lobibox.min.css" type="text/css"></link>

<!-- <link rel="shortcut icon" href="favicon.ico" />-->
<style>
body, html {
	margin: 0px !important;
	padding: 5px 10px 5px 10px !important;
	border: 0;
	background-color: #ffffff !important;
}

body {
	width: 99%;
	width: calc(100% - ( 10px));
	width: -moz-calc(100% - ( 10px));
	width: -webkit-calc(100% - ( 10px));
}

td img {
	cursor: pointer;
}
.fixed-table-pagination .pagination a {
	display: block;
	line-height: 0.9;
}
.fixed-table-pagination .pagination-detail .pagination-info {
	margin-left: 10px;
}
.fixed-table-pagination .pagination .page-next {
	margin-right: 10px;
}
.fixed-table-pagination .pull-left {
	margin-top:4px;
}
.fixed-table-pagination .pull-left .page-list .btn {
	padding: 1px 5px 1px 12px;
}
.row-details {
  margin-top: 4px;
  display: inline-block;
  cursor: pointer;
  width: 14px;
  height: 14px;
}
.row-details.row-details-close {
	background:url(assets/global/img/datatable-row-openclose.png) no-repeat 0 0;
}
.row-details.row-details-open {
	background:url(assets/global/img/datatable-row-openclose.png) 0 -23px no-repeat;
}
.lobibox-body {
	height: 100px;
}
.show-hide,.hide-show {
	display: none;
}
textarea{outline:none;resize:none;}
</style>



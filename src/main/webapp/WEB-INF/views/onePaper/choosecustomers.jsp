<%@ page language="java" import="java.util.*" pageEncoding="utf-8"
	isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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
<head>
<jsp:include page="../decorate/contentHead.jsp"></jsp:include>
<link rel="stylesheet" href="static/tsSigned/css/style.css"
	type="text/css"></link>
</head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<body>
	<div class="row">
		<div class="col-md-12">
			<div class="portlet box green">
				<div class="form-title-min-height"></div>
				<div class="portlet-body form">
					<form class="form-horizontal" id="choosecustomerListForm">
						<div class="form-body form-body-size">
							<div class="form-group">
								<label class="col-md-2 control-label">customercode</label>
								<div class="col-md-2">
									<input type="text" class="form-control"
										placeholder="" name="customercode">
								</div>
								<label class="col-md-2 control-label"> customername </label>
								<div class="col-md-2">
									<input type="text" class="form-control"
										placeholder="" name="customername">
								</div>
								<div class="col-md-1">
									<button type="button" class="btn btn-sm green"
										id="onePagerCustomersSearch">
										<fmt:message key="PAGE.GEN.SEARCH" />
									</button>
								</div>
								<div class="col-md-1">
									<button type="button" class="btn btn-sm green"
										id="onePagerCustomersSure">确定</button>
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-12">
			<div class="portlet box green">
				<div class="portlet-body form">
					<table id="choosecustomer" class="table table-striped table-bordered table-hover">
						<thead>
							<tr>
								<th>Investment amount</th>
								<th>Quantity</th>
							</tr>
						</thead>
					</table>
				</div>
			</div>
		</div>
	</div>
	<!-- END ONE PEGER LIST BODY -->
	<jsp:include page="../decorate/contentFoot.jsp"></jsp:include>
	<jsp:include page="../decorate/contentFootJS.jsp"></jsp:include>
	<script src="static/onePaper/scripts/choosecustomer.js"
		type="text/javascript"></script>
	<script type="text/javascript"
		src="static/onePaper/scripts/ajaxfileupload.js"></script>	 
</body>
</html>

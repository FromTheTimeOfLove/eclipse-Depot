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
<!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
<jsp:include page="../decorate/contentHead.jsp"></jsp:include>
</head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<body>
	<div class="row">
		<div class="col-md-12">
			<!-- BEGIN ONE PEGER HEAD WINDOW-->
			<div class="portlet box green">
				<!-- BEGIN ONE PEGER TITLE AND BUTTON -->
				<div class="form-title-min-height"></div>
				<!-- END ONE PEGER TITLE AND BUTTON -->
				<!-- BEGIN ONE PEGER QUERY CRITERIA -->
				<div class="portlet-body form">
					<form class="form-horizontal" id="deptListForm">
						<div class="form-body form-body-size">
							<div class="form-group">
								<label class="col-md-2 control-label"><fmt:message
										key="PAGE.DEPT.LIST.NAME" />
								</label>
								<div class="col-md-3">
									<input type="text" class="form-control" name="deptname"
										placeholder=""">
								</div>
								<label class="col-md-2 control-label"> <fmt:message
										key="PAGE.DEPT.LIST.LEADER" /> </label>
								<div class="col-md-3">
									<input type="text" class="form-control" name="leaderid"
										placeholder="" />
								</div>
							</div>
						</div>
						<div class="form-actions right">
							<div class="row">
								<div class="col-md-12">
									<button type="button" class="btn btn-primary" id="deptSearchBt">
										<fmt:message key="PAGE.GEN.SEARCH" />
									</button>
									<button type="reset"
										onclick="SelectUtils.resetSelectVal();"
										class="btn btn-primary green" id="deptResetBt">
										<fmt:message key="PAGE.GEN.RESET" />
									</button>
									<button type="button" class="btn btn-success J_menuItem"
										id="deptAddBt">
										<fmt:message key="PAGE.GEN.ADD" />
										<i class="fa fa-plus"> </i>
									</button>
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
				<div class="portlet-title">
					<div class="caption">
						<i class="fa  fa-table"></i>
						部门信息列表
					</div>
					<div class="tools">
						<!-- <a class="collapse" href="javascript:;" data-original-title=""
							title=""> </a> <a class="reload" href="javascript:;"
							data-original-title="" title=""> </a> -->
					</div>
				</div>
				<div class="portlet-body form">
					<table id="deptListTable"
						class="table table-striped table-bordered table-hover">
					</table>
				</div>
			</div>
		</div>
	</div>
	
	<!-- END ONE PEGER LIST BODY -->
	<jsp:include page="../decorate/contentFoot.jsp"></jsp:include>
	<jsp:include page="../decorate/contentFootJS.jsp"></jsp:include>
	<script src="static/dept/scripts/dept.js" type="text/javascript"></script>
</body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix='fmt'%>
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
<jsp:include page="../decorate/contentHead.jsp"></jsp:include>
<link href="static/basicInfo/css/base2.css" rel="stylesheet" type="text/css" />
</head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<body>
	<div class="portlet box green">
		<div class="portlet-title">
			<div class="caption">
				<i class="fa fa-table"></i>Dept
			</div>
		</div>
		<div class="portlet-body">
			<div id="DEPT_EDIT_DIV" class="form">
				<form id="DEPT_EDIT_FORM" class="form-horizontal" role="form">
				<input type="hidden" id="deptid" name="deptid" value="${dept.deptid}" />
					<div class="form-body">
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label class="control-label col-md-3">
										<fmt:message key="PAGE.DEPT.LIST.NAME" />
										<span class="required" aria-required="true"> * </span>
									</label>
									<div class="col-md-7">
										<input type="text" name="deptname" class="form-control input-sm" placeholder="" value="${dept.deptname}">
									</div>
								</div>
							</div>
							<div class="col-md-6">
									<div class="form-group">
									<label class="control-label col-md-3">
										<fmt:message key="PAGE.DEPT.LIST.LEADER" />
									</label>
									<div class="col-md-7">
										<input type="text" name="leaderid" class="form-control input-sm" placeholder="" value="${dept.leaderid}">
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label class="control-label col-md-3">
										<fmt:message key="PAGE.DEPT.LIST.DEPTLEAD" />
									</label>
									<div class="col-md-7">
											<input type="text" class="form-control input-sm" id="parentdeptname" name="parentdeptname" readonly="" placeholder="" value="${dept.parentdeptname}">
											<input type="hidden" class="form-control input-sm" id="parentdeptid" name="parentdeptid" placeholder="" value="${dept.parentdeptid}">
									</div>
									<div class="col-md-1">
										<button type="button" class="btn btn-primary" id="initpermissionbtid" onclick="Deptment.showDeptTree();">
											<fmt:message key="PAGE.DEPT.LIST.DEPTLEAD" />
										</button>
									</div>
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label class="control-label col-md-3">
										<fmt:message key="PAGE.DEPT.LIST.REMARK" />
									</label>
									<div class="col-md-7">
										<input type="text" class="form-control input-sm" name="deptremark" placeholder="" value="${dept.deptremark}">
									</div>
								</div>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<div class="portlet-body form">
		<div class="form-actions">
			<div class="row">
				<div class="col-md-12" align="center">
					<button type="button" class="btn btn-primary" id="saveDeptpBt" onclick="Deptment.saveDeptData();">
						<fmt:message key="PAGE.GEN.SAVE" />
					</button>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="../decorate/contentFoot.jsp"></jsp:include>
    <jsp:include page="../decorate/contentFootJS.jsp"></jsp:include>
	<script src="static/dept/scripts/dept.js" type="text/javascript"></script>
</body>
</html>
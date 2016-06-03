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
				<i class="fa fa-table"></i>USER
			</div>
		</div>
		<div class="portlet-body">
			<div id="ROLE_EDIT_DIV" class="form">
				<form id="ROLE_EDIT_FORM" class="form-horizontal" role="form">
					<input type="hidden" name="roleId" value="${role.roleId}" />
					<div class="form-body">
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label class="control-label col-md-3">
										<fmt:message key="PAGE.ROLE.LIST.ROLE_NAME" />
										<span class="required" aria-required="true"> * </span>
									</label>
									<div class="col-md-7">
										<input type="text" name="roleName" class="form-control input-sm" placeholder="" value="${role.roleName}">
									</div>
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label class="control-label col-md-3">
										<fmt:message key="PAGE.ROLE.LIST.ROLE_STATUS" />
									</label>
									<div class="col-md-7">
										<select class="js-example-placeholder-single form-control" name="roleStatus">
			                                <option <c:if test="${role.roleStatus==0}">selected</c:if> value="0"><fmt:message key="PAGE.ROLE.OPTD.ROLE_ENABLE" /></option>
			                                <option <c:if test="${role.roleStatus==1}">selected</c:if> value="1"><fmt:message key="PAGE.ROLE.OPTD.ROLE_DISABLE" /></option>
			                            </select>
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label class="control-label col-md-3">
										<fmt:message key="PAGE.ROLE.LIST.ROLE_GROUP" />
										<span class="required" aria-required="true"> * </span>
									</label>
									<div class="col-md-7">
										<input type="text" class="form-control input-sm" name="roleGroup" placeholder="" value="${role.roleGroup}">
									</div>
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label class="control-label col-md-3">
										<fmt:message key="PAGE.ROLE.LIST.ROLE_REMARK" />
									</label>
									<div class="col-md-7">
										<input type="text" class="form-control input-sm" name="roleRemark" placeholder="" value="${role.roleRemark}">
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
					<button type="button" class="btn btn-primary" id="saveRoleBt" onclick="Role.saveRoleData();">
						<fmt:message key="PAGE.GEN.SAVE" />
					</button>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="../decorate/contentFoot.jsp"></jsp:include>
    <jsp:include page="../decorate/contentFootJS.jsp"></jsp:include>
	<script src="static/role/scripts/role.js" type="text/javascript"></script>
</body>
</html>
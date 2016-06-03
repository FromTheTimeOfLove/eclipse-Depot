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
			<div id="PWD_EDIT_DIV" class="form dd-edit-form">
				<form id="PWD_HIDDEN_FORM">
					<input type="hidden" id="oldPasswordHidden" name="oldPassword" />
					<input type="hidden" id="newPasswordHidden" name="newPassword" />
					<input type="hidden" id="confirmPasswordHidden" name="confirmPassword" />
					<input type="hidden" name="userId" value="${user.userId}" />
				</form>
				<form id="PWD_EDIT_FORM" class="form-horizontal" role="form">
					<div class="form-body">
						<div class="row">
							<div class="col-md-12">
								<div class="form-group">
									<label class="control-label col-md-5">
										<fmt:message key="PAGE.USER.LIST.USER_OLDPASSWORD" />
										<span class="required" aria-required="true"> * </span>
									</label>
									<div class="col-md-3">
										<input type="password" id="oldPassword" name="oldPasswordV" class="form-control input-sm" placeholder="" value="">
									</div>
									<div class="col-md-1"></div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<div class="form-group">
									<label class="control-label col-md-5">
										<fmt:message key="PAGE.USER.LIST.USER_NEWPASSWORD" />
										<span class="required" aria-required="true"> * </span>
									</label>
									<div class="col-md-3">
										<input type="password" id="newPassword" name="newPasswordV" class="form-control input-sm" placeholder="" value="">
									</div>
									<div class="col-md-1"></div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<div class="form-group">
									<label class="control-label col-md-5">
										<fmt:message key="PAGE.USER.LIST.USER_CFMPASSWORD" />
										<span class="required" aria-required="true"> * </span>
									</label>
									<div class="col-md-3">
										<input type="password" id="confirmPassword" name="confirmPasswordV" class="form-control input-sm" placeholder="" value="">
									</div>
									<div class="col-md-1"></div>
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
					<button type="button" class="btn btn-primary" id="saveUserBt" onclick="User.updatePwdByUserId();">
						<fmt:message key="PAGE.GEN.SAVE" />
					</button>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="../decorate/contentFoot.jsp"></jsp:include>
    <jsp:include page="../decorate/contentFootJS.jsp"></jsp:include>
	<script src="static/user/scripts/user.js" type="text/javascript"></script>
	<script src="static/common/scripts/base64.js" type="text/javascript"></script>
	<script src="static/common/plugins/crypto-js/crypto-js.js" type="text/javascript"></script>
</body>
</html>
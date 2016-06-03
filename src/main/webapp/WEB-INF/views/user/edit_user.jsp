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
			<div id="USER_EDIT_DIV" class="form dd-edit-form">
				<form id="USER_EDIT_FORM" class="form-horizontal" role="form">
					<input type="hidden" name="userId" value="${user.userId}" />
					<div class="form-body">
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label class="control-label col-md-4">
										<fmt:message key="PAGE.USER.LIST.USER_NAME" />
										<span class="required" aria-required="true"> * </span>
									</label>
									<div class="col-md-6">
										<input type="text" name="userName" class="form-control input-sm" placeholder="" value="${user.userName}">
										<input type="hidden" id="userPass" name="userPass" value=<fmt:message key="common.username.userPass" /> />
									</div>
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label class="control-label col-md-4">
										<fmt:message key="PAGE.USER.LIST.USERLOGIN_NAME" />
										<span class="required" aria-required="true"> * </span>
									</label>
									<div class="col-md-6">
										<input type="text" name="uname" class="form-control input-sm" placeholder="" value="${user.uname}">
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label class="control-label col-md-4">
										<fmt:message key="PAGE.USER.LIST.USER_STATUS" />
										<span class="required" aria-required="true"> * </span>
									</label>
									<div class="col-md-6">
										<select class="js-example-placeholder-single form-control" name="userStatus">
											<option <c:if test="${user.userStatus==0}">selected</c:if> value="0"><fmt:message key="PAGE.USER.OPTD.USER_ENABLE" /></option>
											<option <c:if test="${user.userStatus==1}">selected</c:if> value="1"><fmt:message key="PAGE.USER.OPTD.USER_DISABLE" /></option>
										</select>
									</div>
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label class="control-label col-md-4">
										<fmt:message key="PAGE.USER.LIST.USER_L_LEAVE" />
									</label>
									<div class="col-md-6">
										<select class="js-example-placeholder-single form-control" name="leave">
											<option <c:if test="${user.leave==0}">selected</c:if> value="0"><fmt:message key="PAGE.USER.OPTD.USER_SERNOVER" /></option>
											<option <c:if test="${user.leave==1}">selected</c:if> value="1"><fmt:message key="PAGE.USER.OPTD.USER_TURNOVER" /></option>
										</select>
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label class="control-label col-md-4">
										<fmt:message key="PAGE.USER.LIST.USER_TYPE" />
										<span class="required" aria-required="true"> * </span>
									</label>
									<div class="col-md-6">
										<input type="text" class="form-control input-sm" name="userType" placeholder="" value="${user.userType}">
									</div>
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label class="control-label col-md-4">
										<fmt:message key="PAGE.USER.LIST.USER_WORKNUMBER" />
										<span class="required" aria-required="true"> * </span>
									</label>
									<div class="col-md-6">
										<input type="text" class="form-control input-sm" name="workNumber" placeholder="" value="${user.workNumber}">
									</div>
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label class="control-label col-md-4">
										<fmt:message key="PAGE.USER.LIST.USER_POSITION" />
										<span class="required" aria-required="true"> * </span>
									</label>
									<div class="col-md-6">
										<select class="js-example-placeholder-single form-control" name="vcPosition">
											<option></option>
											<c:forEach items="${positionDatas }" var="l">
												<c:choose>
													<c:when test="${l.code == user.vcPosition }">
			                                      			<option value="${l.code }" selected="selected">${l.display }</option>
													</c:when>
													<c:otherwise>
			                                      			<option value="${l.code }">${l.display }</option>
													</c:otherwise>
												</c:choose>
			                                      </c:forEach>
										</select>
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<div class="form-group">
									<label class="control-label col-md-2">
										<fmt:message key="PAGE.USER.LIST.USER_REMARK" />
									</label>
									<div class="col-md-9">
										<textarea class="form-control" rows="3" name="userRemark" placeholder="" value="${user.userRemark}"></textarea>
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
					<button type="button" class="btn btn-primary" id="saveUserBt" onclick="User.saveUserData();">
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

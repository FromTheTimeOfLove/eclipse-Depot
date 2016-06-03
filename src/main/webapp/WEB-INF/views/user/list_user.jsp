<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
</head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<body>
	<div class="row">
		<div class="col-md-12">
			<!-- BEGIN EXAMPLE TABLE PORTLET-->
			<div class="portlet box green">
                <!-- BEGIN ONE PEGER TITLE AND BUTTON -->
                <div class="form-title-min-height">
                </div>
				<div class="portlet-body form">
					<form class="form-horizontal" role="form" id="userListForm">
						<div class="form-body form-body-size">
							<div class="form-group">
								<label class="col-md-2 control-label">
									<fmt:message key="PAGE.USER.LIST.USER_NAME" />
								</label>
								<div class="col-md-3">
									<input type="text" class="form-control input-sm" name="userName" placeholder="" />
								</div>
								<label class="col-md-2 control-label">
									<fmt:message key="PAGE.USER.LIST.USERLOGIN_NAME" />
								</label>
								<div class="col-md-3">
									<input type="text" class="form-control input-sm" name="uname" placeholder="" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-2 control-label">
									<fmt:message key="PAGE.USER.LIST.USER_STATUS" />
								</label>
								<div class="col-md-3">
									<select class="js-example-placeholder-single form-control" name="userStatus">
										<option value="">Please choose status</option>
										<option value="0"><fmt:message key="PAGE.USER.OPTD.USER_ENABLE" /></option>
										<option value="1"><fmt:message key="PAGE.USER.OPTD.USER_DISABLE" /></option>
									</select>
								</div>
								<label class="col-md-2 control-label">
									<fmt:message key="PAGE.USER.LIST.USER_TYPE" />
								</label>
								<div class="col-md-3">
									<input type="text" class="form-control input-sm" name="userType" placeholder="" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-2 control-label">
									<fmt:message key="PAGE.USER.LIST.USER_L_LEAVE" />
								</label>
								<div class="col-md-3">
									<select class="js-example-placeholder-single form-control" name="leave">
										<option value="">Please choose job status</option>
										<option value="0"><fmt:message key="PAGE.USER.OPTD.USER_SERNOVER" /></option>
										<option value="1"><fmt:message key="PAGE.USER.OPTD.USER_TURNOVER" /></option>
									</select>
								</div>
								<label class="col-md-2 control-label">
									<fmt:message key="PAGE.USER.LIST.USER_WORKNUMBER" />
								</label>
								<div class="col-md-3">
									<input type="text" class="form-control input-sm" name="workNumber" placeholder="" />
								</div>
							</div>
						</div>
						<div class="form-actions right">
							<div class="row">
								<div class="col-md-12">
									<button type="button" class="btn btn-primary" id="userSearchBt">
										<fmt:message key="PAGE.GEN.SEARCH" />
									</button>
									<button type="reset"
										onclick="SelectUtils.resetSelectVal();"
										class="btn btn-primary green" id="userResetBt">
										<fmt:message key="PAGE.GEN.RESET" />
									</button>
									<button type="button" class="btn btn-success" id="userAddBt">
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
		<!-- END EXAMPLE TABLE PORTLET-->
	</div>
    <!-- END ONE PEGER HEAD-->
    <!-- BEGIN ONE PEGER LIST BODY -->
    <div class="row">
        <div class="col-md-12">
            <!-- BEGIN ONE PEGER LIST HEAD BODY-->
            <div class="portlet box green">
                <!-- BEGIN ONE PEGER LIST TITLE AND BUTTON -->
                <div class="portlet-title">
                    <!-- BEGIN ONE PEGER LIST TITLE -->
                    <div class="caption">
                        <i class="fa  fa-table"></i>
                        User Management
                    </div>
                    <!-- END ONE PEGER LIST TITLE -->
                    <!-- BEGIN ONE PEGER LIST BUTTON -->
                    <div class="tools">
                        <!-- <a class="collapse" href="javascript:;" data-original-title="" title=""> </a>
                        <a class="reload" href="javascript:;" data-original-title="" title=""> </a> -->
                    </div>
                    <!-- END ONE PEGER LIST BUTTON -->
                </div>
                <!-- END ONE PEGER LIST TITLE AND BUTTON -->
                <!-- BEGIN ONE PEGER LIST CONTENT -->
                <div class="portlet-body form">
                    <!-- BEGIN PAGE CONTENT -->
                    <table id="userListTable" class="table table-striped table-bordered table-hover">
                    </table>
                    <!-- END PAGE CONTENT -->
                </div>
                <!-- END ONE PEGER LIST CONTENT -->
            </div>
            <!-- END ONE PEGER LIST HEAD BODY-->
        </div>
    </div>
	<jsp:include page="../decorate/contentFoot.jsp"></jsp:include>
    <jsp:include page="../decorate/contentFootJS.jsp"></jsp:include>
	<script src="static/user/scripts/user.js" type="text/javascript"></script>
	<script src="static/common/scripts/base64.js" type="text/javascript"></script>
	<script src="static/common/plugins/crypto-js/crypto-js.js" type="text/javascript"></script>
	<!-- END PAGE LEVEL SCRIPTS -->
</body>
</html>
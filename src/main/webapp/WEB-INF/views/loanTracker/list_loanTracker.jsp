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
	<!-- BEGIN Basic Info HEAD-->
	<div class="row">
		<div class="col-md-12">
			<!-- BEGIN Basic Info HEAD WINDOW-->
			<div class="portlet box green">
				<!-- BEGIN Basic Info TITLE AND BUTTON -->
				<div class="form-title-min-height">
				</div>
				<!-- END Basic Info TITLE AND BUTTON -->
				<!-- BEGIN Basic Info QUERY CRITERIA -->
				<div class="portlet-body form">
					<form class="form-horizontal" role="form" id="loanTrackerForm">
						<div class="form-body form-body-size">
							<div class="form-group">
								<label class="col-md-2 control-label">
									Fund
								</label>
								<div class="col-md-3">
									<select class="js-example-placeholder-single form-control" readonly="readonly">
										<option value>Please choose a Fund</option>
										<option value="1">Gardenia + Daisies</option>
										<option value="2">Roses + Stephanotis</option>
										<option value="3">Peony + Gerbera</option>
										<option value="4">Orchid + Limonium</option>
										<option value="5">Iris + Omithoalum</option>
									</select>
								</div>
							</div>
						</div>
						<!-- BEGIN - Here query、 reset, And add button -->
						<div class="form-actions right">
							<div class="row">
								<div class="col-md-12">
									<button type="button" class="btn btn-sm green" id="loanTrackerSearchBt">
										<fmt:message key="PAGE.GEN.SEARCH" />
									</button>
									<button type="reset" onclick="SelectUtils.resetSelectVal();" class="btn btn-sm green" id="loanTrackerResetBt">
										<fmt:message key="PAGE.GEN.RESET" />
									</button>
									<button type="button" class="btn btn-sm green" id="loanTrackerExportBt">
										<fmt:message key="PAGE.GEN.EXPORT" />
										<i class="fa fa-plus"> </i>
									</button>
								</div>
							</div>
						</div>
						<!-- END - Here query、 reset, And add button -->
					</form>
				</div>
				<!-- END Basic Info QUERY CRITERIA -->
			</div>
			<!-- END Basic Info HEAD WINDOW-->
		</div>
	</div>
	<!-- END Basic Info HEAD-->
	<!-- BEGIN Basic Info LIST BODY -->
	<div class="row">
		<div class="col-md-12">
			<!-- BEGIN Basic Info LIST HEAD BODY-->
			<div class="portlet box green">
				<!-- BEGIN Basic Info LIST TITLE AND BUTTON -->
				<div class="portlet-title">
					<!-- BEGIN Basic Info LIST TITLE -->
					<div class="caption">
						<i class="fa  fa-table"></i>
						USD Fund Loan Tracker
					</div>
					<!-- END Basic Info LIST TITLE -->
					<!-- BEGIN Basic Info LIST BUTTON -->
					<div class="tools">
						<a class="collapse" href="javascript:;" data-original-title="" title=""> </a>
						<a class="reload" href="javascript:;" data-original-title="" title=""> </a>
					</div>
					<!-- END Basic Info LIST BUTTON -->
				</div>
				<!-- END Basic Info LIST TITLE AND BUTTON -->
				<!-- BEGIN Basic Info LIST CONTENT -->
				<div class="portlet-body form">
					<table
						class="table table-striped table-bordered table-hover table-checkable order-column"
						id="loanTrackerTable">
					</table>
					<!-- BEGIN END -->
				</div>
				<!-- END Basic Info LIST CONTENT -->
			</div>
			<!-- END Basic Info LIST HEAD BODY-->
		</div>
	</div>
	<!-- END Basic Info LIST BODY -->
    <jsp:include page="../decorate/contentFoot.jsp"></jsp:include>
    <jsp:include page="../decorate/contentFootJS.jsp"></jsp:include>
    <script type="text/javascript" src="static/loanTracker/scripts/loanTracker.js"></script>
</body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    String portfolioNameCH = portfolioNameCH = (String)session.getAttribute("portfolioNameCH");
    if(portfolioNameCH == null) portfolioNameCH = "";
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
	<!-- BEGIN Basic Exit HEAD-->
	<div class="row">
		<div class="col-md-12">
			<!-- BEGIN Basic Exit HEAD WINDOW-->
			<div class="portlet box green">
				<!-- BEGIN Basic Exit TITLE AND BUTTON -->
				<div class="form-title-min-height">
				</div>
				<!-- END Basic Exit TITLE AND BUTTON -->
				<!-- BEGIN Basic Exit QUERY CRITERIA -->
				<div class="portlet-body form">
					<form class="form-horizontal" role="form" id="basicExitListForm">
						<input id="hiddenText" type="text" style="display:none" />
						<div class="form-body form-body-size">
							<div class="form-group">
								<label class="col-md-2 control-label">Portfolio name(CH)</label>
								<div class="col-md-3">
									<input type="text" class="form-control" name="portfolioNameCH" value="<%=portfolioNameCH %>" placeholder="Portfolio name(CH)">
								</div>
								<label class="col-md-2 control-label">
									Stage
								</label>
								<div class="col-md-3">
									<select class="js-example-placeholder-single form-control" readonly="readonly" name="stageId">
										<option value>Please choose a Stage</option>
										<c:forEach var="entry" items="${stage}">
											<option value="${entry.code }">${entry.display }</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-2 control-label">Sector</label>
								<div class="col-md-3">
									<select class="js-example-placeholder-single form-control" readonly="readonly" name="sectorId">
										<option value>Please choose a Stage</option>
										<c:forEach var="entry" items="${sector}">
											<option value="${entry.code }">${entry.display }</option>
										</c:forEach>
									</select>
								</div>
								<label class="col-md-2 control-label">
									Fund
								</label>
								<div class="col-md-3">
									<select class="js-example-placeholder-single form-control" readonly="readonly" name="fundId">
										<option value>Please choose a Stage</option>
										<c:forEach var="entry" items="${fund}">
											<option value="${entry.code }">${entry.display }</option>
										</c:forEach>
									</select>
								</div>
							</div>
						</div>
						<!-- BEGIN - Here query、 reset, And add button -->
						<div class="form-actions right">
							<div class="row">
								<div class="col-md-12">
									<button type="button" class="btn btn-sm green" id="basicExitSearchBt">
										<fmt:message key="PAGE.GEN.SEARCH" />
									</button>
									<button type="reset" onclick="SelectUtils.resetSelectVal();BasicExit.resetSession();" class="btn btn-sm green" id="basicExitResetBt">
										<fmt:message key="PAGE.GEN.RESET" />
									</button>
								</div>
							</div>
						</div>
						<!-- END - Here query、 reset, And add button -->
					</form>
				</div>
				<!-- END Basic Exit QUERY CRITERIA -->
			</div>
			<!-- END Basic Exit HEAD WINDOW-->
		</div>
	</div>
	<!-- END Basic Exit HEAD-->
	<!-- BEGIN Basic Exit LIST BODY -->
	<div class="row">
		<div class="col-md-12">
			<!-- BEGIN Basic Exit LIST HEAD BODY-->
			<div class="portlet box green">
				<!-- BEGIN Basic Exit LIST TITLE AND BUTTON -->
				<div class="portlet-title">
					<!-- BEGIN Basic Exit LIST TITLE -->
					<div class="caption">
						<i class="fa  fa-table"></i>
						Basic Exit List
					</div>
					<!-- END Basic Exit LIST TITLE -->
					<!-- BEGIN Basic Exit LIST BUTTON -->
					<div class="tools">
						<!-- <a class="collapse" href="javascript:;" data-original-title="" title=""> </a>
						<a class="reload" href="javascript:;" data-original-title="" title=""> </a> -->
					</div>
					<!-- END Basic Exit LIST BUTTON -->
				</div>
				<!-- END Basic Exit LIST TITLE AND BUTTON -->
				<!-- BEGIN Basic Exit LIST CONTENT -->
				<div class="portlet-body form">
					<!-- BEGIN PAGE CONTENT -->
					<table id="basicExitListTable" class="table table-striped table-bordered table-hover table-advance">
					</table>
					<!-- END PAGE CONTENT -->
				</div>
				<!-- END Basic Exit LIST CONTENT -->
			</div>
			<!-- END Basic Exit LIST HEAD BODY-->
		</div>
	</div>
	<!-- END Basic Exit LIST BODY -->
    <jsp:include page="../decorate/contentFoot.jsp"></jsp:include>
    <jsp:include page="../decorate/contentFootJS.jsp"></jsp:include>
    <script src="static/basicExit/scripts/basicExit.js?randomId=<%=Math.random()%>" type="text/javascript"></script>
    <script type="text/javascript">
		// 执行	
    	BasicExit.init();
    </script>
</body>
</html>

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
	<!-- BEGIN tsSigned HEAD-->
	<div class="row">
		<div class="col-md-12">
			<!-- BEGIN tsSigned HEAD WINDOW-->
			<div class="portlet box green">
				<!-- BEGIN tsSigned TITLE AND BUTTON -->
				<div class="form-title-min-height">
				</div>
				<!-- END tsSigned TITLE AND BUTTON -->
				<!-- BEGIN tsSigned QUERY CRITERIA -->
				<div class="portlet-body form">
					<form class="form-horizontal" role="form" id="tsSignedListForm">
						<div class="form-body form-body-size">
							<div class="form-group">
								<label class="col-md-2 control-label">Portfolio name(CH)</label>
								<div class="col-md-3">
									<input type="text" value="<%=portfolioNameCH %>" name="portfolioNameCH" class="form-control" placeholder="Portfolio name(CH)">
								</div>
								<label class="col-md-2 control-label">Portfolio name(EN)</label>
								<div class="col-md-3">
									<input type="text" class="form-control" name="portfolioNameEN" placeholder="Portfolio name(EN)">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-2 control-label">Sector</label>
								<div class="col-md-3">
									<select class="js-example-placeholder-single form-control" name="sectorId">
										<option value="">Please choose a Sector</option>
										<c:forEach items="${secsector}" var="se">
											<option value="${se.code}"
												<c:if test="${onepaper.sectorid==se.code}">selected</c:if>>${se.display}</option>
										</c:forEach>
									</select>
								</div>
								<label class="col-md-2 control-label">
									Fund
								</label>
								<div class="col-md-3">
									<select class="js-example-placeholder-single form-control" name="fundId">
										<option value="">Please choose a Fund</option>
										<c:forEach items="${secfund}" var="sef">
											<option value="${sef.code}"
												<c:if test="${onepaper.fundid==sef.code}">selected</c:if>>${sef.display}</option>
										</c:forEach>
									</select>
								</div>
							</div>
						</div>
						<!-- BEGIN - Here query、 reset, And add button -->
						<div class="form-actions right">
							<div class="row">
								<div class="col-md-12">
									<button type="button" class="btn btn-sm green" id="tsSignedSearchBt">
										<fmt:message key="PAGE.GEN.SEARCH" />
									</button>
									<button type="reset" onclick="SelectUtils.resetSelectVal();tsSigned.resetSession();" class="btn btn-sm green" id="tsSignedResetBt">
										<fmt:message key="PAGE.GEN.RESET" />
									</button>
								</div>
							</div>
						</div>
						<!-- END - Here query、 reset, And add button -->
					</form>
				</div>
				<!-- END tsSigned QUERY CRITERIA -->
			</div>
			<!-- END tsSigned HEAD WINDOW-->
		</div>
	</div>
	<!-- END tsSigned HEAD-->
	<!-- BEGIN tsSigned LIST BODY -->
	<div class="row">
		<div class="col-md-12">
			<!-- BEGIN tsSigned LIST HEAD BODY-->
			<div class="portlet box green">
				<!-- BEGIN tsSigned LIST TITLE AND BUTTON -->
				<div class="portlet-title">
					<!-- BEGIN tsSigned LIST TITLE -->
					<div class="caption">
						<i class="fa  fa-table"></i>
						Ts Signed List
					</div>
					<!-- END tsSigned LIST TITLE -->
					<!-- BEGIN tsSigned LIST BUTTON -->
					<div class="tools">
						<!-- <a class="collapse" href="javascript:;" data-original-title="" title=""> </a>
						<a class="reload" href="javascript:;" data-original-title="" title=""> </a> -->
					</div>
					<!-- END tsSigned LIST BUTTON -->
				</div>
				<!-- END tsSigned LIST TITLE AND BUTTON -->
				<!-- BEGIN tsSigned LIST CONTENT -->
				<div class="portlet-body form">
					<!-- BEGIN PAGE CONTENT -->
					<table id="tsSignedListTable" class="table table-striped table-bordered table-hover table-advance">
					</table>
					<!-- END PAGE CONTENT -->
					<!-- BEGIN END -->
				</div>
				<!-- END tsSigned LIST CONTENT -->
			</div>
			<!-- END tsSigned LIST HEAD BODY-->
		</div>
	</div>
	<!-- END tsSigned LIST BODY -->
    <jsp:include page="../decorate/contentFoot.jsp"></jsp:include>
    <jsp:include page="../decorate/contentFootJS.jsp"></jsp:include>
    <script src="static/tsSigned/scripts/tsSigned.js" type="text/javascript"></script>
</body>
</html>

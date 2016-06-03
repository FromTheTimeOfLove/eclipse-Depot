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
	String portfolioNameCH = (String) session
			.getAttribute("portfolioNameCH");
	String portfolioNameEN = (String) session
			.getAttribute("portfolioNameEN");
	if (portfolioNameCH == null) {
		portfolioNameCH = "";
	}
	if (portfolioNameEN == null) {
		portfolioNameEN = "";
	}
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
	<!-- BEGIN ONE PEGER HEAD-->
	<div class="row">
		<div class="col-md-12">
			<!-- BEGIN ONE PEGER HEAD WINDOW-->
			<div class="portlet box green">
				<!-- BEGIN ONE PEGER TITLE AND BUTTON -->
				<div class="form-title-min-height"></div>
				<!-- END ONE PEGER TITLE AND BUTTON -->
				<!-- BEGIN ONE PEGER QUERY CRITERIA -->
				<div class="portlet-body form">
					<form class="form-horizontal" id="onePagerListForm">
						<div class="form-body form-body-size">
							<div class="form-group">
								<label class="col-md-2 control-label">Portfolio name(CH)</label>
								<div class="col-md-3">
									<input type="text" class="form-control input-sm"
										name="portfolionameCH" placeholder=""
										value="<%=portfolioNameCH%>" />
								</div>
								<label class="col-md-2 control-label"> Portfolio name(EN) </label>
								<div class="col-md-3">
									<input type="text" class="form-control input-sm"
										name="portfolionameEN" placeholder=""
										value="<%=portfolioNameEN%>" />
								</div>
								<!-- <div class="col-md-3">
									<select class="js-select" id="stageSelect" name="stageId"
										readonly="readonly">
										<option value>Please choose a Stage</option>
										<option value="1">Gardenia + Daisies</option>
										<option value="2">Roses + Stephanotis</option>
										<option value="3">Peony + Gerbera</option>
										<option value="4">Orchid + Limonium</option>
										<option value="5">Iris + Omithoalum</option>
									</select>
								</div> -->
							</div>
							<div class="form-group">
								<label class="col-md-2 control-label">Sector</label>
								<div class="col-md-3">
								<select class="js-example-placeholder-single form-control" id="sectorid" name="sectorid">
										<option value>Please choose a Sector</option>
										<c:forEach items="${secsector}" var="se">
											<option value="${se.code}"
												<c:if test="${onepaper.sectorid==se.code}">selected</c:if>>${se.display}</option>
										</c:forEach>
									</select>
								</div>
								<!-- <div class="col-md-3">
									<select class="js-select" name="sectorId">
										<option value>Please choose a Sector</option>
										<option value="1">Gardenia + Daisies</option>
										<option value="2">Roses + Stephanotis</option>
										<option value="3">Peony + Gerbera</option>
										<option value="4">Orchid + Limonium</option>
										<option value="5">Iris + Omithoalum</option>
									</select>
								</div>-->
								<label class="col-md-2 control-label"> Fund </label>
								<div class="col-md-3">
									<select class="js-example-placeholder-single form-control" id="fundid" name="fundid">
										<option value>Please choose a Fund</option>
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
									<button type="button" class="btn btn-sm green"
										id="onePagerSearchBt">
										<fmt:message key="PAGE.GEN.SEARCH" />
									</button>
									<button type="reset"
										onclick="SelectUtils.resetSelectVal();OnePaper.resetSession();"
										class="btn btn-sm green" id="onePagerResetBt">
										<fmt:message key="PAGE.GEN.RESET" />
									</button>
									<button type="button" class="btn btn-sm green"
										id="onePagerAddBt">
										<fmt:message key="PAGE.GEN.ADD" />
										<i class="fa fa-plus"> </i>
									</button>
								</div>
							</div>
						</div>
						<!-- END - Here query、 reset, And add button -->
					</form>
				</div>
				<!-- END ONE PEGER QUERY CRITERIA -->
			</div>
			<!-- END ONE PEGER HEAD WINDOW-->
		</div>
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
						<fmt:message key="PAGE.ONEPAPER.TITLE.LIST" />
					</div>
					<!-- END ONE PEGER LIST TITLE -->
					<!-- BEGIN ONE PEGER LIST BUTTON -->
					<div class="tools">
						<!-- <a class="collapse" href="javascript:;" data-original-title=""
							title=""> </a> <a class="reload" href="javascript:;"
							data-original-title="" title=""> </a> -->
					</div>
					<!-- END ONE PEGER LIST BUTTON -->
				</div>
				<!-- END ONE PEGER LIST TITLE AND BUTTON -->
				<!-- BEGIN ONE PEGER LIST CONTENT -->
				<div class="portlet-body form">
					<!-- BEGIN PAGE CONTENT -->
					<table id="onePagerListTable"
						class="table table-striped table-bordered table-hover">
					</table>
					<!-- END PAGE CONTENT -->
				</div>
				<!-- END ONE PEGER LIST CONTENT -->
			</div>
			<!-- END ONE PEGER LIST HEAD BODY-->
		</div>
	</div>
	<!-- END ONE PEGER LIST BODY -->
	<jsp:include page="../decorate/contentFoot.jsp"></jsp:include>
	<jsp:include page="../decorate/contentFootJS.jsp"></jsp:include>
	<script src="static/onePaper/scripts/onePaper.js"
		type="text/javascript"></script>
</body>
</html>

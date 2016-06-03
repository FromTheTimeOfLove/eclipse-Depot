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
					<form class="form-horizontal" role="form" id="EquityInvestmentListForm">
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
                                    <select class="js-example-placeholder-single form-control" name="stageId" readonly="readonly">
                                        <option value>Please choose a Stage</option>
                                        <c:forEach items="${stageDatas }" var="l">
                                        	<option value="${l.code }">${l.display }</option>
                                        </c:forEach>
                                    </select>
                                </div>
							</div>
							<div class="form-group">
								<label class="col-md-2 control-label">Sector</label>
								<div class="col-md-3">
									<select class="js-example-placeholder-single form-control" name="sectorId">
										<option value>Please choose a Sector</option>
										<c:forEach items="${sectorDatas }" var="l">
                                        	<option value="${l.code }">${l.display }</option>
                                        </c:forEach>
									</select>
								</div>
								<label class="col-md-2 control-label">
									Fund
								</label>
								<div class="col-md-3">
									<select class="js-example-placeholder-single form-control" name="fundId" readonly="readonly">
										<option value>Please choose a Fund</option>
										<c:forEach items="${fundDatas }" var="l">
                                        	<option value="${l.code }">${l.display }</option>
                                        </c:forEach>
									</select>
								</div>
							</div>
						</div>
						<!-- BEGIN - Here query、 reset, And add button -->
						<div class="form-actions right">
							<div class="row">
								<div class="col-md-12">
									<button type="button" class="btn btn-sm green" id="equityInvestmentSearchBt">
										<fmt:message key="PAGE.GEN.SEARCH" />
									</button>
									<button type="reset" onclick="SelectUtils.resetSelectVal();EquityInvestment.resetSession();" class="btn btn-sm green" id="equityInvestmentResetBt">
										<fmt:message key="PAGE.GEN.RESET" />
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
						Equity Investment List
					</div>
					<!-- END Basic Info LIST TITLE -->
					<!-- BEGIN Basic Info LIST BUTTON -->
					<div class="tools">
						<!-- <a class="collapse" href="javascript:;" data-original-title="" title=""> </a>
						<a class="reload" href="javascript:;" data-original-title="" title=""> </a> -->
					</div>
					<!-- END Basic Info LIST BUTTON -->
				</div>
				<!-- END Basic Info LIST TITLE AND BUTTON -->
				<!-- BEGIN Basic Info LIST CONTENT -->
				<div class="portlet-body form">
					<table
						class="table table-striped table-bordered table-hover table-checkable order-column"
						id="equityInvestmentListTable">
					</table>
				</div>
				<!-- END Basic Info LIST CONTENT -->
			</div>
			<!-- END Basic Info LIST HEAD BODY-->
		</div>
	</div>
	<!-- END Basic Info LIST BODY -->
    <jsp:include page="../decorate/contentFoot.jsp"></jsp:include>
    <jsp:include page="../decorate/contentFootJS.jsp"></jsp:include>
    <script type="text/javascript" src="static/equityInvestment/scripts/equityInvestment.js?ran=" + Math.random()></script>
</body>
</html>

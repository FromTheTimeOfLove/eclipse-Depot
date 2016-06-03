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
	<form action="#" class="form-horizontal form-row-seperated" id="fundForm">
    <!-- Begin Add Fund -->
    <div class="row">
		<!-- Begin Add Fund Window-->
    	<div class="col-md-12">
			<div class="portlet box green">
				<div class="portlet-title">
					<div class="caption">
						<i class="fa fa-table"></i> 	Fund
					</div>
					<div class="tools">
						<a href="javascript:;" class="collapse" data-original-title="" title="">
						</a>
					</div>
				</div>
				<div class="portlet-body">
					<div class="portlet">
						<div class="form-horizontal" role="form">
							<!-- id隐藏域 -->
					    	<input type="hidden" name="fundId" value="${fund.fundId }"/>
							<div class="form-group">
								<label  class="col-md-3 control-label">出资主体名称:</label>
								<div class="col-md-4">
									<input type="text"  class="form-control" name="fundName" value="${fund.fundName }">
								</div>
							</div>
							<div class="form-group">
								<label  class="col-md-3 control-label">简称:</label>
								<div class="col-md-4">
									<input type="text" class="form-control" name="simpleName" value="${fund.simpleName }">
								</div>
							</div>
							<div class="form-group">
								<label  class="col-md-3 control-label">是否基金:</label>
								<div class="col-md-4">
									<div class="col-md-4">
										<label class="radio-inline">
										<input type="radio" name="istruefund" value="1" <c:if test="${fund.istruefund == 1}">checked="checked"</c:if>> Y </label>
										<label class="radio-inline">
										<input type="radio" name="istruefund" value="0" <c:if test="${fund.istruefund == 0}">checked="checked"</c:if>> N </label>
									</div>
								</div>
							</div>
							<div class="form-group">
								<label  class="col-md-3 control-label">资金规模:</label>
								<div class="col-md-4">
									<input type="text" class="form-control" name="moneygm" value="${fund.moneygm }">
								</div>
							</div>
							<div class="form-group">
								<label  class="col-md-3 control-label">顾问委员会成员:</label>
								<div class="col-md-4">
									<input type="text" class="form-control" name="memberAdvBoard" value="${fund.memberAdvBoard }">
								</div>
							</div>
							<div class="form-group">
								<label  class="col-md-3 control-label">投资决策委员会成员:</label>
								<div class="col-md-4">
									<input type="text" class="form-control" name="memberSinvCommittee" value="${fund.memberSinvCommittee }">
								</div>
							</div>
							<div class="form-group">
								<label  class="col-md-3 control-label">其他重要事项:</label>
								<div class="col-md-4">
									<textarea class="form-control" rows="5" style="resize:none" 
									name="otherImportantIssues">${fund.otherImportantIssues }</textarea>
								</div>
							</div>
							<div class="form-group">
								<label  class="col-md-3 control-label">简介:</label>
								<div class="col-md-4">
									<textarea class="form-control" rows="5" style="resize:none" 
									name="fundDesc">${fund.fundDesc }</textarea>
								</div>
							</div>
							<div class="form-group">
								<label  class="col-md-3 control-label">分配原则:</label>
								<div class="col-md-4">
									<textarea class="form-control" rows="5" style="resize:none" 
									name="allocationPrinciples">${fund.allocationPrinciples }</textarea>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
    	</div>
		<!-- End Add Fund Window-->
    </div>
	</form>
	<div class="portlet-body form">
		<div class="form-actions center">
			<div class="row">
				<div class="col-md-12" align="center">
					<button type="button" class="btn btn-success J_menuItem" onclick="Fund.saveFund()" id="save">
						<fmt:message key="PAGE.GEN.SAVE" />
					</button>
					<button type="reset" onclick="SelectUtils.resetSelectVal();" class="btn btn-primary">
						<fmt:message key="PAGE.GEN.RESET" />
					</button>
				</div>
			</div>
		</div>
	</div>
    <!-- End Add Fund -->
    <jsp:include page="../decorate/contentFoot.jsp"></jsp:include>
    <jsp:include page="../decorate/contentFootJS.jsp"></jsp:include>
    <script src="static/fundMgmt/scripts/fundMgmt.js?randomId=<%=Math.random()%>" type="text/javascript"></script>
</body>
</html>

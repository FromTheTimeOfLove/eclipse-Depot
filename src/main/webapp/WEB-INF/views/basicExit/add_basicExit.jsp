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
     <div class="top-tree">
 		<ul>
			<li style="height:91%">
				<a href="javascript:void(0)" title="红杉" > A轮</a>
			</li>
 			<li style="height:91%">
 				<div class="current"><a title="红杉"> B轮</a></div>
 			</li>
 			<li style="height:91%">
				<a href="javascript:void(0)" title="红杉" > C轮</a>
			</li>
			<li style="height:91%">
				<a href="javascript:void(0)" title="红杉" > D轮</a>
			</li>
 		</ul>
 	</div> 
 	<br/>
 	<br/> 
 		<!-- Begin Add One Pager -->
<div class="row">
		<!-- Begin Add One Pager Window-->
	<div class="col-md-12">
		<div class="portlet box green">
			<div class="portlet-title">
				<div class="caption">
					<i class="fa fa-table"></i> 	Save Exit Info
				</div>
				<div class="tools">
					<a href="javascript:;" class="collapse" data-original-title="" title="">
					</a>
				</div>
			</div>
			<div class="portlet-body form">
					<form id="basicExitform" class="form-horizontal form-row-seperated" target="hidden_frame">
						<div class="form-body" >
							<!-- id隐藏域 -->
							<input type="hidden" name="paperId" value="${basicExit.paperId }">
					    	<input type="hidden" name="basicExitId" value="${basicExit.basicExitId }"/>
							<div class="form-group">
								<label  class="col-md-3 control-label">Portfolio name (CH)</label>
								<div class="col-md-4">
									<input type="text" readonly="readonly" class="form-control" name="portfolioNameCH" value="${basicExit.portfolioNameCH }">
								</div>
							</div>
							<div class="form-group">
								<label  class="col-md-3 control-label">Portfolio name (EN)</label>
								<div class="col-md-4">
									<input type="text" readonly="readonly" class="form-control" name="portfolioNameEN" value="${basicExit.portfolioNameEN }">
								</div>
							</div>
							<div class="form-group">
								<label  class="col-md-3 control-label">Amount of Proceeds</label>
								<div class="col-md-4">
									<input type="text" class="form-control" name="proceedsAmount" value="${basicExit.proceedsAmount }" 
											onkeyup="this.value=this.value.replace(/[^\d\.]/g,'')"
											onafterpaste="this.value=this.value.replace(/[^\d\.]/g,'')"
											onchange="GlobalUtil.setnum(this)">
								</div>
							</div>
							<div class="form-group">
								<label  class="col-md-3 control-label">Date of sold</label>
								<div class="col-md-4">
									<div class="input-icon input-icon-sm right">
										<i class="fa fa-calendar"> </i>
										<input type="text" class="form-control input-sm date dataTimeTest" name="dateSold" placeholder="yyyy-mm-dd" value="${basicExit.dateSold }" readonly />
									</div>
								</div>
							</div>
							<div class="form-group">
								<label  class="col-md-3 control-label">Ownership after sold</label>
								<div class="col-md-4">
									<input type="text" class="form-control" name="afterSold" value="${basicExit.afterSold }">
								</div>
							</div>
							<div class="form-group">
								<label  class="col-md-3 control-label">Reduced investment cost</label>
								<div class="col-md-4">
									<input type="text" class="form-control" name="reducedInvestcost" value="${basicExit.reducedInvestcost }" 
											onkeyup="this.value=this.value.replace(/[^\d\.]/g,'')"
											onafterpaste="this.value=this.value.replace(/[^\d\.]/g,'')"
											onchange="GlobalUtil.setnum(this)">
								</div>
							</div>
							<div class="form-group">
								<label  class="col-md-3 control-label">Date of Sign</label>
								<div class="col-md-4">
									<div class="input-icon input-icon-sm right">
										<i class="fa fa-calendar"> </i>
										<input type="text" class="form-control input-sm date dataTimeTest" name="signDate" placeholder="yyyy-mm-dd" value="${basicExit.signDate }" readonly />
									</div>
								</div>
							</div>
							<div class="form-group">
								<label  class="col-md-3 control-label">Deal partner 1</label>
								<div class="col-md-4">
									<input type="text" class="form-control" name="dealPartnerOne" value="${basicExit.dealPartnerOne }">
								</div>
							</div>
							<div class="form-group">
								<label  class="col-md-3 control-label">Deal partner 2</label>
								<div class="col-md-4">
									<input type="text" class="form-control" name="dealPartnerTwo" value="${basicExit.dealPartnerTwo }">
								</div>
							</div>
							<div class="form-group">
								<label  class="col-md-3 control-label">Deal partner 3</label>
								<div class="col-md-4">
									<input type="text" class="form-control" name="dealPartnerThi" value="${basicExit.dealPartnerThi }">
								</div>
							</div>
							<div class="form-group">
								<label  class="col-md-3 control-label">Type</label>
								<div class="col-md-4">
									<select class="js-example-placeholder-single form-control" name="typeId">
										<option value>Please choose Type</option>
										<c:forEach var="entry" items="${type}">
											<option value="${entry.code }" <c:if test="${basicExit.typeId == entry.code}">selected</c:if>>${entry.display }</option>
										</c:forEach>
									</select>									
								</div>
							</div>
							<div class="form-group">
								<label  class="col-md-3 control-label">Sector</label>
								<div class="col-md-4">
									<select class="js-example-placeholder-single form-control" name="sectorId">
										<option value>Please choose Sector</option>
										<c:forEach var="entry" items="${sector}">
											<option value="${entry.code }" <c:if test="${basicExit.sectorId == entry.code}">selected</c:if>>${entry.display }</option>
										</c:forEach>
									</select>	
								</div>
							</div>
							<div class="form-group">
								<label  class="col-md-3 control-label">Fund</label>
								<div class="col-md-4">
									<select class="js-example-placeholder-single form-control" name="fundId">
										<option value>Please choose Fund</option>
										<c:forEach var="entry" items="${fund}">
											<option value="${entry.code }" <c:if test="${basicExit.fundId == entry.code}">selected</c:if>>${entry.display }</option>
										</c:forEach>
									</select>	
								</div>
							</div>
							</div>
							</form>
							</div>
							</div>
						<div class="portlet-body form">
							<div class="form-actions center">
								<div class="row">
									<div class="col-md-12" align="center">
										<button type="button" class="btn btn-success J_menuItem" onclick="BasicExit.saveBasicExit();" id="onePagerAddBt">
											<fmt:message key="PAGE.GEN.SAVE" />
										</button>
										<button type="reset" onclick="SelectUtils.resetSelectVal();" class="btn btn-primary"  id="onePagerResetBt">
											<fmt:message key="PAGE.GEN.RESET" />
										</button>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
	
	<jsp:include page="../decorate/contentFoot.jsp"></jsp:include>
    <jsp:include page="../decorate/contentFootJS.jsp"></jsp:include>
    <script src="static/basicExit/scripts/basicExit.js?randomId=<%=Math.random()%>" type="text/javascript"></script>
	<script type="text/javascript">
		jQuery(document).ready(function() { 
			$('.dataTimeTest').datetimepicker({
				minView: "month", 
				format: "yyyy-mm-dd", 
				language: 'zh-CN', 
				autoclose:true 
			});
	     }); 
	</script>
</body>
</html>

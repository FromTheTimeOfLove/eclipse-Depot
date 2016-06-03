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
</head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<body>
	<!-- Begin Add One Pager -->
	<div class="row">
		<!-- Begin Add One Pager Window-->
		<div class="col-md-12">
			<form id="ONEPAPER_EDIT_FORM" class="form-horizontal form-row-seperated"
				enctype="multipart/form-data" target="hidden_frame">
				<div class="portlet box green">
					<div class="portlet-title">
						<!-- Begin Add One Peger title -->
						<div class="caption">
							<i class="fa fa-align-justify"></i> Save One Pager
						</div>
						<!-- End Add One Peger title -->
						<!-- Begin Add One Peger Button -->
						<div class="tools">
							<!-- <a class="collapse" href="" data-original-title="" title=""> </a> -->
						</div>
						<!-- End Add One Peger Button -->
					</div>
					<!-- Begin Add One Pager Form Content -->
					<div class="portlet-body form">
						<input type="hidden" name="paperid" value="${onepaper.paperid}" />
						<div class="form-body">
							<div class="form-group">
								<label class="col-md-3 control-label"> Portfolio name
									(CH) <span class="required" aria-required="true"> * </span>
								</label>
								<div class="col-md-3">
									<!-- <input class="form-control input-circle" type="text" placeholder="Portfolio name (CH)"> -->
									<input type="text" name="portfolionameCH" class="form-control"
										placeholder="" value="${onepaper.portfolionameCH}">
								</div>
								<label class="col-md-2 control-label"> Portfolio name
									(EN)<span class="required" aria-required="true"> * </span> </label>
								<div class="col-md-3">
									<input type="text" name="portfolionameEN" class="form-control"
										placeholder="" value="${onepaper.portfolionameEN}">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-3 control-label"> Date </label>
								<div class="col-md-3">
									<div class="input-group date date-picker"
										data-date-start-date="+0d" data-date-format="yyyy-mm-dd">
										<input class="form-control" type="text" name="dpdate"
											value="${onepaper.dpdate}" readonly=""> <span
											class="input-group-btn">
											<button class="btn default" type="button">
												<i class="fa fa-calendar"></i>
											</button> </span>
									</div>
								</div>
								<label class="col-md-2 control-label"> Valuation </label>
								<div class="col-md-3">
									<input type="text" name="valuation" class="form-control"
										id="valuation"
										onkeyup="this.value=this.value.replace(/[^\d\.]/g,'')"
										onafterpaste="this.value=this.value.replace(/[^\d\.]/g,'')"
										placeholder="" value="${onepaper.valuation}"
										onchange="GlobalUtil.setnum(this)">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-3 control-label"> Sector </label>
								<div class="col-md-3">
									<select class="js-example-placeholder-single form-control" id="sectorid" name="sectorid">
									<option value>Please choose a Sector</option>
										<c:forEach items="${secsector}" var="se">
											<option value="${se.code}"
												<c:if test="${onepaper.sectorid==se.code}">selected</c:if>>${se.display}</option>
										</c:forEach>
									</select>
								</div>
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
							<div class="form-group">
								<label class="col-md-3 control-label"> Stage </label>
								<div class="col-md-3">
									<select class="js-example-placeholder-single form-control" id="stageid" name="stageid">
										<option value>Please choose a Stage</option>
										<c:forEach items="${secstage}" var="se">
											<option value="${se.code}"
												<c:if test="${onepaper.stageid==se.code}">selected</c:if>>${se.display}</option>
										</c:forEach>
									</select>
								</div>
								<label class="col-md-2 control-label"> Status </label>
								<div class="col-md-3">
									<select class="js-example-placeholder-single form-control" id="statusid" name="statusid">
										<option value>Please choose a Status</option>
										<c:forEach items="${secstatus}" var="se">
											<option value="${se.code}"
												<c:if test="${onepaper.statusid==se.code}">selected</c:if>>${se.display}</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-3 control-label"> Deal partner 1 </label>
								<div class="col-md-3">
									<input type="text" name="dealpartnerone" class="form-control"
										placeholder="" value="${onepaper.dealpartnerone}">
								</div>
								<label class="col-md-2 control-label"> Pricing </label>
								<div class="col-md-3">
									<input type="text" name="pricing" class="form-control"
										onkeyup="this.value=this.value.replace(/[^\d\.]/g,'')"
										onafterpaste="this.value=this.value.replace(/[^\d\.]/g,'')"
										placeholder="" value="${onepaper.pricing}"
										onchange="GlobalUtil.setnum(this)">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-3 control-label"> Deal partner 2 </label>
								<div class="col-md-3">
									<input type="text" name="dealpartnertwo" class="form-control"
										placeholder="" value="${onepaper.dealpartnertwo}">
								</div>
								<label class="col-md-2 control-label"> Financials </label>
								<div class="col-md-3">
									<input type="text" name="financials" class="form-control"
										onkeyup="this.value=this.value.replace(/[^\d\.]/g,'')"
										onafterpaste="this.value=this.value.replace(/[^\d\.]/g,'')"
										placeholder="" value="${onepaper.financials}"
										onchange="GlobalUtil.setnum(this)">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-3 control-label"> Deal partner 3 </label>
								<div class="col-md-3">
									<input type="text" name="dealpartnerthi" class="form-control"
										placeholder="" value="${onepaper.dealpartnerthi}">
								</div>
								<label class="col-md-2 control-label"> Competitors </label>
								<div class="col-md-3">
									<input type="text" name="competitorsname" class="form-control"
										placeholder="" value="${onepaper.competitorsname}">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-3 control-label"> Source </label>
								<div class="col-md-8">
									<input type="text" name="source" class="form-control"
										placeholder="" value="${onepaper.source}">
								</div>
							</div>

							<div class="form-group">
								<label class="col-md-3 control-label"> Investment Thesis
								</label>
								<div class="col-md-8">
									<input type="text" name="investmentthesis" class="form-control"
										placeholder="" value="${onepaper.investmentthesis}">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-3 control-label"> Business </label>
								<div class="col-md-8">
									<input type="text" name="business" class="form-control"
										placeholder="" value="${onepaper.business}">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-3 control-label"> Market </label>
								<div class="col-md-8">
									<input type="text" name="market" class="form-control"
										placeholder="" value="${onepaper.market}">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-3 control-label"> Product </label>
								<div class="col-md-8">
									<input type="text" name="product" class="form-control"
										placeholder="" value="${onepaper.product}">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-3 control-label"> Deal Terms </label>
								<div class="col-md-8">
									<input type="text" name="dealterms" class="form-control"
										placeholder="" value="${onepaper.dealterms}">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-3 control-label"> Customers </label>
								<div class="col-md-3">
									<input type="text" name="customersid" class="form-control"
										placeholder="" id="onepapercustomercode"
										value="${onepaper.customersid}">
									<!--<div class="input-group" style="text-align:left">
										<input class="form-control" type="text" id="onepapercustomers"  value="${onepaper.customersname}"> <span
											class="input-group-btn">
											<button type="button" class="btn green"
												onclick="OnePaper.ChooseCustomers();">
												<i class="fa fa-check"></i>Choose
											</button>
											  <a id="username1_checker" class="btn green" href="javascript:;" data-original-title=""
											title=""> <i class="fa fa-check"></i> Choose </a> 
											
											</span>
									</div>-->
								</div>
								<label class="col-md-2 control-label"> Team </label>
								<div class="col-md-3">
									<input type="text" name="teamid" class="form-control"
										placeholder="" id="teamid" value="${onepaper.teamid}">
									<!-- <div class="input-group" style="text-align:left">
										<input class="form-control" type="text" placeholder="Team">
										<span class="input-group-btn"> <a
											id="username1_checker" class="btn green" href="javascript:;"
											data-original-title="" title=""> <i class="fa fa-check"></i>
												Choose </a> </span>
									</div> -->
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-3 control-label"> Board </label>
								<div class="col-md-3">
									<input type="text" name="boardid" class="form-control"
										placeholder="" id="boardid" value="${onepaper.boardid}">
									<!-- <div class="input-group" style="text-align:left">
										<input class="form-control" type="text" placeholder="Board">
										<span class="input-group-btn"> <a
											id="username1_checker" class="btn green" href="javascript:;"
											data-original-title="" title=""> <i class="fa fa-check"></i>
												Choose </a> </span>
									</div>-->
								</div>
								<label class="col-md-2 control-label"> Attachment upload
								</label>
								<div class="col-md-3">
									<div class="fileinput fileinput-new" data-provides="fileinput">
										<div class="input-group input-large">
											<div>
												<input type="text" readonly="" name="attachmentname"
													value="${onepaper.attachmentname}" class="form-control" style="width:240px"
													id="attachmentname">
												<!-- 名称 -->
											</div>
											<input type="hidden" name="attachmentid"
												value="${onepaper.attachmentid}" class="form-control"
												id="attachmentid">
											<!-- ID -->
											<input type="hidden" name="attachmentload"
												value="${onepaper.attachmentload}" class="form-control"
												id="targetFilename">
											<!-- 路径 -->
											<span class="input-group-addon btn default btn-file">
												<span > Select file </span>
												<!--<span class="fileinput-new"> Select file </span>
												<span class="fileinput-exists"> Change </span> -->
												<input id="targetFileId" type="file" name="file"
												onchange="GlobalUtil.doChangemvc(this);"> </span> <a
												href="javaScript:;" onclick="GlobalUtil.doRemove(this);"
												class="input-group-addon btn red fileinput-exists"
												id="removeid">Remove </a>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<!-- End Add One Pager Form Content -->
				</div>
				<div class="portlet-body form">
					<div class="form-actions center">
						<div class="row">
							<div class="col-md-12" align="center">
								<button type="button" class="btn btn-success J_menuItem"
									onclick="OnePaper.saveOnePaper();">
									<fmt:message key="PAGE.GEN.SAVE" />
								</button>
								<button type="reset" onclick="SelectUtils.resetSelectVal();"
									class="btn btn-primary" id="onePagerResetBt">
									<fmt:message key="PAGE.GEN.RESET" />
								</button>
							</div>
						</div>
					</div>
				</div>
			</form>
		</div>
		<!-- End Add One Pager Window-->
	</div>
	<!-- End Add One Pager -->
	<br>
	<jsp:include page="../decorate/contentFoot.jsp"></jsp:include>
	<jsp:include page="../decorate/contentFootJS.jsp"></jsp:include>
	<script type="text/javascript"
		src="static/onePaper/scripts/onePaper.js"></script>
	<script type="text/javascript"
		src="static/onePaper/scripts/choosecustomer.js"></script>

	<script type="text/javascript">
		$(document).ready(function() {
			if ($("#targetFilename").val() != "") {
				$(".input-group-addon").removeClass("fileinput-exists");
			}
			;
		});
	</script>
</body>
</html>

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
	<!-- Begin add Ts Signed -->
    <div class="row">
    	<!-- Begin Large container -->
    	<div class="col-md-12">
    		<!-- Begin title Body -->
    		<div class="portlet box green">
    			<!-- Begin title and tools -->
    			<div class="portlet-title">
    				<div class="caption">
						<i class="fa fa-gift"></i>
						Save Ts Signed
					</div>
					<div class="tools">
						<!-- <a class="collapse" href="javascript:;" data-original-title="" title=""> </a> -->
					</div>
    			</div>
    			<!-- End title and tools -->
    			<!-- Begin Form -->
    			<div class="portlet-body form">
					<form id="tsSigned_EDIT_FORM" action="#" class="form-horizontal form-row-seperated" method="post">
					<input type="hidden" name="paperId" value="${tsSigned.paperId }"/>
					<input type="hidden" name="tsSignedId" value="${tsSigned.tsSignedId }"/>
						<div class="form-body">
							<div class="form-group">
								<label class="col-md-3 control-label">
									Portfolio name (CH)
								</label>
								<div class="col-md-3">
									<input readonly="readonly" class="form-control" value="${tsSigned.portfolioNameCH }" type="text" placeholder="Portfolio name (CH)">
								</div>
								<label class="col-md-2 control-label">
									Portfolio name (EN)
								</label>
								<div class="col-md-3">
									<input readonly="readonly" class="form-control" value="${tsSigned.portfolioNameEN }" type="text" placeholder="Portfolio name (CH)">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-3 control-label">
									Investment amount
								</label>
								<div class="col-md-3">
									<input class="form-control" type="text" id="investmentAmount" onchange="GlobalUtil.defaultNumberDataForma(this);" name="investmentAmount" value="${tsSigned.investmentAmount }" placeholder="Investment amount">
								</div>
								<label class="col-md-2 control-label">
									Bridge Loan
								</label>
								<div class="col-md-3">
									<select class="js-example-placeholder-single form-control" id="bridgeLoanSelect"  name="bridgeLoan">
										<option value="0" selected="${tsSigned.bridgeLoan==0?'selected':''}">Yes</option>
										<option value="1" selected="${tsSigned.bridgeLoan==1?'selected':''}">No</option>
									</select>
								</div>
							</div>
							<div class="form-group bridgeLoanHide">
								<label class="col-md-3 control-label">
									Date
								</label>
								<div class="col-md-3">
									<div class="input-group date date-picker"  data-date-format="yyyy/mm/dd">
										<input class="form-control" type="text" readonly="" name="investDate" value="${tsSigned.investDate }" >
										<span class="input-group-btn">
											<button class="btn default" type="button">
												<i class="fa fa-calendar"></i>
											</button>
										</span>
									</div>
								</div>
								<label class="col-md-2 control-label">
									amount 
								</label>
								<div class="col-md-3">
									<input class="form-control" type="text" name="amount" id="amount"  onchange="GlobalUtil.defaultNumberDataForma(this);" value="${tsSigned.amount }" placeholder="amount">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-3 control-label">
									Date of Sign
								</label>
								<div class="col-md-3">
									<div class="input-group date date-picker"  data-date-format="yyyy/mm/dd">
										<input class="form-control" type="text" name="signDate" disabled="disabled" value="${tsSigned.signDate }" >
										<span class="input-group-btn">
											<button class="btn default" type="button">
												<i class="fa fa-calendar"></i>
											</button>
										</span>
									</div>
								</div>
								<label class="col-md-2 control-label">
									Sector
								</label>
								<div class="col-md-3">
									<select disabled="disabled" class="js-example-placeholder-single form-control" id="sectorid" name="sectorId">
									<option value="">Please choose a Sector</option>
										<c:forEach items="${secsector}" var="se">
											<option value="${se.code}"
												<c:if test="${tsSigned.sectorId==se.code}">selected</c:if>>${se.display}</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-3 control-label">
									Fund
								</label>
								<div class="col-md-3">
									<select disabled="disabled" class="js-example-placeholder-single form-control" id="fundid" name="fundId">
									<option value="">Please choose a Fund</option>
										<c:forEach items="${secfund}" var="sef">
											<option value="${sef.code}"
												<c:if test="${tsSigned.fundId==sef.code}">selected</c:if>>${sef.display}</option>
										</c:forEach>
									</select>
								</div>
								<label class="col-md-2 control-label">
									Type
								</label>
								<div class="col-md-3">
									<select class="js-example-placeholder-single form-control" name="typeId">
									<option value="">Please choose a Type</option>
										<c:forEach items="${tsType}" var="sef">
											<option value="${sef.code}"
												<c:if test="${tsSigned.typeId==sef.code}">selected</c:if>>${sef.display}</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-3 control-label">
									Type of Security
								</label>
								<div class="col-md-3">
									<select class="js-example-placeholder-single form-control" name="typeSecurityId">
									<option value="">Please choose a Type of Security</option>
										<c:forEach items="${security}" var="sef">
											<option value="${sef.code}"
												<c:if test="${tsSigned.typeSecurityId==sef.code}">selected</c:if>>${sef.display}</option>
										</c:forEach>
									</select>
								</div>
								<label class="col-md-2 control-label">
									Deal partner 1
								</label>
								<div class="col-md-3">
									<input disabled="disabled" class="form-control" type="text" name="dealPartnerOne" value="${tsSigned.dealPartnerOne }" placeholder="Deal partner 1">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-3 control-label">
									Deal partner 2
								</label>
								<div class="col-md-3">
									<input disabled="disabled" class="form-control" type="text" name="dealPartnerTwo" value="${tsSigned.dealPartnerTwo }" placeholder="Deal partner 2">
								</div>
								<label class="col-md-2 control-label">
									Deal partner 3
								</label>
								<div class="col-md-3">
									<input disabled="disabled" class="form-control" type="text" name="dealPartnerThi" value="${tsSigned.dealPartnerThi }" placeholder="Deal partner 3">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-2 control-label">
									Ownership
								</label>
								<div class="col-md-2" style="width: 10%;">
									<label class="radio-inline">
									<input type="radio" name="ownerShip" id="optionsRadios" value="0"/> N </label>
									<label class="radio-inline">
									<input type="radio" name="ownerShip" id="optionsRadios" value="1"/> Y </label>
								</div>
								<div class="col-md-8">
									<input  class="form-control" value="${tsSigned.ownerShipRemark }" name="ownerShipRemark" type="text" placeholder="">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-2 control-label">
									Liquidation preference
								</label>
								<div class="col-md-2" style="width: 10%;">
									<label class="radio-inline">
									<input type="radio" name="preference" id="optionsRadios" value="0"/> N </label>
									<label class="radio-inline">
									<input type="radio" name="preference" id="optionsRadios" value="1"/> Y </label>
								</div>
								<div class="col-md-8">
									<input  class="form-control" value="${tsSigned.preferenceRemark }" name="preferenceRemark" type="text" placeholder="">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-2 control-label">
									Redemption
								</label>
								<div class="col-md-2" style="width: 10%;">
									<label class="radio-inline">
									<input type="radio" name="redemption" id="optionsRadios" value="0"/> N </label>
									<label class="radio-inline">
									<input type="radio" name="redemption" id="optionsRadios" value="1"/> Y </label>
								</div>
								<div class="col-md-8">
									<input  class="form-control" value="${tsSigned.redemptionRemark }" name="redemptionRemark" type="text" placeholder="">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-2 control-label">
									Board of director
								</label>
								<div class="col-md-2" style="width: 10%;">
									<label class="radio-inline">
									<input type="radio" name="boardDirector" id="optionsRadios" value="0"/> N </label>
									<label class="radio-inline">
									<input type="radio" name="boardDirector" id="optionsRadios" value="1"/> Y </label>
								</div>
								<div class="col-md-8">
									<input  class="form-control" value="${tsSigned.boarDirectoRemark }" name="boarDirectoRemark" type="text" placeholder="">
								</div>
							</div>
							<%--<div class="form-group">
								<label class="col-md-3 control-label">
									Remark
								</label>
								<div class="col-md-8">
									<textarea class="form-control" rows="5" style="resize:none"></textarea>
								</div>
							</div>
							--%><div class="form-group">
								<label class="col-md-3 control-label">
									TS Signed Upload
								</label>
								<div class="col-md-3">
									<div class="fileinput fileinput-new" data-provides="fileinput">
										<div class="input-group input-large">
											<div >
												<input style="width:270px" type="text" readonly="" name="attachmentname" value="${tsSigned.attachmentname}" class="form-control"  id="attachmentname"><!-- 名称 -->
											</div>
											<input type="hidden" name="attachmentid" value="${tsSigned.attachmentid}" class="form-control"  id="attachmentid"><!-- ID -->
											<input type="hidden" name="attachmentload" value="${tsSigned.attachmentload}" class="form-control"  id="targetFilename"><!-- 路径 -->
											<span class="input-group-addon btn default btn-file">
											<span > Select file </span>
											<!-- <span class="fileinput-new"> Select file </span> <span class="fileinput-exists"> Change </span>   -->
												<input id="targetFileId" type="file" name="file" onchange="GlobalUtil.doChangemvc(this);"> 
											</span>
											<a href="javaScript:;" onclick="GlobalUtil.doRemove(this);" class="input-group-addon btn red fileinput-exists" id="removeid" >Remove </a>
										</div>
									</div>
								</div>
							</div>
							<div class="form-group bridgeLoanHide">
								<label class="col-md-3 control-label">
									Bridge Loab Remark
								</label>
								<div class="col-md-3">
									<textarea name="bridgeLoanRemark" class="form-control autosizeme" rows="5"
										placeholder="Bridge Loab Remark ...">${tsSigned.bridgeLoanRemark }</textarea>
								</div>
							</div>
						</div>
					</form>
	   			</div>
    			<!-- End Form -->
    		</div>
    		<!-- End title Body -->
    		<div class="portlet-body form">
				<div class="form-actions center">
					<div class="row">
						<div class="col-md-12" align="center">
							<button type="button" class="btn btn-success J_menuItem" onclick="tsSigned.saveTsSigned();" id="onePagerAddBt">
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
    	<!-- Begin Large container -->
    </div>
    <!-- End add Ts Signed -->
    <br>
    <jsp:include page="../decorate/contentFoot.jsp"></jsp:include>
    <jsp:include page="../decorate/contentFootJS.jsp"></jsp:include>
    <script type="text/javascript" src="static/tsSigned/scripts/tsSigned.js"></script>
    <script type="text/javascript">
    	$(function() {
    		var bridgeLoan = '${tsSigned.bridgeLoan}';
    		var tsId = '${tsSigned.tsSignedId}';
    		if (tsId != 'undefined') {
    			if (bridgeLoan == 'undefined') bridgeLoan = 0;
    			SelectUtils.setSelectVal($("#bridgeLoanSelect"), bridgeLoan);
    			tsSigned.bridgeLoanSelect();
    		} else {
    			SelectUtils.setSelectVal($("#bridgeLoanSelect"), 0);
    			tsSigned.bridgeLoanSelect();
    		}
    		if($("#targetFilename").val()!=""){
    			 $(".input-group-addon").removeClass("fileinput-exists");
    		};
    		//所有权
    		checkedRradio("ownerShip",'${tsSigned.ownerShip}');
    		//清算优先权
    		checkedRradio("preference",'${tsSigned.preference}');
    		//是否赎回
    		checkedRradio("redemption",'${tsSigned.redemption}');
    		//是否董事局
    		checkedRradio("boardDirector",'${tsSigned.boardDirector}');
    	});
    </script>
</body>
</html>

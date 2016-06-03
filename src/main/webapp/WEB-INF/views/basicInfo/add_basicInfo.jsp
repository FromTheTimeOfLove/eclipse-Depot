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
<link href="static/basicInfo/css/base2.css" rel="stylesheet" type="text/css" />
</head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<body>
	<div class="row">
		<div class="col-md-12">
			<div class="top-tree">
		 		<ul>
		 		 	<c:forEach items="${dataResults }" var="r" varStatus="sta">
		 		 		<li>
		 		 			<c:choose>
		 		 				<c:when test="${r.type == '1' }">
		 		 					<div class="current">
		 		 						<a href="javascript:;" onclick="BasicInfo.editbasicInfoBtId('${r.code }');">${r.display }</a>
		 		 					</div>
		 		 				</c:when>
		 		 				<c:otherwise>
		 		 					<a href="javascript:;" onclick="BasicInfo.editbasicInfoBtId('${r.code }');">${r.display }</a>
		 		 				</c:otherwise>
		 		 			</c:choose>
		 		 		</li>
		 		 	</c:forEach>
		 		</ul>
		 	</div>
 		</div>
 	</div>
    <form id="basicInfoSaveForm" enctype="multipart/form-data" target="hidden_frame">
    	<c:choose>
    		<c:when test="${basicInfo.nextIndex == null || basicInfo.nextIndex == ''}">
    			<input type="hidden" name="nextIndex" value="1">
    		</c:when>
    		<c:otherwise>
    			<input type="hidden" name="nextIndex" value="${basicInfo.nextIndex }">
    		</c:otherwise>
    	</c:choose>
		<input type="hidden" id="universalStr" value="${universalStr }">
		<input type="hidden" name="paperId" value="${onePaper.paperid }">
		<input type="hidden" name="basicInfoId" value="${basicInfo.basicInfoId }">
	    <!-- SPA Signed -->
	    <div class="portlet box green">
			<div class="portlet-title">
				<div class="caption">
					<i class="fa fa-table"></i>Basic Info
				</div>
				<div class="tools">
				</div>
			</div>
			<div class="portlet-body">
				<div class="portlet-tabs">
					<ul class="nav nav-tabs nav-justified">
						<li class="active">
							<a href="#basicInfo_tab" dom-id="basicInfo_tab" data-toggle="tab">Basic info</a>
						</li>
						<li>
							<a href="javascript:;" dom-id="preSigning_tab">Pre-signing</a>
						</li>
						<li>
							<a href="javascript:;" dom-id="preFundig_tab">Pre-funding</a>
						</li>
					</ul>
					<div class="tab-content">
						<div class="tab-pane active" id="basicInfo_tab">
							<!-- basic info表单 -->
							<div class="row">
								<div class="col-md-12">
									<br>
									<div class="portlet">
										<div class="portlet-title">
											<div class="caption">
												<i class="fa fa-table"></i>Basic info
											</div>
											<div class="tools">
												<a href="javascript:;" class="collapse" data-original-title="" title="">
												</a>
											</div>
										</div>
										<div class="portlet-body">
											<div class="form-horizontal" role="form">
												<br>
												<div class="form-group">
													<label class="col-md-3 control-label">Portfolio name(CH)<span class="required" aria-required="true"> * </span></label>
													<div class="col-md-3">
														<input type="text" readonly="true" class="form-control" value="${onePaper.portfolionameCH }">
													</div>
													<label class="col-md-2 control-label">Portfolio name(EN)<span class="required" aria-required="true"> * </span></label>
													<div class="col-md-3">
														<input type="text" readonly="true" class="form-control" value="${onePaper.portfolionameEN }">
													</div>
												</div>
												<br>
												<div class="form-group">
													<label class="col-md-3 control-label">
														Date of funding
													</label>
													<div class="col-md-3">
														<div class="input-group date date-picker"
															 data-date-format="yyyy-mm-dd">
															<input class="form-control" type="text" readonly="true" name="fundingDate"
																value="${basicInfo.fundingDate }"> <span
																class="input-group-btn">
																<button class="btn default" type="button">
																	<i class="fa fa-calendar"></i>
																</button> </span>
														</div>
													</div>
													<label class="col-md-2 control-label">
														Date of Sign
													</label>
													<div class="col-md-3">
														<div class="input-group date date-picker"  data-date-format="yyyy-mm-dd">
															<input class="form-control"  type="text" value="${onePaper.dpdate }" disabled="disabled"> 
															<span class="input-group-btn">
																<button class="btn default" type="button" disabled="disabled">
																	<i class="fa fa-calendar"></i>
																</button> 
															</span>
														</div>
													</div>
												</div>
												<br>
												<div class="form-group">
													<label class="col-md-3 control-label">
														Fund
													</label>
													<div class="col-md-3">
														<select disabled="true" class="js-example-placeholder-single form-control" style="width: 304px">
															<option value>Please choose a Fund</option>
															<c:forEach items="${fundDatas }" var="l">
																<c:choose>
																	<c:when test="${l.code == onePaper.fundid }">
					                                        			<option value="${l.code }" selected="selected">${l.display }</option>
																	</c:when>
																	<c:otherwise>
					                                        			<option value="${l.code }">${l.display }</option>
																	</c:otherwise>
																</c:choose>
					                                        </c:forEach>
														</select>
													</div>
													<label class="col-md-2 control-label">
														Sector
													</label>
													<div class="col-md-3">
														<select disabled="true"  class="js-example-placeholder-single form-control" style="width: 304px">
															<option value>Please choose a Sector</option>
															<c:forEach items="${sectorDatas }" var="l">
																<c:choose>
																	<c:when test="${l.code == onePaper.sectorid }">
					                                        			<option value="${l.code }" selected="selected">${l.display }</option>
																	</c:when>
																	<c:otherwise>
					                                        			<option value="${l.code }">${l.display }</option>
																	</c:otherwise>
																</c:choose>
					                                        </c:forEach>
														</select>
													</div>
												</div>
												<br>
												<div class="form-group">
													<label class="col-md-3 control-label">
														Deal partner 1
													</label>
													<div class="col-md-3">
														<input type="text" readonly="true" value="${onePaper.dealpartnerone }" class="form-control" placeholder="Deal partner 1">
													</div>
													<label class="col-md-2 control-label">
														Deal partner 2
													</label>
													<div class="col-md-3">
														<input type="text" readonly="true" value="${onePaper.dealpartnertwo }" class="form-control" placeholder="Deal partner 2">
													</div>
												</div>
												<br>
												<div class="form-group">
													<label class="col-md-3 control-label">
														Deal partner 3
													</label>
													<div class="col-md-3">
														<input type="text" readonly="true" value="${onePaper.dealpartnerthi }" class="form-control" placeholder="Deal partner 3">
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
							<!-- end basic info表单 -->
							<div class="form-group" align="center">
								<button type="button" class="btn btn-success J_menuItem" onclick="GlobalUtil.nextTab(this);">
									<fmt:message key="PAGE.GEN.NEXT" />
								</button>
							</div>
						</div>
						<div class="tab-pane" id="preSigning_tab">
							<div class="row">
								<div class="col-md-12">
									<br>
									<div class="portlet">
										<div class="portlet-title">
											<div class="caption">
												<i class="fa fa-table"></i>Deal Related
											</div>
											<div class="tools">
												<a href="javascript:;" class="collapse" data-original-title="" title="">
												</a>
											</div>
										</div>
										<div class="portlet-body">
											<div class="form-horizontal" role="form">
												<br>
												<div class="form-group">
													<label  class="col-md-4 control-label">Chinese Deal Name and Chinese Company Name</label>
													<div class="col-md-7">
														<input  class="form-control" readonly="true" value="${onePaper.portfolionameCH }" type="text" placeholder="">
													</div>
												</div>
												<br>
												<div class="form-group">
													<label  class="col-md-3 control-label">Bridge loan memo and One Pager</label>
													<div class="col-md-3">
														<span id="bridgeLoan" data-filename="onepBridgeLoan"></span>
													</div>
													<label  class="col-md-2 control-label">Sector/Industry</label>
													<div class="col-md-3">
														<select  disabled="true" class="js-example-placeholder-single" style="width: 304px">
															<option value>Please choose a Sector/Industry</option>
															<c:forEach items="${sectorDatas }" var="l">
																<c:choose>
																	<c:when test="${l.code == onePaper.sectorid }">
					                                        			<option value="${l.code }" selected="selected">${l.display }</option>
																	</c:when>
																	<c:otherwise>
					                                        			<option value="${l.code }">${l.display }</option>
																	</c:otherwise>
																</c:choose>
					                                        </c:forEach>
														</select>
													</div>
												</div>
												<div class="form-group">
													<label class="col-md-3 control-label">Neil's approval to sign P-note</label>
													<div class="col-md-3">
														<label class="radio-inline">
														<input type="radio" name="isApprovalSign" value="0" <c:if test="${basicInfo.isApprovalSign == 0 }">checked="true"</c:if>> Y </label>
														<label class="radio-inline">
														<input type="radio" name="isApprovalSign" value="1" <c:if test="${basicInfo.isApprovalSign == 1 }">checked="true"</c:if>> N </label>
													</div>
													<label class="col-md-2 control-label">
														Deal partner
													</label>
													<div class="col-md-3">
														<input type="text" readonly="readonly" value="${basicInfo.dealPartner }" class="form-control" placeholder="Deal partner">
													</div>
												</div>
												<br>
												<div class="form-group">
													<label class="col-md-3 control-label">
														Pre money valuation
													</label>
													<div class="col-md-3">
														<input type="text" name="preMoney" placeholder="Pre money valuation" onblur="GlobalUtil.defaultNumberDataForma(this);" value="${basicInfo.preMoney }" class="form-control">
													</div>
													<label class="col-md-2 control-label">
														Post money valuation
													</label>
													<div class="col-md-3">
														<input type="text" name="postMoney" placeholder="Post money valuation" onblur="GlobalUtil.defaultNumberDataForma(this);" value="${basicInfo.postMoney }" class="form-control">
													</div>
												</div>
												<br>
												<div class="form-group">
													<label class="col-md-3 control-label">
														Compliance Checklist
													</label>
													<div class="col-md-3">
														<div class="input-group" style="text-align:left">
															<!-- <input class="form-control" type="text" placeholder="Compliance Checklist"> -->
															<span class="input-group-btn hide-show"> 
																<a onclick="BasicInfo.dealTeamWindow_com(this);" class="btn green" href="javascript:;" data-original-title="" title=""> 
																	<c:choose>
																		<c:when test="${comPlianceDeal != null && comPlianceDeal != ''}">
																			<i class="fa fa-check-circle"></i>
																		</c:when>
																		<c:otherwise>
																			<i class="fa fa-question-circle"></i>
																		</c:otherwise>
																	</c:choose>
																	Checklist
																</a> 
																<input id="complianceDeal" value="${comPlianceDeal }" type="hidden"> 
															</span>
														</div>
													</div>
													<label class="col-md-2 control-label">
														P-note Confirmation
													</label>
													<div class="col-md-3">
														<div class="input-group" style="text-align:left">
															<!-- <input class="form-control" type="text" placeholder="P-note Confirmation"> -->
															<span class="input-group-btn hide-show"> 
																<a onclick="BasicInfo.dealTeamWindow(this);" class="btn green" href="javascript:;" data-original-title="" title=""> 
																	<c:choose>
																		<c:when test="${confirmationDeal != null && confirmationDeal != ''}">
																			<i class="fa fa-check-circle"></i>
																		</c:when>
																		<c:otherwise>
																			<i class="fa fa-question-circle"></i>
																		</c:otherwise>
																	</c:choose>
																	Confirmation 
																</a> 
																<input id="confirmationDeal" value="${confirmationDeal }" type="hidden"> 
															</span>
														</div>
													</div>
												</div>
												<br>
												<div class="form-group">
													<label class="col-md-3 control-label">
														name
													</label>
													<div class="col-md-3">
														<input type="text" name="contactsName" value="${basicInfo.contactsName }" class="form-control" placeholder="name">
													</div>
													<label class="col-md-2 control-label">
														email
													</label>
													<div class="col-md-3">
														<input type="text" name="contactsEmail" value="${basicInfo.contactsEmail }" class="form-control" placeholder="email">
													</div>
												</div>
												<br>
												<div class="form-group">
													<label class="col-md-3 control-label">
														English address with area code
													</label>
													<div class="col-md-3">
														<input type="text" name="codeAddressEN" value="${basicInfo.codeAddressEN }" class="form-control" placeholder="English address with area code">
													</div>
													<label class="col-md-2 control-label">
														phone
													</label>
													<div class="col-md-3">
														<input type="text" name="contactsPhone" value="${basicInfo.contactsPhone }" class="form-control" placeholder="phone">
													</div>
												</div>
												<br>
												<div class="form-group">
													<label class="col-md-3 control-label">
														Expected return
													</label>
													<div class="col-md-3">
														<input type="text" name="expectedReturn" onblur="GlobalUtil.defaultNumberDataForma(this);" value="${basicInfo.expectedReturn }" class="form-control" placeholder="Expected return">
													</div>
													<label class="col-md-2 control-label">
														Development stage
													</label>
													<div class="col-md-3">
														<select class="js-example-placeholder-single" style="width: 304px" name="developmentStage.code">
															<option value>Please choose a Development stage</option>
															<c:forEach items="${developmentStageDatas }" var="l">
																<c:choose>
																	<c:when test="${l.code == basicInfo.developmentStage.code }">
					                                        			<option value="${l.code }" selected="selected">${l.display }</option>
																	</c:when>
																	<c:otherwise>
					                                        			<option value="${l.code }">${l.display }</option>
																	</c:otherwise>
																</c:choose>
					                                        </c:forEach>
														</select>
													</div>
												</div>
												<br>
												<div class="form-group">
													<label  class="col-md-3 control-label">Latest financial statements</label>
													<div class="col-md-3">
														<span id="l_f_Statements" data-filename="latestFinancialStatements"></span>
													</div>
													<label class="col-md-2 control-label">
														Investment Stage
													</label>
													<div class="col-md-3">
														<select class="js-example-placeholder-single" style="width: 304px" name="investmentStage.code">
															<option value>Please choose a Investment Stage</option>
															<c:forEach items="${investMentStageDatas }" var="l">
																<c:choose>
																	<c:when test="${l.code == basicInfo.investmentStage.code }">
					                                        			<option value="${l.code }" selected="selected">${l.display }</option>
																	</c:when>
																	<c:otherwise>
					                                        			<option value="${l.code }">${l.display }</option>
																	</c:otherwise>
																</c:choose>
					                                        </c:forEach>
														</select>
													</div>
												</div>
												<br>
												<div class="form-group">
													<label class="col-md-3 control-label">
														FDD Member(If any)
													</label>
													<div class="col-md-3">
														<select class="js-example-placeholder-single" style="width: 304px" name="fddMember.code">
															<option value>Please choose a FDD Member</option>
															<c:forEach items="${fddMemberDatas }" var="l">
																<c:choose>
																	<c:when test="${l.code == basicInfo.fddMember.code }">
					                                        			<option value="${l.code }" selected="selected">${l.display }</option>
																	</c:when>
																	<c:otherwise>
					                                        			<option value="${l.code }">${l.display }</option>
																	</c:otherwise>
																</c:choose>
					                                        </c:forEach>
														</select>
													</div>
													<label  class="col-md-2 control-label">Deal source</label>
													<div class="col-md-3">
														<select class="js-example-placeholder-single" style="width: 304px" name="dealSource.code">
															<option value>Please choose a Deal source</option>
															<c:forEach items="${dealSourceDatas }" var="l">
																<c:choose>
																	<c:when test="${l.code == basicInfo.dealSource.code }">
					                                        			<option value="${l.code }" selected="selected">${l.display }</option>
																	</c:when>
																	<c:otherwise>
					                                        			<option value="${l.code }">${l.display }</option>
																	</c:otherwise>
																</c:choose>
					                                        </c:forEach>
														</select>
													</div>
												</div>
												<br>
												<div class="form-group">
													<label  class="col-md-3 control-label">FDD Report(if applicable)</label>
													<div class="col-md-3">
														<span id="fddReport" data-filename="fddReport"></span>
													</div>
												</div>
												<br>
												<div class="form-group">
													<label  class="col-md-3 control-label">business description (Chinese)</label>
													<div class="col-md-8">
														<textarea class="form-control" name="businessDescriptionCH" rows="3">${basicInfo.businessDescriptionCH }</textarea>
													</div>
												</div>
												<br>
												<div class="form-group">
													<label class="col-md-3 control-label">business description (English)</label>
													<div class="col-md-8">
														<textarea class="form-control" name="businessDescriptionEN" rows="3">${basicInfo.businessDescriptionEN }</textarea>
													</div>
												</div>
											</div>
										</div>
									</div>
									<div class="portlet">
										<div class="portlet-title">
											<div class="caption">
												<i class="fa fa-table"></i>Marketing Related
											</div>
											<div class="tools">
												<a href="javascript:;" class="collapse" data-original-title="" title="">
												</a>
											</div>
										</div>
										<div class="portlet-body">
											<div class="form-horizontal" role="form">
												<div class="form-group">
													<label class="col-md-3 control-label">Are we the lead investor?</label>
													<div class="col-md-3">
														<label class="radio-inline">
														<input type="radio" name="isLeadInvestor" value="0" <c:if test="${basicInfo.isLeadInvestor == 0 }">checked="true"</c:if>> Y </label>
														<label class="radio-inline">
														<input type="radio" name="isLeadInvestor" value="1" <c:if test="${basicInfo.isLeadInvestor == 1 }">checked="true"</c:if>> N </label>
													</div>
													<label class="col-md-3 control-label">is it in stealth mode?</label>
													<div class="col-md-3">
														<label class="radio-inline">
														<input type="radio" name="isStealthMode" value="0" <c:if test="${basicInfo.isStealthMode == 0 }">checked="true"</c:if>> Y </label>
														<label class="radio-inline">
														<input type="radio" name="isStealthMode" value="1" <c:if test="${basicInfo.isStealthMode == 1 }">checked="true"</c:if>> N </label>
													</div>
												</div>
												<br>
												<div class="form-group">
													<label class="col-md-3 control-label">Onshore entity location (City)</label>
													<div class="col-md-3">	
														<input type="text" name="onshoreEntityCity" class="form-control" placeholder="" id="boardid" value="${basicInfo.onshoreEntityCity}">
													</div>
												</div>
											</div>
										</div>
									</div>
									<div class="portlet">
										<div class="portlet-title">
											<div class="caption">
												<i class="fa fa-table"></i>Legal Team
											</div>
											<div class="tools">
												<a href="javascript:;" class="collapse" data-original-title="" title="">
												</a>
											</div>
										</div>
										<div class="portlet-body">
											<div class="form-horizontal" role="form">
												<br>
												<div class="form-group">
													<label class="col-md-3 control-label">
														Compliance Checklist
													</label>
													<div class="col-md-3">
														<div class="input-group" style="text-align:left">
															<!-- <input class="form-control" type="text" placeholder="Compliance Checklist"> -->
															<span class="input-group-btn show-hide"> 
																<a onclick="BasicInfo.legalTeamWindow_com(this);" class="btn green" href="javascript:;" data-original-title="" title=""> 
																	<c:choose>
																		<c:when test="${comPlianceLegal != null && comPlianceLegal != ''}">
																			<i class="fa fa-check-circle"></i>
																		</c:when>
																		<c:otherwise>
																			<i class="fa fa-question-circle"></i>
																		</c:otherwise>
																	</c:choose>
																	Checklist
																</a> 
																<input id="complianceLegal" value="${comPlianceLegal }" type="hidden"> 
															</span>
														</div>
													</div>
													<label class="col-md-2 control-label">
														P-note Confirmation
													</label>
													<div class="col-md-3">
														<div class="input-group" style="text-align:left">
															<!-- <input class="form-control" type="text" placeholder="P-note Confirmation"> -->
															<span class="input-group-btn show-hide"> 
																<a onclick="BasicInfo.legalTeamWindow(this);" class="btn green" href="javascript:;" data-original-title="" title=""> 
																	<c:choose>
																		<c:when test="${confirmationLegal != null && confirmationLegal != ''}">
																			<i class="fa fa-check-circle"></i>
																		</c:when>
																		<c:otherwise>
																			<i class="fa fa-question-circle"></i>
																		</c:otherwise>
																	</c:choose>
																	Confirmation
																</a> 
																<input id="confirmationLegal" value="${confirmationLegal }" type="hidden"> 
															</span>
														</div>
													</div>
												</div>
												<br>
												<div class="form-group">
													<label  class="col-md-3 control-label">LDD Report(if applicable)</label>
													<div class="col-md-3">
														<span id="lddReport" data-filename="lddReport"></span>
													</div>
													<label  class="col-md-2 control-label">Group Chart</label>
													<div class="col-md-3">
														<span id="groupChart" data-filename="groupChart"></span>
													</div>
												</div>
											</div>
										</div>
									</div>
									<div class="portlet">
										<div class="portlet-title">
											<div class="caption">
												<i class="fa fa-table"></i>Finance Yeam
											</div>
											<div class="tools">
												<a href="javascript:;" class="collapse" data-original-title="" title="">
												</a>
											</div>
										</div>
										<div class="portlet-body">
											<div class="form-horizontal" role="form">
												<div class="form-group">
													<label  class="col-md-4 control-label">Cayman Directors’ approval to sign P-note (USD Fund)</label>
													<div class="col-md-3">
														<label class="radio-inline">
														<input type="radio" name="isUsdFund" value="0" <c:if test="${basicInfo.isUsdFund == 0 }">checked="true"</c:if>> Y </label>
														<label class="radio-inline">
														<input type="radio" name="isUsdFund" value="1" <c:if test="${basicInfo.isUsdFund == 1 }">checked="true"</c:if>> N </label>
													</div>
												</div>
											</div>
										</div>
									</div>
									<div class="form-group" align="center">
										<button type="button" class="btn btn-success J_menuItem" onclick="GlobalUtil.nextTab(this);">
											<fmt:message key="PAGE.GEN.NEXT" />
										</button>
									</div>
								</div>
							</div>
						</div>
						<div class="tab-pane" id="preFundig_tab">
							<div class="row">
								<div class="col-md-12">
									<br>
									<div class="portlet">
										<div class="portlet-title">
											<div class="caption">
												<i class="fa fa-table"></i>Legal Team
											</div>
											<div class="tools">
												<a href="javascript:;" class="collapse" data-original-title="" title="">
												</a>
											</div>
										</div>
										<div class="portlet-body">
											<div class="form-horizontal" role="form">
												<br>
												<div class="form-group">
													<label  class="col-md-4 control-label">Wire instruction</label>
													<div class="col-md-4">
														<span id="wireInstruction" data-filename="wireInstruction"></span>
													</div>
												</div>
												<div class="form-group">
													<label  class="col-md-4 control-label">repLetter</label>
													<div class="col-md-4">
														<span id="repLetter" data-filename="repLetter"></span>
													</div>
												</div>
												<div class="form-group">
													<label  class="col-md-4 control-label">Fully signed P-note, relevant transaction docs</label>
													<div class="col-md-4">
														<span id="transaction" data-filename="transactionDocs"></span>
													</div>
												</div>
											</div>
										</div>
									</div>
									<div class="portlet">
										<div class="portlet-title">
											<div class="caption">
												<i class="fa fa-table"></i>Finance Team
											</div>
											<div class="tools">
												<a href="javascript:;" class="collapse" data-original-title="" title="">
												</a>
											</div>
										</div>
										<div class="portlet-body">
											<div class="form-horizontal" role="form">
												<br>
												<div class="form-group">
													<label  class="col-md-4 control-label">1.Neil’s approval for funding</label>
													<div class="col-md-3">
														<label class="radio-inline">
														<input type="radio" name="isApprovalFunding" value="0" <c:if test="${basicInfo.isApprovalFunding == 0 }">checked="true"</c:if>> Y </label>
														<label class="radio-inline">
														<input type="radio" name="isApprovalFunding" value="1" <c:if test="${basicInfo.isApprovalFunding == 1 }">checked="true"</c:if>> N </label>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="portlet-body form">
			<div class="form-actions center">
				<div class="row">
					<div class="col-md-12" align="center">
						<button type="button" class="btn btn-success J_menuItem" onclick="BasicInfo.saveBasicInfoDataBefore();" id="basicInfoSaveBt">
							<fmt:message key="PAGE.GEN.SAVE" />
						</button>
						<button type="reset" class="btn btn-primary" onclick="SelectUtils.resetSelectVal();UploadFile.resetUploadVal();BasicInfo.resetSession" id="basicInfoResetBt">
							<fmt:message key="PAGE.GEN.RESET" />
						</button>
					</div>
				</div>
			</div>
		</div>
	</form>
	<br>
	<jsp:include page="../decorate/contentFoot.jsp"></jsp:include>
    <jsp:include page="../decorate/contentFootJS.jsp"></jsp:include>
    <script type="text/javascript" src="static/basicInfo/scripts/basicInfo.js"></script>
	<script type="text/javascript">
		$(function(){
		 	var nextIndex = '${basicInfo.nextIndex }';
			GlobalUtil.editNext(".portlet-tabs", nextIndex);
			var position = '${user.vcPosition}';
			if(position == '101' || position == '102') {
				$(".show-hide").show();
				$(".hide-show").show();
			} else if(position == '103') {
				$(".show-hide").hide();
				$(".hide-show").show();
			} else if(position == '104') {
				$(".show-hide").show();
				$(".hide-show").hide();
			}
			var basicId = $("input[name='basicInfoId']").val();
			if(basicId != undefined && basicId != null) {
				var obj = { 
						fileDivId : "bridgeLoan", fileId : '${basicInfo.onepBridgeLoan.fileId}',
						fileName : '${basicInfo.onepBridgeLoan.fileName}', filePath : '${basicInfo.onepBridgeLoan.filePath}'
					};
				UploadFile.setEditFileValue(obj);
				
				obj = { 
						fileDivId : "l_f_Statements", fileId : '${basicInfo.latestFinancialStatements.fileId}',
						fileName : '${basicInfo.latestFinancialStatements.fileName}', filePath : '${basicInfo.latestFinancialStatements.filePath}' 
					};
				UploadFile.setEditFileValue(obj);
				
				obj = { 
						fileDivId : "lddReport", fileId : '${basicInfo.lddReport.fileId}',
						fileName : '${basicInfo.lddReport.fileName}', filePath : '${basicInfo.lddReport.filePath}',
					};
				UploadFile.setEditFileValue(obj);
				
				obj = { 
						fileDivId : "fddReport", fileId : '${basicInfo.fddReport.fileId}',
						fileName : '${basicInfo.fddReport.fileName}', filePath : '${basicInfo.fddReport.filePath}',
					};
				UploadFile.setEditFileValue(obj);
				
				obj = { 
						fileDivId : "groupChart", fileId : '${basicInfo.groupChart.fileId}',
						fileName : '${basicInfo.groupChart.fileName}', filePath : '${basicInfo.groupChart.filePath}',
					};
				UploadFile.setEditFileValue(obj);
				
				obj = { 
						fileDivId : "wireInstruction", fileId : '${basicInfo.wireInstruction.fileId}',
						fileName : '${basicInfo.wireInstruction.fileName}', filePath : '${basicInfo.wireInstruction.filePath}',
					};
				UploadFile.setEditFileValue(obj);
				
				obj = { 
						fileDivId : "repLetter", fileId : '${basicInfo.repLetter.fileId}',
						fileName : '${basicInfo.repLetter.fileName}', filePath : '${basicInfo.repLetter.filePath}',
					};
				UploadFile.setEditFileValue(obj);
				
				obj = { 
						fileDivId : "transaction", fileId : '${basicInfo.transactionDocs.fileId}',
						fileName : '${basicInfo.transactionDocs.fileName}', filePath : '${basicInfo.transactionDocs.filePath}',
					};
				UploadFile.setEditFileValue(obj);
			}
		});
	</script>
</body>
</html>

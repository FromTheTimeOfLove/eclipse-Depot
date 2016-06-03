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
<link href="static/equityInvestment/css/base2.css" rel="stylesheet" type="text/css" />
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
		 		 						<a href="javascript:;" onclick="EquityInvestment.editEquityInvestmentBtId('${r.code }');">${r.display }</a>
		 		 					</div>
		 		 				</c:when>
		 		 				<c:otherwise>
		 		 					<a href="javascript:;" onclick="EquityInvestment.editEquityInvestmentBtId('${r.code }');">${r.display }</a>
		 		 				</c:otherwise>
		 		 			</c:choose>
		 		 		</li>
		 		 	</c:forEach>
		 		</ul>
		 	</div>
 		</div>
 	</div>
    <form id="equityInvestmentSaveForm" enctype="multipart/form-data" target="hidden_frame">
    	<c:choose>
    		<c:when test="${equityInvestment.nextIndex == null || equityInvestment.nextIndex == ''}">
    			<input type="hidden" name="nextIndex" value="1">
    		</c:when>
    		<c:otherwise>
    			<input type="hidden" name="nextIndex" value="${equityInvestment.nextIndex }">
    		</c:otherwise>
    	</c:choose>
		<input type="hidden" id="universalStr" value="${universalStr }">
		<input type="hidden" name="paperId" value="${onePaper.paperid }">
		<c:if test="${equityInvestment.equityInvestmentId != null and equityInvestment.equityInvestmentId !='' }">
			<input type="hidden" name="equityInvestmentId" value="${equityInvestment.equityInvestmentId }">
		</c:if>
	    <!-- Basic Info -->
	    <div class="portlet box green">
			<div class="portlet-title">
				<div class="caption">
					<i class="fa fa-table"></i>Equity Investment
				</div>
				<div class="tools">
					<a href="javascript:;" class="collapse" data-original-title="" title="">
					</a>
				</div>
			</div>
			<div class="portlet-body">
				<div class="portlet-tabs">
					<ul class="nav nav-tabs nav-justified">
						<li class="active">
							<a href="#basicInfo_tab" data-toggle="tab">Equity Investment</a>
						</li>
						<li>
							<a href="javascript:;" dom-id="preSigning_tab">Pre-signing</a>
						</li>
						<li>
							<a href="javascript:;" dom-id="preFunding_tab">Pre-funding</a>
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
												<i class="fa fa-table"></i>Equity Investment
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
														<input type="text" name="portfolionameCH" readonly="true" class="form-control" value="${onePaper.portfolionameCH }">
													</div>
													<label class="col-md-2 control-label">Portfolio name(EN)<span class="required" aria-required="true"> * </span></label>
													<div class="col-md-3">
														<input type="text" name="portfolionameEN" readonly="true" class="form-control" value="${onePaper.portfolionameEN }">
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
															<input class="form-control" type="text" readonly="true" value="${equityInvestment.fundingDate }" name="fundingDate"> <span
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
															<input class="form-control"  type="text" name="signDate" value="${onePaper.dpdate }" disabled="disabled"> 
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
														<select class="js-example-placeholder-single form-control" style="width: 304px" name="fundData.code" disabled="true">
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
													<label class="col-md-2 control-label">Sector</label>
													<div class="col-md-3">
														<select class="js-example-placeholder-single form-control" style="width: 304px" name="sectorData.code" disabled="true">
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
														<input type="text" name="partnerOne" readonly="true" value="${onePaper.dealpartnerone }" class="form-control" placeholder="Deal partner 1">
													</div>
													<label class="col-md-2 control-label">
														Deal partner 2
													</label>
													<div class="col-md-3">
														<input type="text" name="partnerTwo" readonly="true" value="${onePaper.dealpartnertwo }" class="form-control" placeholder="Deal partner 2">
													</div>
												</div>
												<br>
												<div class="form-group">
													<label class="col-md-3 control-label">
														Deal partner 3
													</label>
													<div class="col-md-3">
														<input type="text" name="partnerThr" readonly="true" value="${onePaper.dealpartnerthi }" class="form-control" placeholder="Deal partner 3">
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
													<label  class="col-md-4 control-label">Chinese Deal Name And Chinese Company Name</label>
													<div class="col-md-6">
														<input  class="form-control" readonly="true" name="dealNameRmark" value="${onePaper.portfolionameCH}" type="text" placeholder="">
													</div>
												</div>
												<br>
												<div class="form-group">	
													<label  class="col-md-3 control-label">Investment memo and One Pager</label>
													<div class="col-md-3">
														<span id="investmentMemoOne" data-filename="memoUpload"></span>
													</div>
													<label class="col-md-2 control-label">
														Neil's approval to sign SPA
													</label>
													<div class="col-md-3">
														<select class="js-example-placeholder-single form-control" style="width: 304px" readonly="readonly" name="equitySignSPA">
															<option value="0" <c:if test="${equityInvestment.equitySignSPA == 0}">selected="selected"</c:if>>yes</option>
															<option value="1" <c:if test="${equityInvestment.equitySignSPA == 1}">selected="selected"</c:if>>no</option>
														</select>
													</div>
												</div>
												<br>
												<div class="form-group">
													<label class="col-md-3 control-label">
														Pre money valuation
													</label>
													<div class="col-md-3">
														<input type="text" placeholder="Pre money valuation" onblur="GlobalUtil.defaultNumberDataForma(this);" 
														name="npreMoney" class="form-control" value="${equityInvestment.npreMoney}">
													</div>
													<label class="col-md-2 control-label">
														Post money valuation
													</label>
													<div class="col-md-3">
														<input type="text" placeholder="Post money valuation" onblur="GlobalUtil.defaultNumberDataForma(this);"
														name="npostMoney" class="form-control" value="${equityInvestment.npostMoney}">
													</div>
												</div>
												<br>
												<div class="form-group">
													<label  class="col-md-3 control-label">Deal partner</label>
													<div class="col-md-3">
														<input type="text" class="form-control" name="equityDealPartner" style="width: 304px" readonly="true" 
														value="${onePaper.dealpartnerone}<c:if test="${onePaper.dealpartnertwo != null}">,${onePaper.dealpartnertwo }</c:if><c:if test="${onePaper.dealpartnerthi != null}">,${onePaper.dealpartnerthi }</c:if>">
													</div>
													<label  class="col-md-2 control-label">Sector/Industry</label>
													<div class="col-md-3">
														<select disabled="disabled" class="js-example-placeholder-single form-control" style="width: 304px" name="sectorOrIndustry">
															<option value>Please choose</option>
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
														USD FUND
													</label>
													<div class="col-md-3">
														<input type="text" onblur="GlobalUtil.defaultNumberDataForma(this);"  
														name="usdFundRemark" class="form-control" value="${equityInvestment.usdFundRemark}">
													</div>
													<label class="col-md-2 control-label">
														Expected return
													</label>
													<div class="col-md-3">
														<input type="text" name="expectedRemark" class="form-control" 
														value="${equityInvestment.expectedRemark}">
													</div>
												</div>
												<br>
												<div class="form-group">
													<label class="col-md-3 control-label">
														Investment Stage
													</label>
													<div class="col-md-3">
														<select class="js-example-placeholder-single form-control" style="width: 304px" readonly="readonly" name="equityInvestmentStage">
															<option value>Please choose a Investment Stage</opntion>
															<c:forEach items="${investmentStageDatas }" var="l">
																<c:choose>
																	<c:when test="${l.code == equityInvestment.equityInvestmentStage }">
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
														Compliance Checklist
													</label>
													<div class="col-md-3">
														<div class="input-group" style="text-align:left">
															<span class="input-group-btn"> 
																<a onclick="EquityInvestment.dealTeamWindow(this);" class="btn green" href="javascript:;" data-original-title="" title=""> 
																	<c:choose>
																		<c:when test="${equityDealTeamStr != null && equityDealTeamStr != ''}">
																			<i class="fa fa-check-circle"></i>
																		</c:when>
																		<c:otherwise>
																			<i class="fa fa-question-circle"></i>
																		</c:otherwise>
																	</c:choose>
																	Deal Team 
																</a> 
																<input type="hidden" id="complianceDeal" value="${equityDealTeamStr}"> 
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
														<input type="text" name="contactName" value="${equityInvestment.contactName}" class="form-control" placeholder="name">
													</div>
													<label class="col-md-2 control-label">
														email
													</label>
													<div class="col-md-3">
														<input type="text" name="contactEmail" value="${equityInvestment.contactEmail}" class="form-control"  placeholder="email">
													</div>
												</div>
												<br>
												<div class="form-group">
													<label class="col-md-3 control-label">
														English address with area code
													</label>
													<div class="col-md-3">
														<input type="text" name="contactAddress" value="${equityInvestment.contactAddress}" class="form-control" placeholder="English address with area code">
													</div>
													<label class="col-md-2 control-label">
														phone
													</label>
													<div class="col-md-3">
														<input type="text" name="contactPhone" value="${equityInvestment.contactPhone}" class="form-control" placeholder="phone" >
													</div>
												</div>
												<br>
												<div class="form-group">
													<label  class="col-md-3 control-label">Development stage</label>
													<div class="col-md-3">
														<select class="js-example-placeholder-single form-control" style="width: 304px" readonly="readonly" name="equityDevelopmentStage">
															<option value>Please choose a Development stage</option>
															<c:forEach items="${developmentStageDatas }" var="l">
																<c:choose>
																	<c:when test="${l.code == equityInvestment.equityDevelopmentStage }">
					                                        			<option value="${l.code }" selected="selected">${l.display }</option>
																	</c:when>
																	<c:otherwise>
					                                        			<option value="${l.code }">${l.display }</option>
																	</c:otherwise>
																</c:choose>
					                                        </c:forEach>
														</select>
													</div>
													<label  class="col-md-2 control-label">Latest financial statements</label>
													<div class="col-md-3">
														<span id="l_f_statements" data-filename="financialUpload"></span>
													</div>
												</div>
												<br>
												<div class="form-group">
													<label  class="col-md-3 control-label">Cap Table</label>
													<div class="col-md-3">
														<span id="capTable" data-filename="capTableUpload"></span>
													</div>
													<label  class="col-md-2 control-label">FDD report</label>
													<div class="col-md-3">
														<span id="fddReport" data-filename="fddReportUpload"></span>
													</div>
												</div>
												<br>
												<div class="form-group">
													<label  class="col-md-3 control-label">FDD member (if any)</label>
													<div class="col-md-3">
														<select class="js-example-placeholder-single form-control" style="width: 304px" readonly="readonly" name="fddId">
															<option value>Please choose a FDD member</option>
															<c:forEach items="${userDatas }" var="l">
																<c:choose>
																	<c:when test="${l.code == equityInvestment.fddId }">
					                                        			<option value="${l.code }" selected="selected">${l.display }</option>
																	</c:when>
																	<c:otherwise>
					                                        			<option value="${l.code }">${l.display }</option>
																	</c:otherwise>
																</c:choose>
					                                        </c:forEach>
														</select>
													</div>
													<label  class="col-md-2 control-label">BOD</label>
													<div class="col-md-3">
														<select class="js-example-placeholder-single form-control" style="width: 304px" readonly="readonly" name="bodId">
															<option value>Please choose a BOD</option>
															<c:forEach items="${userDatas }" var="l">
																<c:choose>
																	<c:when test="${l.code == equityInvestment.bodId }">
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
													<label  class="col-md-3 control-label">Deal source</label>
													<div class="col-md-3">
														<select class="js-example-placeholder-single form-control" style="width: 304px" readonly="readonly" name="equityDealSource">
															<option value>Please choose a Deal source</option>
															<c:forEach items="${dealSourceDatas }" var="l">
																<c:choose>
																	<c:when test="${l.code == equityInvestment.equityDealSource}">
					                                        			<option value="${l.code }" selected="selected">${l.display }</option>
																	</c:when>
																	<c:otherwise>
					                                        			<option value="${l.code }">${l.display }</option>
																	</c:otherwise>
																</c:choose>
					                                        </c:forEach>
														</select>
													</div>
													<label  class="col-md-2 control-label">Investment Status</label>
													<div class="col-md-3">
														<select class="js-example-placeholder-single form-control" style="width: 304px" readonly="readonly" name="equityInvestmentStatus">
															<option value>Please choose a Investment Status</option>
															<c:forEach items="${investmentStatusDatas }" var="l">
																<c:choose>
																	<c:when test="${l.code == equityInvestment.equityInvestmentStatus}">
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
													<label  class="col-md-3 control-label">Co-investors (if any)</label>
													<div class="col-md-3">
														<input type="text" class="form-control" name="equityInvestors" value="${equityInvestment.equityInvestors}">
													</div>
													<label  class="col-md-2 control-label">Series type</label>
													<div class="col-md-3">
														<input type="text" class="form-control" name="equitySeriesType" value="${equityInvestment.equitySeriesType}">
													</div>
												</div>
												<br/>
												<div class="form-group">
													<label  class="col-md-3 control-label">Expected exit method (IPO, M&A, etc.)</label>
													<div class="col-md-3">
														<input type="text" class="form-control" name="equityExpectedExit" value="${equityInvestment.equityExpectedExit}">
													</div>
													<label  class="col-md-2 control-label">Time to exit</label>
													<div class="col-md-3">
														<div class="input-group date date-picker"
															 data-date-format="yyyy-mm-dd">
															<input class="form-control" type="text" readonly="true" value="${equityInvestment.equityTimeToExit }" name="equityTimeToExit"> <span
																class="input-group-btn">
																<button class="btn default" type="button">
																	<i class="fa fa-calendar"></i>
																</button> </span>
														</div>
													</div>
												</div>
												<br>
												<div class="form-group">
													<label  class="col-md-3 control-label">business description (Chinese)</label>
													<div class="col-md-8">
														<textarea class="form-control" rows="3" name="chineseRmark">${equityInvestment.chineseRmark}</textarea>
													</div>
												</div>
												<br>
												<div class="form-group">
													<label class="col-md-3 control-label">business description (English)</label>
													<div class="col-md-8">
														<textarea class="form-control" rows="3" name="englishRmark">${equityInvestment.englishRmark}</textarea>
													</div>
												</div>
												<br>
												<div class="form-group">
													<label  class="col-md-5 control-label">Deal team to confirm the key terms in the transaction documents</label>
													<div class="col-md-5">
														<label class="radio-inline">
														<input type="radio" name="isEquityKeyTerms" value="0" <c:if test="${equityInvestment.isEquityKeyTerms == 0 }">checked="true"</c:if>> Y </label>
														<label class="radio-inline">
														<input type="radio" name="isEquityKeyTerms" value="1" <c:if test="${equityInvestment.isEquityKeyTerms == 1 }">checked="true"</c:if>> N </label>
													</div>
												</div>	
												<br>											
												<div class="form-group">
													<label  class="col-md-5 control-label">Can we disclose the name of the investment in our Fund’s financials?</label>
													<div class="col-md-5">
														<label class="radio-inline">
														<input type="radio" name="isEquityFinancials" value="0" <c:if test="${equityInvestment.isEquityFinancials == 0 }">checked="true"</c:if>> Y </label>
														<label class="radio-inline">
														<input type="radio" name="isEquityFinancials" value="1" <c:if test="${equityInvestment.isEquityFinancials == 1 }">checked="true"</c:if>> N </label>
													</div>
												</div>
												<br>
												<div class="form-group">
													<label  class="col-md-5 control-label">Broker (if any)</label>
													<div class="col-md-1">
														<label class="radio-inline">
														<input type="radio" name="isEquityBroker" value="0" onclick="changeBroker(this)" <c:if test="${equityInvestment.isEquityBroker == 0 }">checked="true"</c:if>> Y </label>
														<label class="radio-inline">
														<input type="radio" name="isEquityBroker" value="1" onclick="changeBroker(this)" <c:if test="${equityInvestment.isEquityBroker == 1 }">checked="true"</c:if>> N </label>
													</div>
													<div class="col-md-3">
														<input type="text" class="form-control" style="display: none;" name="equityBrokerRemark" id="equityBroker" value="${equityInvestment.equityBrokerRemark }">
													</div>
												</div>
												<br>
												<div class="form-group">
													<label  class="col-md-5 control-label">New Investment Announcement form (Please refer to Appendix 1)</label>
													<div class="col-md-5">
														<label class="radio-inline">
														<input type="radio" name="isEquityAnnouncement" value="0" onclick="changeAnnouncement(this)" <c:if test="${equityInvestment.isEquityAnnouncement == 0 }">checked="true"</c:if>> Y </label>
														<label class="radio-inline">
														<input type="radio" name="isEquityAnnouncement" value="1" onclick="changeAnnouncement(this)" <c:if test="${equityInvestment.isEquityAnnouncement == 1 }">checked="true"</c:if>> N </label>
													</div>
												</div>
												<div class="form-group" style="display: none;" id="equityAnnouncement">
													<label  class="col-md-5 control-label"></label>
													<div class="col-md-5">
														<table class="table table-bordered table-hover">
															<tr>
																<td>Investment rationale: (2-3 sentences)</td>
															</tr>
															<tr>
																<td><textarea rows="3" class="form-control" name="equityRationale">${equityInvestment.equityRationale }</textarea></td>
															</tr>
															<tr>
																<td>Website:</td>
															</tr>
															<tr >
																<td><input type="text" class="form-control" name="equityWebsite" value="${equityInvestment.equityWebsite }"></td>
															</tr>
														</table>
													</div>
												</div>
												<br>
											</div>
										</div>
									</div>
									<br/>
									<div class="portlet">
										<div class="portlet-title">
											<div class="caption">
												<i class="fa fa-table"></i>Online Questionnaire
											</div>
											<div class="tools">
												<a href="javascript:;" class="collapse" data-original-title="" title="">
												</a>
											</div>
										</div>
										<div class="portlet-body">
											<div class="form-horizontal" role="form">
												<div class="form-group">
													<label class="col-md-4">Provide e-mail contact for setting up login details</label>
												</div>
												<div class="form-group">
													<label class="col-md-4">
														<a href="https://essentials.sequoiacap.com/info/" target="_Blank">https://essentials.sequoiacap.com/info/</a>
													</label>
												</div>
											</div>
											<br>
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
													<label  class="col-md-3 control-label">Is it in stealth mode?</label>
													<div class="col-md-3">
														<label class="radio-inline">
														<input type="radio" name="isEquityStealth" value="0" <c:if test="${equityInvestment.isEquityStealth == 0 }">checked="true"</c:if>> Y </label>
														<label class="radio-inline">
														<input type="radio" name="isEquityStealth" value="1" <c:if test="${equityInvestment.isEquityStealth == 1 }">checked="true"</c:if>> N </label>
													</div>
													<label  class="col-md-2 control-label">Are we the lead investor?</label>
													<div class="col-md-3">
														<label class="radio-inline">
														<input type="radio" name="isEquityLeadInvestor" value="0" <c:if test="${equityInvestment.isEquityLeadInvestor == 0 }">checked="true"</c:if>> Y </label>
														<label class="radio-inline">
														<input type="radio" name="isEquityLeadInvestor" value="1" <c:if test="${equityInvestment.isEquityLeadInvestor == 1 }">checked="true"</c:if>> N </label>
													</div>
												</div>
												<br>
												<div class="form-group">
													<label  class="col-md-3 control-label">Onshore entity location (City)</label>
													<div class="col-md-3">
														<input type="text" class="form-control" name="equityOnshore" value="${equityInvestment.equityOnshore }">
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
												<div class="form-group">
													<label  class="col-md-8 control-label">Send out the FCPA questionnaire – at least 5 working days for checking results to be ready</label>
													<div class="col-md-3">
														<span id="questionnaire" data-filename="questionnaireUpload"></span>
													</div>
												</div>
												<br/>											
												<div class="form-group">
													<label  class="col-md-8 control-label">Group Chart(investment structure chart showing all the entities within the Grp; not the internal organization chart) 3.Legal Opinion for all investments(no waiver):</label>
													<div class="col-md-3" id="groupChartUpload">
														<span id="groupChart" data-filename="groupChartUpload"></span>
													</div>
												</div>
												<br/>
												<div class="form-group">
													<label  class="col-md-8 control-label">LDD report</label>
													<div class="col-md-3" id="lddReportUpload">
														<span id="lddReport" data-filename="lddReportUpload"></span>
													</div>
												</div>
												<br/>
												<div class="form-group">
													<label  class="col-md-3 control-label">GDOT/FCPA </label>
													<div class="col-md-3">
														<label class="radio-inline">
														<input type="radio" name="isEquityGDOTOrFCPA" value="0" <c:if test="${equityInvestment.isEquityGDOTOrFCPA == 0 }">checked="true"</c:if>> Y </label>
														<label class="radio-inline">
														<input type="radio" name="isEquityGDOTOrFCPA" value="1" <c:if test="${equityInvestment.isEquityGDOTOrFCPA == 1 }">checked="true"</c:if>> N </label>
													</div>
													<label class="col-md-2 control-label">
														Compliance Checklist
													</label>
													<div class="col-md-3">
														<div class="input-group" style="text-align:left">
															<!-- <input class="form-control" type="text" placeholder="Compliance Checklist"> -->
															<span class="input-group-btn"> 
																<a onclick="EquityInvestment.legalTeamWindow(this);" class="btn blue" href="javascript:;" data-original-title="" title=""> 
																	<c:choose>
																		<c:when test="${equityLegalTeamStr != null && equityLegalTeamStr != ''}">
																			<i class="fa fa-check-circle"></i>
																		</c:when>
																		<c:otherwise>
																			<i class="fa fa-question-circle"></i>
																		</c:otherwise>
																	</c:choose>																	Legal Team 
																</a>
																<input type="hidden" id="complianceLegal" value="${equityLegalTeamStr}"> 
															</span>
														</div>
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
												<div class="form-group">
													<label  class="col-md-5 control-label">Cayman Directors’ approval to sign SPA and related documents (USD Fund)</label>
													<div class="col-md-5">
														<label class="radio-inline">
														<input type="radio" name="isUSDFund" value="0" <c:if test="${equityInvestment.isUSDFund == 0 }">checked="true"</c:if>> Y </label>
														<label class="radio-inline">
														<input type="radio" name="isUSDFund" value="1" <c:if test="${equityInvestment.isUSDFund == 1 }">checked="true"</c:if>> N </label>
													</div>
												</div>
												<div class="form-group">
													<label  class="col-md-5 control-label">Tax clearance for atypical deals</label>
													<div class="col-md-5">
														<label class="radio-inline">
														<input type="radio" name="isAtypical" value="0" <c:if test="${equityInvestment.isAtypical == 0 }">checked="true"</c:if>> Y </label>
														<label class="radio-inline">
														<input type="radio" name="isAtypical" value="1" <c:if test="${equityInvestment.isAtypical == 1 }">checked="true"</c:if>> N </label>
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
						<div class="tab-pane" id="preFunding_tab">
							<div class="row">
								<div class="col-md-12">
									<br>
									<div class="portlet">
										<div class="portlet-title">
											<div class="caption">
												<i class="fa fa-table"></i>Online Questionnaire
											</div>
											<div class="tools">
												<a href="javascript:;" class="collapse" data-original-title="" title="">
												</a>
											</div>
										</div>
										<div class="portlet-body">
											<div class="form-group">
												<label  class="col-md-12" style="text-align: left;">Confirm the online form information is correct</label>
											</div>
											<div class="form-group">
												<label class="col-md-12" style="text-align: left;">
													<a href="https://essentials.sequoiacap.com/info/" target="_Blank">https://essentials.sequoiacap.com/info/ (link for the website)</a>
												</label>
											</div>
										</div>
										<br/>
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
												<div class="form-group">
													<label  class="col-md-4 control-label">FCPA checking result</label>
													<div class="col-md-8">
														<span id="fcpaCheckingResult" data-filename="fcpaCheckingResult"></span>
													</div>
												</div>
												<div class="form-group">
													<label  class="col-md-4 control-label">Dir indemnification</label>
													<div class="col-md-8">
														<span id="indemnification" data-filename="indemnificationUpload"></span>
													</div>
												</div>
												<div class="form-group">
													<label  class="col-md-4 control-label">Fully signed SPA, relevant transaction docs</label>
													<div class="col-md-8">
														<span id="transactionDocs" data-filename="transactionDocsUpload"></span>
													</div>
												</div>
												<div class="form-group">
													<label  class="col-md-4 control-label">Wire instruction</label>
													<div class="col-md-8">
														<span id="instruction" data-filename="instructionUpload"></span>
													</div>
												</div>
												<div class="form-group">
													<label  class="col-md-4 control-label">Rep letter </label>
													<div class="col-md-8">
														<span id="repLetter" data-filename="repLetterUpload"></span>
													</div>
												</div>
												<div class="form-group">
													<label  class="col-md-4 control-label">Legal Opinion (Cayman and PRC) for all investments (no waiver)</label>
													<div class="col-md-8">
														<span id="legalOpinion" data-filename="legalOpinionUpload"></span>
													</div>
												</div>
												<div class="form-group">
													<label  class="col-md-4 control-label">Name and Logo Undertaking Letter</label>
													<div class="col-md-8">
														<span id="letter" data-filename="letterUpload"></span>
													</div>
												</div>
												<div class="form-group">
													<label  class="col-md-4 control-label">Confirm that all the closing conditions are satisfied or waived</label>
													<div class="col-md-4">
														<label class="radio-inline">
														<input type="radio" name="isConditions" value="0" <c:if test="${equityInvestment.isConditions == 0 }">checked="true"</c:if>> Y </label>
														<label class="radio-inline">
														<input type="radio" name="isConditions" value="1" <c:if test="${equityInvestment.isConditions == 1 }">checked="true"</c:if>> N </label>
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
												<div class="form-group">
													<label  class="col-md-4 control-label">Neil’s approval for funding</label>
													<div class="col-md-4">
														<label class="radio-inline">
														<input type="radio" name="isApproval" value="0" <c:if test="${equityInvestment.isApproval == 0 }">checked="true"</c:if>> Y </label>
														<label class="radio-inline">
														<input type="radio" name="isApproval" value="1" <c:if test="${equityInvestment.isApproval == 1 }">checked="true"</c:if>> N </label>
													</div>
												</div>
												<div class="form-group">
													<label  class="col-md-4 control-label">Is this round a follow on investment? </label>
													<div class="col-md-4">
														<label class="radio-inline">
														<input type="radio" name="isRound" value="0" <c:if test="${equityInvestment.isRound == 0 }">checked="true"</c:if>> Y </label>
														<label class="radio-inline">
														<input type="radio" name="isRound" value="1" <c:if test="${equityInvestment.isRound == 1 }">checked="true"</c:if>> N </label>
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
					<div class="col-md-12">
						<div class="row">
							<div class="col-md-12" align="center">
								<button type="button" class="btn btn-success J_menuItem" onclick="EquityInvestment.saveEquityInvestmentDataBefore();">
									<fmt:message key="PAGE.GEN.SAVE" />
								</button>
								<button type="reset" class="btn btn-primary">
									<fmt:message key="PAGE.GEN.RESET" />
								</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</form>
	<br>
	<jsp:include page="../decorate/contentFoot.jsp"></jsp:include>
    <jsp:include page="../decorate/contentFootJS.jsp"></jsp:include>
    <script type="text/javascript" src="static/equityInvestment/scripts/equityInvestment.js?ran=" + Math.random()></script>
	<script type="text/javascript">
		$(function(){
			var isEquityAnnouncement = '${equityInvestment.isEquityAnnouncement}';
			if(isEquityAnnouncement == '0'){
				$("#equityAnnouncement").attr("style",""); 
			}
			var isEquityBroker = '${equityInvestment.isEquityBroker}';
			if(isEquityBroker == '0'){
				$("#equityBroker").attr("style",""); 
			}
			
			var nextIndex = '${equityInvestment.nextIndex }';
			GlobalUtil.editNext(".portlet-tabs", nextIndex);
			
			var equityInvestmentId = $("input[name='equityInvestmentId']").val();
			if(equityInvestmentId != undefined && equityInvestmentId != null) {
				// 设置file值
				var obj = { 
					fileDivId : "indemnification", fileId : '${equityInvestment.indemnificationUpload.fileId}',
					fileName : '${equityInvestment.indemnificationUpload.fileName}', filePath : '${equityInvestment.indemnificationUpload.filePath}'
				};
				UploadFile.setEditFileValue(obj);	
				
				var obj = { 
					fileDivId : "transactionDocs", fileId : '${equityInvestment.transactionDocsUpload.fileId}',
					fileName : '${equityInvestment.transactionDocsUpload.fileName}', filePath : '${equityInvestment.transactionDocsUpload.filePath}'
				};
				UploadFile.setEditFileValue(obj);
					
				var obj = { 
					fileDivId : "instruction", fileId : '${equityInvestment.instructionUpload.fileId}',
					fileName : '${equityInvestment.instructionUpload.fileName}', filePath : '${equityInvestment.instructionUpload.filePath}'
				};
				UploadFile.setEditFileValue(obj);
				
				var obj = { 
					fileDivId : "repLetter", fileId : '${equityInvestment.repLetterUpload.fileId}',
					fileName : '${equityInvestment.repLetterUpload.fileName}', filePath : '${equityInvestment.repLetterUpload.filePath}'
				};
				UploadFile.setEditFileValue(obj);
					
				var obj = { 
					fileDivId : "investmentMemoOne", fileId : '${equityInvestment.memoUpload.fileId}',
					fileName : '${equityInvestment.memoUpload.fileName}', filePath : '${equityInvestment.memoUpload.filePath}'
				};
				UploadFile.setEditFileValue(obj);	
					
				var obj = { 
					fileDivId : "financial", fileId : '${equityInvestment.financialUpload.fileId}',
					fileName : '${equityInvestment.financialUpload.fileName}', filePath : '${equityInvestment.financialUpload.filePath}'
				};
				UploadFile.setEditFileValue(obj);
				
				var obj = { 
					fileDivId : "capTable", fileId : '${equityInvestment.capTableUpload.fileId}',
					fileName : '${equityInvestment.capTableUpload.fileName}', filePath : '${equityInvestment.capTableUpload.filePath}'
				};
				UploadFile.setEditFileValue(obj);
				
				var obj = { 
					fileDivId : "fddReport", fileId : '${equityInvestment.fddReportUpload.fileId}',
					fileName : '${equityInvestment.fddReportUpload.fileName}', filePath : '${equityInvestment.fddReportUpload.filePath}'
				};
				UploadFile.setEditFileValue(obj);
				
				var obj = { 
					fileDivId : "questionnaire", fileId : '${equityInvestment.questionnaireUpload.fileId}',
					fileName : '${equityInvestment.questionnaireUpload.fileName}', filePath : '${equityInvestment.questionnaireUpload.filePath}'
				};
				UploadFile.setEditFileValue(obj);
				
				var obj = { 
					fileDivId : "legalOpinion", fileId : '${equityInvestment.legalOpinionUpload.fileId}',
					fileName : '${equityInvestment.legalOpinionUpload.fileName}', filePath : '${equityInvestment.legalOpinionUpload.filePath}'
				};
				UploadFile.setEditFileValue(obj);

				var obj = { 
					fileDivId : "groupChart", fileId : '${equityInvestment.groupChartUpload.fileId}',
					fileName : '${equityInvestment.groupChartUpload.fileName}', filePath : '${equityInvestment.groupChartUpload.filePath}'
				};
				UploadFile.setEditFileValue(obj);
				
				var obj = { 
					fileDivId : "letter", fileId : '${equityInvestment.letterUpload.fileId}',
					fileName : '${equityInvestment.letterUpload.fileName}', filePath : '${equityInvestment.letterUpload.filePath}'
				};
				UploadFile.setEditFileValue(obj);
				
				var obj = { 
					fileDivId : "lddReport", fileId : '${equityInvestment.lddReportUpload.fileId}',
					fileName : '${equityInvestment.lddReportUpload.fileName}', filePath : '${equityInvestment.lddReportUpload.filePath}'
				};
				UploadFile.setEditFileValue(obj);	
					
				var obj = { 
					fileDivId : "fcpaCheckingResult", fileId : '${equityInvestment.fcpaCheckingResult.fileId}',
					fileName : '${equityInvestment.fcpaCheckingResult.fileName}', filePath : '${equityInvestment.fcpaCheckingResult.filePath}'
				};
				UploadFile.setEditFileValue(obj);				
			}
		});
		
		function changeBroker(obj){
			var brokerValue = $(obj).val();
			if(brokerValue == 0){
				$("#equityBroker").attr("style",""); 
			}else{
				$("#equityBroker").attr("style","display:none;"); 
			}
		}

		function changeAnnouncement(obj){
			var announcementValue = $(obj).val();
			if(announcementValue == 0){
				$("#equityAnnouncement").attr("style",""); 
			}else{
				$("#equityAnnouncement").attr("style","display:none;"); 
			}
		}
	</script>
</body>
</html>

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
    <form>
	    <!-- SPA Signed -->
	    <div class="portlet box green">
			<div class="portlet-title">
				<div class="caption">
					<i class="fa fa-table"></i> 	SPA Signed
				</div>
				<div class="tools">
					<a href="javascript:;" class="collapse" data-original-title="" title="">
					</a>
				</div>
			</div>
			<div class="portlet-body">
				<!-- basic info表单 -->
				<div class="portlet">
					<div class="portlet-title">
						<div class="caption">
							<i class="fa fa-table"></i> 	Basic info
						</div>
						<div class="tools">
							<a href="javascript:;" class="collapse" data-original-title="" title="">
							</a>
						</div>
					</div>
					<div class="portlet-body">
						<div class="table-scrollable">
							<table class="table table-bordered table-hover">
								<tr>
									<td style="text-align:right;vertical-align:middle;">Portfolio name (CH)</td>
									<td><input type="text" class="form-control" value="组合"></td>
									<td style="text-align:right;vertical-align:middle;">Portfolio name (EN)</td>
									<td><input type="text" class="form-control" value="Portfolio"></td>
									<td style="text-align:right;vertical-align:middle;">Date of Sign</td>
									<td>
										<div class="input-icon input-icon-sm right">
											<i class="fa fa-calendar"> </i>
											<input type="text" class="form-control input-sm date dataTimeTest" placeholder="yyyy-mm-dd" value="2016-03-20" readonly />
										</div>							
									</td>
								</tr>
								<tr>
									<td style="text-align:right;vertical-align:middle;">Sector</td>
									<td><input type="text" class="form-control" value="Sector"></td>
									<td style="text-align:right;vertical-align:middle;">Fund</td>
									<td><input type="text" class="form-control" value="Fund"/></td>
									<td style="text-align:right;vertical-align:middle;">Date of funding</td>
									<td>
										<div class="input-icon input-icon-sm right">
											<i class="fa fa-calendar"> </i>
											<input type="text" class="form-control input-sm date dataTimeTest" placeholder="yyyy-mm-dd" value="2016-03-20" readonly />
										</div>
									</td>
								</tr>
								<tr>
									<td style="text-align:right;vertical-align:middle;">Deal partner 1</td>
									<td><input type="text" class="form-control" value="Deal partner 1"></td>
									<td style="text-align:right;vertical-align:middle;">Deal partner 2</td>
									<td><input type="text" class="form-control" value="Deal partner 2"></td>
									<td style="text-align:right;vertical-align:middle;">Deal partner 3</td>
									<td><input type="text" class="form-control" value="Deal partner 3"></td>
								</tr>
							</table>
						</div>
					</div>
					<br>
					<div class="portlet-title form">
						<label class="control-label col-md-1" style="font-size:20px">类型:</label>
						<div class="col-md-3">
							<select id="moneyType" onchange="changeMoneyType()" class="js-example-placeholder-single form-control">
								<option value="0">人民币</option>
								<option value="1">美金</option>
							</select>
						</div>
					</div>
				</div>
				<!-- end basic info表单 -->
				<!-- Key term表单 -->
				<div class="portlet">
					<div class="portlet-title">
						<div class="caption">
							<i class="fa fa-table"></i> 	Key term
						</div>
						<div class="tools">
							<a href="javascript:;" class="collapse" data-original-title="" title="">
							</a>
						</div>
					</div>
					<div class="portlet-body">
						<div class="form-horizontal" role="form">
							<div class="form-group">
								<label  class="col-md-3 control-label">Investment amount</label>
								<div class="col-md-4">
									<input type="text" class="form-control" value="Investment amount">
								</div>
							</div>
							<div class="form-group">
								<label  class="col-md-3 control-label">Ownership</label>
								<div class="col-md-4">
									<input type="text" class="form-control" value="Ownership">
								</div>
							</div>
							<div class="form-group">
								<label  class="col-md-3 control-label">Type of Security</label>
								<div class="col-md-4">
									<input type="text" class="form-control" value="Type of Security">
								</div>
							</div>
							<div class="form-group">
								<label  class="col-md-3 control-label">Quantity</label>
								<div class="col-md-4">
									<input type="text" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label  class="col-md-3 control-label">Warrant</label>
								<div class="col-md-4">
									<input type="text" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label  class="col-md-3 control-label">Liquidation preference</label>
								<div class="col-md-4">
									<input type="text" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label  class="col-md-3 control-label">Redemption</label>
								<div class="col-md-4">
									<input type="text" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label  class="col-md-3 control-label">Board of director</label>
								<div class="col-md-4">
									<input type="text" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label  class="col-md-3 control-label">SPA Upload</label>
								<div class="col-md-4">
									<input type="text" class="form-control">
								</div>
							</div>
						</div>
					</div>		
				</div>
				<!-- end Key term表单 -->
			</div>
		</div>
		<!-- end SPA Signed -->
	    <!-- RMB pre-funding checklist大表单 -->
		<div class="portlet box green" id="rmbMoneyType">
			<div class="portlet-title">
				<div class="caption">
					<i class="fa fa-table"></i> 	Pre-funding checklist
				</div>
				<div class="tools">
					<a href="javascript:;" class="collapse" data-original-title="" title="">
					</a>
				</div>
			</div>
			<div class="portlet-body">
				<!-- Legal document表单 -->
				<div class="portlet">
					<div class="portlet-title">
						<div class="caption">
							<i class="fa fa-table"></i> 	Legal document
						</div>
						<div class="tools">
							<a href="javascript:;" class="collapse" data-original-title="" title="">
							</a>
						</div>
					</div>
					<div class="portlet-body">
						<div class="table-scrollable">
							<table class="table table-bordered table-hover">
								<tr>
									<td style="text-align:right;vertical-align:middle;width:50%">
										 Neil's approval for funding
									</td>
									<td style="text-align:center;vertical-align:middle;">
										 <button type="button" class="btn blue">上传附件</button>
									</td>
								</tr>
								<tr>
									<td style="text-align:right;vertical-align:middle;">
										 Investment memo
									</td>
									<th style="text-align:center;vertical-align:middle;">
										<div class="radio-list">
											<label class="radio-inline">
											<div class="radio" id="uniform-optionsRadios25"><span class="checked"><input type="radio" name="optionsRadios3" id="optionsRadios25" value="a" checked=""></span></div>
											 N </label>
											<label class="radio-inline">
											<div class="radio" id="uniform-optionsRadios26"><span class=""><input type="radio" name="optionsRadios3" id="optionsRadios26" value="b" checked=""></span></div>
											 A </label>
										</div>						</td>
								</tr>
								<tr>
									<td style="text-align:right;vertical-align:middle;">
										 GDOT/FCPA
									</td>
									<td style="text-align:center;vertical-align:middle;">
										 <button type="button" class="btn blue">上传附件</button>
									</td>
								</tr>
								<tr>
									<td style="text-align:right;vertical-align:middle;">
										 LDD Report
									</td>
									<td style="text-align:center;vertical-align:middle;">
										 <button type="button" class="btn blue">上传附件</button>
									</td>
								</tr>
								<tr>
									<td style="text-align:right;vertical-align:middle;">
										 FDD Report
									</td>
									<td style="text-align:center;vertical-align:middle;">
										 <button type="button" class="btn blue">上传Excel</button>
									</td>
								</tr>
								<tr>
									<td style="text-align:right;vertical-align:middle;">
										 Group Chart 
									</td>
									<td style="text-align:center;vertical-align:middle;">
										 <button type="button" class="btn blue">上传Excel</button>
									</td>
								</tr>
								<tr>
									<td style="text-align:right;vertical-align:middle;">
										 Cap table
									</td>
									<td style="text-align:center;vertical-align:middle;">
										 <button type="button" class="btn blue">上传Excel</button>
									</td>
								</tr>
								<tr>
									<td style="text-align:right;vertical-align:middle;">
										 Legal Opinion (no waiver)
									</td>
									<th style="text-align:center;vertical-align:middle;">
										 <div class="radio-list">
											<label class="radio-inline">
											<div class="radio" id="uniform-optionsRadios25"><span class="checked"><input type="radio" name="optionsRadios2" id="optionsRadios25" value="a" checked=""></span></div>
											 Y </label>
											<label class="radio-inline">
											<div class="radio" id="uniform-optionsRadios26"><span class=""><input type="radio" name="optionsRadios2" id="optionsRadios26" value="b" checked=""></span></div>
											 N </label>
										</div>
									</td>
								</tr>
								<tr>
									<td style="text-align:right;vertical-align:middle;">
										 Deal team to confirm the key terms 
									</td>
									<th style="text-align:center;vertical-align:middle;">
										 <div class="radio-list">
											<label class="radio-inline">
											<div class="radio" id="uniform-optionsRadios25"><span class="checked"><input type="radio" name="optionsRadios1" id="optionsRadios25" value="a" checked=""></span></div>
											 Y </label>
											<label class="radio-inline">
											<div class="radio" id="uniform-optionsRadios26"><span class=""><input type="radio" name="optionsRadios1" id="optionsRadios26" value="b" checked=""></span></div>
											 N </label>
										</div>
									</td>
								</tr>
								<tr>
									<td style="text-align:right;vertical-align:middle;">
										 All the conditions of closing are satisfied or waiver 
									</td>
									<th style="text-align:center;vertical-align:middle;">
										 <div class="radio-list">
											<label class="radio-inline">
											<div class="radio" id="uniform-optionsRadios25"><span class="checked"><input type="radio" name="optionsRadios" id="optionsRadios25" value="c" checked=""></span></div> Y </label>
											<label class="radio-inline">
											<div class="radio" id="uniform-optionsRadios26"><span class=""><input type="radio" name="optionsRadios" id="optionsRadios26" value="d" checked=""></span></div> N </label>
										</div>
									</td>
								</tr>
								<tr>
									<td style="text-align:right;vertical-align:middle;">
										 Signed agreement to state that any usage of our Sequoia’s name
									</td>
									<td style="text-align:center;vertical-align:middle;">
										 <button type="button" class="btn blue">上传pdf</button>
									</td>
								</tr>
							</table>
						</div>
					</div>
				</div>
				<!-- Basid info of portfolio表单 -->
				<div class="portlet">
					<div class="portlet-title">
						<div class="caption">
							<i class="fa fa-table"></i> 	Basid info of portfolio
						</div>
						<div class="tools">
							<a href="javascript:;" class="collapse" data-original-title="" title="">
							</a>
						</div>
					</div>
					<div class="portlet-body">
						<div class="form-horizontal" role="form">
							<div class="form-group">
								<label  class="col-md-3 control-label">Legal name (CH)</label>
								<div class="col-md-4">
									<input type="text" class="form-control" id="inputLegalNameCH" value="法律">
								</div>
							</div>
							<div class="form-group">
								<label  class="col-md-3 control-label">Legal name (EN)</label>
								<div class="col-md-4">
									<input type="text" class="form-control" id="inputLegalNameEN" value="Legal">
								</div>
							</div>
							<div class="form-group">
								<label  class="col-md-3 control-label">成立时间</label>
								<div class="col-md-4">
									<div class="input-icon input-icon-sm right">
										<i class="fa fa-calendar"> </i>
										<input type="text" class="form-control input-sm date dataTimeTest" placeholder="yyyy-mm-dd" readonly />
									</div>							
								</div>
							</div>
							<div class="form-group">
								<label  class="col-md-3 control-label">所在地</label>
								<div class="col-md-4">
									<input type="text" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label  class="col-md-3 control-label">Company contact name</label>
								<div class="col-md-4">
									<input type="text" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label  class="col-md-3 control-label">Title</label>
								<div class="col-md-4">
									<input type="text" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label  class="col-md-3 control-label">Email address</label>
								<div class="col-md-4">
									<input type="text" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label  class="col-md-3 control-label">Phone</label>
								<div class="col-md-4">
									<input type="text" class="form-control">
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="portlet">
					<div class="portlet-title">
						<div class="caption">
							<i class="fa fa-table"></i> 	Financial information
						</div>
						<div class="tools">
							<a href="javascript:;" class="collapse" data-original-title="" title="">
							</a>
						</div>
					</div>
					<div class="portlet-body">
						<div class="form-horizontal" role="form">
							<div class="form-group">
								<label class="col-md-3 control-label">Fund</label>
								<div class="col-md-4">
									<input type="text" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-3 control-label">Stealth</label>
								<div class="col-md-4">
									<label class="radio-inline">
									<input type="radio" name="optionsStealth" id="optionsRadios25" value="option1" checked=""> Y </label>
									<label class="radio-inline">
									<input type="radio" name="optionsStealth" id="optionsRadios26" value="option2" checked=""> N </label>
								</div>
							</div>
							<div class="form-group">
								<label  class="col-md-3 control-label">Type</label>
								<div class="col-md-4">
									<select class="js-example-placeholder-single form-control">
										<option value>Please choose </option>
										<option>Loan</option>
										<option>Equity Investment</option>
									</select>								
								</div>
							</div>
							<div class="form-group">
								<label  class="col-md-3 control-label">Date of funding</label>
								<div class="col-md-4">
									<input type="text" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label  class="col-md-3 control-label">Funding amount</label>
								<div class="col-md-4">
									<input type="text" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label  class="col-md-3 control-label">Series</label>
								<div class="col-md-4">
									<input type="text" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label  class="col-md-3 control-label">Funding Type</label>
								<div class="col-md-4">
									<select class="js-example-placeholder-single form-control">
										<option value>Please choose </option>
										<option>Capital increase</option>
										<option>Share transfer</option>
									</select>									
								</div>
							</div>
							<div class="form-group">
								<label  class="col-md-3 control-label">Ownership</label>
								<div class="col-md-4">
									<input type="text" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label  class="col-md-3 control-label">Lead</label>
								<div class="col-md-4">
									<input type="text" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label  class="col-md-3 control-label">BOD</label>
								<div class="col-md-4">
									<input type="text" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label  class="col-md-3 control-label">Supervisor</label>
								<div class="col-md-4">
									<input type="text" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label  class="col-md-3 control-label">FDD member</label>
								<div class="col-md-4">
									<input type="text" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label  class="col-md-3 control-label">Pre money</label>
								<div class="col-md-4">
									<input type="text" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label  class="col-md-3 control-label">Post money</label>
								<div class="col-md-4">
									<input type="text" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label  class="col-md-3 control-label">Pace of investment</label>
								<div class="col-md-4">
									<select class="js-example-placeholder-single form-control">
										<option value>Please choose </option>
										<option>New</option>
										<option>Follow on</option>
									</select>									
								</div>
							</div>
							<div class="form-group">
								<label  class="col-md-3 control-label">主导投资</label>
								<div class="col-md-4">
									<label class="radio-inline">
									<input type="radio" name="options1" id="optionsRadios25" value="option1" checked=""> Y </label>
									<label class="radio-inline">
									<input type="radio" name="options1" id="optionsRadios26" value="option2" checked=""> N </label>
								</div>
							</div>
							<div class="form-group">
								<label  class="col-md-3 control-label">共同投资人信息</label>
								<div class="col-md-4">
									<input type="text" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label  class="col-md-3 control-label">Remark</label>
								<div class="col-md-4">
									<input type="text" class="form-control">
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	    <!-- end RMB pre-funding checklist大表单 -->
	    <!-- USA pre-funding checklist大表单 -->
	    <div class="portlet box green" style="display: none" id="usaMoneyType">
			<div class="portlet-title">
				<div class="caption">
					<i class="fa fa-table"></i> 	Pre-funding checklist
				</div>
				<div class="tools">
					<a href="javascript:;" class="collapse" data-original-title="" title="">
					</a>
				</div>
			</div>
			<div class="portlet-body">
				<div class="portlet">
					<div class="portlet-title">
						<div class="caption">
							<i class="fa fa-table"></i> 	Deal team
						</div>
						<div class="tools">
							<a href="javascript:;" class="collapse" data-original-title="" title="">
							</a>
						</div>
					</div>
					<div class="portlet-body">
						<div class="form-horizontal" role="form">
							<div class="form-group">
								<label  class="col-md-5 control-label">Neil's approval to sign SPA</label>
								<div class="col-md-4">
									<input type="text" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label  class="col-md-5 control-label">Online questionnaire</label>
								<div class="col-md-4">
									<input type="text" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label  class="col-md-5 control-label">Investment memo</label>
								<div class="col-md-4">
									<input type="text" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label  class="col-md-5 control-label">For all venture deals, amount of f/o if any. Please include this in the approval email from Neil (cc us and Wendy) </label>
								<div class="col-md-4">
									<input type="text" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label  class="col-md-5 control-label"> Is it in stealth mode? </label>
								<div class="col-md-4">
									<input type="text" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label  class="col-md-5 control-label"> Pre and post money valuation </label>
								<div class="col-md-4">
									<input type="text" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label  class="col-md-5 control-label"> Contact (name, email, phone, English address with area code)  </label>
								<div class="col-md-4">
									<input type="text" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label  class="col-md-5 control-label"> 2 to 3-line business description </label>
								<div class="col-md-4">
									<input type="text" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label  class="col-md-5 control-label">  Expected return </label>
								<div class="col-md-4">
									<input type="text" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label  class="col-md-5 control-label"> Development stage </label>
								<div class="col-md-4">
									<select class="js-example-placeholder-single form-control">
										<option value>Please choose </option>
										<option>Product Development</option>
										<option>Early Sales</option>
										<option>Revenue Ramp etc</option>
									</select>	
								</div>
							</div>
							<div class="form-group">
								<label  class="col-md-5 control-label">  Latest financial statements: (at least provide us a simple B/S for start-up co) </label>
								<div class="col-md-4">
									<input type="text" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label  class="col-md-5 control-label">  Cap table </label>
								<div class="col-md-4">
									<input type="text" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label  class="col-md-5 control-label">  Are we the lead investor? </label>
								<div class="col-md-4">
									<input type="text" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label  class="col-md-5 control-label">  Investment Stage </label>
								<div class="col-md-4">
									<select class="js-example-placeholder-single form-control">
										<option value>Please choose </option>
										<option>Seed</option>
										<option>Venture</option>
										<option>Growth</option>
										<option>Public</option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label  class="col-md-5 control-label">  FDD report </label>
								<div class="col-md-4">
									<input type="text" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label  class="col-md-5 control-label">  Chinese Deal Name and Chinese Company Name </label>
								<div class="col-md-4">
									<input type="text" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label  class="col-md-5 control-label">  Online questionnaire – Please confirm the online form information as correct </label>
								<div class="col-md-4">
									<input type="text" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label  class="col-md-5 control-label">  Can we disclose the name of the investment in our Fund’s financials? </label>
								<div class="col-md-4">
									<input type="text" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label  class="col-md-5 control-label">  New Investment Announcement form </label>
								<div class="col-md-4">
									<input type="text" class="form-control">
								</div>
							</div>
							<table class="table table-bordered table-hover">
								<tr>
									<td>Name</td>
									<td>Location</td>
								</tr>
								<tr>
									<td><input type="text" class="form-control"></td>
									<td><input type="text" class="form-control"></td>
								</tr>
								<tr>
									<td colspan="2">Business description: (2 sentences)</td>
								</tr>
								<tr >
									<td colspan="2"><textarea rows="2" class="form-control"></textarea></td>
								</tr>
								<tr>
									<td colspan="2">Investment rationale: (2-3 sentences)</td>
								</tr>
								<tr >
									<td colspan="2"><input type="text" class="form-control"></td>
								</tr>
								<tr>
									<td colspan="2">Website:</td>
								</tr>
								<tr >
									<td colspan="2"><input type="text" class="form-control"></td>
								</tr>
								<tr>
									<td style="text-align:right;vertical-align:middle;">Partner:</td>
									<td><input type="text" class="form-control"></td>
								</tr>
								<tr>
									<td style="text-align:right;vertical-align:middle;">Fund:</td>
									<td><input type="text" class="form-control"></td>
								</tr>
								<tr>
									<td style="text-align:right;vertical-align:middle;">Investment amount:</td>
									<td><input type="text" class="form-control"></td>
								</tr>
								<tr>
									<td style="text-align:right;vertical-align:middle;">Ownership</td>
									<td><input type="text" class="form-control"></td>
								</tr>
								<tr>
									<td style="text-align:right;vertical-align:middle;">Pre-money valuation:</td>
									<td><input type="text" class="form-control"></td>
								</tr>
								<tr>
									<td style="text-align:right;vertical-align:middle;">Date of investment:</td>
									<td><input type="text" class="form-control"></td>
								</tr>
							</table>
						</div>
					</div>
				</div>
				<div class="portlet">
					<div class="portlet-title">
						<div class="caption">
							<i class="fa fa-table"></i> 	Legal team
						</div>
						<div class="tools">
							<a href="javascript:;" class="collapse" data-original-title="" title="">
							</a>
						</div>
					</div>
					<div class="portlet-body">
						<div class="form-horizontal" role="form">
							<div class="form-group">
								<label  class="col-md-5 control-label">FCPA questionnaire – at least 5 working days for checking results to be ready</label>
								<div class="col-md-4">
									<input type="text" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label  class="col-md-5 control-label">Dir indemnification (if anyone is on board; or if any new board seats for f/o investments)</label>
								<div class="col-md-4">
									<input type="text" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label  class="col-md-5 control-label">GDOT/FCPA (Legal department should know about this; no GDOT if our shareholding <20%)</label>
								<div class="col-md-4">
									<input type="text" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label  class="col-md-5 control-label">Group Chart (investment structure chart showing all the entities within the Grp; not the internal organization chart)</label>
								<div class="col-md-4">
									<input type="text" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label  class="col-md-5 control-label">Legal Opinion for all investments (no waiver): </label>
								<div class="col-md-4">
									<input type="text" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label  class="col-md-5 control-label">Fully signed SPA, relevant transaction docs</label>
								<div class="col-md-4">
									<input type="text" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label  class="col-md-5 control-label">Wire instruction</label>
								<div class="col-md-4">
									<input type="text" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label  class="col-md-5 control-label">LDD report</label>
								<div class="col-md-4">
									<input type="text" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label  class="col-md-5 control-label">Name and Logo Undertaking Letter</label>
								<div class="col-md-4">
									<input type="text" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label  class="col-md-5 control-label">Confirm that all the closing conditions are satisfied or waived</label>
								<div class="col-md-4">
									<input type="text" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label  class="col-md-5 control-label">Rep letter (for money not being directly sent to the Company’s bank account)</label>
								<div class="col-md-4">
									<input type="text" class="form-control">
								</div>
							</div>
						</div>	
					</div>
				</div>
			</div>
		</div>
	    <!-- end USA pre-funding checklist大表单 -->
		<!-- Post-funding大表单 -->
		<div class="portlet box green">
			<div class="portlet-title">
				<div class="caption">
					<i class="fa fa-table"></i> 	Post-funding
				</div>
				<div class="tools">
					<a href="javascript:;" class="collapse" data-original-title="" title="">
					</a>
				</div>
			</div>
			<div class="portlet-body">
				<div class="portlet">
					<div class="portlet-title">
						<div class="caption">
							<i class="fa fa-table"></i> 	New round financing
						</div>
						<div class="tools">
							<a href="javascript:;" class="collapse" data-original-title="" title="">
							</a>
						</div>
					</div>
					<div class="portlet-body">
						<div class="form-horizontal" role="form">
							<div class="form-group">
								<label  class="col-md-3 control-label">Date of signed</label>
								<div class="col-md-4">
									<input type="text" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label  class="col-md-3 control-label">Diluted ownership</label>
								<div class="col-md-4">
									<input type="text" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label  class="col-md-3 control-label">Pre money</label>
								<div class="col-md-4">
									<input type="text" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label  class="col-md-3 control-label">Post money</label>
								<div class="col-md-4">
									<input type="text" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label  class="col-md-3 control-label">SCC Involved</label>
								<div class="col-md-4">
									<label class="radio-inline">
									<input type="radio" name="optionsStealth" id="optionsRadios25" value="option1" checked=""> Y </label>
									<label class="radio-inline">
									<input type="radio" name="optionsStealth" id="optionsRadios26" value="option2" checked=""> N </label>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="portlet">
					<div class="portlet-title">
						<div class="caption">
							<i class="fa fa-table"></i> 	IPO
						</div>
						<div class="tools">
							<a href="javascript:;" class="collapse" data-original-title="" title="">
							</a>
						</div>
					</div>
					<div class="portlet-body">
						<div class="form-horizontal" role="form">
							<div class="form-group">
								<label  class="col-md-3 control-label">Ticker symbol</label>
								<div class="col-md-4">
									<input type="text" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label  class="col-md-3 control-label">Stock Exchange</label>
								<div class="col-md-4">
									<input type="text" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label  class="col-md-3 control-label">IPO Date</label>
								<div class="col-md-4">
									<input type="text" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label  class="col-md-3 control-label">IPO Price</label>
								<div class="col-md-4">
									<input type="text" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label  class="col-md-3 control-label">Closing IPO Price</label>
								<div class="col-md-4">
									<input type="text" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label  class="col-md-3 control-label">Lock up period</label>
								<div class="col-md-4">
									<input type="text" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label  class="col-md-3 control-label">Unlock date</label>
								<div class="col-md-4">
									<input type="text" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label  class="col-md-3 control-label">Cost per share</label>
								<div class="col-md-4">
									<input type="text" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label  class="col-md-3 control-label">Holding shares</label>
								<div class="col-md-4">
									<input type="text" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label  class="col-md-3 control-label">SCC’s diluted ownership</label>
								<div class="col-md-4">
									<input type="text" class="form-control">
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="portlet">
					<div class="portlet-title">
						<div class="caption">
							<i class="fa fa-table"></i> 	Exit
						</div>
						<div class="tools">
							<a href="javascript:;" class="collapse" data-original-title="" title="">
							</a>
						</div>
					</div>
					<div class="portlet-body">
						<div class="form-horizontal" role="form">
							<div class="form-group">
								<label  class="col-md-3 control-label">Type</label>
								<div class="col-md-4">
									<select class="js-example-placeholder-single form-control">
										<option value>Please choose </option>
										<option>M & A</option>
										<option>Disposal of shares</option>
										<option>Redemption etc</option>
									</select>									
								</div>
							</div>
							<div class="form-group">
								<label  class="col-md-3 control-label">Amount of Proceeds</label>
								<div class="col-md-4">
									<input type="text" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label  class="col-md-3 control-label">Date of sold</label>
								<div class="col-md-4">
									<div class="input-icon input-icon-sm right">
										<i class="fa fa-calendar"> </i>
										<input type="text" class="form-control input-sm date dataTimeTest" placeholder="yyyy-mm-dd" readonly />
									</div>
								</div>
							</div>
							<div class="form-group">
								<label  class="col-md-3 control-label">Ownership after sold</label>
								<div class="col-md-4">
									<input type="text" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label  class="col-md-3 control-label">Reduced investment cost</label>
								<div class="col-md-4">
									<input type="text" class="form-control">
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="form-actions">
			<div class="row">
				<div class="col-md-offset-5">
					<button type="button" class="btn green">保存</button>
					<button type="button" class="btn green">重置</button>
				</div>
			</div>
		</div>
	</form>
	<jsp:include page="../decorate/contentFoot.jsp"></jsp:include>
    <jsp:include page="../decorate/contentFootJS.jsp"></jsp:include>
	<script type="text/javascript">
		jQuery(document).ready(function() { 
			$('.dataTimeTest').datetimepicker({
			　　minView: "month", 
			　　format: "yyyy-mm-dd", 
			　　language: 'zh-CN', 
			　　autoclose:true 
			});
	     }); 
		function changeMoneyType(){
			if($("#moneyType").val()=="0"){
				$("#rmbMoneyType").css("display","");
				$("#usaMoneyType").css("display","none");
			}else{
				$("#usaMoneyType").css("display","");
				$("#rmbMoneyType").css("display","none");
			}
		}
	</script>
</body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
<form id="teamWindowForm">
	<input type="hidden" name="file" value="confirmationDeal_P-note.xls">
	<input type="hidden" name="exportTitle" value="Confirmation Deal P-note">
       <div class="row">
		<div class="col-md-12">
			<br>
			<div class="portlet">
				<div class="portlet-title">
					<div class="caption">
						<i class="fa fa-table"></i>Deal team
					</div>
					<div class="tools">
					</div>
				</div>
				<div class="portlet-body">
					<div class="form-horizontal" align="center" role="form">
						<div class="form-group">
							<div class="col-md-2" style="top:-8px;">
								<label class="radio-inline">
								<input type="radio" name="founderTrustworthy" value="0" <c:if test="${dealTeam.founderTrustworthy==0 }">checked="true"</c:if>> Y </label>
								<label class="radio-inline">
								<input type="radio" name="founderTrustworthy" value="1" <c:if test="${dealTeam.founderTrustworthy==1 }">checked="true"</c:if>> N </label>
							</div>
							<div class="col-md-10" align="left">
								1. Confirm that you know the founder (borrower), and believe him/her to be trustworthy. 
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-2" style="top:-8px;">
								<label class="radio-inline">
								<input type="radio" name="investmentOpportunity" value="0" <c:if test="${dealTeam.investmentOpportunity==0 }">checked="true"</c:if>> Y </label>
								<label class="radio-inline">
								<input type="radio" name="investmentOpportunity" value="1" <c:if test="${dealTeam.investmentOpportunity==1 }">checked="true"</c:if>> N </label>
							</div>
							<div class="col-md-10" align="left">
								2. Confirm that the underlying investment opportunity is worth taking a credit risk on the founder.
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-2" style="top:-8px;">
								<label class="radio-inline">
								<input type="radio" name="confirmInUsd" value="0" <c:if test="${dealTeam.confirmInUsd==0 }">checked="true"</c:if>> Y </label>
								<label class="radio-inline">
								<input type="radio" name="confirmInUsd" value="1" <c:if test="${dealTeam.confirmInUsd==1 }">checked="true"</c:if>> N </label>
							</div>
							<div class="col-md-10" align="left">
								3. Confirm that the loan is expected to be repaid in USD (not RMB) or to be replaced by bona fide equity ecurities of the portfolio company.
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-2" style="top:-8px;">
								<label class="radio-inline">
								<input type="radio" name="loanThirdParty" value="0" <c:if test="${dealTeam.loanThirdParty==0 }">checked="true"</c:if>> Y </label>
								<label class="radio-inline">
								<input type="radio" name="loanThirdParty" value="1" <c:if test="${dealTeam.loanThirdParty==1 }">checked="true"</c:if>> N </label>
							</div>
							<div class="col-md-10" align="left">
								4. Confirm that Neil is aware of the reason why the loan is to be made to a third party rather than the founder and has approved this structure.. (“NA” if the money goes directly to the company or the founder(s))
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-2" style="top:-8px;">
								<label class="radio-inline">
								<input type="radio" name="confirmfounder" value="0" <c:if test="${dealTeam.confirmfounder==0 }">checked="true"</c:if>> Y </label>
								<label class="radio-inline">
								<input type="radio" name="confirmfounder" value="1" <c:if test="${dealTeam.confirmfounder==1 }">checked="true"</c:if>> N </label>
							</div>
							<div class="col-md-10" align="left">
								5. Confirm that you know this founder and trust that his/her use of the recipient entity of the loan proceeds does not represent any violations of anti-money laundering rules and regulations. (“NA” if the money goes directly to the company or the founder(s))
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</form>
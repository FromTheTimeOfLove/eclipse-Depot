<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
<form id="teamWindowForm">
		<input type="hidden" name="file" value="confirmationLegal_P-note.xls">
		<input type="hidden" name="exportTitle" value="Confirmation Legal P-note">
       <div class="row">
		<div class="col-md-12">
			<br>
			<div class="portlet">
				<div class="portlet-title">
					<div class="caption">
						<i class="fa fa-table"></i>Legal team
					</div>
					<div class="tools">
					</div>
				</div>
				<div class="portlet-body">
					<div class="form-horizontal" align="center" role="form">
						<div class="form-group">
							<div class="col-md-2" style="top:-8px;">
								<label class="radio-inline">
								<input type="radio" name="confirmEconomics" value="0" <c:if test="${legalTeam.confirmEconomics==0 }">checked="true"</c:if>> Y </label>
								<label class="radio-inline">
								<input type="radio" name="confirmEconomics" value="1" <c:if test="${legalTeam.confirmEconomics==1 }">checked="true"</c:if>> N </label>
							</div>
							<div class="col-md-10" align="left">
								1. Confirm that Sequoia is entitled to the actual economics based on the binding legal documents.
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-2" style="top:-8px;">
								<label class="radio-inline">
								<input type="radio" name="confirmTransaction" value="0" <c:if test="${legalTeam.confirmTransaction==0 }">checked="true"</c:if>> Y </label>
								<label class="radio-inline">
								<input type="radio" name="confirmTransaction" value="1" <c:if test="${legalTeam.confirmTransaction==1 }">checked="true"</c:if>> N </label>
							</div>
							<div class="col-md-10" align="left">
								2. Confirm that the overall transaction and the signed legal documents are enforceable and in compliance with PRC laws.
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-2" style="top:-8px;">
								<label class="radio-inline">
								<input type="radio" name="confirmFundLoan" value="0" <c:if test="${legalTeam.confirmFundLoan==0 }">checked="true"</c:if>> Y </label>
								<label class="radio-inline">
								<input type="radio" name="confirmFundLoan" value="1" <c:if test="${legalTeam.confirmFundLoan==1 }">checked="true"</c:if>> N </label>
							</div>
							<div class="col-md-10" align="left">
								3. Confirm that the total amount of the loan (combined with all similar loans) is less than 5% of the total size of the Fund.
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-2" style="top:-8px;">
								<label class="radio-inline">
								<input type="radio" name="confirmNoReasonable" value="0" <c:if test="${legalTeam.confirmNoReasonable==0 }">checked="true"</c:if>> Y </label>
								<label class="radio-inline">
								<input type="radio" name="confirmNoReasonable" value="1" <c:if test="${legalTeam.confirmNoReasonable==1 }">checked="true"</c:if>> N </label>
							</div>
							<div class="col-md-10" align="left">
								4. Confirm that there are no reasonable and cost-effective alternatives to this indirect financing that would provide greater certainty of repayment, such as a direct loan or a more secure intermediary party
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-2" style="top:-8px;">
								<label class="radio-inline">
								<input type="radio" name="loanWithConditions" value="0" <c:if test="${legalTeam.loanWithConditions==0 }">checked="true"</c:if>> Y </label>
								<label class="radio-inline">
								<input type="radio" name="loanWithConditions" value="1" <c:if test="${legalTeam.loanWithConditions==1 }">checked="true"</c:if>> N </label>
							</div>
							<div class="col-md-10" align="left">
								5. Confirm that the overall terms and conditions of the loan are within the range of customary practices in the local market.
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-2" style="top:-8px;">
								<label class="radio-inline">
								<input type="radio" name="securedByCollateral" value="0" <c:if test="${legalTeam.securedByCollateral==0 }">checked="true"</c:if>> Y </label>
								<label class="radio-inline">
								<input type="radio" name="securedByCollateral" value="1" <c:if test="${legalTeam.securedByCollateral==1 }">checked="true"</c:if>> N </label>
							</div>
							<div class="col-md-10" align="left">
								6. Confirm that the loan is secured by collateral, to the extent practicable and available.  If there will be no collateral (or collateral will cover less than the entire loan), confirm that the issue was considered and,  taking into account all facts and circumstances, it was determined that full collateral is not practical or available.
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-2" style="top:-8px;">
								<label class="radio-inline">
								<input type="radio" name="confirmPortfolioCompany" value="0" <c:if test="${legalTeam.confirmPortfolioCompany==0 }">checked="true"</c:if>> Y </label>
								<label class="radio-inline">
								<input type="radio" name="confirmPortfolioCompany" value="1" <c:if test="${legalTeam.confirmPortfolioCompany==1 }">checked="true"</c:if>> N </label>
							</div>
							<div class="col-md-10" align="left">
								7. Confirm that the portfolio company is expected to be formed, and to assume responsibility for the loan (or to issue equity securities in exchange for the loan), within a relatively brief period of time (if expected to be longer than 6 months, please explain).
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</form>
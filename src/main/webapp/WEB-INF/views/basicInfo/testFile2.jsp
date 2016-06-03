<!DOCTYPE html>
<!-- release v4.1.8, copyright 2014 - 2015 Kartik Visweswaran -->
<html lang="en">
    <head>
	<jsp:include page="../decorate/contentHead.jsp"></jsp:include>
    </head>
    <body>
    	<form id="teamWindowForm">
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
								<div style="width:700px;text-align: left;">
									1. Confirm that Sequoia is entitled to the actual economics based on the binding legal documents.
								</div>
							</div>
							<div class="form-group" align="center">
								<div class="col-md-9">
									<label class="radio-inline">
									<input type="radio" name="confirmEconomics" value="0" > Y </label>
									<label class="radio-inline">
									<input type="radio" name="confirmEconomics" value="1"> N </label>
								</div>
							</div>
							<div class="form-group">
								<div style="width:700px;text-align: left;">
									2. Confirm that the overall transaction and the signed legal documents are enforceable and in 
									compliance with &nbsp;&nbsp;&nbsp;&nbsp;PRC laws.
								</div>
							</div>
							<div class="form-group" align="center">
								<div class="col-md-9">
									<label class="radio-inline">
									<input type="radio" name="confirmTransaction" value="0" > Y </label>
									<label class="radio-inline">
									<input type="radio" name="confirmTransaction" value="1"> N </label>
								</div>
							</div>
							<div class="form-group">
								<div style="width:700px;text-align: left;">
									3. Confirm that the total amount of the loan (combined with all similar loans) is less than 5% of the
									total size of &nbsp;&nbsp;&nbsp;&nbsp;the Fund.
								</div>
							</div>
							<div class="form-group" align="center">
								<div class="col-md-9">
									<label class="radio-inline">
									<input type="radio" name="confirmFundLoan" value="0" > Y </label>
									<label class="radio-inline">
									<input type="radio" name="confirmFundLoan" value="1"> N </label>
								</div>
							</div>
							<div class="form-group">
								<div style="width:700px;text-align: left;">
									4. Confirm that there are no reasonable and cost-effective alternatives to this indirect financing
									that would provide &nbsp;&nbsp;&nbsp;&nbsp;greater certainty of repayment, such as a direct loan or a more secure 
									intermediary party
								</div>
							</div>
							<div class="form-group" align="center">
								<div class="col-md-9">
									<label class="radio-inline">
									<input type="radio" name="confirmNoReasonable" value="0" > Y </label>
									<label class="radio-inline">
									<input type="radio" name="confirmNoReasonable" value="1"> N </label>
								</div>
							</div>
							<div class="form-group">
								<div style="width:700px;text-align: left;">
									5. Confirm that the overall terms and conditions of the loan are within the range of customary 
									practices in the &nbsp;&nbsp;&nbsp;&nbsp;local market.
								</div>
							</div>
							<div class="form-group" align="center">
								<div class="col-md-9">
									<label class="radio-inline">
									<input type="radio" name="loanWithConditions" value="0" > Y </label>
									<label class="radio-inline">
									<input type="radio" name="loanWithConditions" value="1"> N </label>
								</div>
							</div>
							<div class="form-group">
								<div style="width:700px;text-align: left;">
									6. Confirm that the loan is secured by collateral, to the extent practicable and available.  If there 
									will be no &nbsp;&nbsp;&nbsp;&nbsp;collateral (or collateral will cover less than the entire loan), confirm that the issue was
									considered and,  taking &nbsp;&nbsp;&nbsp;&nbsp;into account all facts and circumstances, it was determined that full
									collateral is not practical or available.
								</div>
							</div>
							<div class="form-group" align="center">
								<div class="col-md-9">
									<label class="radio-inline">
									<input type="radio" name="securedByCollateral" value="0" > Y </label>
									<label class="radio-inline">
									<input type="radio" name="securedByCollateral" value="1"> N </label>
								</div>
							</div>
							<div class="form-group">
								<div style="width:700px;text-align: left;">
									7. Confirm that the portfolio company is expected to be formed, and to assume responsibility for
									the loan (or to &nbsp;&nbsp;&nbsp;&nbsp;issue equity securities in exchange for the loan), within a relatively brief period of 
									time (if expected to be longer &nbsp;&nbsp;&nbsp;&nbsp;than 6 months, please explain).
								</div>
							</div>
							<div class="form-group" align="center">
								<div class="col-md-9">
									<label class="radio-inline">
									<input type="radio" name="confirmPortfolioCompany" value="0" > Y </label>
									<label class="radio-inline">
									<input type="radio" name="confirmPortfolioCompany" value="1"> N </label>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		</form>
    	<jsp:include page="../decorate/contentFoot.jsp"></jsp:include>
    </body>
	
</html>
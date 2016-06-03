<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
<form id="teamWindowForm">
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
						<div class="col-md-2" style="top: -8px;">
							<label class="radio-inline">
							<input type="radio" name="isPortfolioCompany" value="0" <c:if test="${equityDealTeam.isPortfolioCompany==0 }">checked="true"</c:if>> Y </label>
							<label class="radio-inline">
							<input type="radio" name="isPortfolioCompany" value="1" <c:if test="${equityDealTeam.isPortfolioCompany==1 }">checked="true"</c:if>> N </label>
						</div>
						<div style="text-align: left;" class="col-md-10" >
							1. Is this investment being made into an affiliated entity of an existing portfolio company? (Conflicts review)
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-2" style="top: -8px;">
							<label class="radio-inline">
							<input type="radio" name="isExistingInvestment" value="0" <c:if test="${equityDealTeam.isExistingInvestment==0 }">checked="true"</c:if>> Y </label>
							<label class="radio-inline">
							<input type="radio" name="isExistingInvestment" value="1" <c:if test="${equityDealTeam.isExistingInvestment==1 }">checked="true"</c:if>> N </label>
						</div>
						<div style="text-align: left;" class="col-md-10" >
							2. Is the portco an existing investment of another fund not investing in this round? (Conflicts review)
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-2" style="top: -8px;">
							<label class="radio-inline">
							<input type="radio" name="isWarrants" value="0" <c:if test="${equityDealTeam.isWarrants==0 }">checked="true"</c:if>> Y </label>
							<label class="radio-inline">
							<input type="radio" name="isWarrants" value="1" <c:if test="${equityDealTeam.isWarrants==1 }">checked="true"</c:if>> N </label>
						</div>
						<div style="text-align: left;" class="col-md-10" >
							3. Any attached options/warrants/puts/calls?
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-2" style="top: -8px;">
							<label class="radio-inline">
							<input type="radio" name="isTransaction" value="0" <c:if test="${equityDealTeam.isTransaction==0 }">checked="true"</c:if>> Y </label>
							<label class="radio-inline">
							<input type="radio" name="isTransaction" value="1" <c:if test="${equityDealTeam.isTransaction==1 }">checked="true"</c:if>> N </label>
						</div>
						<div style="text-align: left;" class="col-md-10" >
							4. Is Sequoia pledging anything in connection with this transaction?
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-2" style="top: -8px;">
							<label class="radio-inline">
							<input type="radio" name="isTransfer" value="0" <c:if test="${equityDealTeam.isTransfer==0 }">checked="true"</c:if>> Y </label>
							<label class="radio-inline">
							<input type="radio" name="isTransfer" value="1" <c:if test="${equityDealTeam.isTransfer==1 }">checked="true"</c:if>> N </label>
						</div>
						<div style="text-align: left;" class="col-md-10" >
							5. Any unusual limitations on sale/transfer? 
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-2" style="top: -8px;">
							<label class="radio-inline">
							<input type="radio" name="isAssociated" value="0" <c:if test="${equityDealTeam.isAssociated==0 }">checked="true"</c:if>> Y </label>
							<label class="radio-inline">
							<input type="radio" name="isAssociated" value="1" <c:if test="${equityDealTeam.isAssociated==1 }">checked="true"</c:if>> N </label>
						</div>
						<div style="text-align: left;" class="col-md-10" >
							6. Is there an NDA associated with this investment?
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-2" style="top: -8px;">
							<label class="radio-inline">
							<input type="radio" name="isGlobalGrowth" value="0" <c:if test="${equityDealTeam.isGlobalGrowth==0 }">checked="true"</c:if>> Y </label>
							<label class="radio-inline">
							<input type="radio" name="isGlobalGrowth" value="1" <c:if test="${equityDealTeam.isGlobalGrowth==1 }">checked="true"</c:if>> N </label>
						</div>
						<div style="text-align: left;" class="col-md-10" >
							7. Will a US fund or Global Growth be co‐investing?
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-2" style="top: -8px;">
							<label class="radio-inline">
							<input type="radio" name="isConsidered" value="0" <c:if test="${equityDealTeam.isConsidered==0 }">checked="true"</c:if>> Y </label>
							<label class="radio-inline">
							<input type="radio" name="isConsidered" value="1" <c:if test="${equityDealTeam.isConsidered==1 }">checked="true"</c:if>> N </label>
						</div>
						<div style="text-align: left;" class="col-md-10" >
							8. Have you considered if there is an HSR issue?
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-2" style="top: -8px;">
							<label class="radio-inline">
							<input type="radio" name="isUncollateralized" value="0" <c:if test="${equityDealTeam.isUncollateralized==0 }">checked="true"</c:if>> Y </label>
							<label class="radio-inline">
							<input type="radio" name="isUncollateralized" value="1" <c:if test="${equityDealTeam.isUncollateralized==1 }">checked="true"</c:if>> N </label>
						</div>
						<div style="text-align: left;" class="col-md-10" >
							9. Is there an uncollateralized loan? (Structure review)
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-2" style="top: -8px;">
							<label class="radio-inline">
							<input type="radio" name="isCreatedSpv" value="0" <c:if test="${equityDealTeam.isCreatedSpv==0 }">checked="true"</c:if>> Y </label>
							<label class="radio-inline">
							<input type="radio" name="isCreatedSpv" value="1" <c:if test="${equityDealTeam.isCreatedSpv==1 }">checked="true"</c:if>> N </label>
						</div>
						<div style="text-align: left;" class="col-md-10" >
							10. Is this investment being made through a newly created spv? 
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-2" style="top: -8px;">
							<label class="radio-inline">
							<input type="radio" name="isMatures" value="0" <c:if test="${equityDealTeam.isMatures==0 }">checked="true"</c:if>> Y </label>
							<label class="radio-inline">
							<input type="radio" name="isMatures" value="1" <c:if test="${equityDealTeam.isMatures==1 }">checked="true"</c:if>> N </label>
						</div>
						<div style="text-align: left;" class="col-md-10" >
							11. Is there a likely possibility that the specific Sequoia fund will be forced to sell/forfeit its investment before the investment matures (e.g., pursuant to a de-Red Chip transaction)?
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-2" style="top: -8px;">
							<label class="radio-inline">
							<input type="radio" name="isPeriod" value="0" <c:if test="${equityDealTeam.isPeriod==0 }">checked="true"</c:if>> Y </label>
							<label class="radio-inline">
							<input type="radio" name="isPeriod" value="1" <c:if test="${equityDealTeam.isPeriod==1 }">checked="true"</c:if>> N </label>
						</div>
						<div style="text-align: left;" class="col-md-10" >
							12. Do the deal documents impose obligations on the specific Sequoia fund that are likely to extend beyond the fund's term and a reasonable winding-up period?
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-2" style="top: -8px;">
							<label class="radio-inline">
							<input type="radio" name="isExpressly" value="0" <c:if test="${equityDealTeam.isExpressly==0 }">checked="true"</c:if>> Y </label>
							<label class="radio-inline">
							<input type="radio" name="isExpressly" value="1" <c:if test="${equityDealTeam.isExpressly==1 }">checked="true"</c:if>> N </label>
						</div>
						<div style="text-align: left;" class="col-md-10" >
							13. Do the deal documents expressly contemplate a restructure or similar transaction that might be taxable to a Sequoia fund, but not yield cash to cover the taxes?
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-2" style="top: -8px;">
							<label class="radio-inline">
							<input type="radio" name="isSecurities" value="0" <c:if test="${equityDealTeam.isSecurities==0 }">checked="true"</c:if>> Y </label>
							<label class="radio-inline">
							<input type="radio" name="isSecurities" value="1" <c:if test="${equityDealTeam.isSecurities==1 }">checked="true"</c:if>> N </label>
						</div>
						<div style="text-align: left;" class="col-md-10" >
							14. Will Sequoia use leverage to acquire the securities (ignore short term borrowing to bridge a capital call)
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-2" style="top: -8px;">
							<label class="radio-inline">
							<input type="radio" name="isEntity" value="0" <c:if test="${equityDealTeam.isEntity==0 }">checked="true"</c:if>> Y </label>
							<label class="radio-inline">
							<input type="radio" name="isEntity" value="1" <c:if test="${equityDealTeam.isEntity==1 }">checked="true"</c:if>> N </label>
						</div>
						<div style="text-align: left;" class="col-md-10" >
							15. Is issuer a flow‐through entity (e.g., a partnership or LLC)
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-2" style="top: -8px;">
							<label class="radio-inline">
							<input type="radio" name="isCompensation" value="0" <c:if test="${equityDealTeam.isCompensation==0 }">checked="true"</c:if>> Y </label>
							<label class="radio-inline">
							<input type="radio" name="isCompensation" value="1" <c:if test="${equityDealTeam.isCompensation==1 }">checked="true"</c:if>> N </label>
						</div>
						<div style="text-align: left;" class="col-md-10" >
							16. Are we receiving securities or other compensation for services?
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-2" style="top: -8px;">
							<label class="radio-inline">
							<input type="radio" name="isParticipating" value="0" <c:if test="${equityDealTeam.isParticipating==0 }">checked="true"</c:if>> Y </label>
							<label class="radio-inline">
							<input type="radio" name="isParticipating" value="1" <c:if test="${equityDealTeam.isParticipating==1 }">checked="true"</c:if>> N </label>
						</div>
						<div style="text-align: left;" class="col-md-10" >
							17. Are we receiving a “better deal” than other investors participating in the same round(e.g., securities at a lower price than other investors or better terms than are being received by other investors paying the same price)? (No need to highlight receipt of a standard management rights letter or board seat.)
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-2" style="top: -8px;">
							<label class="radio-inline">
							<input type="radio" name="isSecondary" value="0" <c:if test="${equityDealTeam.isSecondary==0 }">checked="true"</c:if>> Y </label>
							<label class="radio-inline">
							<input type="radio" name="isSecondary" value="1" <c:if test="${equityDealTeam.isSecondary==1 }">checked="true"</c:if>> N </label>
						</div>
						<div style="text-align: left;" class="col-md-10" >
							18. Will the securities be acquired on a secondary basis (as opposed to directly from issuer)?
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-2" style="top: -8px;">
							<label class="radio-inline">
							<input type="radio" name="isConvertible" value="0" <c:if test="${equityDealTeam.isConvertible==0 }">checked="true"</c:if>> Y </label>
							<label class="radio-inline">
							<input type="radio" name="isConvertible" value="1" <c:if test="${equityDealTeam.isConvertible==1 }">checked="true"</c:if>> N </label>
						</div>
						<div style="text-align: left;" class="col-md-10" >
							19. Are we purchasing non‐convertible debt (as opposed to convertible debt or equity)?
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-2" style="top: -8px;">
							<label class="radio-inline">
							<input type="radio" name="isAffiliate" value="0" <c:if test="${equityDealTeam.isAffiliate==0 }">checked="true"</c:if>> Y </label>
							<label class="radio-inline">
							<input type="radio" name="isAffiliate" value="1" <c:if test="${equityDealTeam.isAffiliate==1 }">checked="true"</c:if>> N </label>
						</div>
						<div style="text-align: left;" class="col-md-10" >
							20. Is issuer publicly traded, an affiliate of a public company, or is this a "take private" deal?
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-2" style="top: -8px;">
							<label class="radio-inline">
							<input type="radio" name="isOperatingCompany" value="0" <c:if test="${equityDealTeam.isOperatingCompany==0 }">checked="true"</c:if>> Y </label>
							<label class="radio-inline">
							<input type="radio" name="isOperatingCompany" value="1" <c:if test="${equityDealTeam.isOperatingCompany==1 }">checked="true"</c:if>> N </label>
						</div>
						<div style="text-align: left;" class="col-md-10" >
							21. Is the issuer a fund, commodity pool or other type of investment company (as opposed to an operating company)?
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-2" style="top: -8px;">
							<label class="radio-inline">
							<input type="radio" name="isGuarantee" value="0" <c:if test="${equityDealTeam.isGuarantee==0 }">checked="true"</c:if>> Y </label>
							<label class="radio-inline">
							<input type="radio" name="isGuarantee" value="1" <c:if test="${equityDealTeam.isGuarantee==1 }">checked="true"</c:if>> N </label>
						</div>
						<div style="text-align: left;" class="col-md-10" >
							22. Will Sequoia provide any guarantee of debt?
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-2" style="top: -8px;">
							<label class="radio-inline">
							<input type="radio" name="isMilitary" value="0" <c:if test="${equityDealTeam.isMilitary==0 }">checked="true"</c:if>> Y </label>
							<label class="radio-inline">
							<input type="radio" name="isMilitary" value="1" <c:if test="${equityDealTeam.isMilitary==1 }">checked="true"</c:if>> N </label>
						</div>
						<div style="text-align: left;" class="col-md-10" >
							23. Is issuer a registered defense/military contractor, exporter or broker; or a producer of weapons?
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-2" style="top: -8px;">
							<label class="radio-inline">
							<input type="radio" name="isRegulated" value="0" <c:if test="${equityDealTeam.isRegulated==0 }">checked="true"</c:if>> Y </label>
							<label class="radio-inline">
							<input type="radio" name="isRegulated" value="1" <c:if test="${equityDealTeam.isRegulated==1 }">checked="true"</c:if>> N </label>
						</div>
						<div style="text-align: left;" class="col-md-10" >
							24. Is issuer a regulated communication company involved with radio stations, television, cable or newspapers?
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-2" style="top: -8px;">
							<label class="radio-inline">
							<input type="radio" name="isHoldSubstantial" value="0" <c:if test="${equityDealTeam.isHoldSubstantial==0 }">checked="true"</c:if>> Y </label>
							<label class="radio-inline">
							<input type="radio" name="isHoldSubstantial" value="1" <c:if test="${equityDealTeam.isHoldSubstantial==1 }">checked="true"</c:if>> N </label>
						</div>
						<div style="text-align: left;" class="col-md-10" >
							25. Does issuer hold substantial real estate or natural resources?
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-2" style="top: -8px;">
							<label class="radio-inline">
							<input type="radio" name="isRegulatedEntity" value="0" <c:if test="${equityDealTeam.isRegulatedEntity==0 }">checked="true"</c:if>> Y </label>
							<label class="radio-inline">
							<input type="radio" name="isRegulatedEntity" value="1" <c:if test="${equityDealTeam.isRegulatedEntity==1 }">checked="true"</c:if>> N </label>
						</div>
						<div style="text-align: left;" class="col-md-10" >
							26. Is issuer a regulated entity?
							 (e.g. a broker, bank / bank holding company, insurance company, financial services organization, dealer in securities or commodities, member of a securities or commodities exchange, commodity pool operator, registered small business investment company, registered investment adviser, telecom carrier, airline, transportation common carrier, electric or other public utility, or operator of a money services business)
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-2" style="top: -8px;">
							<label class="radio-inline">
							<input type="radio" name="isIncludeProduction" value="0" <c:if test="${equityDealTeam.isIncludeProduction==0 }">checked="true"</c:if>> Y </label>
							<label class="radio-inline">
							<input type="radio" name="isIncludeProduction" value="1" <c:if test="${equityDealTeam.isIncludeProduction==1 }">checked="true"</c:if>> N </label>
						</div>
						<div style="text-align: left;" class="col-md-10" >
							27. Does issuer's business include production/sale of alcohol, tobacco or firearms (other than on a de minimis basis)?
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-2" style="top: -8px;">
							<label class="radio-inline">
							<input type="radio" name="isConcurrentInvestment" value="0" <c:if test="${equityDealTeam.isConcurrentInvestment==0 }">checked="true"</c:if>> Y </label>
							<label class="radio-inline">
							<input type="radio" name="isConcurrentInvestment" value="1" <c:if test="${equityDealTeam.isConcurrentInvestment==1 }">checked="true"</c:if>> N </label>
						</div>
						<div style="text-align: left;" class="col-md-10" >
							28. Any prior or concurrent investment in issuer by current Sequoia personnel?
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-2" style="top: -8px;">
							<label class="radio-inline">
							<input type="radio" name="isPartiesInvolved" value="0" <c:if test="${equityDealTeam.isPartiesInvolved==0 }">checked="true"</c:if>> Y </label>
							<label class="radio-inline">
							<input type="radio" name="isPartiesInvolved" value="1" <c:if test="${equityDealTeam.isPartiesInvolved==1 }">checked="true"</c:if>> N </label>
						</div>
						<div style="text-align: left;" class="col-md-10" >
							29. Any related parties involved? Including Noah, Huatai, Hongshang, portcos and GP investments. 
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-2" style="top: -8px;">
							<label class="radio-inline">
							<input type="radio" name="isPostInvestment" value="0" <c:if test="${equityDealTeam.isPostInvestment==0 }">checked="true"</c:if>> Y </label>
							<label class="radio-inline">
							<input type="radio" name="isPostInvestment" value="1" <c:if test="${equityDealTeam.isPostInvestment==1 }">checked="true"</c:if>> N </label>
						</div>
						<div style="text-align: left;" class="col-md-10" >
							30. Post investment, will the fund have invested >10% of its committed capital into this issuer (and its affiliates)?
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-2" style="top: -8px;">
							<label class="radio-inline">
							<input type="radio" name="isFundManagers" value="0" <c:if test="${equityDealTeam.isFundManagers==0 }">checked="true"</c:if>> Y </label>
							<label class="radio-inline">
							<input type="radio" name="isFundManagers" value="1" <c:if test="${equityDealTeam.isFundManagers==1 }">checked="true"</c:if>> N </label>
						</div>
						<div style="text-align: left;" class="col-md-10" >
							31. Is the issuer a venture capital or other type of investment fund that pays carry or fees to its fund managers? 
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-2" style="top: -8px;">
							<label class="radio-inline">
							<input type="radio" name="isStructure" value="0" <c:if test="${equityDealTeam.isStructure==0 }">checked="true"</c:if>> Y </label>
							<label class="radio-inline">
							<input type="radio" name="isStructure" value="1" <c:if test="${equityDealTeam.isStructure==1 }">checked="true"</c:if>> N </label>
						</div>
						<div style="text-align: left;" class="col-md-10" >
							32. Does the structure of the investment involve non‐standard chains of ownership/title?
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-2" style="top: -8px;">
							<label class="radio-inline">
							<input type="radio" name="isMakingPayment" value="0" <c:if test="${equityDealTeam.isMakingPayment==0 }">checked="true"</c:if>> Y </label>
							<label class="radio-inline">
							<input type="radio" name="isMakingPayment" value="1" <c:if test="${equityDealTeam.isMakingPayment==1 }">checked="true"</c:if>> N </label>
						</div>
						<div style="text-align: left;" class="col-md-10" >
							33. Excluding secondary transactions, are we making payment to persons other than the issuer?
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-2" style="top: -8px;">
							<label class="radio-inline">
							<input type="radio" name="isInvestmentPurposes" value="0" <c:if test="${equityDealTeam.isInvestmentPurposes==0 }">checked="true"</c:if>> Y </label>
							<label class="radio-inline">
							<input type="radio" name="isInvestmentPurposes" value="1" <c:if test="${equityDealTeam.isInvestmentPurposes==1 }">checked="true"</c:if>> N </label>
						</div>
						<div style="text-align: left;" class="col-md-10" >
							34.  Are you utilizing derivative financial instruments for speculative investment purposes?
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-2" style="top: -8px;">
							<label class="radio-inline">
							<input type="radio" name="isAggregateCapital" value="0" <c:if test="${equityDealTeam.isAggregateCapital==0 }">checked="true"</c:if>> Y </label>
							<label class="radio-inline">
							<input type="radio" name="isAggregateCapital" value="1" <c:if test="${equityDealTeam.isAggregateCapital==1 }">checked="true"</c:if>> N </label>
						</div>
						<div style="text-align: left;" class="col-md-10" >
							35.  Are you investing > 10% of the aggregate capital commitment of the Fund in a single portfolio company?
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-2" style="top: -8px;">
							<label class="radio-inline">
							<input type="radio" name="isExistingClaims" value="0" <c:if test="${equityDealTeam.isExistingClaims==0 }">checked="true"</c:if>> Y </label>
							<label class="radio-inline">
							<input type="radio" name="isExistingClaims" value="1" <c:if test="${equityDealTeam.isExistingClaims==1 }">checked="true"</c:if>> N </label>
						</div>
						<div style="text-align: left;" class="col-md-10" >
							36. As part of the deal, is Sequoia settling, abandoning or terminating any existing claims that are part of a bona fide legal or governmental proceeding?
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-2" style="top: -8px;">
							<label class="radio-inline">
							<input type="radio" name="isCurrency" value="0" <c:if test="${equityDealTeam.isCurrency==0 }">checked="true"</c:if>> Y </label>
							<label class="radio-inline">
							<input type="radio" name="isCurrency" value="1" <c:if test="${equityDealTeam.isCurrency==1 }">checked="true"</c:if>> N </label>
						</div>
						<div style="text-align: left;" class="col-md-10" >
							37. Is the investment security denominated in, or redeemable for, a non-convertible currency (e.g., RMB)?
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-2" style="top: -8px;">
							<label class="radio-inline">
							<input type="radio" name="isSequoiaIndividual" value="0" <c:if test="${equityDealTeam.isSequoiaIndividual==0 }">checked="true"</c:if>> Y </label>
							<label class="radio-inline">
							<input type="radio" name="isSequoiaIndividual" value="1" <c:if test="${equityDealTeam.isSequoiaIndividual==1 }">checked="true"</c:if>> N </label>
						</div>
						<div style="text-align: left;" class="col-md-10" >
							38. Does any Sequoia individual have a pre-existing interest in the issuer or non-Sequoia co-investor (other than through a Sequoia fund)?
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-2" style="top: -8px;">
							<label class="radio-inline">
							<input type="radio" name="isSimultaneousInvestment" value="0" <c:if test="${equityDealTeam.isSimultaneousInvestment==0 }">checked="true"</c:if>> Y </label>
							<label class="radio-inline">
							<input type="radio" name="isSimultaneousInvestment" value="1" <c:if test="${equityDealTeam.isSimultaneousInvestment==1 }">checked="true"</c:if>> N </label>
						</div>
						<div style="text-align: left;" class="col-md-10" >
							39. Will any Sequoia individual make a simultaneous investment in the issuer (other than through a Sequoia fund)?
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-2" style="top: -8px;">
							<label class="radio-inline">
							<input type="radio" name="isEitherShould" value="0" <c:if test="${equityDealTeam.isEitherShould==0 }">checked="true"</c:if>> Y </label>
							<label class="radio-inline">
							<input type="radio" name="isEitherShould" value="1" <c:if test="${equityDealTeam.isEitherShould==1 }">checked="true"</c:if>> N </label>
						</div>
						<div style="text-align: left;" class="col-md-10" >
							40. Will any Sequoia individual/entity receive fees/other benefits that either should be shared with a fund or may be to the detriment of a fund?
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</form>

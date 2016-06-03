<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
<form id="teamWindowForm">
	<input type="hidden" name="file" value="complianceDeal_P-note.xls">
	<input type="hidden" name="exportTitle" value="ComPliance Deal P-note">
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
								<input type="radio" name="affiliatedEntity" value="0" <c:if test="${dealTeam.affiliatedEntity==0 }">checked="true"</c:if>> Y </label>
								<label class="radio-inline">
								<input type="radio" name="affiliatedEntity" value="1" <c:if test="${dealTeam.affiliatedEntity==1 }">checked="true"</c:if>> N </label>
							</div>
							<div class="col-md-10" align="left">
								1. Is this investment being made into an affiliated entity of an existing portfolio company? (Conflicts review) 
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-2" style="top:-8px;">
								<label class="radio-inline">
								<input type="radio" name="fundNotInvesting" value="0" <c:if test="${dealTeam.fundNotInvesting==0 }">checked="true"</c:if>> Y </label>
								<label class="radio-inline">
								<input type="radio" name="fundNotInvesting" value="1" <c:if test="${dealTeam.fundNotInvesting==1 }">checked="true"</c:if>> N </label>
							</div>
							<div class="col-md-10" align="left">
								2. Is the portco an existing investment of another fund not investing in this round? (Conflicts review)
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-2" style="top:-8px;">
								<label class="radio-inline">
								<input type="radio" name="anyAttachedOptions" value="0" <c:if test="${dealTeam.anyAttachedOptions==0 }">checked="true"</c:if>> Y </label>
								<label class="radio-inline">
								<input type="radio" name="anyAttachedOptions" value="1" <c:if test="${dealTeam.anyAttachedOptions==1 }">checked="true"</c:if>> N </label>
							</div>
							<div class="col-md-10" align="left">
								3.Any attached options/warrants/puts/calls?
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-2" style="top:-8px;">
								<label class="radio-inline">
								<input type="radio" name="pledgingTransaction" value="0" <c:if test="${dealTeam.pledgingTransaction==0 }">checked="true"</c:if>> Y </label>
								<label class="radio-inline">
								<input type="radio" name="pledgingTransaction" value="1" <c:if test="${dealTeam.pledgingTransaction==1 }">checked="true"</c:if>> N </label>
							</div>
							<div class="col-md-10" align="left">
								4. Is Sequoia pledging anything in connection with this transaction?
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-2" style="top:-8px;">
								<label class="radio-inline">
								<input type="radio" name="unusualLimitations" value="0" <c:if test="${dealTeam.unusualLimitations==0 }">checked="true"</c:if>> Y </label>
								<label class="radio-inline">
								<input type="radio" name="unusualLimitations" value="1" <c:if test="${dealTeam.unusualLimitations==1 }">checked="true"</c:if>> N </label>
							</div>
							<div class="col-md-10" align="left">
								5. Any unusual limitations on sale/transfer? If yes, explain 
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-2" style="top:-8px;">
								<label class="radio-inline">
								<input type="radio" name="investmentNDA" value="0" <c:if test="${dealTeam.investmentNDA==0 }">checked="true"</c:if>> Y </label>
								<label class="radio-inline">
								<input type="radio" name="investmentNDA" value="1" <c:if test="${dealTeam.investmentNDA==1 }">checked="true"</c:if>> N </label>
							</div>
							<div class="col-md-10" align="left">
								6. Is there an NDA associated with this investment?
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-2" style="top:-8px;">
								<label class="radio-inline">
								<input type="radio" name="globalGrowthinvesting" value="0" <c:if test="${dealTeam.globalGrowthinvesting==0 }">checked="true"</c:if>> Y </label>
								<label class="radio-inline">
								<input type="radio" name="globalGrowthinvesting" value="1" <c:if test="${dealTeam.globalGrowthinvesting==1 }">checked="true"</c:if>> N </label>
							</div>
							<div class="col-md-10" align="left">
								7. Will a US fund or Global Growth be co‐investing?
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-2" style="top:-8px;">
								<label class="radio-inline">
								<input type="radio" name="hsrIssue" value="0" <c:if test="${dealTeam.hsrIssue==0 }">checked="true"</c:if>> Y </label>
								<label class="radio-inline">
								<input type="radio" name="hsrIssue" value="1" <c:if test="${dealTeam.hsrIssue==1 }">checked="true"</c:if>> N </label>
							</div>
							<div class="col-md-10" align="left">
								8. Have you considered if there is an HSR issue?
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-2" style="top:-8px;">
								<label class="radio-inline">
								<input type="radio" name="uncollateralizedLoan" value="0" <c:if test="${dealTeam.uncollateralizedLoan==0 }">checked="true"</c:if>> Y </label>
								<label class="radio-inline">
								<input type="radio" name="uncollateralizedLoan" value="1" <c:if test="${dealTeam.uncollateralizedLoan==1 }">checked="true"</c:if>> N </label>
							</div>
							<div class="col-md-10" align="left">
								9. Is there an uncollateralized loan? (Structure review)
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-2" style="top:-8px;">
								<label class="radio-inline">
								<input type="radio" name="newlyCreatedSpv" value="0" <c:if test="${dealTeam.newlyCreatedSpv==0 }">checked="true"</c:if>> Y </label>
								<label class="radio-inline">
								<input type="radio" name="newlyCreatedSpv" value="1" <c:if test="${dealTeam.newlyCreatedSpv==1 }">checked="true"</c:if>> N </label>
							</div>
							<div class="col-md-10" align="left">
								10. Is this investment being made through a newly created spv? If yes, why? (Structure review)
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-2" style="top:-8px;">
								<label class="radio-inline">
								<input type="radio" name="forfeitInvestment" value="0" <c:if test="${dealTeam.forfeitInvestment==0 }">checked="true"</c:if>> Y </label>
								<label class="radio-inline">
								<input type="radio" name="forfeitInvestment" value="1" <c:if test="${dealTeam.forfeitInvestment==1 }">checked="true"</c:if>> N </label>
							</div>
							<div class="col-md-10" align="left">
								11. Is there a likely possibility that the specific Sequoia fund will be forced to sell/forfeit its investment before the investment matures (e.g., pursuant to a de-Red Chip transaction)?
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-2" style="top:-8px;">
								<label class="radio-inline">
								<input type="radio" name="extendBeyondDebt" value="0" <c:if test="${dealTeam.extendBeyondDebt==0 }">checked="true"</c:if>> Y </label>
								<label class="radio-inline">
								<input type="radio" name="extendBeyondDebt" value="1" <c:if test="${dealTeam.extendBeyondDebt==1 }">checked="true"</c:if>> N </label>
							</div>
							<div class="col-md-10" align="left">
								12. Do the deal documents impose obligations on the specific Sequoia fund that are likely to extend beyond the 
								fund's term and a reasonable winding-up period?
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-2" style="top:-8px;">
								<label class="radio-inline">
								<input type="radio" name="coverTheTaxes" value="0" <c:if test="${dealTeam.coverTheTaxes==0 }">checked="true"</c:if>> Y </label>
								<label class="radio-inline">
								<input type="radio" name="coverTheTaxes" value="1" <c:if test="${dealTeam.coverTheTaxes==1 }">checked="true"</c:if>> N </label>
							</div>
							<div class="col-md-10" align="left">
								13. Do the deal documents expressly contemplate a restructure or similar transaction that might be taxable to a Sequoia fund, but not yield cash to cover the taxes?
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-2" style="top:-8px;">
								<label class="radio-inline">
								<input type="radio" name="useLeverageAcquire" value="0" <c:if test="${dealTeam.useLeverageAcquire==0 }">checked="true"</c:if>> Y </label>
								<label class="radio-inline">
								<input type="radio" name="useLeverageAcquire" value="1" <c:if test="${dealTeam.useLeverageAcquire==1 }">checked="true"</c:if>> N </label>
							</div>
							<div class="col-md-10" align="left">
								14. Will Sequoia use leverage to acquire the securities (ignore short term borrowing to bridge a capital call)
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-2" style="top:-8px;">
								<label class="radio-inline">
								<input type="radio" name="businessOrholdSecurities" value="0" <c:if test="${dealTeam.businessOrholdSecurities==0 }">checked="true"</c:if>> Y </label>
								<label class="radio-inline">
								<input type="radio" name="businessOrholdSecurities" value="1" <c:if test="${dealTeam.businessOrholdSecurities==1 }">checked="true"</c:if>> N </label>
							</div>
							<div class="col-md-10" align="left">
								15. Is issuer a flow‐through entity (e.g., a partnership or LLC) a business, or merely hold securities? 
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-2" style="top:-8px;">
								<label class="radio-inline">
								<input type="radio" name="areWeReceivingCompensation " value="0" <c:if test="${dealTeam.areWeReceivingCompensation==0 }">checked="true"</c:if>> Y </label>
								<label class="radio-inline">
								<input type="radio" name="areWeReceivingCompensation" value="1" <c:if test="${dealTeam.areWeReceivingCompensation==1 }">checked="true"</c:if>> N </label>
							</div>
							<div class="col-md-10" align="left">
								16. Are we receiving securities or other compensation for services?
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-2" style="top:-8px;">
								<label class="radio-inline">
								<input type="radio" name="receivingBetterDeal" value="0" <c:if test="${dealTeam.receivingBetterDeal==0 }">checked="true"</c:if>> Y </label>
								<label class="radio-inline">
								<input type="radio" name="receivingBetterDeal" value="1" <c:if test="${dealTeam.receivingBetterDeal==1 }">checked="true"</c:if>> N </label>
							</div>
							<div class="col-md-10" align="left">
								17. Are we receiving a “better deal” than other investors participating in the same round (e.g., securities at a lower price than other investors or better terms than are being 
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-2" style="top:-8px;">
								<label class="radio-inline">
								<input type="radio" name="geosShouldAnswer" value="0" <c:if test="${dealTeam.geosShouldAnswer==0 }">checked="true"</c:if>> Y </label>
								<label class="radio-inline">
								<input type="radio" name="geosShouldAnswer" value="1" <c:if test="${dealTeam.geosShouldAnswer==1 }">checked="true"</c:if>> N </label>
							</div>
							<div class="col-md-10" align="left">
								18. most relevant for US and Israel funds + Global Growth, but all geos should answer
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-2" style="top:-8px;">
								<label class="radio-inline">
								<input type="radio" name="issuerOpposed " value="0" <c:if test="${dealTeam.issuerOpposed==0 }">checked="true"</c:if>> Y </label>
								<label class="radio-inline">
								<input type="radio" name="issuerOpposed" value="1" <c:if test="${dealTeam.issuerOpposed==1 }">checked="true"</c:if>> N </label>
							</div>
							<div class="col-md-10" align="left">
								19. Will the securities be acquired on a secondary basis (as opposed to directly from issuer)?
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-2" style="top:-8px;">
								<label class="radio-inline">
								<input type="radio" name="areWePurchasing" value="0" <c:if test="${dealTeam.areWePurchasing==0 }">checked="true"</c:if>> Y </label>
								<label class="radio-inline">
								<input type="radio" name="areWePurchasing" value="1" <c:if test="${dealTeam.areWePurchasing==1 }">checked="true"</c:if>> N </label>
							</div>
							<div class="col-md-10" align="left">
								20. Are we purchasing non‐convertible debt (as opposed to convertible debt or equity)?
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-2" style="top:-8px;">
								<label class="radio-inline">
								<input type="radio" name="akepPrivateDeal" value="0" <c:if test="${dealTeam.akepPrivateDeal==0 }">checked="true"</c:if>> Y </label>
								<label class="radio-inline">
								<input type="radio" name="akepPrivateDeal" value="1" <c:if test="${dealTeam.akepPrivateDeal==1 }">checked="true"</c:if>> N </label>
							</div>
							<div class="col-md-10" align="left">
								21. Is issuer publicly traded, an affiliate of a public company, or is this a "take private" deal?
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-2" style="top:-8px;">
								<label class="radio-inline">
								<input type="radio" name="issuerFund" value="0" <c:if test="${dealTeam.issuerFund==0 }">checked="true"</c:if>> Y </label>
								<label class="radio-inline">
								<input type="radio" name="issuerFund" value="1" <c:if test="${dealTeam.issuerFund==1 }">checked="true"</c:if>> N </label>
							</div>
							<div class="col-md-10" align="left">
								22. Is the issuer a fund, commodity pool or other type of investment company (as opposed to an operating company)?
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-2" style="top:-8px;">
								<label class="radio-inline">
								<input type="radio" name="anyGuarantee" value="0" <c:if test="${dealTeam.anyGuarantee==0 }">checked="true"</c:if>> Y </label>
								<label class="radio-inline">
								<input type="radio" name="anyGuarantee" value="1" <c:if test="${dealTeam.anyGuarantee==1 }">checked="true"</c:if>> N </label>
							</div>
							<div class="col-md-10" align="left">
								23. Will Sequoia provide any guarantee of debt? If so, specify to whom, amount and term.
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-2" style="top:-8px;">
								<label class="radio-inline">
								<input type="radio" name="defenseOrmilitary " value="0" <c:if test="${dealTeam.defenseOrmilitary==0 }">checked="true"</c:if>> Y </label>
								<label class="radio-inline">
								<input type="radio" name="defenseOrmilitary" value="1" <c:if test="${dealTeam.defenseOrmilitary==1 }">checked="true"</c:if>> N </label>
							</div>
							<div class="col-md-10" align="left">
								24. Is issuer a registered defense/military contractor, exporter or broker; or a producer of weapons?
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-2" style="top:-8px;">
								<label class="radio-inline">
								<input type="radio" name="issuerInvolved" value="0" <c:if test="${dealTeam.issuerInvolved==0 }">checked="true"</c:if>> Y </label>
								<label class="radio-inline">
								<input type="radio" name="issuerInvolved" value="1" <c:if test="${dealTeam.issuerInvolved==1 }">checked="true"</c:if>> N </label>
							</div>
							<div class="col-md-10" align="left">
								25. Is issuer a regulated communication company involved with radio stations, television, cable or newspapers?
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-2" style="top:-8px;">
								<label class="radio-inline">
								<input type="radio" name="doesIssuerHoldResources" value="0" <c:if test="${dealTeam.doesIssuerHoldResources==0 }">checked="true"</c:if>> Y </label>
								<label class="radio-inline">
								<input type="radio" name="doesIssuerHoldResources" value="1" <c:if test="${dealTeam.doesIssuerHoldResources==1 }">checked="true"</c:if>> N </label>
							</div>
							<div class="col-md-10" align="left">
								26. Does issuer hold substantial real estate or natural resources?
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-2" style="top:-8px;">
								<label class="radio-inline">
								<input type="radio" name="issueraRegulatedentity" value="0" <c:if test="${dealTeam.issueraRegulatedentity==0 }">checked="true"</c:if>> Y </label>
								<label class="radio-inline">
								<input type="radio" name="issueraRegulatedentity" value="1" <c:if test="${dealTeam.issueraRegulatedentity==1 }">checked="true"</c:if>> N </label>
							</div>
							<div class="col-md-10" align="left">
								27. Is issuer a regulated entity? (e.g. a broker, bank / bank holding company, insurance company, financial services organization, dealer in securities or commodities, member of a securities or commodities exchange, commodity pool operator, registered small business investment company, registered investment adviser, telecom carrier, airline, transportation common carrier, electric or other public utility, or operator of a money services business)
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-2" style="top:-8px;">
								<label class="radio-inline">
								<input type="radio" name="issuersBusiness" value="0" <c:if test="${dealTeam.issuersBusiness==0 }">checked="true"</c:if>> Y </label>
								<label class="radio-inline">
								<input type="radio" name="issuersBusiness" value="1" <c:if test="${dealTeam.issuersBusiness==1 }">checked="true"</c:if>> N </label>
							</div>
							<div class="col-md-10" align="left">
								28. Does issuer's business include production/sale of alcohol, tobacco or firearms (other than on a de minimis basis)?
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-2" style="top:-8px;">
								<label class="radio-inline">
								<input type="radio" name="sequoiaPersonnel" value="0" <c:if test="${dealTeam.sequoiaPersonnel==0 }">checked="true"</c:if>> Y </label>
								<label class="radio-inline">
								<input type="radio" name="sequoiaPersonnel" value="1" <c:if test="${dealTeam.sequoiaPersonnel==1 }">checked="true"</c:if>> N </label>
							</div>
							<div class="col-md-10" align="left">
								29. Any prior or concurrent investment in issuer by current Sequoia personnel?
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-2" style="top:-8px;">
								<label class="radio-inline">
								<input type="radio" name="anyRelatedPartiesInvolved" value="0" <c:if test="${dealTeam.anyRelatedPartiesInvolved==0 }">checked="true"</c:if>> Y </label>
								<label class="radio-inline">
								<input type="radio" name="anyRelatedPartiesInvolved" value="1" <c:if test="${dealTeam.anyRelatedPartiesInvolved==1 }">checked="true"</c:if>> N </label>
							</div>
							<div class="col-md-10" align="left">
								30. Any related parties involved? Including Noah, Huatai, Hongshang, portcos and GP investments. If yes, explain
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-2" style="top:-8px;">
								<label class="radio-inline">
								<input type="radio" name="fundHaveInvested " value="0" <c:if test="${dealTeam.fundHaveInvested==0 }">checked="true"</c:if>> Y </label>
								<label class="radio-inline">
								<input type="radio" name="fundHaveInvested" value="1" <c:if test="${dealTeam.fundHaveInvested==1 }">checked="true"</c:if>> N </label>
							</div>
							<div class="col-md-10" align="left">
								31. Post investment, will the fund have invested >10% of its committed capital into this issuer (and its affiliates)?
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-2" style="top:-8px;">
								<label class="radio-inline">
								<input type="radio" name="issuerInvestmentFund" value="0" <c:if test="${dealTeam.issuerInvestmentFund==0 }">checked="true"</c:if>> Y </label>
								<label class="radio-inline">
								<input type="radio" name="issuerInvestmentFund" value="1" <c:if test="${dealTeam.issuerInvestmentFund==1 }">checked="true"</c:if>> N </label>
							</div>
							<div class="col-md-10" align="left">
								32. Is the issuer a venture capital or other type of investment fund that pays carry or fees to its fund managers? If yes, will the issuer provide audited GAAP financial statements? If yes, will any carry or fees be paid back to a Sequoia related entity?
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-2" style="top:-8px;">
								<label class="radio-inline">
								<input type="radio" name="investmentInvolve" value="0" <c:if test="${dealTeam.investmentInvolve==0 }">checked="true"</c:if>> Y </label>
								<label class="radio-inline">
								<input type="radio" name="investmentInvolve" value="1" <c:if test="${dealTeam.investmentInvolve==1 }">checked="true"</c:if>> N </label>
							</div>
							<div class="col-md-10" align="left">
								33. Does the structure of the investment involve non‐standard chains of ownership/title?
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-2" style="top:-8px;">
								<label class="radio-inline">
								<input type="radio" name="thanTheIssuer" value="0" <c:if test="${dealTeam.thanTheIssuer==0 }">checked="true"</c:if>> Y </label>
								<label class="radio-inline">
								<input type="radio" name="thanTheIssuer" value="1" <c:if test="${dealTeam.thanTheIssuer==1 }">checked="true"</c:if>> N </label>
							</div>
							<div class="col-md-10" align="left">
								34. Excluding secondary transactions, are we making payment to persons other than the issuer?
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-2" style="top:-8px;">
								<label class="radio-inline">
								<input type="radio" name="investmentPurposes" value="0" <c:if test="${dealTeam.investmentPurposes==0 }">checked="true"</c:if>> Y </label>
								<label class="radio-inline">
								<input type="radio" name="investmentPurposes" value="1" <c:if test="${dealTeam.investmentPurposes==1 }">checked="true"</c:if>> N </label>
							</div>
							<div class="col-md-10" align="left">
								35. Are you utilizing derivative financial instruments for speculative investment purposes?
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-2" style="top:-8px;">
								<label class="radio-inline">
								<input type="radio" name="aggregateCapitalCommitment" value="0" <c:if test="${dealTeam.aggregateCapitalCommitment==0 }">checked="true"</c:if>> Y </label>
								<label class="radio-inline">
								<input type="radio" name="aggregateCapitalCommitment" value="1" <c:if test="${dealTeam.aggregateCapitalCommitment==1 }">checked="true"</c:if>> N </label>
							</div>
							<div class="col-md-10" align="left">
								36. Are you investing > 10% of the aggregate capital commitment of the Fund in a single portfolio company?
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-2" style="top:-8px;">
								<label class="radio-inline">
								<input type="radio" name="sequoiaSettling" value="0" <c:if test="${dealTeam.sequoiaSettling==0 }">checked="true"</c:if>> Y </label>
								<label class="radio-inline">
								<input type="radio" name="sequoiaSettling" value="1" <c:if test="${dealTeam.sequoiaSettling==1 }">checked="true"</c:if>> N </label>
							</div>
							<div class="col-md-10" align="left">
								37.  As part of the deal, is Sequoia settling, abandoning or terminating any existing claims that are part of a bona fide legal or governmental proceeding?
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-2" style="top:-8px;">
								<label class="radio-inline">
								<input type="radio" name="securityenominated" value="0" <c:if test="${dealTeam.securityenominated==0 }">checked="true"</c:if>> Y </label>
								<label class="radio-inline">
								<input type="radio" name="securityenominated" value="1" <c:if test="${dealTeam.securityenominated==1 }">checked="true"</c:if>> N </label>
							</div>
							<div class="col-md-10" align="left">
								38. Is the investment security denominated in, or redeemable for, a non-convertible currency (e.g., RMB)?
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-2" style="top:-8px;">
								<label class="radio-inline">
								<input type="radio" name="preExistingInterest" value="0" <c:if test="${dealTeam.preExistingInterest==0 }">checked="true"</c:if>> Y </label>
								<label class="radio-inline">
								<input type="radio" name="preExistingInterest" value="1" <c:if test="${dealTeam.preExistingInterest==1 }">checked="true"</c:if>> N </label>
							</div>
							<div class="col-md-10" align="left">
								39. Does any Sequoia individual have a pre-existing interest in the issuer or non-Sequoia co-investor (other than through a Sequoia fund)?
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-2" style="top:-8px;">
								<label class="radio-inline">
								<input type="radio" name="simultaneousInvestment" value="0" <c:if test="${dealTeam.simultaneousInvestment==0 }">checked="true"</c:if>> Y </label>
								<label class="radio-inline">
								<input type="radio" name="simultaneousInvestment" value="1" <c:if test="${dealTeam.simultaneousInvestment==1 }">checked="true"</c:if>> N </label>
							</div>
							<div class="col-md-10" align="left">
								40. Will any Sequoia individual make a simultaneous investment in the issuer (other than through a Sequoia fund)?
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-2" style="top:-8px;">
								<label class="radio-inline">
								<input type="radio" name="benefits" value="0" <c:if test="${dealTeam.benefits==0 }">checked="true"</c:if>> Y </label>
								<label class="radio-inline">
								<input type="radio" name="benefits" value="1" <c:if test="${dealTeam.benefits==1 }">checked="true"</c:if>> N </label>
							</div>
							<div class="col-md-10" align="left">
								41. Will any Sequoia individual/entity receive fees/other benefits that either should be shared with a fund or may be to the detriment of a fund?
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-2" style="top:-8px;">
								<label class="radio-inline">
								<input type="radio" name="dealStructure" value="0" <c:if test="${dealTeam.dealStructure==0 }">checked="true"</c:if>> Y </label>
								<label class="radio-inline">
								<input type="radio" name="dealStructure" value="1" <c:if test="${dealTeam.dealStructure==1 }">checked="true"</c:if>> N </label>
							</div>
							<div class="col-md-10" align="left">
								42. Other unusual terms or notes re deal structure:
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</form>

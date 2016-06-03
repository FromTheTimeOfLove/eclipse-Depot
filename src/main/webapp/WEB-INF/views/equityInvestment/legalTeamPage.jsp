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
					<i class="fa fa-table"></i>Legal team
				</div>
				<div class="tools">
				</div>
			</div>
			<div class="portlet-body">
				<div class="form-horizontal" align="center" role="form">
					<div class="form-group">
						<div class="col-md-2" style="top: -8px;">
							<label class="radio-inline">
							<input type="radio" name="isPPM" value="0" <c:if test="${equityLegalTeam.isPPM == 0 }">checked="true"</c:if>> Y </label>
							<label class="radio-inline">
							<input type="radio" name="isPPM" value="1" <c:if test="${equityLegalTeam.isPPM == 1 }">checked="true"</c:if>> N </label>
						</div>
						<div style="text-align: left;" class="col-md-10" >
							1. Is the proposed investment outside the overall investment strategy described in the Fund's PPM?
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-2" style="top: -8px;">
							<label class="radio-inline">
							<input type="radio" name="isSequoia" value="0" <c:if test="${equityLegalTeam.isSequoia == 0 }">checked="true"</c:if>> Y </label>
							<label class="radio-inline">
							<input type="radio" name="isSequoia" value="1" <c:if test="${equityLegalTeam.isSequoia == 1 }">checked="true"</c:if>> N </label>
						</div>
						<div style="text-align: left;" class="col-md-10" >
							2. Is the specific Sequoia fund making the investment also making promises about the behavior of other Sequoia funds?
						</div>
					</div>
					<div class="form-group" align="center">
						<div class="col-md-2" style="top: -8px;">
							<label class="radio-inline">
							<input type="radio" name="isTargetCountries" value="0" <c:if test="${equityLegalTeam.isTargetCountries ==0 }">checked="true"</c:if>> Y </label>
							<label class="radio-inline">
							<input type="radio" name="isTargetCountries" value="1" <c:if test="${equityLegalTeam.isTargetCountries ==1 }">checked="true"</c:if>> N </label>
						</div>
						<div style="text-align: left;" class="col-md-10" >
							3. Is issuer domiciled outside our routine target countries (US, Cayman, BVI, Mauritius, India, PRC, HK, Israel)?
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-2" style="top: -8px;">
							<label class="radio-inline">
							<input type="radio" name="isLocalLaw" value="0" <c:if test="${equityLegalTeam.isLocalLaw ==0 }">checked="true"</c:if>> Y </label>
							<label class="radio-inline">
							<input type="radio" name="isLocalLaw" value="1" <c:if test="${equityLegalTeam.isLocalLaw ==1 }">checked="true"</c:if>> N </label>
						</div>
						<div style="text-align: left;" class="col-md-10" >
							4. Will the fund hold a controlling interest (>51% of vote) in the issuer that will trigger restrictions under local law?
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-2" style="top: -8px;">
							<label class="radio-inline">
							<input type="radio" name="isRelyingSolely" value="0" <c:if test="${equityLegalTeam.isRelyingSolely == 0 }">checked="true"</c:if>> Y </label>
							<label class="radio-inline">
							<input type="radio" name="isRelyingSolely" value="1" <c:if test="${equityLegalTeam.isRelyingSolely == 1 }">checked="true"</c:if>> N </label>
						</div>
						<div style="text-align: left;" class="col-md-10" >
							5. Is the fund relying solely on company counsel in this deal? If so, why? 
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-2" style="top: -8px;">
							<label class="radio-inline">
							<input type="radio" name="isSuerIllegal" value="0" <c:if test="${equityLegalTeam.isSuerIllegal == 0 }">checked="true"</c:if>> Y </label>
							<label class="radio-inline">
							<input type="radio" name="isSuerIllegal" value="1" <c:if test="${equityLegalTeam.isSuerIllegal == 1 }">checked="true"</c:if>> N </label>
						</div>
						<div style="text-align: left;" class="col-md-10" >
							6. CHINA SPECIFIC – Is the acceptance of this investment by the issuer illegal?
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-2" style="top: -8px;">
							<label class="radio-inline">
							<input type="radio" name="isSuchIndividual" value="0" <c:if test="${equityLegalTeam.isSuchIndividual == 0 }">checked="true"</c:if>> Y </label>
							<label class="radio-inline">
							<input type="radio" name="isSuchIndividual" value="1" <c:if test="${equityLegalTeam.isSuchIndividual == 1 }">checked="true"</c:if>> N </label>
						</div>
						<div style="text-align: left;" class="col-md-10" >
							7. Do the deal documents effectively require a Sequoia fund to indemnify a Sequoia individual in cases of "material misconduct" by such individual?
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-2" style="top: -8px;">
							<label class="radio-inline">
							<input type="radio" name="isObligation" value="0" <c:if test="${equityLegalTeam.isObligation == 0 }">checked="true"</c:if>> Y </label>
							<label class="radio-inline">
							<input type="radio" name="isObligation" value="1" <c:if test="${equityLegalTeam.isObligation == 1 }">checked="true"</c:if>> N </label>
						</div>
						<div style="text-align: left;" class="col-md-10" >
							8. Does this investment have related stock stand‐stills or does it violate an existing binding contractual obligation? 
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-2" style="top: -8px;">
							<label class="radio-inline">
							<input type="radio" name="isClauses" value="0" <c:if test="${equityLegalTeam.isClauses == 0 }">checked="true"</c:if>> Y </label>
							<label class="radio-inline">
							<input type="radio" name="isClauses" value="1" <c:if test="${equityLegalTeam.isClauses == 1 }">checked="true"</c:if>> N </label>
						</div>
						<div style="text-align: left;" class="col-md-10" >
							9.  Does this investment have any negative non-compete clauses?
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-2" style="top: -8px;">
							<label class="radio-inline">
							<input type="radio" name="isBehavior" value="0" <c:if test="${equityLegalTeam.isBehavior == 0 }">checked="true"</c:if>> Y </label>
							<label class="radio-inline">
							<input type="radio" name="isBehavior" value="1" <c:if test="${equityLegalTeam.isBehavior == 1 }">checked="true"</c:if>> N </label>
						</div>
						<div style="text-align: left;" class="col-md-10" >
							10. Does this investment circumvent any laws or do you have any reason to believe the issuer engages in any unethical behavior?
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
</form>

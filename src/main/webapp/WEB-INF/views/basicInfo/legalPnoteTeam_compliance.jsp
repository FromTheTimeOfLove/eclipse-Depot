<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
   	<form id="teamWindowForm">
		<input type="hidden" name="file" value="complianceLegal_P-note.xls">
		<input type="hidden" name="exportTitle" value="Compliance Legal P-note">
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
								<input type="radio" name="fundPPM" value="0" <c:if test="${legalTeam.fundPPM==0 }">checked="true"</c:if>> Y </label>
								<label class="radio-inline">
								<input type="radio" name="fundPPM" value="1" <c:if test="${legalTeam.fundPPM==1 }">checked="true"</c:if>> N </label>
							</div>
							<div class="col-md-10" align="left">
								1. Is the proposed investment outside the overall investment strategy described in the Fund's PPM?
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-2" style="top:-8px;">
								<label class="radio-inline">
								<input type="radio" name="sequoiaPromises" value="0" <c:if test="${legalTeam.sequoiaPromises==0 }">checked="true"</c:if>> Y </label>
								<label class="radio-inline">
								<input type="radio" name="sequoiaPromises" value="1" <c:if test="${legalTeam.sequoiaPromises==1 }">checked="true"</c:if>> N </label>
							</div>
							<div class="col-md-10" align="left">
								2. Is the specific Sequoia fund making the investment also making promises about the behavior of other Sequoia funds?
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-2" style="top:-8px;">
								<label class="radio-inline">
								<input type="radio" name="issuerDomiciled" value="0" <c:if test="${legalTeam.issuerDomiciled==0 }">checked="true"</c:if>> Y </label>
								<label class="radio-inline">
								<input type="radio" name="issuerDomiciled" value="1" <c:if test="${legalTeam.issuerDomiciled==1 }">checked="true"</c:if>> N </label>
							</div>
							<div class="col-md-10" align="left">
								3. Is issuer domiciled outside our routine target countries (US, Cayman, BVI, Mauritius, India, PRC, HK, Israel)?
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-2" style="top:-8px;">
								<label class="radio-inline">
								<input type="radio" name="controllingInterest " value="0" <c:if test="${legalTeam.controllingInterest==0 }">checked="true"</c:if>> Y </label>
								<label class="radio-inline">
								<input type="radio" name="controllingInterest" value="1" <c:if test="${legalTeam.controllingInterest==1 }">checked="true"</c:if>> N </label>
							</div>
							<div class="col-md-10" align="left">
								4. Will the fund hold a controlling interest (>51% of vote) in the issuer that will trigger restrictions under local law?
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-2" style="top:-8px;">
								<label class="radio-inline">
								<input type="radio" name="relyingSolely" value="0" <c:if test="${legalTeam.relyingSolely==0 }">checked="true"</c:if>> Y </label>
								<label class="radio-inline">
								<input type="radio" name="relyingSolely" value="1" <c:if test="${legalTeam.relyingSolely==1 }">checked="true"</c:if>> N </label>
							</div>
							<div class="col-md-10" align="left">
								5. Is the fund relying solely on company counsel in this deal? If so, why? 
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-2" style="top:-8px;">
								<label class="radio-inline">
								<input type="radio" name="issuerIllegal" value="0" <c:if test="${legalTeam.issuerIllegal==0 }">checked="true"</c:if>> Y </label>
								<label class="radio-inline">
								<input type="radio" name="issuerIllegal" value="1" <c:if test="${legalTeam.issuerIllegal==1 }">checked="true"</c:if>> N </label>
							</div>
							<div class="col-md-10" align="left">
								6. CHINA SPECIFIC – Is the acceptance of this investment by the issuer illegal?
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-2" style="top:-8px;">
								<label class="radio-inline">
								<input type="radio" name="sequoiaPerson" value="0" <c:if test="${legalTeam.sequoiaPerson==0 }">checked="true"</c:if>> Y </label>
								<label class="radio-inline">
								<input type="radio" name="sequoiaPerson" value="1" <c:if test="${legalTeam.sequoiaPerson==1 }">checked="true"</c:if>> N </label>
							</div>
							<div class="col-md-10" align="left">
								7. Do the deal documents effectively require a Sequoia fund to indemnify a Sequoia individual in cases of material misconduct" by such individual?
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-2" style="top:-8px;">
								<label class="radio-inline">
								<input type="radio" name="contractualObligation" value="0" <c:if test="${legalTeam.contractualObligation==0 }">checked="true"</c:if>> Y </label>
								<label class="radio-inline">
								<input type="radio" name="contractualObligation" value="1" <c:if test="${legalTeam.contractualObligation==1 }">checked="true"</c:if>> N </label>
							</div>
							<div class="col-md-10" align="left">
								8. Does this investment have related stock stand‐stills or does it violate an existing binding contractual obligation? 
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-2" style="top:-8px;">
								<label class="radio-inline">
								<input type="radio" name="noncompeteClauses" value="0" <c:if test="${legalTeam.noncompeteClauses==0 }">checked="true"</c:if>> Y </label>
								<label class="radio-inline">
								<input type="radio" name="noncompeteClauses" value="1" <c:if test="${legalTeam.noncompeteClauses==1 }">checked="true"</c:if>> N </label>
							</div>
							<div class="col-md-10" align="left">
								9. Does this investment have any negative non-compete clauses?
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-2" style="top:-8px;">
								<label class="radio-inline">
								<input type="radio" name="circumventAnyLaws" value="0" <c:if test="${legalTeam.circumventAnyLaws==0 }">checked="true"</c:if>> Y </label>
								<label class="radio-inline">
								<input type="radio" name="circumventAnyLaws" value="1" <c:if test="${legalTeam.circumventAnyLaws==1 }">checked="true"</c:if>> N </label>
							</div>
							<div class="col-md-10" align="left">
								10. Does this investment circumvent any laws or do you have any reason to believe the issuer engages in any unethical behavior?
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</form>
package tests.campaign.leads;

import org.apache.log4j.Logger;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import pageObjects.modules.LeadPageObjects;
import utils.ExtentReports.ExtentTestManager;

public class CompanyTurnover extends LeadPageObjects {

	private Logger logger = Logger.getLogger(LeadPageObjects.class.getName());

	public LeadPageObjects companyTurnoverCheck() throws Exception {
		boolean isEndole = true;
		boolean isMatchFound = true;
		ExtentTestManager.getTest().log(LogStatus.INFO, "company size check in endole");
		selectGooglevalueAndUpdateEndoleCompanyToolsDropdown(" endole");
		String turnOverDropdownType = campaignTestDataProcess().getTurnOverDropdownType();
		String endoleCompanyTurnOver = endolePage().getTurnoverValue(turnOverDropdownType);
		String endoleUrl = getEndoleCurrentUrl();
		if (endoleCompanyTurnOver != null) {
			if (endoleCompanyTurnOver.equals("Unreported")) {
				isEndole = false;
				isMatchFound = false;
				googlePage().closeGooglePage();
				ExtentTestManager.getTest().log(LogStatus.INFO, "Company turnover does not available in endole");
			} else {
				ExtentTestManager.getTest().log(LogStatus.PASS, "Company turnover in endole is " + endoleCompanyTurnOver);
				googlePage().closeGooglePage();
				selectvalueTurnoverDropdown(endoleCompanyTurnOver);
				ExtentTestManager.getTest().log(LogStatus.PASS,
						"Company turnover in lead page is updated as per evidence from endole");
				setvalueTurnoverEvidence(endoleUrl);
				ExtentTestManager.getTest().log(LogStatus.INFO, "Company turnover evidence is updated in lead page");
			}
		} else {
			isEndole = false;
			isMatchFound = false;
			googlePage().closeGooglePage();
			ExtentTestManager.getTest().log(LogStatus.INFO, "Company turnover does not available in endole");
		}
		if(!isEndole) {
			ExtentTestManager.getTest().log(LogStatus.INFO, "company revenue check in zoom info");
			selectZoomInfovalueCompanyToolsDropdown();
			String zoomInfoRevenue = zoomInfoPage().getRevenueValue(turnOverDropdownType);
			String zoomInfoUrl = getZoomInfoCurrentUrl();
			if (zoomInfoRevenue != null) {
				isMatchFound = true;
				ExtentTestManager.getTest().log(LogStatus.PASS,
						"Company revenue in zoom info is matching open notes values");
				googlePage().closeGooglePage();
				selectvalueTurnoverDropdown(zoomInfoRevenue);
				ExtentTestManager.getTest().log(LogStatus.PASS,
						"Company revenue in lead page is updated as per evidence from zoom info");
				setvalueTurnoverEvidence(zoomInfoUrl);
				ExtentTestManager.getTest().log(LogStatus.INFO,
						"Company revenue evidence is updated in lead page");
			} else {
				isMatchFound = false;
				googlePage().closeGooglePage();
				ExtentTestManager.getTest().log(LogStatus.INFO,
						"Company size evidence is updated in lead page");
			}
		} 
		if (!isMatchFound) {
			selectvalueRejectionReasonDropdown("non-spec lead type (placement mismatch)");
			setvalueRejectionReasonEvidence("Company turnover does not available in endole");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "company turn over check does not match in endole");
		}
		return leadPage();
	}
}

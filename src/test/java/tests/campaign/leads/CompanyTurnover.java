package tests.campaign.leads;

import org.apache.log4j.Logger;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import pageObjects.modules.LeadPageObjects;
import utils.ExtentReports.ExtentTestManager;

public class CompanyTurnover extends LeadPageObjects {

	private Logger logger = Logger.getLogger(LeadPageObjects.class.getName());

	public LeadPageObjects companyTurnoverCheck() throws Exception {
		boolean isMatchFound = true;
		ExtentTestManager.getTest().log(LogStatus.INFO, "company size check in endole");
		selectGooglevalueAndUpdateEndoleCompanyToolsDropdown(" endole");
		String endoleCompanyTurnOver = endolePage().getTurnoverValue();
		String endoleUrl = getEndoleCurrentUrl();
		if (endoleCompanyTurnOver != null) {
			ExtentTestManager.getTest().log(LogStatus.PASS, "Company turnover in endole is " + endoleCompanyTurnOver);
			googlePage().closeGooglePage();
			selectvalueTurnoverDropdown(endoleCompanyTurnOver);
			ExtentTestManager.getTest().log(LogStatus.PASS,
					"Company turnover in lead page is updated as per evidence from endole");
			setvalueTurnoverEvidence(endoleUrl);
			ExtentTestManager.getTest().log(LogStatus.INFO, "Company turnover evidence is updated in lead page");
		} else {
			isMatchFound = false;
			googlePage().closeGooglePage();
			ExtentTestManager.getTest().log(LogStatus.INFO, "Company turnover does not available in endole");
			setvalueRejectionReason("company turn over check does not match in endole");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "company turn over check does not match in endole");
		}
		return leadPage();
	}
}

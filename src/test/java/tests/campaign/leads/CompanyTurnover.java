package tests.campaign.leads;

import org.apache.log4j.Logger;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import pageObjects.modules.LeadPageObjects;
import utils.ExtentReports.ExtentTestManager;

public class CompanyTurnover extends LeadPageObjects {

	private Logger logger = Logger.getLogger(LeadPageObjects.class.getName());

	public LeadPageObjects companyTurnoverCheck() throws Exception {
		boolean endolecheck = true;
		boolean zoominfocheck = false;

		if (endolecheck == true) {
			try {
				ExtentTestManager.getTest().log(LogStatus.INFO, "company turnover check in endole");
				selectGooglevalueAndUpdateEndoleCompanyToolsDropdown(" endole");
				String endoleCompanyTurnOver = endolePage().getTurnoverValue();
				String endoleUrl = getCurrentUrl();
				if (endoleCompanyTurnOver != null) {
					ExtentTestManager.getTest().log(LogStatus.PASS,
							"Company turnover in endole is " + endoleCompanyTurnOver);
					endolePage().closeEndolePage();
					setvalueTurnover(endoleCompanyTurnOver);
					ExtentTestManager.getTest().log(LogStatus.PASS,
							"Company turnover in lead page is updated as per evidence from endole");
					setvalueTurnoverEvidence(endoleUrl);
					ExtentTestManager.getTest().log(LogStatus.INFO,
							"Company turnover evidence is updated in lead page");
				} else {
					zoominfocheck = true;
					endolePage().closeEndolePage();
					ExtentTestManager.getTest().log(LogStatus.INFO, "Company turnover does not available in endole");
				}
			} catch (Exception e) {
				zoominfocheck = true;
				setvalueRejectionReason("company turnover check does not match in endole");
				ExtentTestManager.getTest().log(LogStatus.FAIL, "company turnover check does not match in endole");
			}
		} else if (zoominfocheck == true) {
			try {
				ExtentTestManager.getTest().log(LogStatus.INFO, "company turnover check in zoom info");
//				selectZoomInfovalueCompanyToolsDropdown();
//				String endoleCompanyTurnOver = zoomInfoPage().getTurnoverValue();
//				String endoleUrl = getCurrentUrl();
//				if (endoleCompanyTurnOver != null) {
//					ExtentTestManager.getTest().log(LogStatus.PASS,
//							"Company turnover in endole is " + endoleCompanyTurnOver);
//					endolePage().closeEndolePage();
//					setvalueTurnover(endoleCompanyTurnOver);
//					ExtentTestManager.getTest().log(LogStatus.PASS,
//							"Company turnover in lead page is updated as per evidence from endole");
//					setvalueTurnoverEvidence(endoleUrl);
//					ExtentTestManager.getTest().log(LogStatus.INFO,
//							"Company turnover evidence is updated in lead page");
//				} else {
//					zoominfocheck = true;
//					endolePage().closeEndolePage();
//					ExtentTestManager.getTest().log(LogStatus.INFO, "Company turnover does not available in endole");
//				}
			} catch (Exception e) {
//				zoominfocheck = true;
//				setvalueRejectionReason("company turn over check does not match in endole");
				ExtentTestManager.getTest().log(LogStatus.FAIL, "company turn over check does not match in endole");
			}
		}
		
		return leadPage();
	}
}

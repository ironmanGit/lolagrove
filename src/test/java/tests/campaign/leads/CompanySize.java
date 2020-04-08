package tests.campaign.leads;

import org.apache.log4j.Logger;
import org.testng.Assert;
import com.relevantcodes.extentreports.LogStatus;
import pageObjects.modules.LeadPageObjects;
import utils.ExtentReports.ExtentTestManager;

public class CompanySize extends LeadPageObjects {

	private Logger logger = Logger.getLogger(LeadPageObjects.class.getName());

	public LeadPageObjects companySizeCheck() throws Exception {
		String companySizeOpenNoteValue = campaignTestDataProcess().getLeadsCompanySize();
		String placement = getvaluePlacementReadOly();
		boolean isLinkedIn = true;
		boolean isMatchFound = true;
		if (companySizeOpenNoteValue.contains("TAL")) {
			logger.info("Company size value is:" + companySizeOpenNoteValue);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Company size in open notes is 'TAL' so no check needed");
		} else if (isLinkedIn) {
			logger.info("Company size value is:" + companySizeOpenNoteValue);
			if (placement.contains(companySizeOpenNoteValue)) {
				ExtentTestManager.getTest().log(LogStatus.PASS, "Company size check in placement is successfully done");
			} else {
				setvalueRejectionReason("company size in open notes does not match with placement");
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Company size check in placement is failed");
			}
			ExtentTestManager.getTest().log(LogStatus.INFO, "company size check in linkedin");
			selectLinkedInvalueCompanyToolsDropdown();
			String linkedInCompanySize = linkedInPage().getCompanySizeValue();
			String linkedInUrl = getCurrentUrl();
			if (linkedInCompanySize.contains(companySizeOpenNoteValue)) {
				ExtentTestManager.getTest().log(LogStatus.PASS,	"Company size in linkedin is matching open notes values");
				linkedInPage().closeLinkedInPage();
				setvalueCompanySize(linkedInCompanySize);
				ExtentTestManager.getTest().log(LogStatus.PASS,	"Company size in lead page is updated as per evidence from linkedin");
				setvalueCompanyEvidence(linkedInUrl);
				ExtentTestManager.getTest().log(LogStatus.INFO, "Company size evidence is updated in lead page");
			} else {
				isLinkedIn = false;
				isMatchFound = false;
				linkedInPage().closeLinkedInPage();
				ExtentTestManager.getTest().log(LogStatus.INFO, "Company size does not match with linked in");
			}
		} else if (!isLinkedIn) {
			ExtentTestManager.getTest().log(LogStatus.INFO, "company size check in zoom info");
			selectZoomInfovalueCompanyToolsDropdown();
			String zoomInfoCompanySize = zoomInfoPage().getEmployeesValue();
			String zoomInfoUrl = getCurrentUrl();
			if (zoomInfoCompanySize.contains(companySizeOpenNoteValue)) {
				ExtentTestManager.getTest().log(LogStatus.PASS,	"Company size in zoom info is matching open notes values");
				zoomInfoPage().closeZoomInfoPage();
				setvalueCompanySize(zoomInfoCompanySize);
				ExtentTestManager.getTest().log(LogStatus.PASS,	"Company size in lead page is updated as per evidence from zoom info");
				setvalueCompanyEvidence(zoomInfoUrl);
				ExtentTestManager.getTest().log(LogStatus.INFO, "Company size evidence is updated in lead page");
			} else {
				isMatchFound = false;
				zoomInfoPage().closeZoomInfoPage();
				ExtentTestManager.getTest().log(LogStatus.INFO, "Company size evidence is updated in lead page");
			}
		} else if (!isMatchFound) {
			setvalueRejectionReason("company size check does not match in linked in and zoom info");
			ExtentTestManager.getTest().log(LogStatus.FAIL,	"company size check does not match in linked in and zoom info");
		}
		return leadPage();
	}

}

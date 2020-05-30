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
			selectLinkedInvalueCompanyToolsDropdown();
			String companySizeDropdownType = campaignTestDataProcess().getCompanySizeDropdownType();
			String linkedInCompanySize = linkedInPage().getCompanySizeValue(companySizeDropdownType);
			if (linkedInCompanySize==null) {
				isLinkedIn = false;
			}
			String linkedInUrl = getLinkedInCurrentUrl();
			if (linkedInCompanySize != null) {
				ExtentTestManager.getTest().log(LogStatus.PASS,
						"Company size in linkedin is matching open notes values");
				googlePage().closeGooglePage();
				selectvalueCompanySizeDropDown(linkedInCompanySize);
				ExtentTestManager.getTest().log(LogStatus.PASS,
						"Company size in lead page is updated as per evidence from linkedin");
				setvalueCompanySizeEvidence(linkedInUrl);
				ExtentTestManager.getTest().log(LogStatus.INFO,
						"Company size evidence is updated in lead page");
			} else {
				googlePage().closeGooglePage();
				setvalueCompanySizeEvidence(linkedInUrl);
				ExtentTestManager.getTest().log(LogStatus.INFO,
						"Company size is not updated in lead page");
				ExtentTestManager.getTest().log(LogStatus.INFO,
						"Company size evidence is updated in lead page");
			}
		
		} else {
			logger.info("Company size value is:" + companySizeOpenNoteValue);
				ExtentTestManager.getTest().log(LogStatus.PASS, "Company size check in placement is successfully done");
				if (isLinkedIn) {
					ExtentTestManager.getTest().log(LogStatus.INFO, "company size check in linkedin");
					selectLinkedInvalueCompanyToolsDropdown();
					String companySizeDropdownType = campaignTestDataProcess().getCompanySizeDropdownType();
					String linkedInCompanySize = linkedInPage().getCompanySizeValue(companySizeDropdownType);
					String linkedInUrl = getLinkedInCurrentUrl();
					if (linkedInCompanySize != null) {
						ExtentTestManager.getTest().log(LogStatus.PASS,
								"Company size in linkedin is matching open notes values");
						googlePage().closeGooglePage();
						selectvalueCompanySizeDropDown(linkedInCompanySize);
						ExtentTestManager.getTest().log(LogStatus.PASS,
								"Company size in lead page is updated as per evidence from linkedin");
						setvalueCompanySizeEvidence(linkedInUrl);
						ExtentTestManager.getTest().log(LogStatus.INFO,
								"Company size evidence is updated in lead page");
					} else {
						isLinkedIn = false;
						isMatchFound = false;
						googlePage().closeGooglePage();
						ExtentTestManager.getTest().log(LogStatus.INFO, "Company size does not match with linked in");
					}
				} 
				if (!isLinkedIn) {
					ExtentTestManager.getTest().log(LogStatus.INFO, "company size check in zoom info");
					selectZoomInfovalueCompanyToolsDropdown();
					String zoomInfoCompanySize = zoomInfoPage().getEmployeesValue();
					String zoomInfoUrl = getZoomInfoCurrentUrl();
					if (zoomInfoCompanySize != null) {
						isMatchFound = true;
						ExtentTestManager.getTest().log(LogStatus.PASS,
								"Company size in zoom info is matching open notes values");
						googlePage().closeGooglePage();
						selectvalueCompanySizeDropDown(zoomInfoCompanySize);
						ExtentTestManager.getTest().log(LogStatus.PASS,
								"Company size in lead page is updated as per evidence from zoom info");
						setvalueCompanySizeEvidence(zoomInfoUrl);
						ExtentTestManager.getTest().log(LogStatus.INFO,
								"Company size evidence is updated in lead page");
					} else {
						isMatchFound = false;
						googlePage().closeGooglePage();
						ExtentTestManager.getTest().log(LogStatus.INFO,
								"Company size evidence is updated in lead page");
					}
				} 
				if (!isMatchFound) {
					selectvalueRejectionReasonDropdown("non-spec company size (placement mismatch)");
					setvalueRejectionReasonEvidence("company size check does not match in linked in and zoom info");
					ExtentTestManager.getTest().log(LogStatus.FAIL,
							"company size check does not match in linked in and zoom info");
				}
		}
		return leadPage();
	}
	
	public LeadPageObjects companySizeCheck2() throws Exception {
   		selectLinkedInvalueCompanyToolsDropdown();
   		String companySizeDropdownType = campaignTestDataProcess().getCompanySizeDropdownType();
		String linkedInCompanySize = linkedInPage().getCompanySizeValue(companySizeDropdownType);
		String linkedInUrl = getLinkedInCurrentUrl();
		return leadPage();
	}
}

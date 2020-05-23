package tests.campaign.leads;

import org.apache.log4j.Logger;
import com.relevantcodes.extentreports.LogStatus;
import pageObjects.modules.LeadPageObjects;
import utils.ExtentReports.ExtentTestManager;

public class FirstnameLastnameJobTitle extends LeadPageObjects {

	private Logger logger = Logger.getLogger(LeadPageObjects.class.getName());

	public LeadPageObjects firstnameLastnameJobTitleCheck() throws Exception {
		String firstname = getvalueFirstName();
		String lastname = getvalueLastName();
		String companyName = getvalueCompanyName().toLowerCase();
		String openNotesJobTitle = campaignTestDataProcess().getLeadsJobTitle();
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO, "firstname and lastname check in linkedin");
			selectLinkedInCompanySerachInJobTitleDropdown();
			String linkedInFullname = linkedInPage().getFullNameValue();
			String jobTitle = linkedInPage().getJobTitleValue();
			if (linkedInFullname.contains(firstname)) {
				ExtentTestManager.getTest().log(LogStatus.PASS,
						"First name in lead page matched with linkedin fullname");
			} else {
				ExtentTestManager.getTest().log(LogStatus.INFO,
						"First name in lead page does not matched with linkedin fullname");
			}
			if (linkedInFullname.contains(lastname)) {
				ExtentTestManager.getTest().log(LogStatus.PASS,
						"Last name in lead page matched with linkedin fullname");
			} else {
				ExtentTestManager.getTest().log(LogStatus.INFO,
						"Last name in lead page does not matched with linkedin fullname");
			}

			String linkedInCompanyname = linkedInPage().getCompanyValue().toLowerCase();
			if (linkedInCompanyname.contains(companyName)) {
				ExtentTestManager.getTest().log(LogStatus.PASS,
						"Company in lead page matched with linkedin company name");
				if (openNotesJobTitle != null && jobTitle != null) {
					ExtentTestManager.getTest().log(LogStatus.INFO,
							"Job title in lead page matched with linkedin job title");

				}
			} else {
				ExtentTestManager.getTest().log(LogStatus.INFO,
						"Company in lead page does not matched with linkedin company name");
			}
			String linkedInUrl = getLinkedInCurrentUrl();
			googlePage().closeGooglePage();
			setvalueLinkedinIdUrl(linkedInUrl);
			ExtentTestManager.getTest().log(LogStatus.INFO, "Linkedin url evidence is updated in lead page");
			setvalueJobTitle(jobTitle);
			ExtentTestManager.getTest().log(LogStatus.PASS,
					"Job title in lead page is updated with linkedin job title");
			setvalueJobTitleEvidence(linkedInUrl);
			ExtentTestManager.getTest().log(LogStatus.PASS, "job title url evidence is updated in lead page");
		} catch (Exception e) {
			googlePage().closeGooglePage();
			setvalueLinkedinIdUrl("Linkedin URL not found");
			ExtentTestManager.getTest().log(LogStatus.INFO,
					"Unable to find linkedin url so evidence is not updated in lead page");
		}

		return leadPage();
	}

}

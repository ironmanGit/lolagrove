package tests.campaign.leads;

import org.apache.log4j.Logger;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import pageObjects.modules.LeadPageObjects;
import utils.ExtentReports.ExtentTestManager;

public class JobTitle extends LeadPageObjects {

	private Logger logger = Logger.getLogger(LeadPageObjects.class.getName());

	public LeadPageObjects jobTitleCheck() throws Exception {
		String openNotesJobTitle = campaignTestDataProcess().getLeadsJobTitle();
		// boolean isMatchFound = true;
		ExtentTestManager.getTest().log(LogStatus.INFO, "Job title check in linkedin");
		selectLinkedInCompanySerachInJobTitleDropdown();
		String jobTitle = linkedInPage().getJobTitleValue();
		String linkedInUrl = getCurrentUrl();
		if (openNotesJobTitle.contains(jobTitle)) {
			linkedInPage().closeLinkedInPage();
			ExtentTestManager.getTest().log(LogStatus.INFO, "Job title in lead page matched with linkedin job title");
			setvalueJobTitle(jobTitle);
			ExtentTestManager.getTest().log(LogStatus.PASS,
					"Job title in lead page is updated with linkedin job title");
			setvalueJobTitleEvidence(linkedInUrl);
			ExtentTestManager.getTest().log(LogStatus.PASS, "job title url evidence is updated in lead page");
		} else {
			linkedInPage().closeLinkedInPage();
			setvalueJobTitleEvidence("Job title evidence not found");
			ExtentTestManager.getTest().log(LogStatus.INFO, "Job title evidence not found");
			setvalueRejectionReason("Job title does not match with open notes");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Job title does not match with open notes");
		}
		return leadPage();
	}
}

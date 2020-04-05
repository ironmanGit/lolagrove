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
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO, "job title check in linkedin");
			selectLinkedInCompanySerachInJobTitleDropdown();
			String jobTitle = linkedInPage().getJobTitleValue();
			if(openNotesJobTitle.contains(jobTitle)) {
				ExtentTestManager.getTest().log(LogStatus.PASS, "Job title in lead page matched with linkedin job title");
			} else {
				setvalueJobTitle(jobTitle);
				ExtentTestManager.getTest().log(LogStatus.PASS, "Job title in lead page is updated with linkedin job title");
			}
			String linkedInUrl = getCurrentUrl();
			linkedInPage().closeLinkedInPage();
			setvalueJobTitleEvidence(linkedInUrl);
			ExtentTestManager.getTest().log(LogStatus.INFO,"job title url evidence is updated in lead page");
		} catch (Exception e) {
			linkedInPage().closeLinkedInPage();
			setvalueJobTitleEvidence("Job title evidence not found");
			ExtentTestManager.getTest().log(LogStatus.INFO,"Job title evidence not found");
		}
		return leadPage();
	}

}


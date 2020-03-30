package tests.campaign.leads;

import org.apache.log4j.Logger;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import pageObjects.modules.LeadPageObjects;
import utils.ExtentReports.ExtentTestManager;

public class FirstnameLastname extends LeadPageObjects {

	private Logger logger = Logger.getLogger(LeadPageObjects.class.getName());

	public LeadPageObjects firstnameLastnameCheck() throws Exception {
		String firstname = getvalueFirstName();
		String lastname = getvalueLastName();
		String companyName = getvalueCompanyName().toLowerCase();
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO, "firstname and lastname check in linkedin");
			selectLinkedInCompanySerachInJobTitleDropdown();
			String linkedInFullname = linkedInPage().getFullNameValue();
			Assert.assertTrue(linkedInFullname.contains(firstname));
			ExtentTestManager.getTest().log(LogStatus.PASS, "First name in lead page matched with linkedin fullname");
			Assert.assertTrue(linkedInFullname.contains(lastname));
			ExtentTestManager.getTest().log(LogStatus.PASS, "Last name in lead page matched with linkedin fullname");
			String linkedInCompanyname = linkedInPage().getCompanyValue().toLowerCase();
			Assert.assertTrue(linkedInCompanyname.contains(companyName));
			ExtentTestManager.getTest().log(LogStatus.PASS, "Company in lead page matched with linkedin company name");
			String linkedInUrl = getCurrentUrl();
			linkedInPage().closeLinkedInPage();
			setvalueLinkedinIdUrl(linkedInUrl);
			ExtentTestManager.getTest().log(LogStatus.INFO,"Linkedin url evidence is updated in lead page");
		} catch (Exception e) {
			setvalueLinkedinIdUrl("Linkedin URL not found");
			ExtentTestManager.getTest().log(LogStatus.INFO,"Unable to find linkedin url so evidence is not updated in lead page");
		}

		return leadPage();
	}

}

package tests.campaign.leads;

import org.apache.log4j.Logger;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import pageObjects.modules.LeadPageObjects;
import utils.ExtentReports.ExtentTestManager;

public class Email extends LeadPageObjects {

	private Logger logger = Logger.getLogger(LeadPageObjects.class.getName());

	public LeadPageObjects emailCheck() throws Exception {
		String emailOpenNoteValue = campaignTestDataProcess().getEmail();
		String firstName = getvalueFirstName();
		String lastName = getvalueLastName();
		String companyName = getvalueCompanyName();
		String emailFromLeads = getvalueEmail();
		String emailEvidenceFromLeads = getvalueEmailEvidence();
		if (emailOpenNoteValue.contains("Person@Company")) {
			logger.info("Email value in lead page is:" + emailFromLeads);
			if(isValidEmail(emailFromLeads)) {
				ExtentTestManager.getTest().log(LogStatus.PASS, "Email in lead page is in valid format");
				if(emailEvidenceFromLeads.equals("Email Verified")) {
					ExtentTestManager.getTest().log(LogStatus.PASS, "Email evidence - Email Verified");
				} else {
					if(emailFromLeads.contains(firstName)) {
						ExtentTestManager.getTest().log(LogStatus.INFO, "First name matched with email");	
					} else {
						ExtentTestManager.getTest().log(LogStatus.INFO, "First name not matched with email");
					}
					if(emailFromLeads.contains(lastName)) {
						ExtentTestManager.getTest().log(LogStatus.INFO, "Last name matched with email");	
					} else {
						ExtentTestManager.getTest().log(LogStatus.INFO, "Last name not matched with email");
					}
					if(emailFromLeads.contains(companyName)) {
						ExtentTestManager.getTest().log(LogStatus.INFO, "Comapny name matched with email");	
					} else {
						ExtentTestManager.getTest().log(LogStatus.INFO, "Comapny name not matched with email");
					}
				}
			} else {
				setvalueRejectionReason("email format is invalid");
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Email in lead page is in invalid format");
			}
			
		}else if(emailOpenNoteValue.contains("info@Company")) {
			logger.info("Email value in lead page is:" + emailFromLeads);
			if(isValidEmail(emailFromLeads)) {
				ExtentTestManager.getTest().log(LogStatus.PASS, "Email in lead page is in valid format");
				if(emailEvidenceFromLeads.equals("Email Verified")) {
					ExtentTestManager.getTest().log(LogStatus.PASS, "Email evidence - Email Verified");
				} else {
					if(emailFromLeads.contains(firstName)) {
						ExtentTestManager.getTest().log(LogStatus.INFO, "First name matched with email");	
					} else {
						ExtentTestManager.getTest().log(LogStatus.INFO, "First name not matched with email");
					}
					if(emailFromLeads.contains(firstName)) {
						ExtentTestManager.getTest().log(LogStatus.INFO, "Last name matched with email");	
					} else {
						ExtentTestManager.getTest().log(LogStatus.INFO, "Last name not matched with email");
					}
					if(emailFromLeads.contains(companyName)) {
						ExtentTestManager.getTest().log(LogStatus.INFO, "Comapny name matched with email");	
					} else {
						ExtentTestManager.getTest().log(LogStatus.INFO, "Comapny name not matched with email");
					}
				}
			} else {
				setvalueRejectionReason("email format is invalid");
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Email in lead page is in invalid format");
			}
		} else if(emailOpenNoteValue.contains("All")) {
			logger.info("Email value in lead page is:" + emailFromLeads);
			if(isValidEmail(emailFromLeads)) {
				ExtentTestManager.getTest().log(LogStatus.PASS, "Email in lead page is in valid format");
				if(emailEvidenceFromLeads.equals("Email Verified")) {
					ExtentTestManager.getTest().log(LogStatus.PASS, "Email evidence - Email Verified");
				} else {
					if(emailFromLeads.contains(firstName)) {
						ExtentTestManager.getTest().log(LogStatus.INFO, "First name matched with email");	
					} else {
						ExtentTestManager.getTest().log(LogStatus.INFO, "First name not matched with email");
					}
					if(emailFromLeads.contains(firstName)) {
						ExtentTestManager.getTest().log(LogStatus.INFO, "Last name matched with email");	
					} else {
						ExtentTestManager.getTest().log(LogStatus.INFO, "Last name not matched with email");
					}
					if(emailFromLeads.contains(companyName)) {
						ExtentTestManager.getTest().log(LogStatus.INFO, "Comapny name matched with email");	
					} else {
						ExtentTestManager.getTest().log(LogStatus.INFO, "Comapny name not matched with email");
					}
				}
			} else {
				setvalueRejectionReason("email format is invalid");
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Email in lead page is in invalid format");
			}
		} else {
			setvalueRejectionReason("email format invalid from open notes");
			ExtentTestManager.getTest().log(LogStatus.FAIL,
					"email format invalid from open notes need to check manually ");
		}
		
		return leadPage();
	}

}

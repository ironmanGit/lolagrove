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
		if (emailOpenNoteValue.contains("Person@Company")) {
			String emailFromLeads = getvalueEmail();
			String emailEvidenceFromLeads = getvalueEmailEvidence();
			logger.info("Email value in lead page is:" + emailFromLeads);
			if(isValidEmail(emailFromLeads)) {
				ExtentTestManager.getTest().log(LogStatus.PASS, "Email in lead page is in valid format");
				if(emailEvidenceFromLeads.equals("Email Verified")) {
					ExtentTestManager.getTest().log(LogStatus.PASS, "Email evidence - Email Verified");
				}
			} else {
				setvalueRejectionReason("email format is invalid");
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Email in lead page is in invalid format");
			}
			
		}else if(emailOpenNoteValue.contains("info@Company")) {
			String emailFromLeads = getvalueEmail();
			String emailEvidenceFromLeads = getvalueEmailEvidence();
			logger.info("Email value in lead page is:" + emailFromLeads);
			if(isValidEmail(emailFromLeads)) {
				ExtentTestManager.getTest().log(LogStatus.PASS, "Email in lead page is in valid format");
				if(emailEvidenceFromLeads.equals("Email Verified")) {
					ExtentTestManager.getTest().log(LogStatus.PASS, "Email evidence - Email Verified");
				}
			} else {
				setvalueRejectionReason("email format is invalid");
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Email in lead page is in invalid format");
			}
		} else if(emailOpenNoteValue.contains("All")) {
			String emailFromLeads = getvalueEmail();
			String emailEvidenceFromLeads = getvalueEmailEvidence();
			logger.info("Email value in lead page is:" + emailFromLeads);
			if(isValidEmail(emailFromLeads)) {
				ExtentTestManager.getTest().log(LogStatus.PASS, "Email in lead page is in valid format");
				if(emailEvidenceFromLeads.equals("Email Verified")) {
					ExtentTestManager.getTest().log(LogStatus.PASS, "Email evidence - Email Verified");
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

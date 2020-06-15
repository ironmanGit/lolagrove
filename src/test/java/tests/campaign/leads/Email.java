package tests.campaign.leads;

import java.util.List;

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
		String emailFromLead = getvalueEmail();
		String emailEvidenceFromLead = getvalueEmailEvidence();
		String emailDomain = emailEvidenceFromLead.replace(".*(?=@)", "");
		if (emailOpenNoteValue.contains("Person@Company")) {
			logger.info("Email value in lead page is:" + emailFromLead);
			if (isValidEmail(emailFromLead)) {
				ExtentTestManager.getTest().log(LogStatus.PASS, "Email in lead page is in valid format");
				if (emailEvidenceFromLead.equals("Email Verified")) {
					ExtentTestManager.getTest().log(LogStatus.PASS, "Email evidence - Email Verified");
				} else {
					if (emailFromLead.contains(firstName)) {
						ExtentTestManager.getTest().log(LogStatus.INFO, "First name matched with email");
					} else {
						ExtentTestManager.getTest().log(LogStatus.INFO, "First name not matched with email");
					}
					if (emailFromLead.contains(lastName)) {
						ExtentTestManager.getTest().log(LogStatus.INFO, "Last name matched with email");
					} else {
						ExtentTestManager.getTest().log(LogStatus.INFO, "Last name not matched with email");
					}
					if (emailFromLead.contains(companyName)) {
						ExtentTestManager.getTest().log(LogStatus.INFO, "Comapny name matched with email");
					} else {
						ExtentTestManager.getTest().log(LogStatus.INFO, "Comapny name not matched with email");
					}
					selectvalueEmailToolsDropdown("Email search");
					List<String> verifiedEmailHrefs = googlePage().getMatchedEmailHref(emailFromLead);

					if (verifiedEmailHrefs.size() == 0) {
						clearSearchValueInGoogleAndSearch(emailDomain);
						verifiedEmailHrefs = googlePage().getMatchedEmailHref(emailFromLead);
						if (verifiedEmailHrefs.size() == 0) {
							clickEmailNoEvidenceFoundBtn();
							ExtentTestManager.getTest().log(LogStatus.INFO, "No email evidence found");
						} else {
							logger.info("Email Evidence: " + verifiedEmailHrefs.get(0));
							setvalueEmailEvidence(verifiedEmailHrefs.get(0));
							ExtentTestManager.getTest().log(LogStatus.PASS,
									"Email evidence has been set to " + verifiedEmailHrefs.get(0));
						}

					} else {
						logger.info("Email Evidence: " + verifiedEmailHrefs.get(0));
						setvalueEmailEvidence(verifiedEmailHrefs.get(0));
						ExtentTestManager.getTest().log(LogStatus.PASS,
								"Email evidence has been set to " + verifiedEmailHrefs.get(0));
					}

				}
			} 
		} else if (emailOpenNoteValue.contains("info@Company")) {
			logger.info("Email value in lead page is:" + emailFromLead);
			if (isValidEmail(emailFromLead)) {
				ExtentTestManager.getTest().log(LogStatus.PASS, "Email in lead page is in valid format");
				if (emailEvidenceFromLead.equals("Email Verified")) {
					ExtentTestManager.getTest().log(LogStatus.PASS, "Email evidence - Email Verified");
				} else {
					if (emailFromLead.contains(firstName)) {
						ExtentTestManager.getTest().log(LogStatus.INFO, "First name matched with email");
					} else {
						ExtentTestManager.getTest().log(LogStatus.INFO, "First name not matched with email");
					}
					if (emailFromLead.contains(firstName)) {
						ExtentTestManager.getTest().log(LogStatus.INFO, "Last name matched with email");
					} else {
						ExtentTestManager.getTest().log(LogStatus.INFO, "Last name not matched with email");
					}
					if (emailFromLead.contains(companyName)) {
						ExtentTestManager.getTest().log(LogStatus.INFO, "Comapny name matched with email");
					} else {
						ExtentTestManager.getTest().log(LogStatus.INFO, "Comapny name not matched with email");
					}
					selectvalueEmailToolsDropdown("Email search");
					List<String> verifiedEmailHrefs = googlePage().getMatchedEmailHref(emailFromLead);

					if (verifiedEmailHrefs.size() == 0) {
						clearSearchValueInGoogleAndSearch(emailDomain);
						verifiedEmailHrefs = googlePage().getMatchedEmailHref(emailFromLead);
						if (verifiedEmailHrefs.size() == 0) {
							clickEmailNoEvidenceFoundBtn();
							ExtentTestManager.getTest().log(LogStatus.INFO, "No email evidence found");
						} else {
							logger.info("Email Evidence: " + verifiedEmailHrefs.get(0));
							setvalueEmailEvidence(verifiedEmailHrefs.get(0));
							ExtentTestManager.getTest().log(LogStatus.PASS,
									"Email evidence has been set to " + verifiedEmailHrefs.get(0));
						}

					} else {
						logger.info("Email Evidence: " + verifiedEmailHrefs.get(0));
						setvalueEmailEvidence(verifiedEmailHrefs.get(0));
						ExtentTestManager.getTest().log(LogStatus.PASS,
								"Email evidence has been set to " + verifiedEmailHrefs.get(0));
					}
				}
			} 
		} else if (emailOpenNoteValue.contains("All")) {
			logger.info("Email value in lead page is:" + emailFromLead);
			if (isValidEmail(emailFromLead)) {
				ExtentTestManager.getTest().log(LogStatus.PASS, "Email in lead page is in valid format");
				if (emailEvidenceFromLead.equals("Email Verified")) {
					ExtentTestManager.getTest().log(LogStatus.PASS, "Email evidence - Email Verified");
				} else {
					if (emailFromLead.contains(firstName)) {
						ExtentTestManager.getTest().log(LogStatus.INFO, "First name matched with email");
					} else {
						ExtentTestManager.getTest().log(LogStatus.INFO, "First name not matched with email");
					}
					if (emailFromLead.contains(firstName)) {
						ExtentTestManager.getTest().log(LogStatus.INFO, "Last name matched with email");
					} else {
						ExtentTestManager.getTest().log(LogStatus.INFO, "Last name not matched with email");
					}
					if (emailFromLead.contains(companyName)) {
						ExtentTestManager.getTest().log(LogStatus.INFO, "Comapny name matched with email");
					} else {
						ExtentTestManager.getTest().log(LogStatus.INFO, "Comapny name not matched with email");
					}
					selectvalueEmailToolsDropdown("Email search");
					List<String> verifiedEmailHrefs = googlePage().getMatchedEmailHref(emailFromLead);

					if (verifiedEmailHrefs.size() == 0) {
						clearSearchValueInGoogleAndSearch(emailDomain);
						verifiedEmailHrefs = googlePage().getMatchedEmailHref(emailFromLead);
						if (verifiedEmailHrefs.size() == 0) {
							clickEmailNoEvidenceFoundBtn();
							ExtentTestManager.getTest().log(LogStatus.INFO, "No email evidence found");
						} else {
							logger.info("Email Evidence: " + verifiedEmailHrefs.get(0));
							setvalueEmailEvidence(verifiedEmailHrefs.get(0));
							ExtentTestManager.getTest().log(LogStatus.PASS,
									"Email evidence has been set to " + verifiedEmailHrefs.get(0));
						}

					} else {
						logger.info("Email Evidence: " + verifiedEmailHrefs.get(0));
						setvalueEmailEvidence(verifiedEmailHrefs.get(0));
						ExtentTestManager.getTest().log(LogStatus.PASS,
								"Email evidence has been set to " + verifiedEmailHrefs.get(0));
					}
				}
			} 
		} else {
			setvalueRejectionReason("email format invalid from open notes");
			setvalueRejectionReasonEvidence("Remove - Invalid Email");
			ExtentTestManager.getTest().log(LogStatus.FAIL,
					"email format invalid from open notes need to check manually ");
		}

		return leadPage();
	}

}

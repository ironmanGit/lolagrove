package tests.campaign.leads;

import org.apache.log4j.Logger;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import pageObjects.modules.LeadPageObjects;
import utils.ExtentReports.ExtentTestManager;

public class Country extends LeadPageObjects {

	private Logger logger = Logger.getLogger(LeadPageObjects.class.getName());

	public LeadPageObjects countryCheck() throws Exception {
		String countryOpenNoteValue = campaignTestDataProcess().getLeadsCountry();
		if (countryOpenNoteValue.contains("Nordics")) {
			countryOpenNoteValue = countryOpenNoteValue.concat(",Denmark, Finland, Iceland, Norway, Sweden");
		}
		
		if (countryOpenNoteValue.contains("Benelux")) {
			countryOpenNoteValue = countryOpenNoteValue.concat(",Belgium, Netherlands, Luxembourg");
		}
		if (countryOpenNoteValue.contains("UK")) {
			countryOpenNoteValue = countryOpenNoteValue.concat(",United Kingdom");
		}
		if (countryOpenNoteValue.contains("US")||countryOpenNoteValue.contains("United States")) {
			countryOpenNoteValue = countryOpenNoteValue.concat(",USA, United States, United States of America");
		}
		String leadCountryLeadOnly = getvalueCountryReadOly();
		logger.info("Country read only value from lead:" + leadCountryLeadOnly);
		
		try {
			if (countryOpenNoteValue.contains(leadCountryLeadOnly)) {
				ExtentTestManager.getTest().log(LogStatus.PASS,
						"Country in open notes matches country read only field");
				if(leadCountryLeadOnly.equals("USA")||leadCountryLeadOnly.equals("US")||leadCountryLeadOnly.equals("America")) {
					selectvalueCountryDropdown("United States");
				} else if(leadCountryLeadOnly.equals("UK")) {
					selectvalueCountryDropdown("United Kingdom");
				} else {
					selectvalueCountryDropdown(leadCountryLeadOnly);
				}
				selectvalueCountryDropdown(leadCountryLeadOnly);
				ExtentTestManager.getTest().log(LogStatus.PASS,
						"Country value in lead page is updated as per open notes");
			} else {
				selectvalueRejectionReasonDropdown("non-spec country (placement mismatch)");
				setvalueRejectionReasonEvidence("country value in open notes does not match with country in lead");
				ExtentTestManager.getTest().log(LogStatus.FAIL,
						"Country value in open notes does not match with country in lead");
			}

		} catch (Exception e) {
			selectvalueRejectionReasonDropdown("non-spec country (placement mismatch)");
			setvalueRejectionReasonEvidence("country value in open notes does not match with country in lead");
			ExtentTestManager.getTest().log(LogStatus.FAIL,
					"Country value in open notes does not match with country in lead" + e);
		}

		return leadPage();
	}

}

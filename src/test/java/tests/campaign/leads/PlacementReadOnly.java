package tests.campaign.leads;

import java.util.List;

import org.apache.log4j.Logger;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import pageObjects.modules.LeadPageObjects;
import tests.campaign.process.CampaignTestDataProcess;
import utils.ExtentReports.ExtentTestManager;

public class PlacementReadOnly extends LeadPageObjects {

	private Logger logger = Logger.getLogger(LeadPageObjects.class.getName());

	public LeadPageObjects placementCheck() throws Exception {
		try {
			String placement = getvaluePlacementReadOly();
			String leadType = getvalueLeadTypeReadOly();
			String leadCountryLeadOnly = getvalueCountryReadOly();
			logger.info("Placement value is:" + placement);
			logger.info("Lead type value is:" + leadType);
			logger.info("Lead type value is:" + leadCountryLeadOnly);
			if(leadType.equals("undefined")) {
				ExtentTestManager.getTest().log(LogStatus.INFO, "Lead type value is undefined");
			} else {
				if (placement.contains(leadType)) {
					ExtentTestManager.getTest().log(LogStatus.PASS, "Placement check for leas type is successfully done");
				} else {
					selectvalueRejectionReasonDropdown("non-spec lead type (placement mismatch)");
					setvalueRejectionReasonEvidence("placement check does not match as per open notes");
					ExtentTestManager.getTest().log(LogStatus.FAIL, "Placement check failed");
				}
			}
			List<String> countryCode = CampaignTestDataProcess.getCountryMapping(leadCountryLeadOnly);
			
			if (placement.contains(countryCode.get(0))|| placement.contains(countryCode.get(1))) {
				ExtentTestManager.getTest().log(LogStatus.PASS, "Placement check for country code is successfully done");
			} else {
				selectvalueRejectionReasonDropdown("non-spec lead type (placement mismatch)");
				setvalueRejectionReasonEvidence("placement check does not match as per open notes");
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Placement check failed");
			}
		} catch (Exception e) {
			selectvalueRejectionReasonDropdown("non-spec lead type (placement mismatch)");
			setvalueRejectionReasonEvidence("placement check does not match as per open notes");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Placement check failed" + e);
		}
		return leadPage();
	}
}

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
			String openNotesCountry = campaignTestDataProcess().getLeadsCountry();
			logger.info("Placement value is:" + placement);
			logger.info("Lead type value is:" + leadType);
			logger.info("Lead type value is:" + leadCountryLeadOnly);
			if (placement.equals("undefined")) {
				ExtentTestManager.getTest().log(LogStatus.INFO, "Placement value is undefined");
				ExtentTestManager.getTest().log(LogStatus.PASS,
						"Placement check is skipped since the value is undefined");
			} else {
				if (leadType.equals("undefined")) {
					ExtentTestManager.getTest().log(LogStatus.INFO, "Lead type value is undefined");
				} else {
					if (placement.contains(leadType)) {
						ExtentTestManager.getTest().log(LogStatus.PASS,
								"Placement check for leas type is successfully done");
					} else {
						selectvalueRejectionReasonDropdown("Non-spec Lead Type (Placement mismatch)");
						setvalueRejectionReasonEvidence("placement check does not match as per open notes");
						ExtentTestManager.getTest().log(LogStatus.FAIL, "Placement check failed");
					}
				}
				List<String> countryCode = CampaignTestDataProcess.getCountryMapping(leadCountryLeadOnly);

				if (placement.contains(countryCode.get(0)) || placement.contains(countryCode.get(1))
						|| openNotesCountry.equals("ALL")) {
					ExtentTestManager.getTest().log(LogStatus.PASS,
							"Placement check for country code is successfully done");
				} else if (placement.contains("EMEA")) {
					ExtentTestManager.getTest().log(LogStatus.PASS,
							"Placement check for country code is successfully done");
				} else {
					selectvalueRejectionReasonDropdown("Non-spec Country (Placement mismatch)");
					setvalueRejectionReasonEvidence("placement check country code is not available");
					ExtentTestManager.getTest().log(LogStatus.FAIL, "Placement check failed");
				}
			}
		} catch (Exception e) {
			selectvalueRejectionReasonDropdown("Non-spec Country (Placement mismatch)");
			setvalueRejectionReasonEvidence("placement check country code is not available");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Placement check failed" + e);
		}
		return leadPage();
	}
}

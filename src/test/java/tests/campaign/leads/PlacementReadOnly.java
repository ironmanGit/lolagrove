package tests.campaign.leads;

import org.apache.log4j.Logger;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import pageObjects.modules.LeadPageObjects;
import utils.ExtentReports.ExtentTestManager;

public class PlacementReadOnly extends LeadPageObjects {

	private Logger logger = Logger.getLogger(LeadPageObjects.class.getName());

	public LeadPageObjects placementCheck() {
		String placement = getvaluePlacementReadOly();
		String leadType = getvalueLeadTypeReadOly();
		String leadType1 = getvalueLeadTypeReadOly();
		try {
			logger.info("Placement value is:" + placement);
			logger.info("Lead type value is:" + leadType);
			Assert.assertTrue(placement.contains(leadType));
			ExtentTestManager.getTest().log(LogStatus.PASS, "Placement check is successfully done");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Placement check failed" + e);
		}
		return leadPage();
	}
}

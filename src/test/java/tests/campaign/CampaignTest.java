package tests.campaign;

import org.testng.annotations.Test;

import org.apache.log4j.Logger;

import pageObjects.initializePageObjects.PageFactoryInitializer;

public class CampaignTest extends PageFactoryInitializer {
	private Logger logger = Logger.getLogger(CampaignTest.class.getName());

	@Test(priority = 1, description = "Scenario 1")
	public void campaignCheck() throws Exception {
		loginPage()
		.login()
		.verifyCampaignTab()
		.selectCampaign()
		.getCampaignDetailsFromAllPages();
	}
	
}

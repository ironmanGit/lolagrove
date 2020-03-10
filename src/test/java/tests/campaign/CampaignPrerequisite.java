package tests.campaign;

import org.testng.annotations.Test;
import org.apache.log4j.Logger;
import pageObjects.initializePageObjects.PageFactoryInitializer;

public class CampaignPrerequisite extends PageFactoryInitializer {
	private Logger logger = Logger.getLogger(CampaignPrerequisite.class.getName());

	@Test
	public void testCampaignPrerequisite() throws Exception {
		String paramValue = "test";
		logger.info(paramValue+"Passed");
	}
}

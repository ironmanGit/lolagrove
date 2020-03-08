package com.campaign;

import org.testng.annotations.Test;
import org.apache.log4j.Logger;
import com.demoTest.common.DateUtils;
import com.hooks.UISuiteHooks;

public class CampaignPrerequisite extends UISuiteHooks {
	private Logger logger = Logger.getLogger(CampaignPrerequisite.class.getName());
	private final String timeStamp = DateUtils.getCurrentTimestamp();

	@Test
	public void testCampaignPrerequisite() throws Exception {
		String paramValue = "test";
		logger.info(paramValue+"Passed");
	}
	
	
	
}

package com.campaign;

import org.testng.annotations.Test;

import java.lang.reflect.Method;
import utils.ExtentReports.ExtentTestManager;
import org.apache.log4j.Logger;
import com.demoTest.common.DateUtils;
import com.hooks.UISuiteHooks;

import junit.framework.Assert;

public class CampaignTest extends UISuiteHooks {
	private Logger logger = Logger.getLogger(CampaignTest.class.getName());
	private final String timeStamp = DateUtils.getCurrentTimestamp();

	@Test(priority = 1, description = "Scenario 1")
	public void campaign1(Method method) throws Exception {
		ExtentTestManager.startTest(method.getName(), "Test Case1");
		Assert.assertEquals(1, 1);
		ExtentTestManager.endTest();
	}

	@Test(priority = 2, description = "Scenario 2")
	public void campaign2(Method method) throws Exception {
		ExtentTestManager.startTest(method.getName(), "Test Case2");
		Assert.assertEquals(1, 0);
		ExtentTestManager.endTest();
	}
	
	@Test(priority = 3, description = "Scenario 3")
	public void campaign3(Method method) throws Exception {
		ExtentTestManager.startTest(method.getName(), "Test Case3");
		Assert.assertEquals(1, 1);
		ExtentTestManager.endTest();
	}
	
}

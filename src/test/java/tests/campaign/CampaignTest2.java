package tests.campaign;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.log4j.Logger;
import pageObjects.initializePageObjects.PageFactoryInitializer;
import tests.campaign.process.CampaignTestDataProcess;
import utils.ExtentReports.ExtentTestManager;

public class CampaignTest2 extends PageFactoryInitializer {
	private Logger logger = Logger.getLogger(CampaignTest2.class.getName());
	private String getCompanySize;
	private String getIndustrialVertical;
	private String getJobFunction;
	private String getJobTitle;
	private String getCountry;

	@Test(priority = 1, description = "Navigate to Campaign")
	public void campaignCheck() throws Exception {
		ExtentTestManager.startTest("Navigate to Campaign", "Navigate to Campaign");
		loginPage()
		.login()
		.verifyCampaignTab()
		.selectCampaign()
		.navigateToLeadsPage();
		//.clickOpenNotesLink()
		//.getAllFieldsFromOpenNotes()
		//.closeOpenNotesTab()
		//.setTestDataCheck();
		//leadPage()
		//.createCampaignLeadsFile();
	}

	@Test(priority = 2, description = "Launch endole and linkedin browsers")
	public void lauchSearchBrowsers() throws Exception {
		ExtentTestManager.startTest("Launch endole and linkedin browsers", "Launch endole and linkedin browsers");
		//endoleDriver();
		linkedInDriver();
	}
	
	

	@Test(priority = 3, description = "Lead Testing")
	public void leadsCheck() throws Exception {
		//String leadId = leadsLine.substring(leadsLine.length() - 9);
		//ExtentTestManager.startTest("Lead Id--> " + leadId, "Lead Testing");
		leadPage()
		.clickLeadsFromFile("483213375")
		.companySizeCheck();
//		.companyTurnoverCheck()
//		.firstnameLastnameJobTitleCheck()
//		.updateManuallyVerify()
//		.clickSaveBtn();
		//.clickCloseBtn();
		ExtentTestManager.endTest();
	}
}

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

public class CampaignTest extends PageFactoryInitializer {
	private Logger logger = Logger.getLogger(CampaignTest.class.getName());
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
		.navigateToLeadsPage()
		.clickOpenNotesLink()
		.getAllFieldsFromOpenNotes()
		.closeOpenNotesTab()
		.setTestDataCheck();
		//leadPage()
		//.createCampaignLeadsFile();
	}

	@Test(priority = 2, description = "Launch endole and linkedin browsers")
	public void lauchSearchBrowsers() throws Exception {
		ExtentTestManager.startTest("Launch endole and linkedin browsers", "Launch endole and linkedin browsers");
		endoleDriver();
		linkedInDriver();
	}
	
	@Test(priority = 3, description = "Get open records data")
	public void getOpenNotesRecord() throws Exception {
		getCountry = campaignTestDataProcess().getLeadsCountry();
		getCompanySize = campaignTestDataProcess().getLeadsCompanySize();
		getIndustrialVertical = campaignTestDataProcess().getLeadsIndustrialVertical();
		getJobFunction = campaignTestDataProcess().getLeadsJobFunction();
		getJobTitle = campaignTestDataProcess().getLeadsJobTitle();
		logger.info("Country details : " + getCountry);
		logger.info("Company Size : " + getCompanySize);
		logger.info("Industrial : " + getIndustrialVertical);
		logger.info("Job Function: " + getJobFunction);
		logger.info("Job Title : " + getJobTitle);
		List<String> customRegions = CampaignTestDataProcess.getCustomRegions("Cus_EMEA");
		logger.info("custom Regions data : " + customRegions);
		List<String> countryMapping = CampaignTestDataProcess.getCountryMapping("NORDIC", "countryCode1");
		logger.info("country Mapping data : " + countryMapping);
	}

	@DataProvider(name = "getLeadsData")
	public Iterator<Object[]> getLeadsData() throws Exception {
		List<Object[]> dataList = new ArrayList<Object[]>();
		leadPage().readCampaignLeadsFile();
		List<String> campaignLeadsLine = campaignTestDataProcess().getcampaignDataLines();
		for (String Leadsline : campaignLeadsLine) {
			dataList.add(new Object[] { Leadsline });
		}
		return dataList.iterator();
	}

	@Test(dataProvider = "getLeadsData", priority = 3, description = "Lead Testing")
	public void leadsCheck(String leadsLine) throws Exception {
		String leadId = leadsLine.substring(leadsLine.length() - 9);
		ExtentTestManager.startTest("Lead Id--> " + leadId, "Lead Testing");
		leadPage()
		.clickLeadsFromFile(leadsLine)
		//.placementCheck()
		.countryCheck()
		.companySizeCheck()
		//.companyTurnoverCheck()
		//.firstnameLastnameJobTitleCheck()
		.updateManuallyVerify()
		.clickSaveBtn();
		//.clickCloseBtn();
		ExtentTestManager.endTest();
	}
}

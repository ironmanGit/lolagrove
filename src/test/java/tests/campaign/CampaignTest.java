package tests.campaign;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.log4j.Logger;
import pageObjects.initializePageObjects.PageFactoryInitializer;
import pageObjects.modules.LeadPageObjects;
import utils.ExtentReports.ExtentTestManager;

public class CampaignTest extends PageFactoryInitializer {
	private Logger logger = Logger.getLogger(CampaignTest.class.getName());
	private LeadPageObjects leadPage = leadPage();
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
//		 .createCampaignLeadsFile();
//		 leadPage.readCampaignLeadsFile();
		ExtentTestManager.endTest();
	}
	
	@Test(priority = 2, description = "Get open records data")
	public void getOpenNotesRecord() throws Exception {
		getCountry = leadPage.getLeadsCountry();
		getCompanySize = leadPage.getLeadsCompanySize();
		getIndustrialVertical = leadPage.getLeadsIndustrialVertical();
		getJobFunction = leadPage.getLeadsJobFunction();
		getJobTitle = leadPage.getLeadsJobTitle();
	}

	@DataProvider(name = "getLeadsData")
	public Iterator<Object[]> getLeadsData() throws Exception {
		List<Object[]> dataList = new ArrayList<Object[]>();
		leadPage.readCampaignLeadsFile();
		List<String> campaignLeadsLine = leadPage.getcampaignDataLines();
		for (String Leadsline : campaignLeadsLine) {
			dataList.add(new Object[] { Leadsline });
		}
		return dataList.iterator();
	}

	@Test(dataProvider = "getLeadsData", priority = 3, description = "Lead Testing")
	public void leadsCheck(String leadsLine) throws Exception {
		logger.info("Country details : " +getCountry);
		logger.info("Company Size : "+getCompanySize);
		logger.info("Industrial : " +getIndustrialVertical);
		logger.info("Job Function: " +getJobFunction);
		logger.info("Job Title : "+getJobTitle);
		String leadId = leadsLine.substring(leadsLine.length() - 9);
		ExtentTestManager.startTest("Lead Id--> " + leadId, "Lead Testing");
		leadPage()
		.clickLeadsFromFile(leadsLine)
		.clickCloseBtn();
		ExtentTestManager.endTest();
	}
}

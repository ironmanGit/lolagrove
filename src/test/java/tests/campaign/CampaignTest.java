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
	 
	
	@Test(priority = 1, description = "Navigate to Campaign")
	public void campaignCheck() throws Exception {
		ExtentTestManager.startTest("Navigate to Campaign", "Navigate to Campaign");
		loginPage()
		.login()
		.verifyCampaignTab()
		.selectCampaign()
		.navigateToLeadsPage()
		.clickOpenNotesLink()
		.getAllFieldsFromOpenNotes();
		openNotesPage().closeOpenNotesTab();
		leadPage.setTestDataCheck();
//		 .createCampaignLeadsFile();
//		 leadPage.readCampaignLeadsFile();
		ExtentTestManager.endTest();
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

//	@Test(dataProvider = "getLeadsData", priority = 2, description = "Lead Testing")
	public void leadsCheck(String leadsLine) throws Exception {
		String leadId = leadsLine.substring(leadsLine.length() - 9);
		ExtentTestManager.startTest("Lead Id--> " + leadId, "Lead Testing");
		leadPage()
		.clickLeadsFromFile(leadsLine)
		.clickCloseBtn();
		ExtentTestManager.endTest();
	}
}

package tests.campaign;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import pageObjects.initializePageObjects.PageFactoryInitializer;
import pageObjects.modules.LeadPageObjects;

public class CampaignTest extends PageFactoryInitializer {
	private Logger logger = Logger.getLogger(CampaignTest.class.getName());

	private LeadPageObjects leadPage = leadPage();

	@Test(priority = 1, description = "Scenario 1")
	public void campaignCheck() throws Exception {
		loginPage()
		.login()
		.verifyCampaignTab()
		.selectCampaign()
		.navigateToLeadsPage();
		// .createCampaignLeadsFile();
		// leadsPage.readCampaignLeadsFile();
	}

	@DataProvider
	public Iterator<Object[]> getLeadsData() throws Exception {
		List<Object[]> dataList = new ArrayList<Object[]>();
		
		
		leadPage.readCampaignLeadsFile();
		List<String> campaignLeadsLine = leadPage.getcampaignDataLines();
		for (String Leadsline : campaignLeadsLine) {
			dataList.add(new Object[] { Leadsline });
		}
		return dataList.iterator();
	}

	@Test(dataProvider = "getLeadsData", priority = 2)
	public void leadsCheck(String leadsLine) throws Exception {
		leadPage()
		.clickLeadsFromFile(leadsLine)
		.clickCloseBtn();
	}
}

package tests.campaign;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.log4j.Logger;
import pageObjects.initializePageObjects.PageFactoryInitializer;
import pageObjects.modules.LeadPageObjects;

public class CampaignTest extends PageFactoryInitializer {
	private Logger logger = Logger.getLogger(CampaignTest.class.getName());
	private LeadPageObjects leadPage = leadPage();
	 
	@BeforeMethod
	public void BeforeMethod(Object[] testData, ITestContext ctx) {
		if (testData.length > 0) {
			String td = testData[0].toString();
			ctx.setAttribute("description", "Lead Id-->" + td.substring(td.length() - 9));
		} else
			ctx.setAttribute("description", "Navigate to Campaign");
	}

	@Test(priority = 1, description = "Navigate to Campaign")
	public void campaignCheck() throws Exception {
		loginPage()
		.login()
		.verifyCampaignTab()
		.selectCampaign()
		.navigateToLeadsPage();
		// .createCampaignLeadsFile();
		// leadsPage.readCampaignLeadsFile();
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

	@Test(dataProvider = "getLeadsData", priority = 2, description = "Navigate to Campaign")
	public void leadsCheck(String leadsLine) throws Exception {
		leadPage()
		.clickLeadsFromFile(leadsLine)
		.clickCloseBtn();
	}
}

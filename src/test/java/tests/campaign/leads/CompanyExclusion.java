package tests.campaign.leads;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;

import pageObjects.modules.LeadPageObjects;
import utils.ExtentReports.ExtentTestManager;

public class CompanyExclusion extends LeadPageObjects  {
	private Logger logger = Logger.getLogger(LeadPageObjects.class.getName());

	public LeadPageObjects companyExclusionCheck() throws Exception {
		String leadCompanyName = getvalueCompanyName();
		List<String> companyExclusionList = campaignTestDataProcess().getLeadsExclusionCompanyListUrl();
		if (companyExclusionList.size() > 0) {
			selectvalueCompanyToolsDropdown("Google (Generic)");
			for (int i = 0; i < companyExclusionList.size(); i++) {
				getWebDriver().navigate().to(companyExclusionList.get(i));
				List<WebElement> thList = getWebDriver().findElements(By.cssSelector("body > table th"));
				List<String> headers = new ArrayList<>();
				thList.stream().forEach(th -> headers.add(th.getText()));
				int index = headers.indexOf("Company Name");

				WebElement company = getXpath("//tr/td[" + index + "[contains(text(),'%s')]", leadCompanyName);

				if (isFieldExist(company)) {
					googlePage().closeGooglePage();
					selectvalueRejectionReasonDropdown(" Excluded Company");
					setvalueRejectionReasonEvidence(" Excluded Company");
					ExtentTestManager.getTest().log(LogStatus.FAIL, "Company is available in exclusion list");
				} else {
					googlePage().closeGooglePage();
					ExtentTestManager.getTest().log(LogStatus.PASS, "Company is not available in exclusion list");
				}
			}
		} else {
			ExtentTestManager.getTest().log(LogStatus.INFO, "TAL is not applicable for this campaign");
		}
		return leadPage();
	}
}

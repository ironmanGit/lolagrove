package tests.campaign.leads;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;

import pageObjects.modules.LeadPageObjects;
import utils.ExtentReports.ExtentTestManager;

public class CompanyTAL extends LeadPageObjects {

	private Logger logger = Logger.getLogger(LeadPageObjects.class.getName());

	public LeadPageObjects companyTALCheck() throws Exception {
		String leadCompanyName = getvalueCompanyName();
		List<String> companyTalList = campaignTestDataProcess().getLeadsCompanyListUrl();
		if (companyTalList.size() > 0) {
			selectvalueCompanyToolsDropdown("Google (Generic)");
			for (int i = 0; i < companyTalList.size(); i++) {
				getWebDriver().navigate().to(companyTalList.get(i));
				List<WebElement> thList = getWebDriver().findElements(By.cssSelector("body > table th"));
				List<String> headers = new ArrayList<>();
				thList.stream().forEach(th -> headers.add(th.getText()));
				int index = headers.indexOf("Company Name");

				WebElement company = getXpath("//tr/td[" + index + "[contains(text(),'%s')]", leadCompanyName);

				if (isFieldExist(company)) {
					googlePage().closeGooglePage();
					ExtentTestManager.getTest().log(LogStatus.PASS, "Company is available in target list");
				} else {
					googlePage().closeGooglePage();
					selectvalueRejectionReasonDropdown("No Target List Matches");
					setvalueRejectionReasonEvidence("No Target List Matches");
					ExtentTestManager.getTest().log(LogStatus.FAIL, "Company is not available in target list");
				}
			}
		} else {
			ExtentTestManager.getTest().log(LogStatus.INFO, "TAL is not applicable for this campaign");
		}
		return leadPage();
	}
}

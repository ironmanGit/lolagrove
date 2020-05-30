/**
 * 
 */
package pageObjects.modules;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pageObjects.initializePageObjects.PageFactoryInitializer;
import utils.ExplicitWaiting;
import utils.RandomGenerator;
import utils.ExtentReports.ExtentTestManager;
import com.relevantcodes.extentreports.LogStatus;

/**
 * @Author Vivekanandan Sampath
 * @Date Mar 09, 2020
 */
public class EndolePageObjects extends PageFactoryInitializer {

	private Logger logger = Logger.getLogger(LeadPageObjects.class.getName());

	@FindBy(xpath = "//div[@class='financial-overview']/span[contains(text(),'Turnover ')]/following-sibling::span")
	private WebElement turnOverValue;

	public String getTurnoverValue(String type) throws Exception {
		ExplicitWaiting.explicitWaitVisibilityOfElement(turnOverValue, 15);
		String turnover = getText(turnOverValue);
		String value = null;
		if (turnover.contains("Unreported") || turnover == null || turnover.equals(" ") || turnover.equals("") || turnover.equals("No records")) {
			value = "Unreported";
			ExtentTestManager.getTest().log(LogStatus.INFO, "turnover value is null or unreported or empty");
		} else {
			String mORb = turnover.replaceAll("\\.?[0-9]|£|$", "").toLowerCase();
			value = turnover.replaceAll("([a-z]|[A-Z]|£|$)", "");
			value = value.replaceAll("(\\.\\d+)", "");
			value = roundOffTurnover(value, mORb, type);
			try {
				ExtentTestManager.getTest().log(LogStatus.PASS, "turnover value is " + value);
			} catch (Exception e) {
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to get value from turnover " + e);
			}
		}

		return value;
	}

	public LeadPageObjects closeEndolePage() throws Exception {
		try {
			closeTab();
			ExtentTestManager.getTest().log(LogStatus.PASS, "Endole page is closed");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to close endole page" + e);
		}
		return leadPage();
	}
}

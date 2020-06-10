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
public class ZoomInfoPageObjects extends PageFactoryInitializer {

	private Logger logger = Logger.getLogger(LeadPageObjects.class.getName());

	@FindBy(xpath = "//h3[contains(text(), 'Headquarters')]/following-sibling::div/span")
	private WebElement headquartersValue;

	@FindBy(xpath = "//h3[contains(text(), 'Phone')]/following-sibling::div/span")
	private WebElement phoneValue;

	@FindBy(xpath = "//h3[contains(text(), 'Website')]/following-sibling::div/span")
	private WebElement websiteValue;

	@FindBy(xpath = "//h3[contains(text(), 'Employees')]/following-sibling::div/span")
	private WebElement employeesValue;

	@FindBy(xpath = "//h3[contains(text(), 'Revenue')]/following-sibling::div/span")
	private WebElement revenueValue;

	public String getHeadquartersValue() throws Exception {
		String value = getText(headquartersValue);
		try {
			if (value != null) {
				ExtentTestManager.getTest().log(LogStatus.PASS, "headquarters value is " + value);
			} else
				ExtentTestManager.getTest().log(LogStatus.INFO, "headquarters value is null");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to get value from headquarters " + e);
		}
		return value;
	}

	public String getPhoneValue() throws Exception {
		String value = getText(phoneValue);
		try {
			if (value != null) {
				ExtentTestManager.getTest().log(LogStatus.PASS, "phone value is " + value);
			} else
				ExtentTestManager.getTest().log(LogStatus.INFO, "phone value is null");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to get value from phone " + e);
		}
		return value;
	}

	public String getWebsiteValue() throws Exception {
		String value = getText(websiteValue);
		try {
			if (value != null) {
				ExtentTestManager.getTest().log(LogStatus.PASS, "website value is " + value);
			} else
				ExtentTestManager.getTest().log(LogStatus.INFO, "website value is null");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to get value from website " + e);
		}
		return value;
	}

	public String getEmployeesValue(String type) throws Exception {
		String value = null;
		if (isFieldExist(employeesValue)) {
			ExplicitWaiting.explicitWaitVisibilityOfElement(employeesValue, 15);
			value = getText(employeesValue).replaceAll("[a-z]| ", "");
			value = value.replaceAll(".+(?<=-)", "");
			value = value.replaceAll("([,|+])", "");
			value = roundOffCompanySize(type, value);
			try {
				if (value != null) {
					ExtentTestManager.getTest().log(LogStatus.PASS, "companySize value is " + value);
				} else
					ExtentTestManager.getTest().log(LogStatus.INFO, "companySize value is null");
			} catch (Exception e) {
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to get value from companySize " + e);
			}
		} else {
			value = null;
		}
		return value;
	}

	public String getRevenueValue(String type) throws Exception {
		String value = null;
		if (isFieldExist(revenueValue)) {
			ExplicitWaiting.explicitWaitVisibilityOfElement(revenueValue, 15);
			String turnover = getText(revenueValue);
			if (turnover.contains("Unreported") || turnover == null || turnover.equals(" ") || turnover.equals("")
					|| turnover.equals("No records")) {
				value = "Unreported";
				ExtentTestManager.getTest().log(LogStatus.INFO, "turnover value is null or unreported or empty");
			} else {
				String mORb = turnover.replaceAll("[a-z]|[0-9]|\\£|\\$", "").toLowerCase();
				value = turnover.replaceAll("([a-z]|[A-Z]|\\£|\\$| )", "");
				value = value.replaceAll("(\\.\\d+)", "");
				value = roundOffTurnover(value, mORb, type);
				try {
					ExtentTestManager.getTest().log(LogStatus.PASS, "turnover value is " + value);
				} catch (Exception e) {
					ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to get value from turnover " + e);
				}
			}
		} else {
			value = null;
		}
		return value;
	}

	public LeadPageObjects closeZoomInfoPage() throws Exception {
		try {
			closeTab();
			ExtentTestManager.getTest().log(LogStatus.PASS, "Zoom info page is closed");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to close zoom info page" + e);
		}
		return leadPage();
	}
}

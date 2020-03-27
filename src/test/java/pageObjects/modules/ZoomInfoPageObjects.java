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
	
	public String getHeadquartersValue() throws Exception {
		ExplicitWaiting.explicitWaitVisibilityOfElement(headquartersValue, 15);
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
		ExplicitWaiting.explicitWaitVisibilityOfElement(phoneValue, 15);
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
		ExplicitWaiting.explicitWaitVisibilityOfElement(websiteValue, 15);
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
	
	public String getEmployeesValue() throws Exception {
		ExplicitWaiting.explicitWaitVisibilityOfElement(employeesValue, 15);
		String value = getText(employeesValue);
		try {
			if (value != null) {
				ExtentTestManager.getTest().log(LogStatus.PASS, "employees value is " + value);
			} else
				ExtentTestManager.getTest().log(LogStatus.INFO, "employees value is null");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to get value from employees " + e);
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

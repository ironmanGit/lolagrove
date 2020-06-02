/**
 * 
 */
package pageObjects.modules;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pageObjects.initializePageObjects.PageFactoryInitializer;
import utils.ExplicitWaiting;
import utils.RandomGenerator;
import utils.ExtentReports.ExtentTestManager;
import com.relevantcodes.extentreports.LogStatus;

/**
 * @Author Anand Kumar
 * @Date May 19, 2020
 */
public class TelephonePageObjects extends PageFactoryInitializer {

	private Logger logger = Logger.getLogger(LeadPageObjects.class.getName());

	@FindBy(css = "input[name='phoneNumber']")
	private WebElement phoneNumber;

	@FindBy(css = "input[name='defaultCountry']")
	private WebElement regionCode;

	@FindBy(css = "input[type='submit']")
	private WebElement submitbtn;

	@FindBy(css = "input[type='reset']")
	private WebElement resetbtn;
	
	@FindBy(xpath= "//th[text()='Result from isValidNumber()']/following-sibling::td")
	private WebElement getPhoneNumberStatus;
	

	public TelephonePageObjects getPhoneNumberStatus() throws Exception {
		try {
			ExplicitWaiting.explicitWaitVisibilityOfElement(getPhoneNumberStatus, 15);
			String status = getText(getPhoneNumberStatus);
			
			
			ExtentTestManager.getTest().log(LogStatus.PASS, "Value for Phone Number is set as " + status);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to set value for Phone Number " + e);
		}
		return this;
	}
	
	public TelephonePageObjects setvaluePhoneNumber(String value) throws Exception {
		try {
			ExplicitWaiting.explicitWaitVisibilityOfElement(phoneNumber, 15);
			clear(phoneNumber);
			sendKeys(phoneNumber, value);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Value for Phone Number is set as " + value);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to set value for Phone Number " + e);
		}
		return this;
	}
	
	public TelephonePageObjects setvalueRegionCode(String value) throws Exception {
		try {
			ExplicitWaiting.explicitWaitVisibilityOfElement(regionCode, 15);
			clear(regionCode);
			sendKeys(regionCode, value);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Value for Region Code is set as " + value);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to set value for Region Code " + e);
		}
		return this;
	}
	
	public TelephonePageObjects clickSubmitbtn() throws Exception {
		try {
			ExplicitWaiting.explicitWaitVisibilityOfElement(submitbtn, 15);
//			scrollDown();
			click(submitbtn);
			ExtentTestManager.getTest().log(LogStatus.INFO, "Clicked Submit button");
								
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to click Submit button " + e);
		}
		return this;
	}
	
	public TelephonePageObjects clickResetbtn() throws Exception {
		try {
			ExplicitWaiting.explicitWaitVisibilityOfElement(resetbtn, 15);
//			scrollDown();
			click(resetbtn);
			ExtentTestManager.getTest().log(LogStatus.INFO, "Clicked Reset button");
								
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to click Reset button " + e);
		}
		return this;
	}

	


}

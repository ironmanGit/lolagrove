/**
 * 
 */
package pageObjects.modules;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pageObjects.initializePageObjects.PageFactoryInitializer;
import utils.RandomGenerator;
import utils.ExtentReports.ExtentTestManager;
import com.relevantcodes.extentreports.LogStatus;

/**
 * @Author Vivekanandan Sampath
 * @Date Mar 09, 2020
 */
public class GoogleHomePageObjects extends PageFactoryInitializer {
	@FindBy(xpath = "//a[text()='Gmail']")
	private WebElement gmailLink;

	@FindBy(id = "lst-ib")
	private WebElement searchBox;

	@FindBy(css = "a>h3")
	private WebElement searchResult1;
	
	public GoogleHomePageObjects clickonGmailLink() throws Exception {
		click(gmailLink);
		return this;
	}
	
	public GoogleHomePageObjects enterTextToSearchBox(String value) {
		try {
			searchBox.sendKeys(value);
			ExtentTestManager.getTest().log(LogStatus.INFO, "Value entered in search box is " + value);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.INFO, "Unable to enter value in search box" + e);
		}
		return this;
	}

	public GoogleHomePageObjects verifyPageTitle() throws Exception {
		try {
			Assert.assertEquals(getWebDriver().getTitle(), "Google");
			ExtentTestManager.getTest().log(LogStatus.INFO, "Google Test Passed");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.INFO, "Google Test Failed" + e);
		}
		return this;
	}

}

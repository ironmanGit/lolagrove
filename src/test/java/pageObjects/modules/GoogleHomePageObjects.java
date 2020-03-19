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
	private WebElement GmailLink;

	@FindBy(id = "lst-ib")
	private WebElement SearchBox;

	public GoogleHomePageObjects clickonGmailLink() throws Exception {
		click(GmailLink);
		return this;
	}

	public GoogleHomePageObjects enterTextToSearchBox() {
		SearchBox.sendKeys(RandomGenerator.GenerateRandomEMAILIDs("google.com"));
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

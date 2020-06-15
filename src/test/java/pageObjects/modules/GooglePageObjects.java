/**
 * 
 */
package pageObjects.modules;

import java.util.ArrayList;
import java.util.List;

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
public class GooglePageObjects extends PageFactoryInitializer {
	@FindBy(xpath = "//a[text()='Gmail']")
	private WebElement gmailLink;

	@FindBy(id = "lst-ib")
	private WebElement searchBox;

	@FindBy(css = "a>h3")
	private WebElement searchResult1;
	
	@FindBy(css = "div.s div span")
	private List<WebElement> descriptionContains;
	
	public GooglePageObjects clickonGmailLink() throws Exception {
		click(gmailLink);
		return this;
	}
	
	public GooglePageObjects enterTextToSearchBox(String value) {
		try {
			searchBox.sendKeys(value);
			ExtentTestManager.getTest().log(LogStatus.INFO, "Value entered in search box is " + value);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.INFO, "Unable to enter value in search box" + e);
		}
		return this;
	}

	public List<String> getMatchedEmailHref(String emailValue) {
		String [] balckListedHrefs= {"emailverifier", "scribd", "rocketreach", "prospectworx", "cleantalk",
				"lead411", "skymem", "emailsherlock", "email-format", "webspotter"};
		List<String> value = new ArrayList<>();
		try {
			List<String> emailHref = getHrefMatchedDescription(emailValue);
			if(emailHref.size() > 0) {
				for (int i=0; i < emailHref.size(); i++) {
					for (int j=0; j < balckListedHrefs.length; j++) {
						if (!emailHref.get(i).contains(balckListedHrefs[j])) {
							value.add(emailHref.get(i));
						} 
					}
				}
			}
			ExtentTestManager.getTest().log(LogStatus.INFO, "Got verified email hrefs " + value);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.INFO, "Unable to get verified email hrefs" + e);
		}
		return value;
	}
	
	public GooglePageObjects verifyPageTitle() throws Exception {
		try {
			Assert.assertEquals(getWebDriver().getTitle(), "Google");
			ExtentTestManager.getTest().log(LogStatus.INFO, "Google Test Passed");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.INFO, "Google Test Failed" + e);
		}
		return this;
	}
	
	public LeadPageObjects closeGooglePage() throws Exception {
		try {
			closeTab();
			ExtentTestManager.getTest().log(LogStatus.PASS, "Google page is closed");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to close google page" + e);
		}
		return leadPage();
	}

}

/**
 * 
 */
package pageObjects.modules;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.initializePageObjects.PageFactoryInitializer;
import utils.ExtentReports.ExtentTestManager;
import com.relevantcodes.extentreports.LogStatus;

/**
 * @Author Vivekanandan Sampath
 * @Date Mar 09, 2020
 */
public class LoginPageObjects extends PageFactoryInitializer
{
	
	public static String username = appConfig.getUsername();
	public static String password = appConfig.getPassword();
	
	@FindBy(css="input#txtInput")
	private WebElement inputUserid;

	@FindBy(css="input#txtPassword")
	private WebElement inputPassword;

	@FindBy(css="input#lnkBtnLogin")
	private WebElement linkSubmit;

	public LandingPageObjects login() throws Exception {
		enterUsername(username);
		enterPassword(password);
		click(linkSubmit);
		return landingPage();
	}
	
	public LandingPageObjects login(String username, String password) throws Exception {
		enterUsername(username);
		enterPassword(password);
		click(linkSubmit);
		return landingPage();
	}

	public LoginPageObjects enterUsername(String username) {
		try{
			inputUserid.sendKeys(username);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Username Entered");
		}
		catch(Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Username Entry Failed");
		}
		return this;
	}

	public LoginPageObjects enterPassword(String password) {
		try{
			inputPassword.sendKeys(password);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Password Entered");
		}
		catch(Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Password Entry Failed");
		}
		return this;
	}

	public LandingPageObjects clickSubmit(String username) throws Exception {
		
		try{
			linkSubmit.click();
			ExtentTestManager.getTest().log(LogStatus.PASS, "Submit Button Clicked");
		}
		catch(Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Click Submit Button Failed");
		}
		return landingPage();
	}

}

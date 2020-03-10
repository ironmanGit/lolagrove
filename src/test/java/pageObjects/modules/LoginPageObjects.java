/**
 * 
 */
package pageObjects.modules;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.initializePageObjects.PageFactoryInitializer;

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
		inputUserid.sendKeys(username);
		return this;
	}

	public LoginPageObjects enterPassword(String password) {
		inputPassword.sendKeys(password);
		return this;
	}

	public LandingPageObjects clickSubmit(String username) throws Exception {
		linkSubmit.click();
		return landingPage();
	}

}

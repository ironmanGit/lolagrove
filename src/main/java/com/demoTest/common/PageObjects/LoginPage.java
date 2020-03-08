package com.demoTest.common.PageObjects;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.demoTest.common.AbstractBasePage;

public class LoginPage extends AbstractBasePage {
	static Logger logger = Logger.getLogger(LoginPage.class.getName());

	@FindBy(css="input#txtInput")
	private WebElement inputUserid;

	@FindBy(css="input#txtPassword")
	private WebElement inputPassword;

	@FindBy(css="input#lnkBtnLogin")
	private WebElement linkSubmit;

	public LoginPage(WebDriver driver) throws Exception {
		super(driver, "Login Page");
	}

	public LandingPage login(String username, String password) throws Exception {
		enterUsername(username);
		enterPassword(password);
		LandingPage landingPage = clickSubmit(username);
		return landingPage;
	}

	public LoginPage enterUsername(String username) {
		enterInput(username, inputUserid);
		return this;
	}

	public LoginPage enterPassword(String password) {
		enterInput(password, inputPassword);
		return this;
	}

	public LandingPage clickSubmit(String username) throws Exception {
		linkSubmit.click();
		LandingPage landingPage = null;
		try {
			landingPage = new LandingPage(driver);
		} catch (Exception e) {
			String errMsg = e.getMessage();
			if (errMsg.contains("page name")) {
				WebDriver driver = this.getDriver();
				List<WebElement> errorelements = driver.findElements(By.cssSelector("h5 strong"));
				if (errorelements.size() > 0) {
					String errorText = errorelements.get(0).getText();
					throw new Exception("Error: login failed for user " + username + ": " + errorText );
				}
				throw e;
			}
		}
		return landingPage;
	}
}

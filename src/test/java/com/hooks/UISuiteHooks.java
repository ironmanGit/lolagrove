package com.hooks;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.demoTest.LaunchBrowser.LaunchBrowser;
import com.demoTest.common.PageObjects.LandingPage;
import com.demoTest.common.PageObjects.LoginPage;

import utils.ConfigUtils;

public class UISuiteHooks extends Thread {
	static Logger logger = Logger.getLogger(UISuiteHooks.class.getName());

	private String myBrowser = null;
	private String myUsername = null;
	private String myPassword = null;
	private String myUrl = null;
	private LaunchBrowser myBrowserPage = null;
	private LandingPage myHomePage = null;

	public LandingPage getHomePage() {
		return myHomePage;
	}

	public void setHomePage(LandingPage homePage) {
		this.myHomePage = homePage;
	}

	public String getMyUsername() {
		return myUsername;
	}

	public void setMyUsername(String myUsername) {
		this.myUsername = myUsername;
	}

	public String getMyBrowser() {
		return myBrowser;
	}

	public void setMyBrowser(String myBrowser) {
		this.myBrowser = myBrowser;
	}

	public String getMyPassword() {
		return myPassword;
	}

	public void setMyPassword(String myPassword) {
		this.myPassword = myPassword;
	}

	public String getMyUrl() {
		return myUrl;
	}

	public void setMyUrl(String myUrl) {
		this.myUrl = myUrl;
	}

	public LaunchBrowser getMyBrowserPage() {
		return myBrowserPage;
	}

	public void setMyBrowserPage(LaunchBrowser myBrowserPage) {
		this.myBrowserPage = myBrowserPage;
	}

	@BeforeClass
	@Parameters({ "browser", "username", "password", "site" })
	public void launchApp(@Optional("") String paramBrowser, @Optional("") String paramUsername,
			@Optional("") String paramPassword, @Optional("") String paramSite) throws Exception {
		logger.info("UI start up...");

//		String site;
//		String runTimeSite = System.getProperty("site");
//		if (runTimeSite != null && !runTimeSite.trim().isEmpty()) {
//			site = runTimeSite;
//			
//		}
//		else if (paramSite != null && !paramSite.trim().isEmpty() ) {
//			site = paramSite;
//		}
//		else {
//			site = "QA";
//		}
//		System.setProperty("site", site);

		String configFile = ConfigUtils.getCongFile();

		String url = ConfigUtils.getConfigProperty(configFile, "url");

		String browser;
		String runTimeBrowser = System.getProperty("browser");
		if (runTimeBrowser != null && !runTimeBrowser.trim().isEmpty()) {
			browser = runTimeBrowser;
		} else if (paramBrowser != null && !paramBrowser.trim().isEmpty()) {
			browser = paramBrowser;
		} else {
			browser = ConfigUtils.getConfigProperty(configFile, "browser");
			if (browser == null || browser.trim().isEmpty()) {
				browser = "chrome";
			}
		}

		String username;
		String runTimeUsername = System.getProperty("username");
		if (runTimeUsername != null && !runTimeUsername.trim().isEmpty()) {
			username = runTimeUsername;
		} else if (paramUsername != null && !paramUsername.trim().isEmpty()) {
			username = paramUsername;
		} else {
			username = ConfigUtils.getConfigProperty(configFile, "username");
		}

		String password = null;
		String runTimePassword = System.getProperty("password");
		if (runTimePassword != null && !runTimePassword.trim().isEmpty()) {
			password = runTimePassword;
		}
		if (username != null && !username.isEmpty()) {
			String userPassword = System.getProperty(username);
			if (userPassword != null && !userPassword.trim().isEmpty()) {
				password = userPassword;
			}
		}

		if (password == null) {
			if (paramPassword != null && !paramPassword.trim().isEmpty()) {
				password = paramPassword;
			} else {
				password = ConfigUtils.getConfigProperty(configFile, "password");
			}
		}

//		logger.info("browser = " + browser);
//		logger.info("url = " + url);
//		logger.info("browser = " + browser);
//		logger.info("username = " + username);

		myBrowser = browser;
		myUsername = username;
		myPassword = password;
		myUrl = url;

		logger.info("launch browser...");
		LaunchBrowser browserPage = new LaunchBrowser(browser);

		WebDriver driver = browserPage.getDriver();

		browserPage.getDriver().get(url);
		LoginPage loginPage = new LoginPage(driver);
		myHomePage = loginPage.login(username, password);
		myBrowserPage = browserPage;
		this.setMyBrowserPage(browserPage);
		this.setHomePage(myHomePage);
	}

	@AfterClass
	public void tearDownAfterTest() throws Exception {
		logger.info("tear down browser...");
		if (myHomePage != null) {
			logger.info("now quit web driver");
			myHomePage.getDriver().quit();
		}
	}
}

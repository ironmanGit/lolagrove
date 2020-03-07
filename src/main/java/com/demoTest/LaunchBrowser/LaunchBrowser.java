package com.demoTest.LaunchBrowser;

import java.io.File;
import java.net.URL;
import java.util.Hashtable;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.demoTest.common.TestUtils;

import utils.ConfigUtils;

public class LaunchBrowser {
	static Logger logger = Logger.getLogger(LaunchBrowser.class.getName());

	private WebDriver driver;
	private static String browser;
	private static int defaultWaitSecond = 90;
	
	
	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	
	public LaunchBrowser() throws Exception {
		String configFile = ConfigUtils.getCongFile();
		String browser = ConfigUtils.getConfigProperty(configFile, "browser");
		if (browser == null || browser.trim().isEmpty()) {
			throw new Exception("Error: property browser is not defined");
		}
		LaunchBrowser(browser);
	}
	
	public LaunchBrowser(String browserType) throws Exception {
		System.setProperty("browser", browserType);
		this.browser = browserType;
		LaunchBrowser(browserType);
	}
	public void LaunchBrowser(String type) throws Exception {
		
		int maxTry = 5; 
		
		if (type.equals("ie")) {
			this.launchIEDriver();
		} else if (type.equals("chrome")) {
			this.launchChromeDriver();
		} else if (type.equals("chromeGrid")) {
			this.launchChromeGridDriverWithRetry(maxTry);
		} else if (type.equals("headLess")) {
			this.launchHeadLessDriver();
		} else {
			throw new Exception("Error: invalid type " + type);
		}
		
		String waitTime = System.getProperty("waitTime");
		
		int wait_time = this.defaultWaitSecond;
		if (waitTime != null && !waitTime.trim().isEmpty()) {
			wait_time = Integer.parseInt(waitTime);
		}
		
		Options options = driver.manage();
		
		options.timeouts().implicitlyWait(wait_time, TimeUnit.SECONDS);
		//options.

		//driver.manage().window().maximize();
	}

	public void launchHeadLessDriver() {
//		driver = new HtmlUnitDriver();
	}
		
	public void launchChromeDriver() throws Exception {
		System.setProperty("webdriver.chrome.driver", "target/classes/chromedriver.exe");
		ChromeOptions options = getChromeOptions();
		logger.info("launch ChromeDriver");
		driver = new ChromeDriver(options);
		return;
	}

	public static ChromeOptions getChromeOptions() throws Exception {
		String[] items =  new String[] {
			    "Adobe Flash Player",
			    "Chrome PDF Viewer"
		};
		// disable flash and the PDF viewer
		ChromeOptions options = new ChromeOptions();
		Hashtable<String, Object> preferences = new Hashtable<String, Object>();
		preferences.put("plugins.plugins_disabled", items);
		preferences.put("profile.default_content_settings.popups", 0);
	
		String downloadFolder = ConfigUtils.getDownloadFolder();
		TestUtils.createFolder(System.getProperty("user.dir")+ File.separator + downloadFolder);
		preferences.put("download.default_directory",  System.getProperty("user.dir")+ File.separator + downloadFolder);
		preferences.put("safebrowsing.enabled", "false");
		options.addArguments("--safebrowsing-disable-download-protection");
		options.setExperimentalOption("prefs", preferences);
//		options.addArguments("--disable-extensions");
		options.addArguments("--start-maximized");
		options.addArguments("--test-type");
//		options.addArguments("--headless");
		return options;
	}
	public void launchChromeGridDriverWithRetry(int maxTry) throws Exception {
		for (int numTry = 1; numTry <= maxTry; numTry++) {
			try {
				launchChromeGridDriver();
				break;
			} catch (Exception e) {
				logger.info("failed " + numTry + " out of " + maxTry);
				e.printStackTrace();
				if (numTry == maxTry) {
					throw new Exception("Error: failed to launch browser : "+e);
				}
			}
			TestUtils.pauseShort();
		}
	}
	public void launchChromeGridDriver() throws Exception {
		System.setProperty("webdriver.chrome.driver", "target/classes/chromedriver.exe");
		logger.info("launch Chrome Grid Driver");
		ChromeOptions chromeOptions = getChromeOptions();
	    String defaultGridUrl = "";	    
	    String gridUrl = System.getProperty("gridUrl");
	    if (gridUrl == null || gridUrl.trim().isEmpty()) {
	    	gridUrl = defaultGridUrl;
	    }   
	    logger.info("gridUrl = " + gridUrl);
	    RemoteWebDriver remoteDriver =  new RemoteWebDriver(new URL(gridUrl), chromeOptions);
		remoteDriver.setFileDetector(new LocalFileDetector());
		driver = remoteDriver;
		return;
	}

	public void launchIEDriver() {
		System.setProperty("webdriver.ie.driver", "target/classes/IEDriverServer.exe");
		driver = new InternetExplorerDriver();

		return;
	}
	
	public void close() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}

}

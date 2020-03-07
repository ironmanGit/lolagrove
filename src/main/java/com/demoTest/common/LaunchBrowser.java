package com.demoTest.common;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Hashtable;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import utils.ConfigUtils;

public class LaunchBrowser {
	static Logger logger = Logger.getLogger(LaunchBrowser.class.getName());

	private WebDriver driver;
//	private static int defaultWaitSecond = 90;
	
	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public LaunchBrowser(String type) throws Exception {
		if (type.equals("ie")) {
			this.launchIEDriver();
		} else if (type.equals("chrome")) {
			this.launchChromeDriver();
		} else if (type.equals("chromeGrid")) {
			this.launchChromeGridDriver();
		} else if (type.equals("headLess")) {
			this.launchHeadLessDriver();
		} else {
			throw new Exception("Error: invalid type " + type);
		}
		
		String waitTime = System.getProperty("waitTime");
		
		if (waitTime == null || waitTime.trim().isEmpty()) {
			waitTime = ConfigUtils.getConfigProperty("waitTime");
		}
		if (waitTime == null || waitTime.trim().isEmpty()) {
			waitTime = "90";
		}
		int wait_time = Integer.parseInt(waitTime);
		
		Options options = driver.manage();
		
		options.timeouts().implicitlyWait(wait_time, TimeUnit.SECONDS);
		//options.

		//driver.manage().window().maximize();
	}

	public void launchHeadLessDriver() {
//		driver = new HtmlUnitDriver();
	}
	
	
	public void launchChromeDriver() {
		System.setProperty("webdriver.chrome.driver", "target/classes/chromedriver.exe");

//		String[] items =  new String[] {
//			    "Adobe Flash Player",
//			    "Chrome PDF Viewer"
//		};
//		// disable flash and the PDF viewer
//		ChromeOptions options = new ChromeOptions();
//		Hashtable<String, Object> preferences = new Hashtable<String, Object>();
//		preferences.put("plugins.plugins_disabled", items);
//		
//		options.setExperimentalOption("prefs", preferences);
//		options.addArguments("--disable-extensions");
		ChromeOptions options = getChromeOptions();
		logger.info("launch ChromeDriver");
		driver = new ChromeDriver(options);
		
		
//		driver = new ChromeDriver();

		return;
	}

	public static ChromeOptions getChromeOptions() {
		String[] items =  new String[] {
			    "Adobe Flash Player",
			    "Chrome PDF Viewer"
		};
		// disable flash and the PDF viewer
		ChromeOptions options = new ChromeOptions();
		Hashtable<String, Object> preferences = new Hashtable<String, Object>();
		preferences.put("plugins.plugins_disabled", items);
		
		options.setExperimentalOption("prefs", preferences);
		options.addArguments("--disable-extensions");
		
		return options;
	}
	public void launchChromeGridDriver() throws Exception {
		System.setProperty("webdriver.chrome.driver", "target/classes/chromedriver.exe");
		logger.info("launch ChromeDriver");
		ChromeOptions chromeOptions = getChromeOptions();

	    String defaultGridUrl = "";
	    
	    String gridUrl = System.getProperty("gridUrl");
	    if (gridUrl == null || gridUrl.trim().isEmpty()) {
	    	gridUrl = defaultGridUrl;
	    }
	    
	    logger.info("gridUrl = " + gridUrl);
	    driver = new RemoteWebDriver(new URL(gridUrl), (Capabilities) chromeOptions);
		
		driver = new RemoteWebDriver(new URL(gridUrl), (Capabilities) chromeOptions);	
		
//		driver = new ChromeDriver();

		return;
	}

	public void launchIEDriver() {
		System.setProperty("webdriver.ie.driver", "target/classes/IEDriverServer.exe");
		driver = new InternetExplorerDriver();

		return;
	}

}

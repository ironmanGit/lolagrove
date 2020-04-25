package controllers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;

/**
 * @Author Vivekanandan Sampath
 * @Date Mar 09, 2020
 */

public class BrowserFactory extends InitMethod
{
	static WebDriver driver;		
	static DesiredCapabilities capabilities;


	@SuppressWarnings("deprecation")
	static WebDriver createDriver() throws Exception
	{

		switch(Browser.toLowerCase())
		{
		case "chrome":
			if (System.getProperty("os.name").toLowerCase().contains("win")) {
				System.setProperty("webdriver.chrome.driver", "src/main/resources/Drivers/chromedriver.exe");
				System.setProperty("webdriver.chrome.silentOutput","true");
			} else if (System.getProperty("os.name").toLowerCase().contains("mac")) {
				System.setProperty("webdriver.chrome.driver", "src/main/resources/Drivers/chromedriver");
				System.setProperty("webdriver.chrome.silentOutput","true");
			}
			driver = new ChromeDriver();
			break;

		case "chrome_headless":
			if (System.getProperty("os.name").toLowerCase().contains("win")) {
				System.setProperty("webdriver.chrome.driver", "src/main/resources/Drivers/chromedriver.exe");
				System.setProperty("webdriver.chrome.silentOutput","true");
			} else if (System.getProperty("os.name").toLowerCase().contains("mac")) {
				System.setProperty("webdriver.chrome.driver", "src/main/resources/Drivers/chromedriver");
				System.setProperty("webdriver.chrome.silentOutput","true");
			}
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--headless");  
			chromeOptions.addArguments("--disable-gpu");  
			driver = new ChromeDriver(chromeOptions);
			break;

		case  "firefox":
			System.setProperty("webdriver.gecko.driver", "src/main/resources/Drivers/geckodriver.exe");
			driver = new FirefoxDriver();
			break;

		case  "ie":
		case "internet explorer":
			System.setProperty("webdriver.ie.driver", "src/main/resources/Drivers/IEDriverServer.exe");
			DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer(); 
			ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
			break;	

		case  "edge":
			System.setProperty("webdriver.edge.driver", "src/main/resources/Drivers/MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
			break;


		case  "opera":
			System.setProperty("webdriver.chrome.driver", "src/main/resources/Drivers/chromedriver.exe");
			capabilities = DesiredCapabilities.opera();
			ChromeOptions optionsOpera = new ChromeOptions();
			optionsOpera.setBinary("C:/Program Files/Opera/launcher.exe");
			capabilities.setCapability(ChromeOptions.CAPABILITY, optionsOpera);
			driver = new ChromeDriver(capabilities);
			break;

		case "safari":
			driver = new SafariDriver();
			break;

		default:
			throw new NotFoundException("Browser Not Found. Please Provide a Valid Browser");
		}
		
		if(ImplicitlyWait > 0)
		{
			implicitlywait(ImplicitlyWait);
		}

		if(MaxPageLoadTime > 0)
		{
			setMaxPageLoadTime(MaxPageLoadTime);
		}
		driver.get(WebsiteURL);
		if(!Browser.toLowerCase().contains("unit") || !Browser.toLowerCase().contains("ghost") || !Browser.toLowerCase().contains("phantom"))
		{
			driver.manage().window().maximize();
		}
		return driver;		
	}

	public static void implicitlywait(int timeInSeconds) throws Exception
	{
		driver.manage().timeouts().implicitlyWait(timeInSeconds, TimeUnit.SECONDS);
	}

	public static void setMaxPageLoadTime(int timeInSeconds) throws Exception
	{
		driver.manage().timeouts().pageLoadTimeout(timeInSeconds, TimeUnit.SECONDS);
	}
}

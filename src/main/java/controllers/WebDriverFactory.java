/**
 * 
 */
package controllers;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

/**
 * @Author Vivekanandan Sampath
 * @Date Mar 09, 2020
 */
public class WebDriverFactory extends BrowserFactory {
	public static ThreadLocal<WebDriver> wd = new ThreadLocal<WebDriver>();
	public static ThreadLocal<WebDriver> ed = new ThreadLocal<WebDriver>();
	public static ThreadLocal<WebDriver> ld = new ThreadLocal<WebDriver>();
	public static ThreadLocal<WebDriver> zi = new ThreadLocal<WebDriver>();
	public static String browser;
	public static String url;

	@BeforeClass
	public void beforeClass() throws Exception
	{
		System.out.println("Browser: " + Browser);
		System.out.println("WebsiteURL: " + WebsiteURL);
		new WebDriverFactory();
		WebDriver driver = WebDriverFactory.createDriver();
		driver.get(WebsiteURL);
		setWebDriver(driver);
	}

	public void setWebDriver(WebDriver driver) {
		wd.set(driver);
	}

	public static WebDriver getWebDriver() {
		return wd.get();
	}

	public void endoleDriver() throws Exception
	{
		new WebDriverFactory();
		WebDriver endoleDriver = WebDriverFactory.createDriver();
		setEndoleWebDriver(endoleDriver);
		endoleDriver.navigate().to("https://www.endole.co.uk/");
	}
	
	public void setEndoleWebDriver(WebDriver driver) {
		ed.set(driver);
	}

	public static WebDriver getEndoleWebDriver() {
		return ed.get();
	}
	
	public void zoomInfoDriver() throws Exception
	{
		new WebDriverFactory();
		WebDriver zoomInfoDriver = WebDriverFactory.createDriver();
		setZoomInfoWebDriver(zoomInfoDriver);
		zoomInfoDriver.navigate().to("https://www.zoominfo.com/");
	}
	
	public void setZoomInfoWebDriver(WebDriver driver) {
		zi.set(driver);
	}

	public static WebDriver getZoomInfoWebDriver() {
		return zi.get();
	}
	
	public void linkedInDriver() throws Exception
	{
		new WebDriverFactory();
		WebDriver linkedInDriver = WebDriverFactory.createDriver();
		setzLinkedInWebDriver(linkedInDriver);
		linkedInDriver.navigate().to("https://www.linkedin.com/login?");
		linkedInDriver.findElement(By.cssSelector("input[id='username']")).sendKeys("leadscaleautomation@gmail.com");
		linkedInDriver.findElement(By.cssSelector("input[id='password']")).sendKeys("Merit@1234");
		linkedInDriver.findElement(By.cssSelector("div>button")).click();
	}
	
	public void setzLinkedInWebDriver(WebDriver driver) {
		ld.set(driver);
	}

	public static WebDriver getLinkedInWebDriver() {
		return ld.get();
	}
	
	public static void saveFullPageScreenshot(String name) throws IOException {
		Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000))
				.takeScreenshot(getWebDriver());
		ImageIO.write(screenshot.getImage(), "PNG", new File(name));
	}

	@AfterMethod(alwaysRun = true, enabled = true)
	public void afterMethod(ITestResult result) throws Exception {
		Thread.sleep(2000);
		if (result.getStatus() == ITestResult.FAILURE) {
			saveFullPageScreenshot("./src/test/resources/Reports/Images/" + result.getTestClass().getName() + "."
					+ result.getMethod().getMethodName() + ".png");
		}
	}
	
	@AfterClass(alwaysRun = true, enabled = true)
	public void afterClass() throws Exception {
		Thread.sleep(2000);
		getWebDriver().quit();
		getEndoleWebDriver().quit();
		getLinkedInWebDriver().quit();
		getZoomInfoWebDriver().quit();
	}
}

package com.demoTest.common;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.ConfigUtils;

public abstract class AbstractBasePage {
	static Logger logger = Logger.getLogger(AbstractBasePage.class.getName());
	public static String configFile = ConfigUtils.getCongFile();

	protected WebDriver driver;

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public WebDriver getDriver() {
		return driver;
	}

	@FindBy(id = "pageName")
	private WebElement pageName;

	public AbstractBasePage() {
		
	}
	
	public AbstractBasePage(WebDriver driver) throws Exception {
		this(driver, "");
	}
	public AbstractBasePage(WebDriver driver, String pageName) throws Exception {
		if (!pageName.equals("Login Page")) {
//			checkForCompanyLogo(pageName);
		}

//		logger.info("instantiate new object: '" + pageName + "'");
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// jack, 08/02/2019, wait until the page name element is visible
	private void checkForCompanyLogo(String pageName) throws Exception {
		String waitTime = System.getProperty("waitTime");
		
		if (waitTime == null || waitTime.trim().isEmpty()) {
			waitTime = ConfigUtils.getConfigProperty("waitTime");
		}
		if (waitTime == null || waitTime.trim().isEmpty()) {
			waitTime = "30";
		}
		int wait_time = Integer.parseInt(waitTime);
		
		WebDriverWait wait = new WebDriverWait(driver, wait_time);

		int maxTry = 5;
		for (int numTry = 1; numTry <= maxTry; numTry++) {
			String errorMessage = this.getSystemErrorIfAny();
			if (errorMessage != null) {
				throw new Exception("Error: Expecting new page " + pageName +", but got system error, error message = '" + errorMessage + "'");
			}
			try {
				//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("companyLogoImage")));
				WebElement logo = driver.findElement(By.id("companyLogoImage"));
				break;
			} catch (Exception e) {
				if (numTry == maxTry) {
					e.printStackTrace();
					throw new Exception("Page load error");
				}
				logger.info(numTry + " out of " + maxTry + ", page not loded, will try again...");
				TestUtils.pauseShort(5);
			}
			
		}
		
	}
	public void quit() {
		if (driver != null) {
			driver.quit();
		}
	}

	public void enterInput(String value, WebElement field) {
		if (value.trim().isEmpty()) {
			logger.info("debug, empey value");
		}
		WebElement currentFocus = driver.switchTo().activeElement();
		boolean isFocus = field.equals(driver.switchTo().activeElement());
		if (!isFocus) {
			new Actions(driver).moveToElement(field).perform();
		}
		//field.click();
		field.sendKeys(Keys.CONTROL, "a");
		// field.sendKeys(Keys.DELETE);
		if (value.equals("")) {
			field.sendKeys(Keys.DELETE);
		} else {
			field.sendKeys(value);
		}
		field.sendKeys(Keys.TAB);

		return;
	}

	protected String getValue(WebElement field) throws Exception{
		String value = null;
		int maxTry = 5;
		for (int i = 1; i <= maxTry; i++ ) {
			try {
				 value = field.getText();
				 break;
			} catch (Exception e) {
				logger.info("failed " + i + " out of " + maxTry + " times");
				e.printStackTrace();
				if (i < maxTry) {
					logger.info("will retry...");
					TestUtils.pauseShort(3);
					continue;
				}
				else {
					throw e;
				}
			}
			
		}
			
		return value;
	}

	protected String getAttributeValue(WebElement field) throws Exception{
		//String value = field.getAttribute("value");
		String value = null;
		int maxTry = 5;
		for (int i = 1; i <= maxTry; i++ ) {
			try {
				 value = field.getAttribute("value");
				 break;
			} catch (Exception e) {
				logger.info("failed " + i + " out of " + maxTry + " times");
				if (i < maxTry) {
					logger.info("will retry...");
					TestUtils.pauseShort(3);
					continue;
				}
				e.printStackTrace();
				try {
					throw e;
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		}
			
		return value;
	}

	public AbstractBasePage scrollDown() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,250)", "");

		return this;
	}

	public AbstractBasePage scrollDown(int pixel) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0," + pixel + ")", "");

		return this;
	}

	public AbstractBasePage selectOptionByText3(WebElement selectElem, String optionText) {
		logger.info("option = " + optionText);

		Select select = new Select(selectElem);

		select.deselectAll();

		try {
			select.selectByVisibleText(optionText);
			return this;
		} catch (Exception e) {

		}

		// debug, iterate through the options and show the content
		WebElement target = null;
		List<WebElement> optionList = select.getOptions();

		int i = 0;
		for (WebElement option : optionList) {
			i++;
			String actualText = option.getText();
			// logger.info("option [" + i + "] text = " + text);
			if (actualText.contains("DPHT")) {
				logger.info("option [" + i + "] text = " + actualText);
				if (actualText.equals(optionText)) {
					target = option;
					break;
					// option.click();
					// return this;
				} else {
					logger.info("text = '" + actualText + "', length = " + actualText.length());
					logger.info("code = '" + optionText + "', length = " + optionText.length());

					if (actualText.length() == optionText.length()) {
						for (int j = 0; j < actualText.length(); j++) {
							String c1 = actualText.substring(j, j + 1);
							String c2 = optionText.substring(j, j + 1);
							if (c1.equals(c2)) {
								logger.info(c1 + " equals " + c2);
							} else {
								logger.info(c1 + " not equals " + c2);
								break;
							}
						}
					}

				}
			}
		}

		// if target is null, will tr=hrow exception here
		target.click();

		return this;
	}

	public AbstractBasePage selectOptionByText(WebElement selectElem, String optionText) {
		logger.info("option = " + optionText);

		Select select = new Select(selectElem);

		select.deselectAll();
		select.selectByVisibleText(optionText);

		return this;
	}

	public AbstractBasePage selectOptionByTextAndPause(WebElement selectElem, String optionText) {
		logger.info("option = " + optionText);
		Select select = new Select(selectElem);
		select.selectByVisibleText(optionText);

		logger.info("pause here to let the screen refresh");
		TestUtils.pauseRefresh();
		logger.info("after pause");

		return this;
	}

	// this is for debug only
	public List<String> showSelectOptions(WebElement selectElem) {
		List<WebElement> optionList = selectElem.findElements(By.cssSelector(" option"));
		logger.info("enterState2: optionList size = " + optionList.size());

		List<String> optionTextList = new ArrayList<String>();
		
		String optionText;
		int optionNumber = 0;
		for (WebElement option : optionList) {
			optionNumber++;
			optionText = option.getText().trim();
			logger.info("option[" + optionNumber + "] = '" + optionText + "'");
			optionTextList.add(optionText);
		}

		return optionTextList;
	}
	
	public List<String> displaySelectOptions(WebElement selectElem) {
		List<String> optionTextList =  showSelectOptions(selectElem);
		System.out.println("");
		for (String optionText : optionTextList) {
			System.out.println(optionText);
		}
		
		return optionTextList;
	}
	
	
	// selectByVisibleText has to be exact match. selectByValue can do partial match.
	public void selectOptionByValueWithoutDeselect(WebElement selectElem, String value) {
	Select paymentTypeDropDown = new Select(selectElem);
	paymentTypeDropDown.selectByValue(value);
	}
	
	public void selectOptionByIndexWithoutDeselect(WebElement selectElem, int indexNumber) {
		Select select = new Select(selectElem);
		select.selectByIndex(indexNumber);
	}

	public AbstractBasePage selectOptionByTextWithoutDeselect(WebElement selectElem, String optionText) {
		return selectOptionByTextWithoutDeselect(selectElem, optionText, false);
	}
	public AbstractBasePage selectOptionByTextWithoutDeselect2(WebElement selectElem, String optionText, boolean debug_flag) {

		//showSelectOptions(selectElem);
		logger.info("option = " + optionText);
		Select select = new Select(selectElem);
		if (debug_flag) {
			showSelectOptions(selectElem);
		}
		select.selectByVisibleText(optionText);

		return this;
	}

	public AbstractBasePage selectOptionByTextWithoutDeselect(WebElement selectElem, String optionText, boolean debug_flag) {
		if (optionText.equalsIgnoreCase("random") || optionText.equalsIgnoreCase("index=random")) {
			selectRandomOption(selectElem);
		}
		else if (optionText.startsWith("index=")) {
			String indexString = optionText.split("=")[1].trim();
			int indexNumber = Integer.parseInt(indexString);
			selectOptionByIndexWithoutDeselect(selectElem, indexNumber);
		}
		else {
			//showSelectOptions(selectElem);
//			logger.info("option = " + optionText);
			Select select = new Select(selectElem);
			if (debug_flag) {
				//showSelectOptions(selectElem);
				List<WebElement> optionList = selectElem.findElements(By.cssSelector(" option"));
				logger.info("enterState2: optionList size = " + optionList.size());

				for (WebElement option : optionList) {
					String currentText = option.getText();
					logger.info("option = " + currentText);
					if (currentText.equals(optionText)) {
						option.click();
						break;
					}
				}

			}
			else {
				try {
					select.selectByVisibleText(optionText);
				}
				catch (Exception e) {
					logger.error("Error: failed selecting option " + optionText);
					e.printStackTrace();
				}
			}
		}


		return this;
	}

	private void selectRandomOption(WebElement selectElem) {
		List<WebElement> optionList = selectElem.findElements(By.cssSelector(" option"));
		int numberOptions = optionList.size();
		long seed = TestUtils.getUniqueNumber();
		Random random = new Random(seed);
		
		int randomNumber = random.nextInt(numberOptions);
		selectOptionByIndexWithoutDeselect(selectElem, randomNumber);
	}

	// this method should not be used
	private AbstractBasePage selectOptionByText2(WebElement select, String optionText) throws Exception {
		logger.info("option = " + optionText);

		List<WebElement> optionList = select.findElements(By.xpath(".//option"));
		logger.info("enterState2: linkStateOptions size = " + optionList.size());

		selectOptionByText(optionList, optionText);
		return this;
	}

	public AbstractBasePage selectOptionByPrefix(WebElement select, String optionTextPrefix) throws Exception {
		logger.info("option = " + optionTextPrefix);

		List<WebElement> optionList = select.findElements(By.xpath(".//option"));
		logger.info("enterState2: linkStateOptions size = " + optionList.size());

		selectOptionByPrefix(optionList, optionTextPrefix);
		return this;
	}

	public AbstractBasePage selectOptionByText(List<WebElement> optionList, String optionText) throws Exception {
		logger.info("option = " + optionText);

		logger.info("enterState2: linkStateOptions size = " + optionList.size());

		WebElement target = null;
		for (WebElement option : optionList) {
			String text = option.getText();
			// logger.info("text = '" + text + "'");
			System.out.println("    | " + text + "  | ");
			if (text.equals(optionText)) {
				logger.info("selectOptionByText: option found matching value");
				target = option;
				// option.click();
				break;
			}
		}

		if (target == null) {
			throw new Exception("Error: cannot find option with given option " + optionText);
		}
		target.click();

		return this;
	}

	public AbstractBasePage selectOptionByPrefix(List<WebElement> optionList, String optionTextPrefix) throws Exception {
		logger.info("option = " + optionTextPrefix);

		logger.info("enterState2: linkStateOptions size = " + optionList.size());

		WebElement target = null;
		for (WebElement option : optionList) {
			String text = option.getText();
			// logger.info("text = '" + text + "'");
			System.out.println("    | " + text + "  | ");
			if (text.startsWith(optionTextPrefix)) {
				logger.info("selectOptionByText: option found matching value");
				target = option;
				// option.click();
				 break;
			}
		}

		if (target == null) {
			throw new Exception("Error: cannot find option with given option prefix " + optionTextPrefix);
		}
		target.click();

		return this;
	}

	public WebElement findElementFromListByAttribute(List<WebElement> elemList, String attribute,
			String expectedValue) {
		WebElement target = null;
		if (elemList != null) {
			// logger.info("findElementFromListByAttribute list is null");
			for (WebElement elem : elemList) {
				String actualValue;
				if (attribute.equals("text")) {
					actualValue = elem.getText();
				} else {
					actualValue = elem.getAttribute(attribute);
				}
				// logger.info("findElementFromListByAttribute: actualValue = "
				// + actualValue);
				if (actualValue.equals(expectedValue)) {
					target = elem;
					break;
				}
			}
		}

		// logger.info("findElementFromListByAttribute: could not find the
		// expectedValue " + expectedValue);
		return target;
	}

	public boolean isElementDisplayed(String identifier) {
		WebElement element = driver.findElement(By.xpath(".//*[@id='" + identifier + "']"));
		logger.info("Element is Displayed");

		return element.isDisplayed();
	}
	
	//@FindBy(id = "pageName")
	//private WebElement pageName;

	public String getPageNameText(WebElement pageName) throws Exception {
		String pageTitle = null;
		String errorMessage = null;
		try {
			pageTitle = pageName.getText().trim();
		} catch (Exception e) {
				throw new Exception("Error: Got error message = '" + errorMessage + "'");
		}
		return pageTitle;
	}

	public boolean switchToWindowWithMatchingtitle(String expecteditle) {
		boolean found = false;

		WebDriver driver = getDriver();
		String winHandleBefore = driver.getWindowHandle();

		// Switch to new window opened

		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
			String title = driver.getTitle();
			if (title.equals(expecteditle)) {
				found = true;
				break;
			}
		}

		if (!found) {
			driver.switchTo().window(winHandleBefore);
		}

		return found;
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public String getSelectedOption(WebElement selectelement) {
		Select select = new Select(selectelement);

		String result = select.getFirstSelectedOption().getText();

		return result;

	}

	public List<String> getSelectedOptionsList(WebElement selectelement) {
		Select select = new Select(selectelement);

		List<WebElement> opts = select.getAllSelectedOptions();

		List<String> results = new ArrayList<String>();

		for (WebElement opt : opts) {
			String text = opt.getText();
			results.add(text);
		}
		return results;
	}

	public List<String> getOptionsList(WebElement selectelement) {
		Select select = new Select(selectelement);

		List<WebElement> opts = select.getOptions();

		List<String> results = new ArrayList<String>();

		for (WebElement opt : opts) {
			String text = opt.getText();
			results.add(text);
		}
		return results;
	}
	
	public List<String> getOptionsListGetAttributeText(WebElement selectelement) {
		Select select = new Select(selectelement);

		List<WebElement> opts = select.getOptions();

		List<String> results = new ArrayList<String>();

		for (WebElement opt : opts) {
			String text = opt.getAttribute("text");
			results.add(text);
		}
		return results;
	}

	public void saveOptionListToFile(WebElement selectelement, String fileName) throws IOException {
		List<String> statusList = getOptionsList(selectelement);
		TestUtils.writeToFile(fileName, "");

		for (String status : statusList) {
			TestUtils.appendToFile(fileName, status);
		}
		return;
	}

	public void clickOkFromAlertPopUp() {
		WebDriver driver = this.getDriver();
		driver.switchTo().alert().accept();

	}
		
	public String getSystemErrorIfAny() {
		// /html/body/h1/text()
		String errorMessage = null;
		List<WebElement> elements = driver.findElements(By.xpath("/html/body/*"));
		int len = elements.size();
		for (WebElement element: elements) {
			boolean isDisplay = element.isDisplayed();
			if (!isDisplay ) {
				continue;
			}
			String tagName = element.getTagName().toUpperCase();
			String text = element.getText();
			if (tagName.equals("H1") && text.contains("HTTP Status 500")) {
				errorMessage = text;
				break;
			}
			if (tagName.equals("H1") && text.contains("502 Bad Gateway")) {
				errorMessage = text;
				break;
			}
			if (tagName.equals("H1") && text.contains("503 Service Unavailable")) {
				errorMessage = text;
				break;
			}
			if (tagName.equals("H1") && text.contains("504 Gateway Time-out")) {
				errorMessage = text;
				break;
			}
			if (tagName.equals("H3") && text.contains("An Internal Error Has Occurred")) {
				errorMessage = text;
				WebElement viewDetails = driver.findElement(By.id("detailsButton"));
				boolean isViewDetailsDisplayed = viewDetails.isDisplayed();
				if(isViewDetailsDisplayed){
					viewDetails.click();
				}
				break;
			}
		}
		return errorMessage;
	}
	public String getErrorMessageIfAny() throws Exception {
		String errorMessage = null;
		WebDriver driver = this.getDriver();
		// don't put class='columnError' in cssSelector. it will be very slow if no error message
		List<WebElement> elements = driver.findElements(By.cssSelector(" div"));
		int len = elements.size();		// len should never be 0. the smaller, the better.
		int i = 0;
		for (WebElement element: elements) {
			boolean isDisplay = element.isDisplayed();
			if (!isDisplay) {
				continue;
			}
			i++;
			String text = element.getText();
			//logger.info("element " + i + ": text = " + text);
			String classValue = element.getAttribute("class");
			if (isDisplay && classValue.equals("columnError") ) {
				errorMessage = text;
				break;
			}
		}
		return errorMessage;
	}
	
	public void windowsUploadFileWithRelativePath(String fileName) throws Exception {
		logger.info("fileName = " + fileName);
		
		String userDir = System.getProperty("user.dir");
		logger.info("userDir = " + userDir);

		String filePath = userDir + "\\" + fileName;
		logger.info("filePath = " + filePath);
		
		filePath = filePath.replaceAll("\\/", "\\\\");
		
		logger.info("new filePath = " + filePath);
		windowsUploadFileWithAbsolutePath(filePath);
		
	}
	public  void windowsUploadFileWithAbsolutePath(String filePath) throws Exception {
		// int pauseTime = 500;
		logger.info("filePath = " + filePath);
	
		String os = System.getProperty("os.name").toLowerCase();
		logger.info("Current Running Test OS Name is " + os);
		
		if (!os.contains("win")) {
			throw new Exception("Error: this test can only be executed on Windows operating system");
		}
			
		Robot robot = new Robot();
		StringSelection path = new StringSelection(filePath);
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Clipboard clipboard = toolkit.getSystemClipboard();
		clipboard.setContents(path, null);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		Thread.sleep(1000);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		return;
	}
	
	public void takeScreenShot(String value) throws Exception {
		String currentSprintPBIFolder= ConfigUtils.getConfigProperty(configFile, "currentSprintPBIFolder");
		String currentSprintPBI= ConfigUtils.getConfigProperty(configFile, "currentSprintPBI");
		if(!currentSprintPBI.equalsIgnoreCase("false")){
			String currentTime =  getCurrentTimeScreenshotFormat();
			String fileName = "test-output/screenShots/PBIVerification/" + currentSprintPBIFolder.replaceAll(" ","_") + "/" +currentTime +  "_" + value +".png";
			takeScreenshotAndSave(fileName);
		}

	}

	public void takeScreenShot() throws Exception {
		String currentSprintPBIFolder= ConfigUtils.getConfigProperty(configFile, "currentSprintPBIFolder");
		String currentSprintPBI= ConfigUtils.getConfigProperty(configFile, "currentSprintPBI");
		if(!currentSprintPBI.equalsIgnoreCase("false")) {
			String currentTime =  getCurrentTimeScreenshotFormat();
			String fileName = "test-output/screenShots/PBIVerification/" + currentSprintPBIFolder.replaceAll(" ","_") + "/" + currentTime + ".png";
			takeScreenshotAndSave(fileName);
		}
	}

	public void takeScreenshotAndSave(String fileName) {
		try 
		{
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File(fileName));
			logger.info("screenshot taken: "+ fileName);
		} catch (IOException e) 
		{
			logger.info(e.getMessage());
		}
	}

	public String getCurrentTimeScreenshotFormat() throws Exception {
		String currentTime = DateUtils.getCurrentTimestamp();
		String myMethodId = DateUtils.convertTimeStamptoId(currentTime);
		return myMethodId;
	}
	
	public boolean validateLandingPageNameAndThrowError(String expectedPageName, WebElement elem) throws Exception {		
		String actualpageName = null;
		int maxTry = 3;
		for (int numTry = 1; numTry <= maxTry; numTry++) {
			try {
				actualpageName = this.getPageNameText(elem).trim();
				if (actualpageName.equals(expectedPageName))  {
					break;
				}
				logger.info(numTry + " out of " + maxTry + ", page name is '" + actualpageName + "', expecting '" + expectedPageName + "'");
				if ( numTry == maxTry) {
					throw new Exception("Error: invalid page name '" + actualpageName + "', should be '" + expectedPageName + "'");
				}
				TestUtils.pauseShort(5);
			} catch (Exception e) {
				String errorMsg = e.getMessage();
				if (errorMsg.contains("error message")) {
					throw e;
				}
				logger.info(numTry + " out of  2, page name not found");
				if ( numTry > 1) {		
					throw new Exception("Error: cannot find page name, expectedPageName = " + expectedPageName);
				}
			}
		}
		return true;
	}

}

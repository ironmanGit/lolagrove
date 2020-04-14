/**
 * 
 */
package controllers;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.imageio.ImageIO;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.JavascriptExecutor;

/**
 * @Author Vivekanandan Sampath
 * @Date Mar 09, 2020
 */
public class BaseMethod extends WebDriverFactory {

	/* To get the Website Name */
	public String getUrlTitle() throws Exception {
		URL aURL = new URL(WebsiteURL);
		String WebName = aURL.getHost();
		String WebSiteName = WebName.toUpperCase();
		return WebSiteName;
	}

	/* To Press ENTER Key using Robot */
	public void hitEnter() throws Exception {
		re = new Robot();
		re.keyPress(KeyEvent.VK_ENTER);
		re.keyRelease(KeyEvent.VK_ENTER);
	}

	/* To Press BACKSPACE Key using Robot */
	public void hitBackspace() throws Exception {
		re = new Robot();
		re.keyPress(KeyEvent.VK_BACK_SPACE);
		re.keyRelease(KeyEvent.VK_BACK_SPACE);
	}

	/* To Press DELETE Key using Robot */
	public void hitDelete() throws Exception {
		re = new Robot();
		re.keyPress(KeyEvent.VK_DELETE);
		re.keyRelease(KeyEvent.VK_DELETE);
	}

	/* To Select all the Text/Web Elements using ROBOT */
	public void selectAll() throws Exception {
		re = new Robot();
		re.keyPress(KeyEvent.VK_CONTROL);
		re.keyPress(KeyEvent.VK_A);
		re.keyRelease(KeyEvent.VK_CONTROL);
		re.keyRelease(KeyEvent.VK_A);
	}

	/* To Copy all the Selected Text/Web Elements using ROBOT */
	public void copyAll() throws Exception {
		re = new Robot();
		re.keyPress(KeyEvent.VK_CONTROL);
		re.keyPress(KeyEvent.VK_C);
		re.keyRelease(KeyEvent.VK_CONTROL);
		re.keyRelease(KeyEvent.VK_C);
	}

	/* To Paste all the Selected Text/Web Elements using ROBOT */
	public void pasteAll() throws Exception {
		re = new Robot();
		re.keyPress(KeyEvent.VK_CONTROL);
		re.keyPress(KeyEvent.VK_V);
		re.keyRelease(KeyEvent.VK_CONTROL);
		re.keyRelease(KeyEvent.VK_V);
	}

	/* To Capture Screenshot(Replaces if already exists) */
	/*
	 * Also, Make sure that the automation in running in the foreground to capture
	 * the Image of the Browser. Else, It'll capture the open Window
	 */
	public void robotScreenCapture(String robotImageName) throws Exception {
		re = new Robot();
		Rectangle area = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
		BufferedImage bufferedImage = re.createScreenCapture(area);
		// Save as PNG
		File file = new File(robotImageName);
		if (file.exists()) {
			file.delete();
		}
		ImageIO.write(bufferedImage, "png", file);
	}

	/* To ZoomOut */
	public void robotZoomOut() throws Exception {
		re = new Robot();
		re.keyPress(KeyEvent.VK_CONTROL);
		re.keyPress(KeyEvent.VK_SUBTRACT);
		re.keyRelease(KeyEvent.VK_SUBTRACT);
		re.keyRelease(KeyEvent.VK_CONTROL);
	}

	/* To ZoomIn */
	public void robotZoomIn() throws Exception {
		re = new Robot();
		re.keyPress(KeyEvent.VK_CONTROL);
		re.keyPress(KeyEvent.VK_ADD);
		re.keyRelease(KeyEvent.VK_ADD);
		re.keyRelease(KeyEvent.VK_CONTROL);
	}

	/* To ScrollUp using ROBOT */
	public void robotScrollUp() throws Exception {
		re = new Robot();
		re.keyPress(KeyEvent.VK_PAGE_UP);
		re.keyRelease(KeyEvent.VK_PAGE_UP);
	}

	/* To ScrollDown using ROBOT */
	public void robotScrollDown() throws Exception {
		re = new Robot();
		re.keyPress(KeyEvent.VK_PAGE_DOWN);
		re.keyRelease(KeyEvent.VK_PAGE_DOWN);
	}

	/* To ScrollUp using JavaScript Executor */
	public void scrollUp() throws Exception {
		((JavascriptExecutor) getWebDriver()).executeScript("scroll(0, -100);");
	}

	/* To ScrollDown using JavaScript Executor */
	public void scrollDown() throws Exception {
		((JavascriptExecutor) getWebDriver()).executeScript("scroll(0, 100);");
	}

	/* To Move cursor to the Desired Location */
	public void moveCursor(int X_Position, int Y_Position) throws Exception {
		re.mouseMove(X_Position, Y_Position);
	}

	/* To Accept the Alert Dialog Message */
	public void alertAccept() throws Exception {
		al = getWebDriver().switchTo().alert();
		al.accept();
	}

	/* To Dismiss the Alert Dialog Message */
	public void alertDismiss() throws Exception {
		al = getWebDriver().switchTo().alert();
		al.dismiss();
	}

	/* To Get the Alert Messages */
	public String getAlertText() throws Exception {
		al = getWebDriver().switchTo().alert();
		String text = al.getText();
		Thread.sleep(2000);
		alertAccept();
		return text;
	}

	/* To Upload a File using JAVA AWT ROBOT */
	public void fileUpload(String FileToUpload) throws Exception {
		Thread.sleep(5000);
		StringSelection filetocopy = new StringSelection(FileToUpload);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filetocopy, null);
		Thread.sleep(1000);
		re = new Robot();
		re.keyPress(KeyEvent.VK_CONTROL);
		re.keyPress(KeyEvent.VK_V);
		re.keyRelease(KeyEvent.VK_V);
		re.keyRelease(KeyEvent.VK_CONTROL);
		re.keyPress(KeyEvent.VK_ENTER);
		re.keyRelease(KeyEvent.VK_ENTER);
	}

	/* To Perform a WebAction of Mouse Over */
	public void mousehover(WebElement element) {
		ac = new Actions(getWebDriver());
		ac.moveToElement(element).build().perform();
	}

	/* To Perform Select Option by Visible Text */
	public void selectByVisibleText(WebElement element, String value) {
		se = new Select(element);
		se.selectByVisibleText(value);
	}

	/* To Perform Select Option by Index */
	public void selectByIndex(WebElement element, int value) {
		se = new Select(element);
		se.selectByIndex(value);
	}

	/* To Perform Select Option by Value */
	public void selectByValue(WebElement element, String value) {
		se = new Select(element);
		se.selectByValue(value);
	}

	/* To click a certain Web Element */
	public void click(WebElement element) {
		element.click();
	}

	/* To click a certain Web Element using DOM/ JavaScript Executor */
	public void JSclick(WebElement element) {
		((JavascriptExecutor) getWebDriver()).executeScript("return arguments[0].click();", element);
	}

	/* To Type at the specified location */
	public void sendKeys(WebElement element, String value) {
		element.sendKeys(value);
	}

	/* To get value from the specified location */
	public String getText(WebElement element) {
		return element.getText();
	}

	/* To Clear the content in the input location */
	public void clear(WebElement element) {
		element.clear();
	}

	/* To Drag and Drop from Source Locator to Destination Locator */
	public void dragandDrop(WebElement Source, WebElement Destination) {
		ac = new Actions(getWebDriver());
		ac.dragAndDrop(Source, Destination);
	}

	/*
	 * To Drag from the given WebElement Location and Drop at the given WebElement
	 * location
	 */
	public void dragandDropTo(WebElement Source, int XOffset, int YOffset) throws Exception {
		ac = new Actions(getWebDriver());
		ac.dragAndDropBy(Source, XOffset, YOffset);
	}

	/* To Open a Page in New Tab */
	public void rightClick(WebElement element) {
		ac = new Actions(getWebDriver());
		ac.contextClick(element);
		ac.build().perform();
	}

	/* To Close Current Tab */
	public void closeCurrentTab() {
		getWebDriver().close();
	}

	/* To Perform Click and Hold Action */
	public void clickAndHold(WebElement element) {
		ac = new Actions(getWebDriver());
		ac.clickAndHold(element);
		ac.build().perform();
	}

	/* To Perform Click and Hold Action */
	public void doubleClick(WebElement element) {
		ac = new Actions(getWebDriver());
		ac.doubleClick(element);
		ac.build().perform();
	}

	/* To Switch To Frame By Index */
	public void switchToFrameByIndex(int index) throws Exception {
		getWebDriver().switchTo().frame(index);
	}

	/* To Switch To Frame By Frame Name */
	public void switchToFrameByFrameName(String frameName) throws Exception {
		getWebDriver().switchTo().frame(frameName);
	}

	/* To Switch To Frame By Web Element */
	public void switchToFrameByWebElement(WebElement element) throws Exception {
		getWebDriver().switchTo().frame(element);
	}

	/* To Switch out of a Frame */
	public void switchOutOfFrame() throws Exception {
		getWebDriver().switchTo().defaultContent();
	}

	/* To Get Tooltip Text */
	public String getTooltipText(WebElement element) {
		String tooltipText = element.getAttribute("title").trim();
		return tooltipText;
	}

	/* To Close all Tabs/Windows except the First Tab */
	public void closeAllTabsExceptFirst() {
		ArrayList<String> tabs = new ArrayList<String>(getWebDriver().getWindowHandles());
		for (int i = 1; i < tabs.size(); i++) {
			getWebDriver().switchTo().window(tabs.get(i));
			getWebDriver().close();
		}
		getWebDriver().switchTo().window(tabs.get(0));
	}

	/* To Print all the Windows */
	public void printAllTheWindows() {
		ArrayList<String> al = new ArrayList<String>(getWebDriver().getWindowHandles());
		for (String window : al) {
			System.out.println(window);
		}
	}

	/* Return web element using dynamic xpath */
	public WebElement getXpath(String xpath, String dynamicValue) throws Exception {
		String actualXpath = String.format(xpath, dynamicValue);
		WebElement element = getWebDriver().findElement(By.xpath(actualXpath));
		return element;
	}

	/* Click on google search result1 */
	public void updateSearchValueInGoogleAndSearch(String value) throws Exception {
		WebElement element = getWebDriver().findElement(By.cssSelector("input[title='Search']"));
		element.sendKeys(value);
		WebElement searchButton = getWebDriver().findElement(By.cssSelector("button[type='submit']"));
		click(searchButton);
	}
	
	/* Click on google search result1 */
	public void clickSearchResult1() throws Exception {
		WebElement element = getWebDriver().findElement(By.cssSelector("a>h3"));
		click(element);
	}

	/* return current url */
	public String getCurrentUrl() throws Exception {
		String url = getWebDriver().getCurrentUrl();
		return url;
	}

	/* get innner text using js */
	public String getTextUsingScript(String fieldName) throws Exception {
		JavascriptExecutor js = (JavascriptExecutor) getWebDriver();  
		String value = js.executeScript("return document.getElementsByName('"+fieldName+"')[0]['value']").toString();
		return value;
	}
	
	/* get company size as per lolagrove */
	public String roundOffCompanySize(String value) throws Exception {
		int size = Integer.parseInt(value);
		String result = null;
		if (size < 50) {
			result = "1-49";
		} else if ((size >= 50) && (size <= 250)) {
			result = "50-250";
		} else if ((size >= 251) && (size <= 500)) {
			result = "251-500";
		} else if ((size >= 501) && (size <= 1000)) {
			result = "501-1000";
		} else if ((size >= 1001) && (size <= 5000)) {
			result = "1001-5000";
		} else if ((size >= 5001) && (size <= 10000)) {
			result = "5001-10000";
		} else {
			result = "10000+";
		}
		return result;
	}

	/* get company turnover as per lolagrove */
	public String roundOffTurnover(String value) throws Exception {
		int turnOver = Integer.parseInt(value);
		String result = null;
		if (turnOver < 5) {
			result = "$100k - $4.9m[£80k - £3.9m]";
		} else if ((turnOver >= 5) && (turnOver < 25)) {
			result = "$5m - $25m[£4m - £20m]";
		} else if ((turnOver >= 25) && (turnOver < 800)) {
			result = "$25.1m - $1b[£20m - £800m]";
		} else if ((turnOver >= 800) && (turnOver < 4000)) {
			result = "$1b - $5b[£800m - £4b]";
		} else if ((turnOver >= 4000) && (turnOver < 8000)) {
			result = "$5b - $10b[£4b - £8b]";
		} else if ((turnOver > 8000)) {
			result = "$10b+[£8b+]";
		} else {
			result = "$25.1m - $1b[£20m - £800m]";
		}
		return result;
	}
	
	public void switchToNewTab() {
		boolean closeFlag = false;
		switchToOtherHandle(getWebDriver(), closeFlag);
	}

	public void closeTab() {
		boolean closeFlag = true;
		switchToOtherHandle(getWebDriver(), closeFlag);
	}

	public org.openqa.selenium.WebDriver switchToOtherHandle(org.openqa.selenium.WebDriver webDriver,
			boolean closeFlag) {
		Set<String> listOfHandles = webDriver.getWindowHandles();
		List<String> ls = new ArrayList<String>();
		ls.addAll(listOfHandles);
		Iterator WindowHandleIterator = listOfHandles.iterator();
		String existingHandle = webDriver.getWindowHandle();
		if (closeFlag) {
			webDriver.close();
		}
		while (WindowHandleIterator.hasNext()) {
			String newPageHandle = WindowHandleIterator.next().toString();
			if (!newPageHandle.contains(existingHandle)) {
				webDriver.switchTo().window(newPageHandle);
				break;
			}
		}
		return webDriver;
	}
	
	public void switchToWindowWithMatchingTitle(String ExpectedTitle) {
		switchToOtherHandles(getWebDriver(), false, ExpectedTitle);
	}
	
	public void closeToWindowWithMatchingTitle(String ExpectedTitle) {
		switchToOtherHandles(getWebDriver(), true, ExpectedTitle);
	}
	
	public boolean switchToOtherHandles(org.openqa.selenium.WebDriver webDriver, boolean closeFlag,
			String ExpectedTitle) {
		boolean found = false;
		String winHandleBefore = webDriver.getWindowHandle();
		Set<String> listOfHandles = webDriver.getWindowHandles();
		for (String winHandle : listOfHandles) {
			webDriver.switchTo().window(winHandle);
			String title = webDriver.getTitle();
			title = title.trim();
			if (title.equals(ExpectedTitle)) {
				found = true;
				break;
			}
		}

		if (!found) {
			webDriver.switchTo().window(winHandleBefore);
		}
		return found;
	}
	
}

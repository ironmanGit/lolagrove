package utils;

import org.openqa.selenium.WebDriver;

public class SwitchTabUtils {

	public static void switchToFirstTabAndCloseCurrentTab(WebDriver driver) throws Exception {
//		WebDriver driver = homePage.getDriver();
		
		driver.close();
		switchToTab(driver, 0);
		
		
		return;
	}
	
	public static void switchToTab(WebDriver driver, int tabNumber) throws Exception {
//		WebDriver driver = homePage.getDriver();

		int num = 0;
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
			if (num==tabNumber) {
				break;		// force switch to the first windowHandle
			}
			num++;
		}

		return;
	}
	
}

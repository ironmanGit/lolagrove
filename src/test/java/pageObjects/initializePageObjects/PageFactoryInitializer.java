/**
 * 
 */
package pageObjects.initializePageObjects;

import org.openqa.selenium.support.PageFactory;

import controllers.BaseMethod;
import pageObjects.modules.GMailPageObjects;
import pageObjects.modules.GoogleHomePageObjects;

/**
 * @Author Vivekanandan Sampath
 * @Date Mar 09, 2020
 */

public class PageFactoryInitializer extends BaseMethod 
{
	public GoogleHomePageObjects googleHomePage() 
	{
		return PageFactory.initElements(getWebDriver(), GoogleHomePageObjects.class);
	}

	public GMailPageObjects gmailPage() 
	{
		return PageFactory.initElements(getWebDriver(), GMailPageObjects.class);
	}
}

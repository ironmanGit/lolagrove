/**
 * 
 */
package pageObjects.initializePageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import controllers.BaseMethod;
import pageObjects.modules.GMailPageObjects;
import pageObjects.modules.GoogleHomePageObjects;
import pageObjects.modules.LandingPageObjects;
import pageObjects.modules.LeadPageObjects;
import pageObjects.modules.LoginPageObjects;
import pageObjects.modules.OpenNotesPageObjects;

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
	
	public LoginPageObjects loginPage() 
	{
		return PageFactory.initElements(getWebDriver(), LoginPageObjects.class);
	}
	
	public LandingPageObjects landingPage() 
	{
		return PageFactory.initElements(getWebDriver(), LandingPageObjects.class);
	}
	
	public LeadPageObjects leadPage() 
	{
		return PageFactory.initElements(getWebDriver(), LeadPageObjects.class);
	}
	
	public OpenNotesPageObjects openNotesPage() 
	{
		return PageFactory.initElements(getWebDriver(), OpenNotesPageObjects.class);
	}
}

/**
 * 
 */
package pageObjects.modules;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import pageObjects.initializePageObjects.PageFactoryInitializer;
import utils.RandomGenerator;

/**
 * @Author Vivekanandan Sampath
 * @Date Mar 09, 2020
 */
public class GoogleHomePageObjects extends PageFactoryInitializer
{
	@FindBy(xpath="//a[text()='Gmail']")
	private WebElement GmailLink;

	@FindBy(id="lst-ib")
	private WebElement SearchBox;

	
	public GoogleHomePageObjects clickonGmailLink() throws Exception
	{		
		click(GmailLink);
		return this;		
	}


	public GoogleHomePageObjects enterTextToSearchBox() 
	{
		SearchBox.sendKeys(RandomGenerator.GenerateRandomEMAILIDs("google.com"));
		return this;	
	}

	
	public GoogleHomePageObjects verifyPageTitle() throws Exception 
	{
		Assert.assertEquals(getWebDriver().getTitle(), "Boogle");
		return this;
	}

}

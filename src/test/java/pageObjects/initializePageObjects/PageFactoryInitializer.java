/**
 * 
 */
package pageObjects.initializePageObjects;

import org.openqa.selenium.support.PageFactory;
import controllers.BaseMethod;
import pageObjects.modules.GMailPageObjects;
import pageObjects.modules.EndolePageObjects;
import pageObjects.modules.GooglePageObjects;
import pageObjects.modules.LandingPageObjects;
import pageObjects.modules.LeadPageObjects;
import pageObjects.modules.LinkedInPageObjects;
import pageObjects.modules.LoginPageObjects;
import pageObjects.modules.OpenNotesPageObjects;
import pageObjects.modules.ZoomInfoPageObjects;
import tests.campaign.leads.CompanySize;
import tests.campaign.leads.CompanyTurnover;
import tests.campaign.leads.Country;
import tests.campaign.leads.Email;
import tests.campaign.leads.FirstnameLastnameJobTitle;
import tests.campaign.leads.Industry;
import tests.campaign.leads.JobFunction;
import tests.campaign.leads.JobLevel;
import tests.campaign.leads.JobTitle;
import tests.campaign.leads.PlacementReadOnly;
import tests.campaign.process.CampaignTestDataProcess;

/**
 * @Author Vivekanandan Sampath
 * @Date Mar 09, 2020
 */

public class PageFactoryInitializer extends BaseMethod 
{
	public GooglePageObjects googlePage() 
	{
		return PageFactory.initElements(getWebDriver(), GooglePageObjects.class);
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
	
	public CampaignTestDataProcess campaignTestDataProcess() 
	{
		return PageFactory.initElements(getWebDriver(), CampaignTestDataProcess.class);
	}
	
	public LinkedInPageObjects linkedInPage() 
	{
		return PageFactory.initElements(getLinkedInWebDriver(), LinkedInPageObjects.class);
	}
	
	public ZoomInfoPageObjects zoomInfoPage() 
	{
		return PageFactory.initElements(getZoomInfoWebDriver(), ZoomInfoPageObjects.class);
	}
	
	public EndolePageObjects endolePage() 
	{
		return PageFactory.initElements(getEndoleWebDriver(), EndolePageObjects.class);
	}
	
	public PlacementReadOnly placementReadOnly() 
	{
		return PageFactory.initElements(getWebDriver(), PlacementReadOnly.class);
	}
	
	public CompanySize companySize() 
	{
		return PageFactory.initElements(getWebDriver(), CompanySize.class);
	}
	
	public CompanyTurnover companyTurnover() 
	{
		return PageFactory.initElements(getWebDriver(), CompanyTurnover.class);
	}
	
	public Country country() 
	{
		return PageFactory.initElements(getWebDriver(), Country.class);
	}
	
	public FirstnameLastnameJobTitle firstnameLastnameJobTitle() 
	{
		return PageFactory.initElements(getWebDriver(), FirstnameLastnameJobTitle.class);
	}
	
	public JobTitle jobTitle() 
	{
		return PageFactory.initElements(getWebDriver(), JobTitle.class);
	}

	//Added by Anand
	public JobLevel jobLevel() 
	{
		return PageFactory.initElements(getWebDriver(), JobLevel.class);
	}
	
	//Added by Anand
	public JobFunction jobFunction() 
	{
		return PageFactory.initElements(getWebDriver(), JobFunction.class);
	}
	
	//Added by Anand
	public Industry industry() 
	{
		return PageFactory.initElements(getWebDriver(), Industry.class);
	}
	
	public Email email() 
	{
		return PageFactory.initElements(getWebDriver(), Email.class);

	}
}

package com.demoTest.common.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.demoTest.common.AbstractBasePage;

public class LandingPage extends AbstractBasePage{
	
	@FindBy(xpath="//div[contains(text(),'Campaigns')]")
	private WebElement landingPageName;
	
	public LandingPage(WebDriver driver) throws Exception {
		super(driver);
		validateLandingPageNameAndThrowError("Campaigns",landingPageName);
	}

}

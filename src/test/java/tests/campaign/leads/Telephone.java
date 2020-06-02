package tests.campaign.leads;

import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;

import pageObjects.modules.LeadPageObjects;
import pageObjects.modules.LinkedInPageObjects;
import pageObjects.modules.TelephonePageObjects;
import tests.campaign.process.CampaignTestDataProcess;
import utils.ExcelUtils;
import utils.ExtentReports.ExtentTestManager;

public class Telephone extends TelephonePageObjects {
	
	private Logger logger = Logger.getLogger(LeadPageObjects.class.getName());
	
	public TelephonePageObjects telephoneCheck() throws Exception {
		
		List<String> telephoneNumber = CampaignTestDataProcess.getTelephoneNumber();
		List<String> country = campaignTestDataProcess().getCountryforTelephone();
		
		
		logger.info("Telephone Numbers to validate as per csv :" + telephoneNumber);
		logger.info("Telephone Numbers to validate as per csv :" + country);

		
		for (int i=0; i<telephoneNumber.size(); i++) {
			String regionCode = CampaignTestDataProcess.getRegionCode(country.get(i));
			logger.info("Matched Region Code :" + regionCode);
			setvaluePhoneNumber(telephoneNumber.get(i));
			setvalueRegionCode(regionCode);
			clickSubmitbtn();
			
			
		}
		
		
		
	return telephonePage();
	}
}

package tests.campaign.leads;

import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;

import pageObjects.modules.LeadPageObjects;
import pageObjects.modules.LinkedInPageObjects;
import tests.campaign.process.CampaignTestDataProcess;
import utils.ExcelUtils;
import utils.ExtentReports.ExtentTestManager;

public class Industry extends LeadPageObjects {
	

	public void setIndustyToggle() throws Exception {
		List<String> AcceptedIndustries = CampaignTestDataProcess.getIndustryVertical();
		campaignTestDataProcess().setLeadsIndustrialVertical(AcceptedIndustries);
	}

	public LeadPageObjects industryCheck() throws Exception {
		Boolean isSelected = false;
		Boolean industryStatus = false;
		Boolean rejectLead = false;
		String IndusValue = null;
		
	//	String IndustryFromSite = LinkedInPageObjects
		String IndustryFromSite = "Information Technology and Services";
		List<String> AcceptedIndustries = campaignTestDataProcess().getLeadsIndustrialVertical();
		List<String> mapIndustries = CampaignTestDataProcess.getIndustryInfo(IndustryFromSite);
		List<String> finalIndustries = new ArrayList<String>();
		
		for (int i=0; i<AcceptedIndustries.size(); i++) {
			for (int j=0; i<mapIndustries.size(); j++) {
				if (AcceptedIndustries.get(i).contains(mapIndustries.get(j))) {
					industryStatus = true;
					finalIndustries.add(mapIndustries.get(j));
				}
			}
		}
		
		System.out.println(AcceptedIndustries);
		System.out.println(mapIndustries);
		System.out.println(finalIndustries);
		
		if (industryStatus) {		
			List<WebElement> options = getvaluesIndustryDropdown();
			for(WebElement item:options) { 
				System.out.println("Dropdown values are "+ item.getText());
				
				for (int i=0; i<finalIndustries.size(); i++) {
					if (item.getText().contains(finalIndustries.get(i))) {
						IndusValue = finalIndustries.get(i);
						isSelected = true;
						selectvalueIndustryDropdown(item.getText());
						ExtentTestManager.getTest().log(LogStatus.PASS, "Industry Dropdown Value: "+item.getText()+" is selected for the Industry: "+finalIndustries.get(i));
						break;
					}
				}
				if (isSelected) {
					break;
				}					
				else {
					ExtentTestManager.getTest().log(LogStatus.FAIL, "Industry Dropdown Value: "+IndusValue+" not listed in the dropdown");
				}		
		    }
		}
		else {
			rejectLead = true;
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Identified Industries: "+mapIndustries+" are not accepted in vertical list: "+AcceptedIndustries+" hence reject the Lead");
		}
		
	return leadPage();
	}
}

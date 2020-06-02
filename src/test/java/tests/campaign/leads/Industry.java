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
import tests.campaign.process.CampaignTestDataProcess;
import utils.ExcelUtils;
import utils.ExtentReports.ExtentTestManager;

public class Industry extends LeadPageObjects {
	
	private Logger logger = Logger.getLogger(LeadPageObjects.class.getName());
	
	public void setIndustyToggle() throws Exception {
		List<String> AcceptedIndustries = CampaignTestDataProcess.getIndustryVertical();
		campaignTestDataProcess().setLeadsIndustrialVertical(AcceptedIndustries);
	}

	public LeadPageObjects industryCheck() throws Exception {
		Boolean isSelected = false;
		Boolean industryStatus = false;
		Boolean rejectLead = false;
		String IndusValue = null;
		
		String openNotesIndustryValue = campaignTestDataProcess().getOpenNotesIndustryVertical();
		String linkedinIndustry = campaignTestDataProcess().getLinkedinIndustry();
		List<String> mapIndustries = CampaignTestDataProcess.getIndustryInfo(linkedinIndustry);

		logger.info("Industry Mentioned in Open Notes: " + openNotesIndustryValue);
		logger.info("Industry Mentioned in LinkedIn: " + linkedinIndustry);
		logger.info("Matched Industry/keyword from Repository: " + mapIndustries);
		
		if (!openNotesIndustryValue.contains("TAL")) {

	//		String IndustryFromSite = "Information Technology and Services";
			setIndustyToggle();
			List<String> AcceptedIndustries = campaignTestDataProcess().getLeadsIndustrialVertical();		
			List<String> filteredIndustries = new ArrayList<String>();
			
			logger.info("Industry Accepted as per Open Notes: " + AcceptedIndustries);
					
			for (int i=0; i<AcceptedIndustries.size(); i++) {
				for (int j=0; i<mapIndustries.size(); j++) {
					if (AcceptedIndustries.get(i).contains(mapIndustries.get(j))) {
						industryStatus = true;
						filteredIndustries.add(mapIndustries.get(j));
					}
				}
			}
			
			logger.info("Filtered Industry/keyword: " + filteredIndustries);
		
			if (industryStatus) {		
				List<WebElement> options = getvaluesIndustryDropdown();
				for(WebElement item:options) { 
					logger.info("Industry Dropdown values are: " + item.getText());
					
					for (int i=0; i<filteredIndustries.size(); i++) {
						if (item.getText().contains(filteredIndustries.get(i))) {
							IndusValue = filteredIndustries.get(i);
							isSelected = true;
							selectvalueIndustryDropdown(item.getText());
							logger.info("Industry Dropdown Value: "
									+item.getText()+" is selected for the Industry: "+filteredIndustries.get(i));
							ExtentTestManager.getTest().log(LogStatus.PASS, "Industry Dropdown Value: "
									+item.getText()+" is selected for the Industry: "+filteredIndustries.get(i));
							break;
						}
					}
					if (isSelected) {
						break;
					}					
					else {
						logger.info("Industry Dropdown Value: " 
								+IndusValue+" not listed in the dropdown");
						ExtentTestManager.getTest().log(LogStatus.FAIL, "Industry Dropdown Value: "
								+IndusValue+" not listed in the dropdown");
					}		
			    }
			}
			else {
				rejectLead = true;
				logger.info("Identified Industries: "+mapIndustries+" are not accepted in vertical list: "
						+AcceptedIndustries+" hence reject the Lead");
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Identified Industries: "
						+mapIndustries+" are not accepted in vertical list: "+AcceptedIndustries+" hence reject the Lead");
			}
		}
		else {
			List<WebElement> options = getvaluesIndustryDropdown();
			for(WebElement item:options) { 
				logger.info("Industry Dropdown values are: " + item.getText());
				
				for (int i=0; i<mapIndustries.size(); i++) {
					if (item.getText().contains(mapIndustries.get(i))) {
						IndusValue = mapIndustries.get(i);
						isSelected = true;
						selectvalueIndustryDropdown(item.getText());
						logger.info("Industry Dropdown Value: "
								+item.getText()+" is selected for the Industry: "+mapIndustries.get(i));
						ExtentTestManager.getTest().log(LogStatus.PASS, "Industry Dropdown Value: "
								+item.getText()+" is selected for the Industry: "+mapIndustries.get(i));
						break;
					}
				}
				if (isSelected) {
					break;
				}					
		    }
			if (!isSelected) {
				logger.info("Industry Dropdown Value: " 
						+IndusValue+" not listed in the dropdown");
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Industry Dropdown Value: "
						+IndusValue+" not listed in the dropdown");
			}
		}
	return leadPage();
	}
}

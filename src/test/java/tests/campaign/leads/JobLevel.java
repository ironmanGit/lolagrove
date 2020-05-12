package tests.campaign.leads;

import java.io.File;
import java.lang.reflect.Method;
import java.util.List;

import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;

import pageObjects.modules.LeadPageObjects;
import tests.campaign.process.CampaignTestDataProcess;
import utils.ExcelUtils;
import utils.ExtentReports.ExtentTestManager;

public class JobLevel extends LeadPageObjects {
	
	public LeadPageObjects jobLevelCheck() throws Exception {
	Boolean isSelected = false;
//	String jobTitleFromLead =  "Head of Information Systems and Strategy";
	String jobTitleFromLead =  getvalueJobTitle();
	String[] JobRole = CampaignTestDataProcess.getJobRoleInfo(jobTitleFromLead);
 
	boolean IsJobRoleExist = isJobRoleFieldExist();
	if (IsJobRoleExist) {
		ExtentTestManager.getTest().log(LogStatus.INFO, "Job Role Field Exists in lead page");
		List<WebElement> options = getvaluesJobRoleDropdown();
		for(WebElement item:options) { 
			System.out.println(JobRole);
			System.out.println("Dropdown values are "+ item.getText());
			
			for (int i=0; i<JobRole.length; i++) {
				if (item.getText().contains(JobRole[i])) {
					isSelected = true;
					selectvalueJobRoleDropdown(item.getText());
					ExtentTestManager.getTest().log(LogStatus.PASS, "Job Role Dropdown Value: "+item.getText()+" is selected for the Job Role: "+JobRole);
					break;
				}
			}
			if (isSelected) {
				break;
			}		
		}
		if (!isSelected) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Job Role: "+JobRole+" not listed in the dropdown");
		}
	} else {
			ExtentTestManager.getTest().log(LogStatus.INFO, "Job Role Field doesnt Exists in lead page");
		}

	return leadPage();
	}
	
}

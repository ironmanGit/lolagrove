package tests.campaign.leads;

import java.io.File;
import java.lang.reflect.Method;
import java.util.List;

import com.relevantcodes.extentreports.LogStatus;

import pageObjects.modules.LeadPageObjects;
import tests.campaign.process.CampaignTestDataProcess;
import utils.ExcelUtils;
import utils.ExtentReports.ExtentTestManager;

public class JobLevel extends LeadPageObjects {
	
	public LeadPageObjects jobLevelCheck() throws Exception {
	String jobTitleFromLead =  getvalueJobTitle();
	List<String> JobRole = CampaignTestDataProcess.getJobRoleInfo(jobTitleFromLead);
 
	boolean IsJobRoleExist = isJobRoleFieldExist();
	if (IsJobRoleExist) {
		ExtentTestManager.getTest().log(LogStatus.INFO, "Job Role Field Exists in lead page");
		selectvalueJobRoleDropdown(JobRole);
		ExtentTestManager.getTest().log(LogStatus.PASS, "Job Role : "+JobRole+" is selected in Job Role Field");
	} else {
			ExtentTestManager.getTest().log(LogStatus.INFO, "Job Role Field doesnt Exists in lead page");
		}

	return leadPage();
	}
	
}

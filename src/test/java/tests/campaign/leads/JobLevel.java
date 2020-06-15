package tests.campaign.leads;

import java.io.File;
import java.lang.reflect.Method;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.LogStatus;

import pageObjects.modules.LeadPageObjects;
import tests.campaign.process.CampaignTestDataProcess;
import utils.ExcelUtils;
import utils.ExtentReports.ExtentTestManager;

public class JobLevel extends LeadPageObjects {
	
	private Logger logger = Logger.getLogger(LeadPageObjects.class.getName());
	
	@FindBy(css = "input[name='job_role'] + div>select")
	private WebElement jobRoleDropdown;
	
	public LeadPageObjects jobLevelCheck() throws Exception {
	Boolean isSelected = false;
	String jobTitleFromLead =  getvalueJobTitle();
	String jobRoleValue = null;
	List<String> JobRole = CampaignTestDataProcess.getJobRoleInfo(jobTitleFromLead);
	String openNoteJobRole = campaignTestDataProcess().getLeadsJobTitle();

	logger.info("Job Title Mentioned in the Lead:" + jobTitleFromLead);
	logger.info("Accepted Job Function(s) as per Open Notes:" + openNoteJobRole);
	logger.info("Matched Dropdown Values for Job Role: "+ JobRole);
	
	boolean IsJobRoleExist = isJobRoleFieldExist();
	if (IsJobRoleExist) {
		
		selectByIndex(jobRoleDropdown, 1);
		handleAlert();
		selectByIndex(jobRoleDropdown, 0);
		handleAlert();
		
		if (!JobRole.isEmpty()){
			ExtentTestManager.getTest().log(LogStatus.INFO, "Job Role Field Exists in lead page");
			List<WebElement> options = getvaluesJobRoleDropdown();
			for(WebElement item:options) { 
				for (int i=0; i<JobRole.size(); i++) {
					if (item.getText().toLowerCase().contains(JobRole.get(i).toLowerCase())) {
						jobRoleValue = JobRole.get(i);
						isSelected = true;
						selectvalueJobRoleDropdown(item.getText());
						logger.info("Selected Job Role Dropdown Value:" + item.getText());
						ExtentTestManager.getTest().log(LogStatus.PASS, "Job Role Dropdown Value: "+item.getText()+" is selected for the Job Role: "+JobRole.get(i));
						break;
					}
				}
				if (isSelected) {
					break;
				}		
			}
			if (!isSelected) {
				logger.info("Job Role: "+jobRoleValue+" NOT listed in the dropdown - UPDATE KEYWORD DICTIONARY");
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Job Role: "+jobRoleValue+" not listed in the dropdown");
			}
		} else {
			logger.info("No Matched found for Job Title Keyword: "+jobTitleFromLead+" - UPDATE KEYWORD DICTIONARY");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "No Matched found for Job Title Keyword: "+jobTitleFromLead+" - UPDATE KEYWORD DICTIONARY");
		}
	} else {
			ExtentTestManager.getTest().log(LogStatus.INFO, "Job Role Field doesnt Exists in lead page");
		}

	return leadPage();
	}
	
}

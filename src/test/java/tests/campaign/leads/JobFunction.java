package tests.campaign.leads;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;

import pageObjects.modules.LeadPageObjects;
import tests.campaign.process.CampaignTestDataProcess;
import utils.ExtentReports.ExtentTestManager;

public class JobFunction extends LeadPageObjects {
	
	private Logger logger = Logger.getLogger(LeadPageObjects.class.getName());
	
	public LeadPageObjects jobFunctionCheck() throws Exception {
	Boolean isSelected = false;
	Boolean isAccepted = false;
	String jobFunctionValue = null;
	String jobTitleFromLead =  getvalueJobTitle();
	List<String> JobFunction = CampaignTestDataProcess.getJobFunctionInfo(jobTitleFromLead);
	String openNoteJobFunction = campaignTestDataProcess().getLeadsJobFunction();

//	if(m) { to add code for managing Open Notes like Management plus / +
//		
//	}
	
	logger.info("Accepted Job Function(s) as per Open Notes:" + openNoteJobFunction);
	for(String value:JobFunction) {
		if(openNoteJobFunction.contains(value)) {
			isAccepted = true;
			logger.info("Matched Job Title/Keyword with Open Notes:" + value);
		} else {
			logger.info("Unmatched Job Title/Keyword with Open Notes:" + value);
		}
	}
	
	if (isAccepted){
		List<WebElement> options = getvaluesJobFunctionDropdown();
		for(WebElement item:options) {
			logger.info("Job Function Dropdown Value :" + item.getText());
			
			for (int i=0; i<JobFunction.size(); i++) {
				if (item.getText().contains(JobFunction.get(i))) {
					logger.info("Matched Job Title/Keyword with Job Function Dropdown :" + JobFunction.get(i));
					isSelected = true;
					jobFunctionValue = JobFunction.get(i);
					selectvalueJobFunctionDropdown(item.getText());
					logger.info("Selected Job Function Dropdown Value:" + item.getText());
					ExtentTestManager.getTest().log(LogStatus.PASS, "Job Function Dropdown Value: "
					+item.getText()+" is selected for the Job Function: "+JobFunction.get(i));
					break;
				}
			}
			if (isSelected) {
				break;
			}	
		}
		if (!isSelected) {
			logger.info("Job Function: "+jobFunctionValue+" not listed in the dropdown");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Job Function: "+jobFunctionValue+" not listed in the dropdown");
		}
	}
	else {
		logger.info("None of Job Title/Keyword matched with Open Notes");
		ExtentTestManager.getTest().log(LogStatus.FAIL, "None of Job Title/Keyword matched with Open Notes");
	}
			
	return leadPage();
	}
}

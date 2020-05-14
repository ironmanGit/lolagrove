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

public class JobFunction extends LeadPageObjects {
	
	public LeadPageObjects jobFunctionCheck() throws Exception {
	Boolean isSelected = false;
	String jobFunctionValue = null;
	String jobTitleFromLead =  getvalueJobTitle();
	List<String> JobFunction = CampaignTestDataProcess.getJobFunctionInfo(jobTitleFromLead);
	
	List<WebElement> options = getvaluesJobFunctionDropdown();
//	System.out.println("Dropdown values are "+ options);
	for(WebElement item:options) { 
//		System.out.println(JobFunction);
//		System.out.println("Dropdown value is "+ item.getText());
		
		for (int i=0; i<JobFunction.size(); i++) {
			if (item.getText().contains(JobFunction.get(i))) {
				isSelected = true;
				jobFunctionValue = JobFunction.get(i);
				selectvalueJobFunctionDropdown(item.getText());
				ExtentTestManager.getTest().log(LogStatus.PASS, "Job Function Dropdown Value: "+item.getText()+" is selected for the Job Function: "+JobFunction.get(i));
				break;
			}
		}
		if (isSelected) {
			break;
		}	
	}
	if (!isSelected) {
		ExtentTestManager.getTest().log(LogStatus.FAIL, "Job Function: "+jobFunctionValue+" not listed in the dropdown");
	}		
	
	return leadPage();
	}
}

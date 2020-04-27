package tests.campaign.leads;

import java.io.File;
import java.lang.reflect.Method;

import pageObjects.modules.LeadPageObjects;
import utils.ExcelUtils;

public class JobLevel extends LeadPageObjects {
	
	public LeadPageObjects jobLevelCheck() throws Exception {
	String openNotesJobLevel = campaignTestDataProcess().getLeadsJobTitle();

	return leadPage();
	}
	
}

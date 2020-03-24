package pageObjects.modules;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import utils.ExcelUtils;
import utils.ExtentReports.ExtentTestManager;
import com.relevantcodes.extentreports.LogStatus;
import pageObjects.initializePageObjects.PageFactoryInitializer;

public class LandingPageObjects extends PageFactoryInitializer {
	private Logger logger = Logger.getLogger(LandingPageObjects.class.getName());

	@FindBy(xpath = "//div[contains(text(),'Campaigns')]")
	private WebElement landingPageName;

	@FindBy(xpath = "//a[contains(text(), 'Open Notes')]")
	private WebElement openNotesLink;
	
	@FindBy(css = "input[value='Show Data']")
	private WebElement showDataButton;
	
	@FindBy(css = "div [class='alpha'] a")
	private List<WebElement> selectCampaign;

	@FindBy(css = "div [class='fab'][title='Next']")
	private WebElement nextButton;
	
	@FindBy(css = "div [class='fab'][title='Next']")
	private List<WebElement> nextButtonList;
	
	@FindBy(css = "div [class='fab'][title='Back']")
	private WebElement backButton;
	
	@FindBy(css = "div [class='fab'][title='Back']")
	private List<WebElement> backButtonList;

	@FindBy(css = "table[class='table-hover'] tr")
	private List<WebElement> getCampaignRows;
	
	public LandingPageObjects verifyCampaignTab() throws Exception {
		String campaignTab = null;
		try{
			campaignTab = landingPageName.getText();
			Assert.assertEquals(campaignTab, "Campaigns", "Expected Page is 'Campaign' But actual page is " + campaignTab);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Navigated to campaign page");
		}
		catch(Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Expected Page is 'Campaign' But actual page is " + campaignTab);
		}
		return this;
	}

	public LandingPageObjects selectCampaign() throws Exception {
		String campaignText = appConfig.getCampaign();
		ExtentTestManager.getTest().log(LogStatus.INFO, "Selected campaign is : "+campaignText);
		char campaignChar = campaignText.charAt(0);
		String campaignFirstText = Character.toString(campaignChar);
		WebElement target = findCampaignFirstLetter(campaignFirstText);
		click(target);
		return this;
	}
	
	public LandingPageObjects navigateToLeadsPage() throws Exception {
		String campaignText = appConfig.getCampaign();
		WebElement campaignTarget = findCampaignLink(campaignText);
		try {
			click(campaignTarget);	
			ExtentTestManager.getTest().log(LogStatus.PASS, "Successfuly "+campaignText+" selected");
		}catch(Exception e){
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to select "+campaignText);
		}
		Thread.sleep(3000);
		click(showDataButton);
		Thread.sleep(3000);
		return this;
	}

	public WebElement findCampaignFirstLetter(String campaignText) {
		List<WebElement> rows = selectCampaign;
		WebElement target = null;
		int rowSize = rows.size();
		for (int i = 1; i < rowSize; i++) {
			WebElement row = rows.get(i);
			String campaignTextUI = row.getText();
			if (campaignTextUI.equals(campaignText)) {
				target = row;
				break;
			}
		}
		return target;
	}
	
	public void goToFirstPage() throws Exception {
		while(checkPaginationBackIsDisplayed()) {
			click(backButton);
		}
	}
	
	public WebElement findCampaignLink(String campaignText) throws Exception {
		List<String> leadsList = new ArrayList<String>();
		WebElement target = null;
		int maxTry =1;
		for (int i = 0; i < maxTry && target == null; i++) {
			//goToFirstPage();
			while (target == null) {
				target = findCampaignLinkFromCurrentPage(campaignText);
				if(target != null || !checkPaginationNextIsDisplayed()) {
					break;
				}
				click(nextButton);
			}
		}
		
		if (target == null) {
			throw new Exception("Error : Cannot find Campaign name - "+campaignText);
		}
		
		return target;
	}
	
	public WebElement findCampaignLinkFromCurrentPage1(String campaignText) {
		List<WebElement> rows = getCampaignRows;
		WebElement target = null;
		int columnIndex = 0;
		int rowSize = rows.size();
		for (int i = 1; i < rowSize; i++) {
			WebElement row = rows.get(i);
			List<WebElement> cols = row.findElements(By.xpath("./td"));
			WebElement campaignElement = cols.get(columnIndex);
			String campaignTextUI = campaignElement.getText();
			if (campaignTextUI.equals(campaignText)) {
				campaignElement = campaignElement.findElement(By.cssSelector(" a"));
				target = campaignElement;
				break;
			}
		}
		return target;
	}

	public WebElement findCampaignLinkFromCurrentPage(String campaignText) throws Exception {
		WebElement editLead = null;
		try {
			editLead = getXpath("//td/a[contains(text(), '%s')]", campaignText);	
			ExtentTestManager.getTest().log(LogStatus.PASS, "Successfuly "+campaignText+" selected");
		}catch(Exception e){
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to select "+campaignText);
		}
		return editLead;
	}
	
	public List<List<String>> getCampaignDetailsFromAllPages() throws Exception {
		List<List<String>> result = new ArrayList<List<String>>();
		boolean hasNext = true;
		int pageNumber = 0;
		do {
			Thread.sleep(5000);
			result.addAll(getCampaignDetailsFromOnePage());
			pageNumber++;
			Thread.sleep(5000);
			if (checkPaginationNextIsDisplayed()) {
				clickPaginationNext();
			} else {
				hasNext = false;
			}
		} while (hasNext);
		logger.info(result);
		return result;
	}
	
	public void createCampaignLeadsFile() throws Exception {
		String campaignName = appConfig.getCampaign();
		String campaignPath = "campaignFiles/" + campaignName + "_Leads.csv";
		List<List<String>> campaignLeads = this.getCampaignDetailsFromAllPages();
		List<String> campaignLines = new ArrayList<String>();
		for (List<String> campaignLead : campaignLeads) {
			String getName = campaignLead.get(0);
			String getAdvertiser = campaignLead.get(1);
			String getStatus = campaignLead.get(2);
			String getEdit = campaignLead.get(3);
			String getDelete = campaignLead.get(4);
			String getEyeballing = campaignLead.get(5);
			String getUncheckedLeads = campaignLead.get(6);
			String line = getName + "," + getAdvertiser + "," + getStatus + "," + getEdit + "," + getDelete + ","
					+ getEyeballing + "," + getUncheckedLeads;
			campaignLines.add(line);
		}
		createCampaignFile(campaignLines, campaignPath, true);
	}
	
	public void readCampaignLeadsFile() throws Exception {
		String campaignName = appConfig.getCampaign();
		String campaignPath = "campaignFiles/" + campaignName + "_Leads.csv";
		List<String> leadsData = ExcelUtils.readFileToLines(campaignPath);
		campaignTestDataProcess().setcampaignDataLines(leadsData);
		logger.info(leadsData);
		ExtentTestManager.getTest().log(LogStatus.INFO, "Leads lists are "+leadsData);
	}
	
	public void createCampaignFile(List<String> campaignLead, String campaignPath, boolean append) throws IOException {
		boolean fileExists = ExcelUtils.fileExist(campaignPath);
		String headerLine = campaignLead.get(0);
		if(!append || !fileExists) {
			ExcelUtils.writeToFile(campaignPath, headerLine);
		}
		int len = campaignLead.size();
		for (int i=1; i < len; i++) {
			String line = campaignLead.get(i);
			ExcelUtils.appendToFile(campaignPath, line);
		}
	}

	public LandingPageObjects clickPaginationNext() {
		click(nextButton);
		return this;
	}

	public OpenNotesPageObjects clickOpenNotesLink() {
		try {
			click(openNotesLink);
			logger.info("Open notes");
			switchToNewTab();
			ExtentTestManager.getTest().log(LogStatus.PASS, "Clicked 'Open Notes' successfully");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to click 'Open Notes' link");
		}
		return openNotesPage();
	}
	
	public LeadPageObjects clickShowDataButton() {
		try {
			click(showDataButton);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Clicked 'Show Data' button successfully");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to click 'Show Data' button");
		}
		
		return leadPage();
	}
	
	public LeadPageObjects clickEditLead(String leadId) throws Exception {
		try {
			WebElement editLead = getXpath("//td/span[contains(text(),'%s')]/../preceding-sibling::td/i", leadId);
			click(editLead);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Successfully navigated to '" + leadId + "' link");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to navigate to '" + leadId + "' link");
		}
		return leadPage();
	}
	
	public boolean checkPaginationNextIsDisplayed() throws Exception {
		if (nextButtonList.size() != 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean checkPaginationBackIsDisplayed() throws Exception {
		if (backButtonList.size() != 0) {
			return true;
		} else {
			return false;
		}
	}

	public List<List<String>> getCampaignDetailsFromOnePage() {
		List<WebElement> rows = getCampaignRows;
		int len = rows.size();
		List<List<String>> textRows = new ArrayList<List<String>>();
		for (int i = 1; i < len; i++) {
			List<String> textRow = new ArrayList<String>();
			WebElement row = rows.get(i);
			List<WebElement> cols = row.findElements(By.xpath("./td"));
			for (WebElement col : cols) {
				String text = col.getText();
				textRow.add(text);
			}
			textRows.add(textRow);
		}
		return textRows;
	}
	
	public LandingPageObjects setTestDataCheck() {
		String country = campaignTestDataProcess().getLeadsCountry();
		logger.info("country Test data value check is: " + country);
		String companySize = campaignTestDataProcess().getLeadsCompanySize();
		logger.info("companySize Test data value check is: " + companySize);
		String industrial = campaignTestDataProcess().getLeadsIndustrialVertical();
		logger.info("industrial Test data value check is: " + industrial);
		String jobFunction = campaignTestDataProcess().getLeadsJobFunction();
		logger.info("jobFunction Test data value check is: " + jobFunction);
		String jobTitle = campaignTestDataProcess().getLeadsJobTitle();
		logger.info("jobTitle Test data value check is: " + jobTitle);
		ExtentTestManager.getTest().log(LogStatus.INFO, "Test data value check is: ");
		return this;
	}

}

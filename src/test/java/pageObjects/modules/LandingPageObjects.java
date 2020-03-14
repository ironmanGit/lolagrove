package pageObjects.modules;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import pageObjects.initializePageObjects.PageFactoryInitializer;
import tests.campaign.CampaignTest;
import utils.ExcelUtils;

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

	@FindBy(css = "table[class='table-hover'] tr")
	private List<WebElement> getTransactionRows;

	public LandingPageObjects verifyCampaignTab() throws Exception {
		String campaignTab = landingPageName.getText();
		Assert.assertEquals(campaignTab, "Campaigns", "Expected Page is 'Campaign' But actual page is " + campaignTab);
		return this;
	}

	public LandingPageObjects selectCampaign() throws Exception {
		String campaignText = appConfig.getCampaign();
		char campaignChar = campaignText.charAt(0);
		campaignText = Character.toString(campaignChar);
		WebElement target = findCampaignFirstLetter(campaignText);
		click(target);
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
	}

	private void createCampaignFile(List<String> campaignLead, String campaignPath, boolean append) throws IOException {
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
		return;
	}

	public void clickPaginationNext() {
		click(nextButton);
	}

	public void clickOpenNotesLink() {
		click(openNotesLink);
	}
	
	public void clickShowDataButton() {
		click(showDataButton);
	}
	
	public void clickEditLead(String leadId) throws Exception {
		WebElement editLead = getXpath("//td/span[contains(text(),'%s')]/../preceding-sibling::td/i", leadId);
		click(editLead);
	}
	
	public boolean checkPaginationNextIsDisplayed() throws Exception {
		if (nextButtonList.size() != 0) {
			return true;
		} else {
			return false;
		}
	}

	public List<List<String>> getCampaignDetailsFromOnePage() {
		List<WebElement> rows = getTransactionRows;
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

}

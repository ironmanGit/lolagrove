package pageObjects.modules;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import pageObjects.initializePageObjects.PageFactoryInitializer;
import tests.campaign.CampaignTest;

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

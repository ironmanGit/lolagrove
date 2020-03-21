/**
 * 
 */
package pageObjects.modules;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.LogStatus;

import tests.campaign.process.CampaignTestProcess;
import utils.ExtentReports.ExtentTestManager;

/**
 * @Author Vivekanandan Sampath
 * @Date Mar 09, 2020
 */
public class OpenNotesPageObjects extends CampaignTestProcess {

	@FindBy(css = "#GroupA > div:nth-child(3) > div.panel-body")
	private WebElement country;

	@FindBy(css = "#GroupA > div:nth-child(2) > div.panel-body")
	private WebElement companySize;

	@FindBy(css = "#GroupA > div:nth-child(4) > div.panel-body")
	private WebElement industrialVertical;

	@FindBy(css = "#GroupA > div:nth-child(5) > div.panel-body")
	private WebElement jobFunction;

	@FindBy(css = "#GroupA > div:nth-child(6) > div.panel-body")
	private WebElement jobTitle;

	public OpenNotesPageObjects getCountryDetailsFromOpenNotes() {
		String countryDetails = getListOfTexts(country);
		setLeadsCountry(countryDetails);
		ExtentTestManager.getTest().log(LogStatus.INFO, "Country Names in Open Notes : " + countryDetails);
		return this;
	}

	public String getCompanySize() {
		String text = companySize.getText();
		boolean isTAL = text.contains("TAL");
		if (isTAL) {
			text = "TAL";
		}
		return text;
	}

	public OpenNotesPageObjects getCompanySizeFromOpenNotes() {
		String companySize = getCompanySize();
		setLeadsCompanySize(companySize);
		ExtentTestManager.getTest().log(LogStatus.INFO, "company Size details in Open Notes : " + companySize);
		return this;
	}

	public String getIndustryVertical() {
		String text = industrialVertical.getText();
		boolean isTAL = text.contains("TAL");
		if (isTAL) {
			text = "TAL";
		}
		return text;
	}

	public OpenNotesPageObjects getIndustryVerticalFromOpenNotes() {
		String industrialVertical = getIndustryVertical();
		setLeadsIndustrialVertical(industrialVertical);
		ExtentTestManager.getTest().log(LogStatus.INFO,	"Industry vertical details in Open Notes are : " + industrialVertical);
		return this;
	}

	public OpenNotesPageObjects getJobFunctionFromOpenNotes() {
		String jobFunctions = getListOfTexts(jobFunction);
		setLeadsJobFunction(jobFunctions);
		ExtentTestManager.getTest().log(LogStatus.INFO, "Job functions in Open Notes : " + jobFunctions);
		return this;
	}

	public OpenNotesPageObjects getJobTitleFromOpenNotes() {
		String jobTitles = getListOfTexts(jobTitle);
		setLeadsJobTitle(jobTitles);
		ExtentTestManager.getTest().log(LogStatus.INFO, "Job title in Open Notes : " + jobTitles);
		return this;
	}

	public String getListOfTexts(WebElement element) {
		String text = element.getText();
		text = text.replace("\n", "|");
		text = text.replace(",", "|");
		text = text.replace("&", "|");
		text = text.replaceAll("\\([^)]*?\\)", "");
		text = text.replace("|", ",");
		return text;
	}
	
	public OpenNotesPageObjects getAllFieldsFromOpenNotes() {
		getCountryDetailsFromOpenNotes();
		getCompanySizeFromOpenNotes();
		getIndustryVerticalFromOpenNotes();
		getJobFunctionFromOpenNotes();
		getJobTitleFromOpenNotes();
		return this;
	}

	public void closeOpenNotesTab() {
		try {
			closeTab();
			ExtentTestManager.getTest().log(LogStatus.PASS, "Closed 'Open Notes' tab successfully");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to close 'Open Notes' tab");
		}
//		return leadPage();
	}

}

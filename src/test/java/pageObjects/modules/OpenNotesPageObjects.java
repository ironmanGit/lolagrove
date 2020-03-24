/**
 * 
 */
package pageObjects.modules;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.LogStatus;

import pageObjects.initializePageObjects.PageFactoryInitializer;
import tests.campaign.process.CampaignTestProcess;
import utils.ExtentReports.ExtentTestManager;

/**
 * @Author Vivekanandan Sampath
 * @Date Mar 09, 2020
 */
public class OpenNotesPageObjects extends PageFactoryInitializer {
	
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
		campaignTestDataProcess().setLeadsCountry(countryDetails);
		ExtentTestManager.getTest().log(LogStatus.INFO, "Country Names in Open Notes : " + countryDetails);
		return this;
	}

	public String getCompanySize() {
		String companySizes = companySize.getText();
		boolean isTAL = companySizes.contains("TAL");
		if (isTAL) {
			companySizes = "TAL";
		}else {
			companySizes = getListOfTexts(companySize);
		}
		return companySizes;
	}

	public OpenNotesPageObjects getCompanySizeFromOpenNotes() {
		String companySize = getCompanySize();
		campaignTestDataProcess().setLeadsCompanySize(companySize);
		ExtentTestManager.getTest().log(LogStatus.INFO, "company Size details in Open Notes : " + companySize);
		return this;
	}

	public String getIndustryVertical() {
		String industrialVerticalText = industrialVertical.getText();
		boolean isTAL = industrialVerticalText.contains("TAL");
		if (isTAL) {
			industrialVerticalText = "TAL";
		}else {
			industrialVerticalText = getListOfTexts(industrialVertical);
		}
		return industrialVerticalText;
	}

	public OpenNotesPageObjects getIndustryVerticalFromOpenNotes() {
		String industrialVertical = getIndustryVertical();
		campaignTestDataProcess().setLeadsIndustrialVertical(industrialVertical);
		ExtentTestManager.getTest().log(LogStatus.INFO,	"Industry vertical details in Open Notes are : " + industrialVertical);
		return this;
	}

	public OpenNotesPageObjects getJobFunctionFromOpenNotes() {
		String jobFunctions = getListOfTexts(jobFunction);
		campaignTestDataProcess().setLeadsJobFunction(jobFunctions);
		ExtentTestManager.getTest().log(LogStatus.INFO, "Job functions in Open Notes : " + jobFunctions);
		return this;
	}

	public OpenNotesPageObjects getJobTitleFromOpenNotes() {
		String jobTitles = getListOfTexts(jobTitle);
		campaignTestDataProcess().setLeadsJobTitle(jobTitles);
		ExtentTestManager.getTest().log(LogStatus.INFO, "Job title in Open Notes : " + jobTitles);
		return this;
	}

	public String getListOfTexts(WebElement element) {
		String text = element.getText();
		text = text.replace("\n", "|");
		text = text.replace(",", "|");
		text = text.replace("&", "|");
//		text = text.replaceAll("\\([^)]*?\\)", "");
		text = text.replace("(", "|");
		text = text.replace(")", "|");
		text = text.replace("|", ",");
		String[] listOfTexts = text.split(",");
		text = convertArrayToStringMethod(listOfTexts);
		return text;
	}
	
	public static String convertArrayToStringMethod(String[] strArray) {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < strArray.length; i++) {
			if (!strArray[i].trim().isEmpty()) {
				if (strArray[i].trim().length() > 35) {
					strArray[i] = getUpperCaseWords(strArray[i].trim());
				}
				if (i == strArray.length - 1) {
					stringBuilder.append(strArray[i].trim());
				} else {
					stringBuilder.append(strArray[i].trim());
					stringBuilder.append(", ");
				}
			}
		}
		return stringBuilder.toString();
	}
	
	public static String getUpperCaseWords(String name){
		name = name.replaceAll("(?:\\b)[a-z]*(?:\\b)", "").replaceAll("\\s+", " ");  
	    return name;
	}
	
	public static String getUpperCaseWordsold(String name){
	    String uppercaseCharacters = "";
	    for (int i=0;i<name.length();i++){
	        char ch = name.charAt(i);
	        if (Character.isUpperCase(ch)){
	            uppercaseCharacters += ch;
	        }
	    }   
	    return uppercaseCharacters;
	}
	
	public OpenNotesPageObjects getAllFieldsFromOpenNotes() {
		getCountryDetailsFromOpenNotes();
		getCompanySizeFromOpenNotes();
		getIndustryVerticalFromOpenNotes();
		getJobFunctionFromOpenNotes();
		getJobTitleFromOpenNotes();
		return this;
	}

	public LandingPageObjects closeOpenNotesTab() {
		try {
			closeTab();
			ExtentTestManager.getTest().log(LogStatus.PASS, "Closed 'Open Notes' tab successfully");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to close 'Open Notes' tab");
		}
		return landingPage();
	}
	
}

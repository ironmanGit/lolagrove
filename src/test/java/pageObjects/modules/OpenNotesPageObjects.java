/**
 * 
 */
package pageObjects.modules;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.google.common.collect.Lists;
import com.relevantcodes.extentreports.LogStatus;
import pageObjects.initializePageObjects.PageFactoryInitializer;
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

	@FindBy(xpath = "//div/h2[contains(text(),'Target List')]/../following-sibling::div//a")
	private List<WebElement> companyListsLink;

	@FindBy(xpath = "//div/h2[contains(text(),'Exclusions')]/../following-sibling::div//a")
	private List<WebElement> companyExclusionListsLink;
	
	@FindBy(css = "#GroupA > div:nth-child(7) > div.panel-body")
	private WebElement email;

	@FindBy(css = "body > table")
	private WebElement companyListsName;

	@FindBy(css = "body > table tr")
	private List<WebElement> companyListsRow;

	public OpenNotesPageObjects getCountryDetailsFromOpenNotes() {
		String countryDetails = getListOfTexts(country);
		campaignTestDataProcess().setLeadsCountry(countryDetails);
		ExtentTestManager.getTest().log(LogStatus.INFO, "Country Names in Open Notes : " + countryDetails);
		return this;
	}

	public String getCompanySize() {
		String companySizes = companySize.getText();
		boolean isTAL = companySizes.contains("TAL");
		boolean isAll = companySizes.contains("ALL");
		boolean isPlus = companySizes.contains("+");
		if (isTAL) {
			companySizes = "TAL";
		} else if(isAll){
			companySizes = "ALL";
		} else if(isPlus){
			companySizes = companySizes.replaceAll("[^0-9]", " ");
		} else {
			companySizes = companySizes.replaceAll("[^0-9]", " ").trim();
			companySizes = companySizes.replaceAll("  +", "-");
			companySizes = companySizes.replaceAll(" ", "");
		}
		return companySizes.trim();
	}

	public OpenNotesPageObjects getCompanySizeFromOpenNotes() {
		String companySize = getCompanySize();
		if (companySize.contains("-")) {
			companySize = companySize.replaceAll("[0-9]+-", "");
		}
		campaignTestDataProcess().setLeadsCompanySize(companySize);
		ExtentTestManager.getTest().log(LogStatus.INFO, "company Size details in Open Notes : " + companySize);
		return this;
	}

	public String getIndustryVertical() {
		String industrialVerticalText = industrialVertical.getText();
		boolean isTAL = industrialVerticalText.contains("TAL");
		if (isTAL) {
			industrialVerticalText = "TAL";
		} else {
			industrialVerticalText = getListOfTexts(industrialVertical);
		}
		campaignTestDataProcess().setOpenNotesIndustryVertical(industrialVerticalText);
		ExtentTestManager.getTest().log(LogStatus.INFO, "Industry in Open Notes : " + industrialVerticalText);
		return industrialVerticalText;
	}

	//this is not required as Industry details mentioned in png file will be converted to csv by Merit
//	public OpenNotesPageObjects getIndustryVerticalFromOpenNotes() {
//		String industrialVertical = getIndustryVertical();
//		campaignTestDataProcess().setLeadsIndustrialVertical(industrialVertical);
//		ExtentTestManager.getTest().log(LogStatus.INFO,
//				"Industry vertical details in Open Notes are : " + industrialVertical);
//		return this;
//	}

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

	public OpenNotesPageObjects getEmailFromOpenNotes() {
		String emailOpenNotes = getListOfTexts(email);
		campaignTestDataProcess().setEmail(emailOpenNotes);
		ExtentTestManager.getTest().log(LogStatus.INFO, "Email in Open Notes : " + emailOpenNotes);
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

	public static String getUpperCaseWords(String name) {
		name = name.replaceAll("[A-Z]?[a-z]|:|;|,", "").replaceAll("\\s+", " ");
		return name;
	}

	public static String getUpperCaseWordsold(String name) {
		String uppercaseCharacters = "";
		for (int i = 0; i < name.length(); i++) {
			char ch = name.charAt(i);
			if (Character.isUpperCase(ch)) {
				uppercaseCharacters += ch;
			}
		}
		return uppercaseCharacters;
	}

	public OpenNotesPageObjects getAllFieldsFromOpenNotes() throws InterruptedException {
		getCountryDetailsFromOpenNotes();
		getCompanySizeFromOpenNotes();
		getIndustryVertical();
		getJobFunctionFromOpenNotes();
		getJobTitleFromOpenNotes();
		getEmailFromOpenNotes();
		getExclusionCompanyListDetailsFromOpenNotes();
		getCompanyListDetailsFromOpenNotes();
		return this;
	}

	public void getCompanyListDetailsFromOpenNotes() throws InterruptedException {
		List<String> companyListDetails = new ArrayList<>();
		List<WebElement> links = companyListsLink;
		int linkSize = links.size();
		if (linkSize != 0) {
			for (int i = 0; i < linkSize; i++) {
				WebElement row = links.get(i);
				companyListDetails.add(row.getAttribute("href"));
			}
			System.out.println("Full Lists :" + companyListDetails);
			System.out.println("Total Url: " + companyListDetails.size());
			campaignTestDataProcess().setLeadsExclusionCompanyListUrl(companyListDetails);
			ExtentTestManager.getTest().log(LogStatus.INFO,
					"Company list details in Open Notes : " + companyListDetails);
		} else {
			ExtentTestManager.getTest().log(LogStatus.INFO, "No target list companies in open notes");
		}

	}
	
	public void getCompanyListDetailsFromOpenNotes1() throws InterruptedException {
		List<String> companyListDetails = new ArrayList<>();
		List<WebElement> links = companyListsLink;
		int linkSize = links.size();
		if (linkSize != 0) {
			for (int i = 0; i < linkSize; i++) {
				WebElement row = links.get(i);
				row.click();
				Thread.sleep(2000);
				refreshPage();
				Thread.sleep(2000);
				switchToWindowWithMatchingTitle("");
				List<String> companyLists = getColumnValueBasedOnHeaderName(companyListsName, "Company Name");
				companyListDetails.addAll(companyLists);
				int totalCompanyList = companyListDetails.size();
				System.out.println("Total Names: " + totalCompanyList);
				System.out.println("link " + i + " list of names " + companyListDetails);
				closeTab();
				switchToWindowWithMatchingTitle("Eyeballing Notes");
			}
			System.out.println("Full Lists :" + companyListDetails);
			System.out.println("Total Names: " + companyListDetails.size());
			campaignTestDataProcess().setLeadsCompanyListDetails(companyListDetails);
			ExtentTestManager.getTest().log(LogStatus.INFO,
					"Company list details in Open Notes : " + companyListDetails);
		} else {
			ExtentTestManager.getTest().log(LogStatus.INFO, "No target list companies in open notes");
		}

	}

	public void getExclusionCompanyListDetailsFromOpenNotes() throws InterruptedException {
		List<String> companyExclusionListDetails = new ArrayList<>();
		List<WebElement> links = companyExclusionListsLink;
		int linkSize = links.size();
		if (linkSize != 0) {
			for (int i = 0; i < linkSize; i++) {
				WebElement row = links.get(i);
				companyExclusionListDetails.add(row.getAttribute("href"));
			}
			System.out.println("Full Lists :" + companyExclusionListDetails);
			System.out.println("Total Url: " + companyExclusionListDetails.size());
			campaignTestDataProcess().setLeadsCompanyListUrl(companyExclusionListDetails);
			ExtentTestManager.getTest().log(LogStatus.INFO,
					"Exclusion Company list details in Open Notes : " + companyExclusionListDetails);
		} else {
			ExtentTestManager.getTest().log(LogStatus.INFO, "No exclusion companies in open notes");
		}
	}
	
	public void getExclusionCompanyListDetailsFromOpenNotes1() throws InterruptedException {
		List<String> companyListDetails = new ArrayList<>();
		List<WebElement> links = companyExclusionListsLink;
		int linkSize = links.size();
		if (linkSize != 0) {
			for (int i = 0; i < linkSize; i++) {
				WebElement row = links.get(i);
				row.click();
				Thread.sleep(2000);
				refreshPage();
				Thread.sleep(2000);
				switchToWindowWithMatchingTitle("");
				List<String> companyLists = getColumnValueBasedOnHeaderName(companyListsName, "Company Name");
				companyListDetails.addAll(companyLists);
				int totalCompanyList = companyListDetails.size();
				System.out.println("Total Names: " + totalCompanyList);
				System.out.println("link " + i + " list of names " + companyListDetails);
				closeTab();
				switchToWindowWithMatchingTitle("Eyeballing Notes");
			}
			System.out.println("Full Lists :" + companyListDetails);
			System.out.println("Total Names: " + companyListDetails.size());
			campaignTestDataProcess().setLeadsCompanyListDetails(companyListDetails);
			ExtentTestManager.getTest().log(LogStatus.INFO,
					"Exclusion Company list details in Open Notes : " + companyListDetails);
		} else {
			ExtentTestManager.getTest().log(LogStatus.INFO, "No exclusion companies in open notes");
		}
	}

	public List<String> getColumnValueBasedOnHeaderName(WebElement table, String headerName) {
		List<WebElement> thList = table.findElements(By.cssSelector("th"));
		List<String> headers = new ArrayList<>();
		thList.stream().forEach(th -> headers.add(th.getText()));
		int index = headers.indexOf(headerName);
		System.out.println("Index : " + index);
		List<WebElement> rows = companyListsRow;
		int len = rows.size();
		System.out.println("rows length : " + len);
		List<String> companyListsName = new ArrayList<>();
		for (int i = 1; i < len; i++) {
			WebElement row = rows.get(i);
			List<WebElement> tdList = row.findElements(By.xpath("./td"));
			if (tdList.size() > 0) {
				WebElement cell = tdList.get(index);
				String companyName = cell.getText();
				companyListsName.add(companyName);
			}
		}
		return companyListsName;
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

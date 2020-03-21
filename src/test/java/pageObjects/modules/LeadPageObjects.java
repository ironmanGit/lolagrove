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
import tests.campaign.process.CampaignDataRecord;
import tests.campaign.process.CampaignLeadsDataRecord;
import tests.campaign.process.CampaignTestProcess;
import utils.ExcelUtils;
import utils.ExtentReports.ExtentTestManager;
import com.relevantcodes.extentreports.LogStatus;

public class LeadPageObjects extends CampaignTestProcess {
	private Logger logger = Logger.getLogger(LeadPageObjects.class.getName());

	@FindBy(css = "div#editLeadNew table#tablecustom tbody tr td:nth-child(1) span")
	private WebElement placementReadOly;

	@FindBy(xpath = "div#editLeadNew table#tablecustom tbody tr td:nth-child(2) span")
	private WebElement assetReadOly;

	@FindBy(xpath = "div#editLeadNew table#tablecustom tbody tr td:nth-child(3) span")
	private WebElement leadTypeReadOly;

	@FindBy(xpath = "div#editLeadNew table#tablecustom tbody tr td:nth-child(4) span")
	private WebElement countryReadOly;

	@FindBy(css = "input[name='meritleadid']")
	private WebElement leadId;

	@FindBy(css = "input[name='email']")
	private WebElement email;

	@FindBy(css = "select#email_tools")
	private WebElement emailToolsDropdown;

	@FindBy(css = "input[name='email_evidence']")
	private WebElement emailEvidence;

	@FindBy(css = "li#email_evidence-li a.noevidence span")
	private WebElement emailNoEvidenceFoundBtn;

	@FindBy(css = "li#email_evidence-li a.indirect span")
	private WebElement emailIndirectEvidenceBtn;

	@FindBy(css = "input[name='telephone']")
	private WebElement telephone;

	@FindBy(css = "a#telephone + select.ddlCountry")
	private WebElement phoneReformatDropdown;

	@FindBy(css = "select#phone_tools")
	private WebElement phoneToolsDropdown;

	@FindBy(css = "input[name='phone_evidence']")
	private WebElement phoneEvidence;

	@FindBy(css = "li#phone_evidence-li a.callverified span")
	private WebElement phoneCallVerifiedBtn;

	@FindBy(css = "li#phone_evidence-li a.noevidence span")
	private WebElement phoneNoEvidenceFoundBtn;

	@FindBy(css = "input[name='telephone2']")
	private WebElement telephone2;

	@FindBy(css = "a#telephone2 + select.ddlCountry")
	private WebElement phoneReformatDropdown2;

	@FindBy(css = "input[name='phone2_evidence']")
	private WebElement phoneEvidence2;

	@FindBy(css = "input[name='address1']")
	private WebElement address1;

	@FindBy(css = "input[name='address2']")
	private WebElement address2;

	@FindBy(css = "input[name='towncity']")
	private WebElement towncity;

	@FindBy(css = "input[name='county']")
	private WebElement county;

	@FindBy(css = "input[name='postcode']")
	private WebElement postcode;

	@FindBy(css = "li#postcode-li a.toupper span")
	private WebElement postcodeUpperCaseBtn;

	@FindBy(css = "input[name='country']")
	private WebElement country;

	@FindBy(css = "select#ddlCountry2")
	private WebElement countryDropdown;

	@FindBy(css = "input[name='address_evidence']")
	private WebElement addressEvidence;

	@FindBy(css = "li#address_evidence-li a.noevidence span")
	private WebElement addressNoEvidenceFoundBtn;

	@FindBy(css = "li#address_evidence-li a.indirect span")
	private WebElement addressIndirectEvidenceBtn;

	@FindBy(css = "input[name='firstname']")
	private WebElement firstName;

	@FindBy(css = "input[name='lastname']")
	private WebElement lastName;

	@FindBy(css = "input[name='linkedin_id_url']")
	private WebElement linkedinIdUrl;

	@FindBy(css = "li#linkedin_id_url-li a.noevidence span")
	private WebElement linkedinIdUrlNoEvidenceFoundBtn;

	@FindBy(css = "input[name='jobtitle']")
	private WebElement jobTitle;

	@FindBy(css = "select#person_tools")
	private WebElement jobTitleDropdown;

	@FindBy(css = "input[name='jobtitle_evidence']")
	private WebElement jobTitleEvidence;

	@FindBy(css = "li#jobtitle_evidence-li a.copylinked span")
	private WebElement jobTitleEvidenceCopyLinkedinUrlBtn;

	@FindBy(css = "li#jobtitle_evidence-li a.callverified span")
	private WebElement jobTitleEvidenceCallVerifiedBtn;

	@FindBy(css = "li#jobtitle_evidence-li a.noevidence span")
	private WebElement jobTitleEvidenceNoEvidenceFoundBtn;

	@FindBy(css = "input[name='job_function']")
	private WebElement jobFunction;

	@FindBy(css = "select#ddlAdobeJobFunction")
	private WebElement jobFunctionDropdown;

	@FindBy(css = "input[name='companyname']")
	private WebElement companyName;

	@FindBy(xpath = "//div[@class='tallisting']//li/a[1]")
	private WebElement companyNameTargetListMatch1;

	@FindBy(xpath = "//div[@class='tallisting']//li/a[2]")
	private WebElement companyNameTargetListMatch2;

	@FindBy(xpath = "//div[@class='tallisting']//li/a[3]")
	private WebElement companyNameTargetListMatch3;

	@FindBy(css = "li#companyname-li a.companyevidencecopy span")
	private WebElement companyEvidenceCopyBtn;

	@FindBy(css = "li#companyname-li a.companyevidencepaste span")
	private WebElement companyEvidencePasteBtn;

	@FindBy(css = "li#companyname-li a.toupper span")
	private WebElement companyEvidenceUpperCaseBtn;

	@FindBy(css = "li#companyname-li a.toproper span")
	private WebElement companyEvidenceProperCaseBtn;

	@FindBy(css = "select#company_tools")
	private WebElement companyToolsDropdown;

	@FindBy(css = "input[name='industry']")
	private WebElement industry;

	@FindBy(css = "select#ddnIndustry")
	private WebElement industryDropdown;

	@FindBy(css = "input[name='company_evidence']")
	private WebElement companyEvidence;

	@FindBy(css = "input[name='company_size']")
	private WebElement companySize;

	@FindBy(css = "select#cmp_size_ddn")
	private WebElement companySizeDropDown;

	@FindBy(css = "input[name='companysize_evidence']")
	private WebElement companySizeEvidence;

	@FindBy(css = "li#companysize_evidence-li a.noevidence span")
	private WebElement companySizeNoEvidenceFoundBtn;

	@FindBy(css = "li#companysize_evidence-li a.indirect span")
	private WebElement companySizeIndirectEvidenceBtn;

	@FindBy(css = "input[name='turnover']")
	private WebElement turnover;

	@FindBy(css = "select#ddnTurnover")
	private WebElement turnoverDropdown;

	@FindBy(css = "select#company_toolsTurn")
	private WebElement turnoverCompanyToolsDropdown;

	@FindBy(css = "input[name='turnover_evidence']")
	private WebElement turnoverEvidence;

	@FindBy(css = "li#turnover_evidence-li a.noevidence span")
	private WebElement turnoverNoEvidenceFoundBtn;

	@FindBy(css = "li#turnover_evidence-li a.indirect span")
	private WebElement turnoverIndirectEvidenceBtn;

	@FindBy(css = "input[name='comments']")
	private WebElement rejectionReason;

	@FindBy(css = "select#ddnComments")
	private WebElement rejectionReasonDropdown;

	@FindBy(css = "input[name='rejection_evidence']")
	private WebElement rejectionReasonEvidence;

	@FindBy(css = "li#rejection_evidence-li a.r_jtitle span")
	private WebElement rejectionReasonJobtitleBtn;

	@FindBy(css = "li#rejection_evidence-li a.r_cosize span")
	private WebElement rejectionReasonCompanySizeBtn;

	@FindBy(css = "input[name='useragent']")
	private WebElement userAgent;

	@FindBy(css = "input[name='lead_type']")
	private WebElement leadType;

	@FindBy(css = "input[name='sfdc_code']")
	private WebElement sfdcCode;

	@FindBy(css = "input[name='product_of_interest']")
	private WebElement productOfInterest;

	@FindBy(css = "input[name='call_comments']")
	private WebElement callComments;

	@FindBy(css = "select#ddnCallComments")
	private WebElement callCommentsDropDown;

	@FindBy(css = "input[name='secure']")
	private WebElement secure;

	@FindBy(css = "input[name='biggest_challenge']")
	private WebElement biggestChallenge;

	@FindBy(css = "input[name='which_platforms']")
	private WebElement whichPlatforms;

	@FindBy(xpath = "//div[@class='ui-editlead-buttons']/button/span[text()='Reset')")
	private WebElement resetBtn;

	@FindBy(xpath = "//div[@class='ui-editlead-buttons']/a/span[text()='Save']")
	private WebElement saveBtn;

	@FindBy(xpath = "//div[@class='ui-editlead-buttons']/a/span[text()='Save & Reverify']")
	private WebElement saveAndReverifyBtn;

	@FindBy(css = "div[title='close']")
	private WebElement closeBtn;

	@FindBy(css = "table#validate-me tr")
	private List<WebElement> getLeadRows;
	
	@FindBy(xpath = "//a[contains(text(), 'Open Notes')]")
	private WebElement openNotesLink;

	@FindBy(css = "ul[class=pagination] li a")

	private List<WebElement> getPageNumbers;

	public List<List<String>> getLeadsDetailsFromAllPages() throws Exception {
		List<List<String>> result = new ArrayList<List<String>>();
		List<WebElement> pages = getPageNumbers;
		int len = pages.size();
		for (int i = 0; i < len; i++) {
			WebElement page = pages.get(i);
			click(page);
			Thread.sleep(5000);
			result.addAll(getLeadsDetailsFromOnePage());
		}
		logger.info(result);
		ExtentTestManager.getTest().log(LogStatus.PASS, "Retrived Lead Details from all Page");
		return result;
	}

	public List<List<String>> getLeadsDetailsFromOnePage() {
		List<WebElement> rows = getLeadRows;
		int len = rows.size();
		List<List<String>> textRows = new ArrayList<List<String>>();
		for (int i = 1; i < len; i++) {
			List<String> textRow = new ArrayList<String>();
			WebElement row = rows.get(i);
			List<WebElement> cols = row.findElements(By.xpath("./td"));
			for (WebElement col : cols) {
				String text = col.getText();
				text = text.replace("\n", "|");
				text = text.replace(",", "|");
				textRow.add(text);
			}
			textRows.add(textRow);
		}
		return textRows;
	}

	public LeadPageObjects createCampaignLeadsFile() throws Exception {
		String campaignName = appConfig.getCampaign();
		String campaignPath = "campaignFiles/ " + campaignName + "_Leads.csv";
		List<List<String>> campaignLeads = this.getLeadsDetailsFromAllPages();
		List<String> campaignLines = new ArrayList<String>();
		for (List<String> campaignLead : campaignLeads) {
			String eyeIcon = campaignLead.get(0);
			String leadsId = campaignLead.get(1);
			String tickIcon = campaignLead.get(2);
//			String rejectionReason = campaignLead.get(3);
//			String wrongIcon = campaignLead.get(4);
//			String redactionTest = campaignLead.get(5);
//			String email = campaignLead.get(6);
//			String title = campaignLead.get(7);
//			String firstName = campaignLead.get(8);
//			String lastName = campaignLead.get(9);
//			String Address1 = campaignLead.get(10);
//			String Address2 = campaignLead.get(11);
//			String Address3 = campaignLead.get(12);
//			String townCity = campaignLead.get(13);
//			String countryState = campaignLead.get(14);
//			String country = campaignLead.get(15);
//			String postalZipCode = campaignLead.get(16);
//			String telephone = campaignLead.get(17);
//			String userAgent = campaignLead.get(18);
//			String source = campaignLead.get(19);
//			String supplierLeadId = campaignLead.get(20);
//			String urlReferrer = campaignLead.get(21);
//			String startTime = campaignLead.get(22);
//			String endTime = campaignLead.get(23);
//			String fingerPrint = campaignLead.get(24);
//			String leadStatus = campaignLead.get(25);
//			String companyName = campaignLead.get(26);
//			String jobTitle = campaignLead.get(27);
//			String industry = campaignLead.get(28);
//			String platform = campaignLead.get(29);
//			String freeListFlag = campaignLead.get(30);
//			String assetTitle = campaignLead.get(31);
//			String comments = campaignLead.get(32);
//			String leadCreationDate = campaignLead.get(33);
//			String subSource = campaignLead.get(34);
//			String tactic = campaignLead.get(35);
//			String telephone2 = campaignLead.get(36);
//			String ADDRESS_C = campaignLead.get(37);
//			String ADDRESS_EVIDENCE = campaignLead.get(38);
//			String COMPANY_C = campaignLead.get(39);
//			String COMPANY_EVIDENCE = campaignLead.get(40);
//			String COMPANYSIZE_EVIDENCE = campaignLead.get(41);
//			String EMAIL_C = campaignLead.get(42);
//			String EMAIL_EVIDENCE = campaignLead.get(43);
//			String INDIVIDUAL_EVIDENCE = campaignLead.get(44);
//			String JOBTITLE_EVIDENCE = campaignLead.get(45);
//			String LINKEDIN_ID_URL = campaignLead.get(46);
//			String PHONE_C = campaignLead.get(47);
//			String PHONE_EVIDENCE = campaignLead.get(48);
//			String REJECTION_EVIDENCE = campaignLead.get(49);
//			String TURNOVER_EVIDENCE = campaignLead.get(50);
//			String UPDATE_DATE = campaignLead.get(51);
//			String COMPANY_SIZE = campaignLead.get(52);
//			String SWITCHING_TO_CLOUD = campaignLead.get(53);
//			String INTERNATIONAL_BUSINESS_PAYMENTS = campaignLead.get(54);
//			String TURNOVER = campaignLead.get(55);
//			String BREACH_DOCUMENTS = campaignLead.get(56);
//			String JOB_EXPERIENCE = campaignLead.get(57);
//			String PHONE2_EVIDENCE = campaignLead.get(58);
//			String VOICE_VERIFIED = campaignLead.get(59);
//			String JOB_FUNCTION = campaignLead.get(60);
//			String ANNUAL_FOREIGN_EXCHANGE = campaignLead.get(61);
//			String ANNUAL_REVENUE = campaignLead.get(62);
//			String PAYMENT_FREQUENCY = campaignLead.get(63);
//			String CALL_COMMENTS = campaignLead.get(64);
//			String INPUT_PLACEMENT = campaignLead.get(65);
//			String SECURE = campaignLead.get(66);
//			String LEAD_TYPE = campaignLead.get(67);
//			String JOB_ROLE = campaignLead.get(68);
//			String TimeStamp = campaignLead.get(69);
//			String Site = campaignLead.get(70);
//			String Placement = campaignLead.get(71);
//			String IPAddress = campaignLead.get(72);
//			String sub_id = campaignLead.get(73);
//			String CALLBACK_ID = campaignLead.get(74);
			String line = eyeIcon + ", " + leadsId + ", " + tickIcon;
//					+","+rejectionReason+","+wrongIcon+","+redactionTest+","+email+","+title+","+firstName+","+lastName+","+
//					Address1+","+Address2+","+Address3+","+townCity+","+countryState+","+country+","+postalZipCode+","+telephone+","+userAgent+","+source+","+
//					supplierLeadId+","+urlReferrer+","+startTime+","+endTime+","+fingerPrint+","+leadStatus+","+companyName+","+jobTitle+","+industry+","+platform+","+
//					freeListFlag+","+assetTitle+","+comments+","+leadCreationDate+","+subSource+","+tactic+","+telephone2+","+ADDRESS_C+","+ADDRESS_EVIDENCE+","+COMPANY_C+","+
//					COMPANY_EVIDENCE+","+COMPANYSIZE_EVIDENCE+","+EMAIL_C+","+EMAIL_EVIDENCE+","+INDIVIDUAL_EVIDENCE+","+JOBTITLE_EVIDENCE+","+LINKEDIN_ID_URL+","+PHONE_C+","+
//					PHONE_EVIDENCE+","+REJECTION_EVIDENCE+","+TURNOVER_EVIDENCE+","+UPDATE_DATE+","+COMPANY_SIZE+","+SWITCHING_TO_CLOUD+","+INTERNATIONAL_BUSINESS_PAYMENTS+","+
//					TURNOVER+","+BREACH_DOCUMENTS+","+JOB_EXPERIENCE+","+PHONE2_EVIDENCE+","+VOICE_VERIFIED+","+JOB_FUNCTION+","+ANNUAL_FOREIGN_EXCHANGE+","+ANNUAL_REVENUE+","+
//					PAYMENT_FREQUENCY+","+CALL_COMMENTS+","+INPUT_PLACEMENT+","+SECURE+","+LEAD_TYPE+","+JOB_ROLE+","+TimeStamp+","+Site+","+Placement+","+IPAddress+","+sub_id+","+CALLBACK_ID;
			campaignLines.add(line);
		}
		createCampaignFile(campaignLines, campaignPath, true);
		ExtentTestManager.getTest().log(LogStatus.PASS, "Campaign Lead File Created");
		return this;
	}

	public void readCampaignLeadsFile() throws Exception {
		String campaignName = appConfig.getCampaign();
		String campaignPath = "campaignFiles/" + campaignName + "_Leads.csv";
		List<String> leadsData = ExcelUtils.readFileToLines(campaignPath);
		setcampaignDataLines(leadsData);
		logger.info(leadsData);
	}

	public LeadPageObjects clickLeadsFromFile(String leadsLine) throws Exception {
		CampaignLeadsDataRecord leadsRecord = new CampaignLeadsDataRecord(leadsLine);
		String leadId = leadsRecord.getLeadsId();
		leadId = leadId.substring(leadId.length() - 9);
		logger.info(leadId);
		clickEditLead(leadId);
		return this;
	}

	public LeadPageObjects createCampaignFile(List<String> campaignLead, String campaignPath, boolean append)
			throws IOException {
		boolean fileExists = ExcelUtils.fileExist(campaignPath);
		String headerLine = campaignLead.get(0);
		if (!append || !fileExists) {
			ExcelUtils.writeToFile(campaignPath, headerLine);
		}
		int len = campaignLead.size();
		for (int i = 1; i < len; i++) {
			String line = campaignLead.get(i);
			ExcelUtils.appendToFile(campaignPath, line);
		}
		return this;
	}

	public LeadPageObjects clickEditLead(String leadId) throws Exception {
		WebElement editLead = getXpath("//td/span[contains(text(),'%s')]/../preceding-sibling::td/i", leadId);
		try {
			click(editLead);
			ExtentTestManager.getTest().log(LogStatus.PASS, leadId + " Clicked lead edit icon");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, leadId + " Unable to click lead edit icon " + e);
		}
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

	public LeadPageObjects clickEmailNoEvidenceFoundBtn() {
		try {
			click(emailNoEvidenceFoundBtn);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Clicked email NoEvidenceFound button");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to click email NoEvidenceFound button " + e);
		}
		return this;
	}

	public LeadPageObjects clickEmailIndirectEvidenceBtn() {
		try {
			click(emailIndirectEvidenceBtn);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Clicked email IndirectEvidence button");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to click email IndirectEvidence button " + e);
		}
		return this;
	}

	public LeadPageObjects clickPhoneCallVerifiedBtn() {
		try {
			click(phoneCallVerifiedBtn);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Clicked phone CallVerified button");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to click phone CallVerified button " + e);
		}
		return this;
	}

	public LeadPageObjects clickPhoneNoEvidenceFoundBtn() {
		try {
			click(phoneNoEvidenceFoundBtn);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Clicked phone NoEvidenceFound button");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to click phone NoEvidenceFound button " + e);
		}
		return this;
	}

	public LeadPageObjects clickPostcodeUpperCaseBtn() {
		try {
			click(postcodeUpperCaseBtn);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Clicked postcode UpperCase button");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to click postcode UpperCase button " + e);
		}
		return this;
	}

	public LeadPageObjects clickAddressNoEvidenceFoundBtn() {
		try {
			click(addressNoEvidenceFoundBtn);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Clicked address NoEvidenceFound button");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to click address NoEvidenceFound button " + e);
		}
		return this;
	}

	public LeadPageObjects clickAddressIndirectEvidenceBtn() {
		try {
			click(addressIndirectEvidenceBtn);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Clicked address IndirectEvidence button");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to click address IndirectEvidence button " + e);
		}
		return this;
	}

	public LeadPageObjects clickLinkedinIdUrlNoEvidenceFoundBtn() {
		try {
			click(linkedinIdUrlNoEvidenceFoundBtn);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Clicked linkedinIdUrl NoEvidenceFound button");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL,
					"Unable to click linkedinIdUrl NoEvidenceFound button " + e);
		}
		return this;
	}

	public LeadPageObjects clickJobTitleEvidenceCopyLinkedinUrlBtn() {
		try {
			click(jobTitleEvidenceCopyLinkedinUrlBtn);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Clicked jobTitleEvidence CopyLinkedinUrl button");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL,
					"Unable to click jobTitleEvidence CopyLinkedinUrl button " + e);
		}
		return this;
	}

	public LeadPageObjects clickJobTitleEvidenceCallVerifiedBtn() {
		try {
			click(jobTitleEvidenceCallVerifiedBtn);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Clicked jobTitleEvidence CallVerified button");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL,
					"Unable to click jobTitleEvidence CallVerified button " + e);
		}
		return this;
	}

	public LeadPageObjects clickJobTitleEvidenceNoEvidenceFoundBtn() {
		try {
			click(jobTitleEvidenceNoEvidenceFoundBtn);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Clicked jobTitleEvidence NoEvidenceFound button");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL,
					"Unable to click jobTitleEvidence NoEvidenceFound button " + e);
		}
		return this;
	}

	public LeadPageObjects clickCompanyNameTargetListMatch1() {
		try {
			click(companyNameTargetListMatch1);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Clicked companyName TargetListMatch1");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to click companyName TargetListMatch1 " + e);
		}
		return this;
	}

	public LeadPageObjects clickCompanyNameTargetListMatch2() {
		try {
			click(companyNameTargetListMatch2);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Clicked companyNameTarget ListMatch2");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to click companyName TargetListMatch2 " + e);
		}
		return this;
	}

	public LeadPageObjects clickCompanyNameTargetListMatch3() {
		try {
			click(companyNameTargetListMatch3);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Clicked companyName TargetListMatch3");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to click companyName TargetListMatch3 " + e);
		}
		return this;
	}

	public LeadPageObjects clickCompanyEvidenceCopyBtn() {
		try {
			click(companyEvidenceCopyBtn);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Clicked companyEvidence Copy button");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to click companyEvidence Copy button " + e);
		}
		return this;
	}

	public LeadPageObjects clickCompanyEvidencePasteBtn() {
		try {
			click(companyEvidencePasteBtn);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Clicked companyEvidence Paste button");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to click companyEvidence Paste button " + e);
		}
		return this;
	}

	public LeadPageObjects clickCompanyEvidenceUpperCaseBtn() {
		try {
			click(companyEvidenceUpperCaseBtn);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Clicked companyEvidence UpperCase button");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to click companyEvidence UpperCase button " + e);
		}
		return this;
	}

	public LeadPageObjects clickCompanyEvidenceProperCaseBtn() {
		try {
			click(companyEvidenceProperCaseBtn);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Clicked companyEvidence ProperCase button");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to click companyEvidence ProperCase button " + e);
		}
		return this;
	}

	public LeadPageObjects clickCompanySizeNoEvidenceFoundBtn() {
		try {
			click(companySizeNoEvidenceFoundBtn);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Clicked companySize NoEvidenceFound button");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to click companySize NoEvidenceFound button " + e);
		}

		return this;
	}

	public LeadPageObjects clickCompanySizeIndirectEvidenceBtn() {
		try {
			click(companySizeIndirectEvidenceBtn);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Clicked companySize IndirectEvidence button");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to click companySize IndirectEvidence button " + e);
		}
		return this;
	}

	public LeadPageObjects clickTurnoverNoEvidenceFoundBtn() {
		try {
			click(turnoverNoEvidenceFoundBtn);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Clicked turnover NoEvidenceFound button");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to click turnover NoEvidenceFound button " + e);
		}
		return this;
	}

	public LeadPageObjects clickTurnoverIndirectEvidenceBtn() {
		try {
			click(turnoverIndirectEvidenceBtn);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Clicked turnover IndirectEvidence button");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to click turnover IndirectEvidence button " + e);
		}
		return this;
	}

	public LeadPageObjects clickRejectionReasonJobtitleBtn() {
		try {
			click(rejectionReasonJobtitleBtn);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Clicked rejectionReason Jobtitle button");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to click rejectionReason Jobtitle button " + e);
		}
		return this;
	}

	public LeadPageObjects clickRejectionReasonCompanySizeBtn() {
		try {
			click(rejectionReasonCompanySizeBtn);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Clicked rejectionReason CompanySize button");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to click rejectionReason CompanySize button " + e);
		}
		return this;
	}

	public LeadPageObjects clickResetBtn() {
		try {
			click(resetBtn);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Clicked reset button");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to click reset button " + e);
		}
		return this;
	}

	public LeadPageObjects clickSaveBtn() {
		try {
			click(saveBtn);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Clicked save button");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to click save button " + e);
		}
		return this;
	}

	public LeadPageObjects clickSaveAndReverifyBtn() {
		try {
			click(saveAndReverifyBtn);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Clicked saveAndReverify button");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to click saveAndReverify button " + e);
		}
		return this;
	}

	public LeadPageObjects clickCloseBtn() {
		try {
			click(closeBtn);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Clicked close button");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to click close button " + e);
		}
		return this;
	}

	public String getvaluePlacementReadOly() {
		String value = getText(placementReadOly);
		try {
			if (value != null) {
				ExtentTestManager.getTest().log(LogStatus.PASS, "placementReadOly value is " + value);
			} else
				ExtentTestManager.getTest().log(LogStatus.INFO, "placementReadOly value is null");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to get value from placementReadOly " + e);
		}
		return value;
	}

	public String getvalueAssetReadOly() {
		String value = getText(assetReadOly);
		try {
			if (value != null) {
				ExtentTestManager.getTest().log(LogStatus.PASS, "assetReadOly value is " + value);
			} else
				ExtentTestManager.getTest().log(LogStatus.INFO, "assetReadOly value is null");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to get value from assetReadOly " + e);
		}
		return value;
	}

	public String getvalueLeadTypeReadOly() {
		String value = getText(leadTypeReadOly);
		try {
			if (value != null) {
				ExtentTestManager.getTest().log(LogStatus.PASS, "leadTypeReadOly value is " + value);
			} else
				ExtentTestManager.getTest().log(LogStatus.INFO, "leadTypeReadOly value is null");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to get value from leadTypeReadOly " + e);
		}
		return value;
	}

	public String getvalueCountryReadOly() {
		String value = getText(countryReadOly);
		try {
			if (value != null) {
				ExtentTestManager.getTest().log(LogStatus.PASS, "countryReadOly value is " + value);
			} else
				ExtentTestManager.getTest().log(LogStatus.INFO, "countryReadOly value is null");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to get value from countryReadOly " + e);
		}
		return value;
	}

	public LeadPageObjects setvalueLeadId(String value) {
		try {
			clear(leadId);
			sendKeys(leadId, value);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Value for leadId is set as " + value);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to set value for leadId " + e);
		}
		return this;
	}

	public String getvalueLeadId() {
		String value = getText(leadId);
		try {
			if (value != null) {
				ExtentTestManager.getTest().log(LogStatus.PASS, "leadId value is " + value);
			} else
				ExtentTestManager.getTest().log(LogStatus.INFO, "leadId value is null");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to get value from leadId " + e);
		}
		return value;
	}

	public LeadPageObjects setvalueEmail(String value) {
		try {
			clear(email);
			sendKeys(email, value);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Value for email is set as " + value);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to set value for email " + e);
		}
		return this;
	}

	public String getvalueEmail() {
		String value = getText(email);
		try {
			if (value != null) {
				ExtentTestManager.getTest().log(LogStatus.PASS, "email value is " + value);
			} else
				ExtentTestManager.getTest().log(LogStatus.INFO, "email value is null");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to get value from email " + e);
		}
		return value;
	}

	public LeadPageObjects setvalueEmailEvidence(String value) {
		try {
			clear(emailEvidence);
			sendKeys(emailEvidence, value);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Value for emailEvidence is set as " + value);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to set value for emailEvidence " + e);
		}
		return this;
	}

	public String getvalueEmailEvidence() {
		String value = getText(emailEvidence);
		try {
			if (value != null) {
				ExtentTestManager.getTest().log(LogStatus.PASS, "emailEvidence value is " + value);
			} else
				ExtentTestManager.getTest().log(LogStatus.INFO, "emailEvidence value is null");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to get value from emailEvidence " + e);
		}
		return value;
	}

	public LeadPageObjects setvalueTelephone(String value) {
		try {
			clear(telephone);
			sendKeys(telephone, value);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Value for telephone is set as " + value);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to set value for telephone " + e);
		}
		return this;
	}

	public String getvalueTelephone() {
		String value = getText(telephone);
		try {
			if (value != null) {
				ExtentTestManager.getTest().log(LogStatus.PASS, "telephone value is " + value);
			} else
				ExtentTestManager.getTest().log(LogStatus.INFO, "telephone value is null");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to get value from telephone " + e);
		}
		return value;
	}

	public LeadPageObjects setvaluePhoneEvidence(String value) {
		try {
			clear(phoneEvidence);
			sendKeys(phoneEvidence, value);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Value for phoneEvidence is set as " + value);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to set value for phoneEvidence " + e);
		}
		return this;
	}

	public String getvaluePhoneEvidence() {
		String value = getText(phoneEvidence);
		try {
			if (value != null) {
				ExtentTestManager.getTest().log(LogStatus.PASS, "phoneEvidence value is " + value);
			} else
				ExtentTestManager.getTest().log(LogStatus.INFO, "phoneEvidence value is null");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to get value from phoneEvidence " + e);
		}
		return value;
	}

	public LeadPageObjects setvalueTelephone2(String value) {
		try {
			clear(telephone2);
			sendKeys(telephone2, value);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Value for telephone2 is set as " + value);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to set value for telephone2 " + e);
		}
		return this;
	}

	public String getvalueTelephone2() {
		String value = getText(telephone2);
		try {
			if (value != null) {
				ExtentTestManager.getTest().log(LogStatus.PASS, "telephone2 value is " + value);
			} else
				ExtentTestManager.getTest().log(LogStatus.INFO, "telephone2 value is null");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to get value from telephone2 " + e);
		}
		return value;
	}

	public LeadPageObjects setvaluePhoneEvidence2(String value) {
		try {
			clear(phoneEvidence2);
			sendKeys(phoneEvidence2, value);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Value for phoneEvidence2 is set as " + value);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to set value for phoneEvidence2 " + e);
		}
		return this;
	}

	public String getvaluePhoneEvidence2() {
		String value = getText(phoneEvidence2);
		try {
			if (value != null) {
				ExtentTestManager.getTest().log(LogStatus.PASS, "phoneEvidence2 value is " + value);
			} else
				ExtentTestManager.getTest().log(LogStatus.INFO, "phoneEvidence2 value is null");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to get value from phoneEvidence2 " + e);
		}
		return value;
	}

	public LeadPageObjects setvalueAddress1(String value) {
		try {
			clear(address1);
			sendKeys(address1, value);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Value for address1 is set as " + value);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to set value for address1 " + e);
		}
		return this;
	}

	public String getvalueAddress1() {
		String value = getText(address1);
		try {
			if (value != null) {
				ExtentTestManager.getTest().log(LogStatus.PASS, "address1 value is " + value);
			} else
				ExtentTestManager.getTest().log(LogStatus.INFO, "address1 value is null");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to get value from address1 " + e);
		}
		return value;
	}

	public LeadPageObjects setvalueAddress2(String value) {
		try {
			clear(address2);
			sendKeys(address2, value);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Value for address2 is set as " + value);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to set value for address2 " + e);
		}
		return this;
	}

	public String getvalueAddress2() {
		String value = getText(address2);
		try {
			if (value != null) {
				ExtentTestManager.getTest().log(LogStatus.PASS, "address2 value is " + value);
			} else
				ExtentTestManager.getTest().log(LogStatus.INFO, "address2 value is null");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to get value from address2 " + e);
		}
		return value;
	}

	public LeadPageObjects setvalueTowncity(String value) {
		try {
			clear(towncity);
			sendKeys(towncity, value);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Value for towncity is set as " + value);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to set value for towncity " + e);
		}
		return this;
	}

	public String getvalueTowncity() {
		String value = getText(towncity);
		try {
			if (value != null) {
				ExtentTestManager.getTest().log(LogStatus.PASS, "towncity value is " + value);
			} else
				ExtentTestManager.getTest().log(LogStatus.INFO, "towncity value is null");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to get value from towncity " + e);
		}
		return value;
	}

	public LeadPageObjects setvalueCounty(String value) {
		try {
			clear(county);
			sendKeys(county, value);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Value for county is set as " + value);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to set value for county " + e);
		}
		return this;
	}

	public String getvalueCounty() {
		String value = getText(county);
		try {
			if (value != null) {
				ExtentTestManager.getTest().log(LogStatus.PASS, "county value is " + value);
			} else
				ExtentTestManager.getTest().log(LogStatus.INFO, "county value is null");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to get value from county " + e);
		}
		return value;
	}

	public LeadPageObjects setvaluePostcode(String value) {
		try {
			clear(postcode);
			sendKeys(postcode, value);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Value for postcode is set as " + value);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to set value for postcode " + e);
		}
		return this;
	}

	public String getvaluePostcode() {
		String value = getText(postcode);
		try {
			if (value != null) {
				ExtentTestManager.getTest().log(LogStatus.PASS, "postcode value is " + value);
			} else
				ExtentTestManager.getTest().log(LogStatus.INFO, "postcode value is null");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to get value from postcode " + e);
		}
		return value;
	}

	public LeadPageObjects setvalueCountry(String value) {
		try {
			clear(country);
			sendKeys(country, value);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Value for country is set as " + value);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to set value for country " + e);
		}
		return this;
	}

	public String getvalueCountry() {
		String value = getText(country);
		try {
			if (value != null) {
				ExtentTestManager.getTest().log(LogStatus.PASS, "country value is " + value);
			} else
				ExtentTestManager.getTest().log(LogStatus.INFO, "country value is null");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to get value from country " + e);
		}
		return value;
	}

	public LeadPageObjects setvalueAddressEvidence(String value) {
		try {
			clear(addressEvidence);
			sendKeys(addressEvidence, value);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Value for addressEvidence is set as " + value);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to set value for addressEvidence " + e);
		}
		return this;
	}

	public String getvalueAddressEvidence() {
		String value = getText(addressEvidence);
		try {
			if (value != null) {
				ExtentTestManager.getTest().log(LogStatus.PASS, "addressEvidence value is " + value);
			} else
				ExtentTestManager.getTest().log(LogStatus.INFO, "addressEvidence value is null");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to get value from addressEvidence " + e);
		}
		return value;
	}

	public LeadPageObjects setvalueFirstName(String value) {
		try {
			clear(firstName);
			sendKeys(firstName, value);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Value for firstName is set as " + value);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to set value for firstName " + e);
		}
		return this;
	}

	public String getvalueFirstName() {
		String value = getText(firstName);
		try {
			if (value != null) {
				ExtentTestManager.getTest().log(LogStatus.PASS, "firstName value is " + value);
			} else
				ExtentTestManager.getTest().log(LogStatus.INFO, "firstName value is null");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to get value from firstName " + e);
		}
		return value;
	}

	public LeadPageObjects setvalueLastName(String value) {
		try {
			clear(lastName);
			sendKeys(lastName, value);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Value for lastName is set as " + value);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to set value for lastName " + e);
		}
		return this;
	}

	public String getvalueLastName() {
		String value = getText(lastName);
		try {
			if (value != null) {
				ExtentTestManager.getTest().log(LogStatus.PASS, "lastName value is " + value);
			} else
				ExtentTestManager.getTest().log(LogStatus.INFO, "lastName value is null");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to get value from lastName " + e);
		}
		return value;
	}

	public LeadPageObjects setvalueLinkedinIdUrl(String value) {
		try {
			clear(linkedinIdUrl);
			sendKeys(linkedinIdUrl, value);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Value for linkedinIdUrl is set as " + value);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to set value for linkedinIdUrl " + e);
		}
		return this;
	}

	public String getvalueLinkedinIdUrl() {
		String value = getText(linkedinIdUrl);
		try {
			if (value != null) {
				ExtentTestManager.getTest().log(LogStatus.PASS, "linkedinIdUrl value is " + value);
			} else
				ExtentTestManager.getTest().log(LogStatus.INFO, "linkedinIdUrl value is null");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to get value from linkedinIdUrl " + e);
		}
		return value;
	}

	public LeadPageObjects setvalueJobTitle(String value) {
		try {
			clear(jobTitle);
			sendKeys(jobTitle, value);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Value for jobTitle is set as " + value);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to set value for jobTitle " + e);
		}
		return this;
	}

	public String getvalueJobTitle() {
		String value = getText(jobTitle);
		try {
			if (value != null) {
				ExtentTestManager.getTest().log(LogStatus.PASS, "jobTitle value is " + value);
			} else
				ExtentTestManager.getTest().log(LogStatus.INFO, "jobTitle value is null");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to get value from jobTitle " + e);
		}
		return value;
	}

	public LeadPageObjects setvalueJobTitleEvidence(String value) {
		try {
			clear(jobTitleEvidence);
			sendKeys(jobTitleEvidence, value);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Value for jobTitleEvidence is set as " + value);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to set value for jobTitleEvidence " + e);
		}
		return this;
	}

	public String getvalueJobTitleEvidence() {
		String value = getText(jobTitleEvidence);
		try {
			if (value != null) {
				ExtentTestManager.getTest().log(LogStatus.PASS, "jobTitleEvidence value is " + value);
			} else
				ExtentTestManager.getTest().log(LogStatus.INFO, "jobTitleEvidence value is null");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to get value from jobTitleEvidence " + e);
		}
		return value;
	}

	public LeadPageObjects setvalueJobFunction(String value) {
		try {
			clear(jobFunction);
			sendKeys(jobFunction, value);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Value for jobFunction is set as " + value);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to set value for jobFunction " + e);
		}
		return this;
	}

	public String getvalueJobFunction() {
		String value = getText(jobFunction);
		try {
			if (value != null) {
				ExtentTestManager.getTest().log(LogStatus.PASS, "jobFunction value is " + value);
			} else
				ExtentTestManager.getTest().log(LogStatus.INFO, "jobFunction value is null");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to get value from jobFunction " + e);
		}
		return value;
	}

	public LeadPageObjects setvalueCompanyName(String value) {
		try {
			clear(companyName);
			sendKeys(companyName, value);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Value for companyName is set as " + value);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to set value for companyName " + e);
		}
		return this;
	}

	public String getvalueCompanyName() {
		String value = getText(companyName);
		try {
			if (value != null) {
				ExtentTestManager.getTest().log(LogStatus.PASS, "companyName value is " + value);
			} else
				ExtentTestManager.getTest().log(LogStatus.INFO, "companyName value is null");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to get value from companyName " + e);
		}
		return value;
	}

	public String getvalueCompanyNameTargetListMatch1() {
		String value = getText(companyNameTargetListMatch1);
		try {
			if (value != null) {
				ExtentTestManager.getTest().log(LogStatus.PASS, "companyNameTargetListMatch1 value is " + value);
			} else
				ExtentTestManager.getTest().log(LogStatus.INFO, "companyNameTargetListMatch1 value is null");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL,
					"Unable to get value from companyNameTargetListMatch1 " + e);
		}
		return value;
	}

	public String getvalueCompanyNameTargetListMatch2() {
		String value = getText(companyNameTargetListMatch2);
		try {
			if (value != null) {
				ExtentTestManager.getTest().log(LogStatus.PASS, "companyNameTargetListMatch2 value is " + value);
			} else
				ExtentTestManager.getTest().log(LogStatus.INFO, "companyNameTargetListMatch2 value is null");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL,
					"Unable to get value from companyNameTargetListMatch2 " + e);
		}
		return value;
	}

	public String getvalueCompanyNameTargetListMatch3() {
		String value = getText(companyNameTargetListMatch3);
		try {
			if (value != null) {
				ExtentTestManager.getTest().log(LogStatus.PASS, "companyNameTargetListMatch3 value is " + value);
			} else
				ExtentTestManager.getTest().log(LogStatus.INFO, "companyNameTargetListMatch3 value is null");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL,
					"Unable to get value from companyNameTargetListMatch3 " + e);
		}
		return value;
	}

	public LeadPageObjects setvalueIndustry(String value) {
		try {
			clear(industry);
			sendKeys(industry, value);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Value for industry is set as " + value);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to set value for industry " + e);
		}
		return this;
	}

	public String getvalueIndustry() {
		String value = getText(industry);
		try {
			if (value != null) {
				ExtentTestManager.getTest().log(LogStatus.PASS, "industry value is " + value);
			} else
				ExtentTestManager.getTest().log(LogStatus.INFO, "industry value is null");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to get value from industry " + e);
		}
		return value;
	}

	public LeadPageObjects setvalueCompanyEvidence(String value) {
		try {
			clear(companyEvidence);
			sendKeys(companyEvidence, value);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Value for companyEvidence is set as " + value);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to set value for companyEvidence " + e);
		}
		return this;
	}

	public String getvalueCompanyEvidence() {
		String value = getText(companyEvidence);
		try {
			if (value != null) {
				ExtentTestManager.getTest().log(LogStatus.PASS, "companyEvidence value is " + value);
			} else
				ExtentTestManager.getTest().log(LogStatus.INFO, "companyEvidence value is null");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to get value from companyEvidence " + e);
		}
		return value;
	}

	public LeadPageObjects setvalueCompanySize(String value) {
		try {
			clear(companySize);
			sendKeys(companySize, value);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Value for companySize is set as " + value);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to set value for companySize " + e);
		}
		return this;
	}

	public String getvalueCompanySize() {
		String value = getText(companySize);
		try {
			if (value != null) {
				ExtentTestManager.getTest().log(LogStatus.PASS, "companySize value is " + value);
			} else
				ExtentTestManager.getTest().log(LogStatus.INFO, "companySize value is null");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to get value from companySize " + e);
		}
		return value;
	}

	public LeadPageObjects setvalueCompanySizeEvidence(String value) {
		try {
			clear(companySizeEvidence);
			sendKeys(companySizeEvidence, value);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Value for companySizeEvidence is set as " + value);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to set value for companySizeEvidence " + e);
		}
		return this;
	}

	public String getvalueCompanySizeEvidence() {
		String value = getText(companySizeEvidence);
		try {
			if (value != null) {
				ExtentTestManager.getTest().log(LogStatus.PASS, "companySizeEvidence value is " + value);
			} else
				ExtentTestManager.getTest().log(LogStatus.INFO, "companySizeEvidence value is null");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to get value from companySizeEvidence " + e);
		}
		return value;
	}

	public LeadPageObjects setvalueTurnover(String value) {
		try {
			clear(turnover);
			sendKeys(turnover, value);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Value for turnover is set as " + value);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to set value for turnover " + e);
		}
		return this;
	}

	public String getvalueTurnover() {
		String value = getText(turnover);
		try {
			if (value != null) {
				ExtentTestManager.getTest().log(LogStatus.PASS, "turnover value is " + value);
			} else
				ExtentTestManager.getTest().log(LogStatus.INFO, "turnover value is null");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to get value from turnover " + e);
		}
		return value;
	}

	public LeadPageObjects setvalueTurnoverEvidence(String value) {
		try {
			clear(turnoverEvidence);
			sendKeys(turnoverEvidence, value);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Value for turnoverEvidence is set as " + value);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to set value for turnoverEvidence " + e);
		}
		return this;
	}

	public String getvalueTurnoverEvidence() {
		String value = getText(turnoverEvidence);
		try {
			if (value != null) {
				ExtentTestManager.getTest().log(LogStatus.PASS, "turnoverEvidence value is " + value);
			} else
				ExtentTestManager.getTest().log(LogStatus.INFO, "turnoverEvidence value is null");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to get value from turnoverEvidence " + e);
		}
		return value;
	}

	public LeadPageObjects setvalueRejectionReason(String value) {
		try {
			clear(rejectionReason);
			sendKeys(rejectionReason, value);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Value for rejectionReason is set as " + value);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to set value for rejectionReason " + e);
		}
		return this;
	}

	public String getvalueRejectionReason() {
		String value = getText(rejectionReason);
		try {
			if (value != null) {
				ExtentTestManager.getTest().log(LogStatus.PASS, "rejectionReason value is " + value);
			} else
				ExtentTestManager.getTest().log(LogStatus.INFO, "rejectionReason value is null");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to get value from rejectionReason " + e);
		}
		return value;
	}

	public LeadPageObjects setvalueRejectionReasonEvidence(String value) {
		try {
			clear(rejectionReasonEvidence);
			sendKeys(rejectionReasonEvidence, value);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Value for rejectionReasonEvidence is set as " + value);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to set value for rejectionReasonEvidence " + e);
		}
		return this;
	}

	public String getvalueRejectionReasonEvidence() {
		String value = getText(rejectionReasonEvidence);
		try {
			if (value != null) {
				ExtentTestManager.getTest().log(LogStatus.PASS, "rejectionReasonEvidence value is " + value);
			} else
				ExtentTestManager.getTest().log(LogStatus.INFO, "rejectionReasonEvidence value is null");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to get value from rejectionReasonEvidence " + e);
		}
		return value;
	}

	public LeadPageObjects setvalueUserAgent(String value) {
		try {
			clear(userAgent);
			sendKeys(userAgent, value);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Value for userAgent is set as " + value);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to set value for userAgent " + e);
		}
		return this;
	}

	public String getvalueUserAgent() {
		String value = getText(userAgent);
		try {
			if (value != null) {
				ExtentTestManager.getTest().log(LogStatus.PASS, "userAgent value is " + value);
			} else
				ExtentTestManager.getTest().log(LogStatus.INFO, "userAgent value is null");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to get value from userAgent " + e);
		}
		return value;
	}

	public LeadPageObjects setvalueLeadType(String value) {
		try {
			clear(leadType);
			sendKeys(leadType, value);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Value for leadType is set as " + value);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to set value for leadType " + e);
		}
		return this;
	}

	public String getvalueLeadType() {
		String value = getText(leadType);
		try {
			if (value != null) {
				ExtentTestManager.getTest().log(LogStatus.PASS, "leadType value is " + value);
			} else
				ExtentTestManager.getTest().log(LogStatus.INFO, "leadType value is null");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to get value from leadType " + e);
		}
		return value;
	}

	public LeadPageObjects setvalueSfdcCode(String value) {
		try {
			clear(sfdcCode);
			sendKeys(sfdcCode, value);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Value for sfdcCode is set as " + value);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to set value for sfdcCode " + e);
		}
		return this;
	}

	public String getvalueSfdcCode() {
		String value = getText(sfdcCode);
		try {
			if (value != null) {
				ExtentTestManager.getTest().log(LogStatus.PASS, "sfdcCode value is " + value);
			} else
				ExtentTestManager.getTest().log(LogStatus.INFO, "sfdcCode value is null");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to get value from sfdcCode " + e);
		}
		return value;
	}

	public LeadPageObjects setvalueProductOfInterest(String value) {
		try {
			clear(productOfInterest);
			sendKeys(productOfInterest, value);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Value for productOfInterest is set as " + value);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to set value for productOfInterest " + e);
		}
		return this;
	}

	public String getvalueProductOfInterest() {
		String value = getText(productOfInterest);
		try {
			if (value != null) {
				ExtentTestManager.getTest().log(LogStatus.PASS, "productOfInterest value is " + value);
			} else
				ExtentTestManager.getTest().log(LogStatus.INFO, "productOfInterest value is null");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to get value from productOfInterest " + e);
		}
		return value;
	}

	public LeadPageObjects setvalueCallComments(String value) {
		try {
			clear(callComments);
			sendKeys(callComments, value);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Value for callComments is set as " + value);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to set value for callComments " + e);
		}
		return this;
	}

	public String getvalueCallComments() {
		String value = getText(callComments);
		try {
			if (value != null) {
				ExtentTestManager.getTest().log(LogStatus.PASS, "callComments value is " + value);
			} else
				ExtentTestManager.getTest().log(LogStatus.INFO, "callComments value is null");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to get value from callComments " + e);
		}
		return value;
	}

	public LeadPageObjects setvalueSecure(String value) {
		try {
			clear(secure);
			sendKeys(secure, value);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Value for secure is set as " + value);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to set value for secure " + e);
		}
		return this;
	}

	public String getvalueSecure() {
		String value = getText(secure);
		try {
			if (value != null) {
				ExtentTestManager.getTest().log(LogStatus.PASS, "secure value is " + value);
			} else
				ExtentTestManager.getTest().log(LogStatus.INFO, "secure value is null");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to get value from secure " + e);
		}
		return value;
	}

	public LeadPageObjects setvalueBiggestChallenge(String value) {
		try {
			clear(biggestChallenge);
			sendKeys(biggestChallenge, value);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Value for biggestChallenge is set as " + value);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to set value for biggestChallenge " + e);
		}
		return this;
	}

	public String getvalueBiggestChallenge() {
		String value = getText(biggestChallenge);
		try {
			if (value != null) {
				ExtentTestManager.getTest().log(LogStatus.PASS, "biggestChallenge value is " + value);
			} else
				ExtentTestManager.getTest().log(LogStatus.INFO, "biggestChallenge value is null");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to get value from biggestChallenge " + e);
		}
		return value;
	}

	public LeadPageObjects setvalueWhichPlatforms(String value) {
		try {
			clear(whichPlatforms);
			sendKeys(whichPlatforms, value);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Value for whichPlatforms is set as " + value);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to set value for whichPlatforms " + e);
		}
		return this;
	}

	public String getvalueWhichPlatforms() {
		String value = getText(whichPlatforms);
		try {
			if (value != null) {
				ExtentTestManager.getTest().log(LogStatus.PASS, "whichPlatforms value is " + value);
			} else
				ExtentTestManager.getTest().log(LogStatus.INFO, "whichPlatforms value is null");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to get value from whichPlatforms " + e);
		}
		return value;
	}

	public LeadPageObjects selectvalueEmailToolsDropdown(String value) {
		try {
			selectByVisibleText(emailToolsDropdown, value);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Selected value from emailToolsDropdown is " + value);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to select value from emailToolsDropdown " + e);
		}
		return this;
	}

	public LeadPageObjects selectvaluePhoneReformatDropdown(String value) {
		try {
			selectByVisibleText(phoneReformatDropdown, value);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Selected value from phoneReformatDropdown is " + value);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to select value from phoneReformatDropdown " + e);
		}
		return this;
	}

	public LeadPageObjects selectvaluePhoneToolsDropdown(String value) {
		try {
			selectByVisibleText(phoneToolsDropdown, value);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Selected value from phoneToolsDropdown is " + value);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to select value from phoneToolsDropdown " + e);
		}
		return this;
	}

	public LeadPageObjects selectvaluePhoneReformatDropdown2(String value) {
		try {
			selectByVisibleText(phoneReformatDropdown2, value);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Selected value from phoneReformatDropdown2 is " + value);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to select value from phoneReformatDropdown2 " + e);
		}
		return this;
	}

	public LeadPageObjects selectvalueCountryDropdown(String value) {
		try {
			selectByVisibleText(countryDropdown, value);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Selected value from countryDropdown is " + value);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to select value from countryDropdown " + e);
		}
		return this;
	}

	public LeadPageObjects selectvalueJobTitleDropdown(String value) {
		try {
			selectByVisibleText(jobTitleDropdown, value);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Value for jobTitleDropdown is set as " + value);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to select value from jobTitleDropdown " + e);
		}
		return this;
	}

	public LeadPageObjects selectvalueJobFunctionDropdown(String value) {
		try {
			selectByVisibleText(jobFunctionDropdown, value);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Selected value from jobFunctionDropdown is " + value);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to select value from jobFunctionDropdown " + e);
		}
		return this;
	}

	public LeadPageObjects selectvalueCompanyToolsDropdown(String value) {
		try {
			selectByVisibleText(companyToolsDropdown, value);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Selected value from companyToolsDropdown is " + value);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to select value from companyToolsDropdown " + e);
		}
		return this;
	}

	public LeadPageObjects selectvalueIndustryDropdown(String value) {
		try {
			selectByVisibleText(industryDropdown, value);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Selected value from industryDropdown is " + value);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to select value from industryDropdown " + e);
		}
		return this;
	}

	public LeadPageObjects selectvalueCompanySizeDropDown(String value) {
		try {
			selectByVisibleText(companySizeDropDown, value);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Selected value from companySizeDropDown is " + value);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to select value from companySizeDropDown " + e);
		}
		return this;
	}

	public LeadPageObjects selectvalueTurnoverDropdown(String value) {
		try {
			selectByVisibleText(turnoverDropdown, value);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Selected value from turnoverDropdown is " + value);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to select value from turnoverDropdown " + e);
		}
		return this;
	}

	public LeadPageObjects selectvalueTurnoverCompanyToolsDropdown(String value) {
		try {
			selectByVisibleText(turnoverCompanyToolsDropdown, value);
			ExtentTestManager.getTest().log(LogStatus.PASS,
					"Selected value from turnoverCompanyToolsDropdown is " + value);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL,
					"Unable to select value from turnoverCompanyToolsDropdown " + e);
		}
		return this;
	}

	public LeadPageObjects selectvalueRejectionReasonDropdown(String value) {
		try {
			selectByVisibleText(rejectionReasonDropdown, value);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Selected value from rejectionReasonDropdown is " + value);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to select value from rejectionReasonDropdown " + e);
		}
		return this;
	}

	public LeadPageObjects selectvalueCallCommentsDropDown(String value) {
		try {
			selectByVisibleText(callCommentsDropDown, value);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Selected value from callCommentsDropDown is " + value);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to select value from callCommentsDropDown " + e);
		}
		return this;
	}
	
	public LeadPageObjects setTestDataCheck() {
			String country = getLeadsCountry();
			logger.info("country Test data value check is: "+country);
			String companySize = getLeadsCompanySize();
			logger.info("companySize Test data value check is: "+companySize);
			String industrial = getLeadsIndustrialVertical();
			logger.info("industrial Test data value check is: "+industrial);
			String jobFunction = getLeadsJobFunction();
			logger.info("jobFunction Test data value check is: "+jobFunction);
			String jobTitle = getLeadsJobTitle();
			logger.info("jobTitle Test data value check is: "+jobTitle);
			ExtentTestManager.getTest().log(LogStatus.INFO, "Test data value check is: ");
		return this;
	}

}

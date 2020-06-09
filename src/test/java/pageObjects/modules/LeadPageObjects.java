package pageObjects.modules;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import utils.ExplicitWaiting;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pageObjects.initializePageObjects.PageFactoryInitializer;
import tests.campaign.leads.PlacementReadOnly;
import tests.campaign.process.CampaignLeadsDataRecord;
import utils.ExcelUtils;
import utils.ExtentReports.ExtentTestManager;
import com.relevantcodes.extentreports.LogStatus;

public class LeadPageObjects extends PageFactoryInitializer {
	private Logger logger = Logger.getLogger(LeadPageObjects.class.getName());

	@FindBy(css = "div#editLeadNew table#tablecustom tbody tr td:nth-child(1) span")
	private WebElement placementReadOly;

	@FindBy(css = "div#editLeadNew table#tablecustom tbody tr td:nth-child(2) span")
	private WebElement assetReadOly;

	@FindBy(css = "div#editLeadNew table#tablecustom tbody tr td:nth-child(3) span")
	private WebElement leadTypeReadOly;

	@FindBy(css = "div#editLeadNew table#tablecustom tbody tr td:nth-child(4) span")
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
	protected WebElement linkedinIdUrlNoEvidenceFoundBtn;

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

	@FindBy(css = "input[name='job_function'] + div>select")
	private WebElement jobFunctionDropdown;

	@FindBy(css = "input[name='job_role']")
	private WebElement jobRole;

	@FindBy(css = "input[name='job_role'] + div>select")
	private WebElement jobRoleDropdown;

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
	private WebElement companySizeDropdown;

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
//			String tactics = campaignLead.get(35);
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
//					freeListFlag+","+assetTitle+","+comments+","+leadCreationDate+","+subSource+","+tactics+","+telephone2+","+ADDRESS_C+","+ADDRESS_EVIDENCE+","+COMPANY_C+","+
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
		campaignTestDataProcess().setcampaignDataLines(leadsData);
		logger.info(leadsData);
	}

	public LeadPageObjects clickLeadsFromFile(String leadsLine) throws Exception {
		CampaignLeadsDataRecord leadsRecord = new CampaignLeadsDataRecord(leadsLine);
		String leadId = leadsRecord.getLeadsId();
		leadId = leadId.substring(leadId.length() - 9);
		logger.info(leadId);
		try {
			clickEditLead(leadId);
			String companySizeDropdownType = getFirstvalueFromDropdown(companySizeDropdown);
			campaignTestDataProcess().setCompanySizeDropdownType(companySizeDropdownType);
			String turnoverDropdownType = getFirstvalueFromDropdown(turnoverDropdown);
			campaignTestDataProcess().setTurnOverDropdownType(turnoverDropdownType);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Clicked lead id " + leadId);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to click lead id " + leadId + e);
		}
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
		switchToDefaultBrowser();
		if (closeBtn.isDisplayed()) {
			click(closeBtn);
		}
		WebElement editLead = getXpath("//td/span[contains(text(),'%s')]/../preceding-sibling::td/i", leadId);
		ExplicitWaiting.explicitWaitVisibilityOfElement(editLead, 15);
		try {
			Thread.sleep(3000);
			ExplicitWaiting.explicitWaitVisibilityOfElement(editLead, 15);
			click(editLead);
			ExtentTestManager.getTest().log(LogStatus.PASS, leadId + " Clicked lead edit icon");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, leadId + " Unable to click lead edit icon " + e);
		}
		return this;
	}

	public LeadPageObjects clickEmailNoEvidenceFoundBtn() throws Exception {
		try {
			ExplicitWaiting.explicitWaitVisibilityOfElement(emailNoEvidenceFoundBtn, 15);
			click(emailNoEvidenceFoundBtn);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Clicked email NoEvidenceFound button");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to click email NoEvidenceFound button " + e);
		}
		return this;
	}

	public LeadPageObjects clickEmailIndirectEvidenceBtn() throws Exception {
		try {
			ExplicitWaiting.explicitWaitVisibilityOfElement(emailIndirectEvidenceBtn, 15);
			click(emailIndirectEvidenceBtn);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Clicked email IndirectEvidence button");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to click email IndirectEvidence button " + e);
		}
		return this;
	}

	public LeadPageObjects clickPhoneCallVerifiedBtn() throws Exception {
		try {
			ExplicitWaiting.explicitWaitVisibilityOfElement(phoneCallVerifiedBtn, 15);
			click(phoneCallVerifiedBtn);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Clicked phone CallVerified button");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to click phone CallVerified button " + e);
		}
		return this;
	}

	public LeadPageObjects clickPhoneNoEvidenceFoundBtn() throws Exception {
		try {
			ExplicitWaiting.explicitWaitVisibilityOfElement(phoneNoEvidenceFoundBtn, 15);
			click(phoneNoEvidenceFoundBtn);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Clicked phone NoEvidenceFound button");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to click phone NoEvidenceFound button " + e);
		}
		return this;
	}

	public LeadPageObjects clickPostcodeUpperCaseBtn() throws Exception {
		try {
			ExplicitWaiting.explicitWaitVisibilityOfElement(postcodeUpperCaseBtn, 15);
			click(postcodeUpperCaseBtn);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Clicked postcode UpperCase button");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to click postcode UpperCase button " + e);
		}
		return this;
	}

	public LeadPageObjects clickAddressNoEvidenceFoundBtn() throws Exception {
		try {
			ExplicitWaiting.explicitWaitVisibilityOfElement(addressNoEvidenceFoundBtn, 15);
			click(addressNoEvidenceFoundBtn);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Clicked address NoEvidenceFound button");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to click address NoEvidenceFound button " + e);
		}
		return this;
	}

	public LeadPageObjects clickAddressIndirectEvidenceBtn() throws Exception {
		try {
			ExplicitWaiting.explicitWaitVisibilityOfElement(addressIndirectEvidenceBtn, 15);
			click(addressIndirectEvidenceBtn);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Clicked address IndirectEvidence button");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to click address IndirectEvidence button " + e);
		}
		return this;
	}

	public LeadPageObjects clickLinkedinIdUrlNoEvidenceFoundBtn() throws Exception {
		try {
			ExplicitWaiting.explicitWaitVisibilityOfElement(linkedinIdUrlNoEvidenceFoundBtn, 15);
			click(linkedinIdUrlNoEvidenceFoundBtn);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Clicked linkedinIdUrl NoEvidenceFound button");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL,
					"Unable to click linkedinIdUrl NoEvidenceFound button " + e);
		}
		return this;
	}

	public LeadPageObjects clickJobTitleEvidenceCopyLinkedinUrlBtn() throws Exception {
		try {
			ExplicitWaiting.explicitWaitVisibilityOfElement(jobTitleEvidenceCopyLinkedinUrlBtn, 15);
			click(jobTitleEvidenceCopyLinkedinUrlBtn);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Clicked jobTitleEvidence CopyLinkedinUrl button");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL,
					"Unable to click jobTitleEvidence CopyLinkedinUrl button " + e);
		}
		return this;
	}

	public LeadPageObjects clickJobTitleEvidenceCallVerifiedBtn() throws Exception {
		try {
			ExplicitWaiting.explicitWaitVisibilityOfElement(jobTitleEvidenceCallVerifiedBtn, 15);
			click(jobTitleEvidenceCallVerifiedBtn);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Clicked jobTitleEvidence CallVerified button");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL,
					"Unable to click jobTitleEvidence CallVerified button " + e);
		}
		return this;
	}

	public LeadPageObjects clickJobTitleEvidenceNoEvidenceFoundBtn() throws Exception {
		try {
			ExplicitWaiting.explicitWaitVisibilityOfElement(jobTitleEvidenceNoEvidenceFoundBtn, 15);
			click(jobTitleEvidenceNoEvidenceFoundBtn);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Clicked jobTitleEvidence NoEvidenceFound button");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL,
					"Unable to click jobTitleEvidence NoEvidenceFound button " + e);
		}
		return this;
	}

	public LeadPageObjects clickCompanyNameTargetListMatch1() throws Exception {
		try {
			ExplicitWaiting.explicitWaitVisibilityOfElement(companyNameTargetListMatch1, 15);
			click(companyNameTargetListMatch1);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Clicked companyName TargetListMatch1");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to click companyName TargetListMatch1 " + e);
		}
		return this;
	}

	public LeadPageObjects clickCompanyNameTargetListMatch2() throws Exception {
		try {
			ExplicitWaiting.explicitWaitVisibilityOfElement(companyNameTargetListMatch2, 15);
			click(companyNameTargetListMatch2);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Clicked companyNameTarget ListMatch2");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to click companyName TargetListMatch2 " + e);
		}
		return this;
	}

	public LeadPageObjects clickCompanyNameTargetListMatch3() throws Exception {
		try {
			ExplicitWaiting.explicitWaitVisibilityOfElement(companyNameTargetListMatch3, 15);
			click(companyNameTargetListMatch3);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Clicked companyName TargetListMatch3");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to click companyName TargetListMatch3 " + e);
		}
		return this;
	}

	public LeadPageObjects clickCompanyEvidenceCopyBtn() throws Exception {
		try {
			ExplicitWaiting.explicitWaitVisibilityOfElement(companyEvidenceCopyBtn, 15);
			click(companyEvidenceCopyBtn);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Clicked companyEvidence Copy button");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to click companyEvidence Copy button " + e);
		}
		return this;
	}

	public LeadPageObjects clickCompanyEvidencePasteBtn() throws Exception {
		try {
			ExplicitWaiting.explicitWaitVisibilityOfElement(companyEvidencePasteBtn, 15);
			click(companyEvidencePasteBtn);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Clicked companyEvidence Paste button");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to click companyEvidence Paste button " + e);
		}
		return this;
	}

	public LeadPageObjects clickCompanyEvidenceUpperCaseBtn() throws Exception {
		try {
			ExplicitWaiting.explicitWaitVisibilityOfElement(companyEvidenceUpperCaseBtn, 15);
			click(companyEvidenceUpperCaseBtn);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Clicked companyEvidence UpperCase button");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to click companyEvidence UpperCase button " + e);
		}
		return this;
	}

	public LeadPageObjects clickCompanyEvidenceProperCaseBtn() throws Exception {
		try {
			ExplicitWaiting.explicitWaitVisibilityOfElement(companyEvidenceProperCaseBtn, 15);
			click(companyEvidenceProperCaseBtn);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Clicked companyEvidence ProperCase button");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to click companyEvidence ProperCase button " + e);
		}
		return this;
	}

	public LeadPageObjects clickCompanySizeNoEvidenceFoundBtn() throws Exception {
		try {
			ExplicitWaiting.explicitWaitVisibilityOfElement(companySizeNoEvidenceFoundBtn, 15);
			click(companySizeNoEvidenceFoundBtn);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Clicked companySize NoEvidenceFound button");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to click companySize NoEvidenceFound button " + e);
		}

		return this;
	}

	public LeadPageObjects clickCompanySizeIndirectEvidenceBtn() throws Exception {
		try {
			ExplicitWaiting.explicitWaitVisibilityOfElement(companySizeIndirectEvidenceBtn, 15);
			click(companySizeIndirectEvidenceBtn);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Clicked companySize IndirectEvidence button");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to click companySize IndirectEvidence button " + e);
		}
		return this;
	}

	public LeadPageObjects clickTurnoverNoEvidenceFoundBtn() throws Exception {
		try {
			ExplicitWaiting.explicitWaitVisibilityOfElement(turnoverNoEvidenceFoundBtn, 15);
			click(turnoverNoEvidenceFoundBtn);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Clicked turnover NoEvidenceFound button");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to click turnover NoEvidenceFound button " + e);
		}
		return this;
	}

	public LeadPageObjects clickTurnoverIndirectEvidenceBtn() throws Exception {
		try {
			ExplicitWaiting.explicitWaitVisibilityOfElement(turnoverIndirectEvidenceBtn, 15);
			click(turnoverIndirectEvidenceBtn);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Clicked turnover IndirectEvidence button");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to click turnover IndirectEvidence button " + e);
		}
		return this;
	}

	public LeadPageObjects clickRejectionReasonJobtitleBtn() throws Exception {
		try {
			ExplicitWaiting.explicitWaitVisibilityOfElement(rejectionReasonJobtitleBtn, 15);
			click(rejectionReasonJobtitleBtn);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Clicked rejectionReason Jobtitle button");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to click rejectionReason Jobtitle button " + e);
		}
		return this;
	}

	public LeadPageObjects clickRejectionReasonCompanySizeBtn() throws Exception {
		try {
			ExplicitWaiting.explicitWaitVisibilityOfElement(rejectionReasonCompanySizeBtn, 15);
			click(rejectionReasonCompanySizeBtn);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Clicked rejectionReason CompanySize button");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to click rejectionReason CompanySize button " + e);
		}
		return this;
	}

	public LeadPageObjects clickResetBtn() throws Exception {
		try {
			ExplicitWaiting.explicitWaitVisibilityOfElement(resetBtn, 15);
			click(resetBtn);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Clicked reset button");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to click reset button " + e);
		}
		return this;
	}

	public LeadPageObjects clickSaveBtn() throws Exception {
		try {
			ExplicitWaiting.explicitWaitVisibilityOfElement(saveBtn, 15);
			scrollDown();
			click(saveBtn);
			ExtentTestManager.getTest().log(LogStatus.INFO, "Clicked save button");
			if (isAlertPresent()) {
				Alert alert = getWebDriver().switchTo().alert();
				System.out.println(alert.getText());
				ExtentTestManager.getTest().log(LogStatus.INFO, "Alert popped up" + alert.getText());
				alert.accept();
				if (closeBtn.isDisplayed()) {
					click(closeBtn);
				}
			} else {
				ExtentTestManager.getTest().log(LogStatus.PASS, "Saved the Lead");
			}
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to click save button " + e);
		}
		return this;
	}

	public LeadPageObjects clickSaveAndReverifyBtn() throws Exception {
		try {
			ExplicitWaiting.explicitWaitVisibilityOfElement(saveAndReverifyBtn, 15);
			click(saveAndReverifyBtn);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Clicked saveAndReverify button");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to click saveAndReverify button " + e);
		}
		return this;
	}

	public LeadPageObjects clickCloseBtn() throws Exception {
		try {
			ExplicitWaiting.explicitWaitVisibilityOfElement(closeBtn, 15);
			click(closeBtn);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Clicked close button");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to click close button " + e);
		}
		return this;
	}

	public String getvaluePlacementReadOly() throws Exception {
		ExplicitWaiting.explicitWaitVisibilityOfElement(placementReadOly, 15);
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

	public String getvalueAssetReadOly() throws Exception {
		String value = getText(assetReadOly);
		ExplicitWaiting.explicitWaitVisibilityOfElement(assetReadOly, 15);
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

	public String getvalueLeadTypeReadOly() throws Exception {
		ExplicitWaiting.explicitWaitVisibilityOfElement(leadTypeReadOly, 15);
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

	public String getvalueCountryReadOly() throws Exception {
		ExplicitWaiting.explicitWaitVisibilityOfElement(countryReadOly, 15);
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

	public LeadPageObjects setvalueLeadId(String value) throws Exception {
		try {
			ExplicitWaiting.explicitWaitVisibilityOfElement(leadId, 15);
			clear(leadId);
			sendKeys(leadId, value);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Value for leadId is set as " + value);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to set value for leadId " + e);
		}
		return this;
	}

	public String getvalueLeadId() throws Exception {
		ExplicitWaiting.explicitWaitVisibilityOfElement(leadId, 15);
		String value = getTextUsingScript("meritleadid");
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

	public LeadPageObjects setvalueEmail(String value) throws Exception {
		try {
			ExplicitWaiting.explicitWaitVisibilityOfElement(email, 15);
			clear(email);
			sendKeys(email, value);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Value for email is set as " + value);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to set value for email " + e);
		}
		return this;
	}

	public String getvalueEmail() throws Exception {
		ExplicitWaiting.explicitWaitVisibilityOfElement(email, 15);
		String value = getTextUsingScript("email");
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

	public LeadPageObjects setvalueEmailEvidence(String value) throws Exception {
		try {
			ExplicitWaiting.explicitWaitVisibilityOfElement(emailEvidence, 15);
			clear(emailEvidence);
			sendKeys(emailEvidence, value);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Value for emailEvidence is set as " + value);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to set value for emailEvidence " + e);
		}
		return this;
	}

	public String getvalueEmailEvidence() throws Exception {
		ExplicitWaiting.explicitWaitVisibilityOfElement(emailEvidence, 15);
		String value = getTextUsingScript("email_evidence");
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

	public LeadPageObjects setvalueTelephone(String value) throws Exception {
		try {
			ExplicitWaiting.explicitWaitVisibilityOfElement(telephone, 15);
			clear(telephone);
			sendKeys(telephone, value);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Value for telephone is set as " + value);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to set value for telephone " + e);
		}
		return this;
	}

	public String getvalueTelephone() throws Exception {
		ExplicitWaiting.explicitWaitVisibilityOfElement(telephone, 15);
		String value = getTextUsingScript("telephone");
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

	public LeadPageObjects setvaluePhoneEvidence(String value) throws Exception {
		try {
			ExplicitWaiting.explicitWaitVisibilityOfElement(phoneEvidence, 15);
			clear(phoneEvidence);
			sendKeys(phoneEvidence, value);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Value for phoneEvidence is set as " + value);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to set value for phoneEvidence " + e);
		}
		return this;
	}

	public String getvaluePhoneEvidence() throws Exception {
		ExplicitWaiting.explicitWaitVisibilityOfElement(phoneEvidence, 15);
		String value = getTextUsingScript("phone_evidence");
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

	public LeadPageObjects setvalueTelephone2(String value) throws Exception {
		try {
			ExplicitWaiting.explicitWaitVisibilityOfElement(telephone2, 15);
			clear(telephone2);
			sendKeys(telephone2, value);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Value for telephone2 is set as " + value);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to set value for telephone2 " + e);
		}
		return this;
	}

	public String getvalueTelephone2() throws Exception {
		ExplicitWaiting.explicitWaitVisibilityOfElement(telephone2, 15);
		String value = getTextUsingScript("telephone2");
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

	public LeadPageObjects setvaluePhoneEvidence2(String value) throws Exception {
		try {
			ExplicitWaiting.explicitWaitVisibilityOfElement(phoneEvidence2, 15);
			clear(phoneEvidence2);
			sendKeys(phoneEvidence2, value);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Value for phoneEvidence2 is set as " + value);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to set value for phoneEvidence2 " + e);
		}
		return this;
	}

	public String getvaluePhoneEvidence2() throws Exception {
		ExplicitWaiting.explicitWaitVisibilityOfElement(phoneEvidence2, 15);
		String value = getTextUsingScript("phone2_evidence");
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

	public LeadPageObjects setvalueAddress1(String value) throws Exception {
		try {
			ExplicitWaiting.explicitWaitVisibilityOfElement(address1, 15);
			clear(address1);
			sendKeys(address1, value);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Value for address1 is set as " + value);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to set value for address1 " + e);
		}
		return this;
	}

	public String getvalueAddress1() throws Exception {
		ExplicitWaiting.explicitWaitVisibilityOfElement(address1, 15);
		String value = getTextUsingScript("address1");
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

	public LeadPageObjects setvalueAddress2(String value) throws Exception {
		try {
			ExplicitWaiting.explicitWaitVisibilityOfElement(address2, 15);
			clear(address2);
			sendKeys(address2, value);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Value for address2 is set as " + value);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to set value for address2 " + e);
		}
		return this;
	}

	public String getvalueAddress2() throws Exception {
		ExplicitWaiting.explicitWaitVisibilityOfElement(address2, 15);
		String value = getTextUsingScript("address2");
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

	public LeadPageObjects setvalueTowncity(String value) throws Exception {
		try {
			ExplicitWaiting.explicitWaitVisibilityOfElement(towncity, 15);
			clear(towncity);
			sendKeys(towncity, value);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Value for towncity is set as " + value);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to set value for towncity " + e);
		}
		return this;
	}

	public String getvalueTowncity() throws Exception {
		ExplicitWaiting.explicitWaitVisibilityOfElement(towncity, 15);
		String value = getTextUsingScript("towncity");
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

	public LeadPageObjects setvalueCounty(String value) throws Exception {
		try {
			ExplicitWaiting.explicitWaitVisibilityOfElement(county, 15);
			clear(county);
			sendKeys(county, value);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Value for county is set as " + value);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to set value for county " + e);
		}
		return this;
	}

	public String getvalueCounty() throws Exception {
		ExplicitWaiting.explicitWaitVisibilityOfElement(county, 15);
		String value = getTextUsingScript("county");
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

	public LeadPageObjects setvaluePostcode(String value) throws Exception {
		try {
			ExplicitWaiting.explicitWaitVisibilityOfElement(postcode, 15);
			clear(postcode);
			sendKeys(postcode, value);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Value for postcode is set as " + value);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to set value for postcode " + e);
		}
		return this;
	}

	public String getvaluePostcode() throws Exception {
		ExplicitWaiting.explicitWaitVisibilityOfElement(postcode, 15);
		String value = getTextUsingScript("postcode");
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

	public LeadPageObjects setvalueCountry(String value) throws Exception {
		try {
			ExplicitWaiting.explicitWaitVisibilityOfElement(country, 15);
			clear(country);
			sendKeys(country, value);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Value for country is set as " + value);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to set value for country " + e);
		}
		return this;
	}

	public String getvalueCountry() throws Exception {
		ExplicitWaiting.explicitWaitVisibilityOfElement(country, 15);
		String value = getTextUsingScript("country");
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

	public LeadPageObjects setvalueAddressEvidence(String value) throws Exception {
		try {
			ExplicitWaiting.explicitWaitVisibilityOfElement(addressEvidence, 15);
			clear(addressEvidence);
			sendKeys(addressEvidence, value);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Value for addressEvidence is set as " + value);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to set value for addressEvidence " + e);
		}
		return this;
	}

	public String getvalueAddressEvidence() throws Exception {
		ExplicitWaiting.explicitWaitVisibilityOfElement(addressEvidence, 15);
		String value = getTextUsingScript("address_evidence");
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

	public LeadPageObjects setvalueFirstName(String value) throws Exception {
		try {
			ExplicitWaiting.explicitWaitVisibilityOfElement(firstName, 15);
			clear(firstName);
			sendKeys(firstName, value);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Value for firstName is set as " + value);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to set value for firstName " + e);
		}
		return this;
	}

	public String getvalueFirstName() throws Exception {
		ExplicitWaiting.explicitWaitVisibilityOfElement(firstName, 15);
		String value = getTextUsingScript("firstname");
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

	public LeadPageObjects setvalueLastName(String value) throws Exception {
		try {
			ExplicitWaiting.explicitWaitVisibilityOfElement(lastName, 15);
			clear(lastName);
			sendKeys(lastName, value);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Value for lastName is set as " + value);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to set value for lastName " + e);
		}
		return this;
	}

	public String getvalueLastName() throws Exception {
		ExplicitWaiting.explicitWaitVisibilityOfElement(lastName, 15);
		String value = getTextUsingScript("lastname");
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

	public LeadPageObjects setvalueLinkedinIdUrl(String value) throws Exception {
		try {
			ExplicitWaiting.explicitWaitVisibilityOfElement(linkedinIdUrl, 15);
			clear(linkedinIdUrl);
			sendKeys(linkedinIdUrl, value);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Value for linkedinIdUrl is set as " + value);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to set value for linkedinIdUrl " + e);
		}
		return this;
	}

	public String getvalueLinkedinIdUrl() throws Exception {
		ExplicitWaiting.explicitWaitVisibilityOfElement(linkedinIdUrl, 15);
		String value = getTextUsingScript("linkedin_id_url");
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

	public LeadPageObjects setvalueJobTitle(String value) throws Exception {
		try {
			ExplicitWaiting.explicitWaitVisibilityOfElement(jobTitle, 15);
			clear(jobTitle);
			Thread.sleep(2000);
			sendKeys(jobTitle, value);
			Thread.sleep(2000);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Value for jobTitle is set as " + value);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to set value for jobTitle " + e);
		}
		return this;
	}

	public String getvalueJobTitle() throws Exception {
		ExplicitWaiting.explicitWaitVisibilityOfElement(jobTitle, 15);
		String value = getTextUsingScript("jobtitle");
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

	public LeadPageObjects setvalueJobTitleEvidence(String value) throws Exception {
		try {
			ExplicitWaiting.explicitWaitVisibilityOfElement(jobTitleEvidence, 15);
			clear(jobTitleEvidence);
			sendKeys(jobTitleEvidence, value);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Value for jobTitleEvidence is set as " + value);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to set value for jobTitleEvidence " + e);
		}
		return this;
	}

	public String getvalueJobTitleEvidence() throws Exception {
		ExplicitWaiting.explicitWaitVisibilityOfElement(jobTitleEvidence, 15);
		String value = getTextUsingScript("jobtitle_evidence");
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

	public LeadPageObjects setvalueJobFunction(String value) throws Exception {
		try {
			ExplicitWaiting.explicitWaitVisibilityOfElement(jobFunction, 15);
			clear(jobFunction);
			sendKeys(jobFunction, value);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Value for jobFunction is set as " + value);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to set value for jobFunction " + e);
		}
		return this;
	}

	public String getvalueJobFunction() throws Exception {
		ExplicitWaiting.explicitWaitVisibilityOfElement(jobFunction, 15);
		String value = getTextUsingScript("job_function");
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

	public LeadPageObjects setvalueJobRole(String value) throws Exception {
		try {
			ExplicitWaiting.explicitWaitVisibilityOfElement(jobRole, 15);
			clear(jobRole);
			sendKeys(jobRole, value);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Value for jobRole is set as " + value);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to set value for jobRole " + e);
		}
		return this;
	}

	public String getvalueJobRole() throws Exception {
		ExplicitWaiting.explicitWaitVisibilityOfElement(jobRole, 15);
		String value = getTextUsingScript("jobRole");
		try {
			if (value != null) {
				ExtentTestManager.getTest().log(LogStatus.PASS, "jobRole value is " + value);
			} else
				ExtentTestManager.getTest().log(LogStatus.INFO, "jobRole value is null");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to get value from jobFunction " + e);
		}
		return value;
	}

	public LeadPageObjects setvalueCompanyName(String value) throws Exception {
		try {
			ExplicitWaiting.explicitWaitVisibilityOfElement(companyName, 15);
			clear(companyName);
			sendKeys(companyName, value);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Value for companyName is set as " + value);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to set value for companyName " + e);
		}
		return this;
	}

	public String getvalueCompanyName() throws Exception {
		ExplicitWaiting.explicitWaitVisibilityOfElement(companyName, 15);
		String value = getTextUsingScript("companyname");
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

	public String getvalueCompanyNameTargetListMatch1() throws Exception {
		ExplicitWaiting.explicitWaitVisibilityOfElement(companyNameTargetListMatch1, 15);
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

	public String getvalueCompanyNameTargetListMatch2() throws Exception {
		ExplicitWaiting.explicitWaitVisibilityOfElement(companyNameTargetListMatch2, 15);
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

	public String getvalueCompanyNameTargetListMatch3() throws Exception {
		ExplicitWaiting.explicitWaitVisibilityOfElement(companyNameTargetListMatch3, 15);
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

	public LeadPageObjects setvalueIndustry(String value) throws Exception {
		try {
			ExplicitWaiting.explicitWaitVisibilityOfElement(industry, 15);
			clear(industry);
			sendKeys(industry, value);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Value for industry is set as " + value);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to set value for industry " + e);
		}
		return this;
	}

	public String getvalueIndustry() throws Exception {
		ExplicitWaiting.explicitWaitVisibilityOfElement(industry, 15);
		String value = getTextUsingScript("industry");
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

	public LeadPageObjects setvalueCompanyEvidence(String value) throws Exception {
		try {
			ExplicitWaiting.explicitWaitVisibilityOfElement(companyEvidence, 15);
			clear(companyEvidence);
			sendKeys(companyEvidence, value);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Value for companyEvidence is set as " + value);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to set value for companyEvidence " + e);
		}
		return this;
	}

	public String getvalueCompanyEvidence() throws Exception {
		ExplicitWaiting.explicitWaitVisibilityOfElement(companyEvidence, 15);
		String value = getTextUsingScript("company_evidence");
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

	public LeadPageObjects setvalueCompanySize(String value) throws Exception {
		try {
			ExplicitWaiting.explicitWaitVisibilityOfElement(companySize, 15);
			clear(companySize);
			sendKeys(companySize, value);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Value for companySize is set as " + value);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to set value for companySize " + e);
		}
		return this;
	}

	public String getvalueCompanySize() throws Exception {
		ExplicitWaiting.explicitWaitVisibilityOfElement(companySize, 15);
		String value = getTextUsingScript("company_size");
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

	public LeadPageObjects setvalueCompanySizeEvidence(String value) throws Exception {
		try {
			ExplicitWaiting.explicitWaitVisibilityOfElement(companySizeEvidence, 15);
			clear(companySizeEvidence);
			sendKeys(companySizeEvidence, value);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Value for companySizeEvidence is set as " + value);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to set value for companySizeEvidence " + e);
		}
		return this;
	}

	public String getvalueCompanySizeEvidence() throws Exception {
		ExplicitWaiting.explicitWaitVisibilityOfElement(companySizeEvidence, 15);
		String value = getTextUsingScript("companysize_evidence");
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

	public LeadPageObjects setvalueTurnover(String value) throws Exception {
		try {
			ExplicitWaiting.explicitWaitVisibilityOfElement(turnover, 15);
			clear(turnover);
			sendKeys(turnover, value);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Value for turnover is set as " + value);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to set value for turnover " + e);
		}
		return this;
	}

	public String getvalueTurnover() throws Exception {
		ExplicitWaiting.explicitWaitVisibilityOfElement(turnover, 15);
		String value = getTextUsingScript("turnover");
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

	public LeadPageObjects setvalueTurnoverEvidence(String value) throws Exception {
		try {
			ExplicitWaiting.explicitWaitVisibilityOfElement(turnoverEvidence, 15);
			clear(turnoverEvidence);
			sendKeys(turnoverEvidence, value);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Value for turnoverEvidence is set as " + value);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to set value for turnoverEvidence " + e);
		}
		return this;
	}

	public String getvalueTurnoverEvidence() throws Exception {
		ExplicitWaiting.explicitWaitVisibilityOfElement(turnoverEvidence, 15);
		String value = getTextUsingScript("turnover_evidence");
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

	public LeadPageObjects setvalueRejectionReason(String value) throws Exception {
		try {
			ExplicitWaiting.explicitWaitVisibilityOfElement(rejectionReason, 15);
			clear(rejectionReason);
			sendKeys(rejectionReason, value);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Value for rejectionReason is set as " + value);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to set value for rejectionReason " + e);
		}
		return this;
	}

	public String getvalueRejectionReason() throws Exception {
		ExplicitWaiting.explicitWaitVisibilityOfElement(rejectionReason, 15);
		String value = getTextUsingScript("comments");
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

	public LeadPageObjects setvalueRejectionReasonEvidence(String value) throws Exception {
		try {
			ExplicitWaiting.explicitWaitVisibilityOfElement(rejectionReasonEvidence, 15);
			clear(rejectionReasonEvidence);
			sendKeys(rejectionReasonEvidence, value);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Value for rejectionReasonEvidence is set as " + value);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to set value for rejectionReasonEvidence " + e);
		}
		return this;
	}

	public String getvalueRejectionReasonEvidence() throws Exception {
		ExplicitWaiting.explicitWaitVisibilityOfElement(rejectionReasonEvidence, 15);
		String value = getTextUsingScript("rejection_evidence");
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

	public LeadPageObjects setvalueUserAgent(String value) throws Exception {
		try {
			ExplicitWaiting.explicitWaitVisibilityOfElement(userAgent, 15);
			clear(userAgent);
			sendKeys(userAgent, value);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Value for userAgent is set as " + value);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to set value for userAgent " + e);
		}
		return this;
	}

	public String getvalueUserAgent() throws Exception {
		ExplicitWaiting.explicitWaitVisibilityOfElement(userAgent, 15);
		String value = getTextUsingScript("useragent");
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

	public LeadPageObjects setvalueLeadType(String value) throws Exception {
		try {
			ExplicitWaiting.explicitWaitVisibilityOfElement(leadType, 15);
			clear(leadType);
			sendKeys(leadType, value);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Value for leadType is set as " + value);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to set value for leadType " + e);
		}
		return this;
	}

	public String getvalueLeadType() throws Exception {
		ExplicitWaiting.explicitWaitVisibilityOfElement(leadType, 15);
		String value = getTextUsingScript("lead_type");
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

	public LeadPageObjects setvalueSfdcCode(String value) throws Exception {
		try {
			ExplicitWaiting.explicitWaitVisibilityOfElement(sfdcCode, 15);
			clear(sfdcCode);
			sendKeys(sfdcCode, value);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Value for sfdcCode is set as " + value);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to set value for sfdcCode " + e);
		}
		return this;
	}

	public String getvalueSfdcCode() throws Exception {
		ExplicitWaiting.explicitWaitVisibilityOfElement(sfdcCode, 15);
		String value = getTextUsingScript("sfdc_code");
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

	public LeadPageObjects setvalueProductOfInterest(String value) throws Exception {
		try {
			ExplicitWaiting.explicitWaitVisibilityOfElement(productOfInterest, 15);
			clear(productOfInterest);
			sendKeys(productOfInterest, value);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Value for productOfInterest is set as " + value);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to set value for productOfInterest " + e);
		}
		return this;
	}

	public String getvalueProductOfInterest() throws Exception {
		ExplicitWaiting.explicitWaitVisibilityOfElement(productOfInterest, 15);
		String value = getTextUsingScript("product_of_interest");
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

	public LeadPageObjects setvalueCallComments(String value) throws Exception {
		try {
			ExplicitWaiting.explicitWaitVisibilityOfElement(callComments, 15);
			clear(callComments);
			sendKeys(callComments, value);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Value for callComments is set as " + value);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to set value for callComments " + e);
		}
		return this;
	}

	public String getvalueCallComments() throws Exception {
		ExplicitWaiting.explicitWaitVisibilityOfElement(callComments, 15);
		String value = getTextUsingScript("call_comments");
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

	public LeadPageObjects setvalueSecure(String value) throws Exception {
		try {
			ExplicitWaiting.explicitWaitVisibilityOfElement(secure, 15);
			clear(secure);
			sendKeys(secure, value);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Value for secure is set as " + value);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to set value for secure " + e);
		}
		return this;
	}

	public String getvalueSecure() throws Exception {
		ExplicitWaiting.explicitWaitVisibilityOfElement(secure, 15);
		String value = getTextUsingScript("secure");
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

	public LeadPageObjects setvalueBiggestChallenge(String value) throws Exception {
		try {
			ExplicitWaiting.explicitWaitVisibilityOfElement(biggestChallenge, 15);
			clear(biggestChallenge);
			sendKeys(biggestChallenge, value);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Value for biggestChallenge is set as " + value);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to set value for biggestChallenge " + e);
		}
		return this;
	}

	public String getvalueBiggestChallenge() throws Exception {
		ExplicitWaiting.explicitWaitVisibilityOfElement(biggestChallenge, 15);
		String value = getTextUsingScript("biggest_challenge");
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

	public LeadPageObjects setvalueWhichPlatforms(String value) throws Exception {
		try {
			ExplicitWaiting.explicitWaitVisibilityOfElement(whichPlatforms, 15);
			clear(whichPlatforms);
			sendKeys(whichPlatforms, value);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Value for whichPlatforms is set as " + value);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to set value for whichPlatforms " + e);
		}
		return this;
	}

	public String getvalueWhichPlatforms() throws Exception {
		ExplicitWaiting.explicitWaitVisibilityOfElement(whichPlatforms, 15);
		String value = getTextUsingScript("which_platforms");
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

	public LeadPageObjects selectvalueEmailToolsDropdown(String value) throws Exception {
		try {
			ExplicitWaiting.explicitWaitVisibilityOfElement(emailToolsDropdown, 15);
			selectByVisibleText(emailToolsDropdown, value);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Selected value from emailToolsDropdown is " + value);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to select value from emailToolsDropdown " + e);
		}
		return this;
	}

	public LeadPageObjects selectvaluePhoneReformatDropdown(String value) throws Exception {
		try {
			ExplicitWaiting.explicitWaitVisibilityOfElement(phoneReformatDropdown, 15);
			selectByVisibleText(phoneReformatDropdown, value);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Selected value from phoneReformatDropdown is " + value);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to select value from phoneReformatDropdown " + e);
		}
		return this;
	}

	public LeadPageObjects selectvaluePhoneToolsDropdown(String value) throws Exception {
		try {
			ExplicitWaiting.explicitWaitVisibilityOfElement(phoneToolsDropdown, 15);
			selectByVisibleText(phoneToolsDropdown, value);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Selected value from phoneToolsDropdown is " + value);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to select value from phoneToolsDropdown " + e);
		}
		return this;
	}

	public LeadPageObjects selectvaluePhoneReformatDropdown2(String value) throws Exception {
		try {
			ExplicitWaiting.explicitWaitVisibilityOfElement(phoneReformatDropdown2, 15);
			selectByVisibleText(phoneReformatDropdown2, value);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Selected value from phoneReformatDropdown2 is " + value);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to select value from phoneReformatDropdown2 " + e);
		}
		return this;
	}

	public LeadPageObjects selectvalueCountryDropdown(String value) throws Exception {
		try {
			ExplicitWaiting.explicitWaitVisibilityOfElement(countryDropdown, 15);
			selectByIndex(countryDropdown, 0);
			handleAlert();
			selectByVisibleText(countryDropdown, value);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Selected value from countryDropdown is " + value);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to select value from countryDropdown " + e);
		}
		return this;
	}

	public LeadPageObjects selectvalueJobTitleDropdown(String value) throws Exception {
		try {
			ExplicitWaiting.explicitWaitVisibilityOfElement(jobTitleDropdown, 15);
			selectByVisibleText(jobTitleDropdown, value);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Value for jobTitleDropdown is set as " + value);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to select value from jobTitleDropdown " + e);
		}
		return this;
	}

	public LinkedInPageObjects selectLinkedInCompanySerachInJobTitleDropdown() throws Exception {
		try {
			// ExplicitWaiting.explicitWaitVisibilityOfElement(jobTitleDropdown, 15);
			selectByVisibleText(jobTitleDropdown, "Linkedin Company Search");
			logger.info("Linkedin Company Search");
			switchToNewTab();
			// clickSearchResult1();
			String url = getSearchResult1();
			getLinkedInWebDriver().navigate().to(url);
			ExtentTestManager.getTest().log(LogStatus.PASS,
					"Value for jobTitleDropdown is set as Linkedin Company Search");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL,
					"Unable to select value Linkedin Company Search from jobTitleDropdown " + e);
		}
		return linkedInPage();
	}

	public LeadPageObjects selectvalueJobFunctionDropdown(String value) throws Exception {
		try {
			ExplicitWaiting.explicitWaitVisibilityOfElement(jobFunctionDropdown, 15);
			selectByIndex(jobFunctionDropdown, 0);
			handleAlert();
			selectByVisibleText(jobFunctionDropdown, value);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Selected value from jobFunctionDropdown is " + value);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to select value from jobFunctionDropdown " + e);
		}
		return this;
	}

	public LeadPageObjects selectvalueJobRoleDropdown(String value) throws Exception {
		try {
			ExplicitWaiting.explicitWaitVisibilityOfElement(jobRoleDropdown, 15);
			selectByIndex(jobRoleDropdown,0);
			handleAlert();
			selectByVisibleText(jobRoleDropdown, value);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Selected value from jobRoleDropdown is " + value);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to select value from jobRoleDropdown " + e);
		}
		return this;
	}

	public LeadPageObjects selectvalueCompanyToolsDropdown(String value) throws Exception {
		try {
			ExplicitWaiting.explicitWaitVisibilityOfElement(companyToolsDropdown, 15);
			selectByVisibleText(companyToolsDropdown, value);
			logger.info(value);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Selected value from companyToolsDropdown is " + value);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to select value from companyToolsDropdown " + e);
		}
		return this;
	}

	public LinkedInPageObjects selectLinkedInvalueCompanyToolsDropdown() throws Exception {
		try {
			// ExplicitWaiting.explicitWaitVisibilityOfElement(companyToolsDropdown, 15);
			selectByVisibleText(companyToolsDropdown, "Linkedin");
			logger.info("Linkedin");
			switchToNewTab();
			// clickSearchResult1();
			String url = getSearchResult1().replaceAll("/$", "");
			url = url + "/about";
			if (url.contains("linkedin")) {
				getLinkedInWebDriver().navigate().to(url);
			} else {
				logger.info("invalid url for linkedin search");
			}
			ExtentTestManager.getTest().log(LogStatus.PASS, "Selected value from companyToolsDropdown is Linkedin");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to select value from companyToolsDropdown " + e);
		}
		return linkedInPage();
	}

	public ZoomInfoPageObjects selectZoomInfovalueCompanyToolsDropdown() throws Exception {
		try {
			// ExplicitWaiting.explicitWaitVisibilityOfElement(companyToolsDropdown, 15);
			selectByVisibleText(companyToolsDropdown, "Zoominfo");
			logger.info("Zoominfo");
			switchToNewTab();
			// clickSearchResult1();
			String url = getSearchResult1();
			if (url.contains("zoominfo")) {
				getZoomInfoWebDriver().navigate().to(url);
			} else {
				logger.info("invalid url for zoominfo search");
			}
			ExtentTestManager.getTest().log(LogStatus.PASS, "Selected value from companyToolsDropdown is Zoominfo");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to select value from companyToolsDropdown " + e);
		}
		return zoomInfoPage();
	}

	public EndolePageObjects selectGlassDoorvalueCompanyToolsDropdown() throws Exception {
		try {
			// ExplicitWaiting.explicitWaitVisibilityOfElement(companyToolsDropdown, 15);
			selectByVisibleText(companyToolsDropdown, "Glassdoor");
			logger.info("Glassdoor");
			switchToNewTab();
			clickSearchResult1();
			ExtentTestManager.getTest().log(LogStatus.PASS, "Selected value from companyToolsDropdown is Glassdoor");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to select value from companyToolsDropdown " + e);
		}
		return endolePage();
	}

	public EndolePageObjects selectGooglevalueAndUpdateEndoleCompanyToolsDropdown(String searchValue) throws Exception {
		try {
			ExplicitWaiting.explicitWaitVisibilityOfElement(companyToolsDropdown, 15);
			selectByVisibleText(companyToolsDropdown, "Google (Generic)");
			logger.info("Google (Generic)");
			switchToNewTab();
			updateSearchValueInGoogleAndSearch(searchValue);
			// clickSearchResult1();
			String url = getSearchResult1();
			if (url.contains("endole")) {
				getEndoleWebDriver().navigate().to(url);
			} else {
				logger.info("invalid url for endole search");
			}
			ExtentTestManager.getTest().log(LogStatus.PASS,
					"Selected value from companyToolsDropdown is Google (Generic)");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to select value from companyToolsDropdown " + e);
		}
		return endolePage();
	}

	public GooglePageObjects selectEmailEvidenceAndUpdateEmailEvidenceDropdown(String searchValue) throws Exception {
		try {
			ExplicitWaiting.explicitWaitVisibilityOfElement(emailToolsDropdown, 15);
			selectByVisibleText(emailToolsDropdown, "Google (Generic)");
			logger.info("Google (Generic)");
			switchToNewTab();
			updateSearchValueInGoogleAndSearch(searchValue);
			// clickSearchResult1();
			String url = getSearchResult1();
			if (url.contains("endole")) {
				getEndoleWebDriver().navigate().to(url);
			} else {
				logger.info("invalid url for endole search");
			}
			ExtentTestManager.getTest().log(LogStatus.PASS,
					"Selected value from companyToolsDropdown is Google (Generic)");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to select value from companyToolsDropdown " + e);
		}
		return googlePage();
	}
	
	public LeadPageObjects selectvalueIndustryDropdown(String value) throws Exception {
		try {
			ExplicitWaiting.explicitWaitVisibilityOfElement(industryDropdown, 15);
			selectByVisibleText(industryDropdown, value);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Selected value from industryDropdown is " + value);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to select value from industryDropdown " + e);
		}
		return this;
	}

	public LeadPageObjects selectvalueCompanySizeDropDown(String value) throws Exception {
		try {
			ExplicitWaiting.explicitWaitVisibilityOfElement(companySizeDropdown, 15);
			selectByIndex(companySizeDropdown, 0);
			handleAlert();
			selectByVisibleText(companySizeDropdown, value);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Selected value from companySizeDropDown is " + value);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to select value from companySizeDropDown " + e);
		}
		return this;
	}

	public LeadPageObjects selectvalueTurnoverDropdown(String value) throws Exception {
		try {
			ExplicitWaiting.explicitWaitVisibilityOfElement(turnoverDropdown, 15);
			selectByIndex(turnoverDropdown, 0);
			handleAlert();
			selectByVisibleText(turnoverDropdown, value);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Selected value from turnoverDropdown is " + value);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to select value from turnoverDropdown " + e);
		}
		return this;
	}

	public LeadPageObjects selectvalueTurnoverCompanyToolsDropdown(String value) throws Exception {
		try {
			ExplicitWaiting.explicitWaitVisibilityOfElement(turnoverCompanyToolsDropdown, 15);
			selectByVisibleText(turnoverCompanyToolsDropdown, value);
			ExtentTestManager.getTest().log(LogStatus.PASS,
					"Selected value from turnoverCompanyToolsDropdown is " + value);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL,
					"Unable to select value from turnoverCompanyToolsDropdown " + e);
		}
		return this;
	}

	public LeadPageObjects selectvalueRejectionReasonDropdown(String value) throws Exception {
		try {
			ExplicitWaiting.explicitWaitVisibilityOfElement(rejectionReasonDropdown, 15);
			selectByIndex(rejectionReasonDropdown, 0);
			handleAlert();
			selectByVisibleText(rejectionReasonDropdown, value);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Selected value from rejectionReasonDropdown is " + value);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to select value from rejectionReasonDropdown " + e);
		}
		return this;
	}

	public LeadPageObjects selectvalueCallCommentsDropDown(String value) throws Exception {
		try {
			ExplicitWaiting.explicitWaitVisibilityOfElement(callCommentsDropDown, 15);
			selectByVisibleText(callCommentsDropDown, value);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Selected value from callCommentsDropDown is " + value);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to select value from callCommentsDropDown " + e);
		}
		return this;
	}

	public LeadPageObjects updateManuallyVerify() throws Exception {
		WebElement[] textElements = { emailEvidence, telephone, phoneEvidence, telephone2, phoneEvidence2, address1,
				address2, towncity, county, postcode, country, addressEvidence, firstName, lastName, linkedinIdUrl,
				jobTitle, jobTitleEvidence, companyName, industry, companyEvidence, companySize, companySizeEvidence,
				turnover, turnoverEvidence };
		String[] textElementName = { "email_evidence", "telephone", "phone_evidence", "telephone2", "phone2_evidence",
				"address1", "address2", "towncity", "county", "postcode", "country", "address_evidence", "firstname",
				"lastname", "linkedin_id_url", "jobtitle", "jobtitle_evidence", "companyname", "industry",
				"company_evidence", "company_size", "companysize_evidence", "turnover", "turnover_evidence" };

//		WebElement[] dropDownElements = { industryDropdown, turnoverDropdown, jobFunctionDropdown, jobRoleDropdown };
		WebElement[] dropDownElements = {industryDropdown, jobRoleDropdown};

		String[] dropdownElementId = {"ddnIndustry", "ddlIntelJobRole"};
//		String[] dropdownElementId = { "ddnIndustry", "ddnTurnover", "ddlIntelJobFunction", "ddlIntelJobRole" };

		for (int i = 0; i < textElements.length; i++) {
			ExplicitWaiting.explicitWaitVisibilityOfElement(textElements[i], 15);
			String value = getTextUsingScript(textElementName[i]);
			if (value.equals("")) {
				if (textElementName[i].equals("linkedin_id_url")) {
					ExplicitWaiting.explicitWaitVisibilityOfElement(linkedinIdUrlNoEvidenceFoundBtn, 15);
					click(linkedinIdUrlNoEvidenceFoundBtn);
					handleAlert();
					click(linkedinIdUrlNoEvidenceFoundBtn);
					handleAlert();
					ExtentTestManager.getTest().log(LogStatus.INFO, "manually validate linkedin_id_url field");
				} else {
					sendKeys(textElements[i], "manually validate this field");
					handleAlert();
					ExtentTestManager.getTest().log(LogStatus.INFO,
							"manually validate " + textElementName[i] + "field");
				}
			}
		}

		for (int i = 0; i < dropDownElements.length; i++) {
			String value = getTextUsingIdScript(dropdownElementId[i]);
			selectByIndex(dropDownElements[i], 0);
			handleAlert();
			selectByIndex(dropDownElements[i], 1);
			handleAlert();
//			if (isFieldExist(dropDownElements[i])) {
//				
////				if (value.contains("-")) {
////					
////				}
////			} else {
////				
//			}
		}
		return this;
	}

	public LeadPageObjects placementCheck() throws Exception {
		placementReadOnly().placementCheck();
		return this;
	}

	public LeadPageObjects emailCheck() throws Exception {
		email().emailCheck();
		return this;
	}
	
	public LeadPageObjects companySizeCheck() throws Exception {
		companySize().companySizeCheck();
		return this;
	}

	public LeadPageObjects companyTurnoverCheck() throws Exception {
		companyTurnover().companyTurnoverCheck();
		return this;
	}

	public LeadPageObjects countryCheck() throws Exception {
		country().countryCheck();
		return this;
	}

	public LeadPageObjects firstnameLastnameJobTitleCheck() throws Exception {
		firstnameLastnameJobTitle().firstnameLastnameJobTitleCheck();
		return this;
	}

	public LeadPageObjects jobTitleCheck() throws Exception {
		jobTitle().jobTitleCheck();
		return this;
	}

	// added by Anand
	public boolean isJobRoleFieldExist() throws Exception {
		boolean isJobRoleFieldExist = isFieldExist(jobRole);
		return isJobRoleFieldExist;
	}

	// added by Anand
	public LeadPageObjects jobLevelCheck() throws Exception {
		jobLevel().jobLevelCheck();
		return this;
	}

	// added by Anand
	public LeadPageObjects jobFunctionCheck() throws Exception {
		jobFunction().jobFunctionCheck();
		return this;
	}
	
	//added by Anand
	public LeadPageObjects industryCheck() throws Exception {
		industry().industryCheck();
		return this;
	}

	public List<WebElement> getvaluesJobRoleDropdown() throws Exception {
		List<WebElement> options = null;
		try {
			ExplicitWaiting.explicitWaitVisibilityOfElement(jobRoleDropdown, 15);
			Select select = new Select(jobRoleDropdown);
			options = select.getOptions();
			ExtentTestManager.getTest().log(LogStatus.INFO, "Job Role Dropdown Values are " + options);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.INFO, "Unable to get values from jobRoleDropdown " + e);
		}
		return options;
	}

	// added by Anand
	public List<WebElement> getvaluesJobFunctionDropdown() throws Exception {
		List<WebElement> options = null;
		try {
			ExplicitWaiting.explicitWaitVisibilityOfElement(jobFunctionDropdown, 15);
			Select select = new Select(jobFunctionDropdown);
			options = select.getOptions();
			ExtentTestManager.getTest().log(LogStatus.INFO, "Job Function Dropdown Values are " + options);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.INFO, "Unable to get values from jobFunctionDropdown " + e);
		}
		return options;
	}
	
	//added by Anand
	public List<WebElement> getvaluesIndustryDropdown() throws Exception {
		List<WebElement> options = null;
		try {
			ExplicitWaiting.explicitWaitVisibilityOfElement(industryDropdown, 15);
			Select select = new Select(industryDropdown);
			options = select.getOptions();
			ExtentTestManager.getTest().log(LogStatus.INFO, "Industry Dropdown Values are " + options);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.INFO, "Unable to get values from industryDropdown " + e);
		}
		return options;
	}
}

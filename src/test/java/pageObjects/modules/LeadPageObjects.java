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
	
	@FindBy(css = "table#validate-me tr")
	private List<WebElement> getLeadRows;
	
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
	
	public void createCampaignLeadsFile() throws Exception {
		String campaignName = appConfig.getCampaign();
		String campaignPath = "campaignFiles/" + campaignName + "_Leads.csv";
		List<List<String>> campaignLeads = this.getLeadsDetailsFromAllPages();
		List<String> campaignLines = new ArrayList<String>();
		for (List<String> campaignLead : campaignLeads) {
			String eyeIcon = campaignLead.get(0);
			String leadsId = campaignLead.get(1);
			String tickIcon = campaignLead.get(2);
			String rejectionReason = campaignLead.get(3);
			String wrongIcon = campaignLead.get(4);
			String redactionTest = campaignLead.get(5);
			String email = campaignLead.get(6);
			String title = campaignLead.get(7);
			String firstName = campaignLead.get(8);
			String lastName = campaignLead.get(9);
			String Address1 = campaignLead.get(10);
			String Address2 = campaignLead.get(11);
			String Address3 = campaignLead.get(12);
			String townCity = campaignLead.get(13);
			String countryState = campaignLead.get(14);
			String country = campaignLead.get(15);
			String postalZipCode = campaignLead.get(16);
			String telephone = campaignLead.get(17);
			String userAgent = campaignLead.get(18);
			String source = campaignLead.get(19);
			String supplierLeadId = campaignLead.get(20);
			String urlReferrer = campaignLead.get(21);
			String startTime = campaignLead.get(22);
			String endTime = campaignLead.get(23);
			String fingerPrint = campaignLead.get(24);
			String leadStatus = campaignLead.get(25);
			String companyName = campaignLead.get(26);
			String jobTitle = campaignLead.get(27);
			String industry = campaignLead.get(28);
			String platform = campaignLead.get(29);
			String freeListFlag = campaignLead.get(30);
			String assetTitle = campaignLead.get(31);
			String comments = campaignLead.get(32);
			String leadCreationDate = campaignLead.get(33);
			String subSource = campaignLead.get(34);
			String tactic = campaignLead.get(35);
			String telephone2 = campaignLead.get(36);
			String ADDRESS_C = campaignLead.get(37);
			String ADDRESS_EVIDENCE = campaignLead.get(38);
			String COMPANY_C = campaignLead.get(39);
			String COMPANY_EVIDENCE = campaignLead.get(40);
			String COMPANYSIZE_EVIDENCE = campaignLead.get(41);
			String EMAIL_C = campaignLead.get(42);
			String EMAIL_EVIDENCE = campaignLead.get(43);
			String INDIVIDUAL_EVIDENCE = campaignLead.get(44);
			String JOBTITLE_EVIDENCE = campaignLead.get(45);
			String LINKEDIN_ID_URL = campaignLead.get(46);
			String PHONE_C = campaignLead.get(47);
			String PHONE_EVIDENCE = campaignLead.get(48);
			String REJECTION_EVIDENCE = campaignLead.get(49);
			String TURNOVER_EVIDENCE = campaignLead.get(50);
			String UPDATE_DATE = campaignLead.get(51);
			String COMPANY_SIZE = campaignLead.get(52);
			String SWITCHING_TO_CLOUD = campaignLead.get(53);
			String INTERNATIONAL_BUSINESS_PAYMENTS = campaignLead.get(54);
			String TURNOVER = campaignLead.get(55);
			String BREACH_DOCUMENTS = campaignLead.get(56);
			String JOB_EXPERIENCE = campaignLead.get(57);
			String PHONE2_EVIDENCE = campaignLead.get(58);
			String VOICE_VERIFIED = campaignLead.get(59);
			String JOB_FUNCTION = campaignLead.get(60);
			String ANNUAL_FOREIGN_EXCHANGE = campaignLead.get(61);
			String ANNUAL_REVENUE = campaignLead.get(62);
			String PAYMENT_FREQUENCY = campaignLead.get(63);
			String CALL_COMMENTS = campaignLead.get(64);
			String INPUT_PLACEMENT = campaignLead.get(65);
			String SECURE = campaignLead.get(66);
			String LEAD_TYPE = campaignLead.get(67);
			String JOB_ROLE = campaignLead.get(68);
			String TimeStamp = campaignLead.get(69);
			String Site = campaignLead.get(70);
			String Placement = campaignLead.get(71);
			String IPAddress = campaignLead.get(72);
			String sub_id = campaignLead.get(73);
			String CALLBACK_ID = campaignLead.get(74);
			String line = eyeIcon+","+leadsId+","+tickIcon+","+rejectionReason+","+wrongIcon+","+redactionTest+","+email+","+title+","+firstName+","+lastName+","+
					Address1+","+Address2+","+Address3+","+townCity+","+countryState+","+country+","+postalZipCode+","+telephone+","+userAgent+","+source+","+
					supplierLeadId+","+urlReferrer+","+startTime+","+endTime+","+fingerPrint+","+leadStatus+","+companyName+","+jobTitle+","+industry+","+platform+","+
					freeListFlag+","+assetTitle+","+comments+","+leadCreationDate+","+subSource+","+tactic+","+telephone2+","+ADDRESS_C+","+ADDRESS_EVIDENCE+","+COMPANY_C+","+
					COMPANY_EVIDENCE+","+COMPANYSIZE_EVIDENCE+","+EMAIL_C+","+EMAIL_EVIDENCE+","+INDIVIDUAL_EVIDENCE+","+JOBTITLE_EVIDENCE+","+LINKEDIN_ID_URL+","+PHONE_C+","+
					PHONE_EVIDENCE+","+REJECTION_EVIDENCE+","+TURNOVER_EVIDENCE+","+UPDATE_DATE+","+COMPANY_SIZE+","+SWITCHING_TO_CLOUD+","+INTERNATIONAL_BUSINESS_PAYMENTS+","+
					TURNOVER+","+BREACH_DOCUMENTS+","+JOB_EXPERIENCE+","+PHONE2_EVIDENCE+","+VOICE_VERIFIED+","+JOB_FUNCTION+","+ANNUAL_FOREIGN_EXCHANGE+","+ANNUAL_REVENUE+","+
					PAYMENT_FREQUENCY+","+CALL_COMMENTS+","+INPUT_PLACEMENT+","+SECURE+","+LEAD_TYPE+","+JOB_ROLE+","+TimeStamp+","+Site+","+Placement+","+IPAddress+","+sub_id+","+CALLBACK_ID;
			campaignLines.add(line);
		}
		createCampaignFile(campaignLines, campaignPath, true);
	}
	
	public void readCampaignLeadsFile() throws Exception {
		String campaignName = appConfig.getCampaign();
		String campaignPath = "campaignFiles/" + campaignName + "_Leads.csv";
		List<String> leadsData = ExcelUtils.readFileToLines(campaignPath);
		setcampaignDataLines(leadsData);
		logger.info(leadsData);
	}
	
	public void clickLeadsFromFile(String leadsLine) throws Exception {
		CampaignLeadsDataRecord leadsRecord = new CampaignLeadsDataRecord(leadsLine);
		String leadId = leadsRecord.getLeadsId();
		leadId = leadId.substring(leadId.length() - 9);
		logger.info(leadId);
		clickEditLead(leadId);
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
	
	public void clickEditLead(String leadId) throws Exception {
		WebElement editLead = getXpath("//td/span[contains(text(),'%s')]/../preceding-sibling::td/i", leadId);
		click(editLead);
	}
	
	public void clickEmailNoEvidenceFoundBtn() {
		click(emailNoEvidenceFoundBtn);
	}

	public void clickEmailIndirectEvidenceBtn() {
		click(emailIndirectEvidenceBtn);
	}
	
	public void clickPhoneCallVerifiedBtn() {
		click(phoneCallVerifiedBtn);
	}
	
	public void clickPhoneNoEvidenceFoundBtn() {
		click(phoneNoEvidenceFoundBtn);
	}
	
	public void clickPostcodeUpperCaseBtn() {
		click(postcodeUpperCaseBtn);
	}
	
	public void clickAddressNoEvidenceFoundBtn() {
		click(addressNoEvidenceFoundBtn);
	}
	
	public void clickAddressIndirectEvidenceBtn() {
		click(addressIndirectEvidenceBtn);
	}
	
	public void clickLinkedinIdUrlNoEvidenceFoundBtn() {
		click(linkedinIdUrlNoEvidenceFoundBtn);
	}
	
	public void clickJobTitleEvidenceCopyLinkedinUrlBtn() {
		click(jobTitleEvidenceCopyLinkedinUrlBtn);
	}
	
	public void clickJobTitleEvidenceCallVerifiedBtn() {
		click(jobTitleEvidenceCallVerifiedBtn);
	}
	
	public void clickJobTitleEvidenceNoEvidenceFoundBtn() {
		click(jobTitleEvidenceNoEvidenceFoundBtn);
	}
	
	public void clickCompanyNameTargetListMatch1() {
		click(companyNameTargetListMatch1);
	}
	
	public void clickCompanyNameTargetListMatch2() {
		click(companyNameTargetListMatch2);
	}
	
	public void clickCompanyNameTargetListMatch3() {
		click(companyNameTargetListMatch3);
	}
	
	public void clickCompanyEvidenceCopyBtn() {
		click(companyEvidenceCopyBtn);
	}
	
	public void clickCompanyEvidencePasteBtn() {
		click(companyEvidencePasteBtn);
	}
	
	public void clickCompanyEvidenceUpperCaseBtn() {
		click(companyEvidenceUpperCaseBtn);
	}
	
	public void clickCompanyEvidenceProperCaseBtn() {
		click(companyEvidenceProperCaseBtn);
	}
	
	public void clickCompanySizeNoEvidenceFoundBtn() {
		click(companySizeNoEvidenceFoundBtn);
	}
	
	public void clickCompanySizeIndirectEvidenceBtn() {
		click(companySizeIndirectEvidenceBtn);
	}
	
	public void clickTurnoverNoEvidenceFoundBtn() {
		click(turnoverNoEvidenceFoundBtn);
	}
	
	public void clickTurnoverIndirectEvidenceBtn() {
		click(turnoverIndirectEvidenceBtn);
	}
	
	public void clickRejectionReasonJobtitleBtn() {
		click(rejectionReasonJobtitleBtn);
	}
	
	public void clickRejectionReasonCompanySizeBtn() {
		click(rejectionReasonCompanySizeBtn);
	}
	
	public void clickResetBtn() {
		click(resetBtn);
	}
	
	public void clickSaveBtn() {
		click(saveBtn);
	}
	
	public void clickSaveAndReverifyBtn() {
		click(saveAndReverifyBtn);
	}

	public String getValuePlacementReadOly() 
	{
		return getText(placementReadOly);
	}

	public String getValueAssetReadOly() 
	{
		return getText(assetReadOly);
	}

	public String getValueLeadTypeReadOly() 
	{
		return getText(leadTypeReadOly);
	}

	public String getValueCountryReadOly() 
	{
		return getText(countryReadOly);
	}

	public void setValueLeadId(String value)
	{
		clear(leadId);
		sendKeys(leadId, value);
	}


	public String getValueLeadId() 
	{
		return getText(leadId);
	}

	public void setValueEmail(String value)
	{
		clear(email);
		sendKeys(email, value);
	}


	public String getValueEmail() 
	{
		return getText(email);
	}

	public void setValueEmailEvidence(String value)
	{
		clear(emailEvidence);
		sendKeys(emailEvidence, value);
	}


	public String getValueEmailEvidence() 
	{
		return getText(emailEvidence);
	}

	public void setValueTelephone(String value)
	{
		clear(telephone);
		sendKeys(telephone, value);
	}


	public String getValueTelephone() 
	{
		return getText(telephone);
	}

	public void setValuePhoneEvidence(String value)
	{
		clear(phoneEvidence);
		sendKeys(phoneEvidence, value);
	}


	public String getValuePhoneEvidence() 
	{
		return getText(phoneEvidence);
	}

	public void setValueTelephone2(String value)
	{
		clear(telephone2);
		sendKeys(telephone2, value);
	}


	public String getValueTelephone2() 
	{
		return getText(telephone2);
	}

	public void setValuePhoneEvidence2(String value)
	{
		clear(phoneEvidence2);
		sendKeys(phoneEvidence2, value);
	}


	public String getValuePhoneEvidence2() 
	{
		return getText(phoneEvidence2);
	}

	public void setValueAddress1(String value)
	{
		clear(address1);
		sendKeys(address1, value);
	}


	public String getValueAddress1() 
	{
		return getText(address1);
	}

	public void setValueAddress2(String value)
	{
		clear(address2);
		sendKeys(address2, value);
	}


	public String getValueAddress2() 
	{
		return getText(address2);
	}

	public void setValueTowncity(String value)
	{
		clear(towncity);
		sendKeys(towncity, value);
	}


	public String getValueTowncity() 
	{
		return getText(towncity);
	}

	public void setValueCounty(String value)
	{
		clear(county);
		sendKeys(county, value);
	}


	public String getValueCounty() 
	{
		return getText(county);
	}

	public void setValuePostcode(String value)
	{
		clear(postcode);
		sendKeys(postcode, value);
	}


	public String getValuePostcode() 
	{
		return getText(postcode);
	}

	public void setValueCountry(String value)
	{
		clear(country);
		sendKeys(country, value);
	}


	public String getValueCountry() 
	{
		return getText(country);
	}

	public void setValueAddressEvidence(String value)
	{
		clear(addressEvidence);
		sendKeys(addressEvidence, value);
	}


	public String getValueAddressEvidence() 
	{
		return getText(addressEvidence);
	}

	public void setValueFirstName(String value)
	{
		clear(firstName);
		sendKeys(firstName, value);
	}


	public String getValueFirstName() 
	{
		return getText(firstName);
	}

	public void setValueLastName(String value)
	{
		clear(lastName);
		sendKeys(lastName, value);
	}


	public String getValueLastName() 
	{
		return getText(lastName);
	}

	public void setValueLinkedinIdUrl(String value)
	{
		clear(linkedinIdUrl);
		sendKeys(linkedinIdUrl, value);
	}


	public String getValueLinkedinIdUrl() 
	{
		return getText(linkedinIdUrl);
	}

	public void setValueJobTitle(String value)
	{
		clear(jobTitle);
		sendKeys(jobTitle, value);
	}


	public String getValueJobTitle() 
	{
		return getText(jobTitle);
	}

	public void setValueJobTitleEvidence(String value)
	{
		clear(jobTitleEvidence);
		sendKeys(jobTitleEvidence, value);
	}


	public String getValueJobTitleEvidence() 
	{
		return getText(jobTitleEvidence);
	}

	public void setValueJobFunction(String value)
	{
		clear(jobFunction);
		sendKeys(jobFunction, value);
	}


	public String getValueJobFunction() 
	{
		return getText(jobFunction);
	}

	public void setValueCompanyName(String value)
	{
		clear(companyName);
		sendKeys(companyName, value);
	}


	public String getValueCompanyName() 
	{
		return getText(companyName);
	}

	public String getValueCompanyNameTargetListMatch1() 
	{
		return getText(companyNameTargetListMatch1);
	}
	
	public String getValueCompanyNameTargetListMatch2() 
	{
		return getText(companyNameTargetListMatch2);
	}
	
	public String getValueCompanyNameTargetListMatch3() 
	{
		return getText(companyNameTargetListMatch3);
	}
	
	public void setValueIndustry(String value)
	{
		clear(industry);
		sendKeys(industry, value);
	}


	public String getValueIndustry() 
	{
		return getText(industry);
	}

	public void setValueCompanyEvidence(String value)
	{
		clear(companyEvidence);
		sendKeys(companyEvidence, value);
	}


	public String getValueCompanyEvidence() 
	{
		return getText(companyEvidence);
	}

	public void setValueCompanySize(String value)
	{
		clear(companySize);
		sendKeys(companySize, value);
	}


	public String getValueCompanySize() 
	{
		return getText(companySize);
	}

	public void setValueCompanySizeEvidence(String value)
	{
		clear(companySizeEvidence);
		sendKeys(companySizeEvidence, value);
	}


	public String getValueCompanySizeEvidence() 
	{
		return getText(companySizeEvidence);
	}

	public void setValueTurnover(String value)
	{
		clear(turnover);
		sendKeys(turnover, value);
	}


	public String getValueTurnover() 
	{
		return getText(turnover);
	}

	public void setValueTurnoverEvidence(String value)
	{
		clear(turnoverEvidence);
		sendKeys(turnoverEvidence, value);
	}


	public String getValueTurnoverEvidence() 
	{
		return getText(turnoverEvidence);
	}

	public void setValueRejectionReason(String value)
	{
		clear(rejectionReason);
		sendKeys(rejectionReason, value);
	}


	public String getValueRejectionReason() 
	{
		return getText(rejectionReason);
	}

	public void setValueRejectionReasonEvidence(String value)
	{
		clear(rejectionReasonEvidence);
		sendKeys(rejectionReasonEvidence, value);
	}


	public String getValueRejectionReasonEvidence() 
	{
		return getText(rejectionReasonEvidence);
	}

	public void setValueUserAgent(String value)
	{
		clear(userAgent);
		sendKeys(userAgent, value);
	}


	public String getValueUserAgent() 
	{
		return getText(userAgent);
	}

	public void setValueLeadType(String value)
	{
		clear(leadType);
		sendKeys(leadType, value);
	}


	public String getValueLeadType() 
	{
		return getText(leadType);
	}

	public void setValueSfdcCode(String value)
	{
		clear(sfdcCode);
		sendKeys(sfdcCode, value);
	}


	public String getValueSfdcCode() 
	{
		return getText(sfdcCode);
	}

	public void setValueProductOfInterest(String value)
	{
		clear(productOfInterest);
		sendKeys(productOfInterest, value);
	}


	public String getValueProductOfInterest() 
	{
		return getText(productOfInterest);
	}

	public void setValueCallComments(String value)
	{
		clear(callComments);
		sendKeys(callComments, value);
	}


	public String getValueCallComments() 
	{
		return getText(callComments);
	}

	public void setValueSecure(String value)
	{
		clear(secure);
		sendKeys(secure, value);
	}


	public String getValueSecure() 
	{
		return getText(secure);
	}

	public void setValueBiggestChallenge(String value)
	{
		clear(biggestChallenge);
		sendKeys(biggestChallenge, value);
	}


	public String getValueBiggestChallenge() 
	{
		return getText(biggestChallenge);
	}

	public void setValueWhichPlatforms(String value)
	{
		clear(whichPlatforms);
		sendKeys(whichPlatforms, value);
	}


	public String getValueWhichPlatforms() 
	{
		return getText(whichPlatforms);
	}
	
	public void selectValueEmailToolsDropdown(String value)
	{
		selectByVisibleText(emailToolsDropdown, value);
	}
	
	public void selectValuePhoneReformatDropdown(String value)
	{
		selectByVisibleText(phoneReformatDropdown, value);
	}
	
	public void selectValuePhoneToolsDropdown(String value)
	{
		selectByVisibleText(phoneToolsDropdown, value);
	}
	
	public void selectValuePhoneReformatDropdown2(String value)
	{
		selectByVisibleText(phoneReformatDropdown2, value);
	}
	
	public void selectValueCountryDropdown(String value)
	{
		selectByVisibleText(countryDropdown, value);
	}
	
	public void selectValueJobTitleDropdown(String value)
	{
		selectByVisibleText(jobTitleDropdown, value);
	}
	
	public void selectValueJobFunctionDropdown(String value)
	{
		selectByVisibleText(jobFunctionDropdown, value);
	}
	
	public void selectValueCompanyToolsDropdown(String value)
	{
		selectByVisibleText(companyToolsDropdown, value);
	}
	
	public void selectValueIndustryDropdown(String value)
	{
		selectByVisibleText(industryDropdown, value);
	}
	
	public void selectValueCompanySizeDropDown(String value)
	{
		selectByVisibleText(companySizeDropDown, value);
	}
	
	public void selectValueTurnoverDropdown(String value)
	{
		selectByVisibleText(turnoverDropdown, value);
	}
	
	public void selectValueTurnoverCompanyToolsDropdown(String value)
	{
		selectByVisibleText(turnoverCompanyToolsDropdown, value);
	}
	
	public void selectValueRejectionReasonDropdown(String value)
	{
		selectByVisibleText(rejectionReasonDropdown, value);
	}
	
	public void selectValueCallCommentsDropDown(String value)
	{
		selectByVisibleText(callCommentsDropDown, value);
	}
	
}

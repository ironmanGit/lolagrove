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

public class LeadPageObjects extends PageFactoryInitializer {
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

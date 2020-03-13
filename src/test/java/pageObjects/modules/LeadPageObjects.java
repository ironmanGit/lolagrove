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

}

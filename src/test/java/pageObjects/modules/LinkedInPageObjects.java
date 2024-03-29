/**
 * 
 */
package pageObjects.modules;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pageObjects.initializePageObjects.PageFactoryInitializer;
import utils.ExplicitWaiting;
import utils.RandomGenerator;
import utils.ExtentReports.ExtentTestManager;
import com.relevantcodes.extentreports.LogStatus;

/**
 * @Author Vivekanandan Sampath
 * @Date Mar 09, 2020
 */
public class LinkedInPageObjects extends PageFactoryInitializer {

	private Logger logger = Logger.getLogger(LeadPageObjects.class.getName());

	@FindBy(xpath = "//dt[text()='Website']/following-sibling::dd[1]/a")
	private WebElement websiteValue;

	@FindBy(xpath = "//dt[text()='Industry']/following-sibling::dd[1]")
	private WebElement industriesValue;

	@FindBy(xpath = "//dt[text()='Company size']/following-sibling::dd[1]")
	private WebElement companySizeValue;

	@FindBy(xpath = "//dt[text()='Headquarters']/following-sibling::dd[1]")
	private WebElement headquartersValue;

	@FindBy(xpath = "//dt[text()='Type']/following-sibling::dd[1]")
	private WebElement typeValue;

	@FindBy(xpath = "//dt[text()='Founded']/following-sibling::dd[1]")
	private WebElement foundedValue;

	@FindBy(xpath = "//dt[text()='Specialties']/following-sibling::dd[1]")
	private WebElement specialtiesValue;

	@FindBy(css = "section.pv-top-card div.display-flex+div div>ul")
	private WebElement fullName;

	@FindBy(xpath = "//h4/span[contains(text(), 'Present')]/../../../h3")
	private List<WebElement> jobTitle1;

	@FindBy(xpath = "//h4/span[contains(text(), 'Present')]/../../../h3/span[2]")
	private List<WebElement> jobTitle2;

	@FindBy(css = "div h2.top-card-layout__headline")
	private List<WebElement> jobTitle3;
	
	@FindBy(css = "div h2.mt1")
	private List<WebElement> jobTitle4;
	
	@FindBy(css = "ul.pv-top-card--experience-list li>a>span")
	private WebElement jobCompany;

	@FindBy(css = "div+ p a[data-control-name='organization_non_eligible_learn_more_link']")
	private WebElement orgNonEligible;

	public String getWebsiteValue() throws Exception {
		String value = getText(websiteValue);
		try {
			if (value != null) {
				ExtentTestManager.getTest().log(LogStatus.PASS, "website value is " + value);
			} else
				ExtentTestManager.getTest().log(LogStatus.INFO, "website value is null");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to get value from website " + e);
		}
		return value;
	}

	public String getIndustriesValue() throws Exception {
		String value = null;
		if (isFieldExist(companySizeValue)) {
			value = getText(industriesValue);
			try {
				if (value != null) {
					campaignTestDataProcess().setLinkedinIndustry(value);
					ExtentTestManager.getTest().log(LogStatus.PASS, "industries value is " + value);
				} else
					ExtentTestManager.getTest().log(LogStatus.INFO, "industries value is null");
			} catch (Exception e) {
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to get value from industries " + e);
			}
		} else {
			value = null;
		}

		return value;
	}

	public String getCompanySizeValue(String type) throws Exception {
		String value = null;
		if (isFieldExist(orgNonEligible)) {
			ExtentTestManager.getTest().log(LogStatus.INFO, "org search in linkedin reached unclaimed page");
		} else {
			if (isFieldExist(companySizeValue)) {
				ExplicitWaiting.explicitWaitVisibilityOfElement(companySizeValue, 15);
				value = getText(companySizeValue).replaceAll("[a-z]| ", "");
				value = value.replaceAll(".+(?<=-)", "");
				value = value.replaceAll("([,|+])", "");
				value = roundOffCompanySize(type, value);
				try {
					if (value != null) {
						ExtentTestManager.getTest().log(LogStatus.PASS, "companySize value is " + value);
					} else
						ExtentTestManager.getTest().log(LogStatus.INFO, "companySize value is null");
				} catch (Exception e) {
					ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to get value from companySize " + e);
				}
			} else {
				value = null;
			}
		}
		return value;
	}

	public String getHeadquartersValue() throws Exception {
		String value = getText(headquartersValue);
		try {
			if (value != null) {
				ExtentTestManager.getTest().log(LogStatus.PASS, "headquarters value is " + value);
			} else
				ExtentTestManager.getTest().log(LogStatus.INFO, "headquarters value is null");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to get value from headquarters " + e);
		}
		return value;
	}

	public String getTypeValue() throws Exception {
		String value = getText(typeValue);
		try {
			if (value != null) {
				ExtentTestManager.getTest().log(LogStatus.PASS, "type value is " + value);
			} else
				ExtentTestManager.getTest().log(LogStatus.INFO, "type value is null");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to get value from type " + e);
		}
		return value;
	}

	public String getFoundedValue() throws Exception {
		String value = getText(foundedValue);
		try {
			if (value != null) {
				ExtentTestManager.getTest().log(LogStatus.PASS, "founded value is " + value);
			} else
				ExtentTestManager.getTest().log(LogStatus.INFO, "founded value is null");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to get value from founded " + e);
		}
		return value;
	}

	public String getSpecialtiesValue() throws Exception {
		String value = getText(specialtiesValue);
		try {
			if (value != null) {
				ExtentTestManager.getTest().log(LogStatus.PASS, "specialties value is " + value);
			} else
				ExtentTestManager.getTest().log(LogStatus.INFO, "specialties value is null");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to get value from specialties " + e);
		}
		return value;
	}

	public LeadPageObjects closeLinkedInPage() throws Exception {
		try {
			closeTab();
			ExtentTestManager.getTest().log(LogStatus.PASS, "Linkedin page is closed");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to close linkedin page" + e);
		}
		return leadPage();
	}

	public String getFullNameValue() throws Exception {
		String value = getText(fullName);
		try {
			if (value != null) {
				ExtentTestManager.getTest().log(LogStatus.PASS, "full name value is " + value);
			} else
				ExtentTestManager.getTest().log(LogStatus.INFO, "full name value is null");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to get value from full name " + e);
		}
		return value;
	}

	public String getJobTitleValue() throws Exception {
		int jobtitle1Size = jobTitle1.size();
		int jobtitle2Size = jobTitle2.size();
		int jobtitle3Size = jobTitle3.size();
		int jobtitle4Size = jobTitle4.size();
		String value = null;
		if (jobtitle2Size > 0) {
			WebElement jobTitle = jobTitle2.get(0);
			ExplicitWaiting.explicitWaitVisibilityOfElement(jobTitle, 15);
			value = getText(jobTitle);
			value = value.replaceAll("(?= at).+", "");
			try {
				if (value != null) {
					ExtentTestManager.getTest().log(LogStatus.PASS, "job title value is " + value);
				} else
					ExtentTestManager.getTest().log(LogStatus.INFO, "job title value is null");
			} catch (Exception e) {
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to get value from job title " + e);
			}
		} else if (jobtitle1Size > 0) {
			WebElement jobTitle = jobTitle1.get(0);
			ExplicitWaiting.explicitWaitVisibilityOfElement(jobTitle, 15);
			value = getText(jobTitle);
			value = value.replaceAll("(?= at).+", "");
			try {
				if (value != null) {
					ExtentTestManager.getTest().log(LogStatus.PASS, "job title value is " + value);
				} else
					ExtentTestManager.getTest().log(LogStatus.INFO, "job title value is null");
			} catch (Exception e) {
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to get value from job title " + e);
			}
		} else if (jobtitle3Size > 0) {
			WebElement jobTitle = jobTitle3.get(0);
			ExplicitWaiting.explicitWaitVisibilityOfElement(jobTitle, 15);
			value = getText(jobTitle);
			value = value.replaceAll("(?= at).+", "");
			try {
				if (value != null) {
					ExtentTestManager.getTest().log(LogStatus.PASS, "job title value is " + value);
				} else
					ExtentTestManager.getTest().log(LogStatus.INFO, "job title value is null");
			} catch (Exception e) {
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to get value from job title " + e);
			}
		} else if (jobtitle4Size > 0) {
			WebElement jobTitle = jobTitle4.get(0);
			ExplicitWaiting.explicitWaitVisibilityOfElement(jobTitle, 15);
			value = getText(jobTitle);
			value = value.replaceAll("(?= at).+", "");
			try {
				if (value != null) {
					ExtentTestManager.getTest().log(LogStatus.PASS, "job title value is " + value);
				} else
					ExtentTestManager.getTest().log(LogStatus.INFO, "job title value is null");
			} catch (Exception e) {
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to get value from job title " + e);
			}
		}
		return value;
	}

	public String getCompanyValue() throws Exception {
		String value = getText(jobCompany);
		try {
			if (value != null) {
				ExtentTestManager.getTest().log(LogStatus.PASS, "person company value is " + value);
			} else
				ExtentTestManager.getTest().log(LogStatus.INFO, "person company value is null");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to get value from person company " + e);
		}
		return value;
	}
}

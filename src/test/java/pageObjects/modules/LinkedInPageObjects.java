/**
 * 
 */
package pageObjects.modules;

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

	@FindBy(xpath = "//dt[contains(text(), 'Website')]/following-sibling::dd[1]")
	private WebElement websiteValue;

	@FindBy(xpath = "//dt[contains(text(), 'Industries')]/following-sibling::dd[1]")
	private WebElement industriesValue;

	@FindBy(xpath = "//dt[contains(text(), 'Company size')]/following-sibling::dd[1]")
	private WebElement companySizeValue;

	@FindBy(xpath = "//dt[contains(text(), 'Headquarters')]/following-sibling::dd[1]")
	private WebElement headquartersValue;

	@FindBy(xpath = "//dt[contains(text(), 'Type')]/following-sibling::dd[1]")
	private WebElement typeValue;

	@FindBy(xpath = "//dt[contains(text(), 'Founded')]/following-sibling::dd[1]")
	private WebElement foundedValue;

	@FindBy(xpath = "//dt[contains(text(), 'Specialties')]/following-sibling::dd[1]")
	private WebElement specialtiesValue;

	@FindBy(css = "div h1.top-card-layout__title")
	private WebElement fullName;
	
	@FindBy(css = "div h2.top-card-layout__headline")
	private WebElement jobTitle;
	
	@FindBy(css = "div[data-section='currentPositionsDetails'] a span.top-card-link__description")
	private WebElement jobCompany;
	
	public String getWebsiteValue() throws Exception {
		//ExplicitWaiting.explicitWaitVisibilityOfElement(websiteValue, 15);
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
		//ExplicitWaiting.explicitWaitVisibilityOfElement(industriesValue, 15);
		String value = getText(industriesValue);
		try {
			if (value != null) {
				ExtentTestManager.getTest().log(LogStatus.PASS, "industries value is " + value);
			} else
				ExtentTestManager.getTest().log(LogStatus.INFO, "industries value is null");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to get value from industries " + e);
		}
		return value;
	}

	public String getCompanySizeValue() throws Exception {
		//ExplicitWaiting.explicitWaitVisibilityOfElementLinkedIn(companySizeValue, 15);
		WebElement companySizeValue1 = getLinkedInWebDriver().findElement(By.xpath("//dt[contains(text(), 'Company size')]/following-sibling::dd[1]"));
		String value = getText(companySizeValue1).replaceAll("[a-z]| ", "");
		//String value = getText(companySizeValue);
		value = value.replaceAll(".+(?<=-)", "");
		value = value.replaceAll("([,|+])", "");
		value = roundOffCompanySize(value);
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

	public String getHeadquartersValue() throws Exception {
		//ExplicitWaiting.explicitWaitVisibilityOfElement(headquartersValue, 15);
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
		//ExplicitWaiting.explicitWaitVisibilityOfElement(typeValue, 15);
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
		//ExplicitWaiting.explicitWaitVisibilityOfElement(foundedValue, 15);
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
		//ExplicitWaiting.explicitWaitVisibilityOfElement(specialtiesValue, 15);
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
		//ExplicitWaiting.explicitWaitVisibilityOfElement(fullName, 15);
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
		//ExplicitWaiting.explicitWaitVisibilityOfElement(jobTitle, 15);
		String value = getText(jobTitle);
		value = value.replaceAll("(?= at).+", "");
		try {
			if (value != null) {
				ExtentTestManager.getTest().log(LogStatus.PASS, "job title value is " + value);
			} else
				ExtentTestManager.getTest().log(LogStatus.INFO, "job title value is null");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to get value from job title " + e);
		}
		return value;
	}
	
	public String getCompanyValue() throws Exception {
		//ExplicitWaiting.explicitWaitVisibilityOfElement(jobCompany, 15);
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

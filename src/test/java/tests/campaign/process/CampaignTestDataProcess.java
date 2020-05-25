package tests.campaign.process;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.log4j.Logger;
import pageObjects.initializePageObjects.PageFactoryInitializer;
import utils.ExcelUtils;

public class CampaignTestDataProcess extends PageFactoryInitializer {
	private static Logger logger = Logger.getLogger(CampaignTestDataProcess.class.getName());
	
	private static List<String> campaignDataLines = new ArrayList<String>();
	private static List<CampaignDataRecord> campaignLeadsData = new ArrayList<CampaignDataRecord>();
	private static String leadsPlacment;
	private static String leadsCompanySize;
	private static String leadsJobFunction;
	private static String leadsJobTitle;
	private static String leadsCountry;
	private static String leadsCompanyName;
	private static String email;
	private static List<String> leadsCompanyListDetails = new ArrayList<String>();
	private static List<String> leadsIndustrialVertical = new ArrayList<String>();
	private static String companySizeDropdownType;

	public List<CampaignDataRecord> getCampaignLeadsData() {
		return campaignLeadsData;
	}

	public void setCampaignLeadsData(List<CampaignDataRecord> campaignLeadsData) {
		this.campaignLeadsData = campaignLeadsData;
	}

	public List<String> getcampaignDataLines() {
		return campaignDataLines;
	}

	public void setcampaignDataLines(List<String> campaignDataLines) {
		this.campaignDataLines = campaignDataLines;
	}

	public String getLeadsPlacment() {
		return leadsPlacment;
	}

	public void setLeadsPlacment(String leadsPlacment) {
		this.leadsPlacment = leadsPlacment;
	}

	public String getLeadsCompanySize() {
		return leadsCompanySize;
	}

	public void setLeadsCompanySize(String leadsCompanySize) {
		this.leadsCompanySize = leadsCompanySize;
	}

	public List<String> getLeadsIndustrialVertical() {
		return leadsIndustrialVertical;
	}

	public void setLeadsIndustrialVertical(List<String> leadsIndustrialVertical) {
		this.leadsIndustrialVertical = leadsIndustrialVertical;
	}

	public String getLeadsJobFunction() {
		return leadsJobFunction;
	}

	public void setLeadsJobFunction(String leadsJobFunction) {
		this.leadsJobFunction = leadsJobFunction;
	}

	public String getLeadsJobTitle() {
		return leadsJobTitle;
	}

	public void setLeadsJobTitle(String leadsJobTitle) {
		this.leadsJobTitle = leadsJobTitle;
	}

	public String getLeadsCountry() {
		return leadsCountry;
	}

	public void setLeadsCountry(String leadsCountry) {
		this.leadsCountry = leadsCountry;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getCompanySizeDropdownType() {
		return companySizeDropdownType;
	}

	public void setCompanySizeDropdownType(String companySizeDropdownType) {
		this.companySizeDropdownType = companySizeDropdownType;
	}
	
	public String getLeadsCompanyName() {
		return leadsCompanyName;
	}

	public void setLeadsCompanyName(String leadsCompanyName) {
		this.leadsCompanyName = leadsCompanyName;
	}
	
	public List<String> getLeadsCompanyListDetails() {
		return leadsCompanyListDetails;
	}

	public void setLeadsCompanyListDetails(List<String> leadsCompanyList) {
		this.leadsCompanyListDetails = leadsCompanyList;
	}
	
	public static String getCustomRegions(String type, String FilePath) throws Exception {
		String result = null;

		List<String> lines = ExcelUtils.readFileToLines(FilePath);
		for (String line : lines) {
			String[] columns = line.split(",");
			String regionType = columns[0];
			String regionValue = columns[1];
			if (regionType.equals(type)) {
				regionValue = regionValue.toString();
				result = regionValue;
				result = result.replace("|", ",");
				break;
			}
		}

		if (result == null) {
			throw new Exception("Error : Cannot find region type for " + type + " from file " + FilePath);
		}

		return result;
	}

	//Added by Anand
	public static List<String> getJobRoleInfo(String JobTitle) throws Exception {
		String filePath = "./src/test/resources/Test Data/Excel Files/JobRoleInfo.csv";
		List<String> JobRole = getJobRoleInfo(JobTitle, filePath);
		return JobRole;
	}

	//Added by Anand
	public static List<String> getJobFunctionInfo(String JobTitle) throws Exception {
		String filePath = "./src/test/resources/Test Data/Excel Files/JobFunctionInfo.csv";
		List<String> JobFunction = getJobFunctionInfo(JobTitle, filePath);
		return JobFunction;
	}
	
	//Added by Anand
	public static List<String> getIndustryInfo(String IndustryFromSite) throws Exception {
		String filePath = "./src/test/resources/Test Data/Excel Files/IndustryInfo.csv";
		List<String> Industries = getIndustryInfo(IndustryFromSite, filePath);
		return Industries;
	}
	
	//Added by Anand
	public static List<String> getIndustryVertical() throws Exception {
		String filePath = "./src/test/resources/Test Data/Excel Files/IndustryVertical.csv";
		List<String> AcceptedIndustries = getIndustryInfo(filePath);
		return AcceptedIndustries;
	}
	
	//Added by Anand
	public static List<String> getIndustryVertical(String FilePath) throws Exception {
		List<String> getIndustries = new ArrayList<String>();
		List<String> lines = ExcelUtils.readFileToLines(FilePath);
		for (String line : lines) {
			String[] columns = line.split(",");
			String industry = columns[0];
			String status = columns[1];
			System.out.println(industry);
			System.out.println(status);
			if (status.contains("Yes")) {
				industry = industry.toString();
				getIndustries.add(industry);
				System.out.println(getIndustries);
			}
		}
		return getIndustries;
	}
	
	//Added by Anand
	public static List<String> getIndustryInfo(String IndustryFromSite, String FilePath) throws Exception {
		List<String> mapIndustries = new ArrayList<String>();
		List<String> lines = ExcelUtils.readFileToLines(FilePath);
		for (String line : lines) {
			String[] columns = line.split(",");
			String FinalIndustry = columns[0];
			String Industry = columns[1];
			System.out.println(FinalIndustry);
			System.out.println(Industry);
			if (IndustryFromSite.contains(Industry)) {
				FinalIndustry = FinalIndustry.toString();
				mapIndustries.add(FinalIndustry);
				System.out.println(mapIndustries);
			}
		}
		return mapIndustries;
	}
	
	//Added by Anand
	public static List<String> getJobRoleInfo(String JobTitle, String FilePath) throws Exception {
		List<String> matchingRoles = new ArrayList<String>();
		List<String> lines = ExcelUtils.readFileToLines(FilePath);
		for (String line : lines) {
			String[] columns = line.split(",");
			String JTitle = columns[1];
			String JobRoleValue = columns[0];
			if (JobTitle.contains(JTitle)) {
				JobRoleValue = JobRoleValue.toString();
				matchingRoles.add(JobRoleValue);
				System.out.println(JobRoleValue);
			}
		}
//		if (result == null) {
//			throw new Exception("Error : Cannot find Job Tile: " + JobTitle + " from the CSV file for Job Function Field" + FilePath);
//		}
		return matchingRoles;
	}
	
	//Added by Anand
	public static List<String> getJobFunctionInfo(String JobTitle, String FilePath) throws Exception {
		List<String> matchingFunctions = new ArrayList<String>();
		List<String> lines = ExcelUtils.readFileToLines(FilePath);
		for (String line : lines) {
			String[] columns = line.split(",");
			String JTitle = columns[1];
			String JobFunctionValue = columns[0];
			if (JobTitle.contains(JTitle)) {
				JobFunctionValue = JobFunctionValue.toString();
				matchingFunctions.add(JobFunctionValue);
				System.out.println(JobFunctionValue);
			}
		}
		return matchingFunctions;
	}
	
	public static List<String> getCustomRegions(String region) throws Exception {
		String filePath = "./src/test/resources/Test Data/Excel Files/CustomRegionsMapping.csv";
		String customRegions = getCustomRegions(region, filePath);
		List<String> listOfCusRegions = Arrays.asList(customRegions);
		return listOfCusRegions;
	}

	public static List<String> getCountryMapping(String country) throws Exception {
		String filePath = "./src/test/resources/Test Data/Excel Files/CountryCodeMapping.csv";
		List<String> result = new ArrayList<String>();
		List<String> lines = ExcelUtils.readFileToLines(filePath);
		if (country.equals("USA")) {
			country = "United States of America";
		}
		for (String line : lines) {
			String[] columns = line.split(",");
			String countryName = columns[0];
			String countryCodeOne = columns[1];
			String countryCodeTwo = columns[2];
			if (countryName.contains(country)) {
					result.add(countryCodeOne);
					result.add(countryCodeTwo);
					break;
				}
			}
		logger.info("Country codes "+" "+result.get(0)+" "+result.get(1));
		return result;
	}	
}

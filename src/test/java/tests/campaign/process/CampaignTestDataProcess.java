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
	private static String leadsIndustrialVertical;
	private static String leadsJobFunction;
	private static String leadsJobTitle;
	private static String leadsCountry;
	private static String leadsCompanyName;
	private static List<String> leadsCompanyListDetails = new ArrayList<String>();

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

	public String getLeadsIndustrialVertical() {
		return leadsIndustrialVertical;
	}

	public void setLeadsIndustrialVertical(String leadsIndustrialVertical) {
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
	public static String[] getJobRoleInfo(String JobTitle) throws Exception {
		String filePath = "./src/test/resources/Test Data/Excel Files/JobRoleInfo.csv";
		String[] JobRole = getJobRoleInfo(JobTitle, filePath);
		return JobRole;
	}

	//Added by Anand
	public static String[] getJobFunctionInfo(String JobTitle) throws Exception {
		String filePath = "./src/test/resources/Test Data/Excel Files/JobFunctionInfo.csv";
		String[] JobFunction = getJobFunctionInfo(JobTitle, filePath);
//		List<String> listOfJobFunction = Arrays.asList(JobFunction);
		return JobFunction;
	}
	
	//Added by Anand
	public static String[] getIndustries() throws Exception {
		String filePath = "./src/test/resources/Test Data/Excel Files/IndustryVertical.csv";
		String[] Industries = getIndustries(filePath);
		return Industries;
	}
	
	//Added by Anand
	@SuppressWarnings("null")
	public static String[] getIndustries(String FilePath) throws Exception {
		String[] acceptedIndustries = null;
		int counter=0;
		List<String> lines = ExcelUtils.readFileToLines(FilePath);
		for (String line : lines) {
			String[] columns = line.split(",");
			String IndustryName = columns[0];
			String IndustryStatus = columns[1];
			System.out.println(IndustryName);
			System.out.println(IndustryStatus);
			if (IndustryStatus.contains("Yes")) {
				IndustryName = IndustryName.toString();
				acceptedIndustries[counter] = IndustryName;
				counter++;
				System.out.println(acceptedIndustries);
			}
		}
		return acceptedIndustries;
	}
	
	//Added by Anand
	@SuppressWarnings("null")
	public static String[] getJobRoleInfo(String JobTitle, String FilePath) throws Exception {
		//String result = null;
		String[] matchingRoles = null;
		int counter=0;
		List<String> lines = ExcelUtils.readFileToLines(FilePath);
		for (String line : lines) {
			String[] columns = line.split(",");
			String JTitle = columns[1];
			String JobRoleValue = columns[0];
			System.out.println(JobTitle);
			System.out.println(JTitle);
			if (JobTitle.contains(JTitle)) {
				JobRoleValue = JobRoleValue.toString();
				matchingRoles[counter] = JobRoleValue;
				counter++;
				System.out.println(JobRoleValue);
				//break;
			}
		}
		if (result == null) {
			throw new Exception("Error : Cannot find Job Tile: " + JobTitle + " from the CSV file for Job Function Field" + FilePath);
		}
		return matchingRoles;
	}
	
	//Added by Anand
	@SuppressWarnings("null")
	public static String[] getJobFunctionInfo(String JobTitle, String FilePath) throws Exception {
//		String result = null;
		String[] matchingFunctions = null;
		int counter=0;
		
		List<String> lines = ExcelUtils.readFileToLines(FilePath);
		for (String line : lines) {
			String[] columns = line.split(",");
			String JTitle = columns[1];
			String JobFunctionValue = columns[0];
			System.out.println(JobTitle);
			System.out.println(JTitle);
			if (JobTitle.contains(JTitle)) {
				JobFunctionValue = JobFunctionValue.toString();
				matchingFunctions[counter] = JobFunctionValue;
				counter++;
				System.out.println(JobFunctionValue);
//				break;
			}
		}

		if (result == null) {
			throw new Exception("Error : Cannot find Job Tile: " + JobTitle + " from the CSV file for Job Function Field" + FilePath);
		}

		return matchingFunctions;
	}
	
	public static List<String> getCustomRegions(String region) throws Exception {
		String filePath = "./src/test/resources/Test Data/Excel Files/CustomRegionsMapping.csv";
		String customRegions = getCustomRegions(region, filePath);
		List<String> listOfCusRegions = Arrays.asList(customRegions);
		return listOfCusRegions;
	}

	public static String getCountryMapping(String country, String countryCode, String FilePath) throws Exception {
		String result = null;
		List<String> lines = ExcelUtils.readFileToLines(FilePath);
		for (String line : lines) {
			String[] columns = line.split(",");
			String countryName = columns[0];
			String countryCodeOne = columns[1];
			String countryCodeTwo = columns[2];
			if (countryName.contains(country)) {
				if (countryCode.equals("countryCode1")) {
					result = countryCodeOne;
					break;
				} else {
					result = countryCodeTwo;
					break;
				}
			}
		}

		if (result == null) {
			throw new Exception("Error : Cannot find country code for " + country + " from file " + FilePath);
		}

		return result;
	}

	public static List<String> getCountryMapping(String country, String countryCode) throws Exception {
		String filePath = "./src/test/resources/Test Data/Excel Files/CountryCodeMapping.csv";
		String countryMap = getCountryMapping(country, countryCode, filePath);
		List<String> listOfCountryMapping = Arrays.asList(countryMap);
		return listOfCountryMapping;
	}
	
}

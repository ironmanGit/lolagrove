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
	private static String LinkedinIndustry;
	private static String OpenNotesIndustryVertical;
	private static List<String> leadsCompanyListDetails = new ArrayList<String>();
	private static List<String> leadsIndustrialVertical = new ArrayList<String>();
	private static List<String> leadsExclusionCompanyListDetails = new ArrayList<String>();
	private static String companySizeDropdownType;
	private static String turnoverDropdownType;
	private static List<String> leadsCompanyListUrl;
	private static List<String> leadsCompanyExclusionListUrl;

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
	
	public String getOpenNotesIndustryVertical() {
		return OpenNotesIndustryVertical;
	}

	public void setOpenNotesIndustryVertical(String openNotesIndustryVertical) {
		this.OpenNotesIndustryVertical = openNotesIndustryVertical;
	}

	public List<String> getLeadsIndustrialVertical() {
		return leadsIndustrialVertical;
	}

	public void setLeadsIndustrialVertical(List<String> leadsIndustrialVertical) {
		this.leadsIndustrialVertical = leadsIndustrialVertical;
	}
	
	public String getLinkedinIndustry() {
		return LinkedinIndustry;
	}

	public void setLinkedinIndustry(String linkedinIndustry) {
		this.LinkedinIndustry = linkedinIndustry;
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
	
	public String getTurnOverDropdownType() {
		return turnoverDropdownType;
	}

	public void setTurnOverDropdownType(String turnoverDropdownType) {
		this.turnoverDropdownType = turnoverDropdownType;
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
	
	public List<String> getLeadsCompanyListUrl() {
		return leadsCompanyListUrl;
	}
	
	public void setLeadsCompanyListDetails(List<String> leadsCompanyList) {
		this.leadsCompanyListDetails = leadsCompanyList;
	}
	
	public void setLeadsCompanyListUrl(List<String> leadsCompanyList) {
		this.leadsCompanyListUrl = leadsCompanyList;
	}
	
	public List<String> getLeadsExclusionCompanyListDetails() {
		return leadsExclusionCompanyListDetails;
	}
	
	public List<String> getLeadsExclusionCompanyListUrl() {
		return leadsCompanyExclusionListUrl;
	}
	
	public void setLeadsExclusionCompanyListDetails(List<String> leadsExclusionCompanyList) {
		this.leadsExclusionCompanyListDetails = leadsExclusionCompanyList;
	}
	
	public void setLeadsExclusionCompanyListUrl(List<String> leadsCompanyExclusionListUrl) {
		this.leadsCompanyExclusionListUrl = leadsCompanyExclusionListUrl;
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
		List<String> AcceptedIndustries = getIndustryVertical(filePath);
		return AcceptedIndustries;
	}
	
	//Added by Anand
	public static List<String> getTelephoneNumber() throws Exception {
		String filePath = "./src/test/resources/Test Data/Excel Files/TelephoneNumber.csv";
		List<String> lines = ExcelUtils.readFileToLines(filePath);
		List<String> telephoneNumber = new ArrayList<String>();
		for (String line : lines) {
			String[] columns = line.split(",");
			telephoneNumber.add(columns[0]);
		}
		return telephoneNumber;
	}
	
	//Added by Anand
	public static List<String> getCountryforTelephone() throws Exception {
		String filePath = "./src/test/resources/Test Data/Excel Files/TelephoneNumber.csv";
		List<String> lines = ExcelUtils.readFileToLines(filePath);
		List<String> country = new ArrayList<String>();
		for (String line : lines) {
			String[] columns = line.split(",");
			country.add(columns[1]);
		}
		return country;
	}
	
	//Added by Anand
	public static String getRegionCode(String sendCountry) throws Exception {
		String filePath = "./src/test/resources/Test Data/Excel Files/RegionCode.csv";
		List<String> lines = ExcelUtils.readFileToLines(filePath);
		String regionCode = "";
		for (String line : lines) {
			String[] columns = line.split(",");
			String country = columns[0];
			String countryCode = columns[1];
			regionCode = columns[2];
			if (country.toLowerCase().contentEquals(sendCountry.toLowerCase())) {
				regionCode = regionCode.toString();
				break;
			}
		}
		return regionCode;
	}
	
	//Added by Anand
	public static List<String> getIndustryVertical(String FilePath) throws Exception {
		List<String> getIndustries = new ArrayList<String>();
		List<String> lines = ExcelUtils.readFileToLines(FilePath);
		for (String line : lines) {
			String[] columns = line.split(",");
			String industry = columns[0];
			String status = columns[1];
			if (status.toLowerCase().contains("yes")) {
				industry = industry.toString();
				getIndustries.add(industry);
			}
		}
		return getIndustries;
	}
	
	//Added by Anand
	public static List<String> getIndustryInfo(String IndustryFromSite, String FilePath) throws Exception {
		List<String> mapIndustries = new ArrayList<String>();
		List<String> lines = ExcelUtils.readFileToLines(FilePath);
		boolean isMatched = false;
		for (String line : lines) {
			String[] columns = line.split(",");
			String FinalIndustry = columns[0];
			String Industry = columns[1];
			if (IndustryFromSite.toLowerCase().contains(Industry.toLowerCase())) {
				isMatched = true;
				FinalIndustry = FinalIndustry.toString();
				mapIndustries.add(FinalIndustry);
			}
		}
		if (!isMatched) {
			logger.info("No Match Found for Industry: "+ IndustryFromSite + " - UPDATE KEYWORD DICTIONARY");
		}
			
		return mapIndustries;
	}
	
	//Added by Anand
	public static List<String> getJobRoleInfo(String JobTitle, String FilePath) throws Exception {
		List<String> matchingRoles = new ArrayList<String>();
		List<String> lines = ExcelUtils.readFileToLines(FilePath);
		boolean isMatched = false;
		for (String line : lines) {
			String[] columns = line.split(",");
			String JTitle = columns[1];
			String JobRoleValue = columns[0];
			if (JobTitle.toLowerCase().contains(JTitle.toLowerCase())) {
				isMatched = true;
				JobRoleValue = JobRoleValue.toString();
				matchingRoles.add(JobRoleValue);
			}
		}
		if (!isMatched) {
			logger.info("No Match Found for Job Title: "+ JobTitle+ " - UPDATE KEYWORD DICTIONARY");
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
		boolean isMatched = false;
		for (String line : lines) {
			String[] columns = line.split(",");
			String JTitle = columns[1];
			String JobFunctionValue = columns[0];
			if (JobTitle.toLowerCase().contains(JTitle.toLowerCase())) {
				isMatched = true;
				JobFunctionValue = JobFunctionValue.toString();
				matchingFunctions.add(JobFunctionValue);
			}
		}
		if (!isMatched) {
			logger.info("No Match Found for Job Title: "+ JobTitle + " - UPDATE KEYWORD DICTIONARY");
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
			if (countryName.toLowerCase().contains(country.toLowerCase())) {
					result.add(countryCodeOne);
					result.add(countryCodeTwo);
					break;
				}
			}
		logger.info("Country codes "+" "+result.get(0)+" "+result.get(1));
		return result;
	}	
}

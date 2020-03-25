package tests.campaign.process;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import pageObjects.initializePageObjects.PageFactoryInitializer;

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
	
}

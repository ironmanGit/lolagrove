package tests.campaign.process;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import pageObjects.initializePageObjects.PageFactoryInitializer;

public class CampaignTestProcess extends PageFactoryInitializer {
	private Logger logger = Logger.getLogger(CampaignTestProcess.class.getName());

	private List<String> campaignDataLines = new ArrayList<String>();
	private List<CampaignDataRecord> campaignLeadsData = new ArrayList<CampaignDataRecord>();
	private String leadsPlacment;
	private String leadsCompanySize;
	private String leadsIndustrialVertical;
	private String leadsJobFunction;
	private String leadsJobTitle;
	private String leadsCountry;
	private String leadsCompanyName;

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

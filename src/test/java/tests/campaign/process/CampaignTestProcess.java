package tests.campaign.process;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import pageObjects.initializePageObjects.PageFactoryInitializer;

public class CampaignTestProcess extends PageFactoryInitializer {
	private Logger logger = Logger.getLogger(CampaignTestProcess.class.getName());

	private List<String> campaignDataLines;
	private List<CampaignDataRecord> campaignLeadsData = new ArrayList<CampaignDataRecord>();

	public List<CampaignDataRecord> getCampaignLeadsData() {
		return campaignLeadsData;
	}

	public void setCampaignLeadsData(List<CampaignDataRecord> campaignLeadsData) {
		this.campaignLeadsData = campaignLeadsData;
	}

	public List<String> getcampaignDataLines() {
		return campaignDataLines;
	}

	public List<String> setcampaignDataLines(List<String> campaignDataLines) {
		return this.campaignDataLines = campaignDataLines;
	}
	
}

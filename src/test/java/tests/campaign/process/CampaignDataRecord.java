package tests.campaign.process;

import org.apache.log4j.Logger;

public class CampaignDataRecord extends CampaignTestDataProcess{
	private Logger logger = Logger.getLogger(CampaignDataRecord.class.getName());
	
	private String campaignLead;
	private String advertiser;
	private String status;
	private String edit;
	private String delete;
	private String eyeballing;
	private String uncheckedLeads;
	
	public CampaignDataRecord(String dataLine) throws Exception {
		final int columns = 7;
		String[] cols = dataLine.split(",");
		int len = cols.length;
		if(len < columns) {
			throw new Exception("Error: Incorrect line = '" + dataLine + "', number of columns "+len + ", should be "+columns);
		}
		int i=0;
		campaignLead = cols[i++];
		advertiser = cols[i++];
		status = cols[i++];
		edit = cols[i++];
		delete = cols[i++];
		eyeballing = cols[i++];
		uncheckedLeads = cols[i++];
	}
	
	public String getCampaignLead() {
		return campaignLead;
	}

	public void setCampaignLead(String campaignLead) {
		this.campaignLead = campaignLead;
	}

	public String getAdvertiser() {
		return advertiser;
	}

	public void setAdvertiser(String advertiser) {
		this.advertiser = advertiser;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getEdit() {
		return edit;
	}

	public void setEdit(String edit) {
		this.edit = edit;
	}

	public String getDelete() {
		return delete;
	}

	public void setDelete(String delete) {
		this.delete = delete;
	}

	public String getEyeballing() {
		return eyeballing;
	}

	public void setEyeballing(String eyeballing) {
		this.eyeballing = eyeballing;
	}

	public String getUncheckedLeads() {
		return uncheckedLeads;
	}

	public void setUncheckedLeads(String uncheckedLeads) {
		this.uncheckedLeads = uncheckedLeads;
	}
	
}

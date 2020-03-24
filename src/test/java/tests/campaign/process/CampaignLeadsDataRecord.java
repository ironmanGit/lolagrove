package tests.campaign.process;

public class CampaignLeadsDataRecord extends CampaignTestProcess{
	private static String eyeIcon;
	private static String verificationStatus;
	private static String leadsId;
	private static String tickIcon;
	private static String rejectionReason;
	private static String wrongIcon;
	private static String email;
	private static String title;
	private static String firstName;
	private static String lastName;
	private static String Address1;
	private static String Address2;
	private static String Address3;
	private static String townCity;
	private static String countryState;
	private static String country;
	private static String postalZipCode;
	private static String telephone;
	private static String source;
	private static String supplierLeadId;
	private static String urlReferrer;
	private static String startTime;
	private static String endTime;
	private static String fingerPrint;
	private static String leadStatus;
	private static String companyName;
	private static String jobTitle;
	private static String industry;
	private static String platform;
	private static String freeListFlag;
	private static String comments;
	private static String leadCreationDate;
	private static String subSource;
	private static String tactic;
	private static String telephone2;
	private static String ADDRESS_C;
	private static String ADDRESS_EVIDENCE;
	private static String COMPANY_C;
	private static String COMPANY_EVIDENCE;
	private static String COMPANYSIZE_EVIDENCE;
	private static String EMAIL_C;
	private static String EMAIL_EVIDENCE;
	private static String INDIVIDUAL_EVIDENCE;
	private static String JOBTITLE_EVIDENCE;
	private static String LINKEDIN_ID_URL;
	private static String PHONE_C;
	private static String PHONE_EVIDENCE;
	private static String REJECTION_EVIDENCE;
	private static String TURNOVER_EVIDENCE;
	private static String UPDATE_DATE;
	private static String COMPANY_SIZE;
	private static String SWITCHING_TO_CLOUD;
	private static String INTERNATIONAL_BUSINESS_PAYMENTS;
	private static String TURNOVER;
	private static String BREACH_DOCUMENTS;
	private static String JOB_EXPERIENCE;
	private static String PHONE2_EVIDENCE;
	private static String VOICE_VERIFIED;
	private static String JOB_FUNCTION;
	private static String ANNUAL_FOREIGN_EXCHANGE;
	private static String ANNUAL_REVENUE;
	private static String PAYMENT_FREQUENCY;
	private static String CALL_COMMENTS;
	private static String INPUT_PLACEMENT;
	private static String SECURE;
	private static String LEAD_TYPE;
	private static String JOB_ROLE;
	private static String TimeStamp;
	private static String Site;
	private static String Placement;
	private static String IPAddress;
	private static String sub_id;
	private static String CALLBACK_ID;
	
	public CampaignLeadsDataRecord(String dataLine) throws Exception {
		final int columns = 73;
		String[] cols = dataLine.split(",");
		int len = cols.length;
		/*
		 * if(len < columns) { throw new Exception("Error: Incorrect line = '" +
		 * dataLine + "', number of columns "+len + ", should be "+columns); }
		 */
		int i=0;
		eyeIcon = cols[i++];
//		verificationStatus = cols[i++];
		leadsId = cols[i++];
//		tickIcon = cols[i++];
//		rejectionReason = cols[i++];
//		wrongIcon = cols[i++];
//		email = cols[i++];
//		title = cols[i++];
//		firstName = cols[i++];
//		lastName = cols[i++];
//		Address1 = cols[i++];
//		Address2 = cols[i++];
//		Address3 = cols[i++];
//		townCity = cols[i++];
//		countryState = cols[i++];
//		country = cols[i++];
//		postalZipCode = cols[i++];
//		telephone = cols[i++];
//		source = cols[i++];
//		supplierLeadId = cols[i++];
//		urlReferrer = cols[i++];
//		startTime = cols[i++];
//		endTime = cols[i++];
//		fingerPrint = cols[i++];
//		leadStatus = cols[i++];
//		companyName = cols[i++];
//		jobTitle = cols[i++];
//		industry = cols[i++];
//		platform = cols[i++];
//		freeListFlag = cols[i++];
//		comments = cols[i++];
//		leadCreationDate = cols[i++];
//		subSource = cols[i++];
//		tactic = cols[i++];
//		telephone2 = cols[i++];
//		ADDRESS_C = cols[i++];
//		ADDRESS_EVIDENCE = cols[i++];
//		COMPANY_C = cols[i++];
//		COMPANY_EVIDENCE = cols[i++];
//		COMPANYSIZE_EVIDENCE = cols[i++];
//		EMAIL_C = cols[i++];
//		EMAIL_EVIDENCE = cols[i++];
//		INDIVIDUAL_EVIDENCE = cols[i++];
//		JOBTITLE_EVIDENCE = cols[i++];
//		LINKEDIN_ID_URL = cols[i++];
//		PHONE_C = cols[i++];
//		PHONE_EVIDENCE = cols[i++];
//		REJECTION_EVIDENCE = cols[i++];
//		TURNOVER_EVIDENCE = cols[i++];
//		UPDATE_DATE = cols[i++];
//		COMPANY_SIZE = cols[i++];
//		SWITCHING_TO_CLOUD = cols[i++];
//		INTERNATIONAL_BUSINESS_PAYMENTS = cols[i++];
//		TURNOVER = cols[i++];
//		BREACH_DOCUMENTS = cols[i++];
//		JOB_EXPERIENCE = cols[i++];
//		PHONE2_EVIDENCE = cols[i++];
//		VOICE_VERIFIED = cols[i++];
//		JOB_FUNCTION = cols[i++];
//		ANNUAL_FOREIGN_EXCHANGE = cols[i++];
//		ANNUAL_REVENUE = cols[i++];
//		PAYMENT_FREQUENCY = cols[i++];
//		CALL_COMMENTS = cols[i++];
//		INPUT_PLACEMENT = cols[i++];
//		SECURE = cols[i++];
//		LEAD_TYPE = cols[i++];
//		JOB_ROLE = cols[i++];
//		TimeStamp = cols[i++];
//		Site = cols[i++];
//		Placement = cols[i++];
//		IPAddress = cols[i++];
//		sub_id = cols[i++];
//		CALLBACK_ID = cols[i++];
	}

	public String getEyeIcon() {
		return eyeIcon;
	}

	public void setEyeIcon(String eyeIcon) {
		this.eyeIcon = eyeIcon;
	}

	public String getVerificationStatus() {
		return verificationStatus;
	}

	public void setVerificationStatus(String verificationStatus) {
		this.verificationStatus = verificationStatus;
	}

	public String getLeadsId() {
		return leadsId;
	}

	public void setLeadsId(String leadsId) {
		this.leadsId = leadsId;
	}

	public String getTickIcon() {
		return tickIcon;
	}

	public void setTickIcon(String tickIcon) {
		this.tickIcon = tickIcon;
	}

	public String getRejectionReason() {
		return rejectionReason;
	}

	public void setRejectionReason(String rejectionReason) {
		this.rejectionReason = rejectionReason;
	}

	public String getWrongIcon() {
		return wrongIcon;
	}

	public void setWrongIcon(String wrongIcon) {
		this.wrongIcon = wrongIcon;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress1() {
		return Address1;
	}

	public void setAddress1(String address1) {
		Address1 = address1;
	}

	public String getAddress2() {
		return Address2;
	}

	public void setAddress2(String address2) {
		Address2 = address2;
	}

	public String getAddress3() {
		return Address3;
	}

	public void setAddress3(String address3) {
		Address3 = address3;
	}

	public String getTownCity() {
		return townCity;
	}

	public void setTownCity(String townCity) {
		this.townCity = townCity;
	}

	public String getCountryState() {
		return countryState;
	}

	public void setCountryState(String countryState) {
		this.countryState = countryState;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPostalZipCode() {
		return postalZipCode;
	}

	public void setPostalZipCode(String postalZipCode) {
		this.postalZipCode = postalZipCode;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getSupplierLeadId() {
		return supplierLeadId;
	}

	public void setSupplierLeadId(String supplierLeadId) {
		this.supplierLeadId = supplierLeadId;
	}

	public String getUrlReferrer() {
		return urlReferrer;
	}

	public void setUrlReferrer(String urlReferrer) {
		this.urlReferrer = urlReferrer;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getFingerPrint() {
		return fingerPrint;
	}

	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
	}

	public String getLeadStatus() {
		return leadStatus;
	}

	public void setLeadStatus(String leadStatus) {
		this.leadStatus = leadStatus;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getFreeListFlag() {
		return freeListFlag;
	}

	public void setFreeListFlag(String freeListFlag) {
		this.freeListFlag = freeListFlag;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getLeadCreationDate() {
		return leadCreationDate;
	}

	public void setLeadCreationDate(String leadCreationDate) {
		this.leadCreationDate = leadCreationDate;
	}

	public String getSubSource() {
		return subSource;
	}

	public void setSubSource(String subSource) {
		this.subSource = subSource;
	}

	public String getTactic() {
		return tactic;
	}

	public void setTactic(String tactic) {
		this.tactic = tactic;
	}

	public String getTelephone2() {
		return telephone2;
	}

	public void setTelephone2(String telephone2) {
		this.telephone2 = telephone2;
	}

	public String getADDRESS_C() {
		return ADDRESS_C;
	}

	public void setADDRESS_C(String aDDRESS_C) {
		ADDRESS_C = aDDRESS_C;
	}

	public String getADDRESS_EVIDENCE() {
		return ADDRESS_EVIDENCE;
	}

	public void setADDRESS_EVIDENCE(String aDDRESS_EVIDENCE) {
		ADDRESS_EVIDENCE = aDDRESS_EVIDENCE;
	}

	public String getCOMPANY_C() {
		return COMPANY_C;
	}

	public void setCOMPANY_C(String cOMPANY_C) {
		COMPANY_C = cOMPANY_C;
	}

	public String getCOMPANY_EVIDENCE() {
		return COMPANY_EVIDENCE;
	}

	public void setCOMPANY_EVIDENCE(String cOMPANY_EVIDENCE) {
		COMPANY_EVIDENCE = cOMPANY_EVIDENCE;
	}

	public String getCOMPANYSIZE_EVIDENCE() {
		return COMPANYSIZE_EVIDENCE;
	}

	public void setCOMPANYSIZE_EVIDENCE(String cOMPANYSIZE_EVIDENCE) {
		COMPANYSIZE_EVIDENCE = cOMPANYSIZE_EVIDENCE;
	}

	public String getEMAIL_C() {
		return EMAIL_C;
	}

	public void setEMAIL_C(String eMAIL_C) {
		EMAIL_C = eMAIL_C;
	}

	public String getEMAIL_EVIDENCE() {
		return EMAIL_EVIDENCE;
	}

	public void setEMAIL_EVIDENCE(String eMAIL_EVIDENCE) {
		EMAIL_EVIDENCE = eMAIL_EVIDENCE;
	}

	public String getINDIVIDUAL_EVIDENCE() {
		return INDIVIDUAL_EVIDENCE;
	}

	public void setINDIVIDUAL_EVIDENCE(String iNDIVIDUAL_EVIDENCE) {
		INDIVIDUAL_EVIDENCE = iNDIVIDUAL_EVIDENCE;
	}

	public String getJOBTITLE_EVIDENCE() {
		return JOBTITLE_EVIDENCE;
	}

	public void setJOBTITLE_EVIDENCE(String jOBTITLE_EVIDENCE) {
		JOBTITLE_EVIDENCE = jOBTITLE_EVIDENCE;
	}

	public String getLINKEDIN_ID_URL() {
		return LINKEDIN_ID_URL;
	}

	public void setLINKEDIN_ID_URL(String lINKEDIN_ID_URL) {
		LINKEDIN_ID_URL = lINKEDIN_ID_URL;
	}

	public String getPHONE_C() {
		return PHONE_C;
	}

	public void setPHONE_C(String pHONE_C) {
		PHONE_C = pHONE_C;
	}

	public String getPHONE_EVIDENCE() {
		return PHONE_EVIDENCE;
	}

	public void setPHONE_EVIDENCE(String pHONE_EVIDENCE) {
		PHONE_EVIDENCE = pHONE_EVIDENCE;
	}

	public String getREJECTION_EVIDENCE() {
		return REJECTION_EVIDENCE;
	}

	public void setREJECTION_EVIDENCE(String rEJECTION_EVIDENCE) {
		REJECTION_EVIDENCE = rEJECTION_EVIDENCE;
	}

	public String getTURNOVER_EVIDENCE() {
		return TURNOVER_EVIDENCE;
	}

	public void setTURNOVER_EVIDENCE(String tURNOVER_EVIDENCE) {
		TURNOVER_EVIDENCE = tURNOVER_EVIDENCE;
	}

	public String getUPDATE_DATE() {
		return UPDATE_DATE;
	}

	public void setUPDATE_DATE(String uPDATE_DATE) {
		UPDATE_DATE = uPDATE_DATE;
	}

	public String getCOMPANY_SIZE() {
		return COMPANY_SIZE;
	}

	public void setCOMPANY_SIZE(String cOMPANY_SIZE) {
		COMPANY_SIZE = cOMPANY_SIZE;
	}

	public String getSWITCHING_TO_CLOUD() {
		return SWITCHING_TO_CLOUD;
	}

	public void setSWITCHING_TO_CLOUD(String sWITCHING_TO_CLOUD) {
		SWITCHING_TO_CLOUD = sWITCHING_TO_CLOUD;
	}

	public String getINTERNATIONAL_BUSINESS_PAYMENTS() {
		return INTERNATIONAL_BUSINESS_PAYMENTS;
	}

	public void setINTERNATIONAL_BUSINESS_PAYMENTS(String iNTERNATIONAL_BUSINESS_PAYMENTS) {
		INTERNATIONAL_BUSINESS_PAYMENTS = iNTERNATIONAL_BUSINESS_PAYMENTS;
	}

	public String getTURNOVER() {
		return TURNOVER;
	}

	public void setTURNOVER(String tURNOVER) {
		TURNOVER = tURNOVER;
	}

	public String getBREACH_DOCUMENTS() {
		return BREACH_DOCUMENTS;
	}

	public void setBREACH_DOCUMENTS(String bREACH_DOCUMENTS) {
		BREACH_DOCUMENTS = bREACH_DOCUMENTS;
	}

	public String getJOB_EXPERIENCE() {
		return JOB_EXPERIENCE;
	}

	public void setJOB_EXPERIENCE(String jOB_EXPERIENCE) {
		JOB_EXPERIENCE = jOB_EXPERIENCE;
	}

	public String getPHONE2_EVIDENCE() {
		return PHONE2_EVIDENCE;
	}

	public void setPHONE2_EVIDENCE(String pHONE2_EVIDENCE) {
		PHONE2_EVIDENCE = pHONE2_EVIDENCE;
	}

	public String getVOICE_VERIFIED() {
		return VOICE_VERIFIED;
	}

	public void setVOICE_VERIFIED(String vOICE_VERIFIED) {
		VOICE_VERIFIED = vOICE_VERIFIED;
	}

	public String getJOB_FUNCTION() {
		return JOB_FUNCTION;
	}

	public void setJOB_FUNCTION(String jOB_FUNCTION) {
		JOB_FUNCTION = jOB_FUNCTION;
	}

	public String getANNUAL_FOREIGN_EXCHANGE() {
		return ANNUAL_FOREIGN_EXCHANGE;
	}

	public void setANNUAL_FOREIGN_EXCHANGE(String aNNUAL_FOREIGN_EXCHANGE) {
		ANNUAL_FOREIGN_EXCHANGE = aNNUAL_FOREIGN_EXCHANGE;
	}

	public String getANNUAL_REVENUE() {
		return ANNUAL_REVENUE;
	}

	public void setANNUAL_REVENUE(String aNNUAL_REVENUE) {
		ANNUAL_REVENUE = aNNUAL_REVENUE;
	}

	public String getPAYMENT_FREQUENCY() {
		return PAYMENT_FREQUENCY;
	}

	public void setPAYMENT_FREQUENCY(String pAYMENT_FREQUENCY) {
		PAYMENT_FREQUENCY = pAYMENT_FREQUENCY;
	}

	public String getCALL_COMMENTS() {
		return CALL_COMMENTS;
	}

	public void setCALL_COMMENTS(String cALL_COMMENTS) {
		CALL_COMMENTS = cALL_COMMENTS;
	}

	public String getINPUT_PLACEMENT() {
		return INPUT_PLACEMENT;
	}

	public void setINPUT_PLACEMENT(String iNPUT_PLACEMENT) {
		INPUT_PLACEMENT = iNPUT_PLACEMENT;
	}

	public String getSECURE() {
		return SECURE;
	}

	public void setSECURE(String sECURE) {
		SECURE = sECURE;
	}

	public String getLEAD_TYPE() {
		return LEAD_TYPE;
	}

	public void setLEAD_TYPE(String lEAD_TYPE) {
		LEAD_TYPE = lEAD_TYPE;
	}

	public String getJOB_ROLE() {
		return JOB_ROLE;
	}

	public void setJOB_ROLE(String jOB_ROLE) {
		JOB_ROLE = jOB_ROLE;
	}

	public String getTimeStamp() {
		return TimeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		TimeStamp = timeStamp;
	}

	public String getSite() {
		return Site;
	}

	public void setSite(String site) {
		Site = site;
	}

	public String getPlacement() {
		return Placement;
	}

	public void setPlacement(String placement) {
		Placement = placement;
	}

	public String getIPAddress() {
		return IPAddress;
	}

	public void setIPAddress(String iPAddress) {
		IPAddress = iPAddress;
	}

	public String getSub_id() {
		return sub_id;
	}

	public void setSub_id(String sub_id) {
		this.sub_id = sub_id;
	}

	public String getCALLBACK_ID() {
		return CALLBACK_ID;
	}

	public void setCALLBACK_ID(String cALLBACK_ID) {
		CALLBACK_ID = cALLBACK_ID;
	}
	
}

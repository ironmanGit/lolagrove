package utils;

public class ErrorRecord {
	
	private String errorMessage = "";
	private Integer numberError = 0;
	
	public Integer getNumberError() {
		return numberError;
	}
	public void setNumberError(Integer numberError) {
		this.numberError = numberError;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public void addNewError(String currentMessage) {
		numberError++;
		errorMessage += currentMessage + "\n";
	}
	
	public void addNotEqualError(String actualFieldName, Object actualValue, String expectedFieldName, Object expectedValue) {
		String currentMessage = actualFieldName + " = " + actualValue.toString() + ", " + expectedFieldName + " = " + expectedValue.toString();
		numberError++;
		errorMessage += "\n" + currentMessage;
	}
	public void addErrorIfNotEqual(String actualFieldName, Object actualValue, String expectedFieldName, Object expectedValue) {
		if (!actualValue.equals(expectedValue)) {
			String currentMessage = actualFieldName + " = " + actualValue.toString() + ", " + expectedFieldName + " = " + expectedValue.toString();
			numberError++;
			errorMessage += "\n" + currentMessage;
		}
	}
	public boolean hasError() {
		boolean hasError = numberError > 0 ? true : false;
		
		return hasError;
	}

}

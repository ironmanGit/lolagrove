package utils;

public class SoftAssert extends ErrorRecord {
	
	// use assert format method
	
	public void assertTrue(boolean validFlag) {
		assertTrue(validFlag, "");
	}
	public void assertTrue(boolean validFlag, String message) {
		if (!validFlag) {
			this.addNewError(message + " expected " + validFlag + ", but found " + !validFlag);
		}
		
	}
	public void assertFalse(boolean validFlag) {
		assertFalse(validFlag, "");
	}
	public void assertFalse(boolean validFlag, String message) {
		if (validFlag) {
			this.addNewError(message + " expected " + !validFlag + ", but found " + validFlag);
		}
		
	}
	public void assertEquals(Object actualValue, Object expectedValue) {
		assertEquals(actualValue, expectedValue, "");
	}

	public void assertEquals(Object actualValue, Object expectedValue, String message) {
		if (!actualValue.equals(expectedValue)) {
			this.addNewError(message + " expected " + expectedValue + ", but found " + actualValue);
		}
	}
	public void assertAll() throws Exception {
		int numberError = this.getNumberError();
		String errorMessage = this.getErrorMessage();
		if (numberError > 0) {
			throw new Exception("\nTotal Error " + numberError + "\n" + errorMessage );
		}
		
	}
	public void merge(SoftAssert Assert2) {
		int numberError = this.getNumberError() + Assert2.getNumberError();;
		String errorMessage = this.getErrorMessage() + Assert2.getErrorMessage();;

		this.setNumberError(numberError);
		this.setErrorMessage(errorMessage);
		
		return;
	}
	
	public void assertNotNull(Object obj) {
		assertNotNull(obj, "");
	}

	public void assertNotNull(Object obj, String message) {
		if (obj == null) {
			this.addNewError(message + " null object obj ");
		}
	}
	public void assertNotEquals(Object actualValue, Object expectedValue) {
		if (actualValue.equals(expectedValue)) {
			this.addNewError(" actualValue = " + actualValue + " should not be equal to expectedValue " + expectedValue);
		}
	}
	public void assertNotEquals(Object actualValue, Object expectedValue, String message) {
		if (actualValue.equals(expectedValue)) {
			this.addNewError(message + " actualValue = " + actualValue + " should not be equal to expectedValue " + expectedValue);
		}
	}

}

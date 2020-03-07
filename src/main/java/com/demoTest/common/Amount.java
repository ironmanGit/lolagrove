package com.demoTest.common;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.apache.log4j.Logger;

public class Amount {
	static Logger logger = Logger.getLogger(Amount.class.getName());
	
	private BigDecimal amt;
	
	private static BigDecimal moneyAmountToBigDecimal(String amountString) {
		boolean isNegative = TestUtils.isNegativeAmount(amountString);
		amountString = TestUtils.filterAmount(amountString);

		int decimalDigit = 0;
		if (amountString.contains(".")) {

			int integerDigit = amountString.indexOf(".");
			int totalDigit = amountString.length() - 1;

			decimalDigit = totalDigit - integerDigit;
			
			amountString = amountString.replace(".", "");
		}

		BigDecimal amount = new BigDecimal(amountString);
		if (decimalDigit > 0) {
			BigDecimal numberTen = new BigDecimal("10");
			for (int i = 0; i < decimalDigit; i++) {
				amount = amount.divide(numberTen);
			}
		}
		if (isNegative) {
			// BigDecimal amount2 = amount.negate();
			amount = amount.negate();
		}
		//logger.info("amountString 5 = " + amountString);
		return amount;
	}

	public BigDecimal getAmt() {
		return amt;
	}

	public void setAmt(BigDecimal amt) {
		this.amt = amt;
	}

	public Amount(Object amount) {
		if (amount == null || amount.equals("")) {
			amt = new BigDecimal(0);
		}
		else if (amount instanceof BigDecimal) {
    		amt =(BigDecimal)amount;
        }
        else {
        	try {
        		amt = moneyAmountToBigDecimal(amount.toString());
        	} catch (Exception e) {
        		e.printStackTrace();
        		logger.error("Error: invalid amount " + amount);
        	}
        }

	}
	public String toString() {
		return amt.toString();
	}
	
	public boolean isNegative() {
		boolean result = amt.compareTo(BigDecimal.ZERO) < 0;
		return result;
	}

	public boolean isPositive() {
		boolean result = amt.compareTo(BigDecimal.ZERO) > 0;
		return result;
	}

	public boolean isZero() {
		boolean result = amt.compareTo(BigDecimal.ZERO) == 0;
		return result;

	}

	@Override
	public boolean equals(Object amt2 ) {
 		boolean result = amt.compareTo(new Amount(amt2).amt) == 0;
		return result;
		
	}
	
	public boolean isGreaterThan(Object amt2) {
		boolean result = amt.compareTo(new Amount(amt2).amt) > 0;
		return result;
	}
	
	public boolean isLessThan(Object amt2) {
		boolean result = amt.compareTo(new Amount(amt2).amt) < 0;
		return result;
	}
	
	public boolean isGreaterThanOrEqualTo(Object amt2) {
		boolean result = isGreaterThan(amt2) || equals(amt2);
		return result;
	}
	
	public boolean isLessThanOrEqualTo(Object amt2) {
		boolean result = isLessThan(amt2) || equals(amt2);
		return result;
	}
	
	public Amount lowerLimit(Object amt2) {
		if (this.isLessThan(amt2)) {
			amt = new Amount(amt2).amt;
		}
		return this;
	}
	
	public Amount upperLimit(Object amt2) {
		if (this.isGreaterThan(amt2)) {
			amt = new Amount(amt2).amt;
		}
		return this;
	}
	
	public Amount lowerLimitZero() {
		if (amt.compareTo(BigDecimal.ZERO) < 0) {
			amt = BigDecimal.ZERO;
		}
		return this;
	}
	
	public Amount upperLimitZero() {
		if (amt.compareTo(BigDecimal.ZERO) > 0) {
			amt = BigDecimal.ZERO;
		}
		return this;
	}
	
	public Amount plus(Object amt2 ) {
		BigDecimal result = amt;
		result = result.add(new Amount(amt2).amt);
		return new Amount(result);
	}
	
	public Amount minus(Object amt2 ) {
		
		BigDecimal result = amt;
		result = result.subtract(new Amount(amt2).amt);
		return new Amount(result);
	}
	
	public Amount negate() {
		BigDecimal result = amt;
		result = result.negate();
		return new Amount(result);
	}
	
	public Amount multiply(Object i) {
		Amount amt2 = new Amount(i);
		BigDecimal result = amt;
		result = result.multiply(amt2.amt);
		return new Amount(result);
	}


	public static String formatStringAmountWithNoDecimalDigit(String stringAmount) throws Exception {
		String result = formatStringAmountWithGivenDecimalDigit(stringAmount, 0);
		
		return stringAmount;
	}
	public static String formatStringAmountWithTwoDecimalDigit(String stringAmount) throws Exception {
		String result = formatStringAmountWithGivenDecimalDigit(stringAmount, 2);
		
		return result;
	}
	public static String formatStringAmountWithGivenDecimalDigit(String stringAmount, int decimalDigit) throws Exception {
		
		stringAmount = new Amount(stringAmount).toString();
		
		if (decimalDigit < 0) {
			throw new Exception("Error: decimalDigit cannot be negative");
		}
		
		if (decimalDigit == 0) {
			if (stringAmount.contains(".")) {
				int decimalPointIndex = stringAmount.indexOf(".");
				int len = stringAmount.length();
				
				int newLen = len;
				for (int index = len; index >= decimalPointIndex; index-- ) {
					if (!stringAmount.substring(index-1, index).equals("0") ) {
						newLen = index;
						break;
					}
				}
				
				stringAmount = stringAmount.substring(0, newLen);
			}
		}
		else {
			int actualLastIndex = stringAmount.length() - 1;
			
			int len = stringAmount.length();
			int newLen = len;
			int decimalPointIndex = stringAmount.indexOf(".");
			if (stringAmount.contains(".")) {
				
				for (int index = len; index > decimalPointIndex + decimalDigit ; index-- ) {
					if (!stringAmount.substring(index-1, index).equals("0") ) {
						newLen = index;
						break;
					}
				}
				
				stringAmount = stringAmount.substring(0, newLen);
			}

			if (!stringAmount.contains(".")) {
				stringAmount += ".";
				decimalPointIndex = newLen;
			}
			
			for (int i = newLen; i < decimalPointIndex + decimalDigit ; i++) {
				stringAmount += "0";
			}
		}
		return stringAmount;
	}
	public Amount divide(Object i) {
		Amount amt2 = new Amount(i);
		BigDecimal result = amt;
		result = result.divide(amt2.amt);
		return new Amount(result);
	}
	public Amount divide(Object i, RoundingMode roundMode) {
		Amount amt2 = new Amount(i);
		BigDecimal result = amt;
		result = result.divide(amt2.amt, 0, roundMode);
		return new Amount(result);
	}

}

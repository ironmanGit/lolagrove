package com.demoTest.common;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
public class DateUtils {
	private static Logger logger = Logger.getLogger(DateUtils.class.getName());

	private static String[] mons = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
	private static String[] monthFullNameList = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

	public static String findMonthFullName(String monthNumber) {
		int monthIndex = Integer.parseInt(monthNumber) - 1;
		String result = monthFullNameList[monthIndex];
		return result;
	}
	
	public static String findMonthName(String monthNumber) {
		String result = findMonthFullName(monthNumber);
		result = result.substring(0, 3);
		return result;
	}
	
	public static String findPreviousMonth(String monthNumberString) {
		Integer monthNumber = Integer.parseInt(monthNumberString) - 1;
		if (monthNumber < 0) {
			monthNumber += 12;
		}
		return monthNumber.toString();
	}
	
	public static String findPreviousMonthName(String monthNumber) {
		int monthIndex = Integer.parseInt(monthNumber) - 2;
		if (monthIndex < 0) {
			monthIndex += 12;
		}
		return mons[monthIndex];
	}
	
	public static String findPreviousMonthYear(String monthNumber, String currentYear) {
		int monthNumberValue = Integer.parseInt(monthNumber);
		String result;
		if (monthNumberValue == 1) {
			Integer yearValue = Integer.parseInt(currentYear) - 1;
			result = yearValue.toString();
		} 	
		else {
			result = currentYear;
		}
		return result;
	}
	
	public static int findMonthNumber(String month) {
		int num = 0;
		int i = 0;
		month = month.toUpperCase();
		for (String mon: mons) {
			i++;
			if (mon.toUpperCase().equals(month.toUpperCase())) {
				num = i;
				break;
			}
		}
		return num;
	}
	
	public static String converttimeStampToChangeHistoryTimeFormat(String timeStamp) {
		 String year = timeStamp.substring(0, 4);
		 String mon = timeStamp.substring(5, 7);
		 String day = timeStamp.substring(8, 10);
		 
		 String hour = timeStamp.substring(11,13);
		 String min = timeStamp.substring(14,16);
		 String sec = timeStamp.substring(17,19);
		 
		 String newResult = mon + "/" + day + "/" + year + " " + hour + ":" + min + ":" + sec;
		 
		 return newResult;
		 

	}
	
	public static String convertChangeHistoryTimeToTimeStampFormat(String timeStamp) {
		 String mon = timeStamp.substring(0, 2);
		 String day = timeStamp.substring(3, 5);
		 String year = timeStamp.substring(6, 10);
		 
		 String hour = timeStamp.substring(11,13);
		 String min = timeStamp.substring(14,16);
		 String sec = timeStamp.substring(17,19);
		 
		 String newResult = year + "-" + mon + "-" + day + " " + hour + ":" + min + ":" + sec + ":000";
		 
		 return newResult;
		 

	}

	public static String getCurrentTimestamp() {
		 java.util.Date date= new java.util.Date();
		 
		 Timestamp ts = new Timestamp(date.getTime());
		 
		 return ts.toString();

	}

	public static String convertTimeStamptoId(String ts) {
		 String id = ts.toString().replaceAll(" ", "_").replaceAll("\\.", "_").replaceAll(":", "_").replaceAll("-", "_");
		 return id;

	}
	public static String getCurrentTimestampInMMddyyyyFormat() throws Exception {
		String ts = getCurrentTimestamp();
			String date1 = ts.substring(0,10);
			logger.info("date1 = '" + date1 + "'");
			
			final String OLD_FORMAT = "yyyy-MM-dd";
			final String NEW_FORMAT = "MM/dd/yyyy";
			
			SimpleDateFormat sdf = new SimpleDateFormat(OLD_FORMAT);
			Date d = sdf.parse(date1);
			sdf.applyPattern(NEW_FORMAT);
			String newDateString = sdf.format(d);
			logger.info("newDateString = '" + newDateString + "'");
		 return newDateString;

	}
	
	public static String getFirstDateOfMonth(int date) {
		
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Calendar c = Calendar.getInstance(); // this takes current date
        
        c.set(Calendar.DAY_OF_MONTH,  date);        
        String dateNew1 = sdf.format(c.getTime());

        return dateNew1;
	}
	
	public static String getFirstDateOfNextMonth(String date) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
	    Calendar c = Calendar.getInstance(); // this takes current date
	    c.set(Calendar.DAY_OF_MONTH,1); 
	    c.add(Calendar.MONTH, 1);  //adding a month directly - gives the start of next month.
	    String firstDate = sdf.format(c.getTime());
	   
	    return firstDate;
	}

//	public static String getCurrentTimestampInMMMddyyyyFormat() throws Exception {
//		String ts = getCurrentTimestamp();
//			String date1 = ts.substring(0,10);
//			logger.info("date1 = '" + date1 + "'");
//			
//			final String OLD_FORMAT = "yyyy-MM-dd";
//			final String NEW_FORMAT = "MMM dd, yyyy";
//			
//			SimpleDateFormat sdf = new SimpleDateFormat(OLD_FORMAT);
//			Date d = sdf.parse(date1);
//			sdf.applyPattern(NEW_FORMAT);
//			String newDateString = sdf.format(d);
//			logger.info("newDateString = '" + newDateString + "'");
//		 return newDateString;
//
//	}

	public static String getTodaysDate() {
	    Date date = new Date();  
		//logger.info("todayDate = " + date.toString());

//		SimpleDateFormat dateFormat =  new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		SimpleDateFormat dateFormat =  new SimpleDateFormat("MM/dd/yyyy");
	    String formatedDate = dateFormat.format(date);
		
		//logger.info("formatedDate = " + formatedDate);
		
		return formatedDate;
	}

	public static String changeDateFormat(String oldDate, String oldFormat, String newFormat) throws ParseException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(oldFormat);
		Date date = simpleDateFormat.parse(oldDate);
		simpleDateFormat.applyPattern(newFormat);
		String newDate = simpleDateFormat.format(date);
		//logger.info("newDate = '" + newDate + "'");
				
				;
		return newDate;
		
	}
	
	public static String changeDateFormat1ToDbFormat(String oldDate, String oldFormat, String newFormat) throws ParseException {
		
		if (!oldFormat.equals("mm/dd/yyyy")) {
			throw new ParseException("Error, invalid oldFormat", 1);
		}
		if (!newFormat.equals("dd-MMM-yy")) {
			throw new ParseException("Error, invalid newFormat", 1);
		}
		
		String[] temp = oldDate.split("/");
		
		
		int mmInt = Integer.parseInt(temp[0]);
		String newMonth = mons[mmInt-1].toUpperCase();
		String[] yDigit = temp[2].split("");
		
		String yy = "" + yDigit[2] + yDigit[3];
		String newDate = temp[1] + "-" + newMonth + "-" + yy;
		
//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(oldFormat);
//		Date date = simpleDateFormat.parse(oldDate);
//		simpleDateFormat.applyPattern(newFormat);
//		String newDate = simpleDateFormat.format(date);
		logger.info("newDate = '" + newDate + "'");
				
			
		return newDate;
		
	}
	
	
	public static String changeFormat1ToFormat2(String date1) throws Exception {
		String newDateString = changeDateFormat(date1, "MM/dd/yyyy", "MMM d, yyyy");
		logger.info("newDateString = '" + newDateString + "'");
	 return newDateString;

	}
	
	public static String changeFormat2ToFormat1(String date1) throws Exception {
		String newDateString = changeDateFormat(date1, "MMM d, yyyy", "MM/dd/yyyy");
		logger.info("newDateString = '" + newDateString + "'");
	 return newDateString;

	}
	
	
//	public static String convertFormat1ToFormat2(String date1) throws Exception {
//			final String OLD_FORMAT = "MM/dd/yyyy";
//			final String NEW_FORMAT = "MMM d, yyyy";
//			
//			SimpleDateFormat sdf = new SimpleDateFormat(OLD_FORMAT);
//			Date d = sdf.parse(date1);
//			sdf.applyPattern(NEW_FORMAT);
//			String newDateString = sdf.format(d);
//			logger.info("newDateString = '" + newDateString + "'");
//		 return newDateString;
//
//	}
	
	
	public static String getDatePlusNumberOfDays(String oldDate, int numDays) throws ParseException {
		String newDate =  getDatePlusNumberOfDays(oldDate, "MM/dd/yyyy", numDays);
		
		return newDate;
	}
	
	
	public static String convertToRequiredDateFormat(String dateformat1,String dateformat2,String date1 ) throws ParseException
	{
		SimpleDateFormat sdfSource1 = new SimpleDateFormat(dateformat1);
        Date date3 = sdfSource1.parse(date1);
        SimpleDateFormat sdfDestination1 = new SimpleDateFormat(dateformat2);
		return  sdfDestination1.format(date3);
   }
	
	
	
	public static String getDatePlusNumberOfDays(String oldDate, String format, int numDays) throws ParseException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
		Date date = simpleDateFormat.parse(oldDate);
		
		Calendar calendar = new GregorianCalendar();
		
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, numDays);
		
		Date newDate = calendar.getTime();
		
		String formatedNewDate = simpleDateFormat.format(newDate);
		return formatedNewDate;
	}

	public static String getDatePlusNumberOfmonths(String oldDate, int numDays) throws ParseException {
		String newDate =  getDatePlusNumberOfmonths(oldDate, "MM/dd/yyyy", numDays);
		
		return newDate;
	}
	
	public static String getDatePlusNumberOfmonths(String oldDate, String format, int numDays) throws ParseException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
		Date date = simpleDateFormat.parse(oldDate);
		
		Calendar calendar = new GregorianCalendar();
		
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, numDays);
		
		Date newDate = calendar.getTime();
		
		String formatedNewDate = simpleDateFormat.format(newDate);
		return formatedNewDate;
	}

	public static String getDatePlusNumberOfYears(String oldDate, int numDays) throws ParseException {
		String newDate =  getDatePlusNumberOfYears(oldDate, "MM/dd/yyyy", numDays);
		
		return newDate;
	}
	
	public static String getDatePlusNumberOfYears(String oldDate, String format, int numDays) throws ParseException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
		Date date = simpleDateFormat.parse(oldDate);
		
		Calendar calendar = new GregorianCalendar();
		
		calendar.setTime(date);
		calendar.add(Calendar.YEAR, numDays);
		
		Date newDate = calendar.getTime();
		
		String formatedNewDate = simpleDateFormat.format(newDate);
		return formatedNewDate;
	}

	public static String convertDateBad(String userDate) throws Exception  {
		String resultDate = userDate;

		// 05/22/2017: added the following to handle empty date.
		if (userDate.equals("")) {
			return userDate;
		}
		if (userDate.equals("today")) {
			resultDate = getTodaysDate();
		}

		int num_years = 0;
		int num_months = 0;
		int num_days = 0;
		String direction = null;
		Pattern pattern = null;
		String parsingString = userDate;
		String[] datePattern=null;
		Boolean flag = false;
			
		if(parsingString.contains("current"))
			flag =	true;
		
		
		if(flag) {
			datePattern=parsingString.toLowerCase().replaceAll("\\s+", "").split("/");
			parsingString=datePattern[2];
			pattern = Pattern.compile("currentyear|currentyear+\\d+");
		}
		else
			pattern = Pattern.compile("(1 year|\\d+ years) (.*)");
			
		Matcher matcher = pattern.matcher(parsingString);
		
		if(flag)
		{
			if(parsingString.equals("currentyear"))
				num_years=0;
			else
				num_years=Integer.parseInt(parsingString.split("currentyear")[1]);
		}
		else if(matcher.find()) {
			String group1 = matcher.group(1);
			String group2 = matcher.group(2);
			
			//logger.info("check Year: group1 = '" + group1 + "'");
			//logger.info("check Year: group2 ='" + group2 + "'");
			
			parsingString = group2;
			
			if(flag)
				pattern = Pattern.compile("(.*) (\\d+)");
			else		
				pattern = Pattern.compile("(\\d+) (.*)");
			matcher = pattern.matcher(group1);
			if (matcher.find()) {
				String NumberString = matcher.group(1);
				String rest = matcher.group(2);

				num_years = Integer.parseInt(NumberString);
				//logger.info("check Year: NumberString = '" + NumberString + "'");
				//logger.info("check Year: rest ='" + rest + "'");
			}
			
		}	
		if(flag) {
			parsingString=datePattern[0];
			pattern = Pattern.compile("(currentmonth|currentmonth\\d+) (.*)");
		}
		else
			pattern = Pattern.compile("(1 month |\\d+ months) (.*)");
		matcher = pattern.matcher(parsingString);
		
		if(flag)
		{
			if(parsingString.equals("currentmonth"))
				num_months=0;
			else
				num_months=Integer.parseInt(parsingString.split("currentmonth")[1]);
		}
		else if (matcher.find()) {
			String group1 = matcher.group(1);
			String group2 = matcher.group(2);
			//logger.info("check Month: group1 = '" + group1 + "'");
			//logger.info("check Month: group2 = '" + group2 + "'");
			parsingString = group2;
			
			if(flag)
				pattern = Pattern.compile("(.*) (\\d+)");
			else		
				pattern = Pattern.compile("(\\d+) (.*)");
			matcher = pattern.matcher(group1);
			if (matcher.find()) {
				String NumberString = matcher.group(1);
				String rest = matcher.group(2);
				num_months = Integer.parseInt(NumberString);
				
				//logger.info("check Year: NumberString = '" + NumberString + "'");
				//logger.info("check Year: rest ='" + rest + "'");
			}
		}	
		if(flag) {
			parsingString=datePattern[1];
			pattern = Pattern.compile("(currentdate|currentdate\\d+) (.*)");
		}
		else
			pattern = Pattern.compile("(1 day|\\d+ days) (.*)");
		matcher = pattern.matcher(parsingString);
		if(flag)
		{
			if(!parsingString.contains("currentdate"))
				num_days=Integer.parseInt(parsingString);
			else if(parsingString.equals("currentdate"))
				num_days=0;
			else
				num_days=Integer.parseInt(parsingString.split("currentdate")[1]);
		}
		else if (matcher.find()) {
			String group1 = matcher.group(1);
			String group2 = matcher.group(2);
			
			//logger.info("check Day: group1 = '" + group1 + "'");
			logger.info("check Day: group2 = '" + group2 + "'");
			parsingString = group2;
			
			if(flag)
				pattern = Pattern.compile("(.*) (\\d+)");
			else		
				pattern = Pattern.compile("(\\d+) (.*)");
			matcher = pattern.matcher(group1);
			if (matcher.find()) {
				String NumberString = matcher.group(1);
				String rest = matcher.group(2);
				num_days = Integer.parseInt(NumberString);
	
				//logger.info("check Year: NumberString = '" + NumberString + "'");
				logger.info("check Year: rest ='" + rest + "'");
			}
		}	
		if(flag){
			resultDate = getTodaysDate();
			if (num_days != 0 && datePattern[1].contains("currentdate"))
				resultDate = getDatePlusNumberOfDays(resultDate, num_days);
			if (num_days !=0 && !datePattern[1].contains("currentdate"))
				resultDate = getFirstDateOfMonth(num_days);		
			if (num_years != 0)
				resultDate = getDatePlusNumberOfYears(resultDate, num_years);
			if (num_months != 0)
				resultDate = getDatePlusNumberOfmonths(resultDate, num_months);
			}
		else {
		pattern = Pattern.compile("(before|after) (.*)");
		
		matcher = pattern.matcher(parsingString);
		if (matcher.find()) {
			String group1 = matcher.group(1);
			String group2 = matcher.group(2);
			//logger.info("check Direction: group1 = '" + group1 + "'");
			//logger.info("check Direction: group2 = '" + group2 + "'");
			direction = group1;
			parsingString = group2;
			
		}	
		
		if (direction != null) {
			int multiplier = 1;
			if (direction.equals("before")||direction.equals("-")) {
				multiplier = -1;
			}
			resultDate = getTodaysDate();
			if (num_years != 0) {
				num_years *= multiplier;
				resultDate = getDatePlusNumberOfYears(resultDate, num_years);
			}
			if (num_months != 0) {
				num_months *= multiplier;
				resultDate = getDatePlusNumberOfmonths(resultDate, num_months);
			}
			if (num_days != 0) {
				num_days *= multiplier;
				resultDate = getDatePlusNumberOfDays(resultDate, num_days);
			}
		}
		}
		// if direction == null and userDate not equals to today, we'll return whatever the userDate without checking the error
		// 	private static String changeDateFormat(String oldDate, String oldFormat, String newFormat) throws ParseException {
		
		if (resultDate.length() < 10) {
			resultDate = changeDateFormat(resultDate, "MM/dd/yyyy", "MM/dd/yyyy");
		}

		return resultDate;
	}

	public static String convertDate1(String userDate) throws Exception {
		return convertDate(userDate);
				
	}
	public static String convertDate(String userDate) throws Exception {
		String resultDate = userDate;

//		do {
//			userDate = userDate.replaceAll("  ", " ");
//		} while (userDate.contains("  "));
			
		while (userDate.contains("  ")) {
			userDate = userDate.replaceAll("  ", " ");
		}
		
		if (userDate.equals("today")) {
			resultDate = getTodaysDate();
			return resultDate;
		}
		
//		Pattern pattern = Pattern.compile("(\\d+) (days|day|month|months|year|years) (before|after) today");
		Pattern pattern = Pattern.compile("(\\d+) (days|day|month|months|year|years) (before|after|plus|minus) (today|current day|current month|current year)");
		Matcher matcher = pattern.matcher(userDate);
		if (matcher.find()) {
			String numString = matcher.group(1);
			String timeUnit = matcher.group(2);
			String direction = matcher.group(3);
			String addTo = matcher.group(4);
			
			if (Integer.parseInt(numString) == 1) {
				if (timeUnit.endsWith("s")) {
					throw new Exception("Error: do not use plural for number 1");
				}
			}
			else {
				if (!timeUnit.endsWith("s")) {
					throw new Exception("Error: should use plural for any number other than 1");
				}
			}
//			logger.info("direction " + direction);
			
			
//			logger.info("today plus " + userDate);
//			logger.info("numString =" + numString);
			
			int numInt = Integer.parseInt(numString);
			
			if (direction.equals("before")) {
				numInt *= -1;
			}
			
//			logger.info("numInt = " + numInt);
			
			String today = getTodaysDate();
			
			if (timeUnit.startsWith("day")) {
				resultDate = getDatePlusNumberOfDays(today, numInt);
			} else if (timeUnit.startsWith("month")) { 
				resultDate = getDatePlusNumberOfmonths(today, numInt);
			} else if (timeUnit.startsWith("year")) { 
				resultDate = getDatePlusNumberOfYears(today, numInt);
			}
		}	
		
		else if (userDate.equals("3 days before today")) {
			String today = getTodaysDate();
			resultDate = getDatePlusNumberOfDays(today, -3);
		} 
		else {
			Pattern pattern2 = Pattern.compile("(\\d+) ([\\w ]*)");
			Matcher matcher2 = pattern.matcher(userDate);
			if (matcher.find()) {
				String numString2 = matcher.group(1);
				String rest2 = matcher.group(2);
				
				logger.info("numString2 = " + numString2 + ", rest2 = " + rest2);
			}
		}
		
		return resultDate;
	}
	
	// replace the given column with today's date
	public static String replaceCSVLineDateColumnWithTodaysDate(String line, int colNum) throws Exception {
		String[] cols = line.split(",");
		int len1 = cols.length;
		String date = DateUtils.convertDate("today"); 
		cols[colNum] = date;
		String newLine = cols[0];

		for (int j = 1; j < cols.length; j++) {
			newLine += "," + cols[j];
		}
		return newLine;
	}
	// replace the given number of  columns with today's date
	public static String replaceCSVLineDateColumnWithTodaysDate(String line, int[] colNums) throws Exception {
		String[] cols = line.split(",");
		int len1 = cols.length;
		String date = DateUtils.convertDate("today"); 
		for (int colNum : colNums) {
			cols[colNum] = date;
		}
		String newLine = cols[0];

		for (int j = 1; j < cols.length; j++) {
			newLine += "," + cols[j];
		}
		return newLine;
	}
	
	// replace the given number of  columns with today's date
	public static String replaceCSVLineRelativeDateColumnWithAbsoluteDate(String line, int[] colNums) throws Exception {
		String[] cols = line.split(",");
//		int len1 = cols.length;
//		String date = DateUtils.convertDate("today"); 
		for (int colNum : colNums) {
			String relativeDate = cols[colNum];
			String absoluteDate = DateUtils.convertDate(relativeDate);
			cols[colNum] = absoluteDate;
		}
		String newLine = cols[0];

		for (int j = 1; j < cols.length; j++) {
			newLine += "," + cols[j];
		}
		return newLine;
	}
	// replace the given number of columns with csv cell data
	public static String replaceCSVLineDateColumnsWithCsvDataDate(String line, int[] colNums) throws Exception {
		String[] cols = line.split(",");
		int len1 = cols.length;
		for (int colNum : colNums) {
			String dateValue = cols[colNum];
			String date = DateUtils.convertDate(dateValue);
			cols[colNum] = date;
		}
		String newLine = cols[0];

		for (int j = 1; j < cols.length; j++) {
			newLine += "," + cols[j];
		}
		return newLine;
	}
	
	public static int numberOfDaysElapsed(String date1, String date2) throws ParseException {
		// return the number of days between date1 and date2. Assume date1 and date2 are
		// in mm/dd/yyyy format
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		@SuppressWarnings("deprecation")
		int numOfDays = sdf.parse(date1).getDate() - sdf.parse(date2).getDate();

		return numOfDays;

	}

	public static int numberOfOverwatchDaysElapsed1(String date1, String date2) throws ParseException {
		// return the number of days between date1 and date2. Assume date1 and date2 are
		// in mm/dd/yyyy format
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		//@SuppressWarnings("deprecation")
		Date d1 = sdf.parse(date1);
		Date d2 = sdf.parse(date2);
		
		long t1 = sdf.parse(date1).getTime();
		long t2 = sdf.parse(date2).getTime();
		
		logger.info("d1 = " + d1.toString() + ", t = " + t1);
		logger.info("d2 = " + d2.toString() + ", t = " + t2);

		long diffInMillies = Math.abs(t2 - t1);
		long diffSeconds = diffInMillies/1000;
		long diffMinutes = diffSeconds/60;
		long diffHours = diffMinutes/60;
		long diffDays1 = diffHours/24;
		
//		int diffDays = (int) TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
		long diffDays = diffInMillies/86400000;
		logger.info("diffInMillies = " + diffInMillies + ", diffDays = " + diffDays);
		if (t1 > t2) {
			diffDays *= -1;
		}
		return (int)diffDays;

	}

	public static long overwatchDateAbsoluteTime(String date1) throws ParseException {
		Calendar calendar1 = overwatchDateToCalendar(date1);
		
		
		// return the number of days between date1 and date2. Assume date1 and date2 are
		// in mm/dd/yyyy format
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		//@SuppressWarnings("deprecation")
		Date d1 = calendar1.getTime();
		
		long t1 = d1.getTime();
		
		return t1;
	}
	public static int numberOfOverwatchDaysElapsed(String date1, String date2) throws ParseException {
		Calendar calendar1 = overwatchDateToCalendar(date1);
		Calendar calendar2 = overwatchDateToCalendar(date2);
		
		
		// return the number of days between date1 and date2. Assume date1 and date2 are
		// in mm/dd/yyyy format
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		//@SuppressWarnings("deprecation")
		Date d1 = calendar1.getTime();
		Date d2 = calendar2.getTime();
		
		long t1 = d1.getTime();
		long t2 = d2.getTime();
		
		logger.info("d1 = " + d1.toString() + ", t = " + t1);
		logger.info("d2 = " + d2.toString() + ", t = " + t2);

		long diffInMillies = Math.abs(t2 - t1);
		long diffSeconds = diffInMillies/1000;
		long diffMinutes = diffSeconds/60;
		long diffHours = diffMinutes/60;
		long diffDays1 = diffHours/24;
		
//		int diffDays = (int) TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
		long diffDays = diffInMillies/86400000;
		
		// the difference between 03/11/2018 and 03/12/2018 is 82800000 instead of 856400000
		long remainTime = diffInMillies % 86400000;
		if (remainTime > 80000000) {
			diffDays += 1;
		}
		logger.info("diffInMillies = " + diffInMillies + ", diffDays = " + diffDays);
		if (t1 > t2) {
			diffDays *= -1;
		}
		return (int)diffDays;

	}

	public static Calendar overwatchDateToCalendar(String date) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date2 = date + " 00:00:00";
		Date old = sdf.parse(date2);
		Calendar calendar = new GregorianCalendar();

		calendar.setTime(old);
		
		return calendar;
	}
	
	public static String elapseNumberOfDays(String oldDate, int numberOfDays) throws ParseException {
		// return the new date, which is numberOfDays plus oldDate. Assume date format
		// is mm/dd/yyyy. numberOfDays can be positive or negative.
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		Date old = sdf.parse(oldDate);
		Calendar calendar = new GregorianCalendar();

		calendar.setTime(old);
		calendar.add(Calendar.DAY_OF_MONTH, numberOfDays);

		Date newDate = calendar.getTime();

		String formatedNewDate = sdf.format(newDate);
		return formatedNewDate;
	}

	public static Date convertToUTC(Date date) {
		if (date == null) {
			return null;
		}
		
//		   SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		   SimpleDateFormat sdf = new SimpleDateFormat();
		    sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
		    @SuppressWarnings("deprecation")
			Date gmt = new Date(sdf.format(date));
		    String gmtString = gmt.toString();
		String oldDate = date.toString();
		logger.info("oldDate = " + oldDate);
		logger.info("gmtString = " + gmtString);
		
		return gmt;
	}
	public static Date convertToUTC(String date, String format) {
		if (date == null) {
			return null;
		}
		
//		   SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		   SimpleDateFormat sdf = new SimpleDateFormat(format);
		    sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
		    @SuppressWarnings("deprecation")
			Date gmt = new Date(sdf.format(date));
		    String gmtString = gmt.toString();
		String oldDate = date.toString();
		logger.info("oldDate = " + oldDate);
		logger.info("gmtString = " + gmtString);
		
		return gmt;
	}
	public static String getOverwatchDate(Date date) {
		if (date == null) {
			return null;
		}
		
		logger.info("oldDate = " + date.toString());
		date = convertToUTC(date);
		logger.info("UTCDate = " + date.toString());
		
		

		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		int yr = calendar.get(Calendar.YEAR);
		int mon = calendar.get(Calendar.MONTH) + 1;
		int dat = calendar.get(Calendar.DATE);	
	
		int hr = calendar.get(Calendar.HOUR);	
		int min = calendar.get(Calendar.MINUTE);	
		int sec = calendar.get(Calendar.SECOND);	
		int msec = calendar.get(Calendar.MILLISECOND);	
		
		String mm = mon < 10 ? "0" + mon : "" + mon;
		String dd = dat < 10 ? "0" + dat : "" + dat;
		String newDate = "" + yr + "-" + mm + "-" + dd;
		logger.info("newDate = " + newDate);
		
		String newDate2 = "" + yr + "-" + mm + "-" + dd + " " + hr + ":" + min + ":" + sec + "." + msec;
		logger.info("newDate2 = " + newDate2);
		
		return newDate;
	}
	public static String convertDateFromRelativeToOverwatchFormat1(String relativeDate) throws Exception {
		  String d1 = DateUtils.convertDate(relativeDate);
		  //logger.info("d1 = " + d1);
		  
		  String d2 = DateUtils.changeDateFormat(d1, "mm/dd/yyyy", "yyyy-mm-dd");
		  //logger.info("d2 = " + d2);

		  return d2;
	}
	
	public static String convertDateFromRelativeToOverwatchFormat(String relativeDate) throws Exception {
		  String d1 = DateUtils.convertDate(relativeDate);
		  //logger.info("d1 = " + d1);
		  String d2 = DateUtils.changeDateFormat(d1, "MM/dd/yyyy", "yyyy-MM-dd");
		  
		  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		  Date date2  = sdf.parse(d2);
		  Date gmt = convertToUTC(date2);
		  String d3 = getOverwatchDate(gmt);
		  //logger.info("d2 = " + d2);

		  if (!d2.equals(d3)) {
			  throw new Exception("Error: UTC date and local date not the same, d2 = " + d2 + ", d3 = " + d3);
		  }
		  return d3;
	}
	
	public static String generateLoanNUmber() throws Exception {
		  String d1 = DateUtils.getCurrentTimestamp();
		  //logger.info("d1 = " + d1);
		  
		  String yr = d1.substring(2,4);
		  String mon = d1.substring(5, 7);
		  String day = d1.substring(8, 10);
		  String hr = d1.substring(11, 13);
		  String min = d1.substring(14, 16);
		  String sec = d1.substring(17, 19);
		  
//		  String d2 = yr + "-" + mon + "-" + day + "-" + hr + "-" + min + "-" + sec;
//		  logger.info("d2 = " + d2);
		  String result = yr + mon + day + hr + min + sec;
		  //logger.info("result = " + result);
		  return result;
	  }
	
	public static String convertDateFromDbFormatToFormat(String dbDate) throws Exception {
		String[] fields = dbDate.split("-");
		if (fields.length != 3) {
			throw new Exception("Error: invalid format for dbDate " + dbDate);
		}
		
		String dd = fields[0];
		
		String Mon = fields[1];
		int mmVal = findMonthNumber(Mon);
		if (mmVal == 0) {
			throw new Exception("Error: invalid month value " + Mon + ", dbDate = " + dbDate);
		}
		String mm = mmVal < 10 ? "0" + mmVal : "" + mmVal;
	
		String yy = fields[2];
	
		String newDate = mm + "/" + dd + "/20" + yy; 
		
		return newDate;
	}

	public static String convertDateFromFormatToDbFormat(String dbDate) throws Exception {
		String[] fields = dbDate.split("/");
		if (fields.length != 3) {
			throw new Exception("Error: date " + dbDate + ", invalid format for dbDate " + dbDate + ", fields length = " + fields.length);
		}
		
		String mon = fields[0].trim();
		int monthIndex = Integer.parseInt(mon) - 1;
		if (monthIndex < 0 || monthIndex >= mons.length) {
			throw new Exception("Error: date " + dbDate + ", invalid mon value " + mon) ;
		}
		mon = mons[monthIndex].toUpperCase();

		String dd = fields[1].trim();
		if (dd.length() < 2) {
			dd = "0" + dd;
		}

		String yy = fields[2].trim();
		if (yy.length() != 4 && yy.length() != 2) {
			throw new Exception("Error: date " + dbDate + ", invalid year value " + yy + ", length = " + yy.length());
		}
		if (yy.length() == 4) {
			yy = yy.substring(2);
		}
		
		String newDate = dd + "-" + mon + "-" + yy;
		return newDate;
	}

	public static String convertDateToVarChar10Format(String dbDate) throws Exception {
		String[] fields = dbDate.split("-");
		if (fields.length != 3) {
			throw new Exception("Error: date " + dbDate + ", invalid format for dbDate " + dbDate + ", fields length = " + fields.length);
		}
		
		String mon = fields[1].trim();
		int monthIndex = Integer.parseInt(mon) - 1;
		if (monthIndex < 0 || monthIndex >= mons.length) {
			throw new Exception("Error: date " + dbDate + ", invalid mon value " + mon) ;
		}
		mon = mons[monthIndex].toUpperCase();

		String dd = fields[2].trim();
		if (dd.length() < 2) {
			dd = "0" + dd;
		}

		String yy = fields[0].trim();
		if (yy.length() != 4 && yy.length() != 2) {
			throw new Exception("Error: date " + dbDate + ", invalid year value " + yy + ", length = " + yy.length());
		}
		if (yy.length() == 4) {
			yy = yy.substring(2);
		}
		
		String newDate = dd + "-" + mon + "-" + yy;
		return newDate;
	}

	public static String getDayOfMonth() {
		
		String currentDate = DateUtils.getCurrentTimestamp().split(" ")[0];
		
		String dayOfMonth = currentDate.split("-")[2];
		return dayOfMonth;
	}

	public static int getRandomNumberWithLimit(int limit) {
		String currentTimeStamp = DateUtils.getCurrentTimestamp();
		
		//logger.info("currentTimeStamp = " + currentTimeStamp);
		
		String miliSecond = currentTimeStamp.split("\\.")[1];
		
		int randomNumber = Integer.parseInt(miliSecond) % limit;
		
		return randomNumber;
	}

	public static String getUniqueNumber() {
		
		String currentTimeStamp = DateUtils.getCurrentTimestamp();
		
		//logger.info("currentTimeStamp = " + currentTimeStamp);
		
		String result = currentTimeStamp.substring(2, 19).replaceAll(":", "").replaceAll("-", "").replaceAll(" ", "");
		return result;
	}
	
	
	public static String getDayOfWeek(String Date) {
		// Date format: mm/dd/yyyy
		String mon = Date.substring(0,2);
		String day = Date.substring(3,5);
		String year = Date.substring(6);
		
		String dayOfWeekText = getDayOfWeek(year, mon, day);
		
		return dayOfWeekText;
		
	}
	public static String getDayOfWeek(String year, String month, String day) {
		int yr = Integer.parseInt(year);
		int mm = Integer.parseInt(month);
		int dd = Integer.parseInt(day);
		
		String dayOfWeekText = getDayOfWeek(yr, mm, dd);
		
		return dayOfWeekText;
		
	}
	public static String getDayOfWeek(int yr, int mm, int dd) {
	    LocalDate localDate = LocalDate.of(yr,  mm, dd);
	     
	    //Getting the day of week for a given date
	    java.time.DayOfWeek dayOfWeek = localDate.getDayOfWeek();
	    
	    String dayOfWeekText = dayOfWeek.toString();

		 logger.info("day of week text = " + dayOfWeekText);

		 return dayOfWeekText;
	}
	
	private static Map<String, String> dayOfWeekMap = new HashMap<String, String>() {{
		put("SUNDAY", "Sun");
		put("MONDAY", "Mon");
		put("TUESDAY", "Tue");
		put("WEDNESDAY", "Wed");
		put("THURSDAY", "Thu");
		put("FRIDAY", "Fri");
		put("SATURDAY", "Sat");
	}};
	
	public static String dayOfWeekThreeLetter(String dayOfWeek) {
		String result = dayOfWeekMap.get(dayOfWeek);
		return result;
	}
	
	public static String convertDateToChangeHistoryChangePaymentPlanDate(String userDate) throws Exception {
		String result = null;
		
		String Date = convertDate(userDate);
		String mon = Date.substring(0,2);
		String day = Date.substring(3,5);
		String year = Date.substring(6);

		String dayOfWeek = getDayOfWeek(year, mon, day);
		
		String dayOfWeek3Letter = dayOfWeekThreeLetter(dayOfWeek);
		
		int monthIndex = Integer.parseInt(mon) - 1;
		String month3Letter = mons[monthIndex];
		
		result = dayOfWeek3Letter + " " + month3Letter + " " + day + " 00:00:00 CST " + year;
		
		return result;
	}
	
	public static String convertMonthNumberToThreeLetterName(String monthNumber) {
		int monthIndex = Integer.parseInt(monthNumber) - 1;
		String threeLetterName = mons[monthIndex];
		return threeLetterName;
	}

	public static int daysInMonth(String mon, String yr)
	{
		int year = Integer.parseInt(yr);
		Calendar calendar = Calendar.getInstance();
		int month = Integer.parseInt(mon) -1; // use the index
		int date = 1;
		calendar.set(year, month, date);
		int days = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		//System.out.println("mont = " + month + ", Number of Days: " + days);
		
		return days;
	}
	public static String getMonthFromTimeStamp(String timeStamp) {
		// a timeStamp is in the format of yyyy-mm-dd
		String yearMonthDate = timeStamp.split(" ")[0];
		String result = yearMonthDate.split("-")[1];
		
		return result;
	}
	public static String getYearFromTimeStamp(String timeStamp) {
		// a timeStamp is in the format of yyyy-mm-dd
		String yearMonthDate = timeStamp.split(" ")[0];
		String result = yearMonthDate.split("-")[0];
		result = result.substring(result.length()-2);
	 
		
		return result;
	}
	public static String getDateOnlyFromTimeStamp(String timeStamp) {
		// a timeStamp is in the format of yyyy-mm-dd
		String yearMonthDate = timeStamp.split(" ")[0];
		String result = yearMonthDate.split("-")[2];
		
		return result;
		
	}	public static String getMonthYearFromTimeStamp(String timeStamp) {
		String month = getMonthFromTimeStamp(timeStamp);
		String year = getYearFromTimeStamp(timeStamp);
		year = year.substring(year.length()-2);
		
		String result = createMonthYearFromMonthAndYear(month, year);
		
		return result;
	}
	public static String createMonthYearFromMonthAndYear(String month, String year) {
		String result = month + "/" + year;
		return result;
	}
	public static String getMonthOnlyFromMonthYear(String monthYear) {
		String result = monthYear.split("/")[0];
		
		return result;
	}
	
	public static String getYearOnlyFromMonthYear(String monthYear) throws Exception {
		String[] array = monthYear.split("/");
		if (array.length < 2) {
			throw new Exception("Error: invalid monthYear " + monthYear);
		}
		String result = monthYear.split("/")[1];
		
		return result;
	}

	public static int getDaysInMonthFromMonthyear(String monthYear) {
		String month = DateUtils.getMonthOnlyFromMonthYear(monthYear);
		String year = DateUtils.getMonthOnlyFromMonthYear(monthYear);
		int numberDays = DateUtils.daysInMonth(month, year);
		
		return numberDays;
	}
	
	public static int getDaysInMonthFromTimeStamp(String timeStamp) {
		String monthYear = getMonthYearFromTimeStamp(timeStamp);
		int numberDays = getDaysInMonthFromMonthyear(monthYear);
		return numberDays;
	}

	public static boolean isSameMonth(String timeStamp1, String timeStamp2) {
		boolean isSame = false;
		
		String month1 = getMonthFromTimeStamp(timeStamp1);
		String month2 = getMonthFromTimeStamp(timeStamp2);
		String year1 = getYearFromTimeStamp(timeStamp1);
		String year2 = getYearFromTimeStamp(timeStamp2);
		
		if (month1.equals(month2) && year1.equals(year2)) {
			isSame = true;
		}
		return isSame;
	}
	

	public static String getFirstDateOfNextMonthOfFormat_yyyy_mm_dd(String timeStamp) throws ParseException {
		
		String [] ary = timeStamp.split(" ")[0].split("-");
		
		int yy = Integer.parseInt(ary[0]);
		int mm = Integer.parseInt(ary[1]);
		
		mm++;
		if (mm > 12) {
			mm = 1;
			yy++;
		}
		
		String mmStr = mm < 10 ? "0" + mm : "" + mm;
		
		String newDate = "" + yy + "-" + mmStr + "-01";
		
		
		
		return newDate;
	}
	public static String getFirstDateOfNextMonthOfFormat(String firstDayMonth, String format) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date date = sdf.parse(firstDayMonth);
		String d1 = date.toString();
		Calendar calendar = new GregorianCalendar();

		calendar.setTime(date);
		String c1 = sdf.format(calendar.getTime());
		calendar.add(Calendar.MONTH, 1);
		String c2 = sdf.format(calendar.getTime());

		String firstDate = sdf.format(calendar.getTime());
		logger.info("firstDate "+firstDate);
		return firstDate;
	}
	
	public static String getFirstDateOfNextMonthMMDDYYYY(String firstDayOfTranMonth) {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		Calendar c = Calendar.getInstance(); // this takes current date
		c.set(Calendar.DAY_OF_MONTH,1); 
		c.add(Calendar.MONTH, 1); 
		String firstDate = sdf.format(c.getTime());
		logger.info("firstDate "+firstDate);
		return firstDate;
	}
	
	public static String getFirstDateOfMonthBefore(String currentDate, String numberOfMonthBefore) {
		int numberOfMonth = Integer.parseInt(numberOfMonthBefore);
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		Calendar c = Calendar.getInstance(); // this takes current date
		c.set(Calendar.DAY_OF_MONTH,1); 
		c.add(Calendar.MONTH, -numberOfMonth);  //subtracting a month directly - gives the start of given month.
		String firstDate = sdf.format(c.getTime());
		logger.info("firstDate "+firstDate);
		return firstDate;

	}
	
	public static String getCurrentYear() {
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		String yearInString = String.valueOf(year);
		logger.info("current year: "+yearInString);
		return yearInString;
		
	}


}
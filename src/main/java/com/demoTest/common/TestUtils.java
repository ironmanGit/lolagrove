package com.demoTest.common;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Timestamp;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.Vector;

import org.apache.log4j.Logger;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

import utils.ConfigUtils;

public class TestUtils {
	static Logger logger = Logger.getLogger(TestUtils.class.getName());

	public static final int REFRESH = 5000;
	public static final int NORMAL = 5000;
	public static final int DEMO = 3000;
	public static final int SHORT = 1000;
	public static final int LONG = 1000;

	public static void pause(int milliSeconds, String msg) {
		try {
			Thread.sleep(milliSeconds);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void pauseRefresh() {
		pause(REFRESH, "");
	}

	public static void pauseNormal() {
		pause(NORMAL, "");
	}

	public static void pauseNormal(String msg) {
		logger.info("Wait " + NORMAL + "ms, next step: " + msg);
		pause(NORMAL, msg);
	}

	public static void pauseDemo() {
		pause(DEMO, "");
	}

	// this method has been obsoleted, please use logger.info() instead
	// public static void pauseDemo(String msg) {
	// logger.info("Wait " + DEMO + " ms, next step: " + msg);
	// pause(DEMO, msg);
	// }
	//
	public static void pauseShort() {
		pauseShort(1);
	}

	public static void pauseShort(int num) {
		for (int i = 0; i < num; i++) {
			pause(SHORT, "");
		}
	}

	public static void pauseShort(String msg) {
		logger.info("Wait " + SHORT + " ms, next step: " + msg);
		pause(SHORT, msg);
	}

	public static void pauseZero(String msg) {
		logger.info("Wait 0 ms, next step: " + msg);
	}

	public static String readFile(String fileName) throws Exception {
		return readFile(fileName, false);
	}

	public static String readFile(String fileName, boolean debugFlag) throws Exception {
		String text = null;
		try {
			if (debugFlag) {
				logger.info("fileName = '" + fileName + "'");
			}
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();

			logger.info("line = " + line);
			while (line != null) {
				sb.append(line);
				sb.append(System.lineSeparator());
				line = br.readLine();

				logger.info("line = " + line);
			}
			text = sb.toString().replaceAll("\r", "");
			if (debugFlag) {
				logger.info("text = " + text);
			}

			br.close();

		} catch (Exception e) {
			throw e;
		}

		return text;
	}

	public static List<String> readFileToLinesWithoutCommentLine(String fileName) throws Exception {
		return readFileToLines(fileName, true, 0, 0, false);
	}
	
	public static List<String> readFileToLinesWithoutCommentLine(String fileName, String loString, String hiString) throws Exception {
		int lo = 0;
		int hi = 0;
		if (loString != null && loString.trim().length() > 0) {
			lo = Integer.parseInt(loString);
		}
		if (hiString != null && hiString.trim().length() > 0) {
			hi = Integer.parseInt(hiString);
		}
		return readFileToLinesWithoutCommentLine(fileName, lo, hi);
	}
	
	public static List<String> readFileToLinesWithoutCommentLine(String fileName, int lo, int hi) throws Exception {
		boolean skipCommentLine = true;
		boolean debug = false;
		return readFileToLines(fileName, skipCommentLine, lo, hi, debug);
	}
	
	public static List<String> readFileToLines(String fileName) throws Exception {
		boolean skipCommentLine = false;
		boolean debug = false;
		return readFileToLines(fileName, skipCommentLine, 0, 0, debug);

	}

	public static List<String> readFileToLines(String fileName, int lo) throws Exception {
		boolean skipCommentLine = false;
		boolean debug = false;
		return readFileToLines(fileName, skipCommentLine, lo, 0, debug);

	}
	public static List<String> readFileToLines(String fileName, int lo, int hi) throws Exception {
		boolean skipCommentLine = false;
		boolean debug = false;
		return readFileToLines(fileName, skipCommentLine, lo, hi, debug);

	}
	public static List<String> readFileToLines(String fileName, boolean debugFlag) throws Exception {
		boolean skipCommentLine = false;
		return readFileToLines(fileName, skipCommentLine, 0, 0, debugFlag);
		
	}
	private static List<String> readFileToLines(String fileName, boolean skipCommentLine, Integer lo, Integer hi, boolean debugFlag) throws Exception {
		List<String> lines = new ArrayList<String>();

		try {
			if (debugFlag) {
				logger.info("fileName = '" + fileName + "'");
			}
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			// StringBuilder sb = new StringBuilder();
			int i = 0;
			String line;
			do {
				i++;
				if (hi != null && hi != 0 &&  i > hi) {
					break;
				}
				line = br.readLine();
				if (debugFlag) {
					logger.info("line[" + i + "] = " + line);
				}
				if (line == null || line.trim().isEmpty()) {
					break;
				}
				if (line.trim().isEmpty()) {
					continue;
				}
				if (skipCommentLine && line.trim().startsWith("#")) {
					continue;
				}
				if (lo != null && i >= lo ) {
					lines.add(line);
				}
			} while (line != null);

			br.close();

		} catch (Exception e) {
			throw e;
		}

		return lines;
	}

	// public static String readFile2(String fileName) throws Exception {
	// String text = null;
	// try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
	// StringBuilder sb = new StringBuilder();
	// String line = br.readLine();
	//
	// logger.info("line = " + line);
	// while (line != null) {
	// sb.append(line);
	// sb.append(System.lineSeparator());
	// line = br.readLine();
	//
	// logger.info("line = " + line);
	// }
	// text = sb.toString().replaceAll("\r", "");
	// logger.info("text = " + text);
	// }
	//
	// return text;
	// }

	public static List<Integer> getRandomNumbers(int n, int size) {
		Set<Integer> randomNumbers = new HashSet<Integer>();

		String ts = DateUtils.getCurrentTimestamp();
		logger.info("ts = '" + ts + "'");
		ts = ts.replaceAll(" ", "").replaceAll("\\.", "").replaceAll(":", "").replaceAll("-", "").replaceAll("/", "");

		logger.info("ts = '" + ts + "'");
		long seed = Long.parseLong(ts);

		Random randomGenerator = new Random(seed);
		// for (int i = 0; i < 20; i++ ) {
		// int randomInt = randomGenerator.nextInt(size);
		// logger.info("randomInt = '" + randomInt + "'");
		// }
		while (randomNumbers.size() < n) {

			int randomInt = randomGenerator.nextInt(size);
			randomNumbers.add(randomInt);
			logger.info("randomInt = '" + randomInt + "'");
		}

		List<Integer> list = new ArrayList<Integer>();
		for (Integer num : randomNumbers) {
			list.add(num);
		}
		return list;
	}

	public static void appendToFile(String filePath, String content) throws IOException {
		writeToFile(filePath, content, true);

	}

	// if lineNum is 0, create new file. Otherwise append to existing file.
	public static void writeToFile(String filePath, String content, int lineNum) throws IOException {
		boolean appendFlag = lineNum == 0 ? false : true;
		writeToFile(filePath, content, appendFlag);
	}
	
	public static void writeToFile(String filePath, String content) throws IOException {
		writeToFile(filePath, content, false);

	}
	

	public static void writeToFile(String filePath, String content, boolean appendFlag) throws IOException {
		createFolderForPathName(filePath);
		FileWriter fileWriter = new FileWriter(filePath, appendFlag);
		PrintWriter printWriter = new PrintWriter(fileWriter);
		printWriter.print(content + "\n");
		printWriter.close();

	}

	public static void refreshFile(String filePath) throws IOException {
		createFolderForPathName(filePath);
		FileWriter fileWriter = new FileWriter(filePath, false);
		PrintWriter printWriter = new PrintWriter(fileWriter);
		printWriter.print("");
		printWriter.close();

	}

	public static List<String> getFilesUnderfolder(String pathName) {
		return getFilesUnderfolder(pathName, true);
	}

	public static List<String> getFilesUnderfolder(String pathName, boolean recursive) {
		List<String> fileList = new ArrayList<String>();

		File folder = new File(pathName);
		System.out.println("Outside list of File loop");
		
		File[] listOfFiles = folder.listFiles();
		if(listOfFiles == null) {
			System.out.println("Files is null");
		}
		
		for (int i = 0; i < listOfFiles.length; i++) {
			
			String subName = pathName + File.separator + listOfFiles[i].getName();
			if (listOfFiles[i].isFile()) {
				System.out.println("File " + subName);

				fileList.add(subName);
			} else if (listOfFiles[i].isDirectory()) {
				System.out.println("Directory " + subName);

				if (recursive) {
					for (String file : getFilesUnderfolder(subName, recursive)) {
						fileList.add(file);
					}
				}
			}
		}

		return fileList;
	}

	public static boolean isNegativeAmount(String amountString) {
		boolean isNegative = false;

		// logger.info("amountString 1 = " + amountString);
		if (amountString != null && amountString.contains("(")) {
			isNegative = true;
			logger.info("amount is negative");
		}

		return isNegative;
	}

	public static String filterAmount(String amountString) {
		int multiplier = 1;
		if (amountString == null) {
			return null;
		}

		// logger.info("amountString 1 = " + amountString);
		if (amountString != null && amountString.contains("(")) {
			logger.info("amount is negative");
			multiplier = -1;
			amountString = amountString.replaceAll("\\(", "");
			amountString = amountString.replaceAll("\\)", "");

		}
		amountString = amountString.replaceAll("\\$", "");
		// logger.info("amountString 2 = " + amountString);
		amountString = amountString.replaceAll(",", "");
		// logger.info("amountString 3 = " + amountString);
		amountString = amountString.replaceAll("%", "");
		//logger.info("amountString 4 = " + amountString);
		return amountString;
	}
	
	public static float moneyAmountToFloat(String amountString) {
		boolean isNegative = isNegativeAmount(amountString);
		amountString = filterAmount(amountString);

		float amount = Float.parseFloat(amountString);
		if (isNegative) {
			amount *= -1;
		}
		logger.info("amountString 5 = " + amountString);
		return amount;
	}

	public static String appendFileName(String fileName, String suffix) {
		String newName = null;

		String[] temp = fileName.split("\\.");

		// int len = temp.length;
		// for (String t : temp) {
		// logger.info("t = " + t);
		// }
		newName = temp[0] + "_" + suffix;
		for (int i = 1; i < temp.length; i++) {
			newName += "." + temp[i];
		}

		return newName;
	}

	public static boolean fileExist(String fileName) {
		File file = new File(fileName);
		boolean exists = file != null && file.exists();

		return exists;
	}

	public static boolean folderExist(String fileName) {
		File file = new File(fileName);
		boolean exists = file != null && file.exists() && file.isDirectory();

		return exists;
	}

	public static void createFolder(String folderName) {
		File file = new File(folderName);
		boolean result = false;
		try {
			if (!file.exists()) {
				file.mkdir();
			}
			result = true;
		} catch (SecurityException e) {
			e.printStackTrace();
			throw e;
		}
	}

	public static void createFolderForPathName(String pathName) {
		
		String[] dirs = pathName.replaceAll("\\\\", "/").split("/");

		String path = "";
		int last = dirs.length - 1;
		for (int i = 0; i < last; i++) {
			String dir = dirs[i];
			path = path.isEmpty() ? dir : path + "/" + dir;
			createFolder(path);
		}
	}

	public static String patchLoanNumber(String loanNumber) {
		String result = loanNumber;
		while (result.length() < 12) {
			result = "0" + result;
		}

		return result;
	}

	public static String takeDigitalValue(String value) {
		String result = "";
		
		for (int i = 0; i < value.length(); i++) {
			char c = value.charAt(i);
			if (c >= '0' && c<= '9') {
				result += c;
			}
		}
		return result;
	}

	public static boolean fileExistInPath (String dirPath, String fileName) {
		boolean flag=false;
	    File dir = new File(dirPath);
	    if (dir == null || !dir.exists() || !dir.isDirectory()) {
	    	return false;
	    }
	    File[] files = dir.listFiles();
	    if (files == null || files.length == 0) {
	        return false;
	    }
	    
	    for (int i = 1; i < files.length; i++) {
	    	if(files[i].getName().contains(fileName)) {
	    		flag=true;
	    	}
	    }
	    return flag;
	}
	
	public static boolean fileExistWithPrefix (String dirPath, String prefix) {
		boolean flag=false;
	    File dir = new File(dirPath);
	    if (dir == null || !dir.exists() || !dir.isDirectory()) {
	    	return false;
	    }
	    File[] files = dir.listFiles();
	    if (files == null || files.length == 0) {
	        return false;
	    }
	    
	    for (int i = 1; i < files.length; i++) {
	    	if(files[i].getName().startsWith(prefix)) {
	    		flag=true;
	    	}
	    }
	    return flag;
	}
	
	public static void deleteFileWithPrefix(String filePathNamePrefix) {
		String[] temp = filePathNamePrefix.split("/");
		int len = temp.length;
		
		
		String dirPath = temp[0];
		
		for (int i = 1; i< len - 1; i++) {
			dirPath += "/" + temp[i];
		}
		
		String fileNamePrefix = temp[len-1];
		
		deleteFileWithPrefix(dirPath, fileNamePrefix);
	}
	public static void deleteFileWithPrefix(String dirPath, String fileNamePrefix) {
		File dir = new File(dirPath);
	    if (dir == null || !dir.exists() || !dir.isDirectory()) {
	    	return;
	    }
		if (dir != null && dir.listFiles() != null) {
	        for (File f : dir.listFiles()) {
	            if (f.getName().startsWith(fileNamePrefix)) {
	                f.delete();
	            }
	        }
		}
	}
	
	public static void deleteAllFiles(String FolderName) throws IOException {
		File file = new File(FolderName);
		String[] myFiles;
		if (file.isDirectory()) {
			myFiles = file.list();
			for (int i = 0; i < myFiles.length; i++) {
				File myFile = new File(file, myFiles[i]);
				myFile.delete();
				logger.info(myFiles[i] + " is deleted successfully");
			}
		}
	}
	
	//This method copy content from file without new line
    public static void writeToFile2(String filePath, String content, boolean appendFlag) throws IOException {
           createFolderForPathName(filePath);
           FileWriter fileWriter = new FileWriter(filePath, appendFlag);
           PrintWriter printWriter = new PrintWriter(fileWriter);
           printWriter.print(content);
           printWriter.close();

    }
	
	public static void writeLinestToFile(String fileName, List<String> lines) throws IOException {
		writeLinestToFile(fileName, lines, null);
	}
	
	public static void writeLinestToFile(String fileName, List<String> lines, String header) throws IOException {
		boolean noHeader = true;
		if (header != null && !header.isEmpty()) {
			writeToFile(fileName, header);
			noHeader = false;
		}
		int i = 0;
		for (String line: lines) {
			i++;
			if (noHeader && i == 1) {
				writeToFile(fileName, lines.get(0));
			}
			else {
				appendToFile(fileName, line);
			}
		}
		return;
	}

	public static String patchLeadingZeros(String oldValue, int digit) {
		String result = oldValue;
		while (result.length() < digit) {
			result = "0" + result;
		}

		return result;
	}
	
	public static Set<Integer> parseDataRange(String dataRange) throws Exception {
		Set<Integer> dataSet = new HashSet<Integer>();
		if (!dataRange.trim().isEmpty()) {
			String [] subRanges = dataRange.split(",");
			for (String subRange: subRanges) {
				if (subRange.trim().isEmpty()) {
					continue;
				}
				String[] pair = subRange.split("-");
				int len = pair.length;
				if (len < 1 || len > 2) {
					throw new Exception("Error: invalid sub range " + subRange);
				}
				String loBound = pair[0];
				String hiBound = pair[0];
				if (len > 1) {
					hiBound = pair[1];
				}
				Integer lo = Integer.parseInt(loBound.trim());
				Integer hi = Integer.parseInt(hiBound.trim());
				
				for (Integer i = lo; i <= hi; i++) {
					dataSet.add(i);
				}
			}
		}
		return dataSet;
	}

	public static void copyFile(String sourceFile, String targetFile) throws Exception {
		List<String> lines = readFileToLines(sourceFile);	
		writeLinestToFile(targetFile, lines);
	}
	
	public static void moveFileFromSrcToDest(String sourcePath, String destinationPath, String filename)
			throws Exception {
		createFolder(destinationPath);
		String configFile = ConfigUtils.getCongFile();
		String serverAddress = ConfigUtils.getConfigProperty(configFile, "SFTPHost");
		String username = ConfigUtils.getConfigProperty(configFile, "SFTPUserName");
		String password = ConfigUtils.getConfigProperty(configFile, "SFTPPassword");
		int serverPort = 22;
		Session session = null;
		ChannelSftp channelSftp = null;
		try {
			JSch jsch = new JSch();
			session = jsch.getSession(username, serverAddress, serverPort);
			session.setPassword(password);

			java.util.Properties config = new java.util.Properties();
			config.put("StrictHostKeyChecking", "no");

			session.setConfig(config);
			session.connect();
			boolean isSessionConnected = session.isConnected();
			if(isSessionConnected){
				logger.info("Session is connected sucessfully");
			}else{
				logger.info("Session connection failed");
			}
			channelSftp = (ChannelSftp) session.openChannel("sftp");
			channelSftp.connect();
			channelSftp.isConnected();
			channelSftp.cd(sourcePath);
			boolean isChannelConnected = session.isConnected();
			if(isChannelConnected){
				logger.info("Channel is connected sucessfully");
			}else{
				logger.info("Channel connection failed");
			}
			String folderFileName = null;
			Vector<ChannelSftp.LsEntry> filelist = channelSftp.ls(sourcePath);
			for (ChannelSftp.LsEntry file : filelist) {
				if (file.getFilename().startsWith(filename)) {
					folderFileName = file.getFilename();
					break;
				}
			}

			if (folderFileName != null) {
				channelSftp.get(sourcePath + "/" + folderFileName, destinationPath + "/" + folderFileName);
			}

			channelSftp.disconnect();
			session.disconnect();
		} finally {
			if (channelSftp != null && channelSftp.isConnected()) {
				channelSftp.disconnect();
			}

			if (session != null && session.isConnected()) {
				session.disconnect();
			}
		}
//		return test;
	}
		
		public static boolean isValueTrue(String parameterValue, String parameterName) throws Exception {
		boolean isTrue;
		if (parameterValue.toLowerCase().equals("true")) {
			isTrue = true;
		}
		else if (parameterValue.toLowerCase().equals("false")) {
			isTrue = false;
		}
		else {
			throw new Exception("Error: iinvalid value " + parameterValue + " for parameter " + parameterName);
		}
		return isTrue;
	}
	
	public static long getUniqueNumber() {
		String digitString = "";
		String timeStamp = DateUtils.getCurrentTimestamp();
		for (char c: timeStamp.toCharArray()) {
			if (Character.isDigit(c)) {
				digitString += Character.toString(c);
			}
		}
		
		long result = Long.parseLong(digitString);
		return result;
		
	}
	
	public static Map<Integer, String> selectDataRowsFromSet(Map<Integer, String> dataLinesByRowMap, Set<Integer> rowSet) {
		
		Map<Integer, String> dataLinesByRowMap2 = new HashMap<Integer, String>();
		
		for (Integer rowNumber: rowSet) {
			String dataLine = dataLinesByRowMap.get(rowNumber);
			dataLinesByRowMap2.put(rowNumber, dataLine);
		}
		return dataLinesByRowMap2;
	}

	public static  Map<Integer, String> selectRandomDataRows(Map<Integer, String> dataLinesByRowMap, int numberSelect) {
		Map<Integer, String> dataLinesByRowMap2 = new HashMap<Integer, String>();
		Set<Integer> selected = new HashSet<Integer>();
		int total = dataLinesByRowMap.size();
		
		long seed = getUniqueNumber();
		Random random = new Random(seed);
		int numberSelected = 0;
		while (numberSelected < numberSelect && numberSelected < total) {
			int nextValue = random.nextInt(total) + 1;
			if (!selected.contains(nextValue)) {
				selected.add(nextValue);
				numberSelected++;
			}
		}
		//logger.info(threadInfo + "selected size = " + selected.size() + ", selected = " + selected.toString());
		
		Set<Integer> rows = dataLinesByRowMap.keySet();
		//logger.info(threadInfo + "rows size = " + rows.size() + ", rows = " + rows.toString());
		int keyNumber = 0;
		for (Integer rowNumber: rows) {
			keyNumber++;
			if(selected.contains(keyNumber)) {
				String dataLine = dataLinesByRowMap.get(rowNumber);
				dataLinesByRowMap2.put(rowNumber, dataLine);
			}
			
		}
		//logger.info(threadInfo + "data size = " + dataLinesByRowMap2.size());
		return dataLinesByRowMap2;
	}

	public static Map<Integer, String>  getDataLinesbyRowMapFromDataFile(String  paramDataFile, String  paramSelectedRows, String  paramRandomSelect) throws Exception {
		Map<Integer, String>  result = getDataLinesbyRowMapFromDataFile(paramDataFile, paramSelectedRows, paramRandomSelect, null);
		return result;
	}
	public static Map<Integer, String>  getDataLinesbyRowMapFromDataFile(String  paramDataFile, String  paramSelectedRows, String  paramRandomSelect, String rowSuffix) throws Exception {
		Map<Integer, String> dataLinesByRowMap = new HashMap<Integer, String>();

		boolean isSelectAllRows = paramSelectedRows.equalsIgnoreCase("all") || paramSelectedRows.trim().isEmpty() ? true: false;
		Set<Integer> dataRowsSet = new HashSet<Integer>();
		if (!paramSelectedRows.trim().isEmpty() && !paramSelectedRows.equalsIgnoreCase("all")) {
			dataRowsSet = TestUtils.parseDataRange(paramSelectedRows);
		}
		
		List<String> dataLines = TestUtils.readFileToLines(paramDataFile);
		Integer rowNumber = 0;
		for (String dataLine: dataLines) {
			rowNumber++;
			String column1 = dataLine.split(",")[0].toLowerCase();
			if (column1.startsWith("#") || column1.startsWith("seq") || column1.startsWith("loan")) {
				continue;
			}
			if (rowSuffix != null && !rowSuffix.trim().isEmpty()) {
				if (!rowNumber.toString().endsWith(rowSuffix)) {
					continue;
				}
			}
			if (isSelectAllRows || dataRowsSet.contains(rowNumber)) {
				dataLinesByRowMap.put(rowNumber, dataLine);
			}
		}
//		if (!paramSelectedRows.trim().isEmpty() && !paramSelectedRows.equalsIgnoreCase("all")) {
//			dataLinesByRowMap = selectDataRowsFromSet(dataLinesByRowMap, dataRowsSet);
//			logger.info("data size = " + dataLinesByRowMap.size());
//		}
		if (!paramRandomSelect.isEmpty()) {
			int numberSelect = Integer.parseInt(paramRandomSelect);
			dataLinesByRowMap = selectRandomDataRows(dataLinesByRowMap, numberSelect);
//			logger.info(threadInfo + "data size = " + dataLinesByRowMap.size());
		}
		return dataLinesByRowMap;
	}

	public static int getRandomNumber(int length) {
		long seed = getUniqueNumber();
		Random random = new Random(seed);
		
		int randomNumber = random.nextInt(length);
		return randomNumber;
	}

	public static String getNextYearSuffix(String yearSuffix) {
		int yr = Integer.parseInt(yearSuffix);
		Integer nextYr = yr + 1;
		
		return nextYr.toString();
	}

	public static String appendUniqueNumberToFileName(String fileName) {
		String uniqueNumber = DateUtils.getUniqueNumber();
		
		String[] nameArray = fileName.split("\\."); 
		
		String uniqueFileName = nameArray[0] + "_" + uniqueNumber;
		for (int i = 1; i < nameArray.length; i++) {
			uniqueFileName +=  "." + nameArray[i];
		}
		
		return uniqueFileName;
	}

	
}


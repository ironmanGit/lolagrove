package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class ConfigUtils {
	static Logger logger = Logger.getLogger(ConfigUtils.class.getName());
	
	public static String getCongFile() {
		
		String site = System.getProperty("site");
		if (site == null || site.trim().isEmpty()) {
			site = "QA";
		}
		return getCongFile(site);
	}
	
	private static String getCongFile(String site) {
		String configFile = null;

		if (site != null ) {
			site = site.trim();
		}
		if (site == null || site.trim().isEmpty() || site.equals("QA")) {
			configFile = "target/test-classes/config.properties";
		}
				
		return configFile;
	}
	
	
	public static String getConfigProperty(String propertyName) throws Exception {
		String configFile = getCongFile();
		
		String result = getConfigProperty(configFile, propertyName);
		
		return result;
		
	}
	public static String getConfigProperty(String configFile, String propertyName) throws Exception {
		String propertyValue = System.getProperty(propertyName);
		
		if (propertyValue == null || propertyValue.trim().isEmpty()) {
			Properties prop = new Properties();

			try {
				FileInputStream in = new FileInputStream(configFile);
				prop.load(in);
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
				throw e;
			}

			propertyValue = prop.getProperty(propertyName);
			if (propertyValue != null) {
				propertyValue = propertyValue.trim();
			}
		}
		
		return propertyValue;
	}

	// with this one can get multiple properties in the same time. This will reduce the IO time.
	public static String[] getConfigProperties(String configFile, String[] propertyNames) throws Exception {
		int len = propertyNames.length;
		String[] propertyValues = new String[len];
		
		Properties prop = new Properties();

		try {
			FileInputStream in = new FileInputStream(configFile);
			prop.load(in);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		}

		int i = 0;
		for (String name : propertyNames) {
			String value = prop.getProperty(name);
			if (value != null) {
				value = value.trim();
			}
			propertyValues[i++] = value;
		}
		
		return propertyValues;
	}
	
	public static String getDownloadFolder() throws Exception {
		String configFile = ConfigUtils.getCongFile();
		String downloadFolder = ConfigUtils.getConfigProperty(configFile, "downloadFolder");
		
		return downloadFolder;
		
	}

}

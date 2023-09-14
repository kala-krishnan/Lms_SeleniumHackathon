package com.lmsproject.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class CommonUtils {
	static Properties properties = new Properties();
	public static String APP_URL;
	public static String BROWSER;
	public static String CHROME_DRIVER;
	

public static void loadProperties() {
		
		//FileReader reader= null;
		FileInputStream inputstr = null;
		
		try {
		 inputstr = new FileInputStream(System.getProperty("user.dir")+"//src//main//resources//config.properties");
		//reader = new FileReader("config.properties");
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		
	
	try {
	    properties.load(inputstr);
	} catch (IOException e) {
		e.printStackTrace();
	}
	APP_URL = properties.getProperty("APP_URL");
	BROWSER = properties.getProperty("BROWSER");
	CHROME_DRIVER = properties.getProperty("CHROME_DRIVER");

}
public static String getApplicationPage() {
	String appurl = properties.getProperty("applicationURL");
	if (appurl != null)
		return appurl;
	else
		throw new RuntimeException("Homeurl not specified in the Configuration.properties file.");
}
public static String getexcelfilepath() {
	String excelfilelpath = properties.getProperty("excelfilepath");
	if (excelfilelpath != null)
		return excelfilelpath;
	else
		throw new RuntimeException("Excel file path not specified in the Configuration.properties file.");
}
public static String getBatchactiveStatus() {
	String excelfilelpath = properties.getProperty("batchactive");
	if (excelfilelpath != null)
		return excelfilelpath;
	else
		throw new RuntimeException("Batch status not specified in the Configuration.properties file.");
}
public static String getBatchinactiveStatus() {
	String excelfilelpath = properties.getProperty("batchInactive");
	if (excelfilelpath != null)
		return excelfilelpath;
	else
		throw new RuntimeException("Batch Status not specified in the Configuration.properties file.");
}
public static String getBatchtitleinURL() {
	String excelfilelpath = properties.getProperty("batchExpectedURLHeader");
	if (excelfilelpath != null)
		return excelfilelpath;
	else
		throw new RuntimeException("Batch header not specified in the Configuration.properties file.");
}
}

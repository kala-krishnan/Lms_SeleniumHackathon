package com.lmsproject.components;

import java.util.Properties;

import com.lmsproject.utility.CommonUtils;
import com.lmsproject.utility.ExcelFileReader;



public class ExcelDataInputReader {
	public static String programName;
	public static String programDesc;
	public static String programStatus;
	public static String batchName;
	public static String batchDesc;
	public static String Noofclasses;
	public static String classDate;
	public static String classTopic;
	public static String staffId;
	public static String classDesc;
	public static String notes;
	public static String recording;
	public static String batchStatus;
	static Properties properties = new Properties();
	static String excelURLFile = CommonUtils.getexcelfilepath(); 
	
	public static void loadProperties()  {
		
		//FileReader reader= null;
	ExcelFileReader excel = null;
		
		String excelURL = excelURLFile;
		String path=System.getProperty("user.dir");
		excel= new ExcelFileReader(path+excelURL,"LMS-PROJECT");
		
		
		
		
		programName =excel.getCellDataString(1, 0); 
		programDesc = excel.getCellDataString(1, 1); 
		programStatus = excel.getCellDataString(1, 2); 
		batchName =  excel.getCellDataString2(1, 3);
		batchDesc = excel.getCellDataString(1, 4); 
		Noofclasses =  excel.getCellDataString2(1, 5); 
		classDate = excel.getCellDataString2(1, 6); 
		classTopic = excel.getCellDataString(1, 7); 
		staffId = excel.getCellDataString2(1, 8); 
		classDesc = excel.getCellDataString(1, 9);
		notes = excel.getCellDataString(1, 10);
		recording = excel.getCellDataString(1, 11);
		batchStatus = excel.getCellDataString(1, 12);
}
	
	
	
	
	
	
	public static String getProgramName() {
		return programName;
	}
	
	public static String getProgramDesc() {
		return programDesc;
	}
	
	public static String getProgramStatus() {
		return programStatus;
	}
	
	public static String getBatchName() {
		return batchName;
	}
	
	public static String getBatchDesc() {
		return batchDesc;
	}
	
	public static String getNoofclasses() {
		return Noofclasses;
	}
	
	public static String getClassDate() {
		return classDate;
	}
	
	public static String getClassTopic() {
		return classTopic;
	}
	
	public static String getStaffId() {
		return staffId;
	}
	
	public static String getClassDesc() {
		return classDesc;
	}
	
	public static String getNotes() {
		return notes;
	}
	
	public static String getRecording() {
		return recording;
	}
	
	public static String getBatchStatus() {
		return batchStatus;
	}
	
	
	

}

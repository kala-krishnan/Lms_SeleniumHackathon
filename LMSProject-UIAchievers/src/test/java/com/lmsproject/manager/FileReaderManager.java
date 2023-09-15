package com.lmsproject.manager;

import com.lmsproject.utility.ExcelFileReader;

public class FileReaderManager {

	private static FileReaderManager fileReaderManager = new FileReaderManager();
	private static ExcelFileReader excelFileReader;
	
	private FileReaderManager()
	{
		
	}
	
	 public static FileReaderManager getInstance( ) {
	      return fileReaderManager;
	 }

//	 public com.lmsproject.utility.ConfigFileReader getConfigReader() {
//		 return (configFileReader == null) ? new com.lmsproject.utility.ConfigFileReader(): configFileReader;
//	 }
	 
	 /*public ExcelFileReader getExcelFileReader() {
		 return (excelFileReader == null) ? new ExcelFileReader() : excelFileReader;
	 }*/
}
package com.lmsproject.utility;
import org.apache.poi.ss.usermodel.Cell;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ExcelFileReader {
	

		static String path;
		static XSSFWorkbook workbook;
		static XSSFSheet sheet;
		private final DataFormatter dataFormatter;
		static String excelURL = CommonUtils.getexcelfilepath();
		

	public ExcelFileReader(String excelPath, String sheetName) {
		this.dataFormatter = new DataFormatter();
	try {

	path=System.getProperty("user.dir");
	
	workbook= new XSSFWorkbook(excelPath);
	
	sheet= workbook.getSheet(sheetName);
	workbook.close();

	}catch(Exception e) {

	e.printStackTrace();
	}	
	}

	

	public static void getRowCount() {

	try {

		path=System.getProperty("user.dir");
		workbook= new XSSFWorkbook(path+excelURL);
		sheet= workbook.getSheet("Login");	
		int rowCount= sheet.getPhysicalNumberOfRows();
		}
	catch(Exception exp) {
		System.out.println(exp.getMessage());
		System.out.println(exp.getCause());
		exp.printStackTrace();
		}

	}

	public static String getCellDataString(int rowNum, int cellNum) {

		String cellData=" ";
	try {

		 cellData= sheet.getRow(rowNum).getCell(cellNum).getStringCellValue();
		 System.out.println(cellData);
		 return cellData;
		}
	catch(Exception exp) {
		System.out.println(exp.getMessage());
		System.out.println(exp.getCause());
		exp.printStackTrace();
		return cellData;
		}

	}

	
	
	public String getCellDataString2(int rowNumber, int columnNumber) {
        Cell cell = sheet.getRow(rowNumber).getCell(columnNumber);

        
        if (cell != null) {
        	
            return dataFormatter.formatCellValue(cell);
        }
        return "";
    }
	

	}




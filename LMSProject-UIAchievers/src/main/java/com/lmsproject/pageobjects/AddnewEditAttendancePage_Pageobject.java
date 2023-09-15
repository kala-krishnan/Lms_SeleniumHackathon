package com.lmsproject.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.lmsproject.components.*;
import com.lmsproject.utility.*;

public class AddnewEditAttendancePage_Pageobject {
public WebDriver driver;
	
	public AddnewEditAttendancePage_Pageobject(WebDriver ldriver)
	{
		this.driver=ldriver;
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy(xpath="//*[@button='drop-down']")List<WebElement> dropdownforattendance;
	//Select dropDown = new Select((WebElement) dropdownforattendance);
	public @FindBy(xpath = "//@Pagetitle[id = 'Manage Attendance Page']")
	WebElement lblPageHeaderTitle;
	@FindBy(xpath = "//@Pagetitle[id = 'Attendance details']")
	WebElement attendanceTitle;
	
	@FindBy(xpath="//*[@name='username']")
	WebElement userLogin;
	@FindBy(xpath = "//input[@id = 'Search']")
	WebElement txtSearch;
	@FindBy(xpath = "//input[@name='password']")
	WebElement passLogin;
	@FindBy(xpath = "//button[@id='ANEWAttendance']")
	WebElement lblAddnewAttend;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement btnLogin;
	public @FindBy(linkText = "Attendance")
	WebElement attendance;
	@FindBy(id = "enter")
	WebElement enterbutton;
	@FindBy(xpath = "//button[@icon='Delete']")
	WebElement iconMultipleDelete;
	private int x;
	private int y;
	@FindBy(xpath = "//*[text()='ProgramName']")
	WebElement prgnameattend;
	@FindBy(xpath = "//*[text()='classname']")
	WebElement cn;
	@FindBy(xpath = "//*[text()='Attendance']")
	WebElement attendancefield;
	@FindBy(xpath = "//*[text()='Student']")
	WebElement studentfield;
	@FindBy(xpath = "//button[@icon='Delete']")
	WebElement iconMultipleDelete1;
	@FindBy(xpath = "//button[@label='Cancel']")
	WebElement btnCancel;
	@FindBy(xpath = "//button[@label='Save']")
	WebElement btnSave;
	String p="present";
	@FindBy(xpath="//*[text()='Show Calendar']")WebElement calendar;
	@FindBy(tagName="td")List<WebElement> columns;
	ExcelDataInputReader readInput = new ExcelDataInputReader();
	public void filldetailsAttendance(String typeofdata)
	{
		if(typeofdata.equalsIgnoreCase("all the values"))
		{
			prgnameattend.sendKeys(ExcelDataInputReader.getProgramName());
			cn.sendKeys(ExcelDataInputReader.getClassname());
			studentfield.sendKeys(ExcelDataInputReader.getStudentname());
			dropdownforattendance.get(0).sendKeys(p);
			calendar.click();
			columns.get(0).click();
			btnSave.click();
			
		}
		
		if(typeofdata.equalsIgnoreCase("missing program"))
		{
			cn.sendKeys(ExcelDataInputReader.getClassname());
			studentfield.sendKeys(ExcelDataInputReader.getStudentname());
			dropdownforattendance.get(0).sendKeys(p);
			calendar.click();
			columns.get(0).click();
			btnSave.click();
		}
		if(typeofdata.equalsIgnoreCase("missing class"))
				{
			prgnameattend.sendKeys(ExcelDataInputReader.getProgramName());
			studentfield.sendKeys(ExcelDataInputReader.getStudentname());
			dropdownforattendance.get(0).sendKeys(p);
			calendar.click();
			columns.get(0).click();
			btnSave.click();
				}
		if(typeofdata.equalsIgnoreCase("missing student"))
		{
			prgnameattend.sendKeys(ExcelDataInputReader.getProgramName());
			cn.sendKeys(ExcelDataInputReader.getClassname());
			dropdownforattendance.get(0).sendKeys(p);
			calendar.click();
			columns.get(0).click();
			btnSave.click();
			
		}
		if(typeofdata.equalsIgnoreCase("missing Attendance"))
		{
			prgnameattend.sendKeys(ExcelDataInputReader.getProgramName());
			cn.sendKeys(ExcelDataInputReader.getClassname());
			studentfield.sendKeys(ExcelDataInputReader.getStudentname());
			calendar.click();
			columns.get(0).click();
			btnSave.click();
		}
		if(typeofdata.equalsIgnoreCase("Attendance date"))
		{
			prgnameattend.sendKeys(ExcelDataInputReader.getProgramName());
			cn.sendKeys(ExcelDataInputReader.getClassname());
			studentfield.sendKeys(ExcelDataInputReader.getStudentname());
			dropdownforattendance.get(0).sendKeys(p);
			btnSave.click();
		}
	}
	public void  futuredate()
	{
		 
		   
		    calendar.click();
		    	columns.get(3).click();
		    	
		    	
		    	
		    }
}

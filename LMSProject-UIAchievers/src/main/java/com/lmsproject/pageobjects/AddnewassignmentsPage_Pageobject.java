package com.lmsproject.pageobjects;

import java.util.List;
import com.lmsproject.components.*;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class AddnewassignmentsPage_Pageobject {
public WebDriver driver;
	
	public AddnewassignmentsPage_Pageobject(WebDriver ldriver)
	{
		this.driver=ldriver;
		PageFactory.initElements(driver,this);
	}
	
	
	public @FindBy(xpath = "//*[text()='Program Name']")
	WebElement prgname;
	public @FindBy(xpath = "//*[text()='batch number']")
	WebElement batchnum;
	public @FindBy(xpath = "//*[text()='Assignment name']")
	 WebElement assgnname;
	public @FindBy(xpath = "//*[text()='Assignment Description']")
	WebElement assgndesc;
	public @FindBy(xpath = "//*[text()='grade by']")
	WebElement grade;
	public @FindBy(xpath = "//*[text()='Assignment due date']")
	WebElement duedate;
	public @FindBy(xpath = "//*[text()='Assignment File1']")
	WebElement af1;
	public @FindBy(xpath = "//*[text()='Assignment File2']")
	WebElement af2;
	public @FindBy(xpath = "//*[text()='Assignment File3']")
	WebElement af3;
	public @FindBy(xpath = "//*[text()='Assignment File5']")
	WebElement af5;
	public @FindBy(xpath = "//*[text()='Assignment File4']")
	WebElement af4;
	public @FindBy(xpath = "//button[@label='Cancel']")
	WebElement btnCancel;
	public @FindBy(xpath = "//button[@label='Save']")
	WebElement btnSave;
	public void passingdetails(String typeofdetails)
	{
		if(typeofdetails.equalsIgnoreCase("all valid data"))
		{
		prgname.sendKeys(ExcelDataInputReader.getProgramName());
		batchnum.sendKeys(ExcelDataInputReader.getBatchName());
		assgnname.sendKeys(ExcelDataInputReader.getAssignmentname());
		assgndesc.sendKeys(ExcelDataInputReader.getAssignmentDescription());
		grade.sendKeys(ExcelDataInputReader.getGradeby());
		duedate.sendKeys(ExcelDataInputReader.getAssignmentduedate());
		af1.sendKeys(ExcelDataInputReader.getAssignmentFile1());
		af2.sendKeys(ExcelDataInputReader.getAssignmentFile2());
		af3.sendKeys(ExcelDataInputReader.getAssignmentFile3());
		af4.sendKeys(ExcelDataInputReader.getAssignmentFile4());
		af5.sendKeys(ExcelDataInputReader.getAssignmentFile5());
		btnSave.click();
		}
		else if(typeofdetails.equalsIgnoreCase("valid data"))
		{
			prgname.sendKeys(ExcelDataInputReader.getProgramName());
			batchnum.sendKeys(ExcelDataInputReader.getBatchName());
			assgnname.sendKeys(ExcelDataInputReader.getAssignmentname());
			assgndesc.sendKeys(ExcelDataInputReader.getAssignmentDescription());
			duedate.sendKeys(ExcelDataInputReader.getAssignmentduedate());
		}
		
		else if(typeofdetails.equalsIgnoreCase("program name"))
		{
			batchnum.sendKeys(ExcelDataInputReader.getBatchName());
			assgnname.sendKeys(ExcelDataInputReader.getAssignmentname());
			assgndesc.sendKeys(ExcelDataInputReader.getAssignmentDescription());
			grade.sendKeys(ExcelDataInputReader.getGradeby());
			duedate.sendKeys(ExcelDataInputReader.getAssignmentduedate());
			af1.sendKeys(ExcelDataInputReader.getAssignmentFile1());
			af2.sendKeys(ExcelDataInputReader.getAssignmentFile2());
			af3.sendKeys(ExcelDataInputReader.getAssignmentFile3());
			af4.sendKeys(ExcelDataInputReader.getAssignmentFile4());
			af5.sendKeys(ExcelDataInputReader.getAssignmentFile5());
			btnSave.click();
		}
		
		else if(typeofdetails.equalsIgnoreCase("batch number"))
		{	
			prgname.sendKeys(ExcelDataInputReader.getProgramName());
			assgnname.sendKeys(ExcelDataInputReader.getAssignmentname());
			assgndesc.sendKeys(ExcelDataInputReader.getAssignmentDescription());
			grade.sendKeys(ExcelDataInputReader.getGradeby());
			duedate.sendKeys(ExcelDataInputReader.getAssignmentduedate());
			af1.sendKeys(ExcelDataInputReader.getAssignmentFile1());
			af2.sendKeys(ExcelDataInputReader.getAssignmentFile2());
			af3.sendKeys(ExcelDataInputReader.getAssignmentFile3());
			af4.sendKeys(ExcelDataInputReader.getAssignmentFile4());
			af5.sendKeys(ExcelDataInputReader.getAssignmentFile5());
			btnSave.click();
		}
		else if(typeofdetails.equalsIgnoreCase("Assignment name"))
		{
			prgname.sendKeys(ExcelDataInputReader.getProgramName());
			batchnum.sendKeys(ExcelDataInputReader.getBatchName());
			assgndesc.sendKeys(ExcelDataInputReader.getAssignmentDescription());
			grade.sendKeys(ExcelDataInputReader.getGradeby());
			duedate.sendKeys(ExcelDataInputReader.getAssignmentduedate());
			af1.sendKeys(ExcelDataInputReader.getAssignmentFile1());
			af2.sendKeys(ExcelDataInputReader.getAssignmentFile2());
			af3.sendKeys(ExcelDataInputReader.getAssignmentFile3());
			af4.sendKeys(ExcelDataInputReader.getAssignmentFile4());
			af5.sendKeys(ExcelDataInputReader.getAssignmentFile5());
			btnSave.click();
		}
		else if(typeofdetails.equalsIgnoreCase("Assignment due date"))
		{
			prgname.sendKeys(ExcelDataInputReader.getProgramName());
			batchnum.sendKeys(ExcelDataInputReader.getBatchName());
			assgnname.sendKeys(ExcelDataInputReader.getAssignmentname());
			assgndesc.sendKeys(ExcelDataInputReader.getAssignmentDescription());
			grade.sendKeys(ExcelDataInputReader.getGradeby());
			af1.sendKeys(ExcelDataInputReader.getAssignmentFile1());
			af2.sendKeys(ExcelDataInputReader.getAssignmentFile2());
			af3.sendKeys(ExcelDataInputReader.getAssignmentFile3());
			af4.sendKeys(ExcelDataInputReader.getAssignmentFile4());
			af5.sendKeys(ExcelDataInputReader.getAssignmentFile5());
			btnSave.click();
		}
		
		else if(typeofdetails.equalsIgnoreCase("Grade by"))
		{
			prgname.sendKeys(ExcelDataInputReader.getProgramName());
			batchnum.sendKeys(ExcelDataInputReader.getBatchName());
			assgnname.sendKeys(ExcelDataInputReader.getAssignmentname());
			assgndesc.sendKeys(ExcelDataInputReader.getAssignmentDescription());
			duedate.sendKeys(ExcelDataInputReader.getAssignmentduedate());
			af1.sendKeys(ExcelDataInputReader.getAssignmentFile1());
			af2.sendKeys(ExcelDataInputReader.getAssignmentFile2());
			af3.sendKeys(ExcelDataInputReader.getAssignmentFile3());
			af4.sendKeys(ExcelDataInputReader.getAssignmentFile4());
			af5.sendKeys(ExcelDataInputReader.getAssignmentFile5());
			btnSave.click();
		}
		
	}
	
	public void invaliddetailsMandatory(String s,String s1,String s2,String s3,String s4)
	{
		prgname.sendKeys(s);
		   batchnum.sendKeys(s1);
		   assgnname.sendKeys(s2);
		   grade.sendKeys(s3);
		   assgndesc.sendKeys(s4);
		   
	}
	
	public void invalidoptional(String s,String s1,String s2,String s3,String s4)
	{
		af1.sendKeys(s);
		af2.sendKeys(s1);
		af3.sendKeys(s2);
		af4.sendKeys(s3);
		af5.sendKeys(s4);
;	}
}

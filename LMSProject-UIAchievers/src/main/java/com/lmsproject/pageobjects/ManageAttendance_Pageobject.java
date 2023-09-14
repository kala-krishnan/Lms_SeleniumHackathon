package com.lmsproject.pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
//import org.testng.Assert;

import com.lmsproject.utility.CommonWebElements;


public class ManageAttendance_Pageobject {
	public WebDriver driver;
	CommonWebElements cm;
	ManageAttendance_Pageobject mpa;
	public ManageAttendance_Pageobject(WebDriver ldriver) {
		this.driver = ldriver;
		PageFactory.initElements(driver, this);
		cm = new CommonWebElements(driver);// 'this' to optimize our code instead of specifying each and every page
	}

	String Assignment;
	Actions action;

	@FindBy(xpath = "//button[@icon='Delete']")
	WebElement iconMultipleDelete1;
	@FindBy(xpath = "//button[@label='Cancel']")
	WebElement btnCancel;
	@FindBy(xpath = "//button[@label='Save']")
	WebElement btnSave;
	@FindBy(xpath = "//button[@label='rs-close']")
	WebElement close;
	@FindBy(xpath="//*[@button='drop-down']")List<WebElement> dropdownforattendance;
	//Select dropDown = new Select((WebElement) dropdownforattendance);
	String URL = "https://example.com/login";
	@FindBy(xpath = "//Select[@id = 'Select']")
	WebElement checkBoxMultipleSelect;
	@FindBys({ @FindBy(xpath = "//gridtable") })
	List<WebElement> PageGridTable;
	@FindBys({ @FindBy(xpath = "//table/pagegridtable") })
	List<WebElement> PageGridDetail;
	@FindBy(xpath = "//paginator")
	public WebElement lblPaginationEntries;

	@FindBy(id = "resultgrid")
	WebElement table;
	@FindBy(xpath ="//div/label[text()='User']")
	WebElement nameText;
	
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
	
		public @FindBy(xpath = "//table/singlecheckbox") 
	WebElement checkboxSingle; 
		public @FindBys({
			@FindBy(xpath = "//table/singlecheckbox") 
		})List<WebElement> checkboxSingleSelect; 
		
	
	public boolean urlhavingattendance() {
		String url = driver.getCurrentUrl();
		boolean val = url.contains("Manage attendance");
		return val;
	}
	public boolean fieldforall()
	{
		boolean val=attendancefield.getText().contains("Present");
		return val;
	}
	public boolean fieldforall1()
	{
		boolean val=attendancefield.getText().contains("late");
		return val;
	}
	public boolean fieldforall2()
	{
		boolean val=attendancefield.getText().contains("absent");
		return val;
	}
	public boolean fieldforall3()
	{
		boolean val=attendancefield.getText().contains("excused");
		return val;
	}
		
		
	

	
	public void leftsideof_the_page()
	{ 

		 Point location = attendanceTitle.getLocation();
		 int x = location.getX();
	       int y = location.getY();
	      System.out.println("X : " + location.getX());
	        System.out.println("Y : " + location.getY());
		
    int xcord=mpa.x;
    int ycord=mpa.y;
  if(mpa.x>10 && mpa.y>10)
  {
	  System.out.println("left side of the page");
  }
	}
	public boolean searchbarfield() {
		boolean search = txtSearch.isDisplayed();
		return search;
	}
	public boolean addnewbutton() {
		boolean add = lblAddnewAttend.isDisplayed();
		return add;
	}
	private List<String> prepareList(List<WebElement> we) {

		List<String> sortList = new ArrayList<String>();
		for (WebElement item : we) {
			sortList.add(item.getText());
		}
		return sortList;
	}
	public boolean columnheadersattend(String Page) {

		List<String> tblHeading = new ArrayList<String>();
		tblHeading = prepareList(PageGridTable);
		if (Page.equalsIgnoreCase("Attendance")) {
			if (tblHeading.contains("class ID") && tblHeading.contains("Student ID")
					&& tblHeading.contains("Present") && tblHeading.contains("Edit/Delete")) {
				return true;
			}
		}
		return true;
	}

	public void tabledataattend() {

		List<WebElement> allRows = ((By) PageGridDetail).findElements((SearchContext) By.tagName("tr"));
		// And iterate over them, getting the cells
		for (WebElement row : allRows) {
			List<WebElement> cells = row.findElements(By.tagName("td"));
			for (WebElement cell : cells) {
				System.out.println(cell.getText());
				if (cell.getText().isEmpty()) {
					cm.IsEditButtonEnabledInTableRows(row);
					iconMultipleDelete.isDisplayed();
				}
			}
		}
	}
	public void correctspellforall() {
		driver.get("https://insites.com");
		txtSearch.sendKeys(URL);
		enterbutton.click();
	}
	
	public void dropdown()
	{		
		int val=dropdownforattendance.size();
		
	}

public boolean popupclose()
{
	driver.switchTo().alert();
	return(close.isDisplayed());
}
public boolean popupcancel()
{
	driver.switchTo().alert();
	return(btnCancel.isDisplayed());
}

public int dropdownattend(String string)
{
	int order=dropdownforattendance.indexOf(string);
	return order;
}

public boolean comparestring()
{
	String text=dropdownforattendance.get(0).getText();
	
	 String ptext=prgnameattend.getText();
	 
	 if(ptext.equalsIgnoreCase(text))
{
	System.out.println("values matched");
}
	return true;
}

public boolean comparestringforclass()
{
	String text=dropdownforattendance.get(1).getText();
	
	 String classtext=cn.getText();
	 
	 if(classtext.equalsIgnoreCase(text))
{
	System.out.println("values matched");
}
	return true;
}
String order ;
public void dropdownattendfor_spell()
{
	for(i=0;i<dropdownforattendance.size();i++)
	{
	 order = dropdownforattendance.get(i).getText();
	 
	}
	driver.get("https://insites.com");
	txtSearch.sendKeys(order);
	enterbutton.click();
}


public String verifyColorforattend()
{
      String userTextColor = nameText.getCssValue("color");
      String UserColorinHex = Color.fromString(userTextColor).asHex();
      return UserColorinHex;
}
public boolean saveinpopup()
{
	driver.switchTo().alert();
	return(btnSave.isDisplayed());
}
int i;
public int order(String navgationfieldname)
{
	List<WebElement> GetStart= driver.findElements(By.xpath("//a[@class='list-group-item']"));
	
	for(i=0;i<=GetStart.size();i++)
	{
		if(navgationfieldname==GetStart.get(i).getText()) {
			break;
		}
		
	}
	return i;
}

public boolean adminpopup()
{
	driver.switchTo().alert();
	boolean val=attendanceTitle.isDisplayed();
	return val;
}
public void Adminclicks(String fieldname) {

	switch (fieldname) {
	case "Program Name":
		prgnameattend.isDisplayed();
		prgnameattend.click();
		break;
	
	case "class name":
		cn.isDisplayed();
		cn.click();
		break;
	case "Attendancefield":
		attendancefield.isDisplayed();
		attendancefield.click();
		break;
	
	default:
		System.out.println("please enter valid fieldname");
		break;

	}

}
}

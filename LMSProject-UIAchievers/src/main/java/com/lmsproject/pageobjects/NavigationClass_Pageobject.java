package com.lmsproject.pageobjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NavigationClass_Pageobject {
	
	WebDriver driver;
	public NavigationClass_Pageobject(WebDriver driver)
	 { 
		
	  this.driver = driver;
	  PageFactory.initElements(driver, this);
	   
	 }
	
	@FindBy(xpath="//a[contains(@href,'Student')]") WebElement studentPageEle;
	@FindBy(xpath="//a[contains(@href,'Program')]") WebElement programPageEle;
	@FindBy(xpath="//a[contains(@href,'Batch')]") WebElement batchPageEle;
	@FindBy(xpath="//a[contains(@href,'User')]") WebElement userPageEle;
	@FindBy(xpath="//a[contains(@href,'Assignment')]") WebElement assignmentPageEle;
	@FindBy(xpath="//a[contains(@href,'Attendance')]") WebElement attendancePageEle;
	@FindBy(xpath="//a[contains(@href,'Logout')]") WebElement logoutEle;
	
	public void webpage() {
		driver.get("https://example.com/login");
	}
	public String getPageTitle() {
		 
		String title = driver.getTitle();
		return title; 
	}
	public void ClickOnStudentPageLink()
	{
		studentPageEle.click();
	}
	public void ClickOnProgramPageLink()
	{
		programPageEle.click();
	}
	public void ClickOnBatchPageLink()
	{
		batchPageEle.click();
	}
	 public void ClickUserPageLink()
	 {
		 userPageEle.click(); 
	 }
	 public void ClickAssignmentPageLink()
	 {
		 assignmentPageEle.click();
	 }
	 public void ClickAttendancePageLink()
	 {
		 attendancePageEle.click();
	 }
	 public void ClickLogoutLink()
	 {
		 logoutEle.click();
	 }
	public void validSuccessHomepage() {
		// TODO Auto-generated method stub
		
	}
}

package com.lmsproject.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Additional_Pageobject {
	@FindBy(linkText="student") WebElement stud1;
	@FindBy(linkText="program") WebElement prog;
	@FindBy(linkText="batch") WebElement batch;
	@FindBy(linkText="class") WebElement classes;
	@FindBy(linkText="user") WebElement user;
	@FindBy(linkText="Assignment") WebElement assign;
	@FindBy(linkText="Attend") WebElement attend;
	@FindBy(linkText="logout") WebElement logt;
	WebDriver driver;
	public Additional_Pageobject(WebDriver driver)
	 {
	  this.driver = driver;
	  PageFactory.initElements(driver, this);
//	  acts= new Actions(driver);
	 }
	
	public void url()
	{
		driver.get("https://example.com/login");
	}
	
	public void clickstudent()
	{
		stud1.click();
	}
	public String studentpage()
	{
		String studentpage=driver.getTitle();
		return studentpage;
	}
	public void clickprogram()
	{
		prog.click();
	}
	public String progpage()
	{
		String progp=driver.getTitle();
		return progp;
	}
	public void clickbatch()
	{
		batch.click();
	}
	public String batchpage()
	{
		String batchp=driver.getTitle();
		return batchp;
	}
	public void clickclass()
	{
		classes.click();
	}
	public String classpage()
	{
		String classp=driver.getTitle();
		return classp;
	}
	public void clickuser()
	{
		user.click();
	}
	public String userpage()
	{
		String userp=driver.getTitle();
		return userp;
	}
	public void clickassign()
	{
		assign.click();
	}
	public String assignpage()
	{
		String assignp=driver.getTitle();
		return assignp;
	}
	public void clickattend()
	{
		attend.click();
	}
	public String attendpage()
	{
		String attendp=driver.getTitle();
		return attendp;
	}
	public void clicklogout()
	{
		logt.click();
	}
	public boolean logoutpage()
	{
		String logoutp=driver.getTitle();
		boolean val=logt.isEnabled();
		return val;
	}
}

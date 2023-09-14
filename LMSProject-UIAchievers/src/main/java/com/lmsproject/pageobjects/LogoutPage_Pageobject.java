package com.lmsproject.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage_Pageobject {
	WebDriver driver;
	@FindBy(linkText="logout") WebElement logt;
	
	public LogoutPage_Pageobject(WebDriver driver)
	 {
	  this.driver = driver;
	  PageFactory.initElements(driver, this);
	 }
	
	public void launchurl()
	{
		driver.get("https://example.com");
	}
	
	public void logoutbtn()
	{
		logt.click();
	}
	
	public String againlogin()
	{
		String logintitle=driver.getTitle();
		return logintitle;
	}
}

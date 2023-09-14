package com.lmsproject.apphooks;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import com.lmsproject.driverfactory.DriverManager;
import com.lmsproject.manager.FileReaderManager;
import com.lmsproject.manager.PageObjectManager;
import com.lmsproject.utility.CommonWebElements;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestContext {
	
	private DriverManager driverManager;
	private PageObjectManager pageObjectManager;
	private CommonWebElements commonElement;
	private FileReaderManager fileReaderManager;
	WebDriver driver;
	
	public TestContext()
	{
		driver = Hooks.getDriver();
		driverManager = new DriverManager();
		pageObjectManager = new PageObjectManager(driver);
		commonElement = new CommonWebElements(driver);
		fileReaderManager = FileReaderManager.getInstance();
	}
	
	public DriverManager getDriverManager()
	{
		return driverManager;
	}

	public PageObjectManager getPageObjectManager() 
	{
		return pageObjectManager;
	}
	
	public CommonWebElements getCommonElement()
	{
		return commonElement;
	}
	public FileReaderManager getFileReaderManager()
	{
		return fileReaderManager;
	}

}

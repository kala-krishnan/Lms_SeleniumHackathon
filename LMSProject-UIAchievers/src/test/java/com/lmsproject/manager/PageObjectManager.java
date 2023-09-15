package com.lmsproject.manager;

import org.openqa.selenium.WebDriver;

import com.lmsproject.pageobjects.AddOrEditProgramPage_Pageobject;
import com.lmsproject.pageobjects.DashboardPage_Pageobject;
import com.lmsproject.pageobjects.ForgotUsernameOrPasswordPage_Pageobject;
import com.lmsproject.pageobjects.HomePage_Pageobject;
import com.lmsproject.pageobjects.LoginPage_Pageobject;
import com.lmsproject.pageobjects.ProgramPage_Pageobject;
import com.lmsproject.pageobjects.ResetPasswordPage_Pageobject;

public class PageObjectManager {
	
	private WebDriver driver;
	private LoginPage_Pageobject loginPage;
	private DashboardPage_Pageobject dashboardPage;
	private ProgramPage_Pageobject programPage;
	private AddOrEditProgramPage_Pageobject addOrEditProgramPage;
	private HomePage_Pageobject homePage;
	private ForgotUsernameOrPasswordPage_Pageobject forgotUsernameOrPasswordPage_Pageobject;
	private ResetPasswordPage_Pageobject resetPassword_Pageobject;
	
	//constructor
	public PageObjectManager(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//singleton design pattern
	public LoginPage_Pageobject getLoginPage()
	{
		if(loginPage==null)
		{
			loginPage = new LoginPage_Pageobject(driver);
		}
		return loginPage;
	}
	
	public DashboardPage_Pageobject getdashboardPage()
	{
		if(dashboardPage==null)
		{
			dashboardPage = new DashboardPage_Pageobject(driver);
		}
		return dashboardPage;
	}
	
	
	public ProgramPage_Pageobject getProgramPage()
	{
		if(programPage==null)
		{
			programPage = new ProgramPage_Pageobject(driver);
		}
		return programPage;
	}
	public AddOrEditProgramPage_Pageobject getAddOrEditProgramPage()
	{
		if(addOrEditProgramPage==null)
		{
			addOrEditProgramPage = new AddOrEditProgramPage_Pageobject(driver);
		}
		
		return addOrEditProgramPage;
	}
	public HomePage_Pageobject getHomePage()
	{
		if(homePage==null)
		{
			homePage = new HomePage_Pageobject(driver);
		}
		return homePage;
	}
	public ForgotUsernameOrPasswordPage_Pageobject getForgotUsernameOrPasswordPage()
	{
		if(forgotUsernameOrPasswordPage_Pageobject==null)
		{
			forgotUsernameOrPasswordPage_Pageobject = new ForgotUsernameOrPasswordPage_Pageobject(driver);
		}
		return forgotUsernameOrPasswordPage_Pageobject;
	}
	public ResetPasswordPage_Pageobject getResetPassword()
	{
		if(resetPassword_Pageobject==null)
		{
			resetPassword_Pageobject = new ResetPasswordPage_Pageobject(driver);
		}
		return resetPassword_Pageobject;
	}

}

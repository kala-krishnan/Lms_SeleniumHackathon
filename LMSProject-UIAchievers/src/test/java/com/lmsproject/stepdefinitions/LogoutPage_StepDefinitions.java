package com.lmsproject.stepdefinitions;
import com.lmsproject.apphooks.*;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import org.testng.log4testng.Logger;

import com.lmsproject.pageobjects.LogoutPage_Pageobject;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class LogoutPage_StepDefinitions {
	private WebDriver driver;
	private static final Logger LOG=Logger.getLogger(LogoutPage_StepDefinitions.class); 
	LogoutPage_Pageobject ls;
	SoftAssert sa= new SoftAssert();
	public LogoutPage_StepDefinitions()
	{
		driver = Hooks.getDriver();
		ls=new LogoutPage_Pageobject(driver);
		
	}
@Given("Admin is in dashboard page")
public void admin_is_in_dashboard_page() {
  ls.launchurl();
  sa.assertEquals("Launchpage","url");
}

@When("Admin click Logout button on navigation bar")
public void admin_click_logout_button_on_navigation_bar() {
    ls.logoutbtn();
    sa.assertEquals(false,true);
}

@Then("Admin should land on login in page")
public void admin_should_land_on_login_in_page() {
    String txt=ls.againlogin();
    sa.assertEquals("newpage",txt);
}
}

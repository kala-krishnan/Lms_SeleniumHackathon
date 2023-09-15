package com.lmsproject.stepdefinitions;

import java.io.IOException;
import java.util.List;
import com.lmsproject.apphooks.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.log4testng.Logger;

import com.lmsproject.pageobjects.DashboardPage_Pageobject;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class DashboardPage_StepDefinitions {
	DashboardPage_Pageobject dp;
	private WebDriver driver;
	private static final Logger LOG=Logger.getLogger(DashboardPage_StepDefinitions.class); 

	public DashboardPage_StepDefinitions(){

		driver = Hooks.getDriver();
		dp = new DashboardPage_Pageobject(driver);

	}
	
	
	@Given("Admin launch the browser to open UI")
	public void admin_launch_the_browser_to_open_ui() {
	   LOG.info("Admin launches the browser ");
	}

	@Given("Admin is in login page to sign in")
	public void admin_is_in_login_page_to_sign_in() {
	  
		dp.urlLogin();
		LOG.info("Admin is in login page");
	   
	}

	@When("The admin enter valid credentials and clicks login button to enter dashboard")
	public void the_admin_enter_valid_credentials_and_clicks_login_button_to_enter_dashboard(List<String> data) {
		dp.loginUsingValidDetails(data.get(0),data.get(1));
		   LOG.info("validating credentials");
	}
	

	

	@Then("Admin should see manage program as header")
	public void admin_should_see_manage_program_as_header() {
	    String header=dp.headermesg();
	    Assert.assertEquals("header",header);
	    LOG.info("verify header");
	}
	@When("Admin enters URL and clicks login button")
	public void admin_enters_url_and_clicks_login_button() {
	   dp.urlLogin();
	}

	@Then("Admin should be in login page")
	public void admin_should_be_in_login_page() {
	    String log=dp.loginpage();
	    Assert.assertEquals("hello",dp);
	    LOG.info("login page");
	}

	@Then("Maximum navigation time in milliseconds, defaults to {int} seconds in Dasboard")
	public void maximum_navigation_time_in_milliseconds_defaults_to_seconds_in_Dashboard(Integer int1) {
	    dp.timer();
	    Assert.assertEquals(int1,dp.pageLoadTime_Seconds);
	    LOG.info("navigation time calculated");
	}

	@Then("HTTP response >= {int}. Then the link is broken for dashboard")
	public void http_response_then_the_link_is_broken_for_dashboard(Integer int1) throws IOException {
	   dp.linkbroker();
	   Assert.assertEquals(int1, dp.code);
	   LOG.info("link broken validatio");
	}

	@Then("Admin should see LMS -Learning management system  as title in Dashboard")
	public void admin_should_see_lms_learning_management_system_as_title_in_Dashboard() {
	  String title=dp.titlelms();
	  Assert.assertEquals("LMS",title);
	  LOG.info("Validating title");
	}

	@Then("LMS title should be on the top left corner of page")
	public void lms_title_should_be_on_the_top_left_corner_of_page() {
	    
	    dp.leftcorner();
	    int xcord=dp.x;
	    int ycord=dp.y;
	    Assert.assertEquals(10,xcord);
	    Assert.assertEquals(10,ycord);
	}

	@Then("Admin should see correct spelling in navigation bar text")
	public void admin_should_see_correct_spelling_in_navigation_bar_text() {
	    String nav=(String) dp.navspell();
	    Assert.assertEquals("hello",nav);
	}

	@Then("Admin should see correct spelling and space in LMS title")
	public void admin_should_see_correct_spelling_and_space_in_lms_title() {
	  String spell=dp.spellspace();
	  Assert.assertEquals("hi",spell);
	  Assert.assertEquals("space",dp.var1);
	  
	}

@Then("Admin should see the navigation bar text on the top right side")
public void admin_should_see_the_navigation_bar_text_on_the_top_right_side() {
  dp.rightposition();
  int right=dp.i;
  int left=dp.j;
  Assert.assertEquals(6,right>0);
  Assert.assertEquals(78,left>0);
}
@Then("Admin should see {string} in the {int} position")
public void admin_should_see_in_the_position(String string, Integer int1) {
   int orderposition=dp.order(string);
   Assert.assertEquals(int1,orderposition);
}

}

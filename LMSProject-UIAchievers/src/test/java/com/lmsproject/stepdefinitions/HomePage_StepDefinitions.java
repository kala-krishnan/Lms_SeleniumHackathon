package com.lmsproject.stepdefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import org.testng.log4testng.Logger;

import com.lmsproject.pageobjects.HomePage_Pageobject;

import com.lmsproject.apphooks.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class HomePage_StepDefinitions {
	HomePage_Pageobject hp;
	SoftAssert sa=new SoftAssert();
	private WebDriver driver;
	private static final Logger LOG=Logger.getLogger(HomePage_StepDefinitions.class);      
	public HomePage_StepDefinitions()
	{
		driver = Hooks.getDriver();
		 hp=new HomePage_Pageobject(driver);
		
	}
	@Given("Admin launch the browser")
	public void admin_launch_the_browser() {
	   LOG.info("Admin launches the browser"); 
	}

	@When("Admin gives the correct LMS portal URL")
	public void admin_gives_the_correct_lms_portal_url() {
	    hp.urlBrowser();
	    LOG.info("url is launched");
	}

	@Then("Admin should land on the home page")
	public void admin_should_land_on_the_home_page() {
	    String actual=hp.validSuccessHomepage();
	  
	    Assert.assertEquals("welcometopage",actual);
	    driver.close();
	}

	@When("Admin gives the invalid LMS portal URL")
	public void admin_gives_the_invalid_lms_portal_url() {
	    hp.invalidurl();
	}

	@Then("Admin should recieve {int} page not found error")
	public void admin_should_recieve_page_not_found_error(Integer int1) {
	  // int1=404;
	   String actualmsg=hp.notFound();
	   actualmsg.contains(actualmsg);//
	}
	@Then("HTTP response >= {int} the link is broken")
	public void http_response_the_link_is_broken(Integer int1) throws IOException {
	   // int1=404;
	   hp.brokenlink();
	   Assert.assertEquals(int1,hp.code);
	}

	@Then("Admin should see correct spellings in all fields")
	public void admin_should_see_correct_spellings_in_all_fields() {
	  String spell= (String) hp.spellCheck();
	   Assert.assertEquals("LOG",spell);
	}

	@Then("Admin should see correct logo of the LMS")
	public void admin_should_see_correct_logo_of_the_lms() throws IOException {
	    hp.validlogo();
//	    ImageDiffer imgDiff=new ImageDiffer();
//	    ImageDiff diff=imgDiff.makeDiff(hp.expectedimage1,hp.actualimage);
//	    Assert.assertEquals(true,diff.hasDiff());
	}

	@Then("Admin should see logo is properly aligned")
	public void admin_should_see_logo_is_properly_aligned() {
		boolean vallogoalign =hp.alignlogo();
		Assert.assertTrue(vallogoalign);
	}

	@Then("Admin should see login button")
	public void admin_should_see_login_button() {
	    boolean val=hp.loginButton();
	    Assert.assertEquals(true,val);
	}

	@Then("Admin should able to click the Login button")
	public void admin_should_able_to_click_the_login_button() {
	 boolean val=hp.clickable();
	 Assert.assertEquals(true,val);
	
	 LOG.info("admin unable to click the login button as it is diabled");
	}

}

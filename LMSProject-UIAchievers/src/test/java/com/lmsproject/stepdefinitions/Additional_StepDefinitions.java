package com.lmsproject.stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import org.testng.log4testng.Logger;

import com.lmsproject.pageobjects.Additional_Pageobject;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import com.lmsproject.apphooks.*;
public class Additional_StepDefinitions {
	SoftAssert sa=new SoftAssert();
	Additional_Pageobject ap;
	private WebDriver driver;
	private static final Logger LOG=Logger.getLogger(Additional_StepDefinitions.class);      
	public Additional_StepDefinitions()
	{
		driver=Hooks.getDriver();
		 ap =new Additional_Pageobject(driver);
		
	}
	@Given("Admin is on Dashboard Page")
	public void admin_is_on_dashboard_page() {
	   ap.url();
	}

	@When("clicks on student navigation button")
	public void clicks_on_student_navigation_button() {
	   ap.clickstudent();
	   LOG.info("STUDENT BUTTON ");
	}

	@Then("Admin should navigate to student page")
	public void admin_should_navigate_to_student_page() {
	   String p=ap.studentpage();
	   sa.assertEquals(null,p);
	   LOG.info("admin is in student page");
	}

	@When("cLicked on program navigation bar link")
	public void c_licked_on_program_navigation_bar_link() {
	    ap.clickprogram();
	    LOG.info("admin click program button ");
	}

	@Then("Admin should navigate to program page")
	public void admin_should_navigate_to_program_page() {
	    String s=ap.progpage();
	    sa.assertEquals(null,s);
	    LOG.info("program page");
	}

	@When("cLicked on Batch navigation bar link")
	public void c_licked_on_batch_navigation_bar_link() {
		ap.clickbatch();
	    LOG.info("admin click batch button ");
	}

	@Then("Admin should navigate to Batch page")
	public void admin_should_navigate_to_batch_page() {
		String b=ap.batchpage();
	    sa.assertEquals(null,b);
	    LOG.info("batch page");
	}

	@When("cLicked on program class bar link")
	public void c_licked_on_program_class_bar_link() {
		ap.clickclass();
	    LOG.info("admin click class button ");
	}

	@Then("Admin should navigate to class page")
	public void admin_should_navigate_to_class_page() {
		String c=ap.classpage();
	    sa.assertEquals(null,c);
	    LOG.info("class page");
	}

	@When("cLicked on user naigation bar link")
	public void c_licked_on_user_naigation_bar_link() {
		ap.clickuser();
	    LOG.info("admin click user button ");
	}

	@Then("Admin should navigate to user page")
	public void admin_should_navigate_to_user_page() {
		String u=ap.userpage();
	    sa.assertEquals(null,u);
	    LOG.info("user page");
	}

	@When("cLicked on Assignment navigation bar link")
	public void c_licked_on_assignment_navigation_bar_link() {
	    ap.clickassign();LOG.info("admin click assign button ");
	}

	@Then("Admin should navigate to Assignemnt page")
	public void admin_should_navigate_to_assignemnt_page() {
		String asgn=ap.assignpage();
	    sa.assertEquals(null,asgn);
	    LOG.info("Assign page");
	}

	@When("cLicked on Attendance navigation bar link")
	public void c_licked_on_attendance_navigation_bar_link() {
		ap.clickattend();LOG.info("admin click attendance button ");
	}

	@Then("Admin should navigate to Attendance page")
	public void admin_should_navigate_to_attendance_page() {
	   String atnd=ap.attendpage();
	   sa.assertEquals(null,atnd);
	    LOG.info("Attendance page");
	}

	@When("Able to click on logout button")
	public void able_to_click_on_logout_button() {
	   ap.clicklogout();
	LOG.info("admin click logout button ");}

	@Then("action performed as button is enabled")
	public void action_performed_as_button_is_enabled() {
		boolean v=ap.logoutpage();
		
		   sa.assertEquals(true,v);
		    LOG.info("logout page is enabled");
	}
}

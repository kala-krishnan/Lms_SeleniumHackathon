 package com.lmsproject.stepdefinitions;
import java.util.logging.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import com.lmsproject.apphooks.Hooks;
import com.lmsproject.pageobjects.NavigationClass_Pageobject;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NavigationClass_StepDefinitions {
	
	private WebDriver driver;
	  
	NavigationClass_Pageobject nvp; 
  
//	private static final Logger LOG = (Logger) LogManager.getLogger(Class09_navigation_stepdef.class);
	
	@Given("Admin is in ManageClass page")
	public void admin_is_in_manage_class_page() {
		nvp.webpage();
	     nvp.getPageTitle();
	}

	@When("Admin clicks {string} student button in the navigation bar from manage class")
	public void admin_clicks_student_button_in_the_navigation_bar_from_manage_class(String string) {
		nvp.ClickOnStudentPageLink();
	}

	@Then("Admin should be able to land on student page from manage class")
	public void admin_should_be_able_to_land_on_student_page_from_manage_class() {
		 nvp.getPageTitle();
//			LOG.info("Admin is on Student Page");
	}

	@When("Admin clicks {string} program button in the navigation bar from manage class")
	public void admin_clicks_program_button_in_the_navigation_bar_from_manage_class(String string) {
		nvp.ClickOnProgramPageLink();
	}

	@Then("Admin should be able to land on program page from manage class")
	public void admin_should_be_able_to_land_on_program_page_from_manage_class() {
		nvp.getPageTitle();
//	    LOG.info("Admin is on Program Page");
	}

	@When("Admin clicks {string} batch button in the navigation bar from manage class")
	public void admin_clicks_batch_button_in_the_navigation_bar_from_manage_class(String string) {
		nvp.ClickOnBatchPageLink();
	}

	@Then("Admin should be able to land on batch page from manage class")
	public void admin_should_be_able_to_land_on_batch_page_from_manage_class() {
		nvp.getPageTitle();
//	    LOG.info("Admin is on Batch Page");
	}

	@When("Admin clicks {string} user button in the navigation bar from manage class")
	public void admin_clicks_user_button_in_the_navigation_bar_from_manage_class(String string) {
		nvp.ClickUserPageLink();
	}

	@Then("Admin should be able to land on user page from manage class")
	public void admin_should_be_able_to_land_on_user_page_from_manage_class() {
	nvp.getPageTitle();
//		   LOG.info("Admin is on User Page");
	}

	@When("Admin clicks {string} assignment button in the navigation bar from manage class")
	public void admin_clicks_assignment_button_in_the_navigation_bar_from_manage_class(String string) {
		nvp.ClickAssignmentPageLink();
	}

	@Then("Admin should be able to land on Assignment page from manage class")
	public void admin_should_be_able_to_land_on_assignment_page_from_manage_class() {
		 nvp.getPageTitle();
//		   LOG.info("Admin is on Assignment Page");
	}

	@When("Admin clicks {string} attendance button in the navigation bar from manage class")
	public void admin_clicks_attendance_button_in_the_navigation_bar_from_manage_class(String string) {
		 nvp.ClickAttendancePageLink();
	}

	@Then("Admin should be able to land on attendance page from manage class")
	public void admin_should_be_able_to_land_on_attendance_page_from_manage_class() {
		nvp.getPageTitle();
//		   LOG.info("Admin is on Attendance Page");
	}

	@When("Admin clicks {string} logout button in the navigation bar from manage class")
	public void admin_clicks_logout_button_in_the_navigation_bar_from_manage_class(String string) {
		 nvp.ClickLogoutLink();
	}

	@Then("Admin should be able to land on login page from manage class")
	public void admin_should_be_able_to_land_on_login_page_from_manage_class() {
	nvp.validSuccessHomepage();
//		  LOG.info("Admin is Logged out");
	}	
}


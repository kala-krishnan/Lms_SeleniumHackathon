package com.lmsproject.stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import org.testng.log4testng.Logger;

import com.lmsproject.pageobjects.AssignmentPagination_Pageobject;
import com.lmsproject.pageobjects.ManageAssignment_Pageobject;
import com.lmsproject.utility.CommonWebElements;
import com.lmsproject.apphooks.*;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AssignmentPagination_StepDefinitions {


	SoftAssert sa= new SoftAssert();
	ManageAssignment_Pageobject mp;
	CommonWebElements cm;
	 WebDriver driver;
	 AssignmentPagination_Pageobject app;
	private static final Logger LOG=Logger.getLogger(AssignmentPagination_StepDefinitions.class);      
	public AssignmentPagination_StepDefinitions()
	{
		driver=Hooks.getDriver();
		 mp =new ManageAssignment_Pageobject(driver);
		cm=new CommonWebElements(driver);
		app=new AssignmentPagination_Pageobject(driver);
	}	
	
	
	@Then("Admin logged on LMS portal")
	public void admin_logged_on_lms_portal() {
	   sa.assertAll("Admin logged on LMS portal");
	}

	@Given("Admin is on Dashboard page after Login")
	public void admin_is_on_dashboard_page_after_login() {
		 mp.dashboardurl();
	}

	@When("Admin clicks {string} button on the Navigation bar")
	public void admin_clicks_button_on_the_navigation_bar(String string) {
	   mp.clickassign(string);
	}


	@Then("Data table should display  page {int} when entries available")
	public void data_table_should_display_page_when_entries_available(Integer int1) {
		 app.IsFirstpageLoaded();
	}

	@Then("Entries are more than {int} in data table pagination controls enabled")
	public void entries_are_more_than_in_data_table_pagination_controls_enabled(Integer int1) {
		 app.IsSecondPageButtonEnabled();
	}

	@Then("Pagination controls disabled if entries are less than {int} in data table")
	public void pagination_controls_disabled_if_entries_are_less_than_in_data_table(Integer int1) {
		app.IsNextNavigationDisabled();
	}
	

@Then("Right arrow should be enabled in page one when of page entries are more than {int} available")
public void right_arrow_should_be_enabled_in_page_one_when_of_page_entries_are_more_than_available(Integer int1) {
	 app.IsFirstpageLoaded();
	    app.IsFirstpageButtonEnabled();
}

@Then("Left arrow should be disabled in assign page one when entries are more than {int} available")
public void left_arrow_should_be_disabled_in_assign_page_one_when_entries_are_more_than_available(Integer int1) {
	app.IsPreviousNavigationDisabled();
}

@Then("Right arrow should be enabled in assignment page two when entries are more than {int} available")
public void right_arrow_should_be_enabled_in_assignment_page_two_when_entries_are_more_than_available(Integer int1) {
	app.ClickNextNavigationButton();
}

@Then("Left arrow should be enabled in adminassign page two")
public void left_arrow_should_be_enabled_in_adminassign_page_two() {
	app.IsFirstpageButtonEnabled();
}

@Then("Data table should display  page {int} when of assignment entries available")
public void data_table_should_display_page_when_of_assignment_entries_available(Integer int1) {
	app.CheckOnAssignPageLink();
}

@Then("Entries are more than {int} in data table pagination assignment controls enabled")
public void entries_are_more_than_in_data_table_pagination_assignment_controls_enabled(Integer int1) {
	app.IsSecondPageButtonEnabled();
}

@Then("Pagination controls disabled if entries are less than {int} in data table asssignment")
public void pagination_controls_disabled_if_entries_are_less_than_in_data_table_asssignment(Integer int1) {
   app.IsNextNavigationDisabled();
}

}

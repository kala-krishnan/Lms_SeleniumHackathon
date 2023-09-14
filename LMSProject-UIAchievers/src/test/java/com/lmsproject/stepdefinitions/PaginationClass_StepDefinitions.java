package com.lmsproject.stepdefinitions;

import java.util.logging.Logger;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;

import com.lmsproject.apphooks.Hooks;
import com.lmsproject.pageobjects.PaginationClass_Pageobject;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
 

public class PaginationClass_StepDefinitions {
	
	PaginationClass_Pageobject page; 
	private WebDriver driver;
 	 
//	private static final Logger LOG=(Logger) LogManager.getLogger(Pagination_pageobj.class);
	
	public PaginationClass_StepDefinitions()
	{

		driver = Hooks.getDriver();
		 page=new PaginationClass_Pageobject(driver);
		  		
	}
	@Given("Admin is on Dashboard page after Login for manage class")
	public void admin_is_on_dashboard_page_after_login_for_manage_class() {
	page.webpage();
	    page.CheckOnDashBoardPagelink();
//	    LOG.info("Admin is on Dashboard page");
	}

	@When("Admin clicks {string} button on the Navigation bar to manage class")
	public void admin_clicks_button_on_the_navigation_bar_to_manage_class(String string) {
	     page.ClickonClassPageLink();
//	     LOG.info("Admin navigate to Class page");
	}

	@Then("Data table should display {int} page when entries available for manage class")
	public void data_table_should_display_page_when_entries_available_for_manage_class(Integer int1) {
	    page.CheckOnClassPageLink();
//	    LOG.info("Admin is in Class Page with entries");
	}
	@When("Admin clicks {string} button on the navigation bar to manage class")
	public void admin_clicks_button_on_the_navigation_bar_to_manage_class1(String string) {
		page.IsFirstpageButtonEnabled();
	}
	@Then("Right arrow should be enabled in page one when entries are more than {int} available for manage class")
	public void right_arrow_should_be_enabled_in_page_one_when_entries_are_more_than_available_for_manage_class(Integer int1) {
    page.IsFirstpageButtonEnabled();
	     
	}

	@Then("Left arrow should be disabled in page one when entries are more than {int} available for manage class")
	public void left_arrow_should_be_disabled_in_page_one_when_entries_are_more_than_available_for_manage_class(Integer int1) {
	     page.IsPreviousNavigationDisabled();
	}

	@Then("Right arrow should be enabled in page two when entries are more than {int} available for manage class")
	public void right_arrow_should_be_enabled_in_page_two_when_entries_are_more_than_available_for_manage_class(Integer int1) {
	    page.ClickNextNavigationButton();
	}

	@Then("Left arrow should be enabled in page two for manage class")
	public void left_arrow_should_be_enabled_in_page_two_for_manage_class() {
	    page.IsFirstpageButtonEnabled();
	    
	}

	@Then("Data table should display frist page  when entries available for manage class")
	public void data_table_should_display_frist_page_when_entries_available_for_manage_class() {
	    page.IsFirstpageLoaded();
	}

	@Then("Entries are more than {int} in data table pagination controls enabled")
	public void entries_are_more_than_in_data_table_pagination_controls_enabled(Integer int1) {
	     page.IsSecondPageButtonEnabled();
	}

	@Then("Pagination controls disabled if entries are less than {int} in data table")
	public void pagination_controls_disabled_if_entries_are_less_than_in_data_table(Integer int1) {
	     page.IsNextNavigationDisabled();
	}

	@Given("Admin is in add class details popup window")
	public void admin_is_in_add_class_details_popup_window() {
	    page.ClickAddNewClassButton();
	}

	@When("Admin creates {int} new class for manage class")
	public void admin_creates_new_class_for_manage_class(Integer int1) {
		page.successmsg();
//		 LOG.info("New Class is added");
	}

	@Then("total class entries above {int} next page is enabled \\( On multiples of {int} new page will be enabled)")
	public void total_class_entries_above_next_page_is_enabled_on_multiples_of_new_page_will_be_enabled(Integer int1, Integer int2) {
	     page.IsSecondPageButtonEnabled();
	}

	@When("Admin creates less than or equal to {int} new class for manage class")
	public void admin_creates_less_than_or_equal_to_new_class_for_manage_class(Integer int1) {
	    page.ClickAddNewClassButton();
	}

	@Then("total class entries  {int} or below next page is disabled")
	public void total_class_entries_or_below_next_page_is_disabled(Integer int1) {
	     page.IsNextNavigationDisabled();
//	     driver.close();
	}

}

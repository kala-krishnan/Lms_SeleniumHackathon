package com.lmsproject.stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import org.testng.log4testng.Logger;

import com.lmsproject.pageobjects.AttendancePagination_Pageobject;
import com.lmsproject.pageobjects.ManageAttendance_Pageobject;
import com.lmsproject.utility.CommonWebElements;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.lmsproject.apphooks.*;

public class AttendancePagination_StepDefinitions {
	SoftAssert sa= new SoftAssert();
	 ManageAttendance_Pageobject map;
	CommonWebElements cm;
	 WebDriver driver;
	 AttendancePagination_Pageobject atp;
	private static final Logger LOG=Logger.getLogger(AttendancePagination_StepDefinitions.class);      
	public AttendancePagination_StepDefinitions()
	{
		driver=Hooks.getDriver();
		 map =new  ManageAttendance_Pageobject(driver);
		cm=new CommonWebElements(driver);
		atp=new AttendancePagination_Pageobject(driver);
	}	
	@Then("Data table should display {int} a page when entries available")
	public void data_table_should_display_a_page_when_entries_available(Integer int1) {
	  atp.CheckOnAttendPageLink();
	}

	@Then("Right arrow should be enabled in page one when of entries are more than {int} available")
	public void right_arrow_should_be_enabled_in_page_one_when_of_entries_are_more_than_available(Integer int1) {
	atp.IsFirstpageLoaded();
	sa.assertEquals(atp.IsFirstpageButtonEnabled(),true);
	}

	@Then("Left arrow should be disabled in page one of when entries are more than {int} available")
	public void left_arrow_should_be_disabled_in_page_one_of_when_entries_are_more_than_available(Integer int1) {
	   sa.assertEquals(atp.IsPreviousNavigationDisabled(),true);
	}

	@Then("Right arrow should be enabled in page of two when entries are more than {int} available")
	public void right_arrow_should_be_enabled_in_page_of_two_when_entries_are_more_than_available(Integer int1) {
	    atp.ClickNextNavigationButton();
	}

	@Then("Left arrow should be enabled in page two in attendance")
	public void left_arrow_should_be_enabled_in_page_two_in_attendance() {
	   sa.assertEquals(atp.IsFirstpageButtonEnabled(),true);
	}

	@Then("Data table should display  page {int} in attendance when entries available")
	public void data_table_should_display_page_in_attendance_when_entries_available(Integer int1) {
	    sa.assertEquals(atp.IsFirstpageLoaded(),true);
	}

	@Then("Entries are more than {int} in attendance data table pagination controls enabled")
	public void entries_are_more_than_in_attendance_data_table_pagination_controls_enabled(Integer int1) {
	   sa.assertEquals(atp.IsSecondPageButtonEnabled(),true);
	}

	@Then("Pagination controls disabled if entries are less than {int} in attendance data table")
	public void pagination_controls_disabled_if_entries_are_less_than_in_attendance_data_table(Integer int1) {
	   sa.assertEquals(atp.IsNextNavigationDisabled(),true);
	}

	

	@Then("Admin is in Manage attendance page and licks +Add new Attendance button")
	public void admin_is_in_manage_attendance_page_and_licks_add_new_attendance_button() {
	   atp.lblAddnewAttend.click();
	}

	@Given("Admin is in add Attendance details popup window")
	public void admin_is_in_add_attendance_details_popup_window() {
	   map.adminpopup();
	}

	@When("Admin creates {int} new Attendance")
	public void admin_creates_new_attendance(Integer int1) {
	  atp.successmsg();
	}

	@Then("total Attendance entries above {int} next page is enabled \\( On multiples of {int} new page will be enabled)")
	public void total_attendance_entries_above_next_page_is_enabled_on_multiples_of_new_page_will_be_enabled(Integer int1, Integer int2) {
	   sa.assertEquals(atp.IsSecondPageButtonEnabled(),true);
	}

	@When("Admin creates less than or equal to {int} new Attendance")
	public void admin_creates_less_than_or_equal_to_new_attendance(Integer int1) {
	   atp.ClickaddNewAttendButton();
	}
	@Then("total Attendance entries  {int} or below next page is disabled")
	public void total_attendance_entries_or_below_next_page_is_disabled(Integer int1) {
	  sa.assertEquals(atp.IsNextNavigationDisabled(),true);
}
}

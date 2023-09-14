package com.lmsproject.stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import org.testng.log4testng.Logger;
import com.lmsproject.pageobjects.ManageAttendance_Pageobject;
import com.lmsproject.utility.CommonWebElements;
import com.lmsproject.utility.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.lmsproject.apphooks.*;
public class DeleteAttendance_StepDefinitions {
	SoftAssert sa= new SoftAssert();
	ManageAttendance_Pageobject ma;
	CommonWebElements commonElement;
	WebDriver driver;
	DeleteConfirmDialogBox deleteConfirmDialogBox;
	private static final Logger LOG=Logger.getLogger(DeleteAttendance_StepDefinitions.class);      
	public DeleteAttendance_StepDefinitions()
	{
		driver=Hooks.getDriver();
		 ma =new ManageAttendance_Pageobject(driver);
		commonElement=new CommonWebElements(driver);
		deleteConfirmDialogBox=new DeleteConfirmDialogBox(driver);
	}


@Given("Admin is in manage attendance page")
public void admin_is_in_manage_attendance_page() {
    LOG.info("Admin is in Attandance page");
}

@When("Admin clicks delete button in data table row level")
public void admin_clicks_delete_button_in_data_table_row_level() {
	commonElement.ClickSingleDeleteIcon(1);
}

@Then("Admin should see alert")
public void admin_should_see_alert() {
	deleteConfirmDialogBox.GetDeleteDialogBoxTitle();
}

@When("Admin clicks yes button")
public void admin_clicks_yes_button() {
	deleteConfirmDialogBox.DeleteDialogYes.isDisplayed();
}

@Then("Success message and selected attendance details are deleted from the data table")
public void success_message_and_selected_attendance_details_are_deleted_from_the_data_table() {
  commonElement.getSuccessMessage();
}

@When("Admin clicks no button")
public void admin_clicks_no_button() {
	deleteConfirmDialogBox.ClickDeleteConfirmation("no");
}


@Then("Redirected attendance page and selected attendance details are not deleted from the data table")
public void redirected_attendance_page_and_selected_attendance_details_are_not_deleted_from_the_data_table() {
    ma.urlhavingattendance();
}

@Then("Admin should see tick mark in check box")
public void admin_should_see_tick_mark_in_check_box() {
  sa.assertEquals(ma.checkboxSingle.isSelected(),true);
}

@When("Admin clicks multiple row level check box in the data table")
public void admin_clicks_multiple_row_level_check_box_in_the_data_table() {
	commonElement.ClickSingleSelectCheckbox(0);
}

@Then("Admin should see tick mark in check box  of the selected rows")
public void admin_should_see_tick_mark_in_check_box_of_the_selected_rows() {
   ma.checkboxSingleSelect.listIterator();
    
}

@Then("Success message and selected attendance detail are deleted from the data table")
public void success_message_and_selected_attendance_detail_are_deleted_from_the_data_table() {
	commonElement.getSuccessMessage();
}

@Then("Redirected to attendance page and selected attendance details are not deleted from the data table")
public void redirected_to_attendance_page_and_selected_attendance_details_are_not_deleted_from_the_data_table() {
   ma.urlhavingattendance();
}

@Then("Success message and validate particular attendance details are deleted from the data table")
public void success_message_and_validate_particular_attendance_details_are_deleted_from_the_data_table() {
	commonElement.getSuccessMessage();
	}
}

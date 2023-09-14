package com.lmsproject.stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import org.testng.log4testng.Logger;

import com.lmsproject.pageobjects.AddnewassignmentsPage_Pageobject;
import com.lmsproject.pageobjects.ManageAssignment_Pageobject;
import com.lmsproject.utility.CommonWebElements;

import com.lmsproject.apphooks.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class EditassignmentPage_StepDefinitions {
	public WebDriver driver;
	ManageAssignment_Pageobject mp;
	 CommonWebElements cm;
	 AddnewassignmentsPage_Pageobject ap;
	 SoftAssert sa=new SoftAssert();
		private static final Logger LOG=Logger.getLogger(EditassignmentPage_StepDefinitions.class);      
		public EditassignmentPage_StepDefinitions()
		{
			driver=Hooks.getDriver();
			 mp =new ManageAssignment_Pageobject(driver);
			cm=new CommonWebElements(driver);
			ap=new AddnewassignmentsPage_Pageobject(driver);
		}

@Given("Admin is on dashboard page clicks")
public void admin_is_on_dashboard_page_clicks() {
   mp.dashboardurl();
}

@When("Admin clicks on assignment button")
public void admin_clicks_on_assignment_button() {
   mp.assign.click();
}

@Then("Admin is on assignment page and clicks edit button")
public void admin_is_on_assignment_page_and_clicks_edit_button() {
  cm.ClickSingleEditButton(0);
}

@Given("Admin is in  Edit assignment detail popup window")
public void admin_is_in_edit_assignment_detail_popup_window() {
   mp.editPopUp("Edit Assignment");
}

@When("Admin enters all mandatory field values with valid data and clicks save button")
public void admin_enters_all_mandatory_field_values_with_valid_data_and_clicks_save_button() {
   ap.passingdetails("all valid data");
}

@Then("Admin should see updated assignment details is added in the data table")
public void admin_should_see_updated_assignment_details_is_added_in_the_data_table() {
  mp.displaysdata();
}



@Then("Assignment cannot be updated for the passed date")
public void assignment_cannot_be_updated_for_the_passed_date() {
   sa.assertAll("Assignment cannot be updated for the passed date");
}

@Then("Error message should appear in alert")
public void error_message_should_appear_in_alert() {
  mp.errormessage();
}

@When("Admin clicks Edit button in data table")
public void admin_clicks_edit_button_in_data_table() {
   cm.IsMultiDeleteIconEnabled();
  
}

@Then("Edit popup window appears with heading Assignment Details")
public void edit_popup_window_appears_with_heading_assignment_details() {
  mp.editPopUp("Edit Assignment");
}

@When("Admin clicks Edit button from one of the row in data table")
public void admin_clicks_edit_button_from_one_of_the_row_in_data_table() {
   cm.ClickSingleEditButton(0);
}

@Then("Edit popup window appears with same row values in the all fields")
public void edit_popup_window_appears_with_same_row_values_in_the_all_fields() {
   mp.editPopUp("edit assignment");
}

}

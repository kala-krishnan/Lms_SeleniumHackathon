 package com.lmsproject.stepdefinitions;

import org.openqa.selenium.WebDriver;

import com.lmsproject.apphooks.Hooks;
import com.lmsproject.pageobjects.EditClass_Pageobject;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class EditClass_StepDefinitions {
	EditClass_Pageobject edipage;
	WebDriver driver;
	
	public EditClass_StepDefinitions()
	{
		driver = Hooks.getDriver();
		edipage=new EditClass_Pageobject(driver);
		
	}
	@Given("Admin is in Manage Class page to validate edit class  window")
	public void admin_is_in_manage_class_page_to_validate_edit_class_window() {
		edipage.Class_Link();
	}

	@When("Admin clicks Edit button in data table in manage class window")
	public void admin_clicks_edit_button_in_data_table_in_manage_class_window() {
    edipage.ClickOnEditButton();
	}

	@Then("Edit popup window appears with Heading Class Details")
	public void edit_popup_window_appears_with_heading_class_details() {
  edipage.EditPopWindow();
	}
	@Given("Admin is in Manage Class page to validate Edit class  window1")
	public void admin_is_in_manage_class_page_to_validate_edit_class_window1() {
	     
	}
	@When("Admin clicks Edit button from one of the row in data table in manage class window")
	public void admin_clicks_edit_button_from_one_of_the_row_in_data_table_in_manage_class_window() {
		edipage.ClickOnEditButton();
	}

	@Then("Edit popup window appears with same row values in the all fields in manage class window")
	public void edit_popup_window_appears_with_same_row_values_in_the_all_fields_in_manage_class_window() {
		edipage.EditPopWindow();
	}

	@Given("Admin is in Edit class detail popup window in Edit class window")
	public void admin_is_in_edit_class_detail_popup_window_in_edit_class_window() {
	edipage.EditPopWindow();
	}

	@When("Admin enters all mandatory field values with valid data and clicks save button\\( Batch ID , No of Classes, Class Date, Staff Id)")
	public void admin_enters_all_mandatory_field_values_with_valid_data_and_clicks_save_button_batch_id_no_of_classes_class_date_staff_id(io.cucumber.datatable.DataTable dataTable) {
	 		edipage.enterBatchId(dataTable);
		edipage.enterNoofClasses(dataTable);
		edipage.enterClassDate(dataTable);
		edipage.enterClassTopic(dataTable);
	}

	@Then("Admin should see particular class details is updated in the data table")
	public void admin_should_see_particular_class_details_is_updated_in_the_data_table() {
	edipage.getSuccessMessage();
		edipage.driver.navigate().back();
	}
	@Given("Admin is in Edit class detail popup in Edit class window")
	public void admin_is_in_edit_class_detail_popup_in_edit_class_window() {
	}
	@When("Admin enters all mandatory field values with invalid data and clicks save button\\( Batch ID , No of Classes, Class Date, Staff Id) in Edit class window")
	public void admin_enters_all_mandatory_field_values_with_invalid_data_and_clicks_save_button_batch_id_no_of_classes_class_date_staff_id_in_edit_class_window(io.cucumber.datatable.DataTable dataTable) {

		edipage.ClickOnEditButton();
//	     LOG.info("The user enters only mandatory fields with invalid data " );
		edipage.enterBatchId(dataTable);
		edipage.enterNoofClasses(dataTable);
		edipage.enterClassDate(dataTable);
		
	}

	@Then("Error message should appear in alert in manage class window")
	public void error_message_should_appear_in_alert_in_manage_class_window() {
	edipage.geterrorMessage();
	}



@When("Admin enters values in all fields with valid data and clicks save button\\(Batch ID , No of Classes, Class Date, Class Topic, Staff Id, Class description, Comments, Notes, Recordings) in Edit class window")
public void admin_enters_values_in_all_fields_with_valid_data_and_clicks_save_button_batch_id_no_of_classes_class_date_class_topic_staff_id_class_description_comments_notes_recordings_in_edit_class_window(io.cucumber.datatable.DataTable dataTable) {
//	edipage.ClickOnEditButton();
// LOG.info("The user enters values for all fields with valid data " );
edipage.enterBatchId(dataTable);
edipage.enterNoofClasses(dataTable);
edipage.enterClassDate(dataTable);
edipage.enterClassTopic(dataTable);
edipage.enterClassTopic(dataTable);
edipage.enterClassDescription(dataTable);
edipage.enterComments(dataTable);
edipage.enterNotes(dataTable);
edipage.enterRecordings(dataTable);
edipage.successmsg();
	     
	}
@Then("Admin should see particular class details is updated in the data table1")
public void admin_should_see_particular_class_details_is_updated_in_the_data_table1() {
}


@When("Admin enters with invalid data in optional fields and clicks save button\\( Batch ID , No of Classes, Class Date, Staff Id) in Edit class window")
public void admin_enters_with_invalid_data_in_optional_fields_and_clicks_save_button_batch_id_no_of_classes_class_date_staff_id_in_edit_class_window(io.cucumber.datatable.DataTable dataTable) {		edipage.ClickOnEditButton();
//	     LOG.info("The user enters only in optional fields with invalid data " );
		
		edipage.enterClassDescription(dataTable);
		edipage.enterComments(dataTable);
		edipage.enterNotes(dataTable);
		edipage.enterRecordings(dataTable);
	}
@Given("Admin is in Edit class detail popup in manage class window")
public void admin_is_in_edit_class_detail_popup_in_manage_class_window() {
     
}
@When("Admin enters data missing value in Batch ID and clicks save button\\(No of Classes, Class Date, Staff Id) in manage class window")
public void admin_enters_data_missing_value_in_batch_id_and_clicks_save_button_no_of_classes_class_date_staff_id_in_manage_class_window(io.cucumber.datatable.DataTable dataTable) {
		edipage.getEmptyRequiredBatchId();
		 
	}

@Then("BatchId is missing in manage class window")
public void batch_id_is_missing_in_manage_class_window() {
	 
		edipage.getEmptyfieldErrormsgBatchId();
	}

@When("Admin enters data missing value in No of class and clicks save button\\(Batch ID , Class Date, Staff Id) in Edit class window")
public void admin_enters_data_missing_value_in_no_of_class_and_clicks_save_button_batch_id_class_date_staff_id_in_edit_class_window(io.cucumber.datatable.DataTable dataTable) {		edipage.getEmptyRequiredNoofClasses();
		 
	}

@Then("Noofclasses is missing in manage class window")
public void noofclasses_is_missing_in_manage_class_window() {
		 
		edipage.getEmptyfieldErrormsgClassDate();
	}

@When("Admin enters data missing value in class date and clicks save button\\(Batch ID , No of Classes, Staff Id) in manage class window")
public void admin_enters_data_missing_value_in_class_date_and_clicks_save_button_batch_id_no_of_classes_staff_id_in_manage_class_window(io.cucumber.datatable.DataTable dataTable) {		edipage.getEmptyRequiredClassDate();
		edipage.getEmptyfieldErrormsgClassDate();
	}

@Then("classdate is missing in manage class window")
public void classdate_is_missing_in_manage_class_window() {
		edipage.getEmptyfieldErrormsgClassDate();
	}

@When("Admin enters data missing value in staff id and clicks save button \\(Batch ID , No of Classes, Class Date) in manage class window")
public void admin_enters_data_missing_value_in_staff_id_and_clicks_save_button_batch_id_no_of_classes_class_date_in_manage_class_window(io.cucumber.datatable.DataTable dataTable) {		edipage.getEmptyRequiredStaffId();
	}

@Then("staffid is missing in manage class window")
public void staffid_is_missing_in_manage_class_window() {
		edipage.getEmptyRequiredStaffId();
		edipage.getEmptyfieldErrormsgStaffId();
	}

@When("Admin enters passed date in the class date field and clicks save button\\( Batch ID , No of Classes, Class Date, Staff Id) in manage class window")
public void admin_enters_passed_date_in_the_class_date_field_and_clicks_save_button_batch_id_no_of_classes_class_date_staff_id_in_manage_class_window(io.cucumber.datatable.DataTable dataTable) {
	edipage.passeddate();
	}

@Then("class cannot be updated for the passed date in manage class window")
public void class_cannot_be_updated_for_the_passed_date_in_manage_class_window() {
	    edipage.getErrorMsg();
	}

@When("Admin clicks {string} button without entering values in the fields in Edit class window")
public void admin_clicks_button_without_entering_values_in_the_fields_in_edit_class_window(String string) {
 	    
		edipage.editClassConfirmation(string);
	}

@Then("Admin should land on Manage Class page to validate edit class")
public void admin_should_land_on_manage_class_page_to_validate_edit_class() {
		edipage.CheckOnManageClassPage();
	}

@When("Admin clicks {string} button entering values in the fields in Edit class window")
public void admin_clicks_button_entering_values_in_the_fields_in_edit_class_window(String string) {
		edipage.ClickOnEditButton(); 
		 
		edipage.editClassConfirmation(string);
	}

	@Then("Admin should land on Manage Class Page and validate particular class details are not changed  in the data table")
	public void admin_should_land_on_manage_class_page_and_validate_particular_class_details_are_not_changed_in_the_data_table() {
		edipage.CheckOnManageClassPage();
	}
 
}

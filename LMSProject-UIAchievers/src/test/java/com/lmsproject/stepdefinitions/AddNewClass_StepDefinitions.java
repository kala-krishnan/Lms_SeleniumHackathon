package com.lmsproject.stepdefinitions;

import org.openqa.selenium.WebDriver;
import com.lmsproject.apphooks.Hooks;
import com.lmsproject.pageobjects.AddNewClass_Pageobject;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class AddNewClass_StepDefinitions {

	 AddNewClass_Pageobject acp; 
	private WebDriver driver;
	 
//	private static final Logger LOG=(Logger) LogManager.getLogger(AddNewClass_pageobj.class);
	
	public AddNewClass_StepDefinitions()
	{

		driver = Hooks.getDriver();
		 acp=new  AddNewClass_Pageobject(driver);  
		 driver.close();		
	}
	
	@Given("Admin is in class detail popup window for adding new class")
	public void admin_is_in_class_detail_popup_window_for_adding_new_class() {
	acp.webpage();
		acp.ClickOnClass();
//		acp.ClickOnManageClassLink();
		
//		 LOG.info("The user is in manage Class Page");
	}

	@When("Admin clicks Batch ID dropdown in add new class page")
	public void admin_clicks_batch_id_dropdown_in_add_new_class_page() {
		acp.ClickAddNewClassButton();
	}

	@Then("Batch ID in the drop down should match with Batch ID manage class page table")
	public void batch_id_in_the_drop_down_should_match_with_batch_id_manage_class_page_table() {
		acp.ClickdropDownBatchId();
	}
	@When("Admin enters all mandatory field values with valid data and clicks save button {string} , {string}, {string},{string} in add new class page")
	public void admin_enters_all_mandatory_field_values_with_valid_data_and_clicks_save_button_in_add_new_class_page(String string, String string2, String string3, String string4, io.cucumber.datatable.DataTable dataTable) {

//	    acp.ClickAddNewClassButton();
//	     LOG.info("The user enters only mandatory fields " );
		acp.enterBatchId(dataTable);
		 acp.enterNoofClasses(dataTable);
		 acp.enterClassDate(dataTable);
		 acp.enterClassTopic(dataTable);
		 
	}

	@Then("Admin should see new class detail is added in the data table")
	public void admin_should_see_new_class_detail_is_added_in_the_data_table() {
//	    acp.ClickOnManageClassLink();
		acp.getSuccessMessage();
	}

	@When("Admin enters all mandatory field values with invalid data and clicks save button {string} , {string}, {string},{string} in add new class page")
	public void admin_enters_all_mandatory_field_values_with_invalid_data_and_clicks_save_button_in_add_new_class_page(String string, String string2, String string3, String string4, io.cucumber.datatable.DataTable dataTable) {
	 
//		acp.ClickAddNewClassButton();
//	     LOG.info("The user enters only mandatory fields with invalid data " );
			acp.enterBatchId(dataTable);
			 acp.enterNoofClasses(dataTable);
		 acp.enterClassDate(dataTable);
		 acp.enterClassTopic(dataTable);
	}

	@Then("Error message should appear for adding new class")
	public void error_message_should_appear_for_adding_new_class() {
	     acp.getErrorMsg();
	}

	@When("Admin enters values in all fields with valid data and clicks save button  {string} , {string}, {string},{string}, {string}, {string}, {string}, {string} from given {string} and <rownumber> in add new class page")
	public void admin_enters_values_in_all_fields_with_valid_data_and_clicks_save_button_from_given_and_rownumber_in_add_new_class_page(String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9) {
	         
////		 	LOG.info("User enter values to add new class ");
		
		 try {
			acp.AddClassWithValidValues(string, string2, string3, string4, string5, string6, string7, string9);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	} 
	
	@Then("Admin get success message for adding new class")
	public void admin_get_success_message_for_adding_new_class() {
		acp.successmsg();
//	 LOG.info("New Class is added");
	}
	@When("Admin enters with invalid data in optional fields and clicks save button  {string}, {string}, {string}, {string} in add new class page")
	public void admin_enters_with_invalid_data_in_optional_fields_and_clicks_save_button_in_add_new_class_page(String string, String string2, String string3, String string4, io.cucumber.datatable.DataTable dataTable) {

	  	acp.ClickAddNewClassButton();
//	     LOG.info("The user enters only in optional fields with invalid data " );
		
		acp.enterClassDescription(dataTable);
		 acp.enterComments(dataTable);
	 acp.enterNotes(dataTable);
	 acp.enterRecordings(dataTable);
	}
	@Then("Error message should appear as {string} for adding new class")
	public void error_message_should_appear_as_for_adding_new_class(String string) {
	 acp.getErrorMsg();
		
	}
	@When("Admin enters data missing value in Batch ID and clicks save button {string}, {string},{string} in add new class page")
	public void admin_enters_data_missing_value_in_batch_id_and_clicks_save_button_in_add_new_class_page(String string, String string2, String string3, io.cucumber.datatable.DataTable dataTable) {
	     acp.getEmptyRequiredBatchId();
	     acp.getEmptyfieldErrormsgBatchId();
	}

	@When("Admin enters data missing value in No of classes and clicks save button {string}, {string},{string} in add new class page")
	public void admin_enters_data_missing_value_in_no_of_classes_and_clicks_save_button_in_add_new_class_page(String string, String string2, String string3, io.cucumber.datatable.DataTable dataTable) {

	acp.getEmptyRequiredNoofClasses();
	      acp.getEmptyfieldErrormsgNoofClasses();
	}

	@When("Admin enters data missing value in class date and clicks save button {string},{string}, {string} in add new class page")
	public void admin_enters_data_missing_value_in_class_date_and_clicks_save_button_in_add_new_class_page(String string, String string2, String string3, io.cucumber.datatable.DataTable dataTable) {

		acp.getEmptyRequiredClassDate();
		acp.getEmptyfieldErrormsgClassDate();
	     
	}

	@When("Admin enters data missing value in Staff Id and clicks save button {string},{string},{string} in add new class page")
	public void admin_enters_data_missing_value_in_staff_id_and_clicks_save_button_in_add_new_class_page(String string, String string2, String string3, io.cucumber.datatable.DataTable dataTable) {
	acp.getEmptyRequiredStaffId();
		acp.getEmptyfieldErrormsgStaffId();
	     
	}

	@When("Admin enters passed date in the class date field and clicks save button {string} , {string}, {string},{string} in add new class page")
	public void admin_enters_passed_date_in_the_class_date_field_and_clicks_save_button_in_add_new_class_page(String string, String string2, String string3, String string4, io.cucumber.datatable.DataTable dataTable) {
	 
		acp.passeddate();
	}

	@Then("class cannot be created for the passed date for adding new class")
	public void class_cannot_be_created_for_the_passed_date_for_adding_new_class() {
	 		acp.getEmptyfieldErrormsgClassDate();
	}

	@When("Admin clicks Class date from date picker in add new class page")
	public void admin_clicks_class_date_from_date_picker_in_add_new_class_page() {
	    acp.ClickOnDatePicker();
	}

	@Then("Selected date should be their in Class date text box with mm\\/dd\\/yyyy format")
	public void selected_date_should_be_their_in_class_date_text_box_with_mm_dd_yyyy_format() {
	     acp.date();
	}

	@When("Admin clicks Right arrow in the date picker near month in add new class page")
	public void admin_clicks_right_arrow_in_the_date_picker_near_month_in_add_new_class_page() {
	     acp.ClickRightClickOnDatePicker();
	}
	@Then("Next month Calender should visible for adding new class")
	public void next_month_calender_should_visible_for_adding_new_class() {
	     acp.futuredate();
	}

	@When("Admin clicks Left arrow in the date picker near month in add new class page")
	public void admin_clicks_left_arrow_in_the_date_picker_near_month_in_add_new_class_page() {
	     acp.ClickPreviousClickonDatePicker();
	}

	@Then("Previous month calender should visible for adding new class")
	public void previous_month_calender_should_visible_for_adding_new_class() {
	     acp.CheckOnDateContainer();
	}

	@When("Admin clicks Date picker button in add new class page")
	public void admin_clicks_date_picker_button_in_add_new_class_page() {
    acp.date();
	}

	@Then("Admin should see current date is highlighted in the date picker for adding new class")
	public void admin_should_see_current_date_is_highlighted_in_the_date_picker_for_adding_new_class() {
	     acp.color();
	}

	@When("Admin clicks Date picker button and selects future date in add new class page")
	public void admin_clicks_date_picker_button_and_selects_future_date_in_add_new_class_page() {
		 acp.futuredate();
	}

	@Then("Admin should see selected date is highlighted in the date picker for adding new class")
	public void admin_should_see_selected_date_is_highlighted_in_the_date_picker_for_adding_new_class() {
	     acp.colorforfuture();
	}

	@When("Admin clicks cancel button without entering values in the fields {string} in add new class page")
	public void admin_clicks_cancel_button_without_entering_values_in_the_fields_in_add_new_class_page(String string) {
	    acp.ClickAddConfirmation(string);
	}
	

	@Then("Admin should land on Manage Class Page for adding new class")
	public void admin_should_land_on_manage_class_page_for_adding_new_class() {
	     acp.CheckOnManageClassPage();
	}

	@When("Admin clicks cancel button entering values in the fields {string} in add new class page")
	public void admin_clicks_cancel_button_entering_values_in_the_fields_in_add_new_class_page(String string) {
		acp.ClickAddConfirmation(string);
	}

	@Then("Admin should land on Manage Class Page and validate new Class is not created in the data table")
	public void admin_should_land_on_manage_class_page_and_validate_new_class_is_not_created_in_the_data_table() {
		acp.CheckOnManageClassPage();
	}
}	


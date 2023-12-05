package com.lmsproject.stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import org.testng.log4testng.Logger;

import com.lmsproject.pageobjects.AddnewassignmentsPage_Pageobject;
import com.lmsproject.pageobjects.ManageAssignment_Pageobject;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.log4testng.Logger;
import com.lmsproject.apphooks.*;

import io.cucumber.java.en.*;

import org.testng.asserts.SoftAssert;

public class Addnewassignment_StepDefinitions {
		 WebDriver driver;
		 ManageAssignment_Pageobject mp;
		 AddnewassignmentsPage_Pageobject ap;
		 SoftAssert sa=new SoftAssert();
			private static final Logger LOG=Logger.getLogger(Addnewassignment_StepDefinitions.class);      
			public Addnewassignment_StepDefinitions()
			{
				driver=Hooks.getDriver();
				 mp =new ManageAssignment_Pageobject(driver);	
				ap=new AddnewassignmentsPage_Pageobject(driver);
			}
			@Given("Admin is on dashboardpage")
			public void admin_is_on_dashboardpage() {
			    mp.dashboardurl();
			}

			@When("Admin clicks assignment on navigation button")
			public void admin_clicks_assignment_on_navigation_button() {
			    mp.assign.click();
			}
		
			@Given("Admin is in  assignment details popup window")
			public void admin_is_in_assignment_details_popup_window() {
			  mp.assignmentPopUp("Assignment details");
			}

		@When("Admin enters all mandatory field values with {string} and clicks save button")//valid mandatory details
		public void admin_enters_all_mandatory_field_values_with_and_clicks_save_button(String string) {
		   ap.passingdetails(string);
		    
		}
		@When("Admin enters values in all fields with {string} and clicks save button")//passign all details valid
		public void admin_enters_values_in_all_fields_with_and_clicks_save_button(String string) {
		   ap.passingdetails(string);
		}

		@Then("Admin should see new assignment details is added in the data table")
		public void admin_should_see_new_assignment_details_is_added_in_the_data_table() {
		   boolean val=mp.displaysdata();
		   sa.assertEquals(true,val);
		}

		@Then("{string} should appear in alert")
		public void should_appear_in_alert(String string) {
		    sa.assertEquals(string,mp.errormessage());
		}
	//invsalid
		@When("The admin enters all mandatory fields {string},{string},{string},{string},{string} and clicks save")
		public void the_admin_enters_all_mandatory_fields_and_clicks_save(String string, String string2, String string3, String string4, String string5) {
			 ap.invaliddetailsMandatory(string, string2, string3, string4, string5);    	
		}

		@When("Admin enters with invalid data {string},{string},{string},{string},{string} in optional fields and clicks save button")
		public void admin_enters_with_invalid_data_in_optional_fields_and_clicks_save_button(String string, String string2, String string3, String string4, String string5) {
		    ap.invalidoptional(string, string2, string3, string4, string5);
		}
		@When("Admin enters {string} missing value in program name and clicks save button")
		public void admin_enters_missing_value_in_program_name_and_clicks_save_button(String string) {
		   string="program name";
			ap.passingdetails(string);
		   
		}

		@Then("Program Name is missing")
		public void program_name_is_missing() {
		   sa.assertAll("Program Name is missing");
		}

		@When("Admin enters data {string} in Batch number and clicks save button")
		public void admin_enters_data_in_batch_number_and_clicks_save_button(String string) {
		   string="batch number";
		   ap.passingdetails(string);
		}

		@Then("Batch number is missing")
		public void batch_number_is_missing() {
			sa.assertAll("Batch number is missing");
		}

		@When("Admin enters data missing {string} in Assignment name and clicks save button")
		public void admin_enters_data_missing_in_assignment_name_and_clicks_save_button(String string) {
		   string="Assignment name";
		   ap.passingdetails(string);
		}

		@Then("Assignment name is missing")
		public void assignment_name_is_missing() {
			sa.assertAll("Assignment name is missing");
		}

		@When("Admin enters data {string} value in Assignment due date and clicks save button")
		public void admin_enters_data_value_in_assignment_due_date_and_clicks_save_button(String string) {
		   string="Assignment due date";
		   ap.passingdetails(string);
		   
		}

		@Then("Assignment due date is missing")
		public void assignment_due_date_is_missing() {
			sa.assertAll("Assignment name is missing");
		}

		@When("Admin enters {string} value in grade by  and clicks save button")
		public void admin_enters_value_in_grade_by_and_clicks_save_button(String string) {
		   string="grade by";
		   ap.passingdetails(string);
		}

		@Then("Grade by is missing")
		public void grade_by_is_missing() {
			sa.assertAll("Grade by is missing");
		}

		@When("Admin enters passed date in the due date field and clicks save button")
		public void admin_enters_passed_date_in_the_due_date_field_and_clicks_save_button() {
		    mp.passeddate();
		}

		@Then("Assignment cannot be created for the passed date")
		public void assignment_cannot_be_created_for_the_passed_date() {
		    String mesg=mp.errormessage();
		    sa.assertEquals("cannot be created",mesg);
		  
		}

		@When("Admin clicks date from date picker")
		public void admin_clicks_date_from_date_picker() {
		    mp.calendaricon();//selectdate
		}

		@Then("selected date should be their in class date text box")
		public void selected_date_should_be_their_in_class_date_text_box() {
		    String text=mp.date();
		    sa.assertFalse(text.isEmpty());
		}

		@Then("selected date should be in  mm\\/dd\\/yyyy format")
		public void selected_date_should_be_in_mm_dd_yyyy_format() {
		    mp.date();
		}

		@When("Admin clicks right arrow in the date picker near month")
		public void admin_clicks_right_arrow_in_the_date_picker_near_month() {
		    mp.rightclick.click();
		}

		@Then("Next month calender should visible")
		public void next_month_calender_should_visible() {
		    mp.monthname();
		}

		@When("Admin clicks left arrow in the date picker near month")
		public void admin_clicks_left_arrow_in_the_date_picker_near_month() {
		    mp.previousLink.click();
		}

		@Then("previous month calender should visible")
		public void previous_month_calender_should_visible() {
		    mp.monthname();
		}

		@When("Admin clicks date picker button")
		public void admin_clicks_date_picker_button() {
		    mp.calendaricon();
		}

		@Then("Admin should see current date is highled in the date picker")
		public void admin_should_see_current_date_is_highled_in_the_date_picker() {
		   String color= mp.color();
		   sa.assertEquals("actual_hex should equal to: ", "#808080",color);
		}

		@When("Admin clicks date picker button and selects future date")
		public void admin_clicks_date_picker_button_and_selects_future_date() {
		    mp.futuredate();
		}

		@Then("Admin should see selected date is highled in the date picker")
		public void admin_should_see_selected_date_is_highled_in_the_date_picker() {
			String color= mp.colorforfuture();
			   sa.assertEquals("actual_hex should equal to: ", "#808080",color);
		}

		@When("Admin clicks Cancel button without entering values in the fields")
		public void admin_clicks_cancel_button_without_entering_values_in_the_fields() {
		   mp.totalfieldsempty();
		}

		@Then("Admin should land on manage assignment page")
		public void admin_should_land_on_manage_assignment_page() {
		    boolean val=mp.urlhaving();
		    sa.assertEquals(true,val);
		}

		@When("Admin clicks Cancel button entering values in the fields")
		public void admin_clicks_cancel_button_entering_values_in_the_fields() {
		   //excel method call for writing data
			mp.cancelbutton();
		}

		@Then("Admin should land on manage assignment Page and validate new assignment is not created in the data table")
		public void admin_should_land_on_manage_assignment_page_and_validate_new_assignment_is_not_created_in_the_data_table() {
			 boolean val=mp.urlhaving();
			    sa.assertEquals(true,val);
			    mp.tabledata();
		}
	}



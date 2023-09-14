package com.lmsproject.stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import org.testng.log4testng.Logger;

import com.lmsproject.pageobjects.ManageAttendance_Pageobject;
import com.lmsproject.utility.CommonWebElements;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import com.lmsproject.apphooks.*;
public class ManageAttendancePage_StepDefinitions {
	SoftAssert sa= new SoftAssert();
	ManageAttendance_Pageobject mpa;
	CommonWebElements cm;
	 WebDriver driver;
	private static final Logger LOG=Logger.getLogger(ManageAttendancePage_StepDefinitions .class);      
	public ManageAttendancePage_StepDefinitions ()
	{
		driver=Hooks.getDriver();
		 mpa =new ManageAttendance_Pageobject(driver);
		cm=new CommonWebElements(driver);
	}
	
	
	
	
	@When("Admin clicks {string} on the navigation bar")
	public void admin_clicks_on_the_navigation_bar(String string) {
	   mpa.attendance.click();
	}

	@Then("Admin should see the Manage attendance in header")
	public void admin_should_see_the_manage_attendance_in_header() {
	  String text=mpa.lblPageHeaderTitle.getText();
	  sa.assertEquals("Attendance",text.contains("Attendance"));
	}

	@Then("Manage attendance header should be in left side of the page")
	public void manage_attendance_header_should_be_in_left_side_of_the_page() {
	   mpa.leftsideof_the_page();
	}

	@Then("Admin should see search bar on the attendance page")
	public void admin_should_see_search_bar_on_the_attendance_page() {
	   boolean search=mpa.searchbarfield(); sa.assertEquals(true,search);
	}

	@Then("Admin should see +Add New Attendance button on the attendance page")
	public void admin_should_see_add_new_attendance_button_on_the_attendance_page() {
	   boolean addnew=mpa.addnewbutton();
	   sa.assertEquals(true, addnew);
	}

	@Then("Admin should see data table on the Manage Attendance Page With following column headers.")
	public void admin_should_see_data_table_on_the_manage_attendance_page_with_following_column_headers() {
	    
	    mpa.columnheadersattend("Attendance");
	}
	
	@Then("Admin cant see delete  Icon in data table")
	public void admin_cant_see_delete_icon_in_data_table() {
	 mpa.tabledataattend();
	}

	@Then("Admin should see check box in the all rows  of data table")
	public void admin_should_see_check_box_in_the_all_rows_of_data_table() {
	 cm.ClickMutiSelectCheckBox();
	}

	@Then("Above the footer Admin should see the text as {string} below the table")
	public void above_the_footer_admin_should_see_the_text_as_below_the_table(String string) {
	   cm.getFooterTotalRecord();
	   cm.ValidateFooterText(mpa.lblPaginationEntries,string);
	}

	@Then("Admin should see the text with total number classes in the data table. \\( {string})")
	public void admin_should_see_the_text_with_total_number_classes_in_the_data_table(String string) {
	    cm.GetPaginationShowEntries();
	}
	@Then("click attendance navigation button")
	public void click_attendance_navigation_button() {
	 mpa.attendance.click();   
	}

	@Then("Admin is in manage attendance page.")
	public void admin_is_in_manage_attendance_page() {
	 String textmesg= mpa.lblPageHeaderTitle.getText();   
	}

	@Then("Admin should see the text with total number classes in the data table.")
	public void admin_should_see_the_text_with_total_number_classes_in_the_data_table() {
		cm.GetPaginationShowEntries();
	}

	@Given("Admin now on manage attendance page")
	public void admin_now_on_manage_attendance_page() {
	  LOG.info("Admin is now on attendance page");
	}

	@When("Admin clicks + a new attendance button")
	public void admin_clicks_a_new_attendance_button() {
	  mpa.addnewbutton();
	}

	@Then("Admin should see correct spellings in the label")
	public void admin_should_see_correct_spellings_in_the_label() {
	   mpa.correctspellforall();
	}

	@Then("four dropdown should be present")
	public void four_dropdown_should_be_present() {
	  mpa.dropdown();
	}

	@Then("Admin should see  close button on the attendance details popup window")
	public void admin_should_see_close_button_on_the_attendance_details_popup_window() {
	   boolean val=mpa.popupclose();
	   sa.assertEquals(true, val);
	}

	@Then("Close button should on the top right corner")
	public void close_button_should_on_the_top_right_corner() {
	 mpa.popupclose();  
	}

	@Then("First dropdown box {string} text  should be present")
	public void first_dropdown_box_text_should_be_present(String string) {
	    int j=mpa.dropdownattend(string);
	    sa.assertEquals(1,j);
	}

	@Then("Second dropdown box {string} text  should be present")
	public void second_dropdown_box_text_should_be_present(String string) {
		 int j=mpa.dropdownattend(string);
		    sa.assertEquals(2,j);
	}

	@Then("Third dropdown box {string} text  should be present")
	public void third_dropdown_box_text_should_be_present(String string) {
		 int j=mpa.dropdownattend(string);
		    sa.assertEquals(3,j);
	}

	@Then("Fourth dropdown box {string} text  should be present")
	public void fourth_dropdown_box_text_should_be_present(String string) {
		 int j=mpa.dropdownattend(string);
		    sa.assertEquals(4,j);}

	@Then("Admin  should text in gray color")
	public void admin_should_text_in_gray_color() {
	  String color=mpa.verifyColorforattend();
	  sa.assertEquals("gray",color);
	}

	@Then("Admin should see  save button in the class detail popup window")
	public void admin_should_see_save_button_in_the_class_detail_popup_window() {
	   boolean save=mpa.saveinpopup();
	   sa.assertAll();
	}

	@Then("Admin should see  cancel button in the class detail popup window")
	public void admin_should_see_cancel_button_in_the_class_detail_popup_window() {
	   boolean valure=mpa.popupcancel();
	   sa.assertAll();
	}

	
	@Then("Order of the label should be {string}")
	public void order_of_the_label_should_be(String string) {
		 mpa.order(string);
	}

	@Given("Admin is in  attendance details popup window")
	public void admin_is_in_attendance_details_popup_window() {
	    boolean val=mpa.adminpopup();
	    sa.assertAll();
	}

	@When("Admin clicks  program name dropdown")
	public void admin_clicks_program_name_dropdown() {
	    mpa.Adminclicks("Programname");
	}

	@Then("Program Name in the drop down should match with  program name in  manage program page table")
	public void program_name_in_the_drop_down_should_match_with_program_name_in_manage_program_page_table() {
	 boolean val=mpa.comparestring();
	 sa.assertEquals(true, val);
	}

	@When("Admin clicks class name dropdown")
	public void admin_clicks_class_name_dropdown() {
		mpa.Adminclicks("classname");
	}

	@Then("Class Name in the drop down should match with  class name in  manage class page table")
	public void class_name_in_the_drop_down_should_match_with_class_name_in_manage_class_page_table() {
		boolean val=mpa.comparestringforclass();
		 sa.assertEquals(true, val);
	}

	@When("Admin clicks attendance dropdown")
	public void admin_clicks_attendance_dropdown() {
	    mpa.Adminclicks("attendance");
	}

	@Then("Attendance field should have keywords such as - present, absent, late, excused")
	public void attendance_field_should_have_keywords_such_as_present_absent_late_excused() {
	    mpa.fieldforall();
	    mpa.fieldforall1();
	    mpa.fieldforall2();
	    mpa.fieldforall3();
	}

	@Then("Admin should see correct spellings in dropdown text")
	public void admin_should_see_correct_spellings_in_dropdown_text() {
	    mpa.dropdownattendfor_spell();
	}

}

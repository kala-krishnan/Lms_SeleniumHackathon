package com.lmsproject.stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import org.testng.log4testng.Logger;

import com.lmsproject.pageobjects.AddnewEditAttendancePage_Pageobject;
import com.lmsproject.pageobjects.ManageAttendance_Pageobject;
import com.lmsproject.utility.CommonWebElements;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.lmsproject.apphooks.*;

public class AddnewEditAttendance_StepDefinitions {
	SoftAssert sa= new SoftAssert();
	ManageAttendance_Pageobject mpa;
	AddnewEditAttendancePage_Pageobject attp;
	CommonWebElements cm;
	 WebDriver driver;
	private static final Logger LOG=Logger.getLogger(AddnewEditAttendance_StepDefinitions.class);      
	public AddnewEditAttendance_StepDefinitions()
	{
		driver=Hooks.getDriver();
		 mpa =new ManageAttendance_Pageobject(driver);
		cm=new CommonWebElements(driver);
		attp=new AddnewEditAttendancePage_Pageobject(driver);
	}
	
	@Given("Admin is in  attendance details popup window page")
	public void admin_is_in_attendance_details_popup_window_page() {
	    mpa.adminpopup();
	}

@When("Admin fills {string} and click save")
public void admin_fills_and_click_save(String string) {
   attp.filldetailsAttendance(string);
}

@Then("Admin should see success message in popup window and sees new attendance details in manage attendance details DB")
public void admin_should_see_success_message_in_popup_window_and_sees_new_attendance_details_in_manage_attendance_details_db() {
    cm.getSuccessMessage();
}

@When("Admin fills values {string} name and click save")
public void admin_fills_values_name_and_click_save(String string) {
    attp.filldetailsAttendance(string);
}

@Then("Program name is missing")
public void program_name_is_missing() {
  sa.assertAll("Program name is missing");
}

@Then("class name is missing")
public void class_name_is_missing() {
	 sa.assertAll("class name is missing");
}

@Then("student name is missing")
public void student_name_is_missing() {
	 sa.assertAll("student name is missing");
}

@When("Admin fills values {string} and click save")
public void admin_fills_values_and_click_save(String string) {
   attp.filldetailsAttendance(string);
}

@Then("Attendance is missing")
public void attendance_is_missing() {
	 sa.assertAll("Attendance is missing");
}

@When("Admin fills values missing {string}  and click save")
public void admin_fills_values_missing_and_click_save(String string) {
  attp.filldetailsAttendance(string);
}

@Then("Attendance date is missing")
public void attendance_date_is_missing() {
	 sa.assertAll("Attendance date is missing");
}

@When("Admin fills values with future date  and click save")
public void admin_fills_values_with_future_date_and_click_save() {
   attp.futuredate();
}

@Then("Invalidate attendance date")
public void invalidate_attendance_date() {
    sa.assertAll("Invalidate attendance date");
}


}

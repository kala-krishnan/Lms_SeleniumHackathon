package com.lmsproject.stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import org.testng.log4testng.Logger;

import com.lmsproject.pageobjects.AssignmentPagination_Pageobject;
import com.lmsproject.pageobjects.ManageAssignment_Pageobject;
import com.lmsproject.utility.CommonWebElements;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import com.lmsproject.apphooks.*;
public class AssignmentPagination01_StepDefinitions {
	SoftAssert sa= new SoftAssert();
	ManageAssignment_Pageobject mp;
	CommonWebElements cm;
	 WebDriver driver;
	 AssignmentPagination_Pageobject app;
	private static final Logger LOG=Logger.getLogger(AssignmentPagination01_StepDefinitions.class);      
	public AssignmentPagination01_StepDefinitions()
	{
		driver=Hooks.getDriver();
		 mp =new ManageAssignment_Pageobject(driver);
		cm=new CommonWebElements(driver);
		app=new  AssignmentPagination_Pageobject(driver);
	}	

@Given("Admin clicks assignment button")
public void admin_clicks_assignment_button() {
   mp.assign.click();
}

@When("Admin is in Manage assignment page")
public void admin_is_in_manage_assignment_page() {
    LOG.info("Admin is in Manage assignment page");
}

@Then("Admin Clicks +Add new assignment button")
public void admin_clicks_add_new_assignment_button() {
    app.ClickaddNewAssignButton();
}

@Given("Admin is in add Assignment details popup window")
public void admin_is_in_add_assignment_details_popup_window() {
   LOG.info("Admin is in add Assignment details popup window");
}

@When("Admin creates {int} new Assignment")
public void admin_creates_new_assignment(Integer int1) {
app.successmsg();
}
@Then("Data table should display {int} page  of assignment when entries available")
public void data_table_should_display_page_of_assignment_when_entries_available(Integer int1) {
   app.CheckOnAssignPageLink();
}

@Then("total Assignment entries above {int} next page is enabled \\( On multiples of {int} new page will be enabled)")
public void total_assignment_entries_above_next_page_is_enabled_on_multiples_of_new_page_will_be_enabled(Integer int1, Integer int2) {
	sa.assertEquals(app.IsSecondPageButtonEnabled(),true);
}

@When("Admin creates less than or equal to {int} new Assignment")
public void admin_creates_less_than_or_equal_to_new_assignment(Integer int1) {
   app.ClickaddNewAssignButton();
}

@Then("total Assignment entries  {int} or below next page is disabled")
public void total_assignment_entries_or_below_next_page_is_disabled(Integer int1) {
    sa.assertEquals(app.IsNextNavigationDisabled(),true);
}

}

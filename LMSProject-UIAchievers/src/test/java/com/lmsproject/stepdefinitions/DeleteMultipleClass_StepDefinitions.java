package com.lmsproject.stepdefinitions;

import java.util.logging.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import com.lmsproject.apphooks.Hooks;
import com.lmsproject.pageobjects.DeleteMultipleClass_Pageobject;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
 
public class DeleteMultipleClass_StepDefinitions {
	
	
	DeleteMultipleClass_Pageobject delpage;
	private WebDriver driver;
	 
//	private static final Logger LOG=(Logger) LogManager.getLogger(AddNewClass_pageobj.class);
	
	public DeleteMultipleClass_StepDefinitions()
	{

		driver = Hooks.getDriver();
		delpage=new DeleteMultipleClass_Pageobject(driver);  
		driver.close();		
	}
	
	@Given("Admin is in Manage Class page")
	public void admin_is_in_manage_class_page() {
        delpage.webpage();
	    delpage.ClickOnClass();
	}
	@When("Admin clicks single <{int}> row level check box in the data table in delete class window")
	public void admin_clicks_single_row_level_check_box_in_the_data_table_in_delete_class_window(Integer int1) {
   delpage.CheckSingleDeleteIcon(int1);
	}
	@Then("Admin should see delete icon below the header is enabled")
	public void admin_should_see_delete_icon_below_the_header_is_enabled() {
	     
	    delpage.IsMultiDeleteIconDisplayed();
	}
	@When("Admin clicks single <{int}> row level check box in the data table in elete class window")
	public void admin_clicks_single_row_level_check_box_in_the_data_table_in_elete_class_window(Integer int1) 
	{
		delpage.ClickSingleDeleteIcon(int1);
	}

	@Then("Admin should see tick mark in check box in delete class window")
	public void admin_should_see_tick_mark_in_check_box_in_delete_class_window() {
	    delpage.CheckMutiSelectCheckBox();
	}

	@When("Admin clicks multiple row level check box in the data table")
	public void admin_clicks_multiple_row_level_check_box_in_the_data_table() {
	    delpage.ClickMultiSelectCheckBox();
	}

	@Then("Admin should see tick mark in Check box  of the selected rows in delete class window")
	public void admin_should_see_tick_mark_in_check_box_of_the_selected_rows_in_delete_class_window() {
	delpage.IsSinlgeDeleteIconEnabled();
	}

	@Given("Admin is on Delete alert in delete class window")
	public void admin_is_on_delete_alert_in_delete_class_window() {
     delpage.GetDeleteDialogBoxTitle();
	     delpage.isVisibleDialogBoxElements();
//	     LOG.info("Delete Dialog is displayed");
	}

	@When("Admin clicks {string} button on alert window in delete class window")
	public void admin_clicks_button_on_alert_window_in_delete_class_window(String string) {

    delpage.ClickDeleteConfirmation(string);
	}

	@Then("Success Message and validate particular Class details are deleted from the data table")
	public void success_message_and_validate_particular_class_details_are_deleted_from_the_data_table() {
	     delpage.getSuccessMessage();
//	    LOG.info("A class row is deleted");
	}


@When("Admin clicks {string} button on alert window in delete class window1")
public void admin_clicks_button_on_alert_window_in_delete_class_window1(String string) {
	delpage.ClickDeleteConfirmation(string);
	}

	@Then("Admin should land on Manage class page and validate particular Class details are not deleted from the data table1")
	public void admin_should_land_on_manage_class_page_and_validate_particular_class_details_are_not_deleted_from_the_data_table1() {
		delpage.ClickOnClass();
	}
	@When("Admin click {string} button on alert window in delete class window1")
	public void admin_click_button_on_alert_window_in_delete_class_window1(String string) {
	    delpage.deletealertButton(string);
	}
	@Then("Admin should land on Manage Class page and validate particular Class details are deleted from the data table")
	public void admin_should_land_on_manage_class_page_and_validate_particular_class_details_are_deleted_from_the_data_table() {
	     driver.navigate().back();
	}
	@When("Admin click {string} button in alert in delete class window")
	public void admin_click_button_in_alert_in_delete_class_window(String string) {
	 		 delpage.deletealertButton(string);
	}

	@Then("Admin should land on Manage Class page and validate particular class details are not deleted from the data table")
	public void admin_should_land_on_manage_class_page_and_validate_particular_class_details_are_not_deleted_from_the_data_table() {
		delpage.ClickOnClass();
//		driver.close();
	}
	
	 
}



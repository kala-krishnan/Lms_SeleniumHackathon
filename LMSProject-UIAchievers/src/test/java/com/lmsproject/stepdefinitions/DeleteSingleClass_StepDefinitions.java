package com.lmsproject.stepdefinitions;
import java.util.logging.Logger;


import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.lmsproject.apphooks.Hooks;
import com.lmsproject.pageobjects.DeleteSingleClass_Pageobject;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
 

public class DeleteSingleClass_StepDefinitions {
	
	DeleteSingleClass_Pageobject delpage; 
	private WebDriver driver;
	
//	private static final Logger LOG=(Logger) LogManager.getLogger(Deletesingleclass_pageobj.class);
	
	public DeleteSingleClass_StepDefinitions()
	{

		driver = Hooks.getDriver();
		 delpage=new DeleteSingleClass_Pageobject(driver);	  
		  		
	}
	@Given("Admin is in Manage class page")
	public void admin_is_in_manage_class_page() {
		delpage.webpage();
		delpage.ClickOnClass();
	     delpage.ClickOnManageClassLink();
//	     LOG.info("Admin is on Manage class page");
	}

	@When("Admin clicks delete button in data table row level in Manage class page")
	public void admin_clicks_delete_button_in_data_table_row_level_in_manage_class_page() {
  delpage.ClickOnSinlgeDleteButton();
	  
	}

	@Then("Admin should see alert in delete class window")
	public void admin_should_see_alert_in_delete_class_window() {
	     delpage.GetDeleteDialogBoxTitle();
	}

	@Then("Alert should have {string} button to accept in delete class window")
	public void alert_should_have_button_to_accept_in_delete_class_window(String string) {
	   delpage.ClickDeleteConfirmation(string);
	}

	@Then("Alert should have {string} button to reject in delete class window")
	public void alert_should_have_button_to_reject_in_delete_class_window(String string) {
	     delpage.ClickDeleteConfirmation(string);
	}

	@Given("Admin is on delete alert in delete class window")
	public void admin_is_on_delete_alert_in_delete_class_window() {
	    delpage.getDeleteAlert();
	}

	@When("Admin clicks {string} button on Alert in delete class window")
	public void admin_clicks_button_on_alert_in_delete_class_window(String string) {
	     delpage.deletealertButton(string);
	}

	@Then("Success message and validate particular class details are deleted from the data table")
	public void success_message_and_validate_particular_class_details_are_deleted_from_the_data_table()
	{
	     delpage.getSuccessMessage();
	}

	@When("Admin click {string} button on Alert in delete class window")
	public void admin_click_button_on_alert_in_delete_class_window(String string) {
		delpage.deletealertButton(string);
	}
	@Then("Admin should land on manage class page and validate particular class details are not deleted from the data table")
	public void admin_should_land_on_manage_class_page_and_validate_particular_class_details_are_not_deleted_from_the_data_table()
	{
	    delpage.ClickOnManageClassLink();
	    
	}


}

package com.lmsproject.stepdefinitions;
import com.lmsproject.utility.*;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import org.testng.log4testng.Logger;
import com.lmsproject.pageobjects.ManageAssignment_Pageobject;
import com.lmsproject.utility.CommonWebElements;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.lmsproject.apphooks.*;
public class DeleteAssignmentPage_StepDefinitions {
	SoftAssert sa= new SoftAssert();
	ManageAssignment_Pageobject mp;
	CommonWebElements commonElement;
	WebDriver driver;
	DeleteConfirmDialogBox deleteConfirmDialogBox;
	private static final Logger LOG=Logger.getLogger(DeleteAssignmentPage_StepDefinitions.class);      
	public DeleteAssignmentPage_StepDefinitions()
	{
		driver=Hooks.getDriver();
		 mp =new ManageAssignment_Pageobject(driver);
		commonElement=new CommonWebElements(driver);
		deleteConfirmDialogBox=new DeleteConfirmDialogBox(driver);
	}
	
	@Given("Admin is in manage assignment page")
	public void admin_is_in_manage_assignment_page() {
		mp.urllaunch();
	}
	
	@When("Admin clicks delete button in data table {string}")
	public void admin_clicks_delete_button_in_data_table(String string) {
		commonElement.ClickSingleDeleteIcon(1);
	    
	}
	@Then("Admin should see dialog box")
	public void admin_should_see_dialog_box() {
		deleteConfirmDialogBox.GetDeleteDialogBoxTitle();
	}
	@Then("Alert should have {string} button to accept")
	public void alert_should_have_button_to_accept(String string) {
	sa.assertTrue(deleteConfirmDialogBox.isVisibleDialogBoxElements(),"Alert have yes button to accept");
	}
	@Then("Alert should have {string} button to reject")
	public void alert_should_have_button_to_reject(String string) {
		sa.assertTrue(deleteConfirmDialogBox.isVisibleDialogBoxElements(),"Alert have No button to accept"); 
	}
	@When("Admin clicks {string} button in delete assign")
	public void admin_clicks_button_in_delete_assign(String string) {
		deleteConfirmDialogBox.ClickDeleteConfirmation(string);
	}
	@Then("Redirected to assignment page and selected assignment details are {string} from the data table")
	public void redirected_to_assignment_page_and_selected_assignment_details_are_from_the_data_table(String string) {
	   mp.urlhaving();
	}
	@Then("Redirected to assignment page and selected assignment details are {string} from the data table \\(edited)")
	public void redirected_to_assignment_page_and_selected_assignment_details_are_from_the_data_table_edited(String string) {
	  mp.urlhaving();
	}
	@When("Admin clicks single  row level check box in the data table")
	public void admin_clicks_single_row_level_check_box_in_the_data_table() {
		commonElement.ClickSingleSelectCheckbox(0);
	}
	@Then("Admin should see delete icon below the header is enabled")
	public void admin_should_see_delete_icon_below_the_header_is_enabled() {
		sa.assertTrue(commonElement.IsMultiDeleteIconEnabled(),"delete icon below the header is enabled");
	}
	@Given("Admin is in delete alert in delete assign")
	public void admin_is_in_delete_alert_in_delete_assign() {
	    driver.switchTo().alert();
	} 
}

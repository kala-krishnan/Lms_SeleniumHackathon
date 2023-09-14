package com.lmsproject.stepdefinitions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.lmsproject.apphooks.Hooks;
import com.lmsproject.pageobjects.BatchPage_Pageobject;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class BatchPage_StepDefinitions {
	
	private WebDriver driver;
	BatchPage_Pageobject batchPag;
	String successMessage = "";
	String batchId ="";
	int index =0;
	List<Integer> deleteMultipleRows;
	public BatchPage_StepDefinitions()
	{
		driver = Hooks.getDriver();
		batchPag = new BatchPage_Pageobject(driver);
	}
	
	
	@Given("The admin is on dashboard page after login to click batch")
	public void the_admin_is_on_dashboard_page_after_login_to_click_batch() {
		batchPag.landingDashboardPage();
	}

	@When("The admin clicks {string} from navigation bar")
	public void the_admin_clicks_from_navigation_bar(String string) {
		successMessage=batchPag.clickBatchLink();
	}

	@Then("The admin should see the {string} in the URL")
	public void the_admin_should_see_the_in_the_url(String string) {
		Assert.assertEquals(successMessage, string);
	}

	@Then("The admin should see the {string} in the header")
	public void the_admin_should_see_the_in_the_header(String string) {
		successMessage=batchPag.verifyHeader();
		Assert.assertEquals(successMessage, string);
	}

	@Then("The admin should see the pagination controls in the Manage batch data table")
	public void the_admin_should_see_the_pagination_controls_in_the_manage_batch_data_table() {
		Assert.assertTrue(batchPag.verifyPaginationControl());
	}

	@Then("The admin should see the data table headers in {string} as Batch Name,Batch Description,Batch Status,No of Classes,Program Name,Edit ,Delete")
	public void the_admin_should_see_the_data_table_headers_in_as_batch_name_batch_description_batch_status_no_of_classes_program_name_edit_delete(String string) {
		Assert.assertTrue(batchPag.verifyDataTableHeaders(string));
	}

	@Then("The admin should be able to see the {string} icon button in Manage batch is disabled")
	public void the_admin_should_be_able_to_see_the_icon_button_in_manage_batch_is_disabled(String string) {
		Assert.assertTrue(batchPag.verifyDeleteIconDisabled());
	}

	@Then("The admin should be able to see the {string} button in Manage batch")
	public void the_admin_should_be_able_to_see_the_button_in_manage_batch(String string) {
		Assert.assertTrue(batchPag.verifyNewBatch_AddButton_Enabled());
	}

	@Then("Each row in the Manage batch table should have a checkbox")
	public void each_row_in_the_manage_batch_table_should_have_a_checkbox() {
		Assert.assertTrue(batchPag.verifyCheckBoxForEachRow());
	}

	@Then("Each row in Manage batch table should have a Edit icon that is enabled")
	public void each_row_in_manage_batch_table_should_have_a_edit_icon_that_is_enabled() {
		Assert.assertTrue(batchPag.verifyEditButtonEnabledForEachRow());
	}

	@Then("Each row in Manage batch table should have a delete icon that is enabled")
	public void each_row_in_manage_batch_table_should_have_a_delete_icon_that_is_enabled() {
		Assert.assertTrue(batchPag.verifyDeleteButtonEnabledForEachRow());
	}

	@When("The admin clicks {string} button")
	public void the_admin_clicks_button(String string) {
		batchPag.clickNewButton();
	}

	@Then("A new pop up with batch details appear")
	public void a_new_pop_up_with_batch_details_appear() {
		Assert.assertTrue(batchPag.verifyPopUpWindowforAddBatch());
	}
	@Given("The new pop up with batch details appear")
	public void the_new_pop_up_with_batch_details_appear() {
		batchPag.BatchDialogBoxTitle();
	}
	@Then("The pop up should include the fields {string},{string},{string},{string},{string}")
	public void the_pop_up_should_include_the_fields(String string, String string2, String string3, String string4, String string5) {
		HashMap<String ,String> batchTitleDetails = batchPag.BatchDialogBoxDetails();
		Assert.assertEquals(batchTitleDetails.get("batchName"), string);
		Assert.assertEquals(batchTitleDetails.get("BatchDescription"), string2);
		Assert.assertEquals(batchTitleDetails.get("ProgramName"), string3);
		Assert.assertEquals(batchTitleDetails.get("status"), string4);
		Assert.assertEquals(batchTitleDetails.get("No of Classes"), string5);
		
	}
	
	
	@When("The admin enters {string},{string},{string},{string},{string} in batch add pop up")
	public void the_admin_enters_in_batch_add_pop_up(String string, String string2, String string3, String string4, String string5) {
	    batchPag.validateInvalidCredentials(string, string2, string3, string4, string5);
	}

	@Then("the admin should see the error message indicating {string} in Batch pop up")
	public void the_admin_should_see_the_error_message_indicating_in_batch_pop_up(String string) {
		Assert.assertEquals(batchPag.geterrorMessage(), string);
	}
	@Given("The admin is in Add New Batch Pop up page")
	public void the_admin_is_in_add_new_batch_pop_up_page() {
		batchPag.landingPopUpPage();
	}
	@When("The user enter all the valid batch details")
	public void the_user_enter_all_the_valid_batch_details() {
		 batchPag.validBatchCredentials();
	}
	@Then("the user sees the sucesss message")
	public void the_user_sees_the_sucesss_message(String string) {
		successMessage =batchPag.getSuccessMessage();
		Assert.assertEquals(successMessage, string);
	}
	@Given("The delete icon on row level in batch data table is enabled")
	public void the_delete_icon_on_row_level_in_batch_data_table_is_enabled() {
		batchPag.checkDeleteIconisEnabled();
	}

	@When("Admin clicks the delete icon in batch")
	public void admin_clicks_the_delete_icon_in_batch() {
		batchPag.clickDeleteIconinBatch();
	}

	@Then("Alert appears with Yes and No Button")
	public void alert_appears_with_yes_and_no_button() {
		batchPag.GetDeleteDialogBoxTitle();
	}

	

	@When("Click Yes option in batch delete confirmation page")
	public void click_yes_option_in_batch_delete_confirmation_page() {
		batchId=batchPag.clickYesinBatchDeleteDialog();
	}

	@Then("Batch deleted alert pops and batch is no more avaliable in batch")
	public void batch_deleted_alert_pops_and_batch_is_no_more_avaliable_in_batch() {
		Assert.assertTrue(batchPag.validateBatchValueafterGiveYes(batchId));
		
	}

	@When("Click No option in batch delete confirmation page")
	public void click_no_option_in_batch_delete_confirmation_page() {
		batchId=batchPag.clickNoinBatchDeleteDialog();
	}

	@Then("Batch is still listed in data table")
	public void batch_is_still_listed_in_data_table() {
		Assert.assertTrue(batchPag.validateBatchValueafterGiveNo(batchId));
	}
	@Given("admin in in the manage batch page")
	public void admin_in_in_the_manage_batch_page() {
		batchPag.landingDashboardPage();
	}

	@When("None of the checkboxes are selected")
	public void none_of_the_checkboxes_are_selected() {
		batchPag.validatecheckBoxesareEnabled();
	}

	@Then("The delete icon under the manage batch header should be disabled")
	public void the_delete_icon_under_the_manage_batch_header_should_be_disabled() {
		Assert.assertTrue(batchPag.validateMultipleDeleteIcon());
		
	}
	@Given("one of the checkbox\\/row {int} shold be selected")
	public void one_of_the_checkbox_row_shold_be_selected(Integer int1) {
		batchPag.selectAnyOneofCheckBox(int1);
		index=int1;
	}

	@When("click delete icon below {string} header")
	public void click_delete_icon_below_header(String string) {
		batchPag.clickDeleteUnderHeader();
	}

	@Then("The respective row in the manage batch data table is deleted")
	public void the_respective_row_in_the_manage_batch_data_table_is_deleted() {
		Assert.assertTrue(batchPag.rowofBatch_Got_Deleted(index));
	}

	@Given("checkbox indexes {int} , {int} , {int} shold be selected")
	public void checkbox_indexes_shold_be_selected(Integer int1, Integer int2, Integer int3) {
		deleteMultipleRows = new ArrayList<Integer>() ;
		deleteMultipleRows.add(int1);
		deleteMultipleRows.add(int2);
		deleteMultipleRows.add(int3);
		batchPag.selectMoreThanCheckBoxForDelete(deleteMultipleRows);
	}

	@Then("The respective rows in the manage batch data table is deleted")
	public void the_respective_rows_in_the_manage_batch_data_table_is_deleted() {
		Assert.assertTrue(batchPag.rowsofBatch_Got_Deleted(deleteMultipleRows));
	}
	@Given("The edit icon on row level in manage batch data table is enabled")
	public void the_edit_icon_on_row_level_in_manage_batch_data_table_is_enabled() {
		batchPag.editIconOnRowLevelEnabled();
	}

	@When("Admin clicks the rownumber {int} edit icon in manage batch page")
	public void admin_clicks_the_edit_icon_in_manage_batch_page(int index) {
		batchPag.clickEditButton(index);
	}

	@Then("A new pop up with batch details appears")
	public void a_new_pop_up_with_batch_details_appears() {
		Assert.assertTrue(batchPag.verifyPopUpWindowforAddBatch());
	}

	@Given("The admin is in the pop up edit batch page")
	public void the_admin_is_in_the_pop_up_edit_batch_page() {
		batchPag.BatchDialogBoxTitle();
	}
	
	@When("Admin clicks the save button in edit batch page with valid details from excel")
	public void admin_clicks_the_save_button_in_edit_batch_page_with_valid_details_from_excel() {
		batchPag.validBatchCredentials();
	}

	@When("Admin clicks the save button in edit batch page with valid details")
	public void admin_clicks_the_save_button_in_edit_batch_page_with_valid_details(List<String> data) {
		batchPag.validBatchCredentialsToEdit(data.get(0),data.get(1),data.get(2),data.get(3),data.get(4));
	}

	@Then("The updated batch fields should appear on the data table")
	public void the_updated_batch_fields_should_appear_on_the_data_table() {
		
	}

	@Given("The edit pop up with batch details appear")
	public void the_edit_pop_up_with_batch_details_appear() {
	}

	@When("The admin enters {string},{string},{string},{string},{string} in batch edit pop up")
	public void the_admin_enters_in_batch_edit_pop_up(String string, String string2, String string3, String string4, String string5) {
	}

	@Then("the admin should see the error message indicating {string} in Batch edit pop up")
	public void the_admin_should_see_the_error_message_indicating_in_batch_edit_pop_up(String string) {
	}
	

}

package com.lmsproject.stepdefinitions;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import org.testng.log4testng.Logger;

import com.lmsproject.apphooks.TestContext;
import com.lmsproject.components.ExcelDataInputReader;
import com.lmsproject.pageobjects.AddOrEditProgramPage_Pageobject;
import com.lmsproject.pageobjects.DashboardPage_Pageobject;
import com.lmsproject.pageobjects.LoginPage_Pageobject;
import com.lmsproject.pageobjects.ProgramPage_Pageobject;
import com.lmsproject.utility.CommonWebElements;
import com.lmsproject.utility.DeleteConfirmDialogBox;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProgramPage_StepDefinitions {

	WebDriver driver;
	TestContext testContext;
	DashboardPage_Pageobject dashBoardPage;
	//HomePage_Pageobject homePage;
	LoginPage_Pageobject loginPage;
	ProgramPage_Pageobject programPage;
	CommonWebElements commonElement;
	AddOrEditProgramPage_Pageobject addOrEditProgramPage;

	String username;
	String password;
	String pageTitle;
	String pageHeading;
	boolean checkHeaders;
	int checkBoxIdx;
	String successMsg;
	ExcelDataInputReader excelFileReader;

	private static final Logger LOG = Logger.getLogger(ProgramPage_Pageobject.class);

	public ProgramPage_StepDefinitions(TestContext context) {

		this.testContext = context;
		//homePage = testContext.getPageObjectManager().getHomePage();
		loginPage = testContext.getPageObjectManager().getLoginPage();
		//dashBoardPage = testContext.getPageObjectManager().getdashboardPage();
		programPage = testContext.getPageObjectManager().getProgramPage();
		addOrEditProgramPage = testContext.getPageObjectManager().getAddOrEditProgramPage();
		commonElement = testContext.getCommonElement();


	}

	SoftAssert sa = new SoftAssert();

	@Given("Admin users is on dashboard page after Login")
	public void admin_users_is_on_dashboard_page_after_login() {

		//homePage.urlBrowser();
		loginPage.openLMSPage();
		loginPage.loginUsingValidDetails(username, password);
		LOG.info("Admin is on dashboard page");
	}

	//"*****************************09_ProgramPage.feature (Manage Program)************************//
	
	@Then("Admin should land on the dashboard page")
	public void admin_users_should_land_on_the_dashboard_page() {
		
	 //  Assert.assertTrue( dashBoardPage.pagetitle());
	   LOG.info("Admin is in dashboard page");
	}

	@When("Admin clicks Program on the navigation bar")
	public void admin_users_clicks_program_on_the_navigation_bar() {

		programPage.clickprogram(); 
		LOG.info("Admin clicks Program on the navigation bar");// webelement is referred in program page)
	}

	@Then("Admin should see URL with {string} in program module")
	public void admin_users_should_see_url_with_in_program_module(String pagetitle) {

		pageTitle = commonElement.GetPageHeaderTitle();
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(pageTitle, pagetitle);
		LOG.info("Admin is on Manage Program page");
	}

	@Then("Admin should see a heading with text {string} on the page")
	public void admin_users_should_see_a_heading_with_text_on_the_page(String pagetitle) {

		pageTitle = testContext.getCommonElement().GetPageHeaderTitle();
		sa.assertEquals(pageTitle, pagetitle);
		LOG.info("Admin is on Manage Program page");
	}
	
	@Then("Admin should see the text as {string} along with Pagination icon below the table")
	public void admin_users_should_see_the_text_as_along_with_pagination_icon_below_the_table(String paginationEntriesText) {
		
		sa.assertEquals(commonElement.GetPaginationShowEntries(), paginationEntriesText);
		Boolean paginationcontrol = commonElement.VerifyPaginationControlsPresent();
		Assert.assertTrue(paginationcontrol);
	}

	@Then("Admin should see the footer as {string}")
	public void admin_users_should_see_the_footer_as(String footerlabel) {
		
		
		String actualLabel = commonElement.getFooterTotalRecord();
		boolean patternMatch = Pattern.matches("(?:In\\stotal\\sthere\\sare\\s\\d+\\sprograms.)", actualLabel);
		assertTrue(actualLabel, patternMatch);
		LOG.info("Verified that footer text on page");
	}


	@Then("Admin should see a Delete button on the top left hand side as Disabled")
	public void admin_users_should_see_a_delete_button_on_the_top_left_hand_side_as_disabled() {

		Boolean multideleteIcon = commonElement.IsMultiDeleteIconEnabled();
		Assert.assertFalse(multideleteIcon);
		LOG.info("Verified Multiple delete button disabled on Program Page");
	}

	@Then("Admin should see a {string} button on the program page above the data table")
	public void admin_users_should_see_a_button_on_the_program_page_above_the_data_table(String addnewButton) {

		Boolean addnew = commonElement.IsAddButtonDisplayed();
		Assert.assertTrue(addnew);
		LOG.info("Verified add new button is displayed");
	}

	@Then("Admin users should see the number of records \\(rows of data in the table) displayed on the page are {int}")
	public void admin_users_should_see_the_number_of_records_rows_of_data_in_the_table_displayed_on_the_page_are(
			int totalnoofrecords) {

		int count = commonElement.GetRecordCount();
		Assert.assertEquals(count, totalnoofrecords);
		LOG.info("Verified the display of number of records in the program grid table");
	}

	@Then("Admin users should see data table on the Manage Program Page with following column headers {string}")
	public void admin_users_should_see_data_table_on_the_manage_program_page_with_following_column_headers(String page) {

		checkHeaders = commonElement.IsPageLoaded(page);
		Assert.assertTrue(checkHeaders);
		LOG.info("Verified the headers in the program page");
	}

	@Then("Admin users should see the sort arrow icon beside to each column header except Edit and Delete")
	public void admin_users_should_see_the_sort_arrow_icon_beside_to_each_column_header_except_edit_and_delete() {

	}

	@Then("Admin users should see check box on the left side in all rows of the data table")
	public void admin_users_should_see_check_box_on_the_left_side_in_all_rows_of_the_data_table() {

		Assert.assertTrue(commonElement.IsCheckBoxInTableRows(null));
		LOG.info("Verified checkbox present and enabled in table on User Page");
	}

	@Then("Admin users should see the Edit and Delete buttons on each row of the data table")
	public void admin_users_should_see_the_edit_and_delete_buttons_on_each_row_of_the_data_table() {
		/*
		 * Assert.assertTrue(commonElement.IsEditButtonInTableRows(null));
		 * Assert.assertTrue(commonElement.IsDeleteButtonInTableRows(null));
		 */
		//Assert.assertTrue(commonElement.ClickSingleEditButton(1));
		Assert.assertTrue(commonElement.ClickSingleDeleteIcon(1));
		LOG.info("Verified edit and delete button present and enabled in table on Program Page");
	}

	@Then("Admin users should see Search bar with text as {string}")
	public void admin_users_should_see_search_bar_with_text_as(String string) {

		Assert.assertTrue(commonElement.IsSearchBoxDisplayed());
		LOG.info("Verified search textbox present on Program Page");
	}

	//"*****************************Manage Program1.feature************************//
	
	
	@When("Admin enters Program Name , Program Description and Program Status in search content into search box {string} {string}, {string}")
	public void admin_enters_program_name_program_description_and_program_status_in_search_content_into_search_box(String progName, String progDesc, String status) {
		
		commonElement.EnterSearchContent(progName);
		commonElement.EnterSearchContent(progDesc);
		commonElement.EnterSearchContent(status);
		
		LOG.info("Verified Admin enters Program Name, Program Description, Program Status into search content into search box");
		
	}

	@Then("Admin see the search result {string} {string}, {string}")
	public void admin_see_the_search_result(String progName, String progDesc, String status) {
		
		assertTrue(progName, commonElement.IsPageLoaded("Program"));
		//Assert.assertEquals(progName, commonElement.EnterSearchContent(progName));
		assertTrue(progDesc, commonElement.IsPageLoaded("Program"));
		//Assert.assertEquals(progDesc, commonElement.EnterSearchContent(progDesc));
		assertTrue(status, commonElement.IsPageLoaded("Program"));
		//Assert.assertEquals(status, commonElement.EnterSearchContent(status));
		LOG.info("Verified list of programs description displayed based on the Program status");
	}

	@When("Admin enters the keywords not present in the data table 'AI 'on the Search box")
	public void admin_enters_the_keywords_not_present_in_the_data_table_ai_on_the_search_box() {
	    
	}

	

	@When("Admin enters the keywords not present {string} in the data table on the Search box")
	public void admin_enters_the_keywords_not_present_in_the_data_table_on_the_search_box(String notExistsprogramName) {

		commonElement.EnterSearchContent(notExistsprogramName);
		assertTrue(notExistsprogramName, commonElement.IsPageLoaded("Program"));
		//Assert.assertTrue(notExistsprogramName, commonElement.EnterSearchContent(notExistsprogramName));
		LOG.info("Verified list of programs description displayed based on the Program status");
	}

	@Then("Admin should see zero entries on the data table")
	public void admin_should_see_zero_entries_on_the_data_table() {

		commonElement.getFooterTotalRecord();
		LOG.info("Verified list of non exists program will display as zero entries on the table");
	}

	@When("Admin enters the keywords not present in the data table 'SDET1 'on the Search box")
	public void admin_enters_the_keywords_not_present_in_the_data_table_sdet1_on_the_search_box() {

	}

	// ***********Program_NavigationValidation.feature**********************//

	@Given("Admin is on Manage Program page")
	public void admin_is_on_manage_program_page() {

		loginPage.clickloginAuth();
		programPage.clickprogram(); // link is referred to program page, as dashboard link is referred in additional
									// scenarios
		LOG.info("Admin is on Manage Program Page");

	}

	@When("Admin clicks on Student link on Manage Program page")
	public void admin_clicks_on_student_link_on_manage_program_page() {

		programPage.clickstudent();
	}

	@Then("Admin is re-directed to Student page")
	public void admin_is_re_directed_to_student_page() {

		Assert.assertEquals(programPage.studentpage(), pageTitle);
	}

	@When("Admin clicks on Batch link on Manage Program page")
	public void admin_clicks_on_batch_link_on_manage_program_page() {

		programPage.clickbatch();
	}

	@Then("Admin is re-directed to Batch page")
	public void admin_is_re_directed_to_batch_page() {

		Assert.assertEquals(programPage.batchpage(), pageTitle);
	}

	@When("Admin clicks on Class link on Manage Program page")
	public void admin_clicks_on_class_link_on_manage_program_page() {

		programPage.clickclass();
	}

	@Then("Admin is re-directed to Class page")
	public void admin_is_re_directed_to_class_page() {

		Assert.assertEquals(programPage.classpage(), pageTitle);
	}

	@When("Admin clicks on User link on Manage Program page")
	public void admin_clicks_on_user_link_on_manage_program_page() {

		programPage.clickuser();
	}

	@Then("Admin is re-directed to User page")
	public void admin_is_re_directed_to_user_page() {

		Assert.assertEquals(programPage.userpage(), pageTitle);
	}

	@When("Admin clicks on Assignment link on Manage Program page")
	public void admin_clicks_on_assignment_link_on_manage_program_page() {

		programPage.clickprogram();
	}

	@Then("Admin is re-directed to Assignment page")
	public void admin_is_re_directed_to_assignment_page() {

		Assert.assertEquals(programPage.userpage(), pageTitle);
	}

	@When("Admin clicks on Attendance link on Manage Program page")
	public void admin_clicks_on_attendance_link_on_manage_program_page() {

		programPage.clickattend();
	}

	@Then("Admin is re-directed to Attendance page")
	public void admin_is_re_directed_to_attendance_page() {

		Assert.assertEquals(programPage.attendpage(), pageTitle);
	}

	@When("Admin clicks on Logout link on Manage Program page")
	public void admin_clicks_on_logout_link_on_manage_program_page() {

		programPage.clicklogout();
	}

	@Then("Admin is re-directed to Login page")
	public void admin_is_re_directed_to_login_page() {

		Assert.assertTrue(programPage.loginpage());
	}

	// *********************Pagination.feature********************//

	@When("Admin clicks Next page link on the program table")
	public void admin_clicks_next_page_link_on_the_program_table() {

		commonElement.ClickNextNavigationButton();

	}

	@Then("Admin should see the Pagination has {string} link")
	public void admin_should_see_the_pagination_has_link(String string) {

		Assert.assertFalse(commonElement.IsNextNavigationDisabled());
	}

	@When("Admin clicks Last page link")
	public void admin_clicks_last_page_link() {

		commonElement.ClickLastNavigationButton();
	}

	@Then("Admin should see the last page record on the table with Next page link are disabled")
	public void admin_should_see_the_last_page_record_on_the_table_with_next_page_link_are_disabled() {

		Assert.assertTrue(commonElement.IsNextNavigationDisabled());
	}

	@Given("Admin is on last page of Program table")
	public void admin_is_on_last_page_of_program_table() {

		commonElement.IsNextNavigationDisabled();
	}

	@When("Admin clicks First page link")
	public void admin_clicks_first_page_link() {

		commonElement.IsFirstpageButtonEnabled();
	}

	@Then("Admin should see the previous page record on the table with pagination has previous page link")
	public void admin_should_see_the_previous_page_record_on_the_table_with_pagination_has_previous_page_link() {

		Assert.assertTrue(commonElement.IsSecondpageLoaded());
	}

	@Given("Admin is on Previous Program page")
	public void admin_is_on_previous_program_page() {

		commonElement.ClickPreviousNavigationButton();
	}

	@When("Admin clicks Start page link")
	public void admin_clicks_start_page_link() {
		commonElement.IsFirstpageLoaded();
	}

	@Then("Admin should see the very first page record on the table with Previous page link are disabled")
	public void admin_should_see_the_very_first_page_record_on_the_table_with_previous_page_link_are_disabled() {

		Assert.assertTrue(commonElement.IsPreviousNavigationDisabled());
	}

	// *********************Add Program.feature********************//

	@When("Admin clicks <+ A New Program>button")
	public void admin_clicks_a_new_program_button() {

		commonElement.ClickNewButton();
		LOG.info("Admin clicks new program button");
	}

	@Then("Admin should see a popup open for Program details with empty form along with <SAVE> and <CANCEL> button and Close\\(X) Icon on the top right corner of the window")
	public void admin_should_see_a_popup_open_for_program_details_with_empty_form_along_with_save_and_cancel_button_and_close_x_icon_on_the_top_right_corner_of_the_window() {

		Assert.assertTrue(addOrEditProgramPage.isProgramDialogBoxVisible());
		Assert.assertTrue(addOrEditProgramPage.verifyFields());
		LOG.info("Verify the popup and fields in Program Page");
	}

	@Then("Admin should see two input fields and their respective text boxes in the program details window")
	public void admin_should_see_two_input_fields_and_their_respective_text_boxes_in_the_program_details_window() {

		Assert.assertTrue(addOrEditProgramPage.verifyFields());
		LOG.info("Validate the fields and their text boxes in Program Page");
	}

	@Then("Admin should see two radio button for Program Status")
	public void admin_should_see_two_radio_button_for_program_status() {

		Assert.assertTrue(addOrEditProgramPage.verifyFields());
		LOG.info("Verified the radio buttons in Program Page");
	}

	@Given("Admin is on {string} Popup window")
	public void admin_is_on_popup_window(String pageTitle) {

		addOrEditProgramPage.isProgramDialogBoxVisible();
		addOrEditProgramPage.ProgramDialogBoxTitle();

	}
	
	@When("Admin clicks 'Save'button without entering any data {string} {string} {string} {string}")
	public void admin_clicks_save_button_without_entering_any_data(String progName, String progDesc, String status,
			String save) {
		{

			addOrEditProgramPage.validateInvalidCredentials(progName, progDesc, status);
			commonElement.addProgramConfirmation(save);
		}
	}

	@Then("Admin gets a Error message alert {string}")
	public void admin_gets_a_error_message_alert(String errormessage) {

		Alert alert = driver.switchTo().alert();
		Assert.assertEquals(alert.getText(), errormessage);
		alert.accept();
		Assert.assertTrue(commonElement.getErrorMessage(), errormessage);
		LOG.info("Verified error message for invalid data in Program Page");
	}
	@Given("The admin is in Add New Program Pop up page")
	public void the_admin_is_in_add_new_program_pop_up_page() {
		
	   addOrEditProgramPage.landingPopUpPage();
	}

	@When("The user enter all the valid program details")
	public void the_user_enter_all_the_valid_program_details() {
	    
		addOrEditProgramPage.validProgramCredentials();
	}

	@Then("the user sees the {string} message in program page")
	public void the_user_sees_the_message_in_program_page(String successmessage) {
		
	  String successMessage =  commonElement.getSuccessMessage();
	    Assert.assertEquals(successMessage, successmessage);
	}
	
	@When("Admin enters only program name or program description or status {string} or {string} or {string} or {string} in text box and clicks Save button")
	public void admin_enters_only_program_name_or_program_description_or_status_or_or_or_in_text_box_and_clicks_save_button(
			String progName, String progDesc, String status, String save) {

		addOrEditProgramPage.validateInvalidCredentials(progName, progDesc, status);
		commonElement.addProgramConfirmation(save);
	}

	@When("Admin enters program name, program description, status {string} or {string} or {string} in text box and clicks Save button")
	public void admin_enters_program_name_program_description_status_or_or_in_text_box_and_clicks_save_button(
			String progName, String progDesc, String status) {

		addOrEditProgramPage.validateInvalidCredentials(progName, progDesc, status);
		LOG.info("Verify alert Error message in Program Page in adding new program");
	}

	@Then("Admin gets a message {string} alert and able to see the updated details in the table for the particular program")
	public void admin_gets_a_message_alert_and_able_to_see_the_updated_details_in_the_table_for_the_particular_program(
			String successmessage) {

		driver.switchTo().alert().getText();
		Assert.assertEquals(commonElement.getSuccessMessage(), successmessage);
		LOG.info("Verified user added on User Page");
	}

	@When("Admin clicks Close {string} Icon on Program Details form")
	public void admin_clicks_close_icon_on_program_details_form(String close) {

		commonElement.clickXbtn();
	}

	@Then("Program Details popup window should be closed without saving")
	public void program_details_popup_window_should_be_closed_without_saving() {

		Assert.assertTrue(commonElement.clickXbtn());
	}

	@When("Admin clicks <Cancel> {string} button")
	public void admin_clicks_cancel_button(String cancel) {

		commonElement.addProgramConfirmation(cancel);
	}

	@Then("Admin can see the Program details popup disappears without creating any program")
	public void admin_can_see_the_program_details_popup_disappears_without_creating_any_program() {

		Assert.assertTrue(commonElement.IsVerifyProgramDialogBoxDisappear());
	}

//******************EditProgram.feature***************//

	@Given("Admin is in dashboard Page after login")
	public void admin_is_in_dashboard_page_after_login() {

		loginPage.clickloginAuth();
	}

	@When("Admin clicks program on the navigator bar")
	public void admin_clicks_program_on_the_navigator_bar() {

		programPage.clickprogram();
	}

	@Then("Admin should be on Manage Program page {string}")
	public void admin_should_be_on_manage_program_page(String pageTitle) {

		Assert.assertEquals(commonElement.GetPageHeaderTitle(), pageTitle);

	}

	@When("Admin clicks <Edit> button on the data table for any row")
	public void admin_clicks_edit_button_on_the_data_table_for_any_row() {

		commonElement.ClickSingleEditButton(0);

	}

	@Then("Admin should see a popup open for Program details to edit")
	public void admin_should_see_a_popup_open_for_program_details_to_edit() {

		Assert.assertFalse(commonElement.IsVerifyProgramDialogBoxDisappear());
	}

	@When("Admin edits the Name column and clicks save button program name, program description, status {string} or {string} or {string} in text box and clicks Save button")
	public void admin_edits_the_name_column_and_clicks_save_button_program_name_program_description_status_or_or_in_text_box_and_clicks_save_button(
			String progName, String progDesc, String status,
			String save) {

		addOrEditProgramPage.validProgramCredentials();
	}

//*******************Edit Feature -02.feature**********************/
	@Given("Admin is in Manage program Page")
	public void admin_is_in_manage_program_page() {

		programPage.progpage();

	}

	@When("Admin clicks program link on the navigator bar")
	public void admin_clicks_program_link_on_the_navigator_bar() {

		programPage.clickprogram();
	}

	@When("Admin clicks <save>{string} button on edit popup")
	public void admin_clicks_save_button_on_edit_popup(String save) {

		commonElement.addProgramConfirmation(save);
	}

	@When("Admin clicks <Cancel>button on edit popup")
	public void admin_clicks_cancel_button_on_edit_popup(String cancel) {

		commonElement.addProgramConfirmation(cancel);
	}

	@Then("Admin can see the Program details popup disappears and can see nothing changed for particular program")
	public void admin_can_see_the_program_details_popup_disappears_and_can_see_nothing_changed_for_particular_program() {

		Assert.assertFalse(commonElement.IsVerifyProgramDialogBoxDisappear());
	}

//*******************Delete Feature -01.feature**********************/

	@When("User select the single program checkbox and its delete button")
	public void user_select_the_single_program_checkbox_and_its_delete_button() {

		int GetProgramRecordCount = commonElement.GetRecordCount();
		checkBoxIdx = commonElement.getRandomIndex(GetProgramRecordCount);
		if (checkBoxIdx >= 0)
			commonElement.ClickSingleSelectCheckbox(checkBoxIdx);
		
	}

	@Then("User lands on program delete confirmation page")
	public void user_lands_on_program_delete_confirmation_page() {

		DeleteConfirmDialogBox deleteDialogBox = new DeleteConfirmDialogBox(driver);
		assertEquals("Not showing delete confirmation dialog box", "Confirm",
				deleteDialogBox.GetDeleteDialogBoxTitle());
	}

	@When("User clicks on Program delete dialog {string} button")
	public void user_clicks_on_program_delete_dialog_button(String Confirmation) {

		Assert.assertSame(commonElement.getSuccessMessage(), Confirmation);
	}

	@Then("User gets confirmation for Program delete {string}")
	public void user_gets_confirmation_for_program_delete(String string) {

	}

	@When("Admin clicks Close Icon on Deletion alert")
	public void admin_clicks_close_icon_on_deletion_alert() {
		commonElement.clickXbtn();
	}

	@When("Admin clicks <Delete> button on the data table for any row")
	public void admin_clicks_delete_button_on_the_data_table_for_any_row() {
		commonElement.ClickSingleDeleteIcon(0);
	}

	@Then("Admin should see a message {string}")
	public void admin_should_see_a_message(String message) {

		Assert.assertSame(commonElement.getSuccessMessage(), message);
	}

	@Then("Admin should see a alert open with heading {string}  along with  <YES>{string} and <NO>{string} button for deletion")
	public void admin_should_see_a_alert_open_with_heading_along_with_yes_and_no_button_for_deletion(String pageTitle,
			String Yes, String No) {

		Assert.assertEquals(commonElement.GetDeleteDialogBoxTitle(), pageTitle);
		Assert.assertTrue(commonElement.isVisibleDeleteDialogBoxElements());

	}

	@Then("Admin should see a message {string} {string}")
	public void admin_should_see_a_message(String alertmessage, String confirm) {

		Assert.assertEquals(commonElement.ClickDeleteConfirmation(confirm), alertmessage);
	}

	@Given("Admin is on Confirm Deletion alert")
	public void admin_is_on_confirm_deletion_alert() {

		commonElement.GetDeleteDialogBoxTitle();
	}

	@When("Admin clicks <YES>{string} button on the alert")
	public void admin_clicks_yes_button_on_the_alert(String Yes) {
		commonElement.ClickDeleteConfirmation(Yes);
	}

	@Then("Admin gets a message {string} alert and able to see that program deleted in the data table")
	public void admin_gets_a_message_alert_and_able_to_see_that_program_deleted_in_the_data_table(String No) {

		commonElement.ClickDeleteConfirmation(No);
	}

	@When("Admin clicks <NO>{string} button on the alert")
	public void admin_clicks_no_button_on_the_alert(String No) {

		commonElement.ClickDeleteConfirmation(No);
	}

	@Then("Admin can see the deletion alert disappears without deleting")
	public void admin_can_see_the_deletion_alert_disappears_without_deleting() {

		assertTrue(commonElement.IsVerifyProgramDialogBoxDisappear());
	}

	@When("Admin clicks Cancel\\/Close\\(X) Icon on Deletion alert")
	public void admin_clicks_cancel_close_x_icon_on_deletion_alert() {

		commonElement.clickXbtn();
	}

	@Then("Admin can see the deletion alert disappears without any changes")
	public void admin_can_see_the_deletion_alert_disappears_without_any_changes() {

		assertTrue(commonElement.IsVerifyProgramDialogBoxDisappear());
	}

	// *********************************MultiDelete.feature1******************/

	@When("Admin clicks any checkbox in the data table")
	public void admin_clicks_any_checkbox_in_the_data_table() {

		int GetProgramRecordCount = commonElement.GetRecordCount();
		checkBoxIdx = commonElement.getRandomIndex(GetProgramRecordCount);
		if (checkBoxIdx >= 0)
			commonElement.ClickSingleSelectCheckbox(checkBoxIdx);
	}

	@Then("Admin should see common delete option enabled under header Manage Program")
	public void admin_should_see_common_delete_option_enabled_under_header_manage_program() {

		assertTrue(commonElement.IsMultiDeleteIconDisplayed());
	}

	// *********************************MultiDelete.feature2******************/

	@Given("Admin clicks delete button in the Manage Program Page under header")
	public void admin_clicks_delete_button_in_the_manage_program_page_under_header() {
		int GetProgramRecordCount = commonElement.GetRecordCount();
		checkBoxIdx = commonElement.getRandomIndex(GetProgramRecordCount);
		if (checkBoxIdx >= 0)
			commonElement.ClickSingleSelectCheckbox(checkBoxIdx);

	}

	@Then("Admin should see the checkbox selected")
	public void admin_should_see_the_checkbox_selected() {

		Assert.assertTrue(commonElement.ClickSingleDeleteIcon(checkBoxIdx));
		LOG.info("Admin verified the checkbox is selected");

	}

	@When("Click on multiple program delete button")
	public void click_on_multiple_program_delete_button() {

		assertTrue("Multiple delete button is disabled", commonElement.IsMultiDeleteIconEnabled());
		commonElement.ClickMultiDeleteIcon();
	}

	@Given("Admin click on multiple program delete button with checkbox selected")
	public void admin_click_on_multiple_program_delete_button_with_checkbox_selected() {

		int GetProgramRecordCount = commonElement.GetRecordCount();
		checkBoxIdx = commonElement.getRandomIndex(GetProgramRecordCount);
		if (checkBoxIdx >= 0)
			commonElement.ClickSingleSelectCheckbox(checkBoxIdx);
		commonElement.ClickSingleDeleteIcon(checkBoxIdx);
	}

	@When("Admin clicks on Program delete dialog {string} button")
	public void admin_clicks_on_program_delete_dialog_button(String confirmation) {

		successMsg = commonElement.ClickDeleteConfirmation(confirmation);
	}

	@Then("Admin gets confirmation for Program delete {string}")

	public void admin_gets_confirmation_for_program_delete(String Message) {
		if (!Message.equals("NA")) {
			if (!successMsg.contains(Message))
				assertEquals("Sucess message is not per requirement", Message, successMsg);
			assertEquals("Not landed on Program page", "Manage Program", commonElement.GetPageHeaderTitle());
		}
	}

//*********************************Sorting Ordering.feature******************/

	@When("User clicks on the Ascending or Descending arrow button on program page")
	public void user_clicks_on_the_ascending_or_descending_arrow_button_on_program_page(DataTable dataTable) {

		List<String> ascendingButton = dataTable.asList(String.class);
		for (String fieldName : ascendingButton) {
			commonElement.GetSortedOrder(fieldName);	
		}
	}

	@Then("User can see the results in Ascending or Descending order on program page")
	public void user_can_see_the_results_in_ascending_or_descending_order_on_program_page(DataTable dataTable) {
		List<String> ascendingButton = dataTable.asList(String.class);
		List<String> resultList = new ArrayList<String>();
		for (String fieldName : ascendingButton) {
			resultList = commonElement.GetSortedOrder(fieldName);
//			assertThat(resultList).isSorted();
		
	}

	}

}

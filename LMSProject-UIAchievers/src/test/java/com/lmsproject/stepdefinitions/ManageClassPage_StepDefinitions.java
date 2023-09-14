 package com.lmsproject.stepdefinitions;
import java.io.IOException;
import java.util.logging.Logger;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.lmsproject.apphooks.Hooks;
import com.lmsproject.pageobjects.ManageClassPage_Pageobject;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class ManageClassPage_StepDefinitions {

	ManageClassPage_Pageobject mcp;
	private WebDriver driver;
	
 
//	private static final Logger LOG = (Logger) LogManager.getLogger(Class01_ManageClass_stepdef.class);

	public ManageClassPage_StepDefinitions() {
		driver = Hooks.getDriver();
		mcp = new ManageClassPage_Pageobject(driver);
		 
	}

//	VerifyClassPage
	@Given("Admin is on dashboard page after Login for Manage class")
	public void admin_is_on_dashboard_page_after_login_for_manage_class() throws IOException {


		mcp.getPage();
		 mcp.getPageTitle();
	     
	}

	@When("Admin clicks manage Class button on the navigation bar")
	public void admin_clicks_manage_class_button_on_the_navigation_bar() {
	mcp.ClickOnClass();
	}

	@Then("Admin should see URL with {string}")
	public void admin_should_see_url_with(String string) {
		mcp.CheckOnManageClassLink();
//		LOG.info("The user is in Manage Class Page");
	}

//	#@CaptureResponseTime
	@When("Admin clicks Class button on the navigation bar  from dashboard")
	public void admin_clicks_class_button_on_the_navigation_bar_from_dashboard() {
		mcp.ClickOnClass();
	}
	@Then("Get the response time for navigation from dashboard page to Manage class page")
	public void get_the_response_time_for_navigation_from_dashboard_page_to_manage_class_page() {

		mcp.CaptureResponseTime();

	}

//	#@ManageHeader
	@When("Admin clicks Class button on the navigation bar")
	public void admin_clicks_class_button_on_the_navigation_bar() {
		mcp.ClickOnClass();
	}
	@Then("Admin should see header with {string}")
	public void admin_should_see_header_with(String string) {
		 
		String actual=mcp.getPageTitle();
		  
	    Assert.assertEquals("welcometomanageclasspage",actual);
	    
//		LOG.info("Admin is on Manage Class page");
	}

//#@ValidateText
	@When("Admin clicks Class button on the navigation bar and get all text from the portal page")
	public void admin_clicks_class_button_on_the_navigation_bar_and_get_all_text_from_the_portal_page() {
	mcp.GetAllText();

	}

	@Then("Admin should see correct spelling for the all the fields")
	public void admin_should_see_correct_spelling_for_the_all_the_fields() {
		mcp.GetAllText();
	}

//#@ValidateDeleteIcon(Given n when r already thr)
	@Then("Admin should see disabled delete icon below the {string}")
	public void admin_should_see_disabled_delete_icon_below_the(String string) {
		mcp.CheckDeleteAll();
	}

//#@VerifySearchBar
	@Then("Admin should see search bar on the class page")
	public void admin_should_see_search_bar_on_the_class_page() {
		mcp.CheckSearchBar();
	}

//#@VerifyAddNewClass
	@Then("Admin should see +Add New Class button on the class page")
	public void admin_should_see_add_new_class_button_on_the_class_page() {
		mcp.CheckNewClassButton();
//		LOG.info("Verified add new button is displayed");
		mcp.ClickNewClassButton();
	}

//#@VerifyDataTable
	@Then("Admin should see data table on the Manage Class Page With column headers.")
	public void admin_should_see_data_table_on_the_manage_class_page_with_column_headers() {
		mcp.verifyVisibilityOfAllElements();
	}

//#@VerifyEditIcon
	@Then("Edit Icon in each row of data table only when entries are available")
	public void edit_icon_in_each_row_of_data_table_only_when_entries_are_available() {
	mcp.verifyEditButton();
	}

//#@VerifyEditIconWithNoData
	@Then("Edit Icon will not be present in data table")
	public void edit_icon_will_not_be_present_in_data_table() {
		mcp.verifyEditButtonwithNodata();
	}

//#@VerifyDeleteIcon
	@Then("Delete Icon in each row of data table only  when entries are available")
	public void delete_icon_in_each_row_of_data_table_only_when_entries_are_available() {
		mcp.verifyEditButton();
	}

//#@VerifyDeleteIconWithNoData
	@Then("Admin cant see delete Icon in data table in manage class page")
	public void admin_cant_see_delete_icon_in_data_table_in_manage_class_page() {
	mcp.verifyDeleteButtonWithNoData();
	}

//#@VerifySortICon
	@Then("Admin should see sort icon near the column headers except for Edit and Delete in manage class page")
	public void admin_should_see_sort_icon_near_the_column_headers_except_for_edit_and_delete_in_manage_class_page() {
	mcp.GetSortedOrder(null);
	}

//#@VerifyCheckBox
	@Then("Admin should see check box in the all rows  of data table on class page in manage class page")
	public void admin_should_see_check_box_in_the_all_rows_of_data_table_on_class_page_in_manage_class_page() {
	mcp.ClickMutiSelectCheckBox();
	}

//#@VerifyNumberEntries
	@Then("Admin should see the text as {string} below the table in manage class page")
	public void admin_should_see_the_text_as_below_the_table_in_manage_class_page(String string) {
		mcp.checkEntriesFooter();
	}

//#@VerifyPagination
	@Then("Admin should see the pagination controls under the data table in manage class page")
	public void admin_should_see_the_pagination_controls_under_the_data_table_in_manage_class_page() {
	mcp.GetPaginationShowEntries();

	}

//#@VerifyFooter
	@Then("Admin should see the text with total number classes in the data table\\( {string})")
	public void admin_should_see_the_text_with_total_number_classes_in_the_data_table(String string) {
		mcp.getFooterTotalRecord();

		}
//#@VerifySearchBox
	@Given("Admin is on Manage Class Page")
	public void admin_is_on_manage_class_page() {
		mcp.ClickOnClass();
	}
	@When("Admin enters batch id into search box {string} in manage class page")
	public void admin_enters_batch_id_into_search_box_in_manage_class_page(String string) {
    mcp.searchInput_batchId(string);
	}
	@Then("Displays entries with that batch Id in class page")
	public void displays_entries_with_that_batch_id_in_class_page() {
		mcp.displayBatchId();
	}
	@When("Admin enters batch id which is not existing the table into search box {string} in manage class page")
	public void admin_enters_batch_id_which_is_not_existing_the_table_into_search_box_in_manage_class_page(String string) {
	    mcp.searchInput_batchId(string);
	}
	@Then("Displays empty details in the data table in manage class page")
	public void displays_empty_details_in_the_data_table_in_manage_class_page() {
	 mcp.batchSearchBox();
	}

	@When("Admin enters {string} into search box in manage Class page")
	public void admin_enters_into_search_box_in_manage_class_page(String string) {
	mcp.searchInput_classNO(string);
	}

	@Then("Displays entries with that class no in manage class page")
	public void displays_entries_with_that_class_no_in_manage_class_page() {
	mcp.display_classNO();
	}

	@When("Admin enters {string} which is not existing the table into search box in manage class page <integer>")
	public void admin_enters_which_is_not_existing_the_table_into_search_box_in_manage_class_page_integer(String NoofClasses) {
mcp.searchInput_classNO(NoofClasses);
	}

	@When("Admin enters class topic into search box {string} in manage class page")
	public void admin_enters_class_topic_into_search_box_in_manage_class_page(String string) {
		mcp.searchInput_classTopic(string);
	}

	@Then("Displays entries with that  class topic in manage class page")
	public void displays_entries_with_that_class_topic_in_manage_class_page() {
		mcp.display_classTopic();
	}

	@When("Admin enters class topic which is not existing the table into search box {string} in manage class page")
	public void admin_enters_class_topic_which_is_not_existing_the_table_into_search_box_in_manage_class_page(String string) {
		mcp.searchInput_classTopic(string);
	}

	@When("Admin enters staff id into search box {string} in manage class page")
	public void admin_enters_staff_id_into_search_box_in_manage_class_page(String StaffId) {
mcp.searchInput_staffID(StaffId);
	}

	@Then("Displays entries with that  staff id in manage class page")
	public void displays_entries_with_that_staff_id_in_manage_class_page() {
	mcp.display_staffID();
	}

	@When("Admin enters staff id which is not existing the table into search box {string} in manage class page")
	public void admin_enters_staff_id_which_is_not_existing_the_table_into_search_box_in_manage_class_page(String StaffId) {
		mcp.searchInput_staffID(StaffId);
	}

	@When("Admin enters class date into search box {string} in manage class page")
	public void admin_enters_class_date_into_search_box_in_manage_class_page(String date) {
		mcp.searchInput_classDate(date);
	}

	@Then("Displays entries with that  class date in manage class page")
	public void displays_entries_with_that_class_date_in_manage_class_page() {
		mcp.display_classDate();
	}

	@When("Admin enters invalid class date into search box {string} in manage class page")
	public void admin_enters_invalid_class_date_into_search_box_in_manage_class_page(String date) {
		mcp.searchInput_classDate(date);
		mcp.errorMessage();
		driver.close();
	}
}

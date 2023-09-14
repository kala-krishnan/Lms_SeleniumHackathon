package com.lmsproject.stepdefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.lmsproject.apphooks.Hooks;
import com.lmsproject.pageobjects.UserPage_Pageobject;
import com.lmsproject.utility.CommonWebElements;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class UserPage_Stepdefinitions {
	
	private WebDriver driver;
	UserPage_Pageobject  userPg;
	CommonWebElements common;


	
	private final static Logger LOG = LogManager.getLogger(UserPage_Stepdefinitions.class);

	public UserPage_Stepdefinitions()
	{
		driver = Hooks.getDriver();
		userPg= new UserPage_Pageobject(driver);
		common = new CommonWebElements(driver);
	}
	
	@Given("Admin is on dashboard page after Login")
	public void admin_is_on_dashboard_page_after_login() {
		
		userPg.openLMSPage();
		LOG.info("Admin is on dashboard page");
	    
	}

	@When("Admin clicks {string} from navigation bar")
	public void admin_clicks_from_navigation_bar(String string) {
		
	   //user clicks on "user" option from navigation bar
		userPg.clickUserBtn();

	}

	@Then("Admin should see the {string} in the URL")
	public void admin_should_see_the_in_the_url(String string) {
		
		Assert.assertEquals(userPg.getURLtext(), string);
		LOG.info("Admin is on Manage User page");
		
	}

	@Then("Admin should see the {string} in the header")
	public void admin_should_see_the_in_the_header(String string) {
	   
		//Method to validate Manage user text in header
		Assert.assertEquals(userPg.GetPageHeaderTitle(), string);
		LOG.info("Admin is on Manage Program in the Header");
	}

	@Then("Admin should see the pagination controls under the data table")
	public void admin_should_see_the_pagination_controls_under_the_data_table() {
		
		Assert.assertTrue(common.VerifyPaginationControlsPresent(),"User can see the pagination controls under the data table");
	   
	}

	@Then("Admin Should see the data table with headers Id, Name, location, Phone Number, Edit\\/Delete")
	public void admin_should_see_the_data_table_with_headers_id_name_location_phone_number_edit_delete() {
	    
		Assert.assertTrue(common.IsPageLoaded("User"), " Data table with headers Id, Name, location, Phone Number, Edit and Delete is displayed");
	}

	@Then("Admin should be able to see the {string} icon button that is disabled")
	public void admin_should_be_able_to_see_the_icon_button_that_is_disabled(String string) {
	    
		Assert.assertFalse(userPg.validateDeleteBtnisNotEnabled());
		LOG.info("Verified Multiple delete button disabled on User Page");
	}

	@Then("Admin should be able to see the {string} button")
	public void admin_should_be_able_to_see_the_button(String string) {
		
		Assert.assertTrue(userPg.validateAddNewUserBtn(),"Add New User button is displayed on Manage User Page");
		
		Assert.assertTrue(userPg.validateAssignStaffBtn(),"Assign Staff button is displayed on Manage User Page");
	}

	@Then("Admin should be able to see the search text box")
	public void admin_should_be_able_to_see_the_search_text_box() {
		
		Assert.assertTrue(userPg.validatesearchbox());
		LOG.info("Verified search textbox present on User Page");
		
	}

	@Then("Each row in the data table should have a checkbox")
	public void each_row_in_the_data_table_should_have_a_checkbox() {
	    
		Assert.assertTrue(common.ClickSingleDeleteIcon(1));
		LOG.info("Verified Checkbox present and enabled in table on User Page");
	}

	@Then("Each row in the data table should have a delete icon that is enabled")
	public void each_row_in_the_data_table_should_have_a_delete_icon_that_is_enabled() {
		
		Assert.assertTrue(common.ClickSingleDeleteIcon(1));
		LOG.info("Verified delete button present and enabled in table on User Page");
	}

	@Given("Admin is on dashboard page after Login and Admin clicks {string} from navigation bar")
	public void admin_is_on_dashboard_page_after_login_and_admin_clicks_from_navigation_bar(String string) {
	    
	}

	@When("Admin clicks {string} button")
	public void admin_clicks_button(String string) {
		
		userPg.clickAddNewUser();
		LOG.info("Verified click on Add New User button on User Page");
	    
	}

	@Then("A new pop up with User details appear")
	public void a_new_pop_up_with_user_details_appear() {
		
		Assert.assertTrue(userPg.isUserDetailBoxVisible(), "User details pop up is displayed");
	   
	}

	@Given("A new pop up with user details appears")
	public void a_new_pop_up_with_user_details_appears() {
	    
	}

	@Then("The pop up should include the fields First Name,Middle name, Last Name, Location phone, email,linkedin Url,Undergraduate,postgraduate,time zone and user comments as text box User Role, Role status, visa status as drop down\"")
	public void the_pop_up_should_include_the_fields_first_name_middle_name_last_name_location_phone_email_linkedin_url_undergraduate_postgraduate_time_zone_and_user_comments_as_text_box_user_role_role_status_visa_status_as_drop_down() {
	   
	}

	@When("Fill in all the fields except optional fields with valid values and click submit")
	public void fill_in_all_the_fields_except_optional_fields_with_valid_values_and_click_submit() {
	    
	}

	@Then("The newly added user should be present in the data table in Manage User page")
	public void the_newly_added_user_should_be_present_in_the_data_table_in_manage_user_page() {
	    
	}

	@When("Fill in all the fields with valid values and click submit")
	public void fill_in_all_the_fields_with_valid_values_and_click_submit() {
		
		
	    
	}
	
	@Then("The newly added user should be present in the data table in Manage User page")
	public void the_newly_added_user_should_be_present_in_the_data_table_in_manage_user_pagee() {
		
	    //userPg.validateDeletedAddedUsersuccess("user");
	}

	@When("any of the fields have invalid values")
	public void any_of_the_fields_have_invalid_values() {
	    
	}

	@Then("Error message should appear")
	public void error_message_should_appear() {
	    
	}

	@When("Any of the mandatory fields are blank")
	public void any_of_the_mandatory_fields_are_blank() {
	    
	}
	
	@Then("Error message should appear")
	public void error_message_shld_appear() {
		
	    
	}

	@Given("The edit icon on row level in data table is enabled")
	public void the_edit_icon_on_row_level_in_data_table_is_enabled() {
	    
	}

	@When("Admin clicks the edit icon")
	public void admin_clicks_the_edit_icon() {
		
	    common.ClickSingleEditButton(1);
	}
	
	@Then("A new pop up with User detail appears")
	public void a_new_pop_up_with_user_detail_appears() {
		
		String expectedtitle="User Details";
		Assert.assertEquals(common.GetPageHeaderTitle(),expectedtitle);	   
	}
	

	@Given("Admin clicks the edit icn")
	public void admin_clicks_the_edit_icn() {
	    
	}

	@When("Update the fields with valid values and click submit")
	public void update_the_fields_with_valid_values_and_click_submit() {
		
		  common.ClickSingleEditButton(1);
	}

	@Then("The updated user details should appear on the data table")
	public void the_updated_user_details_should_appear_on_the_data_table() {
		
	   
	}

	@When("Update the fields with invalid values and click submit")
	public void update_the_fields_with_invalid_values_and_click_submit() {
	    
	}

	@When("Erase data from mandatory field")
	public void erase_data_from_mandatory_field() {
	    
	}

	@When("Erase data from description field")
	public void erase_data_from_description_field() {
	   
	}

	@Given("The delete icon on row level in data table is enabled")
	public void the_delete_icon_on_row_level_in_data_table_is_enabled() {
	    
	}

	@When("Admin clicks the delete icon")
	public void admin_clicks_the_delete_icon() {
		
		//userPg.clickDeleteBtn();
	    common.ClickSingleDeleteIcon(1);
	    LOG.info("Admin clicks the delete icon");
	}

	@Then("Alert appears with yes and No option")
	public void alert_appears_with_yes_and_no_option() {
		
		Assert.assertEquals(common.GetDeleteDialogBoxTitle(),"Confirm");
		
	}

	@Given("Admin clicks the delete icn")
	public void admin_clicks_the_delete_icn() {
		
	}

	@When("Admin click yes option")
	public void admin_click_yes_option() {
		
		common.ClickDeleteConfirmation("Yes");
		LOG.info("Admin clicked on Yes button of dete user");
		
	}
	    

	@Then("User deleted alert pops and user is no more available in data table")
	public void user_deleted_alert_pops_and_user_is_no_more_available_in_data_table() {
		 
		Assert.assertEquals(userPg.ClickDeleteUserConfirmation("Yes"), "User Deleted");
			    
	}

	@When("Admin click No option")
	public void admin_click_no_option() {
		
	    userPg.ClickDeleteUserConfirmation("No");
	    LOG.info("Admin clicked on No button of delete user");
	}

	@Then("User is still listed in data table")
	public void user_is_still_listed_in_data_table() {
		
		//Assert.assertTrue(userPg.validateDeletedAddedUsersuccess(),"User is not deleted"); 
	}

	@Given("None of the checkboxes in data table are selected")
	public void none_of_the_checkboxes_in_data_table_are_selected() {		
	    
	}

	@Then("The delete icon under the {string} header should be disabled")
	public void the_delete_icon_under_the_header_should_be_disabled(String string) {

		Assert.assertFalse(common.IsMultiDeleteIconEnabled(),"Delete icon is disabled");
	    
	}
	@Given("One of the checkbox or row is selected")
	public void one_of_the_checkbox_row_is_selected() {
	   
		common.ClickSingleSelectCheckbox(1);
	}

	@When("Click delete icon below {string} header")
	public void click_delete_icon_below_header(String string) {
		
	    common.ClickMultiDeleteIcon();
	}

	@Then("The respective row in the data table is deleted")
	public void the_respective_row_in_the_data_table_is_deleted() {
	    
		//Assert.assertFalse(userPg.validateDeletedAddedUsersuccess("user"),"User sucessfully deleted");
		
	}

	@Given("Two or more checkboxes\\/row is selected")
	public void two_or_more_checkboxes_row_is_selected() {
		//select more than1 checkbox
	   common.ClickMutiSelectCheckBox();
	   //Click on deleteBtn
	   common.ClickMultiDeleteIcon();
	    
	}


}




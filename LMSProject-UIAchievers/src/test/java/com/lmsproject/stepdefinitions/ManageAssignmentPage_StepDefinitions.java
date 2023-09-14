package com.lmsproject.stepdefinitions;
import com.lmsproject.apphooks.Hooks;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import org.testng.log4testng.Logger;

import com.lmsproject.pageobjects.ManageAssignment_Pageobject;
import com.lmsproject.utility.CommonWebElements;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class ManageAssignmentPage_StepDefinitions {

	SoftAssert sa= new SoftAssert();
	ManageAssignment_Pageobject mp;
	CommonWebElements cm;
	 WebDriver driver;
	private static final Logger LOG=Logger.getLogger(ManageAssignmentPage_StepDefinitions.class);      
	public ManageAssignmentPage_StepDefinitions()
	{
		driver=Hooks.getDriver();
		 mp =new ManageAssignment_Pageobject(driver);
		cm=new CommonWebElements(driver);
	}
	@Given("Admin is on login page")
	public void admin_is_on_login_page() {
	  mp.urllaunch();
	  LOG.info("Admin is in login page");
	}

	@When("Enter valid credentials {string}{string}")
	public void enter_valid_credentials(String string, String string2) {
	    mp.logincredentials(string, string2);
	}

	@Then("successfully logged in LMSportal")
	public void successfully_logged_in_lm_sportal() {
	    String mesg=mp.successportal();
	    sa.assertEquals("launch",mesg);
	}

	@Given("Admin is on dashboard page after Login")
	public void admin_is_on_dashboard_page_after_login() {
	    mp.dashboardurl();
	    LOG.info("Admin is in Dashboard page");
	}

	@When("Admin clicks {string} button on the navigation bar")
	public void admin_clicks_button_on_the_navigation_bar(String string) {
	   mp.clickassign(string);
	}

	@Then("Admin should see URL with {string}")
	public void admin_should_see_url_with(String string) {
	    boolean act=mp.urlhaving();
	    sa.assertEquals(true,act);
	}

	@Then("Get the response time for navigation from dashboard page to manage assignment page")
	public void get_the_response_time_for_navigation_from_dashboard_page_to_manage_assignment_page() {
	    mp.responsetime();
	}

	@Then("Admin should see header with {string}")
	public void admin_should_see_header_with(String string) {
	    String actheader=mp.titleheader();
	    sa.assertEquals(string,actheader);
	}

	@When("Admin clicks {string} button on the navigation bar and get all text from the portal page")
	public void admin_clicks_button_on_the_navigation_bar_and_get_all_text_from_the_portal_page(String string) {
	    mp.clickbutton(string);
	}

	@Then("Admin should see correct spelling for the all the fields")
	public void admin_should_see_correct_spelling_for_the_all_the_fields() {
	    mp.correctspell();//in the report it takes the screenshot of the result where mistakes can be seen
	}

	@Then("Admin should see disabled delete icon below the {string}")
	public void admin_should_see_disabled_delete_icon_below_the(String string) {
	    boolean actdelbutton=mp.mulitpleDelete();
	    sa.assertEquals(true,actdelbutton);
	}

	@Then("Admin should see search bar on the manage assignment page")
	public void admin_should_see_search_bar_on_the_manage_assignment_page() {
	   boolean search=mp.searchbar();
	   sa.assertEquals(true,search);
	}

	@Then("Admin should see +Add New assignment button on the manage assignment page")
	public void admin_should_see_add_new_assignment_button_on_the_manage_assignment_page() {
	    boolean addnew=mp.addnew();
	    sa.assertEquals(true, addnew);
	}

	@Then("Admin should see data table on the manage {string} page With following column headers")
	public void admin_should_see_data_table_on_the_manage_page_with_following_column_headers(String string) {
	 boolean val=mp.columnheaders(string);
	 sa.assertEquals(false,val);
	}

	@Then("Edit Icon in each row of data table only  when entries are available")
	public void edit_icon_in_each_row_of_data_table_only_when_entries_are_available() {
	  mp.tabledata();
	  cm.ClickSingleEditButton(0);
	  
	}

	@Then("Edit Icon will not be present in data table")
	public void edit_icon_will_not_be_present_in_data_table() {
	 mp.tabledata();   
	}

	@Then("Delete Icon in each row of data table only  when entries are available")
	public void delete_icon_in_each_row_of_data_table_only_when_entries_are_available() {
	  cm.IsMultiDeleteIconEnabled();
	}

	@Then("Delete Icon will not be present in data table")
	public void delete_icon_will_not_be_present_in_data_table() {
	    mp.tabledata();
	}

	@Then("Admin should see sort icon near the column headers except for Edit and Delete")
	public void admin_should_see_sort_icon_near_the_column_headers_except_for_edit_and_delete() {
	 
	   boolean as=mp.chkbox();
	   sa.assertEquals(true,as);
	}

	@Then("Admin should see check box in the all rows  of data table when entries available")
	public void admin_should_see_check_box_in_the_all_rows_of_data_table_when_entries_available() {
		  cm.ClickMutiSelectCheckBox();
	}

	@Then("Admin should see the pagination controls under the data table")
	public void admin_should_see_the_pagination_controls_under_the_data_table() {
	   cm.VerifyPaginationControlsPresent();
	}

	@Then("Admin should see the text with total number assignments in the data table.")
	public void admin_should_see_the_text_with_total_number_assignments_in_the_data_table() {
		 cm.GetPaginationShowEntries();
	}
	@Then("Above the footer Admin should see the text as {string}")
	public void above_the_footer_admin_should_see_the_text_as(String string) {
	   cm.ValidateFooterText(mp.lblPaginationEntries, string);
	}

@Given("Admin is on manage assignment page")
public void admin_is_on_manage_assignment_page() {
   mp.urllaunch();
}

@When("Admin enters assignment name into search box")
public void admin_enters_assignment_name_into_search_box() {
	 mp.entries("assignment");  
}

@Then("Displays entries with that assignment name")
public void displays_entries_with_that_assignment_name() {
    mp.displaysdata();
}

@When("Admin enters assignment  name is not existing the table into search box")
public void admin_enters_assignment_name_is_not_existing_the_table_into_search_box() {
 mp.entries("assignment");  
}

@Then("Displays empty details in the data table")
public void displays_empty_details_in_the_data_table() {
    mp.tabledata();
}

@When("Admin enters assignment description into search box")
public void admin_enters_assignment_description_into_search_box() {
  mp.entries("assignment description");
}

@Then("Displays entries with that assignment description")
public void displays_entries_with_that_assignment_description() {
   mp.tabledata();
}

@When("Admin enters assignment description which is not existing the table into search box")
public void admin_enters_assignment_description_which_is_not_existing_the_table_into_search_box() {
   mp.entries("assignment description");
}

@When("Admin enters assignment due date into search box")
public void admin_enters_assignment_due_date_into_search_box() {
  mp.entries("due date");
}

@Then("Displays entries with that assignment due date")
public void displays_entries_with_that_assignment_due_date() {
 mp.displaysdata();   
}

@When("Admin enters assignment due date which is not existing the table into search box")
public void admin_enters_assignment_due_date_which_is_not_existing_the_table_into_search_box() {
   mp.entries("due data");
}

@When("Admin enters grade value  into search box")
public void admin_enters_grade_value_into_search_box() {
 mp.entries("grade value");  
}

@Then("Displays entries with that assignment  grade")
public void displays_entries_with_that_assignment_grade() {
   mp.displaysdata();
}

@When("Admin enters grade value which is not existing the table into search box")
public void admin_enters_grade_value_which_is_not_existing_the_table_into_search_box() {
   mp.entries("grade");
}

@When("Admin click +Add new assignment button")
public void admin_click_add_new_assignment_button() {
  mp.addnewclick();
}

@Then("Admin should see a popup  with  heading {string}")
public void admin_should_see_a_popup_with_heading(String string) {
    String val=mp.assignmentPopUp(string);
    sa.assertEquals(string,val);
}

@Then("Admin should see input {string}")
public void admin_should_see_input(String string) {
    mp.Getfields(string);
}


@Then("{int} textbox should be  present in Assignment details popup window")
public void textbox_should_be_present_in_assignment_details_popup_window(Integer int1) {
   int total=mp.totalfields();
   sa.assertEquals(int1,total);
}

@Then("Admin should see  dropdown option for Batch Number")
public void admin_should_see_dropdown_option_for_batch_number() {
   boolean actual=mp.dropdown();
   sa.assertEquals(true, actual);
}

@Then("Admin should see  dropdown option for Program name")
public void admin_should_see_dropdown_option_for_program_name() {
	boolean actual=mp.dropdownforprog();
	   sa.assertEquals(true, actual);
}

@Then("Admin should see  calendar icon for assignment due date")
public void admin_should_see_calendar_icon_for_assignment_due_date() {
	boolean actual=mp.calendaricon();
	   sa.assertEquals(true, actual);
}

@Then("Admin should see  save button in the Assignment detail popup window")
public void admin_should_see_save_button_in_the_assignment_detail_popup_window() {
	boolean actual=mp.savebutton();
	   sa.assertEquals(true, actual);
}

@Then("Admin should see  cancel button in the Assignment detail popup window")
public void admin_should_see_cancel_button_in_the_assignment_detail_popup_window() {
	boolean actual=mp.cancelbutton();
	   sa.assertEquals(true, actual);
}

@Then("Admin should see  close button on the Assignment details popup windows")
public void admin_should_see_close_button_on_the_assignment_details_popup_windows() {
	boolean actual=mp.close();
	   sa.assertEquals(true, actual);
}
}

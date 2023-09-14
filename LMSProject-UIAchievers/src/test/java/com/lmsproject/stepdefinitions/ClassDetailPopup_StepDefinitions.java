package com.lmsproject.stepdefinitions;
	 
	import java.util.logging.Logger;
	import org.apache.logging.log4j.LogManager;
	import org.openqa.selenium.WebDriver;
	import com.lmsproject.apphooks.Hooks;
    import com.lmsproject.pageobjects.ClassDetailPopup_Pageobject;
    import io.cucumber.java.en.Given;
	import io.cucumber.java.en.Then;
	import io.cucumber.java.en.When;

	public class ClassDetailPopup_StepDefinitions {
		
		ClassDetailPopup_Pageobject claspage;
		private WebDriver driver;
		
		private static final Logger LOG = (Logger) LogManager.getLogger(ClassDetailPopup_StepDefinitions.class);

		public ClassDetailPopup_StepDefinitions() {
			driver = Hooks.getDriver();
			claspage = new ClassDetailPopup_Pageobject(driver);
			driver.close();
		}
//		#@VerifyClassPopWindow
		@Given("Admin is on Manage Class Page to validate class detail")
		public void admin_is_on_manage_class_page_to_validate_class_detail() 
			{
				claspage.webpage();
			}
		@When("Admin Click +Add New Class button")
		public void admin_click_add_new_class_button() {
		 
		claspage.ClickOnCLassButton();
			claspage.ClickOnNewClassButton();
		}

		@Then("Admin should see a popup with heading class details")
		public void admin_should_see_a_popup_with_heading_class_details() {
	       claspage.GetAllText();
		}
//		#@VerifyInputFields
		@When("Admin Click +Add New class button1")
		public void admin_click_add_new_class_button1() 
		 {
			claspage.ClickOnNewClassButton();
		}
		@Then("Admin should see input fields Text \\(Batch ID , No of Classes, Class Date, Class Topic, Staff Id, Class description, Comments, Notes, Recordings)")
		public void admin_should_see_input_fields_text_batch_id_no_of_classes_class_date_class_topic_staff_id_class_description_comments_notes_recordings()
		{
	      claspage.verifyVisibilityOfAllElements();
		    LOG.info("Checking all the elements");
		}
//		#@VerifyTextBox
		@Then("{int} textbox should be present in Class details popup window")
		public void textbox_should_be_present_in_class_details_popup_window(Integer int1) {
		     claspage.CHeckOnAllTextBox();
		}
//		#@VerifyDropDownInBatchId
		@Then("Admin should see Dropdown option for Batch ID in class details popup window")
		public void admin_should_see_dropdown_option_for_batch_id_in_class_details_popup_window() {
	 	claspage.CheckOnDropDown();
		     
		}
//		#@VerifyDropDownInStaffId
		@Then("Admin should see Dropdown option for Staff Id in class details popup window")
		public void admin_should_see_dropdown_option_for_staff_id_in_class_details_popup_window() {
	   claspage.CheckOnDropDown2();
		}
//		#@VerifyCalendarIcon
		@Then("Admin should see Calendar icon for class date in class details popup window")
		public void admin_should_see_calendar_icon_for_class_date_in_class_details_popup_window() {
	    claspage.CheckOnCalendar();
		}
		
		@Then("Admin should see {string} button in the class detail Popup window")
		public void admin_should_see_button_in_the_class_detail_popup_window(String string) {
		 
		 claspage.addSaveConfirm(string);
		}
//		#@VerifycancelButton
		@Then("Admin should see {string} button in the class detail popup window1")
		public void admin_should_see_button_in_the_class_detail_popup_window1(String string) 
		{
			claspage.addCancelConfirm(string);
		}
//		#@VerifyCloseButton
		@Then("Admin should see Close button on the class details popup window")
		public void admin_should_see_close_button_on_the_class_details_popup_window() {
		     claspage.CheckOncloseButton();
		     
		}


	}

}

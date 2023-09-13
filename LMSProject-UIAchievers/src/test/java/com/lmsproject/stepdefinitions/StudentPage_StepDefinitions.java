package com.lmsproject.stepdefinitions;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.lmsproject.apphooks.Hooks;
import com.lmsproject.pageobjects.StudentPage_Pageobject;

import io.cucumber.java.en.*;


public class StudentPage_StepDefinitions {
	StudentPage_Pageobject sp; 
	private WebDriver driver;
	public WebElement studentNameDropdown;
	public WebElement batchIdDropdown;
	public WebElement allStartWithX;
	public StudentPage_StepDefinitions ()
	{
		driver = Hooks.getDriver();
		 sp=new StudentPage_Pageobject(driver);
		
	}
	@Given("Admin is on dashboard page after Login.")
	public void admin_is_on_dashboard_page_after_login() {
	    sp.dash();
	}

	@When("Admin clicks {string} on the navigation bar.")
	public void admin_clicks_on_the_navigation_bar(String string) {
	    sp.student_btn();
	}

	@Then("Admin should see the Student details Page Title")
	public void admin_should_see_the_student_details_page_title() {
		String actual=sp.pgtitle();
		  
	    Assert.assertEquals("welcometostudentpage",actual);
	    driver.close();
	}
	
	//2
	@Then("Maximum navigation time in milliseconds, defaults to {int} seconds")
	public void maximum_navigation_time_in_milliseconds_defaults_to_seconds(Integer int1) {
	    sp.timeout();
	}
	
	//3
	@Then("HTTP response >= {int}. Then the link is broken.")
	public void http_response_then_the_link_is_broken(Integer int1) throws IOException {
		//int1=404;
		   sp.broken_link();
		   Assert.assertEquals(int1,sp.code);
	}

//4
	@Then("Admin should see LMS -Learning management system  as title")
	public void admin_should_see_lms_learning_management_system_as_title() {
		String actual=sp.pgtitle();
		  
	    Assert.assertEquals("Learning management system",actual);
	    driver.close();
	    
	}
	//5
	@Then("Student Detail title should be in centre of the page")
	public void student_detail_title_should_be_in_centre_of_the_page() {
	    sp.element_align();
	}
	//6
	@Then("{int} dropdowns should be present in the page")
	public void dropdowns_should_be_present_in_the_page(Integer int1) {
	   sp.dropdown();
	}
	//7
	@Then("Admin should see search box inside the drop down")
	public void admin_should_see_search_box_inside_the_drop_down() {
	    sp.searchBox("studentName");
	}
	
	//8
	@Then("Admin should see search box inside  batch id drop down")
	public void admin_should_see_search_box_inside_batch_id_drop_down() {
		sp.searchBox("batchId");
	}
	
	//9
	@Then("Admin should see correct spelling select student name")
	public void admin_should_see_correct_spelling_select_student_name() {
	    sp.studentSearch("studentName","searchInputStudent");
	}
	
	//10
	@Then("Admin should see correct spelling select  batch id")
	public void admin_should_see_correct_spelling_select_batch_id(){
	    sp.studentSearch("batchId","searchInputBatchId");
	}
	//11
	@Then("Admin should see only numbers inside batch id drop down")
	public void admin_should_see_only_numbers_inside_batch_id_drop_down() {
	    sp.batchIdDropdownn();
	}
	//12
	@Then("Admin should see select student name in gray color")
	public void admin_should_see_select_student_name_in_gray_color() {
	   sp.studentNameColor("studentName","searchInputStudent");
	}
//13
	@Then("Admin should see select batch ID in gray color")
	public void admin_should_see_select_batch_id_in_gray_color() {
	    sp.studentNameColor("batchId","searchInputBatchId");
	}
//14
	@Then("Admin should see select student name in first")
	public void admin_should_see_select_student_name_in_first() {
	    sp.studentNameAsTheFirstOption();
	    
	}
//15
	@Then("Admin should see select batch id in second")
	public void admin_should_see_select_batch_id_in_second() {
	   
	    sp.batchIDAsSecondOption();
	}
	//16
	@Then("Admin should able to scroll down to select the name")
	public void admin_should_able_to_scroll_down_to_select_the_name() {
	    sp.ableToScrollAndSelectStudentNmae();
	    Assert.assertTrue(studentNameDropdown.isDisplayed());
	}
//17
	@Then("Admin should able to scroll down to select the batch id")
	public void admin_should_able_to_scroll_down_to_select_the_batch_id() {
		 sp.ableToScrollAndSelectStudentNmae();
		    Assert.assertTrue(batchIdDropdown.isDisplayed());
	}

//18
	@Given("Admin is on student details page")
	public void admin_is_on_student_details_page() {
	    sp.studentPage();
	}

	@When("Admin select student name from the drop down")
	public void admin_select_student_name_from_the_drop_down() {
	    sp.selectStudentFromDropdown();
	}

	@Then("Admin shouldn't see select student name text")
	public void admin_shouldn_t_see_select_student_name_text() {
	  sp.selectStudentFromDropdown();
	  Select select = new Select(studentNameDropdown);
	  WebElement st = select.getFirstSelectedOption();
		String stuName=st.getText(); 
		String actualName="xxxx";
		Assert.assertEquals(stuName,actualName);
	}
	//19
	@When("Admin select batch id from the drop down")
	public void admin_select_batch_id_from_the_drop_down() {
	    sp.selectBatchFromDropdown();
	}

	@Then("Admin shouldn't see select batch id text")
	public void admin_shouldn_t_see_select_batch_id_text() {
		sp.selectBatchFromDropdown();
		  Select select = new Select(batchIdDropdown);
		  WebElement st = select.getFirstSelectedOption();
			String bId=st.getText(); 
			String actualName="xxxx";
			Assert.assertEquals(bId,actualName);
	}
	//20

@When("Admin clicks select student name and  enters x alphabet in the search box")
public void admin_clicks_select_student_name_and_enters_x_alphabet_in_the_search_box() {
    sp.studentSearchBox();
}

@Then("Admin should see student name start with x is listed below")
public void admin_should_see_student_name_start_with_x_is_listed_below() {
	Assert.assertTrue(sp.studentSearchBox());

    // Close the WebDriver when done
    driver.quit();
}
//21
@When("Admin  clicks select batch id and enter x number in the search box")
public void admin_clicks_select_batch_id_and_enter_x_number_in_the_search_box() {
    sp.batchSearchBox();
}

@Then("Admin should see batch id start with x is listed below")
public void admin_should_see_batch_id_start_with_x_is_listed_below() {
	Assert.assertTrue(sp.batchSearchBox());

    // Close the WebDriver when done
    driver.quit();
}
//22
@When("Admin selects only student name")
public void admin_selects_only_student_name() {
    sp.selectedStudentNameOnly();
  
}

@Then("Student details shouldn't be displayed")
public void student_details_shouldn_t_be_displayed() {
   Assert.assertNull(sp.selectedStudentNameOnly());
}
//23
@When("Admin selects only  batch id")
public void admin_selects_only_batch_id() {
    sp.selectedBatchIdOnly();
}
@Then("batchid details shouldn't be displayed")
public void batchid_details_shouldn_t_be_displayed() {
    Assert.assertNull(sp.selectedBatchIdOnly());
}
//24
@When("Admin selects  student name and batch id")
public void admin_selects_student_name_and_batch_id() {
	sp.studentNameAndBatchIdSelected();
}

@Then("Particular student informations should be display")
public void particular_student_informations_should_be_display() {
    Assert.assertEquals(sp.selectedStudentNameOnly(), sp.selectedBatchIdOnly());
}


}




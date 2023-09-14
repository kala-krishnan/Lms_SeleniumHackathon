package com.lmsproject.stepdefinitions;

import java.util.logging.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import com.lmsproject.apphooks.Hooks;
import com.lmsproject.pageobjects.SortFunction_Pageobject;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class SortClass_StepDefinitions {
	
	SortFunction_Pageobject sortobj;
	private WebDriver driver;
 
//	private static final Logger LOG = (Logger) LogManager.getLogger(Class07_SortFunction_stepdef.class);

	public SortClass_StepDefinitions()
	{
		driver = Hooks.getDriver();
		sortobj = new SortFunction_Pageobject (driver);
//		driver.close();
	}
	
	@Given("Admin is in manage Class page")
	public void admin_is_in_manage_class_page() {
		sortobj.webpage();
		sortobj.ClickOnClass();
	    sortobj.ClickOnManageClassLink();
	}
	@When("Admin click on Batch id column header to sort in class page")
	public void admin_click_on_batch_id_column_header_to_sort_in_class_page() {
	     sortobj.ClickOnBatchIcon();
	}

	@Then("Admin should see data table sorted in descending order in {string} page")
	public void admin_should_see_data_table_sorted_in_descending_order_in_page(String string) {
	 sortobj.GetSortedDscOrder(string);
	}

	@When("Admin double click on Batch id column header to sort in class page")
	public void admin_double_click_on_batch_id_column_header_to_sort_in_class_page() {
	     sortobj.ClickOnBatchIcon();
	}

	@Then("Admin should see data table sorted in ascending  order in {string} page")
	public void admin_should_see_data_table_sorted_in_ascending_order_in_page(String string) {
	   sortobj.GetSortedAscOrder(string);
	}


}

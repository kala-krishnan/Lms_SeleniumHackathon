package com.lmsproject.stepdefinitions;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.lmsproject.apphooks.Hooks;
import com.lmsproject.pageobjects.LoginPage_Pageobject;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPage_StepDefinitions {
	
	private WebDriver driver;
	LoginPage_Pageobject loginPag;
	String pageTitle = "";
	String actualErrorMessage = "";
	String successMessage ="";
	String actualNameText = "User";
	String actualPasswordText = "Password";
	String actualText = "";
	boolean checkFields;
	
	HashMap<String,String> loginTextMap = new HashMap<String,String>();
	public LoginPage_StepDefinitions()
	{
		driver = Hooks.getDriver();
		loginPag = new LoginPage_Pageobject(driver);
		
	}
	@Given("The admin is in Home page")
	public void the_admin_is_in_home_page() {
		loginPag.openLMSPage();
	}
	@When("The admin clicks on the Login link")
	public void the_admin_clicks_on_the_login_link() {
		pageTitle=loginPag.clickloginAuth();
	}
	@Then("The admin should landed on LMS Login Page {string}")
	public void the_admin_should_landed_on_lms_login_page(String string) {
		Assert.assertEquals(pageTitle, string);
	}
	
	@Then("The admin gets the errorMessage {string} when the response is >={int}")
	public void the_admin_gets_the_error_message_when_the_response_is(String string, Integer int1) {
		actualErrorMessage=loginPag.verifyURLNotBroken(int1);
		Assert.assertEquals(actualErrorMessage, string);
	
	}
	@Then("The admin gets the Message {string}")
	public void the_admin_gets_the_message(String string) {
		successMessage=loginPag.verifyHeader();
		Assert.assertEquals(successMessage, string);
	
	}
	@Then("The admin should see the correct spellings in all fields")
	public void the_admin_should_see_the_correct_spellings_in_all_fields() {
		loginTextMap = loginPag.VerifyFieldText();
		Assert.assertEquals(loginTextMap.get("ExpUserText"),actualNameText );
		Assert.assertEquals(loginTextMap.get("ExppasswordText"),actualPasswordText );
	}
	@Then("The admin should see the two text fields")
	public void the_admin_should_see_the_two_text_fields() {

		checkFields = loginPag.verifyFields();
		Assert.assertTrue(checkFields);
	}
	@Then("The admin should see {string} in the first text field")
	public void the_admin_should_see_in_the_first_text_field(String string) {
		
		actualText = loginPag.verifyUserPlaceHolder();
		Assert.assertEquals(actualText, string);
	}
	@Then("The admin should see {string} symbol next to user text")
	public void the_admin_should_see_symbol_next_to_user_text(String string) {

		actualText = loginPag.verifyUserAsterick() ;
		Assert.assertEquals(actualText, string);
	}
	@Then("The admin should see {string} in the second text field")
	public void the_admin_should_see_in_the_second_text_field(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Then("The admin should see {string} symbol next to password text")
	public void the_admin_should_see_symbol_next_to_password_text(String string) {

		actualText = loginPag.verifyPasswordAsterick() ;
		Assert.assertEquals(actualText, string);
	}
	@Then("The admin should see the input field on the center of the page")
	public void the_admin_should_see_the_input_field_on_the_center_of_the_page() {
		checkFields = loginPag.verifyFieldsAlignment();
		Assert.assertTrue(checkFields);
	}
	@Then("The admin should see login button")
	public void the_admin_should_see_login_button() {
		
		checkFields = loginPag.verifyLoginButton();
		Assert.assertTrue(checkFields);
	}
	@Then("The admin should see login button on the center of the page")
	public void the_admin_should_see_login_button_on_the_center_of_the_page() {
		checkFields = loginPag.verifyButtonAlignment();
		Assert.assertTrue(checkFields);
	}
	@Then("The admin should see forget username or password link")
	public void the_admin_should_see_forget_username_or_password_link() {
		checkFields = loginPag.verifyforgotPassword();
		Assert.assertTrue(checkFields);
	}
	@Then("The admin should see reset password link")
	public void the_admin_should_see_reset_password_link() {
		checkFields = loginPag.verifyresetPassword();
		Assert.assertTrue(checkFields);
	}
	@Then("The admin should see user in gray {string} scolor")
	public void the_admin_should_see_user_in_gray_scolor(String string) {
		actualText=loginPag.verifyColor();
		Assert.assertEquals(actualText, string);
	}
	@Then("The admin should see password in gray {string} color")
	public void the_admin_should_see_password_in_gray_color(String string) {
		actualText=loginPag.verifyPasswordColor();
		Assert.assertEquals(actualText, string);
	}
	@Given("The admin is in login page")
	public void the_admin_is_in_login_page() {
		loginPag.landLoginPage();
	}
	@When("The admin enter valid credentials and clicks login button")
	public void the_admin_enter_valid_credentials_and_clicks_login_button(List<String> data) {
		loginPag.loginUsingValidDetails(data.get(0),data.get(1));
	}

	@Then("The admin should land on dashboard page with the message {string}")
	public void the_admin_should_land_on_dashboard_page_with_the_message(String string) {
		successMessage=loginPag.getSuccessMessage();
		Assert.assertEquals(actualErrorMessage,string );
	}
	@When("The admin enters {string}, {string} and clicks the login button")
	public void the_admin_enters_and_clicks_the_login_button(String string, String string2) {
		loginPag.validateUserandPassword(string,string2);
	}
	@Then("the admin should see the error message indicating {string}")
	public void the_admin_should_see_the_error_message_indicating(String string) {
		actualErrorMessage = loginPag.geterrorMessage();
		Assert.assertEquals(actualErrorMessage,string );
	}
	@When("The admin enter valid credentials and clicks login button through keyboard")
	public void the_admin_enter_valid_credentials_and_clicks_login_button_through_keyboard(List<String> data) {
		loginPag.loginUsingKeyboard(data.get(0),data.get(1));
	}

	@When("The admin enter valid credentials and clicks login button through mouse")
	public void the_admin_enter_valid_credentials_and_clicks_login_button_through_mouse(List<String> data) {
		loginPag.loginUsingValidDetails(data.get(0),data.get(1));
	}


}

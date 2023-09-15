package com.lmsproject.stepdefinitions;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import org.testng.log4testng.Logger;

import com.lmsproject.apphooks.TestContext;
import com.lmsproject.pageobjects.AddOrEditProgramPage_Pageobject;
import com.lmsproject.pageobjects.BatchPage_Pageobject;
import com.lmsproject.pageobjects.DashboardPage_Pageobject;
import com.lmsproject.pageobjects.HomePage_Pageobject;
import com.lmsproject.pageobjects.LoginPage_Pageobject;
import com.lmsproject.pageobjects.ProgramPage_Pageobject;
import com.lmsproject.utility.CommonWebElements;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ForgotPasswordPage_StepDefinitions {
	WebDriver driver;
	TestContext testContext;
	DashboardPage_Pageobject dashBoardPage;
	HomePage_Pageobject homePage;
	LoginPage_Pageobject loginPag;
	ProgramPage_Pageobject programPage;
	CommonWebElements commonElement;
	AddOrEditProgramPage_Pageobject addOrEditProgramPage;
	com.lmsproject.pageobjects.ForgotUsernameOrPasswordPage_Pageobject forgotPasswordOrUsernamePage;

	String pageTitle = "";
	String actualErrorMessage = "";
	String successMessage = "";
	String actualEmailText = "Email";
	
	String actualText = "";
	boolean checkFields;
	String username;
	String password;

	String pageHeading;
	boolean checkHeaders;
	int checkBoxIdx;
	String successMsg;

	private static final Logger LOG = Logger.getLogger(ForgotPasswordPage_StepDefinitions.class);
	HashMap<String, String> forgotUsernameOrPasswordTextMap = new HashMap<String, String>();

	public ForgotPasswordPage_StepDefinitions(TestContext context) {

		this.testContext = context;
		homePage = testContext.getPageObjectManager().getHomePage();
		loginPag = testContext.getPageObjectManager().getLoginPage();
		dashBoardPage = testContext.getPageObjectManager().getdashboardPage();
		commonElement = testContext.getCommonElement();
		forgotPasswordOrUsernamePage = testContext.getPageObjectManager().getForgotUsernameOrPasswordPage();

	}

	SoftAssert sa = new SoftAssert();

	@Given("Admin is in login page")
	public void admin_is_in_login_page() {

		forgotPasswordOrUsernamePage.landLoginPage();
	}

	@When("Admin click login button in home page")
	public void admin_click_login_button_in_home_page() {

		forgotPasswordOrUsernamePage.clickloginAuth();
	}

	@Then("verify admin is on {string}")
	public void verify_admin_is_on(String PageTitle) {

		Assert.assertEquals(pageTitle, PageTitle);
		// or
		successMessage = loginPag.verifyHeader();
		Assert.assertEquals(successMessage, PageTitle);
	}

	@When("Admin clicks forgot username or password link")
	public void admin_clicks_forgot_username_or_password_link() {

		checkFields = loginPag.verifyforgotPassword();
		Assert.assertTrue(checkFields);
	}

	@Then("Admin should land on forgot username or password page")
	public void admin_should_land_on_forgot_username_or_password_page() {

//		Assert.assertTrue(dashBoardPage.pagetitle());
		LOG.info("Verified Admin lands on forgot username or password page");

	}

	@Then("HTTP response >= {int}. Then the link is broken")
	public void http_response_then_the_link_is_broken(int int1) {

		actualErrorMessage = forgotPasswordOrUsernamePage.verifyURLNotBroken(int1);
		Assert.assertEquals(actualErrorMessage, int1);
	}

	@Then("Admin should see {string} text in gray color")
	public void admin_clicks_forgot_username_or_password_link_admin_should_see_text_in_gray_color(String string) {

		forgotPasswordOrUsernamePage.verifyColor();
	}

	@Then("Admin should see {string} in text field")
	public void admin_clicks_forgot_username_or_password_link_admin_should_see_in_text_field(String string) {

		actualText = forgotPasswordOrUsernamePage.verifyColor();
		Assert.assertEquals(actualText, string);
	}

	@Then("Admin should see {string}  button")
	public void admin_should_see_button(String string) {

		Assert.assertTrue(forgotPasswordOrUsernamePage.verifySendlinkbutton());
	}

	@Then("Admin should see asterik symbol need Email")
	public void Admin_should_see_asterik_symbol_need_email() {

		forgotPasswordOrUsernamePage.verifyEmailAsterick();
	}
	@Then("Admin should see correct spellings in all fields in forgot password page")
	public void admin_should_see_correct_spellings_in_all_fields_in_forgot_password_page() {
		
		forgotUsernameOrPasswordTextMap = forgotPasswordOrUsernamePage.VerifyFieldText();
		Assert.assertEquals(forgotUsernameOrPasswordTextMap.get("Email"), actualEmailText);
		
	}

	@Then("Admin should see send link button in center of the forgot username or password page")
	public void admin_should_see_send_link_button_in_center_of_the_forgot_username_or_password_page() {
		
		checkFields = forgotPasswordOrUsernamePage.verifyFieldsAlignment();
		Assert.assertTrue(checkFields);
	}

//***********************forgot password2.feature*****************//

	@Given("Admin is in forgot username and password page")
	public void admin_is_in_forgot_username_and_password_page() {

		forgotPasswordOrUsernamePage.landLoginPage();
	}

	@Then("Admin is in forgot username or password page")
	public void admin_is_in_forgot_username_or_password_page() {
		forgotPasswordOrUsernamePage.verifyHeader();
	}

	@Then("Admin should receive link in mail for reset username or password'Email sent successfully'{string}")
	public void admin_should_receive_link_in_mail_for_reset_username_or_password_email_sent_successfully(
			String string) {

		Assert.assertTrue(forgotPasswordOrUsernamePage.verifysendLink());
		successMessage = forgotPasswordOrUsernamePage.getSuccessMessage();
		Assert.assertEquals(actualErrorMessage, string);
	}

	@When("Admin enters valid {string} and clicks send link button {string}")
	public void admin_enters_valid_and_clicks_send_link_button(String mail, String message) {

		forgotPasswordOrUsernamePage.verifysendLink();
		successMessage = forgotPasswordOrUsernamePage.getSuccessMessage();
		Assert.assertEquals(actualErrorMessage, message);
	}

	@Then("Admin sends link in mail for reset username or password")
	public void admin_sends_link_in_mail_for_reset_username_or_password() {
		{

			forgotPasswordOrUsernamePage.verifysendLink();

		}

	}
}
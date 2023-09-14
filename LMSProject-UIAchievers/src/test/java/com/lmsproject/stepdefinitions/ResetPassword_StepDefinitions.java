package com.lmsproject.stepdefinitions;

import java.util.HashMap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.lmsproject.apphooks.Hooks;
import com.lmsproject.pageobjects.LoginPage_Pageobject;
import com.lmsproject.pageobjects.ResetPasswordPage_Pageobject;
import com.lmsproject.utility.CommonWebElements;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ResetPassword_StepDefinitions {
	private WebDriver driver;
	LoginPage_Pageobject loginPag;
	ResetPasswordPage_Pageobject resetPasswordPage;
	CommonWebElements commonElement;
	String pageTitle = "";
	String actualErrorMessage = "";
	String successMessage = "";
	String actualNameText = "User";
	String actualPasswordText = "Password";
	String actualText = "";
	boolean checkFields;
	private final static Logger LOG = LogManager.getLogger(ResetPasswordPage_Pageobject.class);
	HashMap<String, String> resetPasswordTextMap = new HashMap<String, String>();

	public ResetPassword_StepDefinitions() {
		driver = Hooks.getDriver();
		loginPag = new LoginPage_Pageobject(driver);

	}

	// *********************resetpassword1.feature********************//

	@Given("Admin is in home page")
	public void admin_is_in_home_page() {

		loginPag.landLoginPage();
	}

	@When("Admin clicks login button in home page")
	public void admin_clicks_login_button_in_home_page() {

		loginPag.clickloginAuth();
	}

	@Then("verify Admin is on login page")
	public void verify_admin_is_on_login_page() {

		Assert.assertTrue(loginPag.verifyFields());
	}

	@Then("Admin should see correct spellings in all fields in reset password page")
	public void admin_should_see_correct_spellings_in_all_fields_in_reset_password_page() {

		resetPasswordTextMap = resetPasswordPage.VerifyFieldText();
		Assert.assertEquals(resetPasswordTextMap.get("ExpUserText"), actualNameText);
		Assert.assertEquals(resetPasswordTextMap.get("ExppasswordText"), actualPasswordText);
	}

	@Then("Admin should see submit button in center of the page")
	public void admin_should_see_submit_button_in_center_of_the_page() {

		checkFields = resetPasswordPage.verifyFieldsAlignment();
		Assert.assertTrue(checkFields);
	}

	@Then("Admin should see two text box")
	public void admin_should_see_two_text_box() {
		Assert.assertTrue(resetPasswordPage.verifyFields());
	}

	@Then("Admin should see {string} in the first label text")
	public void admin_should_see_in_the_first_label_text(String string) {

		Assert.assertTrue(resetPasswordPage.VerifyFieldTypeInNewPasswordLabels());
	}

	@Then("Admin should see {string} in the second label text")
	public void admin_should_see_in_the_second_label_text(String string) {
		Assert.assertTrue(resetPasswordPage.VerifyFieldTypeRetypePasswordLabels());
	}

	@Then("Admin should see text box in disabled state")
	public void admin_should_see_text_box_in_disabled_state() {

		Assert.assertFalse(resetPasswordPage.verifyFields());
	}

	// *********************resetpassword2.feature********************//

	@Given("Admin clicks reset password link")
	public void admin_clicks_reset_password_link() {

		resetPasswordPage.resetPasswordLink();

	}

	@When("Admin is in log in page")
	public void admin_is_in_log_in_page() {

		resetPasswordPage.landLoginPage();
		LOG.info("Verified Admin is on login page");
	}

	@Then("Admin should land on reset password page {string}")
	public void admin_should_land_on_reset_password_page(String page) {

		Assert.assertTrue(resetPasswordPage.verifyHeader());
		LOG.info("Verified Admin is on reset Password page");
	}

	@Given("Admin is in reset password page {string}")
	public void admin_is_in_reset_password_page(String string) {

		resetPasswordPage.getresetPasswordPageHeader();
		LOG.info("Admin is on reset Password page");
	}

	@When("Admin clicks on type in new password and retype password field")
	public void admin_clicks_on_type_in_new_password_and_retype_password_field() {

		resetPasswordPage.verifyFields();
	}

	@Then("Admin should see text box is enabled state")
	public void admin_should_see_text_box_is_enabled_state() {

		Assert.assertTrue(resetPasswordPage.verifyFields());
	}

	@When("Admin enters same password on both field {string}, {string}  and clicks submit button")
	public void admin_enters_same_password_on_both_field_and_clicks_submit_button(String typeinNewPassword,
			String retypePassword) {

		resetPasswordPage.validatePassword(typeinNewPassword, retypePassword);
		LOG.info("Verify alert Error message in Program Page in adding new program");
	}

	@Then("Admin should recieve  : {string}. Please click here to login")
	public void admin_should_recieve_please_click_here_to_login(String message) {

		driver.switchTo().alert().getText();
		Assert.assertEquals(commonElement.getSuccessMessage(), message);
		LOG.info("Verified user added on User Page");
	}


}

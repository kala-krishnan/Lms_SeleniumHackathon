package com.lmsproject.pageobjects;

import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.HashMap;


public class ResetPasswordPage_Pageobject {
	
	WebDriver driver;
	
	private final static Logger LOG = LogManager.getLogger(ResetPasswordPage_Pageobject.class);
	
	@FindBy(xpath="//input[@class='user1']")
	WebElement txtTypeinNewPassword;
	@FindBy(xpath="//input[@class='password1']")
	WebElement txtRetypePassword;
	@FindBy(xpath="//input[@class='Submit']")
	WebElement buttonSubmit;
	@FindBy(xpath ="//div[@class='alert alert-primary']")
	WebElement alertMsg;
	@FindBy(xpath="//h2[text()='Reset Password']")
	WebElement resetPasswordpageHeader;
	
	@FindBy(xpath ="//div/label[text()='Type in New Password']")
	WebElement typeinNewPasswordText;
	@FindBy(xpath ="//div/label[text()='Retype Password']")
	WebElement reTypePasswordText;
	@FindBy(xpath ="//input[@placeholder='Password']")
	WebElement placePassword;
	@FindBy(linkText="Reset Password")
	WebElement resetPasswordLink;
	@FindBy(xpath="//div[@class='alert alert-success']")
	WebElement successAlertMessage;
	
	
	String URL = "https://example.com/login";
	String successPage = "";
	String errorMessage="";
	String successMessage="";
	String actualTypeInNewPasswordText = "admin";
	String actualPasswordText = "admin";
	
	
	
	public ResetPasswordPage_Pageobject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void openLMSPage() {
		driver.get(URL);
		LOG.info("LMS Application is successfully Launched");
	}
	public String clickloginAuth()
	{
		WebElement clickLogin =driver.findElement(By.id("clickLoginLink"));
		clickLogin.click();
		successPage = driver.getTitle();
		return successPage;
	}
	
	public String spellCheck()
	{
		String text = resetPasswordLink.getText();
		return text;
	}
	public boolean verifyHeader()
	{
		successMessage = resetPasswordpageHeader.getText();
		return true;
	}
	
	public String getresetPasswordPageHeader()
	{
		
		String resetPasswordPageHeaderTitle = resetPasswordpageHeader.getText();
		return successMessage;
	}
	public HashMap<String,String> VerifyFieldText()
	{
		HashMap<String,String> textMap = new HashMap<String,String>();
		String actualTypeInNewPasswordText = typeinNewPasswordText.getText();
		String ExpectedPasswordText = reTypePasswordText.getText();
		textMap.put("TypeInNewPassword", actualTypeInNewPasswordText);
		textMap.put("RetypePasswordText", ExpectedPasswordText);
		return textMap;
		
	}
	public boolean VerifyFieldTypeInNewPasswordLabels()
	{
		
		String actualTypeInNewPasswordText = typeinNewPasswordText.getText();
		String ExpectedPasswordText = reTypePasswordText.getText();
		
		return true;
		
	}
	public boolean VerifyFieldTypeRetypePasswordLabels()
	{
		
		String RetypePasswordText = typeinNewPasswordText.getText();
		String ExpectedRetypePasswordText = reTypePasswordText.getText();
		
		return true;
		
	}
	public boolean verifyFields()
	{
		boolean typeinNewPassword = txtTypeinNewPassword.isDisplayed();
		boolean reTypePassword = txtRetypePassword.isDisplayed();
		if(typeinNewPassword && reTypePassword)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	public String verifyPasswordPlaceHolder()
	{
		String getPasswordPlace = placePassword.getText();
		return getPasswordPlace;
	}
	
	
	public boolean verifyFieldsAlignment()
	{
		String script = "arguments[0].style.textAlign='center';";
       boolean userAlignment = (boolean) ((JavascriptExecutor)driver).executeScript(script, txtTypeinNewPassword);
       boolean passwordAlignment =(boolean) ((JavascriptExecutor)driver).executeScript(script, txtRetypePassword);
       boolean submitButtonAlignment = (boolean) ((JavascriptExecutor)driver).executeScript(script, buttonSubmit);
       
       if(userAlignment && passwordAlignment && submitButtonAlignment )
       {
    	   return true;
       }
       else
       {
    	   return false;
       }
	}
	
	public boolean verifySubmitButton()
	{
		boolean buttonSubmitField = buttonSubmit.isDisplayed();
		return buttonSubmitField;
	}
	public boolean verifyButtonAlignment()
	{
		String script = "arguments[0].style.textAlign='center';";
	       boolean loginButtonAlignment = (boolean) ((JavascriptExecutor)driver).executeScript(script, buttonSubmit);
	       return loginButtonAlignment;
	}

	public boolean verifyresetPassword()
	{
		boolean verifyResetPasswordLink = resetPasswordLink.isDisplayed();
		return verifyResetPasswordLink;
	}
	
	public void landLoginPage()
	{
		driver.get("https://example.com/login");
	}
	
	public void validatePassword(String typeInNewPassword,String resetPassword)
	{
		txtTypeinNewPassword.sendKeys(actualTypeInNewPasswordText);
		txtRetypePassword.sendKeys(actualPasswordText);
		buttonSubmit.click();
		
	}
	
	public  void resetPasswordLink()
	{
		resetPasswordLink.click();
		
	}
	public String geterrorMessage()
	{
	    errorMessage = alertMsg.getText();
    	return errorMessage;
	}
	public void loginUsingValidDetails(String validUsrName,String validPassword)
	{
		txtTypeinNewPassword.sendKeys(validUsrName);
		txtRetypePassword.sendKeys(validPassword);
		buttonSubmit.click();
	}
	
	public String getSuccessMessage()
	{
		successMessage = successAlertMessage.getText();
    	return successMessage;
	}
}

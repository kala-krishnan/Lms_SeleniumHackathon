package com.lmsproject.pageobjects;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage_Pageobject {
	WebDriver driver;
	private final static Logger LOG = LogManager.getLogger(LoginPage_Pageobject.class);
	
	
	
	
	@FindBy(xpath="//input[@class='user1']")
	WebElement userLogin;
	@FindBy(xpath="//input[@class='password1']")
	WebElement passLogin;
	@FindBy(xpath="//input[@class='LoginButton']")
	WebElement buttonLogin;
	@FindBy(xpath ="//div[@class='alert alert-primary']")
	WebElement alertMsg;
	@FindBy(xpath="//h2[text()='Please login to LMS application']")
	WebElement loginpageHeader;
	@FindBy(xpath ="//div/label[text()='User']")
	WebElement nameText;
	@FindBy(xpath ="//div/label[text()='Password']")
	WebElement PasswordText;
	@FindBy(xpath ="//input[@placeholder='User']")
	WebElement placeUser;
	@FindBy(xpath = "//div//label[@id='user1']/span[@class='form-required']")
	WebElement userAstrickSymbol;
	@FindBy(xpath ="//input[@placeholder='Password']")
	WebElement placePassword;
	@FindBy(xpath = "//div//label[@id='password1']/span[@class='form-required']")
	WebElement passAstrickSymbol;
	@FindBy(linkText="Forgot Username or Password")
	WebElement forgotPasswordLink;
	@FindBy(linkText="Reset Password")
	WebElement resetPasswordLink;
	@FindBy(xpath="//div[@class='alert alert-success']")
	WebElement successAlertMessage;
	
	
	String URL = "https://example.com/login";
	String successPage = "";
	String errorMessage="";
	String successMessage="";
	HttpURLConnection urlConnectioCheck = null;
    int respCode = 200;
	String actualNameText = "User";
	String actualPasswordText = "Password";
	
	
	
	public LoginPage_Pageobject(WebDriver driver) {
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
	public String verifyURLNotBroken(int statusCode)
	{
		try {
			urlConnectioCheck = (HttpURLConnection)(new URL(URL).openConnection());
			urlConnectioCheck.setRequestMethod("HEAD");
			urlConnectioCheck.connect();
            respCode = urlConnectioCheck.getResponseCode();
            if(respCode >= statusCode){
            	LOG.info("URL is broken link");
                errorMessage="URL is broken link.";
            }
            else{
            	LOG.info("URL is valid link");
            	}
            return errorMessage;
            
		}
		catch(Exception e)
		{
			e.printStackTrace();
			errorMessage = "Exception occured";
			return errorMessage;
		}
		
	}
	public String verifyHeader()
	{
		successMessage = loginpageHeader.getText();
		return successMessage;
	}
	
	public HashMap<String,String> VerifyFieldText()
	{
		HashMap<String,String> textMap = new HashMap<String,String>();
		String ExpectedUserText = nameText.getText();
		String ExpectedPasswordText = PasswordText.getText();
		textMap.put("ExpUserText", ExpectedUserText);
		textMap.put("ExppasswordText", ExpectedPasswordText);
		return textMap;
		
	}
	public boolean verifyFields()
	{
		boolean userField = userLogin.isDisplayed();
		boolean passField = passLogin.isDisplayed();
		if(userField && passField)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	public String verifyUserPlaceHolder()
	{
		String getUserPlace = placeUser.getText();
		return getUserPlace;
	}
	public String verifyUserAsterick()
	{
		String userAsterick = userAstrickSymbol.getText();
		return userAsterick;
	}
	
	public String verifyPasswordPlaceHolder()
	{
		String getPasswordPlace = placePassword.getText();
		return getPasswordPlace;
	}
	public String verifyPasswordAsterick()
	{
		String PasswordAsterick = passAstrickSymbol.getText();
		return PasswordAsterick;
	}
	
	public boolean verifyFieldsAlignment()
	{
		String script = "arguments[0].style.textAlign='center';";
       boolean userAlignment = (boolean) ((JavascriptExecutor)driver).executeScript(script, userLogin);
       boolean passwordAlignment =(boolean) ((JavascriptExecutor)driver).executeScript(script, passLogin);
       if(userAlignment && passwordAlignment )
       {
    	   return true;
       }
       else
       {
    	   return false;
       }
	}
	public boolean verifyLoginButton()
	{
		boolean loginButtonField = buttonLogin.isDisplayed();
		return loginButtonField;
	}
	public boolean verifyButtonAlignment()
	{
		String script = "arguments[0].style.textAlign='center';";
	       boolean loginButtonAlignment = (boolean) ((JavascriptExecutor)driver).executeScript(script, buttonLogin);
	       return loginButtonAlignment;
	}
	public boolean verifyforgotPassword()
	{
		boolean verifyForgotPasswordLink = forgotPasswordLink.isDisplayed();
		return verifyForgotPasswordLink;
	}
	public boolean verifyresetPassword()
	{
		boolean verifyResetPasswordLink = resetPasswordLink.isDisplayed();
		return verifyResetPasswordLink;
	}
	public String verifyColor()
	{
	      String userTextColor = nameText.getCssValue("color");
	      String UserColorinHex = Color.fromString(userTextColor).asHex();
	      return UserColorinHex;
	}
	
	public String verifyPasswordColor()
	{
	      String passwordTextColor = PasswordText.getCssValue("color");
	      String passwordColorinHex = Color.fromString(passwordTextColor).asHex();
	      return passwordColorinHex;
	}
	public void landLoginPage()
	{
		driver.get("https://example.com/login");
	}
	
	public void validateUserandPassword(String userName,String Password)
	{
		userLogin.sendKeys(userName);
		passLogin.sendKeys(Password);
		buttonLogin.click();
		
	}
	public String geterrorMessage()
	{
	    errorMessage = alertMsg.getText();
    	return errorMessage;
	}
	public void loginUsingValidDetails(String validUsrName,String validPassword)
	{
		userLogin.sendKeys(validUsrName);
		passLogin.sendKeys(validPassword);
		buttonLogin.click();
	}
	public void loginUsingKeyboard(String validUsrName,String validPassword)
	{
		userLogin.sendKeys(validUsrName);
		passLogin.sendKeys(validPassword);
		buttonLogin.sendKeys(Keys.ENTER);
	}
	public String getSuccessMessage()
	{
		successMessage = successAlertMessage.getText();
    	return successMessage;
	}

}

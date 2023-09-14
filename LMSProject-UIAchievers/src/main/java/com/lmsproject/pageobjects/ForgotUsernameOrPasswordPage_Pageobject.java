package com.lmsproject.pageobjects;

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
import org.testng.Assert;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;


public class ForgotUsernameOrPasswordPage_Pageobject {
	
	WebDriver driver;
	private final static Logger LOG = LogManager.getLogger(ForgotUsernameOrPasswordPage_Pageobject.class);
	

	@FindBy(xpath="//input[@class='user1']")
	WebElement email;
	
	
	@FindBy(linkText="SendLink")
	WebElement sendLink;
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	WebElement successAlertMessage;
	@FindBy(xpath = "//div//label[@id='Email']/span[@class='form-required']")
	WebElement userAstrickSymbol;
	@FindBy(xpath ="//div[@class='alert alert-primary']")
	WebElement alertMsg;
	@FindBy(xpath="//h2[text()='Please login to LMS application']")
	WebElement loginpageHeader;
	@FindBy(xpath="//h2[text()='Forgot username or password Page']")
	WebElement ForgotuserpasswordPageHeader;
	@FindBy(xpath ="//div/label[text()='Email']")
	WebElement emailText;
	
	String URL = "https://example.com/login";
	String successPage = "";
	String errorMessage="";
	String successMessage="";
	HttpURLConnection urlConnectioCheck = null;
    int respCode = 200;
	String actualEmailText = "forgotpassword";
	
	public ForgotUsernameOrPasswordPage_Pageobject(WebDriver driver) {
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
	
	public HashMap<String,String> VerifyFieldText()
	{
		HashMap<String,String> textMap = new HashMap<String,String>();
		String actualEmailText = email.getText();
		
		
		textMap.put("Email", actualEmailText);
		
		return textMap;
		
	}
	public String verifyHeader()
	{
		WebElement ForgotuserpasswordPageHeaderTitle;
		successMessage = ForgotuserpasswordPageHeader.getText();
		return successMessage;
	}
	public String verifyColor()
	{
	      String userTextColor = emailText.getCssValue("color");
	      String UserColorinHex = Color.fromString(userTextColor).asHex();
	      return UserColorinHex;
	}
	
	
	public String verifyEmailAsterick()
	{
		String userAsterick = userAstrickSymbol.getText();
		return userAsterick;
	}
	
	public boolean verifysendLink()
	{
		boolean verifysendLink = sendLink.isDisplayed();
		return verifysendLink;
	}
	
	public void landLoginPage()
	{
		driver.get("https://example.com/login");
	}
	
	public boolean verifySendlinkbutton()
	{
		boolean sendLinkbuttonfield = sendLink.isDisplayed();
		return sendLinkbuttonfield;
	}
	
	public String geterrorMessage()
	{
	    errorMessage = alertMsg.getText();
    	return errorMessage;
	}
	
	public String getSuccessMessage()
	{
		successMessage = successAlertMessage.getText();
    	return successMessage;
	}
	public boolean verifyFieldsAlignment()
	{
		String script = "arguments[0].style.textAlign='center';";
       boolean emailAlignment = (boolean) ((JavascriptExecutor)driver).executeScript(script, emailText);
       boolean sendLinkAlignment =(boolean) ((JavascriptExecutor)driver).executeScript(script, sendLink);
       if(emailAlignment && sendLinkAlignment )
       {
    	   return true;
       }
       else
       {
    	   return false;
       }
	}
}

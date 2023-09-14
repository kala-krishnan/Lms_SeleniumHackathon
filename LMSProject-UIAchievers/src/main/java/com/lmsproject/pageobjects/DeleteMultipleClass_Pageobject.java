package com.lmsproject.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DeleteMultipleClass_Pageobject {

	WebDriver driver;
		String successpage="";
		Actions action;
		public static WebDriverWait Wdwait;
		public int code;
		public String url;
		WebElement duedate= null;
		public java.util.List<WebElement> selectBoxOptions;
		
		public DeleteMultipleClass_Pageobject(WebDriver driver)
		{ 
			
		 this.driver = driver;
		 PageFactory.initElements(driver, this);
		  
		}
		@FindBy(xpath="//button[@id='Class']") WebElement classLink;
//		@FindBy(xpath="//button[@id='Manage Class']")WebElement manageClassLink;
		@FindBy(xpath="//button[@id='delete']") WebElement DelButtonEle;
		@FindBy(xpath="//confirmdeletedialog//Title") WebElement DeleteDialogTitle;
		@FindBy(xpath="//button[@id ='yes']") WebElement DeleteDialogYes;
		@FindBy(xpath="//button[@id ='no']") WebElement DeleteDialogNo;
		@FindBy(xpath="//confirmdeletedialogalert//Title") WebElement alertdeleteDialogTitle;
		
		@FindBy(xpath="//alertbutton[@id ='yes']") WebElement alertdeleteYes;
		@FindBy(xpath="//alertbutton[@id ='no']") WebElement alertdeleteNo;
		@FindBy(id="successMessage") WebElement successAlertMessage;
		@FindBy(xpath="//Select[@id = 'Select']") WebElement checkBoxMultipleSelect;
		@FindBy(xpath="//button[@icon='Delete']") WebElement iconMultipleDelete;
		@FindBy(xpath = "//button[text()='Delete'][0]") WebElement btnMultipleDelete;
		@FindBys({@FindBy(xpath = "//button[@icon='delete']")})List<WebElement> iconDelete;
		
		public void webpage() {
			driver.get("https://example.com/login");
		}
		public void ClickOnClass()
		{
			classLink.click();// TODO Auto-generated method stub
			
		}
		public void ClickOnManageClassLink()
		{
			List<WebElement> downloadHeader = driver.findElements(By.xpath("//h2[contains(text(), 'Manage Classes page')]"));
			 if(downloadHeader.size() > 0)
			 {
			     System.out.println("Found header Manage Classes Page");
			 }
		}public boolean ClickSingleDeleteIcon(int index) {
			action.moveToElement(iconDelete.get(index)).click().build().perform();
			return true;
		}
		public void ClickMultiDeleteIcon() {
			action.moveToElement(iconMultipleDelete).click().build().perform();
		}
		public boolean IsSinlgeDeleteIconEnabled() {
			return iconMultipleDelete.isEnabled();
		}
		public boolean IsMultiDeleteIconDisplayed() {
			return iconMultipleDelete.isDisplayed();
		}
		public void CheckMutiSelectCheckBox() {
			
			checkBoxMultipleSelect.isDisplayed();
		}
		public void ClickMultiSelectCheckBox()
		{
			action.moveToElement(checkBoxMultipleSelect).click().build().perform();
}
		public boolean CheckSingleDeleteIcon(int index) {
			 
			   
			return true;
		}
		 
		public String GetDeleteDialogBoxTitle() {

			try {
				return DeleteDialogTitle.getText();	
			}
			catch(Exception NoSuchElementException) {
				return "Delete confirmation dialog not displayed";
			}
				
		}
		
		public Boolean isVisibleDialogBoxElements(){
			DeleteDialogYes.isDisplayed();
			DeleteDialogNo.isDisplayed();
			return true;
		}
		
		public String ClickDeleteConfirmation(String Confirmation) {

			if (Confirmation.equalsIgnoreCase("Yes")) {
				action.moveToElement(DeleteDialogYes).click().build().perform();
				Wdwait.until(ExpectedConditions.invisibilityOf(DeleteDialogYes));
				WebElement MsgElement = driver.findElement(By.xpath("//ConfirmationMessage"));
				return MsgElement.getText();
			}
			else if  (Confirmation.equalsIgnoreCase("No")) {
				action.moveToElement(DeleteDialogNo).click().build().perform();;

			}
			return"NA";
		}
		public boolean getDeleteAlert() {
			return alertdeleteDialogTitle.isEnabled();
		}
		public String deletealertButton(String confirm)
		{
			if (confirm.equalsIgnoreCase("Yes")) {
				action.moveToElement(alertdeleteYes).click().build().perform();
				Wdwait.until(ExpectedConditions.invisibilityOf(alertdeleteYes));
				WebElement MsgElement = driver.findElement(By.xpath("//ConfirmationAlert"));
				return MsgElement.getText();
			}
			else if  (confirm.equalsIgnoreCase("No")) {
				action.moveToElement(alertdeleteNo).click().build().perform();;

			}
			return"NA";
		}
		public String getSuccessMessage()
		{
		String successMessage = successAlertMessage.getText();
		return successMessage;
		}
	}


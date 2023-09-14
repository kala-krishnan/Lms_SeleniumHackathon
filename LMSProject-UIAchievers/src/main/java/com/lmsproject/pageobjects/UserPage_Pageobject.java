package com.lmsproject.pageobjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserPage_Pageobject {
	
	WebDriver driver;
	Actions action;
	public static WebDriverWait Wdwait;

	public UserPage_Pageobject(WebDriver ldriver)
	{
		driver = ldriver;
		PageFactory.initElements(driver, this); //'this' to optimize our code instead of specifying each and every page
	}
	
	//locators
	@FindBy(xpath = "//button[@id='user']")WebElement user;
	@FindBy(id="search") WebElement txtSearch;
	@FindBy(xpath="//input[@type='checkbox']") WebElement chkbox;
	@FindBy(xpath="//button[@name='delete']") WebElement btnDelete;
	@FindBy(xpath="//button[@name='addnewuser']") WebElement btnAddNewUser;
	@FindBy(xpath="//button[@name='assignstaff']") WebElement btnassignStaff;
	@FindBy(xpath="//button[@name='delete']") WebElement btndisabledDelete;
	@FindBy(xpath="//button[@name='edit']") WebElement iconEdit;
	@FindBy(xpath="//input[@id='search']") WebElement searchBox;
	@FindBy(xpath="//a[@href='user']") WebElement LnkUserNavigationBar;
	@FindBy(xpath = "//div[@role='dialog") WebElement userDetails;
	@FindBy(xpath="//p-dialog//div[@role='dialog']/div/span") WebElement UserDetailPopupTitle;
	@FindBy(xpath = "//button[@label='Save']") WebElement btnSubmit;
	@FindBy(xpath = "//button[@label='Cancel']") WebElement btnCancel;
	@FindBy(id="btnANewProgram") WebElement btnAddProgram;
	@FindBy(id = "FirstName") WebElement txtFirstName;
	@FindBy(id = "MiddleName") WebElement txtMiddleName;
	@FindBy(id = "LastName") WebElement txtLastName;
	@FindBy(id = "Location") WebElement txtLocation;
	@FindBy(id = "Phone") WebElement txtPhone;
	@FindBy(xpath = "//*[@id='DeleteAlert']")WebElement deleteAlert;
	@FindBy(xpath = "//button[@label='Yes']") WebElement btnYes;
	@FindBy(xpath = "//button[@label='No']") WebElement btnNo;
	@FindBy(id="txtMessage") WebElement txtMessage;
	@FindBy(xpath="//@Pagetitle[id = 'Manage User']") WebElement lblPageHeaderTitle;
	@FindBy(xpath="//confirmdeletedialog//Title") WebElement DeleteDialogTitle;
	@FindBy(xpath="//button[@icon='Delete']") WebElement iconSingleUserDelete;
	@FindBy(xpath="//button[@icon='Delete']") WebElement iconMultipleDelete;
	@FindBy(xpath="//table[@id='User']//tr") WebElement userRow;
	@FindBy(xpath="//table[@id='User']//th") WebElement userCol;
	
	//methods
	
	public void openLMSPage() {
		driver.get("https://example.com/login");	
	}
	
	public void clickUserBtn() {
		user.click();

	}
	
	public boolean validateUserLandedDashboradPageafterLogin() {
		Wdwait.until(ExpectedConditions.visibilityOf(btnAddProgram));
		return btnAddProgram.isDisplayed();
	}
	public String GetPageHeaderTitle() {
		return lblPageHeaderTitle.getText();
	}
	
	public boolean validateDeleteBtnisNotEnabled() {		
		 return btndisabledDelete.isEnabled();
	}
	
	public boolean validatesearchbox() {		
		return searchBox.isDisplayed();		
	}
	public void clickAddNewUser(){
		btnAddNewUser.click();
	}
	
	public boolean validateAddNewUserBtn() {
		 return btnAddNewUser.isDisplayed();
	}
	
	public boolean validateAssignStaffBtn() {
		 return btnassignStaff.isDisplayed();
	}
	
	public void ClickUserOptionFromNavigation() {
		LnkUserNavigationBar.click();
	}
	
	public String getURLtext() {
		return driver.getCurrentUrl();
	}
	
	
	public boolean isUserDetailBoxVisible()
	{
		Wdwait.until(ExpectedConditions.visibilityOf(userDetails));
		return userDetails.isDisplayed();
	}
	
	public String UserDetailPopupTitle()
	{
		return UserDetailPopupTitle.getText();
		
	}
		
	public void submitUserDetails(){
		
		Wdwait.until(ExpectedConditions.visibilityOf(btnSubmit));
		if (btnSubmit.isDisplayed())
		{
			action.moveToElement(btnSubmit).build().perform();
		}
		else 
		{
			action.moveToElement(btnCancel).build().perform();
		}		
	}
	
	/*public void EnterProgramDetails(String Firstname, String MiddleName,String LastName,String Location,String LinkedInURL,long phone,String UserRole,String RoleStatus,String VisaStatus,String UnderGraduate,String PostGraduate,String TimeZone,String UserComment)
	{
		txtFirstName.clear();
		txtFirstName.sendKeys(Firstname);
		txtMiddleName.clear();
		txtMiddleName.sendKeys(MiddleName);
		txtLastName.clear();
		txtLastName.sendKeys(LastName);
		txtLocation.clear();
		txtLocation.sendKeys(Location);
		txtPhone.clear();
		//txtPhone.sendKeys(phone);
	}*/
	
	public void clickDeleteBtn(){
		btnDelete.click();		
	}
	
	public boolean IsDeleteIconEnabled() {
		return iconSingleUserDelete.isEnabled();
	}
	
	public String validateDeleteAlert() {
		Alert alert = driver.switchTo().alert();
		return alert.getText();	
	}
	
	
	public void ClickDeleteUserYesBtn() {
		Alert alert = driver.switchTo().alert();
		if (alert.getText().contains("Yes"))		
			alert.accept();
		else 
			alert.dismiss();
		}
	
	public String GetDeleteDialogBoxTitle() {

		try {
			return DeleteDialogTitle.getText();	
		}
		catch(Exception NoSuchElementException) {
			return "Delete confirmation dialog not displayed";
		}
			
	}
	
	public String ClickDeleteUserConfirmation(String Confirmation) {

		if (Confirmation.equalsIgnoreCase("Yes")) 
		{
			action.moveToElement(btnYes).click().build().perform();
			Wdwait.until(ExpectedConditions.invisibilityOf(btnYes));
			WebElement MsgElement = driver.findElement(By.xpath("//ConfirmationMessage"));
			return MsgElement.getText();
		}
		else if  (Confirmation.equalsIgnoreCase("No")) {
			action.moveToElement(btnNo).click().build().perform();;

		}
		return"NA";
	}
	public String getMessage()
	{
		return txtMessage.getText();
	}
	
/*public boolean validateDeletedAddedUsersuccess(String name) {
		
		int rowCount = userRow.getSize();
		int colCount = userCol.getSize();
		
		for(int i=1;i<rowcount;i++) {
			int j=1;j<colCount;j++) {
				
				String username =driver.findElement(By.xpath("//table[@id=\"user"\]/tbody/tr["+(i+1)+"]/td["+j+"]")).getText();
						if(username.equals(username))
							return true;
						else
							return false;
			}
		
	}	*/

	
	
}

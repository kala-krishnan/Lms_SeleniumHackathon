package com.lmsproject.pageobjects;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.datatable.DataTable;

public class EditClass_Pageobject {
	public WebDriver driver;
	public static WebDriverWait Wdwait;
	String successpage="";
	String errorMessage="";
	Actions action;
//	public int code;
//	public String url;
	public java.util.List<WebElement> selectBoxOptions;

	public EditClass_Pageobject(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		driver.get("https:www.lms.com/login");
 
	}
	 
	@FindBy(xpath = "//button[@id='Class']")
	WebElement classEle;
	@FindBy(xpath = "//button[@id='delete']")
	WebElement deleteButEle;
	@FindBy(xpath="//button[@id='Class']") WebElement classLink;
	@FindBy(linkText="ManageClass")WebElement manageClassLink;
	@FindBy (xpath="//a[contains(text(),'Add New Class')]")WebElement addNewClassButton; 
	@FindBy (xpath="//a[contains(text(),'Batch Id')]")WebElement dropDownBatchId;
	@FindBy (xpath="//a[contains(text(),'No of Classes')]") WebElement NoofClassesEle;
	@FindBy (xpath="//a[contains(text(),'Class Date')]") WebElement classDateEle;
	@FindBy (xpath="//a[contains(text(),'Class Topic')]") WebElement classTopicEle;
	@FindBy (xpath="//a[contains(text(),'Staff ID')]") WebElement staffIdEle;
	@FindBy (xpath="//a[contains(text(),'Class description')]") WebElement classDescriEle;
	@FindBy (xpath="//a[contains(text(),'Comments')]") WebElement commentsEle;
	@FindBy (xpath="//a[contains(text(),'Notes')]") WebElement notesEle;
	@FindBy (xpath="//a[contains(text(),'Recordings')]") WebElement recordingsEle;
	@FindBy (xpath="//button[@id='Save']") WebElement saveEle;
	@FindBy (xpath="//button[@id='Cancel']") WebElement cancelEle;
	@FindBy(xpath ="//div[@class='alert alert-success']") WebElement successAlertMessage;
	@FindBy(xpath ="//div[@class='alert alert-primary']")WebElement alertMsg;
//	@FindBy (xpath="//*[@class='alert alert-primary']") WebElement errorMsg;
	@FindBy(xpath="//alertbutton[@id ='yes']") WebElement alertdeleteYes;
	@FindBy(xpath="//alertbutton[@id ='no']") WebElement alertdeleteNo;
	@FindBy(xpath="//button[@id ='yes']") WebElement DeleteDialogYes;
	@FindBy(xpath="//button[@id ='no']") WebElement DeleteDialogNo;
	@FindBy(xpath="//confirmdeletedialogalert//Title") WebElement alertdeleteDialogTitle;
	@FindBy(xpath="//div[@id='click_box']")WebElement datePickerEle;
	public WebElement selectDate = driver.findElement(By.xpath("//span[@aria-controls='datetimepicker_dateview']"));
	List<WebElement> columns = driver.findElements(By.tagName("td"));

	public void page() {
		driver.get("https://example.com/login");
	}
	
	public void Class_Link()
	{
		classEle.click();
	}
	public void ClickOnEditButton()
	{
		deleteButEle.click();
	}
	public void EditPopWindow()
	{
		Alert alert = driver.switchTo().alert(); // switch to alert

		String alertMessage= driver.switchTo().alert().getText(); // capture alert message

		System.out.println(alertMessage); // Print Alert Message
		 
		alert.accept();
	}
	public String geterrorMessage()
	{
	    errorMessage = alertMsg.getText();
    	return errorMessage;
	}
	public void ClickdropDownBatchId()
	{
		Select dropdown = new Select(dropDownBatchId);
		selectBoxOptions = dropdown.getOptions();
	}
	public String editClassConfirmation(String save)
	{
		if (save.equalsIgnoreCase("Save"))
		{
			action.moveToElement(saveEle).build().perform();
			//Wdwait.until(ExpectedConditions.invisibilityOf(btnSave));
			//alert text message
			return getSuccessMessage();
		}
		else 
		{
			action.moveToElement(cancelEle).build().perform();
		}
		return "NA";
				
	}
	public String getSuccessMessage()
	{
	String successMessage = successAlertMessage.getText();
	return successMessage;
	}
	public void getErrorMsg() {
		String Error_Message=alertMsg.getText();
//		LOG.info("Error Message  : " + Error_Message);		
	}
	public String getEmptyfieldErrormsgBatchId() {
		return dropDownBatchId.getAttribute("validationMessage");
		
	}
	public String getEmptyfieldErrormsgNoofClasses() {
		return NoofClassesEle.getAttribute("validationMessage");
		
	}
	public String getEmptyfieldErrormsgClassDate() {
		return classDateEle.getAttribute("validationMessage");
		
	}
	public String getEmptyfieldErrormsgStaffId() {
		return staffIdEle.getAttribute("validationMessage");
		
	}
	public void EditClassWithValidValues(String BatchID, String NoofClasses, String ClassDate, String ClassTopic, String ClassDescription, String Comments, String Notes, String Recording) throws InterruptedException {
		dropDownBatchId.isEnabled();	
		NoofClassesEle.sendKeys(NoofClasses);
		classDateEle.isSelected();
		classTopicEle.sendKeys(ClassTopic);	
		staffIdEle.sendKeys(ClassDescription);
		classDescriEle.sendKeys(Comments);	
		commentsEle.sendKeys(Notes);
		notesEle.sendKeys(Recording);
			
	}
	public String successmsg()
	{
		 successpage = driver.getTitle();
		return successpage;
	}
	public void enterBatchId(DataTable dataTable) {
		List<Map<String, String>> classdetail = dataTable.asMaps(String.class, String.class);	
		for (Map<String, String> mapData : classdetail) {
			String classDetail = mapData.get("Batch Id");
//			LOG.info("The user enter BatchId as : " + classDetail);
			dropDownBatchId.isSelected();
		}
	}
	
	public void enterNoofClasses(DataTable dataTable) {
		List<Map<String, String>> classdetail = dataTable.asMaps(String.class, String.class);
		for (Map<String, String> mapData : classdetail) {
			String noofclass = mapData.get("No of Classes");
//			LOG.info("The user enter No of Classes as : " + noofclass);
			NoofClassesEle.sendKeys(noofclass);
		}
	}
	public void enterClassDate(DataTable dataTable) {
		List<Map<String, String>> classdetail = dataTable.asMaps(String.class, String.class);
		for (Map<String, String> mapData : classdetail) {
			String dateclass = mapData.get("Class Date");
//			LOG.info("The user enter password as : " + dateclass);
			classDateEle.isSelected();
		}
	}public void enterClassTopic(DataTable dataTable) {
		List<Map<String, String>> classdetail = dataTable.asMaps(String.class, String.class);
		for (Map<String, String> mapData : classdetail) {
			String classtopic = mapData.get("Class Topic");
//			LOG.info("The user enter password as : " + classtopic);
			classTopicEle.sendKeys(classtopic);
		}
	}
	public void enterClassDescription(DataTable dataTable) {
		List<Map<String, String>> classdetail = dataTable.asMaps(String.class, String.class);	
		for (Map<String, String> mapData : classdetail) {
			String classDescrip = mapData.get("Class description");
//			LOG.info("The user enter Class description as : " + classDescrip);
			classDescriEle.sendKeys(classDescrip);
		}
	}
	
	public void enterComments(DataTable dataTable) {
		List<Map<String, String>> classdetail = dataTable.asMaps(String.class, String.class);
		for (Map<String, String> mapData : classdetail) {
			String Comm = mapData.get("Comments");
//			LOG.info("The user enter Comments : " + Comm);
			commentsEle.sendKeys(Comm);
		}
	}
	public void enterNotes(DataTable dataTable) {
		List<Map<String, String>> classdetail = dataTable.asMaps(String.class, String.class);
		for (Map<String, String> mapData : classdetail) {
			String note = mapData.get("Class Date");
//			LOG.info("The user enter password as : " + note);
			notesEle.sendKeys(note);
		}
	}public void enterRecordings(DataTable dataTable) {
		List<Map<String, String>> classdetail = dataTable.asMaps(String.class, String.class);
		for (Map<String, String> mapData : classdetail) {
			String record = mapData.get("Class Topic");
//			LOG.info("The user enter password as : " + record);
			recordingsEle.sendKeys(record);
		}
	}
	public Boolean getEmptyRequiredBatchId() {
		boolean isRequired = true;
		// To check empty fields , we need to check "required" field is on an attribute
		if (dropDownBatchId.getText().isEmpty()) {
			JavascriptExecutor js_user = (JavascriptExecutor) driver;
			isRequired = (Boolean) js_user.executeScript("return arguments[0].required;", dropDownBatchId);
		}
		return isRequired;
	}

	public Boolean getEmptyRequiredNoofClasses() {
		boolean isRequired = true;
		// To check empty fields , we need to check "required" field is on an attribute
		if (NoofClassesEle.getText().isEmpty()) {
			JavascriptExecutor js_user = (JavascriptExecutor) driver;
			isRequired = (Boolean) js_user.executeScript("return arguments[0].required;", NoofClassesEle);
		}
		return isRequired;
	}
	public Boolean getEmptyRequiredClassDate() {
		boolean isRequired = true;
		// To check empty fields , we need to check "required" field is on an attribute
		if (classDateEle.getText().isEmpty()) {
			JavascriptExecutor js_user = (JavascriptExecutor) driver;
			isRequired = (Boolean) js_user.executeScript("return arguments[0].required;", classDateEle);
		}
		return isRequired;
	}
	public Boolean getEmptyRequiredStaffId() {
		boolean isRequired = false;
		// To check empty fields , we need to check "required" field is on an attribute
		if (staffIdEle.getText().isEmpty()) {
			JavascriptExecutor js_user = (JavascriptExecutor) driver;
			isRequired = (Boolean) js_user.executeScript("return arguments[0].required;", staffIdEle);
		}
		return isRequired;
	}
	public void ClickOnDatePicker()
	{
		datePickerEle.click();
	}
	
	public void passeddate()
	{	 
		WebElement duedate= null; 
	     duedate.clear();
		selectDate.click();
		columns.get(-1).click();
		String text=duedate.getText();
		
		
	}
	public void ClickOnManageClassLink()
	{
		List<WebElement> downloadHeader = driver.findElements(By.xpath("//h2[contains(text(), 'Manage Classes')]"));
		 if(downloadHeader.size() > 0)
		 {
		     System.out.println("Found header Manage Classes Page");
		 }
		 
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
	public void CheckOnManageClassPage()
	{
		manageClassLink.isDisplayed();
	}

}

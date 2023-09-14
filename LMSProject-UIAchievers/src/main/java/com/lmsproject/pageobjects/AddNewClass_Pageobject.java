package com.lmsproject.pageobjects;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
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
import com.lmsproject.components.ExcelDataInputReader;
import io.cucumber.datatable.DataTable;

public class AddNewClass_Pageobject {
	WebDriver driver;
	String successpage="";
	Actions action;
	public static WebDriverWait Wdwait;
	public int code;
	public String url;
	WebElement duedate= null;
	public java.util.List<WebElement> selectBoxOptions;
//	CommonWebElements comElement;
//	ExcelFileReader exceldata=new ExcelFileReader(String excelPath, String sheetName);
//	private final static Logger LOG = (Logger) LogManager.getLogger(AddNewClass_pageobj.class);

public AddNewClass_Pageobject(WebDriver driver)
{ 
	
 this.driver = driver;
 PageFactory.initElements(driver, this);
// comElement = new CommonWebElements(driver);

}
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
@FindBy(id="successMessage") WebElement successAlertMessage;
@FindBy(xpath="//button[@id ='yes']") WebElement DeleteDialogYes;
@FindBy(xpath="//button[@id ='no']") WebElement DeleteDialogNo;
@FindBy(xpath="//confirmdeletedialogalert//Title") WebElement alertdeleteDialogTitle;
@FindBy(xpath="//*[text()='Show Calendar']")WebElement calendar;
@FindBy(xpath="//div[@id='click_box']")WebElement datePickerEle;
public WebElement selectDate = driver.findElement(By.xpath("//span[@aria-controls='datetimepicker_dateview']"));
//public WebElement dueDate = driver.findElement(By.xpath("//span[@aria-controls='datetimepicker_dateview']//div[@class,'due-date')]"));

List<WebElement> columns = driver.findElements(By.tagName("td"));
public WebElement rightclick=driver.findElement(By.xpath("//div[@id='datetimepicker_dateview']//div[@class='k-header']//a[contains(@class,'k-nav-next')]"));
 public WebElement previousLink = driver.findElement(By.xpath("//div[@id='datetimepicker_dateview']//div[@class='k-header']//a[contains(@class,'k-nav-prev')]")); 
public WebElement dateContainer=driver.findElement(By.xpath("//div[@id='qs-datepicker-container']"));

@FindBy (xpath="//*[@class='alert alert-primary']") WebElement errorMsg;

public void webpage() {
	driver.get("https://example.com/login");
}
public void ClickOnClass()
{
	classLink.click(); 
	
}
public void ClickOnManageClassLink()
{
	List<WebElement> downloadHeader = driver.findElements(By.xpath("//h2[contains(text(), 'Manage Classes')]"));
	 if(downloadHeader.size() > 0)
	 {
		 System.out.println("Found header Manage Classes Page" );
//	     LOG.info("Found header Manage Classes Page");
	 }
	 
}
public String getPageTitle() {
		String title = driver.getTitle();
		return title; 
	}
public void broken_link() throws IOException {
	List<WebElement> links = driver.findElements(By.tagName("a"));

	// Printing The Total Links Number
	System.out.println("Total Link Size: " + links.size());
	for (int i = 0; i < links.size(); i++) {
		// Checking Each & Every Links
		WebElement element = links.get(i);

		url = element.getAttribute("href");

		@SuppressWarnings("deprecation")
		URL link = new URL(url);
		HttpURLConnection httpConn = (HttpURLConnection) link.openConnection();
		httpConn.connect();

		// Getting The Response Code
		code = httpConn.getResponseCode();

		if (code >= 400) {
			System.out.println("Broken Link: " + url);
		} else {
			System.out.println("Valid Link: " + url);
		}
	}

}
@SuppressWarnings("deprecation")
public void timeout() {
	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
}

public void ClickAddNewClassButton()
{
	addNewClassButton.click();
}

public void ClickdropDownBatchId()
{
	Select dropdown = new Select(dropDownBatchId);
	selectBoxOptions = dropdown.getOptions();
}
public String addClassConfirmation(String save)
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
	String Error_Message=errorMsg.getText();
//	LOG.info("Error Message  : " + Error_Message);		
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
public void AddClassWithValidValues(String BatchID, String NoofClasses, String ClassDate, String ClassTopic, String ClassDescription, String Comments, String Notes, String Recording) throws InterruptedException {
	dropDownBatchId.isSelected();	
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

//USING DATATABLE TO READ DATA  [DATADRIVEN ] 
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
public String ClickAddConfirmation(String Confirmation) {

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
public void CheckOnManageClassPage()
{
	manageClassLink.isDisplayed();
}
public String errormessage()
{
	driver.switchTo().alert().dismiss();
	String errormessage=driver.switchTo().alert().getText();
	return errormessage();
}
public void ClickOnDatePicker()
{
	datePickerEle.click();
}
public void passeddate()
{	duedate.clear();
	selectDate.click();
	columns.get(-1).click();
	String text=duedate.getText();
	
	
}
public void futuredate()
{	duedate.clear();
	selectDate.click();
	columns.get(3).click();
	String text=duedate.getText();
	
	
}
public String date() {
	
	WebElement duedate= null;
	duedate.clear();
	selectDate.click();
	columns.get(0).click();
	
	String text=duedate.getText();

	String date_dd_MM_yyyy[] = (text.split(" ")[0]).split("/");
	String rgbFormat1 = columns.get(0).getCssValue("background-color");
	return text;
	
}
public String color()
{
	String rgbFormat1 = columns.get(0).getCssValue("background-color");
	String color_hex[];  
	 color_hex = rgbFormat1.replace("rgba(", "").split(",");       
	 String actual_hex = String.format("#%02x%02x%02x", Integer.parseInt(color_hex[0].trim()), Integer.parseInt(color_hex[1].trim()), Integer.parseInt(color_hex[2].trim()));
	return actual_hex;
}
public String colorforfuture()
{
	String rgbFormat1 = columns.get(3).getCssValue("background-color");
	String color_hex[];  
	 color_hex = rgbFormat1.replace("rgba(", "").split(",");       
	 String actual_hex = String.format("#%02x%02x%02x", Integer.parseInt(color_hex[0].trim()), Integer.parseInt(color_hex[1].trim()), Integer.parseInt(color_hex[2].trim()));
	return actual_hex;
}
public int monthname()
{	
	Calendar calendar = Calendar.getInstance();
	calendar.setTime((Date) selectDate);
	return(calendar.get(Calendar.MONTH));
}
public void selectDate(String month_year, String select_day) throws InterruptedException 
{
	List<WebElement> elements = driver.findElements(By.xpath("//div[@class='ui-datepicker-title']/span[1]"));

	for (int i=0; i<elements.size();i++)
	{
	System.out.println(elements.get(i).getText());

	//Selecting the month
	if(elements.get(i).getText().equals(month_year))
	{ 

	//Selecting the date 
	List<WebElement> days = driver.findElements(By.xpath("//div[@class='ui-datepicker-inline ui-datepicker ui-widget ui-widget-content ui-helper-clearfix ui-corner-all ui-datepicker-multi ui-datepicker-multi-2']/div[2]/table/tbody/tr/td/a"));

	for (WebElement d:days)
	{ 
	System.out.println(d.getText());
	if(d.getText().equals(select_day))
	{
	d.click();
	Thread.sleep(2000);
	return;
	}
	} 

	} 

	}
	driver.findElement(By.xpath("//div[@class='ui-datepicker-inline ui-datepicker ui-widget ui-widget-content ui-helper-clearfix ui-corner-all ui-datepicker-multi ui-datepicker-multi-2']/div[2]/div/a/span")).click();
	selectDate(month_year,select_day);

	}	
public void ClickRightClickOnDatePicker()
{
	rightclick.click();
}
	public void ClickPreviousClickonDatePicker()
	{
		previousLink.click();
	}
	public void CheckOnDateContainer()
	{
		dateContainer.isDisplayed();
	}
	public void validClassCredentials()
	{
		dropDownBatchId.sendKeys((ExcelDataInputReader.getBatchName()));
		NoofClassesEle.sendKeys(ExcelDataInputReader.getNoofclasses());
		classDateEle.sendKeys(ExcelDataInputReader.getClassDate());
		classTopicEle.sendKeys(ExcelDataInputReader.getClassTopic());
		staffIdEle.sendKeys(ExcelDataInputReader.getStaffId());
		 
		classDescriEle.sendKeys(ExcelDataInputReader.getClassDesc());
		commentsEle.sendKeys(ExcelDataInputReader.getComments());
		notesEle.sendKeys(ExcelDataInputReader.getNotes());
		recordingsEle.sendKeys(ExcelDataInputReader.getRecording());
		saveEle.click();
	 
}
}


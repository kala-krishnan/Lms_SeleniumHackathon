 package com.lmsproject.pageobjects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;

//import utilities.ConfigReader;

public class ManageClassPage_Pageobject {
	
//	private static final By elementLocator = null;
	WebDriver driver;
	Actions action;
//	public static WebDriverWait Wdwait;
	 
//	ChromeOptions options=new ChromeOptions();
////	options.setHeadless(true);   //make browser as headless
//	options.addArguments("--headless");
////	
//	WebDriver driver1=new ChromeDriver(options); //will become headless browser

	public ManageClassPage_Pageobject(WebDriver driver)
	 { 
		
	  this.driver = driver;
	  PageFactory.initElements(driver, this);
	   
     
	 }
	
	 @FindBy(xpath="//a[@href='/login']") WebElement getStarted;
 
	 @FindBy(xpath="//button[@id='Class']") WebElement classLink;
//	 @FindBy(linkText="ManageClass")WebElement manageClassLink;
	  
//     @FindBy(xpath="//a[normalize-space()='Manage Classes Page']") WebElement pageHeader;
//	 string pageText = driver.FindElement(By.XPath="ManageClass")).Text;
	 
	 @FindBy(xpath="//button[@id='Class']") WebElement deleteAllButton;
	 @FindBy(xpath = "//input[@id = 'Search']") WebElement txtSearch;
	 @FindBy(xpath="//button[@id='AddNewClass']") WebElement lblAddnewClass;
	 @FindBy(xpath = "//input[@id='Batch Id']")WebElement batchIdCol;

	 @FindBy(xpath = "//input[@id = No of Classes") WebElement noofClassFld;

	 @FindBy(xpath = "//input[@id = Class Date")WebElement classDateFld;
	 @FindBy(xpath = "//input[@id = Class Topic") WebElement classTopicFld;

	 @FindBy(xpath = "//input[@id = Staff Id")WebElement staffIdFld;
	  

	 @FindBy(xpath = "//input[@id = Class Description")WebElement classDecFld;
	 @FindBy(xpath = "//input[@id = Comments") WebElement commFld;

	 @FindBy(xpath = "//input[@id = Notes")WebElement notesFld;
	 @FindBy(xpath = "//input[@id = Recording")WebElement recordFld;
	 
	 @FindBy(xpath="//button[@id='Edit']") WebElement clickEditButton;
	
	 
	 @FindBy(xpath="//button[@id='Delete']") WebElement clickDeleteButton;
	 
	 @FindBys({@FindBy(xpath = "//table//sorticon") }) List<WebElement> btnSort;
	 @FindBy(xpath="//Select[@id = 'Select']") WebElement checkBoxMultipleSelect;
		
	 @FindBys({@FindBy(xpath = "//table//sort-icon1") })List<WebElement> sortedBatchId;
	 @FindBys({@FindBy(xpath = "//table//sort-icon2") })List<WebElement> sortedClassno;
	 @FindBys({@FindBy(xpath = "//table//sort-icon3") })List<WebElement> sortedClassdate;
	@FindBys({@FindBy(xpath = "//table//sort-icon4") })List<WebElement> sortedClassTopic;
	@FindBys({@FindBy(xpath = "//table//sort-icon5") })List<WebElement> sortedStaffId;
	 @FindBys({@FindBy(xpath = "//table//sort-icon6") })List<WebElement> sortedDesc;
	 @FindBys({@FindBy(xpath = "//table//sort-icon7") })List<WebElement> sortedComments;
	 @FindBys({@FindBy(xpath = "//table//sort-icon8") })List<WebElement> sortedNotes;
	 @FindBys({@FindBy(xpath = "//table//sort-icon9") })List<WebElement> sortedRecording;
	 
	@FindBy(xpath="//input[@id='entries']") WebElement showEntriesList;
//	@FindBys({@FindBy(xpath = "//table/pagegridtable") })List<WebElement> PageGridDetail;
	 @FindBy(xpath = "//paginator") WebElement lblPaginationEntries;
	 @FindBys({@FindBy(xpath = "//paginator//button") })List<WebElement> PageNoButtonList;
		
		@FindBy(xpath = "//paginator/button[1]") WebElement btnFirstpage;
		 
		@FindBy(xpath = "//paginator/button[2]") WebElement btnSecondpage;
		@FindBy(xpath = "//paginator/button[3]") WebElement btnPreviouspage;
		@FindBy(xpath = "//paginator/button[4]") WebElement btnNextpage;
		@FindBy(xpath = "//paginator/button[5]") WebElement btnLastspage;
		@FindBy(xpath = "//paginator/button[6]") WebElement lblTotalCount;
 
		
		@FindBys({@FindBy(xpath = "//paginator/button") })List<WebElement> btnPagination;
		 @FindBy(xpath="//input[@id='Search']") WebElement searchBox;
		 @FindBy(xpath="//input[@id='display']") WebElement searchOutput;
		 
	 public void getPage() throws IOException
	 {
//		ConfigReader.loadConfig();				
//		String URL=ConfigReader.getApplicationUrl();
		 driver.get("https://example.com/login");		
	 }
	 
	 public void ClickOnClass()
	 {
		 classLink.click();
		 
	 }
	 
	 public void CheckOnManageClassLink()
	 {
		 List<WebElement> downloadHeader = driver.findElements(By.xpath("//h2[contains(text(), 'Manage Classes page')]"));
		 if(downloadHeader.size() > 0)
		 {
		     System.out.println("Found header Manage Classes Page");
		     
		 }
	 }
	  
	 public String getPageTitle() {
		 
			String title = driver.getTitle();
			return title; 
		}
	 public void CaptureResponseTime()
	 {
//			long startTime = System.currentTimeMillis();
//			new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.id("Calculate")));
//			long endTime = System.currentTimeMillis();
//			long totalTime = endTime - startTime;
//			System.out.println("Total Page Load Time: " + totalTime + "milliseconds");
		 
		 driver.get("http:lms.com/dashboard");

		// get the  page load time
		Long loadtime = (Long)((JavascriptExecutor)driver).executeScript(
		    "return performance.timing.loadEventEnd - performance.timing.navigationStart;");
	 
	 }
	 public void GetAllText()
	 {
		  
		 String t = "Manage Classes Page";
	         
	        if (driver.getPageSource().contains("Manage Classes Page")) {
	            System.out.println("Text: " + t + " is present. ");
	        } else {
	            System.out.println("Text: " + t + " is not present. ");
	        }
	 }
	 public void CheckDeleteAll()
	 {
		  
		  deleteAllButton.isEnabled();
	 }
	 public boolean CheckSearchBar()
	 {
		  txtSearch.isEnabled();
				return txtSearch.isDisplayed();
			 
	 }
	 public boolean CheckNewClassButton()
	 {
		 return lblAddnewClass.isDisplayed();
	 }
	 public void ClickNewClassButton() 
	 {
			action.moveToElement(lblAddnewClass).click().build().perform();
		}
	 public void verifyVisibilityOfAllElements()
	 {
		 List<WebElement> elementList = new ArrayList<WebElement>();
		 elementList.add(batchIdCol);
		 elementList.add(noofClassFld);
		 elementList.add(classDateFld);
		 elementList.add(classTopicFld);
		 elementList.add(staffIdFld);
		 elementList.add(classDecFld);
		 elementList.add(commFld);
		 elementList.add(notesFld);
		 elementList.add(recordFld);
		  
		 for(WebElement ele:elementList){
		 if(ele.isDisplayed()){
		 System.out.println("element is displayed" +ele);
		 } else {
		 System.out.println("element is not displayed" +ele);
		 }
		 }
	 }
	 public void verifyEditButton()
	 {
		 clickEditButton.isDisplayed();
	 }
	 public void verifyEditButtonwithNodata()
	 {
		  
		 By elementLocator = By.id("Edit");
		 List<WebElement> elements = driver.findElements(elementLocator);

	 if (elements.size() < 0) 
		    System.out.println("No Element exists");
	 }
	 public void verifyDeleteButton()
	 {
		 clickDeleteButton.isDisplayed();
	 }
	 public void verifyDeleteButtonWithNoData()
	 { 
		 By elementLocator1 = By.id("Delete");
		 List<WebElement> elements1 = driver.findElements(elementLocator1 );

	      if (elements1.size() < 0) 
		    System.out.println("No Element exists");
 
	 }
	 public void ClickMutiSelectCheckBox()
	 {
			action.moveToElement(checkBoxMultipleSelect).click().build().perform();
		}
	 private List<String> prepareList(List<WebElement> we){
			List<String> sortList = new ArrayList<String>();
			for(WebElement item:we){
				sortList.add(item.getText());
			}
			return sortList;
		}
	 public List<String> GetSortedOrder(String fieldClicked)
	 {
			List<String> sortedtList = new ArrayList<String>();
			for(WebElement item:btnSort){
				String fields= item.getDomAttribute("field");
				action.moveToElement(item).click().build().perform();
				
					if (fieldClicked.contains("Batch Id")&& fields.contains("Batch Id") ){
						fields= item.getDomAttribute("field");
						sortedtList= prepareList(sortedBatchId);
						return sortedtList;
					}
					if(fieldClicked.contains("No of Classes") && fields.contains("No of Classes")) {
						fields= item.getDomAttribute("field");
						sortedtList= prepareList(sortedClassno);
						return sortedtList;
					}
					if(fieldClicked.contains("Class Date")&& fields.contains("Class Date") ) {
						fields= item.getDomAttribute("field");
						sortedtList= prepareList(sortedClassdate);
						return sortedtList;
					}
			
			if(fieldClicked.contains("Class Topic")&& fields.contains("Class Topic") ) {
				fields= item.getDomAttribute("field");
				sortedtList= prepareList(sortedClassTopic);
				return sortedtList;
			}
			if(fieldClicked.contains("Staff Id")&& fields.contains("Staff Id") ) {
				fields= item.getDomAttribute("field");
				sortedtList= prepareList(sortedStaffId);
				return sortedtList;
			}
			if(fieldClicked.contains("Class Description")&& fields.contains("Class Description") ) {
				fields= item.getDomAttribute("field");
				sortedtList= prepareList(sortedDesc);
				return sortedtList;
			}
			if(fieldClicked.contains("Comments")&& fields.contains("Comments") ) {
				fields= item.getDomAttribute("field");
				sortedtList= prepareList(sortedComments);
				return sortedtList;
		
					
			} 
			if(fieldClicked.contains("Notes")&& fields.contains("Notes") ) {
				fields= item.getDomAttribute("field");
				sortedtList= prepareList(sortedNotes);
				return sortedtList;
			}
				if(fieldClicked.contains("Recordings")&& fields.contains("Recordings") ) {
					fields= item.getDomAttribute("field");
					sortedtList= prepareList(sortedRecording);
					return sortedtList;
				}
			}
			return sortedtList;
		}
	 
public void checkEntriesFooter()
{
	showEntriesList.isDisplayed();
}
public String GetPaginationShowEntries() {
	return lblPaginationEntries.getText();
}

public String getFooterTotalRecord() {
	return lblTotalCount.getText();
} 
 

	 
public void searchInput_batchId(String string)
{
	 searchBox.sendKeys(String.valueOf(string));
}

public String displayBatchId()
{
	 return searchOutput.getText();
}
public void searchInput_classNO(String string)
{
	 searchBox.sendKeys(String.valueOf(string));
}
public String display_classNO()
{
	 return searchOutput.getText();
}
public void searchInput_classTopic(String topic) {
	 searchBox.sendKeys(topic);
}
public String display_classTopic()
{
	 return searchOutput.getText();
}
public void searchInput_staffID(String staffId) {
	 searchBox.sendKeys(String.valueOf(staffId));
}

public String display_staffID()
{
	 return searchOutput.getText();
}

public void searchInput_classDate(String date) {
	 searchBox.sendKeys(String.valueOf(date));
}
public String display_classDate()
{
	 return searchOutput.getText();
}
public static String errorMessage() {	
		WebElement alert_msg = null;
		@SuppressWarnings("null")
		String error_Message = alert_msg.getText();
		return error_Message;		
}
public boolean batchSearchBox() {
	java.util.List<WebElement> batchidElements = driver.findElements(By.id("batchid"));
	 	 
	boolean allbatchWithId = true;
	for (WebElement element : batchidElements) {
		String BatchId = element.getText();
		if (!BatchId.matches(BatchId)) {
			allbatchWithId = false;
			break; // Exit the loop if a name doesn't start with "x"
		}
	}
	return allbatchWithId;
}
}




package com.lmsproject.pageobjects;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.lmsproject.utility.CommonWebElements;



public class ManageAssignment_Pageobject {

	public WebDriver driver;
	CommonWebElements cm;

	public ManageAssignment_Pageobject(WebDriver ldriver) {
		this.driver = ldriver;
		PageFactory.initElements(driver, this);
		cm = new CommonWebElements(driver);// 'this' to optimize our code instead of specifying each and every page
	}

	String Assignment;
	Actions action;

	@FindBy(xpath = "//button[@icon='Delete']")
	WebElement iconMultipleDelete1;
	@FindBy(xpath = "//button[@label='Cancel']")
	WebElement btnCancel;
	@FindBy(xpath = "//button[@label='Save']")
	WebElement btnSave;
	@FindBy(xpath = "//button[@label='rs-close']")
	WebElement close;

	String URL = "https://example.com/login";
	@FindBy(xpath = "//Select[@id = 'Select']")
	WebElement checkBoxMultipleSelect;
	@FindBys({ @FindBy(xpath = "//gridtable") })
	List<WebElement> PageGridTable;
	@FindBys({ @FindBy(xpath = "//table/pagegridtable") })
	List<WebElement> PageGridDetail;
	@FindBy(xpath = "//paginator")
	public WebElement lblPaginationEntries;

	@FindBy(id = "resultgrid")
	WebElement table;
	@FindBy(xpath = "//@Pagetitle[id = 'Manage Assignment Page']")
	WebElement lblPageHeaderTitle;
	@FindBy(xpath = "//@Pagetitle[id = 'Assignment details']")
	WebElement assignmentTitle;
	@FindBy(xpath = "//@Pagetitle[id = 'Edit Assignment']")
	WebElement editTitle;
	//*[@id="app"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input
	@FindBy(xpath="//input[@name='username']")
	WebElement userLogin;
	//input[@name="username"]
	@FindBy(xpath = "//input[@id = 'Search']")
	WebElement txtSearch;
	@FindBy(xpath = "//input[@name='password']")
	WebElement passLogin;
	@FindBy(xpath = "//button[@id='ANEWAssignment']")
	WebElement lblAddnew;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement btnLogin;
	public @FindBy(linkText = "Assignment")
	WebElement assign;
	@FindBy(id = "enter")
	WebElement enterbutton;
	@FindBy(xpath = "//button[@icon='Delete']")
	WebElement iconMultipleDelete;
	@FindBy(xpath = "//*[text()='ProgramName']")
	WebElement prgname;
	@FindBy(xpath = "//*[text()='batchnumber']")
	WebElement batchnum;
	@FindBy(xpath = "//*[text()='Assignmentname']")
	WebElement assgnname;
	@FindBy(xpath = "//*[text()='AssignmentDescription']")
	WebElement assgndesc;
	@FindBy(xpath = "//*[text()='gradeby']")
	WebElement grade;
	public @FindBy(xpath = "//*[text()='Assignmentduedate']")
	WebElement duedate;
	@FindBy(xpath = "//*[text()='AssignmentFile1']")
	WebElement af1;
	@FindBy(xpath = "//*[text()='AssignmentFile2']")
	WebElement af2;
	@FindBy(xpath = "//*[text()='AssignmentFile3']")
	WebElement af3;
	@FindBy(xpath = "//*[text()='AssignmentFile5']")
	WebElement af5;
	@FindBy(xpath = "//*[text()='AssignmentFile4']")
	WebElement af4;
	@FindBy(xpath = ".//*[@id='batch_drpdwn']")
	WebElement element;
	@FindBy(xpath = ".//*[@id='program_drpdwn']")
	WebElement elementforprogram;
	@FindBy(id="successMessage") WebElement successAlertMessage;
	
//	WebElement calendar = 
//			findElement(By.cssSelector("button.ui-datepicker-trigger.ui-button [aria-label='Show Calendar']"));
	@FindBy(xpath="//*[text()='Show Calendar']")WebElement calendar;
	//public WebElement selectDate = driver.findElement(By.xpath("//span[@aria-controls='datetimepicker_dateview']"));
	//List<WebElement> columns = driver.findElements(By.tagName("td"));
	@FindBy(tagName="td")List<WebElement> columns;
	//public WebElement rightclick=driver.findElement(By.xpath("//div[@id='datetimepicker_dateview']//div[@class='k-header']//a[contains(@class,'k-nav-next')]"));
	 //public WebElement previousLink = driver.findElement(By.xpath("//div[@id='datetimepicker_dateview']//div[@class='k-header']//a[contains(@class,'k-nav-prev')]")); 
    public @FindBy(xpath="//div[@id='datetimepicker_dateview']") WebElement rightclick;
    public @FindBy(xpath="//div[@id='datetimepicker_dateview']")WebElement previousLink;
	public String errormessage()
    {
    	driver.switchTo().alert().dismiss();
    	String errormessage=driver.switchTo().alert().getText();
    	return errormessage();
    }
    public void passeddate()
    {	duedate.clear();
    	calendar.click();
    	columns.get(1).click();
    	String text=duedate.getText();
    	
    	
    }
    public void futuredate()
    {	duedate.clear();
    calendar.click();
    	columns.get(3).click();
    	String text=duedate.getText();
    	
    	
    }
    public String date() {
    	duedate.clear();
    	calendar.click();
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
    	//calendar.setTime((Date) selectDate);
    	return(calendar.get(Calendar.MONTH));
    }
    
	public void Getfields(String fieldname) {

		switch (fieldname) {
		case "Program Name":
			prgname.isDisplayed();
			break;
		case "batch number":
			batchnum.isDisplayed();
			break;
		case "Assignment name":
			assgnname.isDisplayed();
			break;
		case "Assignment Description":
			assgndesc.isDisplayed();
			break;
		case "grade by":
			grade.isDisplayed();
			break;
		case "Assignment due date":
			duedate.isDisplayed();
			break;
		case "Assignment File1":
			af1.isDisplayed();
			break;
		case "Assignment File2":
			af2.isDisplayed();
			break;
		case "Assignment File3":
			af3.isDisplayed();
			break;
		case "Assignment File4":
			af4.isDisplayed();
			break;
		case "Assignment File5":
			af5.isDisplayed();
			break;
		default:
			System.out.println("please enter valid fieldname");
			break;

		}

	}

	public int totalfields() {
		List<WebElement> totalTextboxes = driver.findElements(By.xpath("//input[@type='text']"));
		System.out.println(totalTextboxes.size());
		return totalTextboxes.size();
	}
public boolean totalfieldsempty()
{
	List<WebElement> totalTextboxes = driver.findElements(By.xpath("//input[@type='text']"));
for(WebElement data:totalTextboxes)
	if(data.getText().isEmpty())
	{
		btnCancel.click();
	}
return true;

	
}


	public boolean dropdown() {

		boolean see = element.isDisplayed();
		return see;
	}

	public boolean dropdownforprog() {

		boolean see = elementforprogram.isDisplayed();
		return see;
	}

	public boolean calendaricon() {
		boolean cal = calendar.isDisplayed();
		return cal;
	}

	public void entries(String entryname) {
		if (entryname.equalsIgnoreCase("assignment") || entryname.equalsIgnoreCase("assignmentdescription")
				|| entryname.equalsIgnoreCase("duedate") || entryname.equalsIgnoreCase("gradevalue")) {
			txtSearch.clear();
			txtSearch.sendKeys(entryname);
		}
	}

	public void urllaunch() {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

	}

	public void logincredentials(String validUsrName, String validPassword) {
		
		userLogin.sendKeys(validUsrName);
		
		passLogin.sendKeys(validPassword);
		btnLogin.click();
	}

	public String successportal() {
		String pg = driver.getPageSource();
		return pg;
	}

	public void dashboardurl() {
		driver.get("https://example.com");
	}

	public void clickassign(String assgn)

	{
		assign.click();
	}

	public boolean urlhaving() {
		String url = driver.getCurrentUrl();
		boolean val = url.contains("Manage assignemnt");
		return val;
	}

	public void responsetime() {
		long start = System.currentTimeMillis();
		driver.get(URL);
		long end = System.currentTimeMillis();
		System.out.println("Round trip response time = " + (end - start) + " millis");
	}

	public String titleheader() {
		String header = lblPageHeaderTitle.getText();
		return header;
	}

	public void clickbutton(String string1) {
		assign.click();
		System.out.println("all text in" + string1);
		List<WebElement> sectionList = driver.findElements(By.xpath("//div[@id='mid']/div"));
		int i = 0;
		for (WebElement string11 : sectionList) {
			System.out.println("Section " + i + ":" + string11.getText());
			i++;
		}
	}

	public void correctspell() {
		driver.get("https://insites.com");
		txtSearch.sendKeys(URL);
		enterbutton.click();
	}

	public boolean mulitpleDelete() {
		boolean button = iconMultipleDelete1.isEnabled();
		return button;
	}

	public boolean searchbar() {
		boolean search = txtSearch.isDisplayed();
		return search;
	}

	public boolean addnew() {
		boolean add = lblAddnew.isDisplayed();
		return add;
	}

	private List<String> prepareList(List<WebElement> we) {

		List<String> sortList = new ArrayList<String>();
		for (WebElement item : we) {
			sortList.add(item.getText());
		}
		return sortList;
	}

	public boolean columnheaders(String Page) {

		List<String> tblHeading = new ArrayList<String>();
		tblHeading = prepareList(PageGridTable);
		if (Page.equalsIgnoreCase("Assignment")) {
			if (tblHeading.contains("Assignment Name") && tblHeading.contains("Assignment Description")
					&& tblHeading.contains("Assignment Due Date") && tblHeading.contains("Assignment Grade")) {
				return true;
			}
		}
		return true;
	}

	public void tabledata() {

		List<WebElement> allRows = ((By) PageGridDetail).findElements((SearchContext) By.tagName("tr"));
		// And iterate over them, getting the cells
		for (WebElement row : allRows) {
			List<WebElement> cells = row.findElements(By.tagName("td"));
			for (WebElement cell : cells) {
				System.out.println(cell.getText());
				if (cell.getText().isEmpty()) {
					cm.IsEditButtonEnabledInTableRows(row);
					iconMultipleDelete.isDisplayed();
				}
			}
		}
	}

	public boolean displaysdata() {
		List<WebElement> allRows = ((By) PageGridDetail).findElements((SearchContext) By.tagName("tr"));
		// And iterate over them, getting the cells
		for (WebElement row : allRows) {
			List<WebElement> cells = row.findElements(By.tagName("td"));
			for (WebElement cell : cells) {
				System.out.println(cell.getText());
				if (cell.getText().contains("Assignment") || cell.getText().contains("Assignment Description")
						|| cell.getText().contains("due date") || cell.getText().contains("grade")) {
					cm.IsEditButtonEnabledInTableRows(row);
				}
	else if(cell.getText().contains("Jun") || cell.getText().contains("Adm")||cell.getText().contains("14")||cell.getText().contains("desc")||
			cell.getText().contains("pat")||cell.getText().contains("path")||cell.getText().contains("path3")||cell.getText().contains("path4")
			||cell.getText().contains("path5")){

			System.out.print("data is present");

			}
		}
		}
		return true;
	}

	public void addnewclick() {
		lblAddnew.isEnabled();
		lblAddnew.click();
	}

	public boolean chkbox() {
		return checkBoxMultipleSelect.isDisplayed();
	}

	String msg;

	public String assignmentPopUp(String popup) {
		if (popup.equalsIgnoreCase("Assignment details")) {
			action.moveToElement(assignmentTitle).build().perform();
			msg = assignmentTitle.getText();
			// alert text message

		}

		return msg;

	}
	public String editPopUp(String popup) {
		if (popup.equalsIgnoreCase("Edit Assignment page")) {
			action.moveToElement(editTitle).build().perform();
			msg = assignmentTitle.getText();
			// alert text message

		}

		return msg;

	}

	public boolean savebutton() {

		boolean see = btnSave.isDisplayed();
		return see;
	}

	public boolean cancelbutton() {

		boolean see = btnCancel.isDisplayed();
		btnCancel.click();
		return see;
	}

	public boolean close() {

		boolean see = close.isDisplayed();
		return see;
	}
	
	public void validentrydetails(String valid)
	{
		
		
	}	

}

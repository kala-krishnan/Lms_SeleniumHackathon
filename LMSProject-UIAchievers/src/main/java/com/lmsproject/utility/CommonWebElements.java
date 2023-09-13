package com.lmsproject.utility;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class CommonWebElements {
	Actions action;
	WebDriver driver;
	
	public CommonWebElements(WebDriver driver)
	{
		this.driver = driver;
		action = new Actions(driver);
		PageFactory.initElements(driver, this);
		//wait in page factory, waits for the element to appear, a type of explicit wait
		//PageFactory.initElements(new AjaxElementLocatorFactory(driver,20), this);
	}
	
	
	//Page Common Header Element
		@FindBy(xpath="//@Pagetitle[id = 'Manage Program']") WebElement lblPageHeaderTitle;
		@FindBy(xpath = "//input[@id = 'Search']") WebElement txtSearch;
		@FindBy(id="new") WebElement btnAddNew;
		@FindBy(xpath="//button[@id='ANewBatch']") WebElement lblAddnew;
		
		//Table Header Element
		@FindBy(xpath="//Select[@id = 'Select']") WebElement checkBoxMultipleSelect;
		@FindBy(xpath="//button[@icon='Delete']") WebElement iconMultipleDelete;

		@FindBys({
			@FindBy(xpath = "//table//sorticon") 
		}) List<WebElement> btnSort;
		@FindBys({
			@FindBy(xpath = "//table//sort-icon1") 
		})List<WebElement> sortedProgramNameList;
		@FindBys({
			@FindBy(xpath = "//table//sort-icon2") 
		})List<WebElement> sortedProgramDescList;
		@FindBys({
			@FindBy(xpath = "//table//sort-icon3") 
		})List<WebElement> sortedProgramStatusList;
		
		@FindBys({
			@FindBy(xpath = "//gridtable") 
		})List<WebElement> PageGridTable;
		
		//Table Body Element
		@FindBys({
			@FindBy(xpath = "//table/pagegridtable") 
		})List<WebElement> PageGridDetail;
		
		@FindBys({
			@FindBy(xpath = "//table/singlecheckbox") 
		})List<WebElement> checkboxSingleSelect; 
		
		@FindBys({
			@FindBy(xpath = "//button[@icon='edit']") 
		})List<WebElement> iconEdit;
			
		@FindBys({
			@FindBy(xpath = "//button[@icon='delete']") 
		})List<WebElement> iconDelete;
	
		//Footer Element
		@FindBy(xpath = "//paginator") WebElement lblPaginationEntries;
		
		@FindBys({
			@FindBy(xpath = "//paginator//button") 
		})List<WebElement> PageNoButtonList;
		
		@FindBy(xpath = "//paginator/button[1]") WebElement btnFirstpage;
		@FindBy(xpath = "//paginator/button[2]") WebElement btnSecondpage;
		@FindBy(xpath = "//paginator/button[3]") WebElement btnPreviouspage;
		@FindBy(xpath = "//paginator/button[4]") WebElement btnNextpage;
		@FindBy(xpath = "//paginator/button[5]") WebElement btnLastspage;
		@FindBy(xpath = "//paginator/button[6]") WebElement lblTotalCount;
		
		@FindBys({
			@FindBy(xpath = "//paginator/button") 
	})List<WebElement> btnPagination;
		@FindBy(xpath = "//button[@label='Cancel']") WebElement btnCancel;
		@FindBy(xpath = "//button[@label='Save']") WebElement btnSave;
		//success message
		@FindBy(id="successMessage") WebElement successAlertMessage;
		
		
		//Method
		private List<String> prepareList(List<WebElement> we){
			List<String> sortList = new ArrayList<String>();
			for(WebElement item:we){
				sortList.add(item.getText());
			}
			return sortList;
		}
		//To verify the URL
		public Boolean VerifyURL(String urlText)
		{
			if(driver.getCurrentUrl().contains(urlText))
				return true;
			else
				return false;
		}
		// Page Header Content Methods
		
		public boolean IsPageLoaded(String Page) {
			List<String> tblHeading = new ArrayList<String>();
			tblHeading=prepareList(PageGridTable);
			
			if (Page.equalsIgnoreCase("Program")) 
			{
				if (tblHeading.contains("Program Name") && tblHeading.contains("Program Status"))
				{
					return true;
				}
			}
			if(Page.equalsIgnoreCase("Batch"))
			{
				if(tblHeading.contains("Batch Name") && tblHeading.contains("Batch Description") && tblHeading.contains("Batch Status") && tblHeading.contains("No Of Classes") && tblHeading.contains("Program Name") && tblHeading.contains("Edit Delete"))
				{
					return true;
				}
			}
			if(Page.equalsIgnoreCase("Class"))
			{
				if(tblHeading.contains("Batch Id") && tblHeading.contains("Class No") && tblHeading.contains("Class Date") && tblHeading.contains("Class Topic") && tblHeading.contains("Staff Id") && tblHeading.contains("Description") && tblHeading.contains("Comments") && tblHeading.contains("Notes") && tblHeading.contains("Recording"))
				{
					return true;
				}
			}
			if(Page.equalsIgnoreCase("User"))
			{
				if(tblHeading.contains("Id") && tblHeading.contains("Name") && tblHeading.contains("Location") && tblHeading.contains("Phone Number"))
				{
					return true;
				}
			}
			if(Page.equalsIgnoreCase("Assignment"))
			{
				if(tblHeading.contains("Assignment Name") && tblHeading.contains("Assignment Description") && tblHeading.contains("Assignment Due Date") && tblHeading.contains("Assignment Grade"))
				{
					return true;
				}
			}
			if(Page.equalsIgnoreCase("Attendance"))
			{
				if(tblHeading.contains("Class ID") && tblHeading.contains("Student ID") && tblHeading.contains("Present"))
				{
					return true;
				}
			}
			return false;
		}
	
		
		public String GetPageHeaderTitle() {
			return lblPageHeaderTitle.getText();
		}
		
		
		public void ClickMultiDeleteIcon() {
			action.moveToElement(iconMultipleDelete).click().build().perform();
		}
		
		public void EnterSearchContent(String content) {
			txtSearch.clear();
			txtSearch.sendKeys(content);
		}
		
		public void ClickNewButton() {
			action.moveToElement(lblAddnew).click().build().perform();
		}
			
		public boolean IsAddButtonDisplayed() {
			return btnAddNew.isDisplayed();
		}
		public boolean IsSearchBoxDisplayed() {
			return txtSearch.isDisplayed();
		}
		
		public boolean IsMultiDeleteIconEnabled() {
			return iconMultipleDelete.isEnabled();
		}
		
		//Table Header Content Methods
		
		public void ClickMutiSelectCheckBox() {
			action.moveToElement(checkBoxMultipleSelect).click().build().perform();
		}
		
		public List<String> GetSortedOrder(String fieldClicked)  {
			List<String> sortedtList = new ArrayList<String>();
			for(WebElement item:btnSort){
				String fields= item.getDomAttribute("field");
				action.moveToElement(item).click().build().perform();
				
					if (fieldClicked.contains("Program Name")&& fields.contains("Program Name") ){
						fields= item.getDomAttribute("field");
						sortedtList= prepareList(sortedProgramNameList);
						return sortedtList;
					}
					if(fieldClicked.contains("Program Description") && fields.contains("Program Description")) {
						fields= item.getDomAttribute("field");
						sortedtList= prepareList(sortedProgramDescList);
						return sortedtList;
					}
					if(fieldClicked.contains("Program Status")&& fields.contains("Program Status") ) {
						fields= item.getDomAttribute("field");
						sortedtList= prepareList(sortedProgramStatusList);
						return sortedtList;
					}
					
			} 
			return sortedtList;
		}
		
		//Table Body Content Methods
		
		public int GetRecordCount() {
			
			return PageGridDetail.size();
		}
		
		public int ClickSingleSelectCheckbox(int index) {
			action.moveToElement(checkboxSingleSelect.get(index)).click().build().perform();
			return index;
		}
		
		public Boolean CheckSingleSelectCheckboxenabled(WebElement PageGridTable)
		{
			List<WebElement> checkBoxes = PageGridTable.findElements(By.xpath("//button[text()='Edit']"));
			
			Boolean areEnabled = true;
			for(WebElement checkBox : checkBoxes)
			{
				if(!checkBox.isEnabled())
					areEnabled = false;
			}
			
			return areEnabled;
		}
		public void ClickSingleEditButton(int index) {
			action.moveToElement(iconEdit.get(index)).click().build().perform();
		}
		
		public void ClickSingleDeleteIcon(int index) {
			action.moveToElement(iconDelete.get(index)).click().build().perform();
		}
		
		//Page Footer content Methods
		
		public String GetPaginationShowEntries() {
			return lblPaginationEntries.getText();
		}
		
		public String getFooterTotalRecord() {
			return lblTotalCount.getText();
		}
		
		public boolean IsFirstpageLoaded() {
			if (PageNoButtonList.size()>=1) {
				action.moveToElement(btnFirstpage).click().build().perform();
				return btnFirstpage.isEnabled();
			}
			return false;
		}
		public boolean IsFirstpageButtonEnabled() {
			if (PageNoButtonList.size()>=1) 
				return btnFirstpage.isEnabled();
			return false;
		}
		public boolean IsSecondpageLoaded() {
			if (PageNoButtonList.size()>1) 
				return btnSecondpage.isEnabled();
			return false;
		}
		
		public boolean IsSecondPageButtonEnabled() {
			if (PageNoButtonList.size()>1) 
				return btnSecondpage.isEnabled();
			return false;
		}
		public void ClickPreviousNavigationButton() {
			if (PageNoButtonList.size()>1) 
				action.moveToElement(btnPreviouspage).click().build().perform();
		}
		public boolean IsPreviousNavigationDisabled() {
			return btnPreviouspage.isEnabled();
		}
		
		public boolean IsNextNavigationDisabled() {
			return btnNextpage.isEnabled();
		}
		public void ClickNextNavigationButton() {
			if (PageNoButtonList.size()>1) action.moveToElement(btnNextpage).click().build().perform();
		}

		public void ClickLastNavigationButton() {
			if (PageNoButtonList.size()>1) action.moveToElement(btnLastspage).click().build().perform();
		}
		
		public String getSuccessMessage()
		{
		String successMessage = successAlertMessage.getText();
		return successMessage;
		}
		public Boolean VerifyPaginationControlsPresent()
		{
			
			if(btnFirstpage.isDisplayed() && btnSecondpage.isDisplayed() && btnPreviouspage.isDisplayed() && btnNextpage.isDisplayed() && btnLastspage.isDisplayed() && lblTotalCount.isDisplayed())
			{
				return true;
			}
			else{
				return false;
			}
		}
		public Boolean IsEditButtonInTableRows(WebElement PageGridTable)
		{
			List<WebElement> editButtons = PageGridTable.findElements(By.xpath("//button[text()='Edit']"));
			List<WebElement> rows = PageGridTable.findElements(By.tagName("//tr"));
			
			if(editButtons.size() == rows.size())
				return true;
			else
				return false;
		}
		
		public Boolean IsEditButtonEnabledInTableRows(WebElement PageGridTable)
		{
			List<WebElement> editButtons = PageGridTable.findElements(By.xpath("//button[text()='Edit']"));
			
			Boolean areEnabled = true;
			for(WebElement editButton : editButtons)
			{
				if(!editButton.isEnabled())
					areEnabled = false;
			}
			
			return areEnabled;
		}
		
		public Boolean IsDeleteButtonInTableRows(WebElement PageGridTable)
		{
			List<WebElement> deleteButtons = PageGridTable.findElements(By.xpath("//button[text()='Delete']"));
			List<WebElement> rows = PageGridTable.findElements(By.tagName("//tr"));
			
			if(deleteButtons.size() == rows.size())
				return true;
			else
				return false;
		}
		
		public Boolean IsDeleteButtonEnabledInTableRows(WebElement PageGridTable)
		{
			List<WebElement> deleteButtons = PageGridTable.findElements(By.xpath("//button[text()='Edit']"));
			
			Boolean areEnabled = true;
			for(WebElement deleteButton : deleteButtons)
			{
				if(!deleteButton.isEnabled())
					areEnabled = false;
			}
			
			return areEnabled;
		}
		
		public Boolean IsCheckBoxInTableRows(int checkBoxSize,int rowSize)
		{
			if(checkBoxSize == rowSize)
				return true;
			else
				return false;
		}
		public Boolean ValidateFooterText(WebElement element, String expectedPartialText)
		{
			if(element.getText().contains(expectedPartialText) || element.getText().equalsIgnoreCase(expectedPartialText))
					return true;
			else
				return false;
		}
		public boolean disabledDeleteButton()
		{
			if(iconMultipleDelete.isEnabled())
			{
				return false;
			}
			else
			{
				return true;
			}
		}
		


}

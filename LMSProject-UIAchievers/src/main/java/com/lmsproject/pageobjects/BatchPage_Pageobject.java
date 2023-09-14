package com.lmsproject.pageobjects;

import java.util.HashMap;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.lmsproject.components.ExcelDataInputReader;
import com.lmsproject.utility.CommonWebElements;


public class BatchPage_Pageobject {
	
	WebDriver driver;
	private final static Logger LOG = LogManager.getLogger(BatchPage_Pageobject.class);
	ExcelDataInputReader readInput = new ExcelDataInputReader();
	
	CommonWebElements comElement;
	
	@FindBy(id= "batch_Name")
	WebElement batchName;
	@FindBy(id= "batch_Desc")
	WebElement batchDescription;
	@FindBy(xpath = "//div[@class='list-group-programName']")
	WebElement programNameDropDownElement;
	@FindBy(xpath = "//div[@class='activestatus']")
	WebElement batchActiveStatus;
	@FindBy(xpath = "//div[@class='inactivestatus']")
	WebElement batchInActiveStatus;
	@FindBy(id = "Status")
	WebElement batchStatusId;
	@FindBy(id="noofclasses")
	WebElement no_of_Classes;
	@FindBy(xpath="//button[@icon='save']")
	WebElement saveButton;
	@FindBy(linkText="batch")
	WebElement clickBatchLink;
	@FindBy(xpath = "//h2[text()='Manage Batch']")
	WebElement batchHeader;
	@FindBy(xpath ="//div[@role='dialog']")
	WebElement batchDialogBox;
	@FindBy(xpath ="//div[@role='dialog']/div")
	WebElement batchDialogBoxTitle;
	@FindBy(xpath="//div[@class='alert alert-primary')")
	WebElement alertMsg;
			
	
	

	
	@FindBy(xpath = "//checkbox")
	List<WebElement> checkboxes;
	
	@FindBy(tagName ="//tr")
	List<WebElement> rows;
	
	@FindBy(xpath = "//div[@class = 'pageGirdTable']")
	WebElement pageGridTable;
	
	boolean validButton;
	@FindBy(xpath ="//div[@role='deletedialog']")
	WebElement batchdeleteDialogBox;
	@FindBy(xpath ="//div[@role='deletedialogyes']")
	WebElement batchdeleteYes;
	@FindBy(xpath ="//div[@role='deletedialogno']")
	WebElement batchdeleteNo;
	@FindBy(id="Batch_id")
	WebElement getBatchIDfromDeleteDialog;
	@FindBy(xpath ="//div[@class='rt-tr-group']")
	List<WebElement> getBatchList;

	
	
	String successMessage="";
	String errorMessage = "";
	//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
	Actions act;
	
	public BatchPage_Pageobject(WebDriver driver) {
		this.driver = driver;
		ExcelDataInputReader.loadProperties();
		PageFactory.initElements(driver, this);
		comElement = new CommonWebElements(driver);
		act = new Actions(driver);
	}
	
	public void landingDashboardPage()
	{
		driver.get("https://example.com/login");
	}
	public String clickBatchLink()
	{
		clickBatchLink.click();
		String urlText = clickBatchLink.getAttribute("href");
		String currentURL = driver.getCurrentUrl();
		if(currentURL.contains(urlText))
		{
			successMessage = "ManageBatch";
		}
		else
		{
			successMessage = "wrong URL";
		}
		return successMessage;
	}
	
	public String verifyHeader()
	{
		String headerName = batchHeader.getText();
		return headerName;
	}
	
	public boolean verifyPaginationControl()
	{
		validButton = comElement.VerifyPaginationControlsPresent();
		return validButton;
	}
	
	public boolean verifyDataTableHeaders(String pageName)
	{
		validButton = comElement.IsPageLoaded(pageName);
		return validButton;
				
	}
	public boolean verifyDeleteIconDisabled()
	{
		validButton = comElement.disabledDeleteButton();
		return validButton;
	}
	
	public boolean verifyNewBatch_AddButton_Enabled()
	{
		validButton=comElement.IsAddButtonDisplayed();
		return validButton;
	}
	public boolean verifyCheckBoxForEachRow()
	{
		validButton = comElement.IsCheckBoxInTableRows(checkboxes.size(),rows.size());
		return validButton;
	}
	
	public boolean verifyEditButtonEnabledForEachRow()
	{
		validButton = comElement.IsEditButtonEnabledInTableRows(pageGridTable);
		return validButton;
	}
	public boolean verifyDeleteButtonEnabledForEachRow()
	{
		validButton = comElement.IsDeleteButtonEnabledInTableRows(pageGridTable);
		return validButton;
	}
	public void clickNewButton()
	{
		comElement.ClickNewButton();
	}
	public boolean verifyPopUpWindowforAddBatch()
	{
		
		//wait.until(ExpectedConditions.visibilityOf(batchDialogBox));
		return batchDialogBox.isDisplayed();
	}
	public String BatchDialogBoxTitle()
	{
		return batchDialogBoxTitle.getText();
	}
	public HashMap<String,String> BatchDialogBoxDetails()
	{
		HashMap<String,String> batchFormDetails = new HashMap<String,String> ();
		batchFormDetails.put("batchName", batchName.getText());
		batchFormDetails.put("BatchDescription", batchDescription.getText());
		batchFormDetails.put("ProgramName", programNameDropDownElement.getText());
		batchFormDetails.put("status", batchStatusId.getText());
		batchFormDetails.put("No of Classes", no_of_Classes.getText());
		
		
		
		
		return batchFormDetails;
	}
	
	public void landingPopUpPage()
	{
		driver.get("https://example.com/login");
	}
	public void validBatchCredentials()
	{
		batchName.sendKeys((ExcelDataInputReader.getBatchName()));
		batchDescription.sendKeys(ExcelDataInputReader.getBatchDesc());
		Select dropDown = new Select(programNameDropDownElement);
		dropDown.selectByVisibleText(ExcelDataInputReader.getProgramName());
		if(ExcelDataInputReader.getBatchStatus().equalsIgnoreCase("Active"))
		{
			batchActiveStatus.click();
		}
		else if(ExcelDataInputReader.getBatchStatus().equalsIgnoreCase("InActive"))
		{
			batchInActiveStatus.click();
		}
		no_of_Classes.sendKeys(ExcelDataInputReader.getNoofclasses());
		saveButton.click();
	}
	public void validBatchCredentialsToEdit(String batchNam,String BatchDesc,String ProgramName,String Status,String NoofClasses)
	{
		batchName.sendKeys(batchNam);
		batchDescription.sendKeys(BatchDesc);
		Select dropDown = new Select(programNameDropDownElement);
		dropDown.selectByVisibleText(ProgramName);
		if(Status.equalsIgnoreCase("Active"))
		{
			batchActiveStatus.click();
		}
		else if(Status.equalsIgnoreCase("InActive"))
		{
			batchInActiveStatus.click();
		}
		no_of_Classes.sendKeys(NoofClasses);
		saveButton.click();
	}
	public String getSuccessMessage()
	{
		successMessage=comElement.getSuccessMessage();
		return successMessage;
	}
	
	public void validateInvalidCredentials(String batchId,String batchDes,String pgmName,String status,String  NoC)
	{
		batchName.sendKeys(batchId);
		batchDescription.sendKeys(batchDes);
		programNameDropDownElement.sendKeys(pgmName);
		batchActiveStatus.sendKeys(status);
		no_of_Classes.sendKeys(NoC);
		saveButton.click();
	}
	public String geterrorMessage()
	{
	    errorMessage = alertMsg.getText();
    	return errorMessage;
	}
	
	public void checkDeleteIconisEnabled()
	{
		comElement.IsMultiDeleteIconEnabled();
	}
	
	public void clickDeleteIconinBatch()
	{
		comElement.ClickSingleDeleteIcon(0);
	}
	
	public String clickYesinBatchDeleteDialog()
	{
		String batchIdinDeleteDialogBox = getBatchIDfromDeleteDialog.getText();
		batchdeleteYes.click();
		return batchIdinDeleteDialogBox;
	}
	public boolean validateBatchValueafterGiveYes(String batchID)
	{
		if(getBatchList.contains(batchID))
		{
			return false;
		}
		else
		{
		return true;
		}
	}
	public String clickNoinBatchDeleteDialog()
	{
		String batchIdinDeleteDialogBox = getBatchIDfromDeleteDialog.getText();
		batchdeleteNo.click();
		return batchIdinDeleteDialogBox;
	}
	public boolean validateBatchValueafterGiveNo(String batchID)
	{
		if(getBatchList.contains(batchID))
		{
			return true;
		}
		else
		{
		return false;
		}
	}
	public void validatecheckBoxesareEnabled()
	{
		comElement.CheckSingleSelectCheckboxenabled(pageGridTable);
	}
	public boolean validateMultipleDeleteIcon()
	{
		return comElement.IsMultiDeleteIconEnabled();
	}
	public boolean GetDeleteDialogBoxTitle() {

		try {
			if(batchdeleteYes.isDisplayed() && batchdeleteNo.isDisplayed())
			{
				validButton= true;	
			}
			else
			{
				validButton= false;
			}
		}
		catch(Exception NoSuchElementException) {
			validButton= false;
		}
		return validButton;
			
	}
	public String ClickDeleteConfirmation(String Confirmation) {

		if (Confirmation.equalsIgnoreCase("Yes")) {
			act.moveToElement(batchdeleteYes).click().build().perform();
			WebElement MsgElement = driver.findElement(By.xpath("//ConfirmationMessage"));
			return MsgElement.getText();
		}
		else if  (Confirmation.equalsIgnoreCase("No")) {
			act.moveToElement(batchdeleteNo).click().build().perform();;
			

		}
		return "";
	}
	public void selectAnyOneofCheckBox(int index)
	
	{
		comElement.ClickSingleSelectCheckbox(0);
		
	}
	public void clickDeleteUnderHeader()
	{
		comElement.ClickMultiDeleteIcon();
	}
	public void selectMoreThanCheckBoxForDelete(List<Integer> deleteMultipleRows)
	{
		for(int i=1;i<=deleteMultipleRows.size();i++)
		{
			for(WebElement batchLi : getBatchList)
			{
				batchLi.click();
				}
		}
		
	}
	public boolean rowofBatch_Got_Deleted(int index)
	{
		
		if(getBatchList.get(index).isDisplayed())
		{
			return false;
		}
		else
		{
			return true;
		}
		
	}
	public boolean rowsofBatch_Got_Deleted(List<Integer> deleteMultipleRows)
	{
		if(getBatchList.contains(deleteMultipleRows))
		{
			return false;
		}
		else
		{
			return true;
		}
			
	}
	
	public void editIconOnRowLevelEnabled()
	{
		comElement.IsEditButtonEnabledInTableRows(pageGridTable);
	}
	public void clickEditButton(int index)
	{
		comElement.ClickSingleEditButton(0);
	}

}

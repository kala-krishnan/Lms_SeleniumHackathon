package com.lmsproject.pageobjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.lmsproject.components.ExcelDataInputReader;

public class AddOrEditProgramPage_Pageobject {
	
	WebDriver driver;
	Actions action;
	
	// public static WebDriverWait Wdwait;

	public AddOrEditProgramPage_Pageobject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		System.out.println("Add or Edit page");
	}

	// display add program dialog box
	@FindBy(xpath = "//div[@role='dialog")
	WebElement programDialog;
	@FindBy(xpath = "//p-dialog//div[@role='dialog']")
	WebElement lblDialogTitle;

	// dialog page elements , add new program
	@FindBy(id = "ProgramName")
	WebElement txtProgName;
	@FindBy(id = "ProgramDescription")
	WebElement txtProgDescription;
	@FindBy(id = "ProgramName")
	WebElement lblProgName;
	@FindBy(id = "ProgramDescription")
	WebElement lblProgDescription;
	@FindBy(xpath = "//label[@id='ProgramStatus']")
	WebElement lblprogramStatus;
	@FindBy(xpath = "//p-radiobutton[@id='Active']")
	WebElement statusActive;
	@FindBy(xpath = "//p-radiobutton[@id='Inactive']")
	WebElement statusInActive;
	@FindBy(id = "btnANewProgram")
	WebElement btnAddProgram;
	@FindBy(id = "txtMessage")
	WebElement txtMessage;
	@FindBy(xpath = "//button[@label='Cancel']")
	WebElement btnCancel;
	@FindBy(xpath = "//button[@label='Save']")
	WebElement btnSave;
	@FindBy(xpath = "//button[@label='Close']")
	WebElement btnClose;

	public boolean verifyFields() {
		boolean programName = lblProgName.isDisplayed();
		boolean programDesc = lblProgDescription.isDisplayed();
		boolean programStatus = lblprogramStatus.isDisplayed();
		boolean active = statusActive.isDisplayed();
		boolean inactive = statusActive.isDisplayed();
		boolean closeXbutton = btnClose.isDisplayed();
		boolean save = btnSave.isDisplayed();
		boolean cancel = btnCancel.isDisplayed();
		if (programName && programDesc && programStatus && save && cancel && closeXbutton && active && inactive) {
			return true;
		} else {
			return false;
		}
	}

	public void clickAddNewProgram() {
		btnAddProgram.click();
	}

	public boolean isProgramDialogBoxVisible() {
		// Wdwait.until(ExpectedConditions.visibilityOf(programDialog));
		return programDialog.isDisplayed();
	}

	public String ProgramDialogBoxTitle() {
		return lblDialogTitle.getText();

	}

	public void EnterProgramDetails(String name, String description, String active) {
		txtProgName.clear();
		txtProgName.sendKeys(name);
		txtProgDescription.clear();
		txtProgDescription.sendKeys(description);
		if (active.equals("Active"))
			action.moveToElement(statusActive).build().perform();
		else
			action.moveToElement(statusInActive).build().perform();

	}

	public void VerifyMissingMandatoryErrorMessage(String message) {
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals(alert.getText(), message);
		alert.accept();

	}
	public void landingPopUpPage()
	{
		driver.get("https://example.com/login");
	}
	
	public void validProgramCredentials()
	{
		txtProgName.sendKeys((ExcelDataInputReader.getProgramName()));
		txtProgDescription.sendKeys(ExcelDataInputReader.getProgramDesc());
		
		if(ExcelDataInputReader.getProgramStatus().equalsIgnoreCase("Active"))
		{
			statusActive.click();
		}
		else if(ExcelDataInputReader.getProgramStatus().equalsIgnoreCase("InActive"))
		{
			statusActive.click();
		}

		btnSave.click();
	}
	
	public void validateInvalidCredentials(String pgmName,String programDes,String status)
	{
		txtProgName.sendKeys(pgmName);
		txtProgDescription.sendKeys(programDes);
		statusActive.sendKeys(status);
		btnSave.click();
	}
}

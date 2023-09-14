 package com.lmsproject.pageobjects;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
 
public class ClassDetailPopup_Pageobject {
	
	WebDriver driver;
	Actions action;
//	private static final Logger LOG = (Logger) LogManager.getLogger(ClassDetailPopup_Pageobject.class);

	public ClassDetailPopup_Pageobject(WebDriver driver)
	 { 
		
	  this.driver = driver;
	  PageFactory.initElements(driver, this);
	   
	 }
@FindBy(xpath="//button[@id='Class']") WebElement classLink;
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
@FindBy(xpath = "//button[@id = Save")WebElement saveButton;
@FindBy(xpath = "//button[@id = Cancel")WebElement cancelButton;
@FindBy(xpath = "//button[@id = Close")WebElement closeBox;
Boolean Save = driver.findElement(By.xpath("//button[@id='Save']")).isDisplayed();
Boolean Cancel = driver.findElement(By.xpath("button[@id='Cancel']")).isDisplayed();
Boolean Close = driver.findElement(By.xpath("//*[@id='close']")).isDisplayed();

public void webpage() {
	driver.get("https://example.com/login");
}

public void ClickOnCLassButton()
{
	classLink.click();
}
public void ClickOnNewClassButton()
{
	lblAddnewClass.click();
}
public void CheckOnNewClassWindow()
{
	classLink.click();
 System.out.println(driver.getTitle());
String expectedTitle = "Class Details";
String title = driver.getTitle();
if (title.equalsIgnoreCase(expectedTitle)) {
    System.out.println("Title Matched");
} else {
    System.out.println("Not a match");
}
}
public void GetAllText()
{
	  
	 String t = "Class Details";
        
       if (driver.getPageSource().contains("Class Details")) {
           System.out.println("Text: " + t + " is present. ");
       } else {
           System.out.println("Text: " + t + " is not present. ");
       }
}
public String getPageTitle() {
	 
		String title = driver.getTitle();
		return title; 
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
public void CHeckOnAllTextBox() {
	

List<WebElement> textboxes = driver.findElements(By.xpath("dijitReset dijitInputInner']"));

System.out.println(textboxes.size());

for(int i=1; i<=textboxes.size(); i=i+1);
{
    System.out.println(textboxes.size());  
//    LOG.info("All the Text boxes are there");
}
}
public boolean CheckOnDropDown()
{
Boolean dropdownPresent = batchIdCol.isDisplayed();
{
if(dropdownPresent==true)
{
    System.out.println("Dropdown is appearing");
}
else{
    System.out.println("Dropdown is not appearing");
}
}
return false;
}
public boolean CheckOnDropDown2()
{
Boolean dropdownPresent = staffIdFld.isDisplayed();
{
if(dropdownPresent==true)
{
    System.out.println("Dropdown is appearing");
}
else{
    System.out.println("Dropdown is not appearing");
}
}
return false;
}
public void CheckOnCalendar()
{
 
classDateFld.isEnabled();
}
public void addSaveConfirm(String save)
{
	
	if (save.equalsIgnoreCase("Save"))
	{
		saveButton.isEnabled();
		 System.out.println("Save Button is Present");
	}
	else 
	{
		System.out.println("Save Button is Not Present");
	}
	 
			
}
public void addCancelConfirm(String cancel)
{
	if (cancel.equalsIgnoreCase("Cancel"))
	{
		cancelButton.isEnabled();
		 System.out.println("Cancel Button is Present");
	}
	else 
	{
		System.out.println("Cancel Button is Not Present");
	}		
}
public void CheckOncloseButton()
{
	closeBox.isDisplayed();
}
}

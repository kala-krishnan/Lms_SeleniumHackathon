package com.lmsproject.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DeleteConfirmDialogBox {
	Actions action;
    WebDriver driver;
    public static WebDriverWait Wdwait;
    
    public DeleteConfirmDialogBox(WebDriver driver ) {
        action =new Actions(driver);
        PageFactory.initElements(driver,this);
    }
    
    public @FindBy(xpath="//confirmdeletedialog//Title") WebElement DeleteDialogTitle;
    public @FindBy(xpath="//button[@id ='yes']") WebElement DeleteDialogYes;
    public @FindBy(xpath="//button[@id ='no']") WebElement DeleteDialogNo;
    
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
        System.out.println("Yes the dialog is visible");
        
        return true;
    }
    
    public String ClickDeleteConfirmation(String Confirmation) {
        if (Confirmation.equalsIgnoreCase("Yes")) {
            action.moveToElement(DeleteDialogYes).click().build().perform();
//            Wdwait.until(ExpectedConditions.invisibilityOf(DeleteDialogYes));
            WebElement MsgElement = driver.findElement(By.xpath("//ConfirmationMessage"));
            return MsgElement.getText();
        }
        else if  (Confirmation.equalsIgnoreCase("No")) {
            action.moveToElement(DeleteDialogNo).click().build().perform();;
        }
        return"NA";
    }
}

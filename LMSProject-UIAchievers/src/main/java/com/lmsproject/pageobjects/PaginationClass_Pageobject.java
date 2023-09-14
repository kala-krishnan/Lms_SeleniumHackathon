package com.lmsproject.pageobjects;

import java.util.List;
import java.util.logging.Logger;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class PaginationClass_Pageobject {
	
	 
	WebDriver driver;
	Actions action;
	String successpage="";
//	private static final Logger LOG = (Logger) LogManager.getLogger(Class01_ManageClass_stepdef.class);

public PaginationClass_Pageobject(WebDriver driver)
{ 
	
 this.driver = driver;
 PageFactory.initElements(driver, this);
  

} 
 @FindBy(linkText="DashBoard")WebElement dashBoardPageEle;
 @FindBy(linkText="Class")WebElement classPageEle;
 @FindBy(xpath = "//paginator") WebElement lblPaginationEntries;
@FindBys({@FindBy(xpath = "//paginator//button") })List<WebElement> PageNoButtonList;
@FindBy (xpath="//a[contains(text(),'Add New Class')]")WebElement addNewClassButton;
@FindBy(xpath = "//paginator/button[1]") WebElement btnFirstpage;
@FindBy(xpath = "//paginator/button[2]") WebElement btnSecondpage;
@FindBy(xpath = "//paginator/button[3]") WebElement btnPreviouspage;
@FindBy(xpath = "//paginator/button[4]") WebElement btnNextpage;
@FindBy(xpath = "//paginator/button[5]") WebElement btnLastspage;
@FindBy(xpath = "//paginator/button[6]") WebElement lblTotalCount;

@FindBys({@FindBy(xpath = "//paginator/button") })List<WebElement> btnPagination;
 
public void webpage() {
	driver.get("https://example.com/login");
}	
public void CheckOnDashBoardPagelink()
	{
		dashBoardPageEle.isDisplayed();
	}
public void ClickonClassPageLink()
{
	classPageEle.isEnabled();
}
public void CheckOnClassPageLink()
{
	classPageEle.isDisplayed();
}
public String GetPaginationShowEntries() {
	return lblPaginationEntries.getText();
}
public String getFooterTotalRecord() {
	return lblTotalCount.getText();
}
public void ClickAddNewClassButton()
{
	addNewClassButton.click();
}
public String successmsg()
{
	 successpage = driver.getTitle();
	return successpage;
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
		 
}
package com.lmsproject.pageobjects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class SortFunction_Pageobject {

	WebDriver driver;
	Actions action;
//	private static final Logger LOG = (Logger) LogManager.getLogger(SortFunction_pageobj.class);

	public SortFunction_Pageobject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		driver.get("https://example.com/login");
	}
	@FindBy(xpath="//button[@id='Class']") WebElement classLink;
	 @FindBy(linkText="ManageClass")WebElement manageClassLink;
	 @FindBy(xpath="//button[@id='Batch Id']") WebElement batchEle;
	@FindBys({ @FindBy(xpath = "//table//sorticon") })
	List<WebElement> btnSort;
	@FindBys({ @FindBy(xpath = "//table//sort-icon1") })
	List<WebElement> sortedBatchId;
	
	public void webpage() {
		driver.get("https://example.com/login");
	}
	public void ClickOnManageClassLink()
	 {
		 List<WebElement> downloadHeader = driver.findElements(By.xpath("//h2[contains(text(), 'Manage Classes page')]"));
		 if(downloadHeader.size() > 0)
		 {
		     System.out.println("Found header Manage Classes Page");
		     
		 }
	 }
	public void ClickOnBatchIcon()
	{
		batchEle.click();  
	}
	private List<String> prepareList(List<WebElement> we) {
		List<String> sortList = new ArrayList<String>();
		for (WebElement item : we) {
			sortList.add(item.getText());
		}
		return sortList;
	}

	public List<String> GetSortedAscOrder(String fieldClicked) {
		List<String> sortedtList = new ArrayList<String>();
		for (WebElement item : btnSort) {
			String fields = item.getDomAttribute("field");
// Sorting in natural order or ascending order
			List sortedListAsc = sortedtList.stream().sorted().collect(Collectors.toList());
			if (fieldClicked.contains("Batch Id") && fields.contains("Batch Id")) {
				fields = item.getDomAttribute("field");
				sortedtList = prepareList(sortedBatchId);
			}

		}
		return sortedtList;
	}

	public List<String> GetSortedDscOrder(String fieldClicked1) {
		List<String> sortedtList1 = new ArrayList<String>();
		for (WebElement item : btnSort) {
			String fields = item.getDomAttribute("field");

// Sorting in descending order
			List sortedListDesc = sortedtList1.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

			sortedtList1 = prepareList(sortedBatchId);

//			LOG.info("Table is displayed in descending order");
		}
		return sortedtList1;
	}
	public void ClickOnClass() {
		classLink.click(); 
		
	}
}

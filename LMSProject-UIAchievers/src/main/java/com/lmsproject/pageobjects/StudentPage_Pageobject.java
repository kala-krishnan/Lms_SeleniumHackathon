package com.lmsproject.pageobjects;



import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class StudentPage_Pageobject {
		
		public int code;
		public String url;
		public WebDriver driver;

		public java.util.List<WebElement> selectBoxOptions;

		public StudentPage_Pageobject(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
//		  acts= new Actions(driver);
		}
		@FindBy(xpath = "//button[@id='student']")
		WebElement student;
		@FindBy(xpath = "//h1[contains(text(),'Student Detail')]")
		WebElement titleElement;
		@FindBy(id = "dropdown")
		WebElement drpdwn;
		@FindBy(id = "searchBox")
		WebElement searchbox;
		@FindBy(id = "batchIdDropdown")
		WebElement batchIdDropdown;
		@FindBy(id = "studentNameDropdown")
		WebElement studentNameDropdown;
		@FindBy(id = "studentPage")
		WebElement studentPage;
		@FindBy(id = "searchBoxInput")
		WebElement searchBox;

		public void dash() {
			driver.get("https://example.com/login");
		}

		public void student_btn() {
			student.click();

		}

		public String pgtitle() {
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

		public void timeout() {
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		}

		public void element_align() {
			String script = "arguments[0].style.textAlign='center';";
			((JavascriptExecutor) driver).executeScript(script, titleElement);
		}

		public List<WebElement> dropdown() {
			List<WebElement> dropdowns = driver.findElements(By.tagName("select"));
			System.out.println("size of the drop down:" + dropdowns.size());
			// Check if at least two dropdowns are present
			if (dropdowns.size() >= 2) {
				System.out.println("At least two dropdowns are present on the page.");
			} else {
				System.out.println("Less than two dropdowns are present on the page.");
			}
			return dropdowns;
		}

		public WebElement searchBox(String type) {
			WebElement searchBox = drpdwn.findElement(By.id(type));
			searchBox.click();
			// Don't forget to close the WebDriver when done
			driver.quit();
			if (searchbox.isDisplayed()) {
				System.out.println("The search box is present inside the dropdown for Admin.");
				return searchBox;
			} else {
				System.out.println("The search box is not present inside the dropdown for Admin.");
				return null;
			}
		}

		public void studentSearch(String dropdownId, String searchBoxInput) {

			WebElement searchBox = driver.findElement(By.id(searchBoxInput));

			// Get the value of the search box
			String searchBoxValue = searchBox.getAttribute("value");

			WebElement dropdownElement = driver.findElement(By.id(dropdownId));

			// Create a Select object to work with the dropdown
			Select dropdown = new Select(dropdownElement);

			// Get all the available options from the dropdown
			selectBoxOptions = dropdown.getOptions();
			// Iterate through the options and compare with the desired text
			for (WebElement option : selectBoxOptions) {
				String optionText = option.getText();
				if (optionText.equals(searchBoxValue)) {
					// If the option matches the desired text, perform your action here
					System.out.println("Desired text found: " + optionText);

					// For example, select the option
					option.click();
					break; // Exit the loop once the desired option is found
				}
			}

		}

		public void batchIdDropdownn() {
			Select select = new Select(batchIdDropdown);

			// Iterate through the options and verify that they contain only numbers
			for (WebElement option : select.getOptions()) {
		//		assertTrue(option.getText().matches("^[0-9]+$"));
			}

			driver.quit();
		}

		public void studentNameColor(String dropdownId, String searchBoxInput) {
			WebElement searchBox = driver.findElement(By.id(searchBoxInput));

			// Get the value of the search box
			String searchBoxValue = searchBox.getAttribute("value");
			WebElement dropdownElement = driver.findElement(By.id(dropdownId));
			// Create a Select object to work with the dropdown
			Select dropdown = new Select(dropdownElement);
			// Get all the available options from the dropdown
			selectBoxOptions = dropdown.getOptions();
			// Iterate through the options and compare with the desired text
			for (WebElement option : selectBoxOptions) {
				String optionText = option.getText();
				if (optionText.contains("gray color")) {
					// If the option matches the desired text, perform your action here
					System.out.println("Desired text found in gray color: " + optionText);

					// For example, select the option
					option.click();
					break; // Exit the loop once the desired option is found
				}
			}
		}

		public void studentNameAsTheFirstOption() {
			// WebElement studentNameDropdown =
			// driver.findElement(By.id("studentNameDropdown")); // Replace with the actual
			// ID
			Select select = new Select(studentNameDropdown);
			// Get the text of the first option in the dropdown
			WebElement firstOption = select.getFirstSelectedOption();
			String firstOptionText = firstOption.getText();
			//Assert.assertEquals("Select Student Name", firstOptionText);
			driver.quit();

		}

		public void batchIDAsSecondOption() {
			Select select = new Select(batchIdDropdown);
			WebElement secondOption = select.getFirstSelectedOption();
			String secondOptionText = secondOption.getText();
		//	Assert.assertEquals("Select Batch Id", secondOptionText);
			driver.quit();
		}

		public void ableToScrollAndSelectStudentNmae() {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", studentNameDropdown);

		}

		public void ableToScrollAndSelectBatchId() {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", batchIdDropdown);

		}

		public void studentPage() {
			driver.navigate().to("StudentPage");
			studentPage.click();
			String studentPageTitle = driver.getTitle();
			System.out.println("Student Page title is" + studentPageTitle);

		}

		public void selectStudentFromDropdown() {
			Select select = new Select(studentNameDropdown);
			select.selectByValue("StudentName");

		}

		public void selectBatchFromDropdown() {
			Select select = new Select(batchIdDropdown);
			select.selectByValue("BatchId");

		}

		public boolean studentSearchBox() {
			// searchBox.sendKeys("x");
			java.util.List<WebElement> studentNameElements = driver.findElements(By.id("student-name"));
			// Replace with the actual CSS selector

			// Iterate through the list of student names and check if they start with "x"
			boolean allStartWithX = true;
			for (WebElement element : studentNameElements) {
				String studentName = element.getText();
				if (!studentName.startsWith("x")) {
					allStartWithX = false;
					break; // Exit the loop if a name doesn't start with "x"
				}
			}
			return allStartWithX;

		}

		public boolean batchSearchBox() {
			java.util.List<WebElement> batchidElements = driver.findElements(By.id("batchid"));
			// Replace with the actual CSS selector

			// Iterate through the list of student names and check if they start with "x"
			boolean allStartWithX = true;
			for (WebElement element : batchidElements) {
				String studentName = element.getText();
				if (!studentName.startsWith("56")) {
					allStartWithX = false;
					break; // Exit the loop if a name doesn't start with "x"
				}
			}
			return allStartWithX;
		}

		public List<String> selectedBatchIdOnly() {
			WebElement batchIdDropdown = driver.findElement(By.id("studentNameDropdown")); // Replace with the actual ID

			// Create a Select object to work with the dropdown
			Select select = new Select(batchIdDropdown);

			// Select an option from the dropdown (for example, by index)
			select.selectByIndex(2); // Replace with the desired index

			// Get the selected option
			WebElement selectedOption = select.getFirstSelectedOption();

			boolean isStudentNameSelected = true; //selectedOption.isSelected();;

			WebElement studentBatchIdDropdown = driver.findElement(By.id("BatchIdDropdown"));

			// Create a Select object to work with the dropdown
			Select select1 = new Select(studentBatchIdDropdown);

			// Select an option from the dropdown (for example, by index)
			select1.selectByIndex(1); // Replace with the desired index

			// Get the selected option
			WebElement selectedBatchOption = select1.getFirstSelectedOption();
			

			boolean isStudentBatchIdSelected = false ;//selectedBatchOption.isSelected();
			List<String> batchidList = null;

			if (isStudentNameSelected && isStudentBatchIdSelected) {
	            System.out.println("Both options selected.");
				 batchidList = new ArrayList(5);
			} 
			return batchidList;
		}
		
		public List<String> selectedStudentNameOnly() {
			WebElement studentNameDropdown = driver.findElement(By.id("studentNameDropdown")); // Replace with the actual ID

			// Create a Select object to work with the dropdown
			Select select = new Select(studentNameDropdown);

			// Select an option from the dropdown (for example, by index)
			select.selectByIndex(0); // Replace with the desired index

			// Get the selected option
			WebElement selectedOption = select.getFirstSelectedOption();

			boolean isBatchIdSelected = true; //selectedOption.isSelected();;

			WebElement studentBatchIdDropdown = driver.findElement(By.id("studentBatchIdDropdown"));

			// Create a Select object to work with the dropdown
			Select select1 = new Select(studentBatchIdDropdown);

			// Select an option from the dropdown (for example, by index)
			select1.selectByIndex(2); // Replace with the desired index

			// Get the selected option
			WebElement selectedBatchOption = select1.getFirstSelectedOption();
			

			boolean isStudentBatchIdSelected = false ;//selectedBatchOption.isSelected();
			List<String> studentList = null;

			if (isBatchIdSelected && isStudentBatchIdSelected) {
	            System.out.println("Both options selected.");
				 studentList = new ArrayList(5);
			} 
			return studentList;
		}
		public void studentNameAndBatchIdSelected() {
			studentNameDropdown.sendKeys("StudentName");
			batchIdDropdown.sendKeys("BatchId");
		}
	}
	                    


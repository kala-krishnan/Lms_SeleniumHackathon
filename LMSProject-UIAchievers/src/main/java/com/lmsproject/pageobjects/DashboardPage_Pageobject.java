package com.lmsproject.pageobjects;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class  DashboardPage_Pageobject {
	@FindBy(id="username")WebElement userLogin; 
	@FindBy(id="password")WebElement passLogin;
	@FindBy(xpath="//button[@id='login']") WebElement btnLogin;
	@FindBy(css="#header div.cf>h1>a") WebElement element;
	@FindBy(id="name")WebElement title;
	public int x,y,i,j;
	public int code;
	public String url;
	public int pageLoadTime_Seconds;
	public boolean var,var1;
	@FindBy(linkText="student") WebElement stud1;
	@FindBy(linkText="program") WebElement prog;
	@FindBy(linkText="batch") WebElement batch;
	@FindBy(linkText="class") WebElement classes;
	@FindBy(linkText="user") WebElement user;
	@FindBy(linkText="Assignment") WebElement assign;
	@FindBy(linkText="Attend") WebElement attend;
	@FindBy(linkText="logout") WebElement logt;
	@FindBy(id="lms")WebElement lmstext;
	
    
	
	StopWatch pageLoad = new StopWatch();
    
	public WebDriver driver;
	
	public DashboardPage_Pageobject (WebDriver driver) 
	{
		
		 this.driver = driver;
		  PageFactory.initElements(driver, this);
	}
	
	public String headermesg()
	{
		String text = element.getText();
		return text;
	}
	
	public String loginpage()
	{
		String title=driver.getTitle();
		return title;
	}
	
	public void urlLogin()
	{
		driver.get("https://example.com/login");
		btnLogin.click();
		
	}
	public void loginUsingValidDetails(String validUsrName,String validPassword)
	{
	userLogin.sendKeys(validUsrName);
	passLogin.sendKeys(validPassword);
	btnLogin.click();
	}
	
	public void timer()
	{
		  StopWatch pageLoad = new StopWatch();
	        pageLoad.start();
	        //Open your web app (In my case, I opened facebook)
	        driver.get("https://www.facebook.com/");
	        // Wait for the required any element (I am waiting for Login button in fb)
	        WebDriverWait wait = new WebDriverWait(driver,null);
	        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("u_0_l")));

	        pageLoad.stop();
	        //Get the time
	        int pageLoadTime_ms = (int) pageLoad.getTime();
	        int pageLoadTime_Seconds = pageLoadTime_ms / 1000;
	}
	
	public void linkbroker() throws IOException
	{
		List <WebElement>links = 
			      driver.findElements(By.tagName("a"));
			      
			    // Printing The Total Links Number
			    System.out.println("Total Link Size: " + 
			                        links.size());
			    for(int i = 0; i < links.size(); i++)
			    {
			      // Checking Each & Every Links
			      WebElement element = links.get(i);
			          
			      url = element.getAttribute("href");
			  
			      @SuppressWarnings("deprecation")
				URL link = new URL(url);
			      HttpURLConnection httpConn = 
			        (HttpURLConnection) link.openConnection();
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
	
	public String titlelms()
	{
		String title=driver.getTitle();
		return title;
		
	}
	
	public void leftcorner()
	{
//		Actions actions = null;
//		actions.moveToElement(title,0,0).perform();
//		return var;
		
		 Point location = title.getLocation();
		 x=location.getX();
	       y=location.getY();
	      System.out.println("X : " + location.getX());
	        System.out.println("Y : " + location.getY());
	}
	public String navspell()
	{
		String txt=classes.getText();
		return txt;
	}
	
	public String spellspace()
	{
		String txt=assign.getText();
		var1=txt.contains("");
		return txt;
		
	}

	public void rightposition()
	{
		Point right=stud1.getLocation();
		i=right.getX();
		j=right.getY();
	}
		
			public int order(String navgationfieldname)
			{
				List<WebElement> GetStart= driver.findElements(By.xpath("//a[@class='list-group-item']"));
				
				for(int i=0;i<=GetStart.size();i++)
				{
					if(navgationfieldname==GetStart.get(i).getText()) {
						break;
					}
					
				}
				return i;
						
				
			}
			
		
}

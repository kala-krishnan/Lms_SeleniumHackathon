package com.lmsproject.pageobjects;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage_Pageobject {
	public int code;
	public String url;
	public WebDriver driver;
	public BufferedImage expectedimage1,actualimage;
	public HomePage_Pageobject(WebDriver driver)
	 {
	  this.driver = driver;
	  PageFactory.initElements(driver, this);

	 }
	
	@FindBy(xpath="//button[@id='login']") WebElement btnLogin;
	 @FindBy(xpath="//h1[@id='lmslogo']//a//img")WebElement logoElement;
	 @FindBy(tagName="a")WebElement link;

	 
	
	public void urlBrowser()
	{
		driver.get("https://example.com/login");
		
	}

	public void brokenlink() throws IOException {
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
	public void invalidurl()
	{
		driver.get("bestflare.com/te");
	}
	
	public String  validSuccessHomepage()
	{
		String homepageactual=driver.getTitle();
		return homepageactual;
		
	}
	public String notFound()
	{
		String actual=driver.getTitle();
		return actual;
		
	}
	
	public String spellCheck()
	{
		String text = link.getText();
		return text;
	}
	
	public boolean loginButton()
	{
		boolean login = btnLogin.isDisplayed();
		return login;
		
	}
	
	public boolean clickable()
	{
		boolean click=btnLogin.isEnabled();
		return click;
		
	}
	
	public void validlogo()throws IOException
	{
		WebElement logo =driver.findElement(By.xpath("//img[@src='/images/Toolsqa.jpg']"));
		File file = logo.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("logo.png"));
		String ScreenShotImage = ":\\Users\\divya\\git_bkup\\Team14_UIAchievers\\Team14_UIAchievers\\logo.png";
		
		String originalImage = "C:\\Users\\divya\\git_bkup\\Team14_UIAchievers\\Team14_UIAchievers\\src\\test\\resources\\images\\divya.png";
		 BufferedImage image1 = ImageIO.read(new File(ScreenShotImage));
         BufferedImage image2 = ImageIO.read(new File(originalImage));
         boolean areEqual = compareImages(image1, image2);

         if (areEqual) {
             System.out.println("The two images are identical.");
         } else {
             System.out.println("The two images are different.");
         }
	}
         private static boolean compareImages(BufferedImage image1, BufferedImage image2) {
             if (image1.getWidth() != image2.getWidth() || image1.getHeight() != image2.getHeight()) {
                 return false; // Images have different dimensions, so they are different
             }

             for (int x = 0; x < image1.getWidth(); x++) {
                 for (int y = 0; y < image1.getHeight(); y++) {
                     if (image1.getRGB(x, y) != image2.getRGB(x, y)) {
                         return false; // Images have different pixel values, so they are different
                     }
                 }
             }

             return true; // Images are identical
         
	
	}
	public boolean alignlogo()
	{
		Dimension logoSize = logoElement.getSize();
		{
			if((logoSize.getWidth() > 0 && logoSize.getHeight() > 0))
			{
			return true;
			}
			else
			{
			return false;
			}
		}		}
}

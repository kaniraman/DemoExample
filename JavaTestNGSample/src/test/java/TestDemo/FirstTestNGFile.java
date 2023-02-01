package TestDemo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterTest;

public class FirstTestNGFile {
	
    WebDriver driver ; 

	@BeforeMethod
	public void verifyHomepageTitle() {
		System.out.println("Verifying the Homepage");
		String expectedTitle = "Welcome: Mercury Tours";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	@Test
    public void register(){
		System.out.println("Register the user");
        driver.findElement(By.linkText("REGISTER")).click() ;
        String expected = "Register: Mercury Tours";
        String actual = driver.getTitle();
        Assert.assertEquals(actual, expected);
    }
	
        
    @AfterMethod
    public void goBackToHomepage ( ) {
    	 System.out.println("Go Back to the Home Page");
          driver.findElement(By.linkText("Home")).click() ;
    }
    
    @BeforeClass
    public void settingBrowser() {
      System.out.println("Launching the Browser");
  	  System.setProperty("webdriver.chrome.driver", "C:/Users/Kanimozhi_Raman/eclipse-workspace/JavaTestNGSample/src/test/resources/chromedriver.exe");
  	  driver = new ChromeDriver();
  	  driver.get("http://demo.guru99.com/test/newtours/");
    }

	@AfterClass
	public void terminateBrowser(){
		System.out.println("Closing the Browser");
		driver.quit();
	}
}

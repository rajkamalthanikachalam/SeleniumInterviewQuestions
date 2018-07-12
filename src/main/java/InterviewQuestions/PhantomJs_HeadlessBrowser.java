package InterviewQuestions;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/*
 ************ Phantom JS discontinued, this is just for Learning Purpose****************

 * PhantomJS is a headless browser with JavaScript API. It is an optimal solution for Headless Website Testing,
	access and manipulate webpages & comes with the standard DOM API. 

In order to use PhantomJS with Seleniun, one has to use GhostDriver. 
GhostDriver is a implementation of Webdriver Wire protocol in simple JS for PhantomJS. 
Important Features:
	-phantomJSdriver internally uses ghost driver 
	-ghostdriver is used as JSON wire protocol -- HTTP REST calls 
	-headless browser testing: -no browser will be launched 
	-testing is happening behind the scene -its very fast 
	-it directly interacts with your app HTML DOM*/


public class PhantomJs_HeadlessBrowser {
WebDriver driver;
	
	@BeforeTest()
	public void setup(){
				
		System.setProperty("phantomjs.binary.path", "../Selenium_InterviewQuestions/Drivers/phantomjs.exe");
		//WebDriver driver = new PhantomJSDriver();	 Actual code				
		WebDriver driver = new PhantomJSDriver(null);	
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.freecrm.com/");
		
	}
	
	@Test(enabled = true)
	public void headlessBrowser(){
		
		System.out.println("Login Page Title " + driver.getTitle());
		driver.findElement(By.name("username")).clear();
	    driver.findElement(By.name("username")).sendKeys("008rajkamal");
	    driver.findElement(By.name("password")).clear();
	    driver.findElement(By.name("password")).sendKeys("Feb$2018@");
	    driver.findElement(By.xpath("//input[@value ='Login']")).submit();

		System.out.println("Home Page Title " + driver.getTitle());

	}
}


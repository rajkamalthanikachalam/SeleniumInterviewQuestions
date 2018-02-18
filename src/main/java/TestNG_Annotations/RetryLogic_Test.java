package TestNG_Annotations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RetryLogic_Test {
	
	WebDriver driver;
	//if retry logic implemented in class level, we need to remove annotations, Only at Test level, we require "retryAnalyzer = package name of retry class.class"
	
	@BeforeMethod
	public void setup(){
		
		System.setProperty("webdriver.chrome.driver", "../Selenium_InterviewQuestions/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get("https://www.freecrm.com");
		
	}
	
	@Test(retryAnalyzer = com.qa.analyzer.RetryListener.class)
	public void retryAnalyzer_Method(){
		
		driver.findElement(By.name("username")).clear();
	    driver.findElement(By.name("username")).sendKeys("008rajkamal");
	    driver.findElement(By.name("password")).clear();
	    driver.findElement(By.name("password")).sendKeys("Fe$2018@");	//providing bad password, so it will retry to pass the method 1+3(Actual execution + Retry 3)
	    driver.findElement(By.xpath("//input[@value ='Login']")).submit();
	    String HomePageTitle = driver.getTitle();
	    Assert.assertEquals(HomePageTitle, "CRMPRO");
		
	}
		
	@AfterMethod
	public void teardown(){
		driver.quit();
	}

}

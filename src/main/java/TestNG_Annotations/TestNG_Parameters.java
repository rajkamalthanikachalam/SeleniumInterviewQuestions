package TestNG_Annotations;

import org.testng.annotations.Test;

import com.qa.analyzer.RetryListener;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class TestNG_Parameters {
	
	WebDriver driver;
	
	@BeforeTest
	public void setup(){
		
		System.setProperty("webdriver.chrome.driver", "../Selenium_InterviewQuestions/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
	}
	
	@Test
	@Parameters({"URL","UserName"})	// from TestNG.xml file value will be passed to the test
	public void login(String URL, String UserName){
		
		driver.get(URL);
		driver.findElement(By.id("login-username")).sendKeys(UserName);
		driver.findElement(By.id("login-signin")).click();
		String Title = driver.getTitle();
		Assert.assertEquals(Title, "Yahoo - login", "Title not matched");
		
	}
	
	@AfterTest
	public void teardown(){
		
		driver.quit();
		
	}
	

}

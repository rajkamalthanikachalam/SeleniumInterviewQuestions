package InterviewQuestions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HeadlessBrowser {
WebDriver driver;
	
	@BeforeTest()
	public void setup(){
		
		System.setProperty("webdriver.chrome.driver", "../Selenium_InterviewQuestions/Drivers/chromedriver.exe");
		
		ChromeOptions options  = new ChromeOptions();
		options.addArguments("window-size=1400,800"); //Size must set to run in chrome
		options.addArguments("headless");
		driver = new ChromeDriver(options);
	
		//driver = new ChromeDriver();
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


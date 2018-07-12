package InterviewQuestions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Navigate_Back_Forward {

public WebDriver driver;

	@BeforeMethod()
	public void setup(){
		
		System.setProperty("webdriver.chrome.driver", "../Selenium_InterviewQuestions/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	}

	@Test()
	public void navigate(){

		driver.get("https://www.freecrm.com/");
		System.out.println(driver.getTitle());
		
		driver.navigate().to("https://www.google.com/");
		System.out.println(driver.getTitle());
		
		driver.navigate().back();
		System.out.println(driver.getTitle());
		
		driver.navigate().forward();
		System.out.println(driver.getTitle());
		
		driver.navigate().back();
		System.out.println(driver.getTitle());
		
		driver.navigate().refresh();
	}
	
	@AfterMethod()
	public void teardown(){

		driver.quit();
	}
	
}

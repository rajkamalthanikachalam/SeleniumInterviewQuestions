package InterviewQuestions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FrameHandling {

	WebDriver driver;
	
	@BeforeTest()
	public void setup(){
		System.setProperty("webdriver.chrome.driver", "../Selenium_InterviewQuestions/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

		driver.get("https://www.freecrm.com/");
	}
	
	@Test()
	public void framehandle(){
		
		driver.findElement(By.name("username")).clear();
	    driver.findElement(By.name("username")).sendKeys("008rajkamal");
	    driver.findElement(By.name("password")).clear();
	    driver.findElement(By.name("password")).sendKeys("Feb$2018@");
	    driver.findElement(By.xpath("//input[@value ='Login']")).submit();

	    driver.switchTo().frame("mainpanel");
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Contact')]"))).build().perform();    
		driver.findElement(By.xpath("//a[contains(text(),'New Contact')]")).click();
	}
}

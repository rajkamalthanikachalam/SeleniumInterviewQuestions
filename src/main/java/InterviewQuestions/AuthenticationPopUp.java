package InterviewQuestions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class AuthenticationPopUp {
	WebDriver driver;
	
	@BeforeMethod
	public void setup(){
				
		System.setProperty("webdriver.chrome.driver", "../Selenium_InterviewQuestions/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Test
	public void authentication_PopUp() throws InterruptedException{
		
		//http://username:password@url.com
		driver.get("https://admin:admin@the-internet.herokuapp.com/baisc_auth");
		String message = driver.findElement(By.cssSelector("p")).getText();
		System.out.println(message);
	}
	
	@AfterMethod
	public void teardown(){
		//driver.close();
	}

}

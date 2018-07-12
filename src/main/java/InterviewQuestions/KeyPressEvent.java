package InterviewQuestions;

import java.awt.event.ActionEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class KeyPressEvent {
	
WebDriver driver;
	
	@BeforeMethod
	public void startup(){
		
		System.setProperty("webdriver.chrome.driver", "../Selenium_InterviewQuestions/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get("http://the-internet.herokuapp.com/key_presses");
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	}
	
	
	@Test
	public void keyPressEvent(){
		
		// Option 1 - sendkeys
		
		//driver.findElement(By.id("content")).sendKeys(Keys.SHIFT);
		
		//Option 2 - action class
		Actions action = new Actions(driver);
		action.sendKeys(Keys.SHIFT).build().perform();
	
		String text = driver.findElement(By.id("result")).getText();
		System.out.println(text);
		Assert.assertEquals(text, "You entered: SHIFT", "Wrong Input");
	}

	@AfterMethod
	public void teardown(){
		driver.quit();
	}
	
	
	
}

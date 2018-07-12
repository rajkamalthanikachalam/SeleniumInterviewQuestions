package InterviewQuestions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MouseMovement {

	
WebDriver driver;
	
	@BeforeTest()
	public void setup(){
		System.setProperty("webdriver.chrome.driver", "../Selenium_InterviewQuestions/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	}
	
	@Test(enabled = false)
	public void MouseOver() throws InterruptedException{
		
		driver.get("http://www.spicejet.com/");
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.linkText("Check-In"))).build().perform();
		Thread.sleep(3000);
	}
	
	@Test(enabled = false)
	public void DragAndDrop(){
		driver.get("http://jqueryui.com/droppable/");
		driver.switchTo().frame(0);
		
		Actions action = new Actions(driver);
		action.clickAndHold(driver.findElement(By.id("draggable"))).moveToElement(driver.findElement(By.id("droppable"))).release().build().perform();
	}
	
	@Test()
	public void waitFunctionality(){
		
		driver.get("https://www.instagram.com/?hl=en");
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.MILLISECONDS); //dynamic wait, it wont wait once page loaded before the time mentioned
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.MILLISECONDS); //static wait, wait until all elements loaded
		
		
	}
}

package InterviewQuestions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Implicit_Explicit_Wait {

	
	/*
	 * Implicit Wait: 
	 * • During Implicit wait if the Web Driver cannot find it immediately because of its availability, 
	 *   it will keep polling the DOM to get the element. 
	 * • If the element is not available within the specified Time an NoSuchElementException will be raised. 
	 * • The default setting is zero. 
	 * • Once we set a time, the Web Driver waits for the period of the WebDriver object instance. 
	 * 
	 * ====================================================== 
	 * 
	 * Explicit Wait: 
	 * • There can be instance when a particular element takes more than a minute to load. 
	 * • In that case you definitely not like to set a huge time to Implicit wait, as if you do this your browser 
	 *   will going to wait for the same time for every element. 
	 * • To avoid that situation you can simply put a separate time on the required element only. 
	 * • By following this your browser implicit wait time would be short for every element and it would be 
	 *   large for specific element. 
	 * 
	 */
	WebDriver driver;
	
	@BeforeMethod
	public void setUp(){
		
		System.setProperty("webdriver.chrome.driver", "../Selenium_InterviewQuestions/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

		driver.get("https://www.instagram.com/accounts/emailsignup/?hl=en");
		
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}

	@Test
	public void signUp(){
		
		WebElement MobileNo = driver.findElement(By.name("emailOrPhone"));
		WebElement FullName = driver.findElement(By.name("fullName"));
		WebElement UserName = driver.findElement(By.name("username"));
		WebElement Password = driver.findElement(By.name("password"));
		WebElement SignUp = driver.findElement(By.xpath("//button[contains(text(),'Sign up')]"));
		
		
		sendKeys(driver,MobileNo,10,"987654321");
		sendKeys(driver,FullName,10,"DummyUser");
		sendKeys(driver,UserName,10,"Dummy");
		sendKeys(driver,Password,10,"Dummy_User");
		clickOn(driver, SignUp, 10);	
		
	}

	
	public static void sendKeys(WebDriver driver,WebElement element, int timeout,String Value){
		new  WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(Value);
	}
	
	public static void clickOn(WebDriver driver,WebElement element, int timeout){
		new  WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}
	
	
	
	
}

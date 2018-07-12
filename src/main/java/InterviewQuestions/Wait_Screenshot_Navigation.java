package InterviewQuestions;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Wait_Screenshot_Navigation {
	
WebDriver driver;
	
	@BeforeTest()
	public void setup(){
		System.setProperty("webdriver.chrome.driver", "../Selenium_InterviewQuestions/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	}
	
	//Back and forward simulation
	@Test(enabled = false)
	public void navigation() throws InterruptedException{
		
		driver.get("https://www.google.com/"); // Launch URL
		Thread.sleep(2000);
		driver.navigate().to("https://www.amazon.com/"); //to Navigate to new page
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
		driver.navigate().forward();
		Thread.sleep(2000);
		
		driver.navigate().refresh();
	}
	
	@Test(enabled = false)
	public void screenshot() throws IOException{
		
		driver.get("https://www.google.com/");
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("../Selenium_InterviewQuestions/Screenshot/Capute.png"));		
	}
	
	@Test(enabled = true)
	public void implicitWait(){
		
		driver.manage().timeouts().pageLoadTimeout(2000, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
	
	}
	
	@Test(enabled = false)
	//Explicit wait Function - dynamic wait , if element is visible before the mention time, it will proceed further instead waiting for all time
	//Synchronization 
	public static void CickOn(WebDriver driver, WebElement locator, int timeout){
		new WebDriverWait(driver,timeout).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(locator));
		locator.click();
	}
	
	@AfterTest()
	public void teardown(){
		driver.quit();
	}

}

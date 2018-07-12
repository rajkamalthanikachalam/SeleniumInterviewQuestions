package Hashmap_Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CRM_LoginPage {

public WebDriver driver;
public String Credentails;
public String[] Info;

	@BeforeMethod()
	public void setup(){
		
		
		//System.setProperty("webdriver.gecko.driver" , "../Selenium_InterviewQuestions/Drivers/geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "../Selenium_InterviewQuestions/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		//driver = new FirefoxDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.freecrm.com/");
	}
	
	@Test(priority = 1)
	public void User1(){
		
		Credentails = HashMap.UserInfo().get("User1");
		Info = Credentails.split("_");//Username & Password are saved with _ between them
		
	    driver.findElement(By.name("username")).sendKeys(Info[0]);
	    driver.findElement(By.name("password")).sendKeys(Info[1]);
	    driver.findElement(By.xpath("//input[@value ='Login']")).submit();

	    driver.switchTo().frame("mainpanel");
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Contact')]"))).build().perform();    
		driver.findElement(By.xpath("//a[contains(text(),'Contact')]")).click();
		
		driver.findElement(By.xpath("//a[contains(text(),'Popeye The Sailor')]/parent::td//preceding-sibling::td//input[@name = 'contact_id']")).click();;
	
	}

	@Test()
	public void User2(){
		
		Credentails = HashMap.UserInfo().get("User2");
		Info = Credentails.split("_");//Username & Password are saved with _ between them
		
	    driver.findElement(By.name("username")).sendKeys(Info[0]);
	    driver.findElement(By.name("password")).sendKeys(Info[1]);
	    driver.findElement(By.xpath("//input[@value ='Login']")).submit();

	    driver.switchTo().frame("mainpanel");
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Contact')]"))).build().perform();    
		driver.findElement(By.xpath("//a[contains(text(),'Contact')]")).click();
		
		driver.findElement(By.xpath("//a[contains(text(),'Popeye The Sailor')]/parent::td//preceding-sibling::td//input[@name = 'contact_id']")).click();;
	
	}
	
	@AfterMethod()
	public void teardown(){
		driver.quit();
	}
}

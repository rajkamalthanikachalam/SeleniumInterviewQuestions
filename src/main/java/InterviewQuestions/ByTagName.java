package InterviewQuestions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ByTagName {

WebDriver driver;
	
	@BeforeTest()
	public void setup(){
		System.setProperty("webdriver.chrome.driver", "../Selenium_InterviewQuestions/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.ebay.com/");
	}
	
	@Test(enabled = true)
	public void getLinkText(){
	
		List<WebElement> linkedlist = driver.findElements(By.tagName("a"));
		System.out.println("Total no of Links :" +linkedlist.size());
		
		for(int i=0;i<linkedlist.size();i++){
			System.out.println("Name of Link " +i+ " is : "+linkedlist.get(i).getText());	
			}
	}
		
	@Test(enabled = true)
	public void getFullLink(){
		
		List<String> hrefs = new ArrayList<String>();
		List<WebElement> anchors = driver.findElements(By.tagName("a"));
		for ( WebElement anchor : anchors ) {
		    hrefs.add(anchor.getAttribute("href"));
		}
		for ( String href : hrefs ) {
		    driver.get(href);           
		}
	}
	
	@AfterTest()
	public void teardown(){
		driver.quit();
	}
}

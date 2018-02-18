package InterviewQuestions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HTMLUnitDriver {
WebDriver driver;
	
//Not suitable for mouse movement, drag and drop and action
//Also called Ghost driver
//HTML Unit driver
//Also called Headless browser
//Add HTML Unit driver jar file externally 

	@BeforeTest()
	public void setup(){
		System.setProperty("webdriver.chrome.driver", "../Selenium_InterviewQuestions/Drivers/chromedriver.exe");
		//driver = new ChromeDriver();
		driver = new HtmlUnitDriver();  //not part of Selenium 3
		
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
		
	@Test(enabled = false)
	public void getFullLink(){
		
		List<String> hrefs = new ArrayList<String>();
		List<WebElement> anchors = driver.findElements(By.tagName("a"));
		for ( WebElement anchor : anchors ) {
		    System.out.println(hrefs.add(anchor.getAttribute("href")));
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

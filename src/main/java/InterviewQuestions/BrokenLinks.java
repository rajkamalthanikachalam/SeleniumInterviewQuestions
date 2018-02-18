package InterviewQuestions;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BrokenLinks {
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
	public void brokenLinksImages() throws MalformedURLException, IOException{
		
		driver.findElement(By.name("username")).clear();
	    driver.findElement(By.name("username")).sendKeys("008rajkamal");
	    driver.findElement(By.name("password")).clear();
	    driver.findElement(By.name("password")).sendKeys("Feb$2018@");
	    driver.findElement(By.xpath("//input[@value ='Login']")).submit();
	    driver.switchTo().frame("mainpanel");

	    List<WebElement> list =  driver.findElements(By.tagName("a"));   // Link tag = a  and Image Tag = img
	    list.addAll(driver.findElements(By.tagName("img")));
	    System.out.println("Size of total Links and Image : "+list.size());
	   
	    List<WebElement> activelinks = new ArrayList<WebElement>(); // to store only active links, which means only with href tag
	    
	    for(int i =0; i<list.size();i++){
	    	//System.out.println(list.get(i).getAttribute("href"));
	    	if(list.get(i).getAttribute("href")!= null && (! list.get(i).getAttribute("href").contains("javascript"))){
	    		activelinks.add(list.get(i));
	    	}
	    }
		System.out.println("Size of Active Links : "+ activelinks.size());
		
		for(int j =0; j<=activelinks.size();j++){
			
			HttpURLConnection url = (HttpURLConnection)new URL(activelinks.get(j).getAttribute("href")).openConnection();
			int response = url.getResponseCode();
			url.disconnect();
			System.out.println("List of active links" +activelinks.get(j).getAttribute("href")+ "=====>" + response );
		}
	}
	
	@AfterTest()
	public void teardown(){
		driver.quit();
	}
	

}

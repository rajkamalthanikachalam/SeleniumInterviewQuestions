package InterviewQuestions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Alert_PopUp {
	private static final boolean False = false;
	WebDriver driver;
	
	@BeforeMethod
	public void setup(){
				
		System.setProperty("webdriver.chrome.driver", "../Selenium_InterviewQuestions/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();		
	}
	
	//Handle Javascript alert popup
	@Test(enabled = False)
	public void alert_Popup() throws InterruptedException{
		
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.findElement(By.name("proceed")).click();
		Thread.sleep(5000);
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());	
		alert.accept(); // to click on Ok button
		//alert.dismiss(); // to click on cancel button
	}
	
	//Handle windows pop up to upload the file
	@Test(enabled = false)
	public void Windows_Popup(){
		
		driver.get("https://html.com/input-type-file/");
		driver.findElement(By.id("fileupload")).sendKeys("C:/Users/Raj Kamal/Downloads/SampleFile.pdf");
	}
	
	//Handle browser popup
	@Test
	public void browser_Popup() throws InterruptedException{
		
		driver.get("http://www.popuptest.com/goodpopups.html");
		driver.findElement(By.linkText("Good PopUp #1")).click();
		
		Set<String> windowHandler = driver.getWindowHandles();
		Iterator<String> it = windowHandler.iterator();
		
		String ParentWindow = it.next();
		System.out.println("Parent Window : " +ParentWindow );
		Thread.sleep(2000);
		
		String ChildWindow = it.next();
		System.out.println("ChildWindow : " +ChildWindow );
		Thread.sleep(2000);
		
		driver.switchTo().window(ChildWindow);
		System.out.println("Title of Childeren Window "+driver.getTitle());
		
		driver.close();

		driver.switchTo().window(ParentWindow);
		System.out.println("Title of Childeren Window "+driver.getTitle());
	}
	
	@AfterMethod
	public void teardown(){
		//driver.close();
	}

}

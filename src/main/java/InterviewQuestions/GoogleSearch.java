package InterviewQuestions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleSearch {
	
	WebDriver driver;
	
	
@BeforeMethod
public void setUp(){
	
	System.setProperty("webdriver.chrome.driver", "../Selenium_InterviewQuestions/Drivers/chromedriver.exe");
	driver = new ChromeDriver();
	
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();

	driver.get("http://www.google.com/");
}

@Test
public void dynamicSearch() throws InterruptedException{
	
	driver.findElement(By.id("lst-ib")).sendKeys("java");
	List<WebElement> list = driver.findElements(By.xpath("//ul[@role = 'listbox']//li/descendant::div[@class = 'sbqs_c']"));

	System.out.println("Total no of Suggestion in Google search :" +list.size());
	
	for(int i = 0; i<list.size(); i++){
		System.out.println(list.get(i).getText());
		if(list.get(i).getText().equalsIgnoreCase("Javatpoint" )){
			list.get(i).click();
			break;
		}
	}
}

@AfterMethod
public void tearDown(){

	//driver.quit();
}

}

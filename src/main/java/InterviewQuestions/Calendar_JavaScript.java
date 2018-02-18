package InterviewQuestions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Calendar_JavaScript {
WebDriver driver;
	
	@BeforeTest()
	public void setup(){
		
		System.setProperty("webdriver.chrome.driver", "../Selenium_InterviewQuestions/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("http://spicejet.com/");
		
	}
	
	@Test()
	public void CalendarJS(){
		WebElement date = driver.findElement(By.id("view_fulldate_id_1"));
		String dateVal = "30-05-2018";
		
		selectDateByJS(driver, date, dateVal);
		
	}
	
	public static void selectDateByJS(WebDriver driver, WebElement element, String dateVal){
    	JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].setAttribute('value','"+dateVal+"');", element);
		
}

}

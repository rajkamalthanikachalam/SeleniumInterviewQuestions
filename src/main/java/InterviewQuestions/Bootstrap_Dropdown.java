package InterviewQuestions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Bootstrap_Dropdown {
WebDriver driver;
	
	@BeforeTest()
	public void setup(){
		
		System.setProperty("webdriver.chrome.driver", "../Selenium_InterviewQuestions/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("http://www.jquery-az.com/boots/demo.php?ex=63.0_2");
		
	}
	
	@Test()
	public void bootstrap(){
		
		driver.findElement(By.xpath("//button[@class ='multiselect dropdown-toggle btn btn-default']")).click();
		
		List<WebElement> list = driver.findElements(By.xpath("//ul[@class='multiselect-container dropdown-menu']/li/a/label"));
		System.out.println(list.size());
		
		for(int i=0;i<list.size();i++){
			list.get(i).getText();
			if(list.get(i).getText().equalsIgnoreCase("Angular")){
				list.get(i).click();
				break;
			}
		}
		
		
	}
}

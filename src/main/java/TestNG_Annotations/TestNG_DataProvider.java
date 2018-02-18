package TestNG_Annotations;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.utilities.TestUtil;

public class TestNG_DataProvider {

	WebDriver driver;
	
	@DataProvider
	public Iterator<Object[]> getData(){
		ArrayList<Object[]> testdata = TestUtil.getDataFromExcel(); //since its static, we are calling by class name
		return testdata.iterator();
	}
	
	@BeforeMethod
	public void setup(){
		
		System.setProperty("webdriver.chrome.driver", "../Selenium_InterviewQuestions/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get("https://www.freecrm.com");
		
	}
	
	@Test(dataProvider = "getData")
	public void newContact(String FirstName, String LastName,String Title, String Image, String NickName,String Company,String Position,
			String Department,String RefferedBy, String Mobile,String EmailAddress, String ReceiveEmail){
		
		//Login Page
		driver.findElement(By.name("username")).clear();
	    driver.findElement(By.name("username")).sendKeys("008rajkamal");
	    driver.findElement(By.name("password")).clear();
	    driver.findElement(By.name("password")).sendKeys("Feb$2018@");
	    driver.findElement(By.xpath("//input[@value ='Login']")).submit();
	    String HomePageTitle = driver.getTitle();
	    Assert.assertEquals(HomePageTitle, "CRMPRO");
	    
	    //Home Page
		driver.switchTo().frame("mainpanel");
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Contact')]"))).build().perform();    
		driver.findElement(By.xpath("//a[contains(text(),'New Contact')]")).click();
		String ContactPageTitle = driver.getTitle();
		Assert.assertEquals(ContactPageTitle, "CRMPRO");
		
		//New Contact Page
		driver.findElement(By.id("first_name")).sendKeys(FirstName);
		driver.findElement(By.id("surname")).sendKeys(LastName);
		Select select = new Select(driver.findElement(By.name("suffix")));
		select.selectByValue(Title);
		driver.findElement(By.xpath("//*[@id='image_file']")).sendKeys(Image);
		driver.findElement(By.name("nickname")).sendKeys(NickName);
		driver.findElement(By.name("client_lookup")).sendKeys(Company);
		driver.findElement(By.id("company_position")).sendKeys(Position);
		driver.findElement(By.id("department")).sendKeys(Department);
		driver.findElement(By.name("contact_lookup_ref")).sendKeys(RefferedBy);
		driver.findElement(By.id("mobile")).sendKeys(Mobile);
		driver.findElement(By.id("email")).sendKeys(EmailAddress);
		
		if(ReceiveEmail.equalsIgnoreCase("Yes")){
			driver.findElement(By.xpath("//input[@name='receive_email' and @value ='Y']")).click();
		}else if(ReceiveEmail.equalsIgnoreCase("No")){
			driver.findElement(By.xpath("//input[@name='receive_email' and @value ='N']")).click();
		}
		
		//driver.findElement(By.xpath(".//button[@value = 'Save']")).click();
		
	}

	@AfterMethod
	public void teardown(){
		driver.quit();
	}
	
}

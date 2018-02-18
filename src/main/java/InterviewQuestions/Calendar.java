package InterviewQuestions;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Calendar {
WebDriver driver;
	
	@BeforeTest()
	public void setup(){
		
		System.setProperty("webdriver.chrome.driver", "../Selenium_InterviewQuestions/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.freecrm.com/");
		
	}
	
	@Test(enabled = false)
	public void dynamicTable(){
		
		driver.findElement(By.name("username")).clear();
	    driver.findElement(By.name("username")).sendKeys("008rajkamal");
	    driver.findElement(By.name("password")).clear();
	    driver.findElement(By.name("password")).sendKeys("Feb$2018@");
	    driver.findElement(By.xpath("//input[@value ='Login']")).submit();
	    
	    driver.switchTo().frame("mainpanel");
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Contact')]"))).build().perform();  
		
		String Date = "June-31-2000";
		String DateArray[] = Date.split("-");
		String Month = DateArray[0];
		String Day = DateArray[1];
		String Year = DateArray[2];
		
		Select selectMonth = new Select(driver.findElement(By.name("slctMonth")));
		selectMonth.selectByVisibleText(Month);
		
		Select selectYear = new Select(driver.findElement(By.name("slctYear")));
		selectYear.selectByVisibleText(Year);
		
		boolean flag = false;
		for(int row =2;row<=6;row++){
			for(int col =1;col<=7;col++){
				
				String DayValue = driver.findElement(By.xpath("//*[@id ='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr["+row+"]/td["+col+"]")).getText();
				System.out.println(DayValue);
				if(DayValue.equals(Day)){
					driver.findElement(By.xpath("//*[@id ='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr["+row+"]/td["+col+"]")).click();
					flag = true;
					break;
				}
			}
			if(flag){
				break;
			}
		}
	}
	
	
	@Test(enabled = true)
	public void dynamicTable_TryCatch(){
		driver.findElement(By.name("username")).clear();
	    driver.findElement(By.name("username")).sendKeys("008rajkamal");
	    driver.findElement(By.name("password")).clear();
	    driver.findElement(By.name("password")).sendKeys("Feb$2018@");
	    driver.findElement(By.xpath("//input[@value ='Login']")).submit();
	    
	    driver.switchTo().frame("mainpanel");
		
		String date = "32-May-2017";
		String dateArr[] = date.split("-"); // {18,September,2017}
		String day = dateArr[0];
		String month = dateArr[1];
		String year = dateArr[2];
		
		Select select = new Select(driver.findElement(By.name("slctMonth")));
		select.selectByVisibleText(month);
		
		Select select1 = new Select(driver.findElement(By.name("slctYear")));
		select1.selectByVisibleText(year);
		
		String beforeXpath = "//*[@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[";
		String afterXpath = "]/td[";
		
		final int totalWeekDays = 7;
		boolean flag = false;
		String dayVal = null;
		
		for(int rowNum=2; rowNum<=7; rowNum++){
			
			for(int colNum = 1; colNum<=totalWeekDays; colNum++){
				try{
			    dayVal =driver.findElement(By.xpath(beforeXpath+rowNum+afterXpath+colNum+"]")).getText();
				}catch (NoSuchElementException e){
					System.out.println("Please enter a correct date value");
					flag = false;
					break;
				}
				System.out.println(dayVal);
				if(dayVal.equals(day)){
					driver.findElement(By.xpath(beforeXpath+rowNum+afterXpath+colNum+"]")).click();
					flag = true;
					break;
				}				
			}
			if(flag){
				break;
			}
			
		}
		
	}
	
}


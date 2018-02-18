package InterviewQuestions;
//It wont open browser and URL 
// Not working as expected
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class Sikuli {

public static void main (String[]args) throws FindFailed{
	WebDriver driver;
		
		System.setProperty("webdriver.chrome.driver", "../Selenium_InterviewQuestions/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.youtube.com/watch?v=sJSGEQgAYWg");
		
		Screen S = new Screen();
		Pattern pause = new Pattern("Pause.PNG");
		S.wait(pause,20000);
		S.click();

	}
}

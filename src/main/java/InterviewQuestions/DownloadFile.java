package InterviewQuestions;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.collections.map.HashedMap;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DownloadFile {
	
WebDriver driver;
File folder;
	
	@BeforeMethod
	public void startup(){
		
		folder = new File(UUID.randomUUID().toString());
		folder.mkdir();
		
		//Firefox:
		
		/*FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("browser.download.dir", folder.getAbsolutePath());
		profile.setPreference("browser.download.folderList", 2);
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "image/jpeg, application/pdf, application/octet-stream");
		profile.setPreference("pdfjs.disabled", true);
		driver= new FirefoxProfile(profile);*/
		
		
		//Chrome :
		/*System.setProperty("webdriver.chrome.driver", "../Selenium_InterviewQuestions/Drivers/chromedriver.exe");
		ChromeOptions options= new ChromeOptions();
		Map<String, Object> pref = new HashMap<String, Object>();
		pref.put("profile.default_content_settings.popups", 0);
		pref.put("download.default_directory",folder.getAbsolutePath());
		options.setExperimentalOption("pref", pref);
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setCapability(ChromeOptions.CAPABILITY, options);
		driver = new ChromeDriver(cap);*/
		
	}
	
	
	@Test
	public void downnload() throws InterruptedException{
		
		
		driver.get("http://the-internet.herokuapp.com/download");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		
		driver.findElement(By.linkText("some-file.txt")).click();
		Thread.sleep(2000); // Manual wait for file get download
 		
		File listoffiles[] = folder.listFiles();	//Make sure directory is not empty
		Assert.assertTrue(listoffiles.length>0);
		
		for(File files:listoffiles ){
			Assert.assertTrue(files.length()>0);
		}
	}

	@AfterMethod
	public void teardown(){
		driver.quit();
		for(File file:folder.listFiles()){
			file.delete();
		}
		folder.delete();
	}
	
	
	
	

}

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class chromeoption {

	public WebDriver rm;
	
	@BeforeMethod
	public void setUp()
	{
        System.setProperty("webdriver.chrome.driver","C://Users//chromedriver//chromedriver.exe");
		
        ChromeOptions co=new ChromeOptions();
        
        co.addArguments("start-minimized");
        
        co.addArguments("Incognito");
        
		rm=new ChromeDriver(co);
		
		rm.get("https://www.tarc.in/");
	}
	
	@Test
	public void tc() throws IOException
	{
		
		TakesScreenshot tk=(TakesScreenshot)rm;
		
		File src=tk.getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(src, new File("C://Users//Admin//eclipse-workspace//TDD//target//incognitoYouTube.png"));
		
	}
	
	
	@AfterMethod
	public void teadDown() throws InterruptedException
	{
		
		Thread.sleep(3000);
		
		rm.close();
		
	}
}

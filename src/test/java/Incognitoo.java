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

public class Incognitoo {

	public WebDriver rm;
	
	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver","C://Users//chromedriver//chromedriver.exe");
		
		ChromeOptions co=new ChromeOptions();
		
		co.addArguments("incognito");
		
		co.addArguments("start-maximized");
		
		rm=new ChromeDriver(co);
	}
	
	@Test
	public void tc1() throws IOException
	{
		rm.get("https://rahulshettyacademy.com/AutomationPractice");
		
		TakesScreenshot tk=(TakesScreenshot)rm;
		
		File src=tk.getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(src, new File("C://Users//Admin//eclipse-workspace//TDD//target//rahulshetty.png"));
	
	}
	
	@AfterMethod
	public void tearDown()
	{
		rm.close();
	}
	
}

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class srcollDown {

	public WebDriver rm;
	
	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver","C://Users//chromedriver//chromedriver.exe");
		
		rm=new ChromeDriver();
				
		rm.manage().window().maximize();
		
		rm.manage().deleteAllCookies();
		
		rm.get("https://www.guru99.com/selenium-tutorial.html");
	}
	
	@Test
	public void tc1() throws IOException
	{
		
		JavascriptExecutor j=(JavascriptExecutor)rm;
		
		
		
		TakesScreenshot tk=(TakesScreenshot)rm;
		
		File src=tk.getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(src, new File("C://Users//Admin//eclipse-workspace//TDD//target//keydown.jpg"));
	}
	
	@AfterMethod
	public void tearDown()
	{
		rm.close();		
	
	}
}

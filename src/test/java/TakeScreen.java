import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.common.io.Files;

public class TakeScreen {
	
	public WebDriver rm;

	@BeforeClass
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "C://Users//chromedriver//chromedriver.exe");
		
		rm=new ChromeDriver();
		
		rm.manage().window().maximize();
		
		rm.manage().deleteAllCookies();
		
		rm.get("https://jqueryui.com/");
	}
	
	@Test
	public void details() throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)rm;
		
		File file=ts.getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(file, new File("C://Users//Admin//eclipse-workspace//TDD//Screenshot.jpg"));
	}
	
	@AfterClass
	public void tearDown()
	{
		rm.close();
	}
}

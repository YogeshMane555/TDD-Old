import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EurekaScreenshot {

	public WebDriver rm;
	
	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.gecko.driver","C://Users//geckodriver//geckodriver.exe");
		
		rm=new FirefoxDriver();
		
		rm.manage().window().maximize();
		
		rm.manage().deleteAllCookies();
		
		rm.get("https://www.facebook.com/");
		
	}
	
	@Test
	public void tc1() throws IOException
	{
		
		rm.findElement(By.xpath("//input[@id='email']")).sendKeys("9423705952");
		
		rm.findElement(By.xpath("//input[@id='pass']")).sendKeys("qwertyuio");
		
		TakesScreenshot ts=(TakesScreenshot)rm;
		
		File src=ts.getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(src, new File("C://Users//Admin//eclipse-workspace//TDD//Screenshot.jpg"));
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		rm.close();
	}
	
	
}

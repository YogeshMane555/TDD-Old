import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertPopup {

	public WebDriver rm;
	
	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "C://Users//chromedriver//chromedriver.exe");
		
		rm=new ChromeDriver();
		
		rm.manage().window().maximize();
		
		rm.manage().deleteAllCookies();
		
		rm.get("https://rahulshettyacademy.com/AutomationPractice/");
		
	}
	
	@Test(enabled=false)
	public void tc1() throws InterruptedException, IOException
	{
		
		rm.findElement(By.xpath("//input[@id='alertbtn']")).click();
		
		Thread.sleep(2000);
		
		Alert a=rm.switchTo().alert();
		a.accept();
		
		TakesScreenshot tk=(TakesScreenshot)rm;
		
		File src= tk.getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(src, new File("C://Users//Admin//eclipse-workspace//TDD//target//ss1.jpg"));
	
		
	}
	
	@Test
	public void tc2() throws IOException
	{
		rm.findElement(By.xpath("//input[@id='confirmbtn']")).click();
		
		Alert a=rm.switchTo().alert();
		
		a.dismiss();
		
		TakesScreenshot tk=(TakesScreenshot)rm;
		
		File src=tk.getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(src, new File("C://Users//Admin//eclipse-workspace//TDD//target//ss2.jpg"));
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		rm.close();
	}
	
}

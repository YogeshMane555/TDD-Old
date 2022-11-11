import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class alert {

	public WebDriver rm=null;
	
	
	@BeforeClass
	public void setUp() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C://Users//chromedriver//chromedriver.exe");

		rm = new ChromeDriver();

		rm.manage().window().maximize();

		rm.manage().deleteAllCookies();
		
		rm.get("http://rahulshettyacademy.com/AutomationPractice/");

		Thread.sleep(2000);
	}

	@Test(enabled=false)
	public void tc1() throws InterruptedException {

		rm.findElement(By.xpath("//input[@id='alertbtn']")).click();

		Thread.sleep(2000);

		rm.switchTo().alert().accept();

		Thread.sleep(2000);

	}
	
	@Test
	public void tc2() throws InterruptedException
	{
		rm.findElement(By.xpath("//input[@id='confirmbtn']")).click();
		
		Thread.sleep(2000);
		
		//rm.switchTo().alert().dismiss();
		
		rm.switchTo().alert().accept();
		
	}

	@AfterClass
	public void tearDown() 
	{
		
		rm.close();
	}
}

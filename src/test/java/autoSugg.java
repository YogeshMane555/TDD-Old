import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class autoSugg {

	public WebDriver rm;

	@BeforeClass
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "C://Users//chromedriver//chromedriver.exe");
		
		rm=new ChromeDriver();
		
		rm.manage().window().maximize();
		
		rm.manage().deleteAllCookies();
		
		rm.get("https://www.flipkart.com/");
		
		rm.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	
	}
	
	@Test
	public void tc1() throws InterruptedException
	{
		rm.findElement(By.name("q")).sendKeys("iPhone 13");
		
		Thread.sleep(2000);
		
		List<WebElement> lis=rm.findElements(By.name("q"));
		
	
		
		
		
		Thread.sleep(2000);
	}
	
	
	@AfterClass
	public void teadDown()
	{
		rm.close();
	}
	
}

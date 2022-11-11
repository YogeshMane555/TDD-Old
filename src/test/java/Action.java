import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Action {

	public WebDriver rm;
	
	@BeforeClass
	public void setUP()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\chromedriver//chromedriver.exe");
		
		rm=new ChromeDriver();
		
		rm.manage().window().maximize();
		
		rm.manage().deleteAllCookies();
			
		rm.get("https://rahulshettyacademy.com/AutomationPractice/");
	
	}
	
	@Test
	public void tc1() throws InterruptedException
	{

		Actions a=new Actions(rm);
		
		a.build();

		Thread.sleep(2000);
	}
	
	@AfterClass
	public void tearDown()
	{
		rm.close();
		
	}
	
}

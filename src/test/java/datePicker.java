import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class datePicker {
	
	public WebDriver rm;
	
	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver","C://Users//chromedriver//chromedriver.exe");
		
		rm=new ChromeDriver();
		
		rm.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		rm.manage().window().maximize();
		
		rm.manage().deleteAllCookies();
		
		rm.get("https://jqueryui.com/datepicker/");
		
	}
	
	
	@Test
	public void tc1()
	{		
		rm.findElement(By.id("datepicker")).click();
		
		String monthyear=rm.findElement(By.className("ui-datepicker-title")).getText();
		
		System.out.println(monthyear);
	}
	
	@AfterMethod
	public void tearDown()
	{
		rm.close();
	}
	

}

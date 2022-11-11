import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class dropDown {

	public WebDriver rm;
	@BeforeClass
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "C://Users//chromedriver//chromedriver.exe");
		
		rm=new ChromeDriver();
		
		rm.manage().window().maximize();
		
		rm.manage().deleteAllCookies();
		
		rm.get("https://jqueryui.com/selectmenu/");
		
		rm.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	
	}
	
	@Test
	public void tc()
	{
		
		WebElement dr=rm.findElement(By.xpath("//span[@id='speed-button']"));
		
		dr.click();
		
		
		
	}
	
	@AfterClass
	public void tearDown()
	{
		rm.close();
	}
	
}

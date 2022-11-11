package Main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class MainTest {

	public WebDriver rm;
	
	@BeforeMethod
	public void BeforeMethod()
	{
		System.setProperty("webdriver.chrome.driver", "C://Users//chromedriver//chromedriver.exe");
		
		rm=new ChromeDriver();
		
		rm.manage().window().maximize();
		
		rm.manage().deleteAllCookies();
	}
	
	@AfterMethod
	public void CleanUp()
	{
		if(rm!=null)
		{
			rm.quit();
		}
	}
	
}


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class simpleRR {

	public WebDriver rm;
	
	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "C://Users//chromedriver//chromedriver.exe");
		
		ChromeOptions co=new ChromeOptions();
		
		co.addArguments("incognito");
		
		co.addArguments("start-maximizing");
		
		co.addArguments("Headless");
		
		rm=new ChromeDriver(co);
		
		rm.get("https://rahulshettyacademy.com/AutomationPractice");

	}
	
	@Test
	public void tc1() throws InterruptedException
	{
		Thread.sleep(5000);
		
		String title=rm.getTitle();
		
		System.out.println(title);
		
		String ActualTitle="Practice Page";
		
		Assert.assertEquals(ActualTitle, title);
		
		Thread.sleep(5000);
		
	
	}
	
	@AfterMethod
	public void tearDown()
	{
		rm.quit();
	}
	
}

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class autoSuggestion {

	public WebDriver rm;
	
	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver","C://Users//chromedriver//chromedriver.exe");
		
		rm=new ChromeDriver();
		
		rm.manage().window().maximize();
		
		rm.get("http://rahulshettyacademy.com/AutomationPractice/");	
			
	}
		
	@Test
	public void tc1()
	{
		
		rm.findElement(By.xpath("//input[@id='autocomplete']")).sendKeys("Ch");
		
		
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		
	}
}

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class getAttributeText {

	public WebDriver rm;
	
	@BeforeClass
	public void setUp()
	{
	   System.setProperty("webdriver.chrome.driver", "C://Users//chromedriver//chromedriver.exe");
		
		rm=new ChromeDriver();
		
		rm.manage().window().maximize();
		
		rm.manage().deleteAllCookies();
	
		rm.get("https://jqueryui.com/button/");
	}
	
	@Test
	public void tc1()
	{
		rm.findElement(By.xpath("//button[text()='A button element']")).getText();
	}
	
	
	@AfterClass
	public void tearDown()
	{
		rm.close();
	}
	
}

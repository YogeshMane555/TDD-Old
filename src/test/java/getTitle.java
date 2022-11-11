import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class getTitle {

	public WebDriver rm;
	@BeforeMethod
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
		WebElement radio1=rm.findElement(By.xpath("//label[@for='radio-2']"));
		
		radio1.click();
		
		boolean b=radio1.isSelected();
		
	}
	
	@AfterMethod
	public void tearDwon()
	{
		rm.close();
	}
	
}

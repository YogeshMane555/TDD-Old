import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class jQuery {
	
	public WebDriver rm;
	
@BeforeMethod
public void setup()
{
	System.setProperty("webdriver.chrome.driver", "C://Users//chromedriver//chromedriver.exe");
	
	rm=new ChromeDriver();
	
	rm.manage().window().maximize();
	
	rm.manage().deleteAllCookies();
	
	rm.get("https://jqueryui.com/button");
	
}
	
@Test
public void tc1()
{
	WebElement button=rm.findElement(By.xpath(null));
	
	String button_color=button.getCssValue("background-color");
	
	System.out.println(button_color);
}


@AfterMethod
public void tearDown()
{
	rm.quit();
}
	
}

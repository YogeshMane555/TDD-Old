import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class checkBox {

	public WebDriver rm;

	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C://Users//chromedriver//chromedriver.exe");

		rm = new ChromeDriver();

		rm.manage().window().maximize();

		rm.manage().deleteAllCookies();

		rm.get("https://the-internet.herokuapp.com/checkboxes");

		rm.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}

	@AfterClass
	public void tearDown()
	{
		rm.close();
	}
	
	@Test
	public void tc1() throws InterruptedException
	{
		WebElement chk1=rm.findElement(By.xpath("//input[@type='checkbox'][1]"));
		
		chk1.click();
	
		Thread.sleep(3000);
		
		WebElement chk2=rm.findElement(By.xpath("//input[@type='checkbox'][2]"));
		
		chk2.click();
		
		boolean a=chk2.isSelected();
		
		boolean b=chk1.isSelected();
		
		
	}

}

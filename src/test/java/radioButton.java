import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class radioButton {

	public WebDriver rm;
	
	@BeforeClass
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "C://Users//chromedriver//chromedriver.exe");
		
		rm=new ChromeDriver();
		
		rm.manage().window().maximize();
		
		rm.manage().deleteAllCookies();
		
		rm.get("https://jqueryui.com/checkboxradio/");
		
	}
	
	@Test
	public void tc1() throws InterruptedException
	{
		WebElement rad1=rm.findElement(By.xpath("/html/body/div/fieldset[1]/label[1]/span[1]"));
		
		Thread.sleep(3000);
		
		rad1.click();
		
		boolean a=rad1.isSelected();
		
		System.out.println(a);
		
	}
	
	@AfterClass
	public void tearDown()
	{
		rm.close();
	}
}

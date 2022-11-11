import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DDropSS {
	
	public WebDriver rm;

	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "C://Users//chromedriver//chromedriver.exe");
		
		rm=new ChromeDriver();
		
		rm.manage().window().maximize();
		
		rm.manage().deleteAllCookies();
		
		rm.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		rm.get("https://jqueryui.com/droppable/");
		
	}
	
	@Test
	public void tc1() throws IOException, InterruptedException
	{
		WebElement frame=rm.findElement(By.xpath("//iframe[@class='demo-frame']"));
		
		rm.switchTo().frame(frame);
		
		
		WebElement drag=rm.findElement(By.id("draggable"));
		
		WebElement drop=rm.findElement(By.id("droppable"));
		
		
		Actions a =new Actions(rm);
		
		a.dragAndDrop(drag, drop);
		
		a.build().perform();
		
		Thread.sleep(2000);
		
		TakesScreenshot tk=(TakesScreenshot)rm;
		
		File src=tk.getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(src, new File("C://Users//Admin//eclipse-workspace//TDD//Screenshot.jpg"));
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		rm.close();
	}
}

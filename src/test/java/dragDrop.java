import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class dragDrop {
	public WebDriver rm; 
	
	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C://Users//chromedriver//chromedriver.exe");

		rm = new ChromeDriver();

		rm.manage().window().maximize();
		
		rm.get("https://jqueryui.com/droppable/");

		WebElement frame=rm.findElement(By.xpath("//iframe[@class='demo-frame']"));
		
		rm.switchTo().frame(frame);

	}

	@Test
	public void tc1() throws InterruptedException, IOException
	{
		
		Thread.sleep(2000);
		
        WebElement draggable=rm.findElement(By.xpath("//div[@id='draggable']"));
		
		WebElement dropable=rm.findElement(By.xpath("//div[@id='droppable']"));
		
		Actions a=new Actions(rm);
		
		a.dragAndDrop(draggable, dropable).build().perform();
		
		Thread.sleep(2000);
		
		TakesScreenshot ts=(TakesScreenshot)rm;
		
		File src=ts.getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(src, new File("C://Users//Admin//eclipse-workspace//TDD//target//screenshot1.jpg"));
		
	}
	
	@AfterClass
	public void tearDown()
	{
		rm.close();
	}
			

}

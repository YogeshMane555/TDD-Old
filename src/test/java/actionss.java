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

public class actionss {

	public WebDriver rm;
	
	@BeforeMethod
	public void setUp() throws InterruptedException
	{
        System.setProperty("webdriver.chrome.driver","C://Users//chromedriver//chromedriver.exe");
		
		rm=new ChromeDriver();
		
		rm.manage().window().maximize();
		
		rm.manage().deleteAllCookies();
		
		rm.get("https://www.tarc.in/");
		
		Thread.sleep(4000);

	}
	
	@Test
	public void tc1() throws IOException, InterruptedException
	{	
		
		rm.findElement(By.xpath("//span[text()='Close']")).click();
		
		WebElement investor=rm.findElement(By.xpath("//span[@class='itemDepth02233374943__label' and text()='Investors']"));
		
		Thread.sleep(2000);
		
		WebElement disc=rm.findElement(By.xpath("//span[text()='Disclosures under Reg. 46 of LODR']"));
		
		WebElement project=rm.findElement(By.xpath("//span[@class='itemDepth02233374943__label' and text()='Projects']"));
		
		Actions a=new Actions(rm);
		
		Thread.sleep(2000);
		
		a.moveToElement(project).build().perform();
		
		Thread.sleep(2000);
		
        a.moveToElement(investor).build().perform();
		
		Thread.sleep(2000);
		
		a.moveToElement(disc).click().build().perform();		
		
		Thread.sleep(2000);
		
		TakesScreenshot tk=(TakesScreenshot)rm;
		
		File src=tk.getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(src, new File("C://Users//Admin//eclipse-workspace//TDD//target//ActionHover.png"));
		
		Thread.sleep(3000);
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		rm.close();
	}
	
}

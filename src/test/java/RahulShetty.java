import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RahulShetty {

	public WebDriver rm;
	
	@BeforeMethod
	public void setUp()
	{
		ChromeOptions co=new ChromeOptions();
		
		co.addArguments("start-maximized");
		
		co.addArguments("Incognito");
		
		System.setProperty("webdriver.chrome.driver", "C://Users//chromedriver//chromedriver.exe");
		
	    rm=new ChromeDriver(co);
		
		rm.get("https://rahulshettyacademy.com/AutomationPractice");
	
	}
	
	@Test
	public void tc2() throws InterruptedException
	{
		rm.findElement(By.id("autocomplete")).sendKeys("Fr");
		
		Thread.sleep(3000);
		
		List <WebElement>elements=rm.findElements(By.className("ui-menu-item"));
			
		Thread.sleep(2000);
		
		System.out.println(elements.size());
	
		for(WebElement element:elements)
		{
			System.out.println(element.getText());
					
		}
		
		TakesScreenshot tk=(TakesScreenshot)rm;
		
		File src=tk.getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(src, new File("C://Users//Admin//eclipse-workspace//TDD//target//Autosuggestion.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Thread.sleep(3000);
		
	}
	
	@Test
	public void tc3() throws InterruptedException
	{
		System.out.println(rm.getTitle());
		
		TakesScreenshot tk= (TakesScreenshot)rm;
		
		File src=tk.getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(src, new File("C://Users//Admin//eclipse-workspace//TDD//target//handles1.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		rm.findElement(By.id("opentab")).click();
		
		Thread.sleep(3000);
		
		Set<String> hn= rm.getWindowHandles();
		
		Iterator<String> it= hn.iterator();
		
		String s=it.next();
		
		String ss=it.next();
		
		Thread.sleep(3000);
		
		rm.switchTo().window(ss);
		
		System.out.println(rm.getTitle()); 
		
        TakesScreenshot tk1= (TakesScreenshot)rm;
		
		File src1=tk.getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(src1, new File("C://Users//Admin//eclipse-workspace//TDD//target//handle2.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Thread.sleep(3000);
		
		rm.switchTo().window(s);
	}
	
	
	@AfterMethod
	public void tearDown() 
	{
		rm.quit();
		
	}
}

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NewClasss {

	public WebDriver rm;
	
	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "C://Users//chromedriver//chromedriver.exe");
		
		ChromeOptions co=new ChromeOptions();
		
		co.addArguments("Incognito");
		
		co.addArguments("start-maximized");
		
		rm=new ChromeDriver(co);
		
		rm.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		
	}
	
	@Test
	public void tc1() throws InterruptedException
	{
		
		rm.findElement(By.xpath("//*[contains(@id,'autocomplete')]")).sendKeys("Yo");
		
		Thread.sleep(3000);
		
		WebElement drplabel=rm.findElement(By.xpath("//*[contains(text(),'Dropdown Example')]"));
		
		String backg=drplabel.getCssValue("font-size");
		
		System.out.println("background color of text is :" +backg);
		
		TakesScreenshot tk=(TakesScreenshot)rm;
		
		File src=tk.getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(src, new File("C://Users//Admin//eclipse-workspace//TDD//Screenshot//NewClasssRahultt.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void tc2()
	{
		JavascriptExecutor js=(JavascriptExecutor)rm;
		
		js.executeScript("window.scrollBy(0,1000)");
		
		TakesScreenshot tk=(TakesScreenshot)rm;
		
		File src1=tk.getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(src1, new File("C://Users//Admin//eclipse-workspace//TDD//Screenshot//NewClasssScrolldown.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@AfterMethod
	public void tearDown()
	{
		rm.quit();
	}
	
}

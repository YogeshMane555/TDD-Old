import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PP {
	
	public WebDriver rm;	

	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "C://Users//chromedriver//chromedriver.exe");
		
		rm=new ChromeDriver();
		
		rm.manage().window().maximize();
		
		rm.manage().deleteAllCookies();
		
		rm.get("https://www.blissbyfineline.com/");
		
	}
	
	@Test
	public void tc() throws IOException, InterruptedException
	{
		JavascriptExecutor j=(JavascriptExecutor)rm;
		
		j.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		
		Thread.sleep(3000);
		
		TakesScreenshot tk=(TakesScreenshot)rm;
		
		File src=tk.getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(src, new File("C://Users//Admin//eclipse-workspace//TDD//target//PPBottomPage.png"));
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		rm.close();
	}
	
}

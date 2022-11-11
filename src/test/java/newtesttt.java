import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

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

public class newtesttt {

	public WebDriver rm;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C://Users//chromedriver//chromedriver.exe");

		ChromeOptions co = new ChromeOptions();

		co.addArguments("start-maximized");

		co.addArguments("Incognito");

		rm = new ChromeDriver(co);

		rm.manage().deleteAllCookies();

		rm.get("https://rahulshettyacademy.com/AutomationPractice/");

	}

	@Test
	public void tc() throws InterruptedException {
		Thread.sleep(2000);

		JavascriptExecutor js = (JavascriptExecutor) rm;

		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

		Thread.sleep(3000);

		js.executeScript("window.scrollBy(0,-500)");

		Thread.sleep(3000);

		TakesScreenshot tk = (TakesScreenshot) rm;

		File src = tk.getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(src, new File("C://Users//Admin//eclipse-workspace//TDD//target//scrollingdown.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// rm.findElement(By.id("number-button")).click();
	}

	@Test
	public void tc2() throws InterruptedException {

		TakesScreenshot tk = (TakesScreenshot) rm;

		Thread.sleep(3000);

		File src = tk.getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(src,
					new File("C://Users//Admin//eclipse-workspace//TDD//target//BeforeGetWindowHandleMethod.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		rm.findElement(By.id("opentab")).click();

		Thread.sleep(3000);

		Set<String> ss = rm.getWindowHandles();

		Iterator<String> it = ss.iterator();

		String n = it.next();

		Thread.sleep(3000);

		String next = it.next();

		Thread.sleep(3000);

		rm.switchTo().window(next);

		Thread.sleep(3000);

		TakesScreenshot tk1 = (TakesScreenshot) rm;

		File src1 = tk1.getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(src1,
					new File("C://Users//Admin//eclipse-workspace//TDD//target//AfterWindowHandlesMethod.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(rm.getCurrentUrl());

		rm.switchTo().window(n);

		System.out.println(rm.getCurrentUrl());

	}
	

	@AfterMethod
	public void tearDown() {
		
		rm.quit();
		
	}
}

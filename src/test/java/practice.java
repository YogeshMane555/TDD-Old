import java.awt.Dimension;
import java.awt.Point;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class practice {

	public WebDriver rm;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\chromedriver//chromedriver.exe");

		rm = new ChromeDriver();

		rm.manage().window().maximize();

		rm.manage().deleteAllCookies();

		rm.get("https://rahulshettyacademy.com/AutomationPractice");

	}

	@Test
	public void testcase() throws InterruptedException, IOException {
		WebElement opnetab = rm.findElement(By.id("opentab"));

		String gettext = opnetab.getText();

		System.out.println(gettext);

		Thread.sleep(2000);

		rm.findElement(By.id("name")).sendKeys("Yogesh Mane Automation engineer");

		/*
		 * WebElement Albuttn=rm.findElement(By.id("alertbtn"));
		 * 
		 * Thread.sleep(2000);
		 * 
		 * Albuttn.click();
		 * 
		 * Thread.sleep(2000);
		 * 
		 * Alert a=rm.switchTo().alert();
		 * 
		 * Thread.sleep(2000);
		 * 
		 * a.accept();
		 * 
		 */

		rm.findElement(By.id("confirmbtn")).click();

		Thread.sleep(2000);

		Alert a = rm.switchTo().alert();

		Thread.sleep(2000);

		a.accept();

		WebElement select = rm.findElement(By.id("dropdown-class-example"));

		Thread.sleep(2000);

		Select s = new Select(select);

		Thread.sleep(2000);

		s.selectByIndex(1);

		Thread.sleep(2000);

		rm.findElement(By.id("autocomplete")).sendKeys("ga");

		Thread.sleep(2000);

		WebElement radio = rm.findElement(By.xpath("//input[@value='radio2']"));
		
		Thread.sleep(2000);

		radio.click();
		
		Thread.sleep(2000);

		boolean b = radio.isSelected();
		
		Thread.sleep(2000);

		System.out.println(b);
		
		WebElement radio1=rm.findElement(By.xpath("//input[@value='radio1']"));

		Thread.sleep(2000);
		
		boolean b1=radio1.isSelected();
		
		Thread.sleep(2000);
		
		System.out.println(b1);
		
		rm.findElement(By.id("hide-textbox")).click();
		
		Thread.sleep(2000);
		
		WebElement textbox=rm.findElement(By.id("displayed-text"));
		
		Thread.sleep(2000);
		
		boolean b2=textbox.isDisplayed();
		
		Thread.sleep(2000);
		
		System.out.println(b2);
		
		WebElement openwindow=rm.findElement(By.id("openwindow"));
	
		org.openqa.selenium.Dimension d=openwindow.getSize();
		
		int dh=d.height;
		
		System.out.println("height of OpenWindow button is : "+ dh);
		
		int dw=d.width;
		
		System.out.println("Width of OpenWindow button is : "+ dw);
		
		org.openqa.selenium.Point p=openwindow.getLocation();
		
		int xpoint=p.getX();
		
		System.out.println("Location from horizontal :" + xpoint);
		
		int ypoint=p.getY();
		
		System.out.println("Location from Vertical :" + ypoint);
		
		String color=openwindow.getCssValue("background-color");
		
		String size=openwindow.getCssValue("font-size");
		
		System.out.println("Color of button : "+ color);
				
		System.out.println("Size of button label : "+ size);
		
		TakesScreenshot tk = (TakesScreenshot) rm;

		File src = tk.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(src, new File("C://Users//Admin//eclipse-workspace//TDD//target//OptionScreenshot.jpg"));

	}

	@AfterMethod
	public void tearDown() {
		rm.close();
	}

}

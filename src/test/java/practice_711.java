import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class practice_711 {

	public WebDriver rm;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C://Users//chromedriver//chromedriver.exe");

		ChromeOptions co = new ChromeOptions();

		co.addArguments("Start-Maximized");

		co.addArguments("--Headless");
		
		co.addArguments("Incognito");

		rm = new ChromeDriver(co);

		rm.get("https://rahulshettyacademy.com/AutomationPractice/");

	}

	@Test
	public void tc1() throws InterruptedException {
		WebElement radio3 = rm.findElement(By.xpath("//input[@value='radio3']"));

		radio3.click();

		Thread.sleep(3000);

		boolean b = radio3.isSelected();

		System.out.println("Is Radio button 3 selected? :" + b);

		TakesScreenshot tk = (TakesScreenshot) rm;

		File src = tk.getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(src, new File("C://Users//Admin//eclipse-workspace//TDD//target//P711Radio3Click.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Thread.sleep(3000);

	}

	@Test
	public void tc2() throws InterruptedException {
		rm.findElement(By.id("autocomplete")).sendKeys("Am");

		Thread.sleep(3000);

		List<WebElement> autosuggestion = rm.findElements(By.className("ui-menu-item"));

		System.out.println("Total Number of Autosuggestion list is :" + autosuggestion.size());

		for (WebElement list : autosuggestion) {
			System.out.println("List of Autosuggestion is :" + list.getText());
		}

		TakesScreenshot tk = (TakesScreenshot) rm;

		File src = tk.getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(src,
					new File("C://Users//Admin//eclipse-workspace//TDD//target//P711Autosuggestion.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Thread.sleep(3000);

	}

	@Test
	public void tc3() throws InterruptedException {
		WebElement drp = rm.findElement(By.id("dropdown-class-example"));

		Select s = new Select(drp);

		s.selectByVisibleText("Option3");

		Thread.sleep(3000);

		boolean b1 = drp.isEnabled();

		System.out.println("Is drop down value 3? :" + b1);

		TakesScreenshot tk = (TakesScreenshot) rm;

		File src = tk.getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(src, new File("C://Users//Admin//eclipse-workspace//TDD//target//P711DropDown.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void tc4() throws InterruptedException {
		WebElement checkbox3 = rm.findElement(By.id("checkBoxOption3"));

		checkbox3.click();

		Thread.sleep(3000);

		boolean b3 = checkbox3.isSelected();

		System.out.println("Is Checkbox3 value selected?:" + b3);

		TakesScreenshot tk = (TakesScreenshot) rm;

		File src = tk.getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(src, new File("C://Users//Admin//eclipse-workspace//TDD//target//P711Checkbox3.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void tc5() throws InterruptedException {

		System.out.println(rm.getTitle());

		Thread.sleep(3000);

		TakesScreenshot tk = (TakesScreenshot) rm;

		File src = tk.getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(src,
					new File("C://Users//Admin//eclipse-workspace//TDD//target//P711BeforeClickingButton.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		rm.findElement(By.id("opentab")).click();

		Set<String> gh = rm.getWindowHandles();

		Iterator<String> it = gh.iterator();

		String s = it.next();

		String ss = it.next();

		rm.switchTo().window(ss);

		Thread.sleep(3000);

		System.out.println(rm.getTitle());

		TakesScreenshot tk1 = (TakesScreenshot) rm;

		File src1 = tk1.getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(src1,
					new File("C://Users//Admin//eclipse-workspace//TDD//target//P711AfterclickingonButton.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void tc6() throws InterruptedException {
		rm.findElement(By.id("name")).sendKeys("YOGESH");

		Thread.sleep(3000);

		rm.findElement(By.id("alertbtn")).click();

		Alert a = rm.switchTo().alert();

		Thread.sleep(3000);

		a.accept();

		rm.findElement(By.id("name")).sendKeys("MANE");

		Thread.sleep(3000);

		rm.findElement(By.id("confirmbtn")).click();

		Alert a1 = rm.switchTo().alert();

		Thread.sleep(3000);

		a1.dismiss();

	}

	@Test
	public void tc7() throws InterruptedException {
		
		JavascriptExecutor js=(JavascriptExecutor)rm;
		
		js.executeScript("window.scrollBy(0,550)");
		
		Thread.sleep(2000);
			
		WebElement textfieldElement = rm.findElement(By.id("displayed-text"));

		boolean bb = textfieldElement.isDisplayed();

		System.out.println("Is Text field visible ?:" + bb);
		
		Thread.sleep(3000);

		TakesScreenshot tk = (TakesScreenshot) rm;

		File src = tk.getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(src,
					new File("C://Users//Admin//eclipse-workspace//TDD//target//P711TextFieldVisible.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		rm.findElement(By.id("hide-textbox")).click();
		
		Thread.sleep(3000);

		WebElement textfieldElement1 = rm.findElement(By.id("displayed-text"));

		boolean bb1 = textfieldElement1.isDisplayed();

		System.out.println("Is textfield visible? :" + bb1);

		TakesScreenshot tk1 = (TakesScreenshot) rm;

		File src1 = tk.getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(src1,
					new File("C://Users//Admin//eclipse-workspace//TDD//target//P711TextFieldNotVisible.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void tc8() throws InterruptedException
	{
		
		JavascriptExecutor js=(JavascriptExecutor)rm;
		
		js.executeScript("window.scrollBy(0,1400)");
		
		Thread.sleep(3000);
		
		WebDriverWait ww=new WebDriverWait(rm,Duration.ofSeconds((1)));
		
		ww.until(ExpectedConditions.visibilityOfElementLocated(By.id("courses-iframe")));
		
	}
	
	@Test
	public void tc9()
	{
		List<WebElement> links= rm.findElements(By.tagName("a"));
		
		System.out.println("Total Links available in this WebPage are : " +links.size());
		
		for(WebElement URLName: links)
		{
			System.out.println(URLName.getText());
		}
	}
	

	@AfterMethod
	public void tearDown() {
		rm.quit();
	}

}

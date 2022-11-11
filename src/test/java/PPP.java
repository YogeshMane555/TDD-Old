import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PPP {

	public WebDriver rm;
	
@BeforeMethod
public void setUp()
{
	System.setProperty("webdriver.chrome.driver", "C://Users//chromedriver//chromedriver.exe");
	
	rm=new ChromeDriver();
	
	rm.manage().window().maximize();
	
	rm.manage().deleteAllCookies();
	
	rm.get("https://rahulshettyacademy.com/AutomationPractice/");
	
}

@Test
public void tc1() throws InterruptedException, IOException
{
	WebElement radio=rm.findElement(By.xpath("//input[@value='radio1']"));
	
	Thread.sleep(2000);
	
	radio.click();
	
	Thread.sleep(2000);
	
	boolean rb=radio.isSelected();
	
	Thread.sleep(2000);
	
	System.out.println("Radio button1 :" + rb);
	
    TakesScreenshot tk=(TakesScreenshot)rm;
	
	File src=tk.getScreenshotAs(OutputType.FILE);
	
	FileUtils.copyFile(src, new File("C://Users//Admin//eclipse-workspace//TDD//target//PPPRadio.png"));

}

@Test
public void tc2() throws InterruptedException, IOException
{
	WebElement dpdwn=rm.findElement(By.id("dropdown-class-example"));
	
	Select s=new Select(dpdwn);
	
	Thread.sleep(2000);
	
	s.selectByIndex(1);
	
	boolean dp=dpdwn.isSelected();
	
	Thread.sleep(2000);

	System.err.println("Drop down value2 is selected : " +dp);
	
    TakesScreenshot tk=(TakesScreenshot)rm;
	
	File src=tk.getScreenshotAs(OutputType.FILE);
	
	FileUtils.copyFile(src, new File("C://Users//Admin//eclipse-workspace//TDD//target//PPPDropdown.png"));

	
}

@Test
public void tc3() throws InterruptedException, IOException
{
	WebElement chckbx=rm.findElement(By.id("checkBoxOption2"));
	
	Thread.sleep(2000);
	
	chckbx.click();
	
	boolean ch=chckbx.isSelected();
	
	Thread.sleep(2000);
	
	System.out.println("Checkbox value2 is selected :" + ch);
	
    TakesScreenshot tk=(TakesScreenshot)rm;
	
	File src=tk.getScreenshotAs(OutputType.FILE);
	
	FileUtils.copyFile(src, new File("C://Users//Admin//eclipse-workspace//TDD//target//PPPCheckbox.png"));
}

@Test
public void tc4() throws InterruptedException, IOException
{
	rm.findElement(By.id("name")).sendKeys("YOGESH MANE");
	
	Thread.sleep(2000);
	
	rm.findElement(By.id("confirmbtn")).click();
	
	Thread.sleep(2000);
	
	Alert a=rm.switchTo().alert();
	
	Thread.sleep(2000);
	
	a.dismiss();
	
}
	
@Test
public void tc5() throws InterruptedException
{
	rm.findElement(By.id("show-textbox")).click();
	
	
	Thread.sleep(2000);
	
	WebElement textbox=rm.findElement(By.id("displayed-text"));
	
	Thread.sleep(2000);
	
	boolean tx=textbox.isDisplayed();
	
	Thread.sleep(2000);
	
	System.out.println("text box is dispayed :" + tx);

}

@Test
public void tc6()
{
	WebElement opentab=rm.findElement(By.id("opentab"));
	
	String Lb=opentab.getText();
	
	org.openqa.selenium.Dimension d=opentab.getSize();
	
	int height=d.height;
	
	int width=d.width;
	
	System.out.println("button Label is :" + Lb);
	
	System.out.println("Height of CTA is :" + height);
	
	System.out.println("Width of CTA is :" + width);
	
	org.openqa.selenium.Point p=opentab.getLocation();
	
	int top=p.x;
	
	int bottom=p.y;
	
	System.out.println("Location from top :" + top);
	
	System.out.println("Location from bottom :" + bottom );
	
}

@Test
public void tc7() throws IOException, InterruptedException 
{
	JavascriptExecutor j=(JavascriptExecutor)rm;
	
	Thread.sleep(2000);
	
	//j.executeScript("window.scrollBy(0,2000)");
	
	j.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	
	Thread.sleep(2000);
	
	TakesScreenshot tk= (TakesScreenshot)rm;
	
	File src=tk.getScreenshotAs(OutputType.FILE);
	
	FileUtils.copyFile(src, new File("C://Users//Admin//eclipse-workspace//TDD//target//PPPscrolldown.png"));
	
}

@Test
public void tc8() throws IOException, InterruptedException
{
	WebElement frame=rm.findElement(By.name("iframe-name"));
	
	rm.switchTo().frame(frame);
	
	Thread.sleep(2000);
	
	JavascriptExecutor j=(JavascriptExecutor)rm;
	
	Thread.sleep(2000);
	
	j.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	
	Thread.sleep(2000);
	
	TakesScreenshot tk=(TakesScreenshot)rm;
	
	File src=tk.getScreenshotAs(OutputType.FILE);
	
	FileUtils.copyFile(src, new File("C://Users//Admin//eclipse-workspace//TDD//target//PPPFrameScrollDown.png"));
	
}

@Test
public void tc9() throws InterruptedException, IOException
{
	rm.findElement(By.id("opentab")).click();
	
	Thread.sleep(2000);
	
	rm.switchTo().newWindow(WindowType.TAB);
	
	Thread.sleep(2000);
	
	rm.get("https://www.rahulshettyacademy.com/");
	
	Thread.sleep(2000);
	
	String PageTitle=rm.getTitle();
	
	String CurrentTitle="Rahul Shetty Academy";
	
	System.out.println(PageTitle);
	
	Assert.assertEquals(PageTitle, CurrentTitle);
	
	TakesScreenshot tk=(TakesScreenshot)rm;
	
	File src=tk.getScreenshotAs(OutputType.FILE);
	
	FileUtils.copyFile(src, new File("C://Users//Admin//eclipse-workspace//TDD//target//PPPNewTabScreenshot.png"));
	 
}



@AfterMethod
public void tearDown()
{
	rm.quit();
}
	
}

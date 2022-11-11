
import java.io.File;
import java.io.IOException;
import java.util.List;

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
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class newTest {

	public WebDriver rm;
	
	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "C://Users//chromedriver//chromedriver.exe");
		
		ChromeOptions co=new ChromeOptions();
		
		co.addArguments("start-maximized");
		
		co.addArguments("incognito");
		
		rm=new ChromeDriver(co);
		
		rm.get("https://rahulshettyacademy.com/AutomationPractice/");
	}

	@Test
	public void tc1()
	{
		WebElement rbuttonlabel= rm.findElement(By.xpath("//legend[text()='Radio Button Example']"));
		
		String textonbutton=rbuttonlabel.getText();
		
		System.out.println("Label on button is :"+textonbutton);
		
		org.openqa.selenium.Dimension d=rbuttonlabel.getSize();
		
		int buttonheight=d.height; 
		
		int buttonwidth=d.width;
		
		System.out.println("height of button is :"+buttonheight);
		
		System.out.println("Width of button is :"+buttonwidth);
		
		org.openqa.selenium.Point p= rbuttonlabel.getLocation();
		
		int x1=p.x;
		
		int y1=p.y;
		
		System.out.println("Location from horizontal :"+x1);
		
		System.out.println("Location from vertical :"+y1);
		
		String size=rbuttonlabel.getCssValue("font-size");
		
		String background=rbuttonlabel.getCssValue("background");
		
		String color=rbuttonlabel.getCssValue("color");
		
		String padding=rbuttonlabel.getCssValue("padding");
		
		System.out.println("Font size of label is :"+size);
		
		System.out.println("Background is :"+background);
		
		System.out.println("Color of label is :"+color);
		
		System.out.println("Padding is :"+padding);
		
		WebElement radio2=rm.findElement(By.xpath("//input[@value='radio2']"));
		
		radio2.click();
		
		boolean b=radio2.isSelected();
		
		System.out.println("Radio button 2 is selected ? :"+b);
		
		newTest.this.takesceenrshot();
	
	}
	
	@Test
	public void tc2() throws InterruptedException
	{
		WebElement suggestion= rm.findElement(By.id("autocomplete"));
		
		suggestion.sendKeys("st");
		
		Thread.sleep(3000);
		
		List<WebElement> autosuggestion= rm.findElements(By.xpath("//li[@class='ui-menu-item']"));
		
		int totalsuggestion=autosuggestion.size();
		
		System.out.println(totalsuggestion);
				
		autosuggestion.add(rm.findElement(By.xpath("//div[text()='Austria']")));
		
		Thread.sleep(3000);
		
		newTest.this.takesceenrshot();
		

	}
	
	@Test
	public void tc3()
	{
		WebElement dropdown=rm.findElement(By.id("dropdown-class-example"));
		
		Select s=new Select(dropdown);
		
		s.selectByVisibleText("Option2");
		
		newTest.this.takesceenrshot();
		
		Boolean b1=	dropdown.isEnabled();
		
		System.out.println("Drop down is enabled ?:"+b1);
		
	}
	
	@Test
	public void tc4()
	{
		WebElement chckbx= rm.findElement(By.id("checkBoxOption2"));
		
		chckbx.click();
		
		boolean b2=chckbx.isSelected();
		
		System.out.println("Is Checkbox 2 selected ?:"+b2);
		
		WebElement chckbxlabel= rm.findElement(By.xpath("//label[@for='benz']"));
		
		String fontsize=chckbxlabel.getCssValue("font-size");
		
		String lineheight=chckbxlabel.getCssValue("line-height");
		
		System.out.println("Font size of label is :"+fontsize);
		
		System.out.println("Line height of label is :"+lineheight);
		
		newTest.this.takesceenrshot();
		
	}
	
	@Test
	public void tc5() throws InterruptedException
	{
		rm.findElement(By.id("name")).sendKeys("YOGESH MANE");
		
		Thread.sleep(3000);
		
		rm.findElement(By.id("alertbtn")).click();
		
		Alert a=rm.switchTo().alert();
		
		Thread.sleep(3000);
		
		a.accept();
		
		WebElement text=rm.findElement(By.name("enter-name"));
		
		text.sendKeys("MANE YOGESH");
		
		String enteredText=text.getAttribute("text");

		System.out.println(enteredText);
		
		Thread.sleep(3000);
	
		rm.findElement(By.id("confirmbtn")).click();
		
		Alert a1=rm.switchTo().alert();
		
		Thread.sleep(3000);
		
		a1.accept();
		
		JavascriptExecutor js=(JavascriptExecutor)rm;
		
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		
		Thread.sleep(3000);
		
		newTest.this.takesceenrshot();
		
	}
		
	
	public void takesceenrshot()
	{
        TakesScreenshot tk=(TakesScreenshot)rm;
		
		File src=tk.getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(src, new File("C://Users//Admin//eclipse-workspace//TDD//target//newTestRadio.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@AfterMethod
	public void tearDown()
	{
		rm.close();
	}
	
}

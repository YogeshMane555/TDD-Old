import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class getTestDataExcelsheet {

	public WebDriver rm;
	
	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\chromedriver//chromedriver.exe");
		
		rm=new ChromeDriver();
		
		rm.manage().window().maximize();
		
		rm.manage().deleteAllCookies();
		
		//rm.get("https://www.saucedemo.com/");
		
		rm.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void tc() throws InterruptedException, IOException
	{
		
		File f=new File("‪C://Users//Admin//Documents//TestData.xlsx");
		
		FileInputStream fis=new FileInputStream(f);
		
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		
		XSSFSheet sheet=wb.getSheetAt(0);
		
		int lastrow=sheet.getLastRowNum();
		
		System.out.println("Total Number of ROW :" +lastrow);
		
		for(int i=0; i<lastrow; i++)
		{
			
			String data=sheet.getRow(i).getCell(0).getStringCellValue();
			
			System.out.println("Excel sheet data is : "+ data);
		}
		
		
		/*rm.findElement(By.id("user-name")).sendKeys("standard_user");
		
		Thread.sleep(2000);
		
		rm.findElement(By.id("password")).sendKeys("secret_sauce");
		
		Thread.sleep(2000);
		
		rm.findElement(By.id("login-button")).click();
		
		Thread.sleep(4000);
		
		TakesScreenshot tk=(TakesScreenshot)rm;
		
		File Src=tk.getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(Src, new File("C://Users//Admin//eclipse-workspace//TDD//target//SauceLabsSS.jpg"));
		
		rm.findElement(By.id("react-burger-menu-btn")).click();
		
		Thread.sleep(2000);
		
		rm.findElement(By.id("logout_sidebar_link")).click();
		*/		
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		rm.close();
	}
	
}

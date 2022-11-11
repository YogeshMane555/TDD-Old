import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class fileUpload {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C://Users//chromedriver//chromedriver.exe");

		WebDriver rm = new ChromeDriver();

		rm.manage().window().maximize();
		
		rm.get("https://the-internet.herokuapp.com/upload");
		
		rm.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		
		rm.findElement(By.xpath("//input[@id='file-upload']")).sendKeys("C:\\Users\\Admin\\Downloads\\Vaan_megam_PPR_31st_August_2022.xlsx");
		
		Thread.sleep(2000);
		
		rm.findElement(By.xpath("//input[@class='button']")).click();
		
		Thread.sleep(2000);
		
		rm.close();	
		

	}
}

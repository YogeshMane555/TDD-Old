import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class autoSuggestions {
	
	public static void main(String[] args) {
		
		
		System.setProperty("webdriver.chrome.driver", "C://Users//chromedriver//chromedriver.exe");
		
		WebDriver rm=new ChromeDriver();
		
		rm.manage().window().maximize();
		
		rm.manage().deleteAllCookies();
		
		rm.get("https://www.google.com");
		
		rm.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		rm.findElement(By.name("q")).sendKeys("sele");

		List<WebElement> lwb=rm.findElements(By.xpath("//div[@class='OBMEnb']"));
		
		int count=lwb.size();
		
		System.out.println("Count of autosuggestion is :" + count);
		
	}	
	
}

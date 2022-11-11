import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class mutlipleWindowHandle {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C://Users//chromedriver//chromedriver.exe");
		
		WebDriver rm=new ChromeDriver();
		
		rm.manage().window().maximize();
		
		rm.get("https://www.myntra.com/tshirt");
		
		Set<String> handle=rm.getWindowHandles();
		
		Iterator<String> it=handle.iterator();
		
		String ParnetWorld=it.next();
		
		String ChildWold=it.next();
		
	
		
		
		
		
		
	}
}

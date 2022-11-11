import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class alertInternetHerokupp {

	public WebDriver rm;

	@BeforeClass
	public void setUP() {
		System.setProperty("webdriver.chrome.driver", "C://Users//chromedriver//chromedriver.exe");

		rm = new ChromeDriver();

		rm.manage().window().maximize();

		rm.manage().deleteAllCookies();

		rm.get("https://the-internet.herokuapp.com/javascript_alerts");

	}

	@AfterClass
	public void tearDown() {
		rm.close();
	}

	@Test(enabled = false)
	public void tc1() {
		rm.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();

		rm.switchTo().alert().accept();

		System.out.println(rm.findElement(By.xpath("//p[@id='result']")).getText());
	}

	@Test(enabled = false)
	public void tc2() throws InterruptedException {
		rm.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();

		Thread.sleep(2000);

		rm.switchTo().alert().dismiss();

		System.out.println(rm.findElement(By.xpath("//p[@id='result']")).getText());

	}

	@Test
	public void tc3() throws InterruptedException {
		rm.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();

		Thread.sleep(2000);

		rm.switchTo().alert().sendKeys("YOGESH MANE");

		Thread.sleep(4000);

		rm.switchTo().alert().accept();

		System.out.println(rm.findElement(By.xpath("//p[@id='result']")).getText());
	}

}

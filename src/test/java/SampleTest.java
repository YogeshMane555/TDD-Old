import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import LoginPagePackage.LoginPage;
import Main.MainTest;

public class SampleTest extends MainTest {

	/* WITHOUT PAGE OBJECT MODULE
		
	@Test
	public void testcase1() {
		rm.get("https://itera-qa.azurewebsites.net/Login");

		rm.findElement(By.xpath("//input[@id='Username']")).sendKeys("YogeshMane");

		rm.findElement(By.xpath("//input[@id='Password']")).sendKeys("Jarvis@2511");

		rm.findElement(By.xpath("//input[@id='Password']")).submit();
		
		String URL=rm.getCurrentUrl();
		Assert.assertTrue(URL.startsWith("http://itera-qa.azurewebsites.net"),"URL :"+ rm.getCurrentUrl()+ "Was not start with https://itera-qa.azurewebsites.net/Login/Authorize");
	
}
	*/
	
	/* WITH PAGE OBJECT MODULE */
	@Test
	public void TestCase2()
	{
		rm.get("https://itera-qa.azurewebsites.net/Login");
		
		LoginPage lp = new LoginPage();
		 
		PageFactory.initElements(rm, lp);
		
		lp.EnterUserName("Yogesh Mane");
		
		lp.EnterPassword("yogeshmane009");
		
		lp.ClickLoginButton();
		
			
	}
	
	

}

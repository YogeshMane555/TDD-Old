package LoginPagePackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	@FindBy(name="Username")
	WebElement Username;
	
	@FindBy(id="Password")
	WebElement Password;
	
	@FindBy(name="login")
	WebElement LgnBtn;
	
	
	public void EnterUserName(String EnterUS)
	{
		Username.sendKeys(EnterUS);
	}
	
	public void EnterPassword(String EnterPass)
	{
		Password.sendKeys(EnterPass);
	}

	public void ClickLoginButton()
	{
		LgnBtn.click();
	}
}

package Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page {
	public Login_Page(WebDriver driver)
	{
	PageFactory.initElements(driver, this);	
	}

@FindBy(name="user_name")
private WebElement usernametextfield;

@FindBy(name="user_password")
private WebElement passwordtextfield;

@FindBy(id="submitButton")
private WebElement loginbutton;

public WebElement getUsernametextfield() {
	return usernametextfield;
}

public WebElement getPasswordtextfield() {
	return passwordtextfield;
}

public WebElement getLoginbutton() {
	return loginbutton;
}

public void loginToApp(String username,String password)
{
	usernametextfield.sendKeys(username);
	passwordtextfield.sendKeys(password);
	loginbutton.click();
}

}
package Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganistion_Page {
	
//  Initiliasation
	
	public CreateOrganistion_Page(WebDriver driver)
	{
	PageFactory.initElements(driver, this);
	}
	
//  Declaration	
	
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement createorgplussign;
	
	@FindBy(name="accountname")
	private WebElement orgnametextfield;
	
	@FindBy(name="button")
	private WebElement savebutton;
	
//  Getters
	
	public WebElement getCreateorgplussign() {
		return createorgplussign;
	}

	public WebElement getOrgnametextfield() {
		return orgnametextfield;
	}

	public WebElement getSavebutton() {
		return savebutton;
	}
	
//	business logics
	
	public void clickOrgPlusSign()
	{
		createorgplussign.click();
	}
	public void sendOrgname(String organame)
	{
		orgnametextfield.sendKeys(organame);
	}
	public void clickOnSave()
	{
		savebutton.click();
	}
}

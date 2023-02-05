package Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaign_Page {
	public CreateCampaign_Page(WebDriver driver)
	{
	PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//img[@alt='Create Campaign...']")
	private WebElement createcampplussign;
	
	@FindBy(name="campaignname")
	private WebElement campnametextfield;
	
	@FindBy(name="button")
	private WebElement savebutton;

	public WebElement getCreatecampplussign() {
		return createcampplussign;
	}
	public WebElement getCampnametextfield() {
		return campnametextfield;
	}
	public WebElement getSavebutton() {
		return savebutton;
	}
	//business logics
	public void clickCampPlusSign()
	{
		createcampplussign.click();
	}
	public void sendCampname(String cmpname)
	{
		campnametextfield.sendKeys(cmpname);
	}
	public void clickOnSave()
	{
		savebutton.click();
	}

}

package Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_utility.WebDriver_Utility;

public class Home_Page {
//  Intialization
	public Home_Page(WebDriver driver)
	{
	PageFactory.initElements(driver, this);
	}
//	Declaration
	@FindBy(linkText="Organizations")
	private WebElement organisationslink;
	
	@FindBy(linkText="Products")
	private WebElement productslink;
	
	@FindBy(linkText="More")
	private WebElement morelink;
	
	@FindBy(linkText="Campaigns")
	private WebElement campaignslink;
	
	@FindBy(xpath="(//td[@class='small'])[2]")
	private WebElement adminmouseover;
	
	@FindBy(linkText="Sign Out")
	private WebElement signoutlink;
		
//  Getters method
	public WebElement getOrganisationslink() 
	{
		return organisationslink;
	}
	public WebElement getProductslink()
	{
		return productslink;
	}
	public WebElement getMorelink() 
	{
		return morelink;
	}
	
	public WebElement getCampaignslink() 
	{
		return campaignslink;
	}
	
	public WebElement getAdminmouseover()
	{
		return adminmouseover;
	}
	public WebElement getSignoutlink()
	{
		return signoutlink;
	}
	
//  Business logics	
	public void clickOrganisationsLink()
	{
		organisationslink.click();
	}
	public void clickProductsLink()
	{
		productslink.click();
	}
	public void clickMoreLink(WebDriver driver)
	{
		Actions a = new Actions(driver);
		a.moveToElement(morelink).perform();
        morelink.click();
	}
	public void clickCampaignsLink()
	{
		campaignslink.click();
	}
	public void logoutFromApp(WebDriver driver)
	{
		Actions a = new Actions(driver);
		a.moveToElement(adminmouseover).perform();
		signoutlink.click();
	}
	
}

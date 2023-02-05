package Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAndDeleteProduct_Page {
	public CreateAndDeleteProduct_Page(WebDriver driver)
	{
	PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//img[@title='Create Product...']")
	private WebElement createprodplussign;
	
	@FindBy(name="productname")
	private WebElement prodnametextfield;
	
	@FindBy(name="button")
	private WebElement savebutton;
	
	@FindBy(name="Delete")
	private WebElement deletebutton;


    public WebElement getCreateprodplussign() {
		return createprodplussign;
	}
	public WebElement getProdnametextfield() {
		return prodnametextfield;
	}
	public WebElement getSavebutton() {
		return savebutton;
	}
	public WebElement getDeletebutton() {
		return deletebutton;
	}
	//business logics
	public void clickProdPlusSign()
	{
		createprodplussign.click();
	}
	public void sendProdname(String prdname)
	{
		prodnametextfield.sendKeys(prdname);
	}
	public void clickOnSave()
	{
		savebutton.click();
	}
	public void clickOnDelete()
	{
		deletebutton.click();
	}
}

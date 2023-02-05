package Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampWithProd_Page {
	
//  Initialisation
	
	public CreateCampWithProd_Page(WebDriver driver)
	{
	PageFactory.initElements(driver, this);
	}
	
//  Declaration
	
	@FindBy(xpath="//img[@title='Create Product...']")
	private WebElement createprodplussign;
	
	@FindBy(name="productname")
	private WebElement prodnametextfield;
	
	@FindBy(name="button")
	private WebElement savebutton;
	
	@FindBy(xpath="//img[@alt='Create Campaign...']")
	private WebElement createcampplussign;
	
	@FindBy(name="campaignname")
	private WebElement campnametextfield;
	
	@FindBy(xpath="//img[@title='Select']")
	private WebElement addprodsign;
	
    @FindBy(id="search_txt")
	private WebElement srchtextfield;
	
	@FindBy(name="search")
	private WebElement srchbutton;
	
//  Getters
	
    public WebElement getCreateprodplussign()
    {
		return createprodplussign;
	}
	public WebElement getProdnametextfield()
	{
		return prodnametextfield;
	}
	public WebElement getSavebutton()
	{
		return savebutton;
	}
	public WebElement getCreatecampplussign() 
	{
		return createcampplussign;
	}
	public WebElement getCampnametextfield() 
	{
		return campnametextfield;
	}
	public WebElement getAddprodsign()
	{
		return addprodsign;
	}
	public WebElement getSrchtextfield()
	{
		return srchtextfield;
	}
	public WebElement getSrchbutton() {
		return srchbutton;
	}
	
//	business logics
	
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
	public void clickCampPlusSign()
	{
		createcampplussign.click();
	}
	public void sendCampname(String cmpname)
	{
		campnametextfield.sendKeys(cmpname);
	}
	public void clickAddPrdSign()
	{
		addprodsign.click();
	}
	public void clickOnSrchAndSendText(String prdname)
	{
		srchtextfield.sendKeys(prdname);
	}
	public void clickSrchButton()
	{
		 srchbutton.click();
	}
	

}

package campaigns;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import Object_Repository.CreateCampWithProd_Page;
import Object_Repository.Home_Page;
import Object_Repository.Login_Page;
import Object_Repository.VrfyAndValdte_CampVthPrd;
import generic_utility.BaseClass;
import generic_utility.Excel_Utility;
import generic_utility.File_Utility;
import generic_utility.Java_Utility;
import generic_utility.WebDriver_Utility;


public class CreateCamp_WithProduct extends BaseClass{
@Test
public void createCamp_VthProd() throws Throwable{

//  launch the browser
//  System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
//  WebDriver driver = new ChromeDriver();
		
	File_Utility flib = new File_Utility();
//	String BROWSER = flib.getKeyAndValue("browser");
//	WebDriver driver;
//	if(BROWSER.equalsIgnoreCase("chrome"))
//	{
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
//	}
//	else if(BROWSER.equalsIgnoreCase("firefox"))
//	{
//		WebDriverManager.firefoxdriver().setup();
//		driver = new FirefoxDriver();
//	}
//	else
//	{
//		driver = new ChromeDriver();
//	}
//	
    Home_Page home = new Home_Page(driver);
    WebDriver_Utility wlib = new WebDriver_Utility();
    wlib.maximizeScreen(driver);
    CreateCampWithProd_Page cmprd = new CreateCampWithProd_Page(driver);
	
//	String URL = flib.getKeyAndValue("url");
//	wlib.waitForPageToLoad(driver);
//	String USERNAME = flib.getKeyAndValue("username");
//	String PASSWORD = flib.getKeyAndValue("password");
//	
//	driver.get(URL);
//	Login_Page login = new Login_Page(driver);
//	login.loginToApp(USERNAME, PASSWORD);
	home.clickProductsLink();
	cmprd.clickProdPlusSign();
//	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//	driver.findElement(By.id("submitButton")).click();
//	driver.findElement(By.linkText("Products")).click();
//	driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
	
	//to avoid duplicates
	Java_Utility jlib = new Java_Utility();
	int randnum = jlib.getRandomNum();
	
	Excel_Utility elib = new Excel_Utility();
    String prodname = elib.getExcelData("Product",0,0)+randnum;
    cmprd.sendProdname(prodname);
    cmprd.clickOnSave();
    VrfyAndValdte_CampVthPrd validate = new VrfyAndValdte_CampVthPrd(driver);
    validate.prodVerifyAndValidate(driver, prodname);
//	driver.findElement(By.name("productname")).sendKeys(prodname);
//	driver.findElement(By.name("button")).click();//save
//	String actdata = driver.findElement(By.id("dtlview_Product Name")).getText();
//	if(actdata.contains(prodname))
//	{
//		System.out.println("Validation Pass");
//	}
//	else
//	{
//		System.out.println("Validation Fail");
//	}
    home.clickMoreLink(driver);
    home.clickCampaignsLink();
    cmprd.clickCampPlusSign();
	//navigate to more------->campaigns
//	WebElement ele = driver.findElement(By.linkText("More"));
//	wlib.mouseOverOnElement(driver, ele);
//	driver.findElement(By.linkText("Campaigns")).click();
	
	//click on plus
//	driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
	
	//fetch data from excel to campaign
	
	String campname = elib.getExcelData("Campaign",0,0);
	cmprd.sendCampname(campname);
	cmprd.clickAddPrdSign();
//	driver.findElement(By.name("campaignname")).sendKeys(campname);
//	driver.findElement(By.xpath("//img[@title='Select']")).click();
	

	//switch to window
	wlib.switchToWindow(driver,"Products&action");
	cmprd.clickOnSrchAndSendText(prodname);
	cmprd.clickSrchButton();
//	driver.findElement(By.id("search_txt")).click();
	//dynamic path
	driver.findElement(By.xpath("//a[text()='"+prodname+"']")).click();
//	driver.findElement(By.name("search")).click();
	
	
//  switch back to window
    wlib.switchToWindow(driver, "Campaigns&action");
	cmprd.clickOnSave();
//	driver.findElement(By.name("button")).click();//save
//	validate.campVerifyAndValidate(driver, campname);
	String actdata1 = driver.findElement(By.id("dtlview_Campaign Name")).getText();
    Assert.assertEquals(actdata1,campname);
	
	//	if(actdata1.contains(campname))
//	{
//		System.out.println("Validation Pass");
//	}
//	else
//	{
//		System.out.println("Validation Fail");
//	}

	home.logoutFromApp(driver);
// 	WebElement ele2 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
//  wlib.mouseOverOnElement(driver, ele2);
//	driver.findElement(By.linkText ("Sign Out")).click();//sign out
	}
}
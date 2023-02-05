package campaigns;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Object_Repository.CreateCampaign_Page;
import Object_Repository.Home_Page;
import Object_Repository.Login_Page;
import Object_Repository.VerifyAndValidate_Camp;
import generic_utility.BaseClass;
import generic_utility.Excel_Utility;
import generic_utility.File_Utility;
import generic_utility.Java_Utility;
import generic_utility.WebDriver_Utility;
@Listeners(generic_utility.ListenersClass.class)
public class CreateCampaign extends BaseClass{
@Test
	public void createCampaign() throws Throwable{
//	System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
//  WebDriver driver = new ChromeDriver();
   //	String BROWSER = flib.getKeyAndValue("browser");
	
//	if(BROWSER.equalsIgnoreCase(BROWSER))
//	{
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
//	}
//	else if(BROWSER.equalsIgnoreCase(BROWSER))
//	{
//		WebDriverManager.firefoxdriver().setup();
//		driver = new FirefoxDriver();
//	}
//	else
//	{
//		driver = new ChromeDriver();
//	}
	 Home_Page home = new Home_Page(driver);
	    
	File_Utility flib = new File_Utility();	

	CreateCampaign_Page camp = new CreateCampaign_Page(driver);
    WebDriver_Utility wlib = new WebDriver_Utility();
    wlib.maximizeScreen(driver);

//	String URL = flib.getKeyAndValue("url");
//	wlib.waitForPageToLoad(driver);
//	
//	String USERNAME = flib.getKeyAndValue("username");
//	String PASSWORD = flib.getKeyAndValue("password");
//	driver.get(URL);
//	Login_Page login = new Login_Page(driver);
//	login.loginToApp(USERNAME, PASSWORD);
	home.clickMoreLink(driver);
	home.clickCampaignsLink();
	camp.clickCampPlusSign();
	
//	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//	driver.findElement(By.id("submitButton")).click();
//	WebElement ele = driver.findElement(By.linkText("More"));
//	wlib.mouseOverOnElement(driver, ele);
//	driver.findElement(By.linkText("Campaigns")).click();
//	driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
//	
	Java_Utility jlib = new Java_Utility();
	int randnum = jlib.getRandomNum();
 
	Excel_Utility elib = new Excel_Utility();
    String campname = elib.getExcelData("Campaign",0,0)+randnum;
    camp.sendCampname(campname);
    Assert.assertEquals(false,true);
    camp.clickOnSave();
    String actdata = driver.findElement(By.xpath("//span[text()='"+campname+"']")).getText();
//  Assert.assertEquals(actdata,campname);
    
    
//  driver.findElement(By.name("campaignname")).sendKeys(campname);
//	driver.findElement(By.name("button")).click();
//  VerifyAndValidate_Camp validate = new VerifyAndValidate_Camp(driver);
//  validate.campVerifyAndValidate(driver, campname);
//	String actdata = driver.findElement(By.name("dtlview_Campaign Name")).getText();
//	if(actdata.contains(campname))
//	{
//		System.out.println("Validation Pass");
//	}
//	else
//	{
//		System.out.println("Validation Fail");
//	}
//	driver.findElement(By.xpath)
	home.logoutFromApp(driver);
//	WebElement ele1 = driver.findElement(By.xpath("(//td[@class='small'])[2]"));
//	wlib.mouseOverOnElement(driver, ele1);
//	driver.findElement(By.linkText("Sign Out")).click();	
	
	} 

}

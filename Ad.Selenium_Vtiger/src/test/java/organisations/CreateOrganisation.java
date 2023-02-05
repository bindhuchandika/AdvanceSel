package organisations;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Object_Repository.CreateOrganistion_Page;
import Object_Repository.Home_Page;
import Object_Repository.Login_Page;
import Object_Repository.VrfyAndVldte_Org;
import generic_utility.BaseClass;
import generic_utility.Excel_Utility;
import generic_utility.File_Utility;
import generic_utility.Java_Utility;
import generic_utility.WebDriver_Utility;

@Listeners(generic_utility.ListenersClass.class)
public class CreateOrganisation extends BaseClass{
@Test(retryAnalyzer=generic_utility.RetryImpClass.class)	
//@Test(groups={"smoke","regression"})
public void createOrganisation() throws Throwable {
	
//		System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
		File_Utility flib = new File_Utility(); 
//		String BROWSER = flib.getKeyAndValue("browser");
//		WebDriver driver;
//		if(BROWSER.equalsIgnoreCase("chrome"))
//		{
//			WebDriverManager.chromedriver().setup();
//			driver = new ChromeDriver();
//		}
//		else if(BROWSER.equalsIgnoreCase("firefox"))
//		{
//			WebDriverManager.firefoxdriver().setup();
//			driver = new FirefoxDriver();
//		}
//		else
//		{
//			driver = new ChromeDriver();
//		}
		Home_Page home = new Home_Page(driver);
		WebDriver_Utility wlib = new  WebDriver_Utility();
		wlib.maximizeScreen(driver);//maximize
		CreateOrganistion_Page org = new CreateOrganistion_Page(driver);
		
//		String URL = flib.getKeyAndValue("url");//data from properties file
//		wlib.waitForPageToLoad(driver);//implicitly wait
//		String USERNAME = flib.getKeyAndValue("username");
//		String PASSWORD = flib.getKeyAndValue("password");
//		
//		driver.get(URL);
//		Login_Page login = new Login_Page(driver);
//		login.loginToApp(USERNAME, PASSWORD);
		home.clickOrganisationsLink();
		org.clickOrgPlusSign();
		
//		driver.findElement(By.linkText("Organizations")).click();
//		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		Java_Utility jlib = new Java_Utility();
		int randnum = jlib.getRandomNum();//To avoid duplicates
		
		Excel_Utility elib = new Excel_Utility();//data from excel
	    String orgname = elib.getExcelData("Organisation",0,0)+randnum;
	    org.sendOrgname(orgname);
	    org.clickOnSave();
//		driver.findElement(By.name("accountname")).sendKeys(orgname);
//		driver.findElement(By.name("button")).click();//save
		driver.navigate().refresh();
		
		VrfyAndVldte_Org validate = new VrfyAndVldte_Org(driver);
		validate.orgValidation(driver, orgname);
//		String actdata = driver.findElement(By.id("dtlview_Organization Name")).getText();
//        if(actdata.contains(orgname))
//        {
//        	System.out.println("Validation Pass");
//        }
//        else
//        {
//        	System.out.println("Validation Fail");
//        }
//     	WebElement element = driver.findElement(By.xpath("(//td[@class='small'])[2]"));
        home.logoutFromApp(driver);
//      wlib.mouseOverOnElement(driver, element);
//      driver.findElement(By.linkText("Sign Out")).click();//sign out
}
@Test
public void m() 
{
	System.out.println("pass");
}

}

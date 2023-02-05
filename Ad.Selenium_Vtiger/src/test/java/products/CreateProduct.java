package products;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Object_Repository.CreateProduct_Page;
import Object_Repository.Home_Page;
import Object_Repository.VerifyAndValidate_Prod;
import generic_utility.BaseClass;
import generic_utility.Excel_Utility;
import generic_utility.File_Utility;
import generic_utility.Java_Utility;
import generic_utility.WebDriver_Utility;

//@Listeners(generic_utility.ListenersClass.class)
public class CreateProduct extends BaseClass{
	@Test(groups="smoke")
		public void createProduct() throws Throwable {
//			System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
//			WebDriver driver = new ChromeDriver();
		    File_Utility flib = new File_Utility();
//			String BROWSER = flib.getKeyAndValue("browser");
//			WebDriver driver;
//			if(BROWSER.equalsIgnoreCase(BROWSER))
//			{
//				WebDriverManager.chromedriver().setup();
//				driver = new ChromeDriver();
//			}
//			else if(BROWSER.equalsIgnoreCase(BROWSER))
//			{
//				WebDriverManager.firefoxdriver().setup();
//				driver = new FirefoxDriver();
//			}
//			else
//			{
//				driver = new ChromeDriver();
//			}
			
			Home_Page home = new Home_Page(driver);
		    WebDriver_Utility wlib = new WebDriver_Utility();
		    wlib.maximizeScreen(driver);
		    CreateProduct_Page prd = new  CreateProduct_Page(driver);
		
//			String URL = flib.getKeyAndValue("url");
//			wlib.waitForPageToLoad(driver);
//			String USERNAME = flib.getKeyAndValue("username");
//			String PASSWORD = flib.getKeyAndValue("password");
//			
//			driver.get(URL);
//			Login_Page login = new Login_Page(driver);
//			login.loginToApp(USERNAME, PASSWORD);
			home.clickProductsLink();
			prd.clickProdPlusSign();
		
//			driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//			driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//			driver.findElement(By.id("submitButton")).click();
//     		driver.findElement(By.linkText("Products")).click();
//			driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
			
			Java_Utility jlib = new Java_Utility();
			int randnum = jlib.getRandomNum();
			
			Excel_Utility elib = new Excel_Utility();
		    String prodname = elib.getExcelData("Product",0,0)+randnum;
		    prd.sendProdname(prodname);
		    prd.clickOnSave();
		   // driver.findElement(By.name("productname")).sendKeys(prodname);
		   //  driver.findElement(By.name("button")).click();
		    VerifyAndValidate_Prod validate = new VerifyAndValidate_Prod(driver);
		    validate.prodVerifyAndValidate(driver, prodname);
//			String actdata = driver.findElement(By.id("dtlview_Product Name")).getText();
//			if(actdata.contains(prodname))
//			{
//				System.out.println("Validation Pass");
//			}
//			else
//			{
//				System.out.println("Validation Fail");
//			}
			home.logoutFromApp(driver);
//			WebElement ele = driver.findElement(By.xpath("(//td[@class='small'])[2]"));
//			wlib.mouseOverOnElement(driver, ele);
//			driver.findElement(By.linkText("Sign Out")).click();
	}

}

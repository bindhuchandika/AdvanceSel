package generic_utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import Object_Repository.Login_Page;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public WebDriver driver;
	public static WebDriver sdriver;
	@BeforeSuite(groups={"smoke","regression"})
	public void BS()
	{
		System.out.println("database connection");
	}
	@BeforeTest(groups={"smoke","regression"})
	public void BT()
	{
		System.out.println("parallel execution");
	}

//	@Parameters("BROWSER")
    @BeforeClass(groups={"smoke","regression"})
    public void BC() throws Throwable
	{
//  public void BC(String BROWSER) throws Throwable
//  {
    	File_Utility flib = new File_Utility();
    	String BROWSER = flib.getKeyAndValue("browser");
    	if(BROWSER.equalsIgnoreCase("chrome"))
    	{
    		WebDriverManager.chromedriver().setup();
    		driver = new ChromeDriver();
    	}
    	else if(BROWSER.equalsIgnoreCase("firefox"))
    	{
    		WebDriverManager.firefoxdriver().setup();
    		driver = new FirefoxDriver();
    	}
    	else if(BROWSER.equalsIgnoreCase("edge"))
    	{
    		WebDriverManager.edgedriver().setup();
    		driver = new EdgeDriver();
    	}
    	else
    	{
    		driver = new ChromeDriver();
    	}
    	System.out.println("launch the browser");
    	sdriver = driver;
}
    
    @BeforeMethod(groups={"smoke","regression"})
    public void BM() throws Throwable
	{
    	File_Utility flib = new File_Utility();	
        WebDriver_Utility wlib = new WebDriver_Utility();

        String URL = flib.getKeyAndValue("url");
    	wlib.waitForPageToLoad(driver);
    	String USERNAME = flib.getKeyAndValue("username");
    	String PASSWORD = flib.getKeyAndValue("password");
    	
    	driver.get(URL);
    	Login_Page login = new Login_Page(driver);
    	login.loginToApp(USERNAME, PASSWORD);
	
	System.out.println("login to the application");
	}
    @AfterMethod(groups={"smoke","regression"})
    public void AM()
	{
    	System.out.println("logout to the application");
	}
    
    @AfterClass(groups={"smoke","regression"})
    public void AC()
	{
    	System.out.println("close the browser");	
	}
    @AfterTest(groups={"smoke","regression"})
	public void AT()
	{
		System.out.println("execution done");
	}
    @AfterSuite(groups={"smoke","regression"})
	public void AS()
	{
		System.out.println("close database connection");
	}
}	
   
   
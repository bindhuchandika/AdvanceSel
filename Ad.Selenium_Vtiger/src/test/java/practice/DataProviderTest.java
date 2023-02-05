package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import generic_utility.BaseClass;

public class DataProviderTest {
	@Test(dataProvider="dataProvider_Test")
	public void companyDetails(String name, String phno, String email) throws Throwable {
		
			System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			  
			   FileInputStream fis = new FileInputStream("./src/test/resources/commondata.properties");
			   Properties p = new Properties();
			   p.load(fis);
			   String URL = p.getProperty("url");
			   String USERNAME = p.getProperty("username");
			   String PASSWORD = p.getProperty("password");
			   
			   driver.get(URL);
			   driver.findElement(By.name("user_name")).sendKeys(USERNAME);
			   driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
			   driver.findElement(By.id("submitButton")).click();
			   driver.findElement(By.xpath("//a[text()='Contacts']")).click();
			   driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
			   driver.findElement(By.name("lastname")).sendKeys(name);
			   driver.findElement(By.name("mobile")).sendKeys(phno);
			   driver.findElement(By.name("email")).sendKeys(email);
			   driver.findElement(By.name("button")).click();
//			   driver.findElement(By.xpath("(//td[@class='small'])[2]")).click();
//		       driver.findElement(By.linkText("Sign Out")).click();
	           driver.quit();
	           Thread.sleep(2000);
	}
        @DataProvider
        public Object[][] dataProvider_Test()
        {
        	Object[][] obj = new Object[3][3];
        	obj[0][0] = "AAA";
        	obj[0][1] = "9999999999";
        	obj[0][2] = "abc@gmail.com";
        	
        	obj[1][0] = "BBB";
        	obj[1][1] = "8888888888";
        	obj[1][2] = "def@gmail.com";

        	
        	obj[2][0] = "CCC";
        	obj[2][1] = "7777777777";
        	obj[2][2] = "ghi@gmail.com";
        	
        	return obj;

        }
}

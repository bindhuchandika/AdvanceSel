package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import generic_utility.WebDriver_Utility;

public class CreateContact_WithOrganisation {
	public static void main(String[] args) throws IOException, InterruptedException {
		   System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
		   WebDriver driver = new ChromeDriver();
		   WebDriver_Utility wlib = new  WebDriver_Utility();
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
		   
		   
		   
		   driver.findElement(By.linkText("Organizations")).click();
		   driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		   
		   //To avoid duplicates
		   Random ran = new Random();
		   int randname = ran.nextInt(1000);
		   //Reading data from excel sheet
		   FileInputStream fis1 = new FileInputStream("src/test/resources/ExcelData1.xlsx");
		   Workbook wb = WorkbookFactory.create(fis1);
		   Sheet sh = wb.getSheet("Sheet1");
		   Row row = sh.getRow(0);
		   Cell cell = row.getCell(0);
		   String orgname = cell.getStringCellValue()+randname;
		   driver.findElement(By.name("accountname")).sendKeys(orgname);
		   driver.findElement(By.name("button")).click();
		   driver.navigate().refresh();
		   driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		   driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		   
		   FileInputStream fis2 = new FileInputStream("./src/test/resources/ExcelData.xlsx");
		   Workbook wb1 = WorkbookFactory.create(fis2);
		   Sheet sh1 = wb1.getSheet("Contact");
		   Row row1 = sh1.getRow(0);  
		   Cell cel1 = row1.getCell(0);
		   String contname = cel1.getStringCellValue()+randname;
		   driver.findElement(By.name("lastname")).sendKeys(contname);
		   driver.findElement(By.xpath("//img[@alt='Select']")).click();
		   
		   Set<String> allId = driver.getWindowHandles();
		   Iterator<String> it = allId.iterator();
		   while(it.hasNext())
		   {
			   String wind = it.next();
			   driver.switchTo().window(wind);
			   String title = driver.getTitle();
			   if(title.contains("Accounts&action"))
			   {
				  break; 
			   }
		   }
		   driver.findElement(By.id("search_txt")).sendKeys(orgname);
		   driver.findElement(By.name("search")).click();
		   WebElement element = driver.findElement(By.xpath("//a[text()='"+orgname+"']"));
			wlib.waitForElementWithCustomTimeOut(driver,element,5000);
			
		   Set<String> allId1 = driver.getWindowHandles();
		   Iterator<String> it1 = allId1.iterator();
		   while(it1.hasNext())
		   {
			   String wind1 = it1.next();
			   driver.switchTo().window(wind1);
			   String title = driver.getTitle();
			   if(title.contains("Contacts&action"))
			   {
				  break; 
			   }
		   }
		   driver.findElement(By.name("button")).click();//save
		   WebElement ele2 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		   Actions a = new Actions(driver);
		   a.moveToElement(ele2).perform();     
		   driver.findElement(By.linkText ("Sign Out")).click();//sign out


	}

}

package generic_utility;

import java.time.Duration;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

public class WebDriver_Utility {

    public void maximizeScreen(WebDriver driver)
    {
		driver.manage().window().maximize();
	}
    public void waitForPageToLoad(WebDriver driver) 
    {
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    public void scriptTimeOut(WebDriver driver)
    {
     driver.manage().timeouts().setScriptTimeout(20,TimeUnit.SECONDS);
    }
    public void waitForElementWithCustomTimeOut(WebDriver driver,WebElement Element,int pollingTime) {
    		   // Waiting 30 seconds for an element to be present on the page, checking
    		   // for its presence once every 5 seconds.
    		   Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
    		       .withTimeout(Duration.ofSeconds(30L))
    		       .pollingEvery(Duration.ofSeconds(5L))
    		       .ignoring(NoSuchElementException.class);

    		   WebElement element = wait.until(new Function<WebDriver, WebElement>() {
    		     public WebElement apply(WebDriver driver) {
    		       return driver.findElement(By.id("foo"));
    		     }
    		   });
    		 

//     FluentWait wait = new FluentWait(driver);
//     wait.pollingEvery(Duration.ofSeconds(20));
//     wait.until(ExpectedConditions.elementToBeClickable(Element));
    }
    public void switchToWindow(WebDriver driver,String PartialWindowTitle) {
      Set<String> allId = driver.getWindowHandles();
      Iterator<String> it = allId.iterator();
    	   while(it.hasNext())
    	   {
    		   String wind = it.next();
    		   driver.switchTo().window(wind);
    		   String title = driver.getTitle();
    		   if(title.contains(PartialWindowTitle))
    		   {
    			  break; 
    		   }
    	   }
    }
    public void switchToAlertAndAccept(WebDriver driver)
    {
   	 driver.switchTo().alert().accept();
    }
    public void switchToAlertAndDismiss(WebDriver driver)
    {
      	 driver.switchTo().alert().dismiss();
    }
    public void switchToFrame(WebDriver driver,int index) 
    {
     	 driver.switchTo().frame(index);
    }
    public void switchToFrame(WebDriver driver,String id_name_Attribute)
    {
    	 driver.switchTo().frame(id_name_Attribute);
    }
    public void switchBackToFrame(WebDriver driver) 
    {
    	driver.switchTo().defaultContent();
    }
    public void select(WebElement element,int index)
    {
   	    Select s = new Select(element);
    	s.selectByIndex(index);
    }
    public void select(WebElement element,String text) 
    {
   	    Select s = new Select(element);
    	s.selectByVisibleText(text);
    }
    public void mouseOverOnElement(WebDriver driver,WebElement element)
    {
   	    Actions a = new Actions(driver);
    	a.moveToElement(element).perform();
    }
    public void rightClickOnElement(WebDriver driver,WebElement element)
    {
    	Actions a = new Actions(driver);
    	a.contextClick(element).perform();
    }
}

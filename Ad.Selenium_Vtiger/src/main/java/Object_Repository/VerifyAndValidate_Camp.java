package Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VerifyAndValidate_Camp {

		public VerifyAndValidate_Camp(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(id="dtlview_Campaign Name")
		private WebElement data;

		public WebElement getData() 
		{
			return data;
		}
        public void  campVerifyAndValidate(WebDriver driver,String campdata)
        {
        	String actdata = data.getText();
         	if(actdata.contains(campdata))
        	{
           		System.out.println("Validation Pass");
        	}
        	else
        	{
        		System.out.println("Validation Fail");
        	}
        	 	
        }

}

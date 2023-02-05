package Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VrfyAndValdte_CampVthPrd {
		public VrfyAndValdte_CampVthPrd(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(id="dtlview_Product Name")
		private WebElement data;
		
		@FindBy(id="dtlview_Campaign Name")
		private WebElement data1;

		public WebElement getData()
		{
			return data;
		}
		public WebElement getData1() 
		{
			return data;
		}
	    public void prodVerifyAndValidate(WebDriver driver,String proddata)
		
	    {
	    	String actdata = data.getText();
			if(actdata.contains(proddata))
			{
				System.out.println("Validation Pass");
			}
			else
			{
				System.out.println("Validation Fail");
			}
	    }
	    public void  campVerifyAndValidate(WebDriver driver,String campdata)
        {
        	String actdata = data1.getText();
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

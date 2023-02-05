package Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VrfyAndVldte_CreatDelPrd {
		public VrfyAndVldte_CreatDelPrd(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(id="dtlview_Product Name")
		private WebElement data;

		public WebElement getData() {
			return data;
		}
	    public void createDeleteProdVerifyAndValidate(WebDriver driver,String proddata)
		
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

}

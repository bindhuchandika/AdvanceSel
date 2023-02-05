package Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VrfyAndVldte_Org {
	public VrfyAndVldte_Org(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="dtlview_Organization Name")
	private WebElement actualorgdata;

	public WebElement getActualorgdata() {
		return actualorgdata;
	}
	public void orgValidation(WebDriver driver,String orgnamedata)
	{
		 String actdata = actualorgdata.getText();
		 if(actdata.contains(orgnamedata))
		 {
	        System.out.println("Validation Pass");
	     }
	     else
	     {
          	System.out.println("Validation Fail");
	     }
	
	}
}

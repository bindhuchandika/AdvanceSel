package generic_utility;

import java.io.File;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersClass implements ITestListener {

	public void onTestFailure(ITestResult result) {
	String testname = result.getMethod().getMethodName();
	System.out.println("-----execute------");
//	EventFiringWebDriver edriver = new EventFiringWebDriver(BaseClass.sdriver);
//	File src = edriver.getScreenshotAs(OutputType.FILE);

	TakesScreenshot ts = (TakesScreenshot)BaseClass.sdriver; 	
	File src = ts.getScreenshotAs(OutputType.FILE);
	Date date = Calendar.getInstance().getTime();
	String today = date.toString().replace(":","-");
    File dest = new File("./ScreenShot/"+testname+today+".png");
	try {
	FileUtils.copyFile(src,dest);
	}
	catch(Exception e)
	{
		e.printStackTrace(); 
	}
	}
}

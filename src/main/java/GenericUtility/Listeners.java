package GenericUtility;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

//go to source and click on override and impement methods n click onTestFailure()
public class Listeners implements ITestListener{

	  public void onTestFailure(ITestResult result) {
		//ths is a implemented method from listeners class
		String testname = result.getMethod().getMethodName();
		
		EventFiringWebDriver edriver=new EventFiringWebDriver(BaseClass.sdriver);
		//sdriver will take the screenshot of failed TS
		File src = edriver.getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(src, new File("./Screenshot/"+testname+".png"));
			
		} catch (Exception e) {
			e.printStackTrace();
			//this method will trace the entire method
		}
	}

	
}

package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VerificationAndValidationPage {
	
	public VerificationAndValidationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
  @FindBy(xpath="//span[@id='dtlview_Organization Name']")
	private WebElement actualOrganizationData;
	
  //getter method
	public WebElement getActualOrganizationData() {
		return actualOrganizationData;
	}
	
	//bussiness logics
	public String organizationValidation(WebDriver driver,String data)
	{
	String actData = actualOrganizationData.getText();
	
	if(actData.contains(data))
	   {
	  	 System.out.println("pass");
	   }
	   else
	   {
	  	 System.out.println("fail");
	   }
	return actData;
	
	}
	
	
}

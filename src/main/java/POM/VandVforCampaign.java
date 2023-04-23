package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VandVforCampaign {
	public VandVforCampaign(WebDriver driver, String data)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//span[@id='dtlview_Campaign Name']")
	private WebElement actualCampaignData;
	
	@FindBy(xpath="//span[@id='dtlview_Product']")
	private WebElement actualProductData;
	
	public WebElement getActualProductData() {
		return actualProductData;
	}

	public WebElement getActualCampaignData() {
		return actualCampaignData;
	}
	
	public String CampaignValidation(WebDriver driver,String data)
	{
		String act =actualCampaignData.getText();
		 if(act.contains(data))
	      {
	    	  System.out.println("camp is pass");
	    	  
	      }
	      else
	      {
	    	  System.out.println("camp is fail");
	      }
		return act;
		 }
	
		public String ProductValidation(WebDriver driver1,String data1)
		{
			
		 String actdata1=actualProductData.getText();
		 if(actdata1.contains(data1))
	      { 
	    	  System.out.println("prod is pass");
	    	  
	      }
	      else
	      {
	    	  System.out.println("prod is fail");
	      }
		return actdata1;
	}
}

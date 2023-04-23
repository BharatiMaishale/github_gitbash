package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VandVforProduct {

	public VandVforProduct(WebDriver driver, String data)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[@id='dtlview_Product Name']")
   private WebElement actualproductText;

	public WebElement getProductText() {
		return actualproductText;
	}
   
	public String ValidationofProduct(WebDriver driver,String data) {
		String actdata=actualproductText.getText();
		
		if(actdata.contains(data))
	      {
		   System.out.println("pass");
	      }
	      else
		   System.out.println("fail");
		return actdata;
	}
   
   
}

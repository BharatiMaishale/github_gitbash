package POM;

import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductCreationPage {

	public ProductCreationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//Declaration
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement ProductCreateImage;
	
	@FindBy(name="productname")
	private WebElement ProductNameTextField;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;

	@FindBy(xpath="(//a[.='Products'])[2]")
	private WebElement productBackButton;
	
	@FindBy(xpath="//input[@value='Delete']")
	private WebElement deleteProduct;
	
	
	//getter Methods
	
	public WebElement getProductCreateImage() {
		return ProductCreateImage;
	}

	public WebElement getProductNameTextField() {
		return ProductNameTextField;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	public WebElement getProductBackButton() {
		return productBackButton;
	}

	public WebElement getDeleteProduct() {
		return deleteProduct;
	}
	
	//Businesslogic
	/**
	 * This Method is used for ClickOn +img
	 */
	public void ClickProductCreateImage()
	{
		ProductCreateImage.click();
	}
	/**
	 * This Method is used to Pass Value to Product TextField
	 */
	public void ClickProductNameTextField(String prdtName)
	{
		ProductNameTextField.sendKeys(prdtName);;
	}
	/**
	 * This Method is used to Save ProductName
	 */
	public void SaveButton()
	{
		saveButton.click();
	}
	public void productBackButton(WebDriver driver)
	{
		productBackButton.click();
	}

	public void deleteProduct()
	{
		deleteProduct.click();
	}
	
	public String Verification(WebDriver driver,String productdata) {
		java.util.List<WebElement> Lists = driver.findElements(By.xpath("(//table[@class='lvt small']/tbody/tr/td[3])[position()>1]"));
	        
	        boolean flag=false;
	        for(WebElement wb:Lists)
	        {
	        	String act = wb.getText();
	        	if(act.contains(productdata))
	        	{
	        		flag=true;
	        		break;
	        	}
	        	
	        }
	        if(flag)
	        {
	        	System.out.println("deleted");
	        	
	        }
	        else
	        {
	        	System.out.println("not deleted");
	        }
			return productdata;
		
	    }
	
}

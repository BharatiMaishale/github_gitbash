package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignCreatePage {

	public CampaignCreatePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	 //Declaration
	@FindBy(xpath="//img[@alt='Create Campaign...']")
	private WebElement CampaigncreateImage;
	
	@FindBy(name="campaignname")
	private WebElement CampaignNameTextField;
	
	@FindBy(xpath="//img[@title='Select']")
	private WebElement SelectProduct;
	
	@FindBy(id="search_txt")
	private WebElement SearchBox;
	
	@FindBy(name="search")
	private WebElement SearchButton;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	

	//Getters method
	public WebElement getCampaigncreateImage() {
		return CampaigncreateImage;
	}

	public WebElement getCampaignNameTextField() {
		return CampaignNameTextField;
	}

	public WebElement getSelectProduct() {
		return SelectProduct;
	}

	public WebElement getSearchBox() {
		return SearchBox;
	}

	public WebElement getSearchButton() {
		return SearchButton;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	//Business logic
	public void Clickcampaigncreate()
	{
		CampaigncreateImage.click();
	}
	public void ClickCampaignName(String Cmpname)
	{
		CampaignNameTextField.sendKeys(Cmpname);
	}
	public void ClickselectProd()
	{
		SelectProduct.click();
	}
	public void Clicksearchbox(String data)
	{
		SearchBox.sendKeys(data);
	}
	public void ClicksearchButton()
	{
		SearchButton.click();
	}
	public void ClickSave()
	{
		saveButton.click();
	}
}

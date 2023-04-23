package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtility.WebdriverUtility;

public class HomePage {
	//create constructor( initialization)
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//declaration
	@FindBy(linkText="Products")
	private WebElement produtTxt;	
	
	@FindBy(linkText="More")
	private WebElement moreTxt;
	
	@FindBy(linkText="Campaigns")
	private WebElement campaigntxt;
	
	@FindBy(linkText="Organizations")
	private WebElement organizationTxt;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement signoutImg;
	
	@FindBy(linkText="Sign Out")
	//@FindBy(xpath="//a[@class='drop_down_usersettings'][1]")
	private WebElement signoutTxt;
    
  //utilization
	public WebElement getProdutTxt() {
		return produtTxt;
	}
	public WebElement getMoreTxt() {
		return moreTxt;
	}
	public WebElement getCampaigntxt() {
		return campaigntxt;
	}
	public WebElement getOrganizationTxt() {
		return organizationTxt;
	}
	public WebElement getSignoutImg() {
		return signoutImg;
	}
	public WebElement getSignoutTxt() {
		return signoutTxt;
	}

	//business logic
	
	public void ClickOraganization()
	{
		organizationTxt.click();
	
	}
	public void ClickmoreLink(WebDriver driver)
	{
		WebdriverUtility wlib=new WebdriverUtility();
		wlib.mouseOverOnElement(driver, moreTxt);
	}
	public void ClickCampaign()
	{
		campaigntxt.click();
		
	}
	public void ClickProduct()
	{
		produtTxt.click();
		
	}
	public void signout(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.moveToElement(signoutImg).perform();
		signoutTxt.click();
	}
}


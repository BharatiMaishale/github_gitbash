package GenericUtility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

public class WebdriverUtility {

	/**
	 * this method wait for page to loadin GUI
	 * @param driver
	 */
	public void implicitlywait(WebDriver driver)
	{
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}
	
	/**
	 * after every action it will go to next action to perform
	 * @param driver
	 */
	public void scriptTimeout(WebDriver driver)
	{
		driver.manage().timeouts().setScriptTimeout(20,TimeUnit.SECONDS);
	}
	
	/**
	 * used to wait for element to be clickable in GUI and checkforspecific element for every 500ms
	 * @param driver
	 * @param Element
	 * @param pollingTime
	 */
	public void waitForElementWithCustomTimeOut(WebDriver driver,WebElement Element, int pollingTime)
	{
		FluentWait wait=new FluentWait(driver);
			wait.pollingEvery(Duration.ofSeconds(20));
			wait.until(ExpectedConditions.elementToBeClickable(Element));
			
	}
	
	/**
	 * This method is used for maximizing the window
	 * @param driver
	 */
	public void maximize(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	/**
	 * This method is used for switching windows based on window title
	 * @param driver
	 * @param PartialWindowTitle
	 * @author bharati
	 */
	public void switchwindow(WebDriver driver, String PartialWindowTitle)
	{
		Set<String> allid = driver.getWindowHandles();
	      Iterator<String> id = allid.iterator();

	      while(id.hasNext())
	      {
	    	 String wid = id.next();
	    	 driver.switchTo().window(wid);
	    	 String title = driver.getTitle();
	    	 
	    	 if(title.contains(PartialWindowTitle))
	    	 {
	    		 break;
	    	 }
	      }
	}
	
	/**
	 * used to switch to alertwindow and accept(click on ok button)
	 * @param driver
	 * @author bharati
	 */
	public void switchToAlertAndAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	/**
	 * used to switch to alertwindow and dismiss(click on cancel button)
	 * @param driver
	 * @author bharati
	 */
	public void switchToAlertAndDismiss(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * used to switch to frame window based on index
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver, int index )
	{
		driver.switchTo().frame(index);
	}
	
	/**
	 * used to switch to frame window based on id or name attribute
	 * @param driver
	 * @param id_name_Attribute
	 */
	public void switchToFrame(WebDriver driver,String id_name_Attribute)
	{
		driver.switchTo().frame(id_name_Attribute);
	}
	
	/**
	 * used to slect the value from the dropdown based on index
	 * @param element
	 * @param index
	 */
	public void select(WebElement element, int index)
	{
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}
	
	/**
	 * used to select the value from the dropdown based on text
	 * @param element
	 * @param text
	 */
	public void select(WebElement element, String text)
	{
		Select sel=new Select(element);
		sel.selectByVisibleText(text);
    }
	
	/**
	 * used to right click on the specific elemnt
	 * @param driver
	 * @param element
	 */
	public void rightClickOnElement(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
	}
	
	/**
	 * 
	 * @param driver
	 * @param x
	 * @param y
	 */
	public void moveByOffset(WebDriver driver, int x, int y)
	{
		Actions act=new Actions(driver);
		act.moveByOffset(x, y).click().perform();
	}
	/**
	 * used to place cursor on specified element
	 * @param driver
	 * @param element
	 */
	public void mouseOverOnElement(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	
}

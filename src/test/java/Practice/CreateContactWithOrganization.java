package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import GenericUtility.ExcelUtility;
import GenericUtility.JavaUtility;
import GenericUtility.PropertyUtility;
import GenericUtility.WebdriverUtility;
import POM.HomePage;
import POM.LoginPage;
import POM.OrganizationCreationPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactWithOrganization {

	public static void main(String[] args) throws Throwable {
		WebDriver driver;
		PropertyUtility plib=new PropertyUtility();
		String BROWSER = plib.getKeyValue("browser");
		
		if(BROWSER.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else
		{
			driver=new EdgeDriver();
		}
		WebdriverUtility wlib=new WebdriverUtility();
		wlib.maximize(driver);
		wlib.implicitlywait(driver);
		
		String URL = plib.getKeyValue("url");
		String USERNAME = plib.getKeyValue("username");
		String PASSWORD = plib.getKeyValue("password");	
	    driver.get(URL);
		      
	  /*driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();*/
	    LoginPage loginPage = new LoginPage(driver);
		loginPage.loginToApp(USERNAME, PASSWORD);
	    loginPage.getSubmitBtn();

		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
		JavaUtility jlib=new JavaUtility();
	    int RanNum = jlib.getRandomNum();
		ExcelUtility elib=new ExcelUtility();
	    String contactdata = elib.getExcelDataFormatter("Contact",0,0)+RanNum;
	    
		driver.findElement(By.name("lastname")).sendKeys(contactdata);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		 
		// driver.findElement(By.linkText("Organizations")).click();
	    // driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		 HomePage pomhomepage = new  HomePage(driver);
		 pomhomepage.ClickOraganization();
		 
		 OrganizationCreationPage org=new OrganizationCreationPage(driver);
		 org.clickOrganizationCreateImage();
		 
		 String exceldata = elib.getExcelData("organization",2,0)+RanNum;

		 driver.findElement(By.name("accountname")).sendKeys(exceldata);
		 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		  
		/*pomhomepage.getMoreTxt().click();
		 driver.findElement(By.xpath("//a[text()='More']")).click();
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//a[text()='Sales Order']")).click();*/
		
		 Thread.sleep(3000);
		 driver.findElement(By.linkText("More")).click();
		 driver.findElement(By.name("Invoice")).click();
		 driver.findElement(By.xpath("//img[@title='Create Invoice...']")).click();
			    
	     String invoicedata = elib.getExcelDataFormatter("Invoice",1,1)+RanNum;
	     driver.findElement(By.xpath("//input[@class='detailedViewTextBox'][1]")).sendKeys(invoicedata);
	     Thread.sleep(1000);
	    
	   //driver.findElement(By.xpath("(//img[@title='Select'])[2]")).click();
	    WebdriverUtility wlib1=new WebdriverUtility();
	   /* wlib1.switchwindow(driver, "Contacts&action");
	       
	    driver.findElement(By.xpath("//input[@class='txtBox']")).sendKeys(contactdata);
	    Thread.sleep(1000);
	    driver.findElement(By.name("search")).click();
	   //driver.findElement(By.xpath("//a[text()=' Bharati K575']")).click();
	    driver.findElement(By.xpath("//a[text()='"+ contactdata+"']")).click();
	    Thread.sleep(1000); 
	    wlib1.switchwindow(driver, "Invoice&action");
	    Thread.sleep(1000); */
	    driver.findElement(By.xpath("(//img[@alt='Select'])[3]")).click();
	    wlib1.switchwindow(driver, "Accounts&action");
	    driver.findElement(By.xpath("//input[@class='txtBox']")).sendKeys(exceldata);
	  
	    driver.findElement(By.name("search")).click();
	    driver.findElement(By.xpath("//a[text()='"+exceldata+"']")).click();
	    Thread.sleep(1000);
	    wlib1.switchwindow(driver, "Invoice&action");
	}

}

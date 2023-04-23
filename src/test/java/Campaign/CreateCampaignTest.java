package Campaign;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import GenericUtility.BaseClass;
import GenericUtility.ExcelUtility;
import GenericUtility.JavaUtility;
import GenericUtility.PropertyUtility;
import GenericUtility.WebdriverUtility;
import POM.CampaignCreatePage;
import POM.HomePage;
import POM.LoginPage;
import POM.OrganizationCreationPage;
import POM.VandVforCampaign;
import POM.VerificationAndValidationPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCampaignTest extends BaseClass {
	
   @Test(groups = "smoketest")
	public void CreateCampaignTest() throws Throwable {
		//WebDriver driver=new EdgeDriver();
		/*WebDriver driver;
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();*/
		
		/*WebDriver driver;
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
		}*/
		//driver.manage().window().maximize();
		WebdriverUtility wlib=new WebdriverUtility();
		wlib.maximize(driver);
		//driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		wlib.implicitlywait(driver);
     
     
		/*FileInputStream fis=new FileInputStream("./src/test/resources/commondata10.properties.txt.txt");
		Properties pro=new Properties();
		pro.load(fis);
		String URL=pro.getProperty("url");
		String USERNAME = pro.getProperty("username");
		String PASSWORD = pro.getProperty("password");
		 driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	     driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	     driver.findElement(By.id("submitButton")).click(); */
	     
		/*String URL = plib.getKeyValue("url");
		String USERNAME = plib.getKeyValue("username");
		String PASSWORD = plib.getKeyValue("password");	
	    driver.get(URL);
	    LoginPage loginPage = new LoginPage(driver);
		loginPage.loginToApp(USERNAME, PASSWORD);
		loginPage.getSubmitBtn();*/
	   
		  Actions a=new Actions(driver);
		  WebElement more = driver.findElement(By.linkText("More"));
		  a.moveToElement(more).perform();
      
		 HomePage pomhomepage= new HomePage(driver);
		 pomhomepage.getMoreTxt().click();
		 //driver.findElement(By.linkText("More")).click();
		 
		 //driver.findElement(By.linkText("Campaigns")).click();
	     //driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
		 
		 pomhomepage.ClickCampaign();
		 CampaignCreatePage ccp=new CampaignCreatePage(driver);
		 ccp.Clickcampaigncreate();
		 
		 
    //  Random ran=new Random();
    //  int RanNum = ran.nextInt(1000);
        JavaUtility jlib=new JavaUtility();
        int RanNum = jlib.getRandomNum();
      
     /* FileInputStream fes=new FileInputStream("./src/test/resources/ExcelTest.xlsx");
      Workbook book=  WorkbookFactory.create(fes);
      Sheet sheet = book.getSheet("campaigns");
      Row row = sheet.getRow(0);
      Cell cell = row.getCell(0);
      String Campdata = cell.getStringCellValue()+RanNum;*/
        
      ExcelUtility elib=new ExcelUtility();
      String Campdata = elib.getExcelData("campaigns",0,0)+RanNum;
   
    //  driver.findElement(By.name("campaignname")).sendKeys(Campdata);
      ccp.ClickCampaignName(Campdata);
      //driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
      ccp.ClickSave();      
      
    /*String Actdata = driver.findElement(By.cssSelector("span.dvHeaderText")).getText();
    if(Actdata.contains(Campdata))
    {
 	   System.out.println("pass");
 	   
    }
    else
    {
 	   System.out.println("fail");
    }
    */ 
     VandVforCampaign validate=new VandVforCampaign(driver, Campdata);
     String actData = validate.CampaignValidation(driver, Campdata);
     Assert.assertEquals(actData, Campdata);
     
    // pomhomepage.signout(driver);
    /* driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
     driver.findElement(By.linkText("Sign Out")).click();*/
      
      
	}
 
   
}

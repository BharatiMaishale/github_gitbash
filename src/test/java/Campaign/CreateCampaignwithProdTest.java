package Campaign;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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
import POM.ProductCreationPage;
import POM.VandVforCampaign;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCampaignwithProdTest extends BaseClass {
	
 @Test(groups = "regressiontest")
	public void CreateCampaignwithProdTest() throws Throwable {
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
	 // driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	   wlib.implicitlywait(driver);
	   
	  /* FileInputStream fis=new FileInputStream("./src/test/resources/commondata10.properties.txt.txt");
       Properties pro=new Properties();
       pro.load(fis);
       String URL = pro.getProperty("url");
       String USERNAME = pro.getProperty("username");
       String PASSWORD = pro.getProperty("password");
	   driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	   driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	   driver.findElement(By.id("submitButton")).click();*/
	   
	  /*String URL = plib.getKeyValue("url");
	  String USERNAME = plib.getKeyValue("username");
	  String PASSWORD = plib.getKeyValue("password");	
      driver.get(URL);
      LoginPage loginPage = new LoginPage(driver);
	  loginPage.loginToApp(USERNAME, PASSWORD);
	  loginPage.getSubmitBtn();*/
      
      //driver.findElement(By.linkText("Products")).click();
	     HomePage pomhomepage= new HomePage(driver);
		 pomhomepage.ClickProduct();
		 
		 // driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		 
		 ProductCreationPage prdt=new ProductCreationPage(driver);
		 prdt.ClickProductCreateImage();
      
    //  Random ran=new Random();
    //  int RanNum = ran.nextInt(1000);
      JavaUtility jlib=new JavaUtility();
      int RanNum = jlib.getRandomNum();
      
    /*  FileInputStream fes=new  FileInputStream("./src/test/resources/ExcelTest.xlsx");
     Workbook book= WorkbookFactory.create(fes);
     Sheet sheet = book.getSheet("product");
     Row row = sheet.getRow(0);
      Cell cell = row.getCell(0);
      String productdata = cell.getStringCellValue()+RanNum;*/
   
    ExcelUtility elib=new ExcelUtility();
    String productdata = elib.getExcelDataFormatter("product",0,0)+RanNum;
    
   // driver.findElement(By.name("productname")).sendKeys(productdata);
    prdt.ClickProductNameTextField(productdata);
    
   // driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
   prdt.SaveButton();
   
   // driver.findElement(By.linkText("More")).click();
	 pomhomepage.ClickmoreLink(driver);
	 Thread.sleep(2000);
	 // driver.findElement(By.linkText("Campaigns")).click();
	   pomhomepage.ClickCampaign();
	
	// driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
	 CampaignCreatePage ccp=new CampaignCreatePage(driver);
	 ccp.Clickcampaigncreate();
	       
     /* FileInputStream fes1=new FileInputStream("./src/test/resources/ExcelTest.xlsx");
      Workbook book1=  WorkbookFactory.create(fes1);
      Sheet sheet1 = book1.getSheet("campaigns");
      Row row1 = sheet1.getRow(0);
      Cell cell1 = row1.getCell(0)  ;
      String Campdata = cell1.getStringCellValue()+RanNum;*/
      String Campdata = elib.getExcelDataFormatter("campaigns",0,0)+RanNum;
      
      
      // driver.findElement(By.name("campaignname")).sendKeys(Campdata);
      
      ccp.ClickCampaignName(Campdata);
      
      //driver.findElement(By.xpath("//img[@title='Select']")).click();
      ccp.ClickselectProd();
      
    /* Set<String> allid = driver.getWindowHandles();
      Iterator<String> id = allid.iterator();

      while(id.hasNext())
      {
    	 String wid = id.next();
    	 driver.switchTo().window(wid);
    	 String title = driver.getTitle();
    	 
    	 if(title.contains("Products&action"))
    	 {
    		 break;
    	 }
      }*/
      WebdriverUtility wlib1=new WebdriverUtility();
      wlib1.switchwindow(driver, "Products&action");
          
      //driver.findElement(By.id("search_txt")).sendKeys(productdata);
      //driver.findElement(By.name("search")).click();
      
      ccp.Clicksearchbox(productdata);
      ccp.ClicksearchButton();
      
   //  driver.findElement(By.xpath("//a[text()='Iphone776']")).click();
      driver.findElement(By.xpath("//a[text()='"+productdata+"']")).click();
      
     /* Set<String> allid1 = driver.getWindowHandles();
      Iterator<String> id1 = allid1.iterator(); 
      while(id1.hasNext())
      {
    	String wid1 = id1.next();
    	driver.switchTo().window(wid1);
    	String title1 = driver.getTitle();
    	
    	if(title1.contains("Campaigns&action"))
    	{
    		break;
    	}
      }*/
      
      wlib1.switchwindow(driver, "Campaigns&action");
      
      //driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
      ccp.ClickSave();
      
      VandVforCampaign validate=new VandVforCampaign(driver, Campdata);
    String act= validate.CampaignValidation(driver, Campdata);
    Assert.assertEquals(act, Campdata);
      
     /* String act = driver.findElement(By.xpath("//span[@id='dtlview_Campaign Name']")).getText();
      if(act.contains(Campdata))
      {
    	  System.out.println("camp is pass");
    	  
      }
      else
      {
    	  System.out.println("camp is fail");
      }*/
     String actdata=validate.ProductValidation(driver, productdata);
      Assert.assertEquals(actdata, productdata);
     
    /* String actdata = driver.findElement(By.xpath("//span[@id='dtlview_Product']")).getText();
      
      if(actdata.contains(productdata))
      { 
    	  System.out.println("prod is pass");
    	  
      }
      else
      {
    	  System.out.println("prod is fail");
      }*/
    	 //driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
    	// driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
    	 //pomhomepage.signout(driver);
    	 
      }
     
}




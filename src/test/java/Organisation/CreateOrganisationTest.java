package Organisation;

import java.io.FileInputStream;
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
import org.testng.annotations.Listeners;
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

@Listeners(GenericUtility.Listeners.class)
public class CreateOrganisationTest  extends BaseClass{
         @Test(groups = {"smoketest", "regressiontest", "sanitytest"})
	
//	@Test(retryAnalyzer= GenericUtility.RetryExample.class)
		public void createOrganisationTest() throws Throwable
		{			
		//driver.manage().window().maximize();
		WebdriverUtility wlib=new WebdriverUtility();
		wlib.maximize(driver);
		//driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		wlib.implicitlywait(driver);
		
	/*	String URL = plib.getKeyValue("url");
		String USERNAME = plib.getKeyValue("username");
		String PASSWORD = plib.getKeyValue("password");	
		driver.get(URL);   
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginToApp(USERNAME, PASSWORD);
		loginPage.getSubmitBtn();
		*/
		
		/*FileInputStream fis=new FileInputStream("./src/test/resources/commondata10.properties.txt.txt");
		Properties pro=new Properties();
		pro.load(fis);
		String URL=pro.getProperty("url");
		String USERNAME = pro.getProperty("username");
		String PASSWORD = pro.getProperty("password");*/
	
	    /* driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	     driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	     driver.findElement(By.id("submitButton")).click();*/
	   
      // driver.findElement(By.linkText("Organizations")).click();
       HomePage pomhomepage = new  HomePage(driver);
	   pomhomepage.getOrganizationTxt().click();
	  // Assert.assertEquals(false, true);
	   
	  // driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
	   OrganizationCreationPage org=new OrganizationCreationPage(driver);
	   org.clickOrganizationCreateImage();
	   
   /*  Random ran=new Random();
     int RanNum = ran.nextInt(1000);*/
     
     JavaUtility jlib=new JavaUtility();
     int RanNum = jlib.getRandomNum();
     
     ExcelUtility elib=new ExcelUtility();
    String exceldata = elib.getExcelData("organization",2,0)+RanNum;
    
    /* FileInputStream fes=new FileInputStream("./src/test/resources/ExcelTest.xlsx");
     Workbook book=  WorkbookFactory.create(fes);
     Sheet sheet = book.getSheet("organization");
     Row row = sheet.getRow(2);
     Cell cell = row.getCell(0)  ;
     String exceldata = cell.getStringCellValue()+RanNum;
     */
  
     org.organizationNamesTextField(exceldata);
     //driver.findElement(By.name("accountname")).sendKeys(exceldata);
     
     org.saveButton();
    // driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
     
  /* String Actdata = driver.findElement(By.cssSelector("span.dvHeaderText")).getText();
   if(Actdata.contains(exceldata))
   {
	   System.out.println("pass");
	   
   }
   else
   {
	   System.out.println("fail");
   }*/
     VerificationAndValidationPage validate=new VerificationAndValidationPage(driver);
     String  actData=validate.organizationValidation(driver, exceldata);
     Assert.assertEquals(actData, exceldata);
  
    // pomhomepage.signout(driver);
    //driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
    //driver.findElement(By.linkText("Sign Out")).click();
     
    	} 

}       


package Product;

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
import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
import POM.HomePage;
import POM.LoginPage;
import POM.ProductCreationPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateandDeleteProductTest extends BaseClass{
	
  @Test
	public void createandDeleteProductTest() throws Throwable {
		//WebDriver driver=new EdgeDriver();
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
		}
		*/
		//driver.manage().window().maximize();
		WebdriverUtility wlib=new WebdriverUtility();
		wlib.maximize(driver);
		//driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		wlib.implicitlywait(driver);
     
		/*FileInputStream fis=new FileInputStream("./src/test/resources/commondata10.properties.txt.txt");
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
		 
		 
    /*  Random ran=new Random();
      int RanNum = ran.nextInt(1000);*/
      JavaUtility jlib=new JavaUtility();
      int RanNum = jlib.getRandomNum();
      
      /*FileInputStream fes=new  FileInputStream("./src/test/resources/ExcelTest.xlsx");
     Workbook book= WorkbookFactory.create(fes);
     Sheet sheet = book.getSheet("product");
     Row row = sheet.getRow(0);
     Cell cell = row.getCell(0);
     String productdata = cell.getStringCellValue()+RanNum;*/
      ExcelUtility elib=new ExcelUtility();
      String productdata = elib.getExcelDataFormatter("product",0,0)+RanNum;
   
  // driver.findElement(By.name("productname")).sendKeys(productdata);
   prdt.ClickProductNameTextField(productdata);
   System.out.println(productdata);
   
   //driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
    prdt.SaveButton();
    
  // driver.findElement(By.xpath("(//a[.='Products'])[2]")).click();
    prdt.productBackButton(driver);
    
   driver.findElement(By.xpath("//table[@class='lvt small']/tbody//td//a[text()='"+productdata+"']/../preceding-sibling::td[2]")).click();
  // driver.findElement(By.xpath("//input[@value='Delete']")).click();
   prdt.deleteProduct();
   
   /*Alert alt=driver.switchTo().alert();
   Thread.sleep(1000);
   alt.accept();*/
   wlib.switchToAlertAndAccept(driver);
   // driver.findElement(By.xpath("(//input[@type='checkbox'])[14]")).click();
   
     String actDta = prdt.Verification(driver, productdata);
     Assert.assertEquals(actDta, productdata);
     
  /* java.util.List<WebElement> Lists = driver.findElements(By.xpath("(//table[@class='lvt small']/tbody/tr/td[3])[position()>1]"));
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
   }*/
 
   //pomhomepage.signout(driver);
   /*
   driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
   driver.findElement(By.linkText("Sign Out")).click();*/
  
	}

}

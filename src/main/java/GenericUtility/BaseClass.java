package GenericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import POM.HomePage;
import POM.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass {
	
	public static WebDriver sdriver;//to use listener class as static variable
	 public WebDriver driver;//making driver public to be accessible by child classes
	
	 public PropertyUtility plib=new PropertyUtility();
@BeforeSuite(groups= {"smoketest","regressiontest", "sanitytest"})
	public void BS()
	{
		System.out.println("DataBase connection");
	}

 @BeforeTest(groups= {"smoketest","regressiontest", "sanitytest"})
    public void BT()
    {
    	System.out.println("Parallel Execution");
    }
    @Parameters("BROWSER")
 @BeforeClass(groups= {"smoketest","regressiontest", "sanitytest"})
 
   // public void BC(String BROWSER)
    //{
    public void BC() throws Throwable
     {
	
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
	 System.out.println("Launching Browser");
	 sdriver=driver;
      }
 @BeforeMethod(groups= {"smoketest","regressiontest", "sanitytest"})
    public void BM() throws Throwable
    {
	    String URL = plib.getKeyValue("url");
		String USERNAME = plib.getKeyValue("username");
		String PASSWORD = plib.getKeyValue("password");	
		driver.get(URL);   
		LoginPage login = new LoginPage(driver);
		login.loginToApp(USERNAME, PASSWORD);
		login.getSubmitBtn();
    	System.out.println("Login Application");
    }
  @AfterMethod(groups= {"smoketest","regressiontest", "sanitytest"})
   public void AM()
   { 
	  HomePage pomhomepage = new  HomePage(driver);
	  pomhomepage.signout(driver);
	   System.out.println("Logout Application");
   }
  
  @AfterClass(groups= {"smoketest","regressiontest", "sanitytest"})
  public void AC()
  {
	  
 System.out.println("Browser closed");
  }

  @AfterTest(groups= {"smoketest","regressiontest", "sanitytest"})
  public void AT()
  {
	
  	System.out.println("Parallel Execution Done");
  }
  
  @AfterSuite(groups= {"smoketest","regressiontest", "sanitytest"})
  public void AS()
  {
  	System.out.println("DataBase Connection close");
  }
}   
//1st pull

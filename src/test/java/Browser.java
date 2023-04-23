import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Browser {

	public static void main(String[] args) throws Throwable {
		
		/*String key="webdriver.edge.driver";
		String Value="./Referenced Libraries/selenium-server-4.8.1.jar";
		System.setProperty(key, Value);
		WebDriver driver=new EdgeDriver();*/
		
		
		WebDriver driver=new EdgeDriver();
		FileInputStream fis=new FileInputStream("./src/test/resources/commondata10.properties.txt.txt");
		
		Properties pro=new Properties();
		pro.load(fis);
		
		String URL=pro.getProperty("url");
		
		String USERNAME=pro.getProperty("username");
		String PASSWORD=pro.getProperty("password");
		driver.get(URL);
		
		driver.findElement(By.id("username")).sendKeys(USERNAME);
		driver.findElement(By.name("pwd")).sendKeys(PASSWORD);
		driver.findElement(By.id("loginButton")).click();

		
	}

}

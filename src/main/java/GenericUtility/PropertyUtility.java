package GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class PropertyUtility {

	/**
	 * This method is used for fetching data from property file
	 * @param key
	 * @return
	 * @throws Throwable
	 * @author bharati
	 */
	public String getKeyValue(String key) throws Throwable
	{
		FileInputStream fis=new FileInputStream("./src/test/resources/commondata10.properties.txt.txt");
	       Properties pro=new Properties();
	       pro.load(fis);
	       String Value = pro.getProperty(key);
	       return Value;
	}
}

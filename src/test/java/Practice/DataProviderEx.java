package Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderEx {
	
	
	@Test(dataProvider = "dataprovider")
	
	public void bookingTickets(String src, String dest)
	{
		System.out.println("Book tickets from" +src+ "to" +dest);
	}
	
	@DataProvider
      public Object[][] dataprovider()
      {
    	  Object[][] objarr=new Object[3][2];
    	  
    	  objarr[0][0]="Bangalore";
    	  objarr[0][1]="Goa";
    	  objarr[1][0]="Bangalore";
    	  objarr[1][1]="Mysore";
    	  objarr[2][0]="Bangalore";
    	  objarr[2][1]="Hubli";
    	  
		return objarr;
    	  
      }
}

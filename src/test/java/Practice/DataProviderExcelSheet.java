package Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import GenericUtility.ExcelUtility;

public class DataProviderExcelSheet {

	@Test(dataProvider="getData")
	public void readData(String from,String to)
	{
		System.out.println(from+"  "+to);
	}
	@DataProvider
	public Object[][] getData() throws Throwable
	{
		ExcelUtility excel=new ExcelUtility();
		/*Object[][] objarr=new Object[3][2];
	
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<2;j++)
			{
				objarr[i][j]=excel.getExcelData("DataProvidersheet", i, j);
			}
		}
		return objarr;*/
		
		Object[][] value = excel.readMultipleData("DataProvidersheet");
		return value;
		
		/*
		 * objarr[0][0]=ex.getExcelData("DataProvider", 1, 0);
		 * objarr[0][1]=ex.getExcelData("DataProvider", 1, 1);
		 * 
		 * objarr[1][0]=ex.getExcelData("DataProvider", 2, 0);
		 * objarr[1][1]=ex.getExcelData("DataProvider", 2, 1);
		 * 
		 * objarr[2][0]=ex.getExcelData("DataProvider", 3, 0);
		 * objarr[2][1]=ex.getExcelData("DataProvider", 3, 1);
		 */
		
	}
}


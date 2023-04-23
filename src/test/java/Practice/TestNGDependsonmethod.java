package Practice;

import org.testng.annotations.Test;

public class TestNGDependsonmethod {
	@Test
	public void createContact()
	{
		int[] arr= {1,2,3};
		System.out.println(arr[5]);
		System.out.println("contact created");
	}
	
	@Test(dependsOnMethods = "createContact")
	public void modifyContact()
	{
		System.out.println("modified contact");
	}
	
	@Test(dependsOnMethods = "createContact")
	public void deleteContact()
	{
		System.out.println("deleted contact");
	}
}

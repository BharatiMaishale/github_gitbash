package Practice;

import org.testng.annotations.Test;

public class TestNGinvocation {
	@Test(invocationCount = 3)
	public void createContact()
	{
	
		System.out.println("contact created");
	}
	
	@Test
	public void modifyContact()
	{
		System.out.println("modified contact");
	}
	
	@Test
	public void deleteContact()
	{
		System.out.println("deleted contact");
	}

}

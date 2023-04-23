package Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Hardassert {
     /* @Test
 
	   public void createcontact()
	   {
		System.out.println("step1");
		System.out.println("step2");
		Assert.assertEquals(false, true);
		System.out.println("step3");
		System.out.println("step4");
	   }
 
       @Test
        public void deletecontat()
        {
      	System.out.println("step5");
   		System.out.println("step6");  
        }*/
	@Test
	public void m1()
	{
		String expdata = "Qspiders";
		String actdata = "jspiders";
		Assert.assertEquals(actdata, expdata);
	}
}

package Practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAsserttest {
	
    @Test
	public void createcontact()
	{
		System.out.println("step1");
		System.out.println("step2");
		System.out.println("step3");
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(false, true);
		System.out.println("step4");
		System.out.println("step5");
		soft.assertAll();
	}
    @Test
	public void m1()
	{
		String expdata = "Qspiders";
		String actdata = "Qspiders";
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(actdata, expdata);
		soft.assertAll();
	}
}


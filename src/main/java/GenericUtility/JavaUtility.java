package GenericUtility;

import java.util.Random;

public class JavaUtility {

	/**
	 * *This method is used to launch the application
	 * @param key
	 * @return
	 * @throws Throwable
	 * @author Bharati
	
	*/
	public int getRandomNum()
	{
		Random ran=new Random();
		int RanNum = ran.nextInt(1000);
		return RanNum;
		
	}
	
	
}

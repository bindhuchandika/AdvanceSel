package generic_utility;

import java.util.Random;

public class Java_Utility {
	/**
	 *This method is for avoding duplicates
	 * @return
	 * author bindhu
	 */
	public int getRandomNum(){

		Random ran = new Random();
		int randnum = ran.nextInt(1000);
		return randnum;
		
		
	}

}

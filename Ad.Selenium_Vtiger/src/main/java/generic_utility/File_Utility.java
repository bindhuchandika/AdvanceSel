package generic_utility;

import java.io.FileInputStream;
import java.util.Properties;

public class File_Utility {
/**
 * This method is used to read data from property file
 * @param key
 * @return
 * @throws Throwable
 * author bindhu
 */
	public String getKeyAndValue(String key) throws Throwable
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/commondata.properties");
		Properties p = new Properties();
		p.load(fis);
	    String value = p.getProperty(key);
		return value;
	}
}

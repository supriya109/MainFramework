package com.crm.GenericLibrary;

import java.io.FileInputStream;
import java.util.Properties;


	/**
	 * This will read data from property file and return value to user
	 * @author RELIANCE
	 *
	 */
	public class PropertyFileUtility {
		/**
		 * this ,method will read data from property file for key given by user
		 * @param key
		 * @return
		 * @throws Throwable
		 */
	public String readDataFromPropertyFile(String key) throws Throwable
	{
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties plib=new Properties();
		plib.load(fis);
		String value = plib.getProperty(key);
		return value;
	}
	}

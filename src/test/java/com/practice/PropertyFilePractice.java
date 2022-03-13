package com.practice;

import java.io.FileInputStream;
import java.util.Properties;

import org.testng.annotations.Test;

public class PropertyFilePractice {
	@Test
	public void propertyFile() throws Throwable
	{
		//step1:read file
		FileInputStream fis=new FileInputStream("./src/test/resources/CommonData.properties");
		
		//step2:create obj of Properties
		Properties pObj=new Properties();
		pObj.load(fis);
		
		//step3:read the Data
		String URL=pObj.getProperty("username");
		
		//verification
		System.out.println(URL);
	}
	}

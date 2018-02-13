package com.toysrus.automation.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class LocatorProps {
	

	static InputStream inputStream;

	public static String getProperty(String key)  {

		Properties properties = new Properties();
		
		if (ConfigProps.getProperty("env").equals("qa2")) {

			try {
				inputStream = new FileInputStream("qa2.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			try {
				inputStream = new FileInputStream("prod.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		
		// load a properties file
		try {
			properties.load(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return properties.getProperty(key);

	}

}
package com.toysrus.automation.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class LocatorProps {


	static InputStream inputStream;
	String key = null;

	public static String getProperty(String key)  {


		Properties properties = new Properties();

		String str = ConfigProps.getProperty(key);
		String[] splt = str.split("\\.");
		String  env = splt[0];
		String  site = splt[1];

		if (env.equalsIgnoreCase("prod")) {

			try {
				inputStream = new FileInputStream("prod.properties");
				key = key.concat("."+site);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			try {
				inputStream = new FileInputStream("qa2.properties");
				key = key.concat("."+site);
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
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


		String[] splt = key.split("\\.");
		String  env = splt[0];
		String  site = splt[1];

		if (env.equalsIgnoreCase("prod")) {

			try {
				inputStream = new FileInputStream("prod.properties");


			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		} else {
			try {
				inputStream = new FileInputStream("qa2.properties");

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}


		// load a properties file
		try {
			properties.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return properties.getProperty(site);
	}
}
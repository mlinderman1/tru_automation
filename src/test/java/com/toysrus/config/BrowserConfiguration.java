package com.toysrus.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import cucumber.api.java.After;

public class BrowserConfiguration {

	private final static String driverPath = System.getProperty("user.dir")
			+ "\\src\\test\\resources\\drivers\\";

	public static WebDriver driver = null;

	public static WebDriver openBrowser(String browserName) {

		if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", driverPath
					+ "geckodriver.exe");

			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", driverPath
					+ "chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("ie")) {

			System.setProperty("webdriver.ie.driver", driverPath
					+ "IEDriverServer.exe");
			driver = new InternetExplorerDriver();

		}
		 driver.manage().window().maximize();
		return driver;
	}

}

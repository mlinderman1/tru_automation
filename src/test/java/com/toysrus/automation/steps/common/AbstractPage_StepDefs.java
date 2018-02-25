package com.toysrus.automation.steps.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AbstractPage_StepDefs {
	
    protected static WebDriver driver;

    protected WebDriver getDriver() {
    	System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\Browsers\\geckodriver.exe");
        if (driver == null){ //instantiated driver for the first time
            driver = new FirefoxDriver();
            driver.manage().deleteAllCookies();
        }
        return driver;
    }

    protected WebDriver closeDriver() {
        if (driver != null){ //instantiated driver for the first time
            driver.quit();
        }
        return driver=null;
    }
    }

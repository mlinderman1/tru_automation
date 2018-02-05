package com.toysrus.automation.Steps.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AbstractPage_StepDefs {

    protected static WebDriver driver;

    protected WebDriver getDriver() {
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

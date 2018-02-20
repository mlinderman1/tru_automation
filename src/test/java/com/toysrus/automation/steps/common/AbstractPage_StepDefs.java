package com.toysrus.automation.steps.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class AbstractPage_StepDefs {

    protected static WebDriver driver;
    public Properties prop;
    public File file;
    private FileReader fileReader;

    protected WebDriver getDriver() {
        if (driver == null) { //instantiated driver for the first time

   //     FireFox headless support

            FirefoxBinary firefoxBinary = new FirefoxBinary();
            firefoxBinary.addCommandLineOptions("-headless");
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.setBinary(firefoxBinary);
            driver = new FirefoxDriver(firefoxOptions);

 //     chrome headless support
/*
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("headless");
            driver = new ChromeDriver(chromeOptions);
*/

            driver.manage().deleteAllCookies();
        }
        return driver;
    }

    protected WebDriver closeDriver() {
        if (driver != null) { //instantiated driver for the first time
            driver.quit();
        }
        return driver = null;
    }

    public void setUp() throws IOException {
        prop = new Properties();
        file = new File(System.getProperty("user.dir") + "/src/test/resources/config.properties");
        FileReader fileReader = new FileReader(file);
        prop.load(fileReader);

    }
}
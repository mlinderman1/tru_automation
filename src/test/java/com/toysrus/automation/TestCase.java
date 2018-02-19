package com.toysrus.automation;

import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.java.After;
import cucumber.api.junit.Cucumber;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import java.io.File;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/features/Webstore_AddToCart.feature"},
        glue="com.toysrus.automation.steps",
        		plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
        strict = false)

public class TestCase {
	
	@AfterClass
    public static void setup() {
        Reporter.loadXMLConfig(new File("/extent-config.xml"));
        Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
	    Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));

 }
}	
	
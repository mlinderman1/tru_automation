package com.toysrus.automation;

import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.java.After;
import cucumber.api.junit.Cucumber;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import java.io.File;

@RunWith(Cucumber.class)
@CucumberOptions(   features    = {"src/test/resources/features/"},
                    glue        ="com.toysrus.automation.steps",
					plugin = {"pretty","json:target/cucumber-reports/cucumber.json","com.cucumber.listener.ExtentCucumberFormatter:target/report.html"},
                    strict      = false)


public class TestCase {
	

}	
	
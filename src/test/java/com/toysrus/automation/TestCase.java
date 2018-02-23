package com.toysrus.automation;

/*import cucumber.api.CucumberOptions;
 import cucumber.api.junit.Cucumber;
 import org.junit.runner.RunWith;

 @RunWith(Cucumber.class)
 @CucumberOptions(features = { "src/test/resources/features/" }, glue = "com.toysrus.automation", tags = { "@MegaMenu" }, strict = false)
 public class TestCase {
 // glue = "com.toysrus.automation.steps"
 }*/

/*import org.junit.runner.RunWith;

 import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
 import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

 import cucumber.api.CucumberOptions;
 import cucumber.api.junit.Cucumber;

 @RunWith(Cucumber.class)
 @CucumberOptions(features = "classpath:features", format = {
 "json:target/cucumber.json", "html:target/cucumber-pretty" })
 public class RunCukesTest {

 }*/

import com.cucumber.listener.ExtentProperties;
import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.io.File;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/test/resources/features/" },strict=true,
plugin = { "com.cucumber.listener.ExtentCucumberFormatter:" })
public class TestCase {
	@BeforeClass
	public static void setup() {
		ExtentProperties extentProperties = ExtentProperties.INSTANCE;
		extentProperties.setProjectName("TRU_Auomation");
		extentProperties.setReportPath("output/myreport.html");
	}

	@AfterClass
	public static void teardown() {
		Reporter.loadXMLConfig(new File("src/test/resources/extent-config.xml"));
		Reporter.setSystemInfo("user", System.getProperty("user.name"));
		Reporter.setSystemInfo("os", System.getProperty("os.name"));
		Reporter.setTestRunnerOutput("TRU Regression Suite");
	}

}

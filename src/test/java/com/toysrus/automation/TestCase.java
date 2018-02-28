package com.toysrus.automation;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/features/"},
        tags = {"@registrant"},monochrome = true,
        glue="com.toysrus.automation.steps",
        strict = false)

public class TestCase {

}
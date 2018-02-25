package com.toysrus.automation;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/features/SSO__AWS__ATG__NewUser.feature/"},
        glue="com.toysrus.automation.steps",
        strict = false)

public class TestCase {

}
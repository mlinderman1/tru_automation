package com.toysrus.config;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/test/resources/features/parallel.feature" }, glue = "com.toysrus", tags = { "@ie" }, strict = false)
public class TestCase {
}

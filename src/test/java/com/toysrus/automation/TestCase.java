package com.toysrus.automation;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/features/"},
        glue="com.toysrus.automation.steps",
        strict = false)

public class TestCase {
//    public Properties prop;
//    public File file;
//    private FileReader fileReader;
//
//    public void readData() throws IOException {
//        prop = new Properties();
//        file = new File(System.getProperty("user.dir")+"src/test/resources/config.properties");
//        FileReader fileReader = new FileReader(file);
//        prop.load(fileReader);


//        InputStream input = TestCase.class.getClassLoader().getResourceAsStream("src/test/resources/config.properties");
//        prop.load(input);
//        System.out.println("XXXXXXXXXXXXXXX"+prop.getProperty("env"));
    }

package com.toysrus.automation.Steps.pages;

import com.toysrus.automation.Steps.common.AbstractPage_StepDefs;
import com.toysrus.automation.Steps.common.Common_StepDefs;
import com.toysrus.automation.Steps.overlays.Overlay__LightBox;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;

public class Page__HelpCenter extends AbstractPage_StepDefs {


    public class Selectors {

    }

    WebDriver driver = getDriver();
    WebDriverWait wait = new WebDriverWait(driver, 30);
    Selectors selector = new Selectors();


    @Before
    public void setUp() {
        getDriver();
        driver.manage().window().maximize();
    }

    @After
    public void breakDown() {
        closeDriver();
    }




}
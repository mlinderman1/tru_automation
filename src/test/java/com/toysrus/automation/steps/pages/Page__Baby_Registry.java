package com.toysrus.automation.steps.pages;

import com.toysrus.automation.steps.common.*;
import cucumber.api.java.en.When;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page__Baby_Registry extends AbstractPage_StepDefs {


    public class Selectors {
    	public static final String btn_registry_create = ".btn-bru hidden-xs";
    	public static final String  btn_registry_signin="#signinbtn";

    }

    WebDriver driver = getDriver();
    WebDriverWait wait = new WebDriverWait(driver, 15);
    Selectors selector = new Selectors();
    Common_StepDefs common = new Common_StepDefs();

    @When("^user clicks on create in babyregistry homepage$")
    public void user_clicks_on_create_in_babyregistry_homepage()  {
    	common.clickOn(Selectors.btn_registry_create);
    }


}

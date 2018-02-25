package com.toysrus.automation.steps.overlays;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.toysrus.automation.lib.RunTimeVariables;
import com.toysrus.automation.steps.common.AbstractPage_StepDefs;
import com.toysrus.automation.steps.common.Common_StepDefs;
import com.toysrus.automation.steps.overlays.Overlay__AddToCart.Selectors;

import cucumber.api.java.en.Then;

public class Overlay__SignIn extends AbstractPage_StepDefs {

    public class Selectors {
        public static final String overlay__signin_emailid = "#login";
        public static final String overlay__signin_password = "#sign-in-password-input";
        public static final String overlay__signin_button = "#signin-submit-btn";
    }

    WebDriver driver = getDriver();
    WebDriverWait wait = new WebDriverWait(driver, 15);
    Selectors selector = new Selectors();
    Common_StepDefs common = new Common_StepDefs();

    @Then("^user should sign in with same credentials$")
	public void user_should_sign_in_with_same_credentials()  {
		common.typeInto(Selectors.overlay__signin_emailid,RunTimeVariables.emailId );
		common.typeInto(Selectors.overlay__signin_password, RunTimeVariables.general_password);
		common.clickOn(Selectors.overlay__signin_button);
		
	}

    }

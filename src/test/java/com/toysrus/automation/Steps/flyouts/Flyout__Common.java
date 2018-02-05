package com.toysrus.automation.Steps.flyouts;

import com.toysrus.automation.Steps.common.AbstractPage_StepDefs;
import com.toysrus.automation.Steps.common.Common_StepDefs;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class Flyout__Common extends AbstractPage_StepDefs {

    public class Selectors {
        public static final String btn__flyout__close =".tru-modal-dialog__close-btn";
    }

    WebDriver driver = getDriver();
    Random rand = new Random();
    WebDriverWait wait = new WebDriverWait(driver, 20);
    Common_StepDefs common = new Common_StepDefs();
    int n;
    Selectors selector = new Selectors();

    @Then("^the user closes the flyout$")
    public void theUserClosesTheFlyout() throws Throwable {
        try{
            driver.findElement(By.cssSelector(selector.btn__flyout__close)).click();
        }
        catch(Exception e){
            System.out.println(e);
        }

    }
}




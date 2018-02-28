package com.toysrus.automation.steps.flyouts;

import com.toysrus.automation.steps.common.*;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class Flyout__Common extends AbstractPage_StepDefs {

    public static class Selectors {
        public static final String btn__flyout__close =".tru-modal-dialog__close-btn";
        public static final String side_panel__flyout =".tru-side-panel__content";
    }

    WebDriver driver = getDriver();
    Random rand = new Random();
    WebDriverWait wait = new WebDriverWait(driver, 20);
    Common_StepDefs common = new Common_StepDefs();
    int n;
    

    @Then("^the user closes the flyout$")
    public void theUserClosesTheFlyout() throws Throwable {
        try{
            driver.findElement(By.cssSelector(Selectors.btn__flyout__close)).click();
        }
        catch(Exception e){
            System.out.println(e);
        }

    }
    
    @And("^the user verifies the flyout has closed$")
    public void the_user_verifies_the_flyout_has_closed() throws Throwable {
    	try{

    		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(Selectors.side_panel__flyout)));

    	}
    	catch(Exception e){
    		System.out.println(e);
    	}

    }
}




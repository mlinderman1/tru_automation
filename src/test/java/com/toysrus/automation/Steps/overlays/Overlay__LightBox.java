package com.toysrus.automation.Steps.overlays;

import com.toysrus.automation.Steps.common.AbstractPage_StepDefs;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Overlay__LightBox extends AbstractPage_StepDefs {

    public class Selectors {
        public static final String btn__lightbox__close = ".truEventLightboxClose";  //Proposed new lightbox id after 10/28/17
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

    @When("^the user closes the lightbox$")
    public void theUserClosesTheLightbox() throws Throwable {
        try{
            WebElement btn__lightbox__close = driver.findElement(By.cssSelector(Selectors.btn__lightbox__close));
            if (btn__lightbox__close.isDisplayed())
            {
                btn__lightbox__close.click();
            }

        }
        catch(Exception e){
            return;
        }
    }

}

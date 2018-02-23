package com.toysrus.automation.steps.cart;

import com.toysrus.automation.steps.common.AbstractPage_StepDefs;
import com.toysrus.automation.steps.common.Common_StepDefs;
import com.toysrus.automation.steps.overlays.Overlay__LightBox;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Cart__Common extends AbstractPage_StepDefs {

    public class Selectors {
        public static final String container__page__cart = ".checkout-cart-page";
    }

    WebDriver driver = getDriver();
    WebDriverWait wait = new WebDriverWait(driver, 15);
    URL siteURL;
    Random rand = new Random();
    int n;
    Overlay__LightBox lightBox = new Overlay__LightBox();
    Selectors selector = new Selectors();

    @And("^the user is on the cart page$")
    public void theUserIsOnTheCartPage() throws Throwable {
        try{
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(selector.container__page__cart)));
        }
        catch(Exception e){
            System.out.println(e);
        }
        finally{
            try
            {
                lightBox.theUserClosesTheLightbox();
            }
            catch (Exception e) {
                System.out.println(e);
            }
        }
    }


}
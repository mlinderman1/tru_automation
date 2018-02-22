package com.toysrus.automation.steps.pdp;

import com.toysrus.automation.steps.common.*;
import com.toysrus.automation.steps.overlays.Overlay__LightBox;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PDP__Common extends AbstractPage_StepDefs {

    public class Selectors {
        public static final String container__page__pdp = ".pdp-page-container";
        public static final String link__pdp__ispu = ".product-ship-to-store__status-ispu a";
        public static final String page__footer = ".footer-group.footer-sitemap";
    }

    WebDriver driver = getDriver();
    WebDriverWait wait = new WebDriverWait(driver, 15);
    Selectors selector = new Selectors();
    Overlay__LightBox lightBox = new Overlay__LightBox();
    JavascriptExecutor je = (JavascriptExecutor) driver;

    @Given("^the user is on the PDP page$")
    public void theUserIsOnThePDPPage() throws Throwable {
        try{
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(selector.container__page__pdp)));
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

    @When("^the user verifies in PDP if item is gift-eligible$")
    public Boolean pdpVerifyGiftable() throws Throwable {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(selector.container__page__pdp)));
        WebElement pdpSection = driver.findElement(By.cssSelector(".pdp-details"));

        if (pdpSection.getText().toLowerCase().contains("gift wrap available")) {
            System.out.println("//////// GIFT WRAP ELIGIBLE");
            return true;
        } else {
            System.out.println("//////// GIFT WRAP NOT ELIGIBLE");
            return false;
        }
    }

    @And("^the user clicks 'Find in Store' link$")
    public void theUserClicksISPULink() throws Throwable {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(selector.link__pdp__ispu)));

        WebElement ispuLink = driver.findElement(By.cssSelector(selector.link__pdp__ispu));

        ispuLink.click();
    }
    
    @When("^the user scrolls down the page so sticky footer shows up$")
    public void the_user_scrolls_down_the_page_so_sticky_footer_shows_up() throws Throwable {
    	
    	WebElement pageFooter = driver.findElement(By.cssSelector(selector.page__footer));
    	je.executeScript("arguments[0].scrollIntoView(true);",pageFooter);
    	 	
       }


}

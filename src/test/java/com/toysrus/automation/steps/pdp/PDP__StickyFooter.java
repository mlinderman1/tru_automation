package com.toysrus.automation.steps.pdp;

import com.toysrus.automation.steps.common.*;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;




public class PDP__StickyFooter extends AbstractPage_StepDefs{
    public class Selectors {
        public static final String page__footer = ".footer-group.footer-sitemap";
        public static final String sticky__footer = ".pdp-sticky-footer";
        public static final String btn__add_to_cart__sticky_footer = ".pdp-cta-primary-button";
    }

    WebDriver driver = getDriver();
    WebDriverWait wait = new WebDriverWait(driver, 15);
    Selectors selector = new Selectors();
    JavascriptExecutor je = (JavascriptExecutor) driver;
    Common_StepDefs common = new Common_StepDefs();
    
    @When("^the user scrolls down the page so sticky footer shows up$")
    public void the_user_scrolls_down_the_page_so_sticky_footer_shows_up() throws Throwable {
    	
    	String cssSelector = selector.page__footer;
    	common.scrollToWebElement(cssSelector);
   	 	
       }
    
    @When("^the user adds PDP item to cart from sticky footer$")
    public void the_user_adds_PDP_item_to_cart_from_sticky_footer() throws Throwable {
    	WebElement stickyFooter = driver.findElement(By.cssSelector(selector.sticky__footer));
    	WebElement btn__add_to_cart__stickyFooter = stickyFooter.findElement(By.cssSelector(selector.btn__add_to_cart__sticky_footer));
    	wait.until(ExpectedConditions.elementToBeClickable(btn__add_to_cart__stickyFooter));
    	btn__add_to_cart__stickyFooter.click();

	}  

}
